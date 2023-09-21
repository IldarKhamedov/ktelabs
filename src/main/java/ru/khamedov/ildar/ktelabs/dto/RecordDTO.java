package ru.khamedov.ildar.ktelabs.dto;



import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.util.Date;

@Getter
@Setter
public class RecordDTO {

    private Long id;

    private Date time;

    private Duration duration;
}
