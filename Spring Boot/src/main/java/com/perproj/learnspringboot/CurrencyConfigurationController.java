package com.perproj.learnspringboot;

////http://localhost:8080/courses
//[
//        {
//            "id": 1,
//        "name": "Learn AWS",
//        "author": "Jack"
//        }
//        ]

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConfigurationController {

    @Autowired
    private CurrencyServiceConfiguration configuration;
    @GetMapping("/currency-configuration")
    public CurrencyServiceConfiguration retrieveAllCurrencies(){
        return configuration;
    }
}
