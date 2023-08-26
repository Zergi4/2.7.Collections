package pro.sky.collections.skypro_collections.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class EmloyeeNotFoundException extends HttpStatusCodeException {

    public EmloyeeNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}