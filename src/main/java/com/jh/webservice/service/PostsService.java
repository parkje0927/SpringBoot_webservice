package com.jh.webservice.service;

import com.jh.webservice.domain.posts.PostsRepository;
import com.jh.webservice.web.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class PostsService {

    /**
     * Controller 에서 Dto.toEntity 를 통해서 바로 전달해도 되는데 굳이 Service 에서 Dto 를 받는 이유는 간단하다.
     * Controller 와 Service 의 역할을 분리하기 위함이다.
     * 비즈니스 로직 & 트랜잭션 관리는 모두 Service 에서 관리하고, View 와 연동되는 부분은 Controller 에서 담당하도록 구성한다.
     *
     * Tip) 트랜잭션?
     * 일반적으로 DB 데이터를 등록, 수정, 삭제하는 Service 메소드는 @Transactional 를 필수적으로 가져간다.
     * 이 어노테이션이 하는 일은, 메소드 내에서 Exception 이 발생하면 해당 메소드에서 이루어진 모든 DB 작업을 초기화 시킨다.
     * 즉, save 메소드를 통해서 10개를 등록해야하는데 5번째에서 Exception 이 발생하면 앞에 저장된 4개까지를 전부 롤백시켜버린다.
     * 정확히 이야기하면, 이미 넣은걸 롤백시키는 건 아니며, 모든 처리가 정상적으로 됐을때만 DB 에 커밋하며 그렇지 않은 경우엔 커밋하지 않는 것이다.
     */

    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto) {
        return postsRepository.save(dto.toEntity()).getId();
    }
}
