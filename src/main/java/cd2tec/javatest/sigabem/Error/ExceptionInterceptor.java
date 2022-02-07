package cd2tec.javatest.sigabem.Error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
@RestController
public class ExceptionInterceptor {
    @ExceptionHandler(CustomException.class)
    public final ResponseEntity<Object> handlerInterceptorGeneric(CustomException ex){
        Map<String, Object> res = new LinkedHashMap<>();
        res.put("error", ex.getMessage());
        res.put("status", ex.getStatus());
        res.put("statusName", HttpStatus.valueOf(ex.getStatus()));
        return new ResponseEntity<Object>(res, HttpStatus.valueOf(ex.getStatus()));
    }
}
