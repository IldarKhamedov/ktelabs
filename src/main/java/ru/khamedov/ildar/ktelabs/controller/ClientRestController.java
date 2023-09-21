package ru.khamedov.ildar.ktelabs.controller;

import jakarta.annotation.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.khamedov.ildar.ktelabs.dto.RecordDTO;
import ru.khamedov.ildar.ktelabs.service.RecordService;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/common")
public class ClientRestController {

    @Resource
    private RecordService recordService;

    @GetMapping("/client/records/free/{doctorId}/{date}")
    public ResponseEntity getFreeRecords(@PathVariable(required = true)Long doctorId,
                                         @PathVariable(required = true) @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) String date){
        List<RecordDTO> recordDTOList=recordService.getRecordDTOList(doctorId, Date.valueOf(date));
        return new ResponseEntity(recordDTOList, HttpStatus.OK);

    }
}
