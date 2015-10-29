package fi.timmeri.contollers;

import fi.timmeri.dtos.response.RecordDto;
import fi.timmeri.entities.Record;
import fi.timmeri.service.RecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/")
@RestController
public class RecordController {
    private static final Logger log = LoggerFactory.getLogger(RecordController.class);

    @Autowired
    private RecordService recordService;

    @RequestMapping(method = RequestMethod.GET, value = "v1/records/{id}")
    public RecordDto getRecordById(@PathVariable long id) {
        Record record = null;
        try {
            record = recordService.getRecordById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new RecordDto(record.getId(), record.getContent());
    }
}
