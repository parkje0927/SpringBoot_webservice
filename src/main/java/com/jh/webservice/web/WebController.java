package com.jh.webservice.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {

    /**
     * handlebars-spring-boot-starter
     * controller 에서 문자열을 반환할 때 앞의 path 와 뒤의 파일 확장자는 자동으로 지정된다.
     * 즉, "main" 을 반환하면 src/main/resources/templates/main.hbs 로 전환되어 View Resolver 가 처리하게 된다.
     */
    @GetMapping("/")
    public String main() {
        return "main";
    }
}
