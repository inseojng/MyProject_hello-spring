package com.inseo.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody  //http에서 응답 body부에 데이터를 직접 넣어주겠다는 의미
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; //return이 view 가지않고 문자열이 그대로 내려간다
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    //클래스 내부에 static으로 class를 만들면 클래스안에서 해당 클래스를 사용할 수 있다. HelloController.Hello 자바에서 정식으로 지원하는 문법
    static class Hello{
        private String name;

        public String getName() {
            return name;
        }
        public void setName(String n) {
            this.name = n;
        }
    }
}
