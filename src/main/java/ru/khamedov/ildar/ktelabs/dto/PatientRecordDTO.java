package ru.khamedov.ildar.ktelabs.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientRecordDTO {

    private String contact;

    private String code;

    private Long recordId;
}
