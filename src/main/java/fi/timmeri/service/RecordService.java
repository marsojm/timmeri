package fi.timmeri.service;

import fi.timmeri.entities.Record;
import fi.timmeri.repositories.RecordRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordService {
    private static final Logger log = LoggerFactory.getLogger(RecordService.class);

    @Autowired
    private RecordRepository recordRepository;

    public Record getRecordById(long id) throws Exception {
        return recordRepository.getRecordById(id);
    }
}
