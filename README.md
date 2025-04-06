# Spring 데이터 영속성 예제

이 프로젝트는 Spring 기반의 백엔드 시스템에서 다양한 방식으로 데이터 영속성을 구현하는 방법을 보여줍니다.
`JDBC API`, `JdbcTemplate`, `MyBatis`, `Hibernate`, `JPA + Hibernate`, `Spring Data JPA`를 사용하여 CRUD 기능을 구현하는 예제를 포함하고 있습니다.
---
## 목적
이 프로젝트의 목적은 다양한 영속성 기술을 사용하여 `Task(할 일)` 엔티티에 대한 CRUD 작업을 구현하고, 각 기술의 코드 간결성, 가독성, 유지보수성의 차이를 비교하는 것입니다.

---
## 프로젝트 구조
SpringPersistenceExamples/  
├── jdbc/                     # 순수 JDBC API 사용 예제  
├── jdbcTemplate/             # Spring의 JdbcTemplate 사용 예제  
├── mybatis/                  # MyBatis SQL Mapper 사용 예제  
├── hibernate/                # Hibernate 사용 예제 (JPA 프로바이더)  
├── jpa/                      # JPA + Hibernate 사용 예제  
├── springDataJpa/            # Spring Data JPA 사용 예제  
├── README.md                 # 프로젝트 설명 (이 파일)  
---

## 의존성
다양한 모듈에서 사용되는 공통 의존성은 다음과 같습니다:
- spring-webmvc
- spring-jdbc
- spring-tx
- javax.servlet-api
- commons-dbcp2
- mysql-connector-java

## 적용 기술
1. JDBC API (순수 JDBC를 사용한 CRUD 구현)
2. JdbcTemplate (Spring의 추상화 계층을 사용하여 JDBC 접근 단순화)
3. MyBatis (SQL Mapper를 사용하여 SQL을 객체로 매핑)
4. Hibernate (ORM 프레임워크로서 JPA 프로바이더로 사용)
5. JPA + Hibernate (JPA 표준 인터페이스를 사용하여 Hibernate를 프로바이더로 사용)
6. Spring Data JPA (Spring Data의 저장소 추상화를 사용하여 코드 간결화)

## 실행 방법

저장소를 클론합니다.  
eisenhower 라는 이름의 MySQL 데이터베이스를 생성하고 sql 파일을 참조하여 Task 테이블을 생성합니다.  
applicationContext.xml 및 dispatcher-servlet.xml 파일을 설정합니다.  
각 모듈을 독립적으로 실행하여 CRUD 기능을 테스트합니다.  

## 결론
다양한 영속성 기술을 비교함으로써 각 방식이 코드 간결성, 유지보수성, 표현력 측면에서 어떻게 차이가 나는지 확인할 수 있습니다. 이 프로젝트는 상황에 따라 적합한 영속성 기술을 선택할 수 있도록 도움을 주기 위해 작성되었습니다.