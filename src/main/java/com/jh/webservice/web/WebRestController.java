package com.jh.webservice.web;

import com.jh.webservice.dto.PostsSaveRequestDto;
import com.jh.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {

    /**
     * @AllArgsConstructor 를 통해 생성자 생성 -> Bean 주입
     *
     * postsRepository.save(dto.toEntity()) -> postsService.save(dto) 로 교체
     */

    private PostsService postsService;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
        return postsService.save(dto);
    }
}
