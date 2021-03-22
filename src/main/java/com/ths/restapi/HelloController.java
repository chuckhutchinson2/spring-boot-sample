package com.ths.restapi;

import com.ths.restapi.aspect.RestCall;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    static Logger log = LoggerFactory.getLogger(HelloController.class.getName());

    private HttpStatus status = HttpStatus.CONTINUE;

    public HttpStatus getNext() {
        return HttpStatus.values()[(status.ordinal()+1) % HttpStatus.values().length];
    }
    @RestCall
    @RequestMapping("/")
    public ResponseEntity<String> index() {
		log.debug("hello called");
        status = getNext();

        return new ResponseEntity<>( "hello world", status);
    }
}
