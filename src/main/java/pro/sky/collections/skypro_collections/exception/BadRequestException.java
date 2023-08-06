package pro.sky.collections.skypro_collections.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.HttpStatusCodeException;

public class BadRequestException extends HttpStatusCodeException {


    public BadRequestException( String message) {
        super(HttpStatus.BAD_REQUEST, message);    }
}
