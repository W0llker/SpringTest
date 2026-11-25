package org.example.webmvc.dto;

import java.util.List;
import org.example.webmvc.entity.Record;

public class RecordContainerDto {
    private final List<Record> records;
    private final int countActiveRecords;
    private final int countNotActiveRecords;

    public RecordContainerDto(List<Record> records, int countActiveRecords, int countNotActiveRecords) {
        this.countActiveRecords = countActiveRecords;
        this.records = records;
        this.countNotActiveRecords = countNotActiveRecords;
    }

    public int getCountActiveRecords() {
        return countActiveRecords;
    }

    public int getCountNotActiveRecords() {
        return countNotActiveRecords;
    }

    public List<Record> getRecords() {
        return records;
    }
}
