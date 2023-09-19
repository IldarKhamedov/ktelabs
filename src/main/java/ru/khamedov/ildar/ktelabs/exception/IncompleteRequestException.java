package ru.khamedov.ildar.ktelabs.exception;

/**
 * Исключение, если для создания записи передали не все входные данные.
 */
public class IncompleteRequestException extends RuntimeException{

    public IncompleteRequestException( String message) {
        super(message);
    }
}
