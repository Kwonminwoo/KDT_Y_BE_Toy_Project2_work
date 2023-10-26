
## 토이 프로젝트2 SPRING BOOT


여행 여정을 기록과 관리하는 SNS 서비스 2단계


### 🕰️ 개발 기간

---

- 23.10.23일 - 23.10.27일

### 🧑‍🤝‍🧑 멤버 구성

---

- [권민우](https://github.com/Kwonminwoo)

- [백인권](https://github.com/BackInGone)

- [임경민](https://github.com/pabu-lim)

- [유현](https://github.com/yuhyun1)

### ⚙️ 개발 환경

---

- Java 17
- Spring 3.1.5
- Gradle
- 의존성
    - Spring Web
    - Lombok
    - JPA
    - Validation


### 📌 주요 기능

---

#### - 여행 기록 및 여정 기록 기능
- 여행 일정 기록
- 하나의 여행에 여러 개의 일정 기록


#### - 여행 정보 조회 기능
- 저장된 여행 전체 리스트 조회
- 여행 전체 리스트에서 확인된 아이디를 입력하면 해당 여행 정보 조회

### 💡 착안사항

---


#### - 예외처리
- 여행 등록 실패 시 오류 메세지 출력
- 여행 조회, 수정 시 여행 정보가 없으면 오류 메세지 출력
- 입력 길이 초과, 아이디, 날짜 등 컬럼 형식이 안맞을 떄 오류 메세지 출력
- 여행/여정 종료 날짜가 시작 날짜보다 빠를 때 오류 메세지 출력
- 일부 정보만 누락될 때(필드 누락) 오류 메세지 출력

#### - 리팩토링
- 
