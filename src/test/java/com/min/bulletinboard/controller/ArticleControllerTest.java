package com.min.bulletinboard.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @WebMvcTest
 * - JPA 기능은 동작하지 않는다.
 * - 여러 스프링 테스트 어노테이션 중,  Web(Spring MVC) 에만 집중할 수 있는 어노테이션
 * - @Controller, @ControllerAdvice 사용 가능
 * - 단, @Service, @Repository 등은 사용할 수 없다.
 */
@DisplayName("View 컨트롤러 - 게시글")
@WebMvcTest(ArticleController.class)
class ArticleControllerTest {

    /**
     * 웹 API 테스트할 때 사용
     * 스프링 MVC 테스트의 시작점
     * HTTP GET, POST 등에 대해 API 테스트 가능
     */
    private final MockMvc mvc;

    // test 패키지에 있는 것들은 @Autowired 를 생략할 수 없다.  따라서, 직접 명시 해줘야 함.
    public ArticleControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[view] [GET] 게시글 (게시판) 페이지 - 정상 호출")  // /articles
    @Test
    public void givenNothing_whenRequestingArticlesView_thenReturnsArticlesView() throws Exception {
        // Given


        // When & Then
        mvc.perform(get("/articles"))    // MockMvc 를 통해 /articles 주소로 GET 요청
                                                    // mvc.perform() 의 결과를 검증
                .andExpect(status().isOk())         // 200 상태
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))  // content 내용의 타입이 무엇인가?  // view니까 TEXT_HTML
                                                                                    //contentTypeCompatibleWith : 호환되는 타입까지 맞다고 쳐준다.
                .andExpect(view().name("articles/index"))   // 뷰에 이름에 대한 테스도 조건에 추가할 수 있다.
                .andExpect(model().attributeExists("articles"));    // 뷰는 데이터가 있어야 함. // model에 attribute가 있는지 체크
                                                                        // model 애트리뷰트라는 map "articles" 라는 이름에 데이터가 있는지 검사
    }

    @DisplayName("[view] [GET] 게시글 상세 페이지 - 정상 호출") //  /articles/{article-id}
    @Test
    public void givenNothing_whenRequestingArticleView_thenReturnsArticleView() throws Exception {
        // Given


        // When & Then
        mvc.perform(get("/articles/1"))    // MockMvc 를 통해 /articles 주소로 GET 요청
                // mvc.perform() 의 결과를 검증
                .andExpect(status().isOk())         // 200 상태
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))  // content 내용의 타입이 무엇인가?  // view니까 TEXT_HTML
                .andExpect(view().name("articles/detail"))
                 .andExpect(model().attributeExists("article"))    // 뷰는 데이터가 있어야 함. // model에 attribute가 있는지 체크
                .andExpect(model().attributeExists("articleComments"));
        // model 애트리뷰트라는 map "articles" 라는 이름에 데이터가 있는지 검사
    }

    @Disabled("구현 중")
    @DisplayName("[view] [GET] 게시글 검색 전용 페이지 - 정상 호출")  //  /articles/search
    @Test
    public void givenNothing_whenRequestingArticleSearchView_thenReturnsArticleSearchView() throws Exception {
        // Given


        // When & Then
        mvc.perform(get("/articles/search"))    // MockMvc 를 통해 /articles 주소로 GET 요청
                // mvc.perform() 의 결과를 검증
                .andExpect(status().isOk())         // 200 상태
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))  // content 내용의 타입이 무엇인가?  // view니까 TEXT_HTML
                .andExpect(model().attributeExists("articles/search"));
    }

    @Disabled("구현 중")
    @DisplayName("[view] [GET] 게시글 해시태그 검색 페이지 - 정상 호출")  // /articles/search-hashtag
    @Test
    public void givenNothing_whenRequestingArticleHashtagSearchView_thenReturnsArticleHashtagSearchView() throws Exception {
        // Given


        // When & Then
        mvc.perform(get("/articles/search-hashtag"))    // MockMvc 를 통해 /articles 주소로 GET 요청
                // mvc.perform() 의 결과를 검증
                .andExpect(status().isOk())         // 200 상태
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))  // content 내용의 타입이 무엇인가?  // view니까 TEXT_HTML
                .andExpect(model().attributeExists("articles/search-hashtag"));
    }
}
