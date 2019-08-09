package com.toyota.usedcardocker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {

    @GetMapping
    public String getGreeting(){
        return "Hello there, general Kenobi.";
    }

}
