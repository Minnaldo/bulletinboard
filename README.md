# bulletinboard

## 게시판 서비스 프로젝트의 목표

- 누구나 이해하기 쉬운 소재로 명확한 기능 요구사항을 만든다.
- 요구사항을 구현하는데, 도움이 되는 각종 문서 작업을 경험한다.
- 자바+스프링부트로 프로젝트 요구사항을 실제로 구현하는 기술적인 방법을 익힌다.
- 최신 버전의 기술을 사용해 보면서 기술 동향을 파악하고, 새로운 문제와 해결 방법을 확인한다.
- 기획과 문서 작성부터 개발, 형상관리, 테스트, 배포까지 전반적인 개발 프로세스 전반을 경험한다.

## 개발 목적 이해하기

### 다양한 형태의 문서 작업 - 원활한 협업의 초석

- 문서를 통해 개발할 프로젝트의 목적, 내용, 진행상황을 공유 (왜 하는지가 중요)
    - 무엇을, 어떻게 : 업무의 가이드. 동료의 생산성을 높여줌.
    - 왜 : 함꼐 움직이는 원동력, 동료가 더 나은 방법을 제안하거나, 내 생각의 오류를 잡아줌.
- 내용이 구체적일수록, 동료들의 프로젝트 개발 내용이 잘 동기화되고 진행이 막히지 않음.
    - 주의 - 과도한 정보의 범람, 업데이트 되지 않았거나 잘못된 정보가 주는 혼란.
- 백업이 용이 : 문서는 지나간 일을 다시 꺼내야 할 때, 쉽게 찾게 도와줌.
- 기억은 짧고 왜곡되지만, 문서는 수정 가능하고 발전하며 오래 감.
- 업무 기록을 남김으로써, 업무 진척 상황과 내 성과가 잘 드러남.

### 문서 작업

- diagrams.net (구 draw.io) : 도메인과 ERD 설계, 유즈케이스
- 구글 시트 : API 디자인
- 깃 + 깃헙 : 커밋 메시지 작성, 프로젝트 관리 및 협업 환경 꾸미기

### 개발 목적 - 고객의 문제 해결 (+ 하는 과정을 공부)

- 고객의 니즈와 문제를 정리
    - 고객이 원치 않거나 고객의 문제를 해결해 줄 수 없는 개발은 의미가 없다.
- 문제 -> 요구사항 -> 기능(feature) 도출 -> 구현 방안의 기획 -> 개발 계획 수립 -> 실행
- 제약사항 : 기술 스택 픽스.
    - 제약 == 집중과 효율
- 공부 목표의 특전 : 가능한 최신 버전의 기술을 사용
    - 최신 동향 파악
    - 아직 밝혀지지 않은 이슈를 직접 경험 -> 해결 방법 찾기 -> 할 수 있다면 해결까지.

### 개발 환경

- IDE : IntelliJ IDEA 2022.1.1 (Ultimate Edition)
    - Community Edition 은 무료지만 스프링 부트 지원 기능이 Ultimate 버전에 있음.
    - 현업에서 Ultimate Edition 사용.
- 언어 : java 17
- 프레임워크 : spring boot 2.7.0
- 빌드 도구 : gradle 7.4.1
- git GUI : GitKraken - git 형상 관리와 브랜치 전략 활용
- 각종 개발 전략과 도메인 설계, 실무 디자인 패턴, 비즈니스 로직의 구현을 경험.

### 인텔리제이 플러그인 추가 (기능)

- CamelCase (3.0.12)
- GitToolBox (212.9.0)
- JPA Buddy (2022.2.4-221)
- Key Promoter X (2022.1.2)
- Presentation Assistant (1.0.9)
- Ideolog (203.0.30.0)
- Spring Boot Assistant (0.14.0)

- ANSI Highlighter (1.2.4) -> 이후 유료 플러그인으로 바뀜.
- Atom Material Icons (64.0.0)
- Grep Console (12.12.211.6693.0)
- One Dark theme (5.6.0)

### 테스트와 배포 - 고객에게 제품을 보여주고 성과를 확인하는 순간

- 테스트
    - 개발 요구사항이 빠짐 없이 모두 구현되었는가? (일이 끝났는가)
    - 구현된 요구사항이 오류 없이 동작하는가? (일이 잘 끝났는가)
- 배포
    - 깃헙 릴리즈 작성
    - 클라우드 서버에 배포 (헤로쿠)  -> 무료, 목업

### 게시판 테스트와 배포

- 테스트
    - JUnit 5.8.2
    - 각종 테스트 라이브러리 (Mockito, AssertJ 등)
    - 스프링 부트 슬라이스 테스트 테크닉
    - 깃헙 : 테스트/빌드 자동화
- 배포
    - 클라우드 서버에 배포 (Heroku)
        - 최근 보안 이슈로 일부 자동화 기능을 이용하지 못할 수 있음.
        - Heroku 를 사용하지 못할 경우, 로컬에서 실행
    - 깃헙 : Heroku 배포 자동화

### Reference

- https://www.diagrams.net/
- https://www.heroku.com/home
- https://junit.org/junit5/
- https://site.mockito.org/
- https://assertj.github.io/doc/

