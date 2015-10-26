package fi.timmeri.repositories;

import fi.timmeri.entities.Record;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RecordRepository {
    private static final Logger log = LoggerFactory.getLogger(RecordRepository.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Record getRecordById(long id) throws Exception {
        log.info("Creating tables");
        jdbcTemplate.execute("DROP TABLE records IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE records(" +
                "id SERIAL, content VARCHAR(255))");

        List<Object[]> records = Arrays.asList("Content1", "Content2", "Content3")
                .stream()
                .map(a -> new Object[]{a})
                .collect(Collectors.toList());

        jdbcTemplate.batchUpdate("INSERT INTO records(content) VALUES (?)", records);

        List<Record> r = jdbcTemplate.query("SELECT id, content FROM records WHERE id = ?", new Object[] {id},
                (rs, rowNum) -> recordMapper(rs));

        return r.get(0);
    }

    private Record recordMapper(ResultSet rs) throws SQLException {
        return new Record(rs.getLong("id"), rs.getString("content"));
    }


}
