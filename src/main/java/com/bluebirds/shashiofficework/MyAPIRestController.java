package com.bluebirds.shashiofficework;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyAPIRestController {

    @Autowired
    UrlCallUsingRestTemplateService service;

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeVO employee) {
        System.out.println(employee);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public ResponseEntity<String> createEmployee() {
        System.out.println("Test Post Method Executed");
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public ResponseEntity<String> test1() {
        System.out.println("Test Post Method Executed");
        service.postTest();

        return new ResponseEntity(HttpStatus.CREATED);
    }

}


