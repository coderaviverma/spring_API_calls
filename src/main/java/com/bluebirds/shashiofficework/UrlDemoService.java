package com.bluebirds.shashiofficework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class UrlDemoService {

    @Autowired
    public UrlDemoService(RestTemplate restTemplate) {
        this.restTemplate=restTemplate;
    }

    private  RestTemplate restTemplate;

    public  void getEmployees() {
//        RestTemplate restTemplate=new RestTemplate();

        final String uri = "http://localhost:8080/springrestexample/employees";


        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

        if (result.getStatusCode() == HttpStatus.OK) {

        }

        System.out.println(result);
    }

    public  void postEmployees() {
//        RestTemplate restTemplate=new RestTemplate();

        final String uri = "http://localhost:8080/employees";

        EmployeeVO employeeVO =new EmployeeVO("Avi","verma","coderaviverma@gmail.com");

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);


//        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
        EmployeeVO result = restTemplate.postForObject(uri, employeeVO, EmployeeVO.class);

        if (result !=null) {

        }

        System.out.println(result);
    }


    public  void postTest() {
//        RestTemplate restTemplate=new RestTemplate();
        final String uri = "http://localhost:8080/test";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
//        String result = restTemplate.postForObject(uri, entity, String.class);

        System.out.println(result);
    }
}
