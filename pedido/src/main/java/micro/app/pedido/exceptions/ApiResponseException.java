package micro.app.pedido.exceptions;

import org.springframework.http.HttpStatus;

public class ApiResponseException extends RuntimeException{

    private final HttpStatus httpStatus;

    /** Constructor */
    public ApiResponseException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public static ApiResponseException of(final String message, final HttpStatus httpStatus){
        return new ApiResponseException(message, httpStatus);
    }
}
