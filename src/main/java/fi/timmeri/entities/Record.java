package fi.timmeri.entities;

public class Record {
    private final long id;
    private String content;

    public Record(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
