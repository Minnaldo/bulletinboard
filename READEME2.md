# 필요한 기술 정리하기

## 필요 세부 기술 목록 뽑는 방법

- 미리 사용 기술을 모두 파악한 후, 처음부터 프로젝트에 넣는 방법.
- 기능 하나를 만들 때마다, 필요한 기술을 추가해 나가는 방법 -> 사용할 방법.

## 예상하는 세부 기능들

- 게시판, 댓글 도메인의 설계
- 도메인 데이터를 DB에 저장
- JSON API 로 데이터 제공
- 사용자에게 웹 화면으로 서비스 제공 + 디자인 요소
    - 게시판 페이지
    - 게시글 페이지
    - 로그인 페이지
- 적절한 입출력 데이터의 검증
- 인증 기능
- 생산성에 도움이 되는 도구들 선택

## 세부기능으로부터 선택을 예상하는 기술들

- Java + Spring Boot 기반에서 선택
- 웹 서비스 제공 -> Spring Web
- 도메인의 설계와 DB 저장 -> Spring Data JPA, H2 Database, MySQL Driver
- JSOn API 로 데이터 제공 -> Rest Repositories, Rest Repositories HAL Explorer
- 웹 화면 : 강의 목표에서 맞춰 서버 사이드 렌더링으로 접근 -> 템플릿 에닞ㄴ -> Thymeleaf
- 디자인 요소 -> Bootstrap 5.2
- 적절한 입출력 데이터의 검증 -> Validation
- 인증 기능 -> Spring Security
- 생산성 -> Lombok, Spring Boot DevTools, Spring Boot Actuator

## Reference

- https://start.spring.io/
