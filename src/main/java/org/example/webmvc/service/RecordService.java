package org.example.webmvc.service;

import org.example.webmvc.dao.RecordDao;
import org.example.webmvc.dto.RecordContainerDto;
import org.example.webmvc.entity.Record;
import org.example.webmvc.entity.RecordStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class RecordService {
    private final RecordDao recordDao;

    @Autowired
    public RecordService(RecordDao recordDao) {
        this.recordDao = recordDao;
    }

    public RecordContainerDto findAllRecords(String filterMode) {
        var records = recordDao.findAllRecords();
        var countActiveRecord = (int) records.stream().filter(record -> record.getStatus() == RecordStatus.ACTIVE).count();
        var countNotActiveRecord = (int) records.stream().filter(record -> record.getStatus() == RecordStatus.DONE).count();
        if (filterMode == null || filterMode.isBlank())
            return new RecordContainerDto(records, countActiveRecord, countNotActiveRecord);

        var enumValues = Arrays.stream(RecordStatus.values())
                .map(Enum::name)
                .toList();

        var filterUpperCase = filterMode.toUpperCase();
        if (enumValues.contains(filterUpperCase)) {
            var filterRecords = records.stream()
                    .filter(record -> record.getStatus() == RecordStatus.valueOf(filterUpperCase))
                    .collect(Collectors.toList());
            return new RecordContainerDto(filterRecords, countActiveRecord, countNotActiveRecord);
        } else
            return new RecordContainerDto(records, countActiveRecord, countNotActiveRecord);
    }

    public void saveRecord(String title) {
        if (title != null && !title.isBlank())
            recordDao.saveRecord(new Record(title));

    }

    public void updateRecordStatus(int id, RecordStatus newStatus) {
        recordDao.updateRecord(id, newStatus);
    }

    public void deleteRecord(int id) {
        recordDao.deleteRecord(id);
    }
}
