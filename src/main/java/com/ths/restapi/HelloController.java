package com.ths.restapi;

import com.ths.restapi.aspect.RestCall;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

@RestController
public class HelloController {

    private HttpStatus status = HttpStatus.CONTINUE;

    public HttpStatus getNext() {
        return HttpStatus.values()[(status.ordinal()+1) % HttpStatus.values().length];
    }
    @RestCall
    @RequestMapping("/")
    public String index() {
		System.out.println("hello called");
        status = getNext();

        if (status != HttpStatus.OK) {
            throw new HttpServerErrorException(status);
        }

        return "Hello world";
    }
  
}
