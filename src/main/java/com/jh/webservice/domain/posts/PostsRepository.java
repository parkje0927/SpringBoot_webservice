package com.jh.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    /**
     * Repository
     * - DB Layer 접근자
     * - 단순히 인터페이스를 생성 후, JpaRepository<Entity 클래스, PK 타입> 를 상속하면 기본적인 CRUD 메소드가 자동생성 된다.
     * - 특별히 @Repository 를 추가할 필요도 없다.
     */
}
