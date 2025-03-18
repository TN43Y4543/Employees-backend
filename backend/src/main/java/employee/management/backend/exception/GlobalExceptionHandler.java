package employee.management.backend.exception;


import employee.management.backend.entity.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorModel> ResourceNotFoundException(ResourceNotFoundException resourceNotFoundException)
    {
        ErrorModel errorModel=ErrorModel.builder().errCode("err-001").errorMessage(resourceNotFoundException.getMessage()).build();
        return new ResponseEntity<>(errorModel, HttpStatus.BAD_REQUEST);
    }

}
