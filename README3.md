# 깃 브랜치 전략 세우기

## 깃 브랜치를 운영하는 방법론
- gitflow
  - master : production ready - 제품으로 나갈 수 있는 상태
  - develop : 개발 브랜치
  - feature : 개개인 개발자들이 자기 개발하기 위해
  - release : QA를 하고 간단한 버그 픽스
  - hotfix : 서비스 운영 중, 버그나 심각한 문제나 이슈가 있을 때

- github flow
  - main(master), feature 브랜치만으로 운영하는 방식


* gitflow 는 복잡하다, github flow 는 비교적 단순하다.
- 조직에 규모가 클 경우 -> gitflow
- 스타트업 같은 경우 -> github flow

## 브랜치 전략을 세우는 이유와 요령
- 하나의 프로젝트 소스코드를 여러 개발자가 다루면서 발생하는 각종 부작용을 해결하자.
- 개발 협업을 원활하게 하기 위한 약속
- 전략을 세울 때, 고려할 수 있는 요소들
  - 이 브랜치는 제품으로 내보낼 수 있는가?
  - 이 브랜치는 빌드 실패를 허용하는가?
  - 이 브랜치는 테스트 실패를 허용하는가?
  - 이 브랜치는 임시로 운영하는가? 유지하지 않고 수시로 삭제하는가?

** merge 충돌이 날 경우, 대비 **

## Reference
- https://github.com/nvie/gitflow
- https://docs.github.com/en/get-started/quickstart/github-flow
