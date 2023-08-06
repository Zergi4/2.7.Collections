package pro.sky.collections.skypro_collections.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmloyeeNotFoundException extends RuntimeException{
    public EmloyeeNotFoundException(String message) {
        super(message);
    }
}
