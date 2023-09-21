package ru.khamedov.ildar.ktelabs.controller;

import jakarta.annotation.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ru.khamedov.ildar.ktelabs.dto.PatientRecordDTO;
import ru.khamedov.ildar.ktelabs.dto.RecordDTO;
import ru.khamedov.ildar.ktelabs.service.PatientService;
import ru.khamedov.ildar.ktelabs.service.RecordService;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/common")
public class ClientRestController {

    @Resource
    private RecordService recordService;

    @Resource
    private PatientService patientService;

    @GetMapping("/client/records/free/{doctorId}/{date}")
    public ResponseEntity getFreeRecords(@PathVariable(required = true)Long doctorId,
                                         @PathVariable(required = true) String date){
        List<RecordDTO> recordDTOList=recordService.getRecordDTOList(doctorId, Date.valueOf(date));
        return new ResponseEntity(recordDTOList, HttpStatus.OK);
    }

    @PostMapping("/client/record/fill")
    public ResponseEntity fillRecord(@RequestBody PatientRecordDTO fillRecordDTO){
        return new ResponseEntity(recordService.fillRecord(fillRecordDTO),HttpStatus.OK);
    }

}
