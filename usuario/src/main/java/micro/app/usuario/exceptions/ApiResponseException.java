package micro.app.usuario.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiResponseException extends RuntimeException {

    private final HttpStatus httpStatus;

    /** Constructor */
    public ApiResponseException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public static ApiResponseException getException(final String message, final HttpStatus httpStatus){
        return new ApiResponseException(message, httpStatus);
    }
}
