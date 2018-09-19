package controller;

import com.google.gson.Gson;
import model.validation.exception.MessagePayload;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String genererErreurMethodeArgumentNotValidException (MethodArgumentNotValidException ex) {
        MessagePayload messagePayload = new MessagePayload();

        for (ObjectError objerreur : ex.getBindingResult().getAllErrors()) {
            String[] erruer = objerreur.getDefaultMessage().split(":");

            messagePayload.setCode(erruer[0]);
            messagePayload.setMessage(erruer[1]);
        }

        return new Gson().toJson(messagePayload);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String genererErreurException (MethodArgumentNotValidException ex) {
        MessagePayload messagePayload = new MessagePayload();

        messagePayload.setCode(null);
        messagePayload.setMessage(ex.getMessage());

        return new Gson().toJson(messagePayload);
    }

}
