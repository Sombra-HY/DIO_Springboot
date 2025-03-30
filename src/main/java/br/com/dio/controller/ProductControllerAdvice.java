package br.com.dio.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ProductControllerAdvice extends ResponseEntityExceptionHandler {

    @Exception(ProductEmpentyExceotion.class)
    public ResponseEntity<Object> GetErrorNull(){
        Map<String,Object> body = new HashMap<String,Object>();
        body.put("message","Verifique os campos do produto");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

}
