package employee.management.backend.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String msg)
    {
        super(msg);
    }

}
