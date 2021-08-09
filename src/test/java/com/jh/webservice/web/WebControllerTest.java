package com.jh.webservice.web;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void 메인페이지_로딩() {

        /**
         * 실제로 url 호출시 제대로 페이지가 호출되는지에 대한 테스트
         * html 도 결국은 규칙이 있는 문자열
         * TestRestTemplate 을 통해 "/" 로 호출했을 때, main.hbs 에 포함된 코드들이 있는지 확인하면 됨.
         */

        //given

        //when
        String body = this.restTemplate.getForObject("/", String.class);

        //then
        System.out.println("body = " + body);
//        assertThat(body).contains("스프링부트로 시작하는 웹 서비스");
    }
}