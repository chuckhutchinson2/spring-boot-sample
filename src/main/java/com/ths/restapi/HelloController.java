package com.ths.restapi;

import com.ths.restapi.aspect.RestCall;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private HttpStatus status = HttpStatus.CONTINUE;

    public HttpStatus getNext() {
        return HttpStatus.values()[(status.ordinal()+1) % HttpStatus.values().length];
    }
    @RestCall
    @RequestMapping("/")
    public ResponseEntity<String> index() {
		System.out.println("hello called");
        status = getNext();

        return new ResponseEntity<>( "hello world", status);
    }
}
