package com.example.SpringBootProject.web;

import com.example.SpringBootProject.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // json을 반환하는 controller로 만들어줌
public class HelloController {
    @GetMapping("/hello")   //HTTP Method인 Get 요청을 받을 수 있는 API를 만들어줌
    public String hello() {
        return "hello";     // /hello 로 요청오면 문자열 hello 반환
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }

}
