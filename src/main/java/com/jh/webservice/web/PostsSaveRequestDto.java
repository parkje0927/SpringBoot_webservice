package com.jh.webservice.web;

import com.jh.webservice.domain.posts.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostsSaveRequestDto {

    /**
     * @Setter 사용하지 말라고 했는데 왜 여기서는 사용?
     * - WebRestController 와 같은 Controller 에서 @RequestBody 로 외부에서 데이터를 받는 경우엔,
     * - 기본 생성자 + set 메소드를 통해서만 값이 할당된다.
     * - 그래서 이때만 Setter 를 허용한다.
     *
     * 그리고 Entity 클래스와 거의 유사한 형태임에도 DTO 클래스를 추가로 생성
     * 절대로 테이블과 매핑되는 Entity 클래스를 Request / Response 클래스로 사용해서는 안된다.
     * Entity 클래스는 가장 core 한 클래스라고 봐야 하는데,
     * 수많은 서비스 클래스나 비즈니스 로직들이 Entity 클래스를 기준으로 동작한다.
     * Entity 클래스가 변경되면 여러 클래스에 영향을 끼치게 되는 반면,
     * Request 와 Response 용 DTO 는 view 를 위한 클래스라 정말 자주 변경이 필요하다.
     *
     * view Layer 와 DB Layer 를 철저하게 역할 분리를 하는 게 좋다.
     * 꼭! Entity 클래스와 Controller 에서 쓸 DTO 는 분리해서 사용하라!
     */

    private String title;
    private String content;
    private String author;

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }


}
