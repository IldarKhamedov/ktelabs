package ru.khamedov.ildar.ktelabs.exception;

/**
 * Исключение, если запись на выбранную дату и время существует.
 */
public class ExistsRecordException extends RuntimeException{

    public ExistsRecordException(String message) {
        super(message);
    }
}
