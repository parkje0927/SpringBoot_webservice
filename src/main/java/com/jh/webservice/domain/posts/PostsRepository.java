package com.jh.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    /**
     * Repository
     * - DB Layer 접근자
     * - 단순히 인터페이스를 생성 후, JpaRepository<Entity 클래스, PK 타입> 를 상속하면 기본적인 CRUD 메소드가 자동생성 된다.
     * - 특별히 @Repository 를 추가할 필요도 없다.
     *
     * 주로,
     * 조회용 프레임워크로는 => querydsl
     * 등록/수정/삭제로는 => SpringDataJpa
     */

    //@Query 를 사용한 이유는, SpringDataJpa 에서 제공하지 않는 메소드는 쿼리로 작성해도 되는 것을 보여주기 위함.
    @Query("select p from Posts p " + "order by p.id desc")
    Stream<Posts> findAllDesc();
}
