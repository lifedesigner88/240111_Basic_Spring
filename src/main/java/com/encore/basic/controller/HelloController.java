package com.encore.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// 모든 요청에 ResponseBody를 붙이고 싶다면, RestController 사용
@Controller
// 클래스 차원에서 url 경로를 지정하고 싶다면 @RequestMapping을 클래스 위에 선언하면서 경로 지정.
@RequestMapping("hello")
public class HelloController {

//    responseBody가 없고,
//    return 타입이 String 이면 template 밑에 html 파일 리턴

    @GetMapping("string")
    @ResponseBody
    public String helloString(){return "hello_string";}


    @GetMapping("json")
    @ResponseBody
    public String helloJson(){return "hello_string";}


    @GetMapping("screen")
    public String helloScreen(){return "screen";}


    @GetMapping("screen-model-param")
//        screen-model?name=sejong (파라미터 호출방식)
    public String helloScreenModel(@RequestParam(value = "name") String inputName, Model model) {
//        화면에 data를 넘기고 싶을 때는 model 객체 사용
//        model에 key:value 형식으로 전달.
        model.addAttribute("myData", inputName);
        return "screen";
    }

//    pathvariable 방식은 url을 통해 자원의 구조를 명확하게 표현할 수 있다.
//    좀 더 RestFul API 디자인에 적합.
    @GetMapping("screen-model-path/{id}")   // 숫자 형태로 받음. (int)
    public String helloScreenModelPath(@PathVariable int id, Model model) {
        model.addAttribute("myData", id);
        return "screen";
    }



}
