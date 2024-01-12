package com.encore.basic.controller;

import Print.Print;
import com.encore.basic.domain.Hello;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

// 모든 요청에 ResponseBody를 붙이고 싶다면, RestController 사용
@Controller
// 클래스 차원에서 url 경로를 지정하고 싶다면 @RequestMapping을 클래스 위에 선언하면서 경로 지정.
@RequestMapping("hello")
public class HelloController extends Print {

//    responseBody가 없고,
//    return 타입이 String 이면 template 밑에 html 파일 리턴

    //    @GetMapping("string")
    @RequestMapping(value = "string", method = RequestMethod.GET)
    @ResponseBody
    public String helloString() {
        return "hello_string";
    }


//    Request 처리
//    1-1) Paramiter
//    1-2) path valuable 방식

//    Respon 처리
//    Json
//    X-www 데이터 처리


    @GetMapping("json")
    @ResponseBody
    public Hello helloJson() {
        Hello hello = new Hello();
        hello.setName("세종");
        hello.setEmail("segjon@naver.com");
        hello.setPassword("1234");
        return hello;
    }


    @GetMapping("screen")
    public String helloScreen() {
        return "screen";
    }


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


//    From 태그로 x-www 데이터 처리
    @GetMapping("form-screen")
    public String helloFormScreen() {
        return "hello-form-screen";
    }



    @PostMapping("form-post-handle")
    @ResponseBody
    public String handleFormPost(@RequestParam("name") String name,
                                 @RequestParam("email") String email,
                                 @RequestParam("password") String password) {
        print(name);
        print(email);
        print(password);
        return "정상처리";
    }


//    json 데이터 처리
    @GetMapping("json-screen")
    public String jsonScrean(){
        return "hello-json-screen";
    }


    @PostMapping("json-post-handle")
    @ResponseBody
//    RequestBody는 json으로 포스트 요청이 왔을 때 body에서 data를 꺼내기 위해 사용
    public String jsonPostHandle1(@RequestBody Map<String, String> body){

        print(body.get("name"));
        print(body.get("email"));
        print(body.get("password"));
        return "정상처리";
    }

//    JSON 데이터 받는 방법
//      MAP<String, String>
//      JsonNode
//      객체로 바로 변환

}






































































