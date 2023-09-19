package ru.khamedov.ildar.ktelabs.endpoint;


import https.ktelabs.web_service.shedule.rules.CreateRecordRequest;
import https.ktelabs.web_service.shedule.rules.CreateRecordResponse;
import jakarta.annotation.Resource;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.khamedov.ildar.ktelabs.repository.ServiceRepository;
import ru.khamedov.ildar.ktelabs.service.RecordService;
import ru.khamedov.ildar.ktelabs.util.Constant;

import java.text.ParseException;
import java.time.Duration;

@Endpoint
public class ServicePoint {

    @Resource
    private ServiceRepository serviceRepository;

    @Resource
    private RecordService recordService;

    private static final String LOCAL_PART = "createRecordRequest";

    @PayloadRoot(namespace = Constant.NAMESPACE_URI, localPart = LOCAL_PART)
    @ResponsePayload
    public CreateRecordResponse createRecord(@RequestPayload CreateRecordRequest recordRequest) throws ParseException {
        if (!recordService.checkRequest(recordRequest)) {
            recordService.emptyRequestError(recordRequest);
        }
        CreateRecordResponse recordResponse = new CreateRecordResponse();
        boolean check = recordService.createSlots(
                recordRequest.getDate().toGregorianCalendar().getTime(),
                recordRequest.getStartTime().toGregorianCalendar().getTime(),
                Duration.parse(recordRequest.getDuration().toString()),
                recordRequest.getCount());
        recordResponse.setConfirmation(check);
        return recordResponse;
    }
}