package fi.timmeri.dtos.response;

public class RecordDto {
    private final long id;
    private final String content;

    public RecordDto(long id, String content) {
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
