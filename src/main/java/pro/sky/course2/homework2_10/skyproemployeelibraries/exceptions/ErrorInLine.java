package pro.sky.course2.homework2_10.skyproemployeelibraries.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class ErrorInLine extends RuntimeException {
    private static final String DEFAULT_MESSAGE = " Запрещенные символы в строке ";

    public ErrorInLine() {
        super(DEFAULT_MESSAGE);
    }
}
