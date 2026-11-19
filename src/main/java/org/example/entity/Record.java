package org.example.entity;

public class Record {
    private static int counterSequence = 0;
    public final int id;
    public final String title;
    public RecordStatus status;

    public Record(String title, RecordStatus status) {
        this.title = title;
        this.status = status;
        this.id = counterSequence++;
    }

    public Record(String title) {
        this.title = title;
        this.status = RecordStatus.ACTIVE;
        this.id = counterSequence++;
    }

    public RecordStatus getStatus() {
        return status;
    }

    public void setStatus(RecordStatus status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }
}
