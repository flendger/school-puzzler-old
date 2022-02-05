package ru.flendger.school.puzzler.web.message;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
@Builder
public class ResponseMessage {
    private String message;
    private HttpStatus status;

    public static ResponseEntity<ResponseMessage> createResponse(String message, HttpStatus status) {
        ResponseMessage responseMessage = ResponseMessage
                .builder()
                .message(message)
                .status(status)
                .build();

        return new ResponseEntity<>(responseMessage, status);
    }
}
