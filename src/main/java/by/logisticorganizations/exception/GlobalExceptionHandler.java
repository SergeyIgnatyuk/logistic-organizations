package by.logisticorganizations.exception;

import by.logisticorganizations.dto.ErrorDto;
import by.logisticorganizations.dto.SubErrorDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String userMessage = "Некорректный формат JSON в запросе";
        ErrorDto error = new ErrorDto(HttpStatus.resolve(status.value()), status.value(), userMessage, Instant.now(), request.getContextPath(), null);
        return buildResponseEntity(error);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String userMessage = "Validation failed";

        Set<SubErrorDto> subErrors = ex.getBindingResult().getFieldErrors().stream()
                .map(f -> new SubErrorDto(f.getObjectName(), f.getField(),
                        f.getRejectedValue(), f.getDefaultMessage()))
                .collect(Collectors.toSet());

        ErrorDto error = new ErrorDto(HttpStatus.resolve(status.value()), status.value(), userMessage, Instant.now(),  request.getContextPath(), subErrors);

        return buildResponseEntity(error);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleNotFoundException(NoSuchElementException ex, HttpServletRequest request) {
        ErrorDto error = new ErrorDto(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(), ex.getMessage(), Instant.now(),  request.getRequestURI(), null);
        return buildResponseEntity(error);
    }

    private ResponseEntity<Object> buildResponseEntity(ErrorDto error) {
        return ResponseEntity.status(error.getStatus()).body(error);
    }
}
