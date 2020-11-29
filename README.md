# Spring Logging

## 스프링과 JCL, 그리고 SLF4J
- 스프링 부트는 모든 내부 로깅에 Apache Commons Logging (또는 Jakarta Commons Logging, 이하 JCL) 을 기반으로 작성 됨.
- JCL 은 수 많은 로깅 구현체와 이를 사용하는 애플리케이션이 강하게 결합되지 않도록 인터페이스를 제공하는 중간 Bridge 임.
    > The Logging package is an ultra-thin bridge between different logging implementation - [Apache Commons: The Logging Component](https://commons.apache.org/proper/commons-logging/index.html#The_Logging_Component)
- 따라서 스프링은 실질적인 로깅 구현체인 Java Util Logging, Log4J2, Logback 에 대한 기본 구성도 제공.
- 반면, 2019년 스프링 블로그에 작성 된 [Logging Dependencies in Spring](https://spring.io/blog/2009/12/04/logging-dependencies-in-spring/) 글에서 JCL 의 단점에 대해 이야기하며 스프링 프로젝트를 다시 만든다면 JCL 을 택하지 않을 것이라고 기술. 그리고 이미 스프링에 포함된 JCL 의존성을 제외하고 SLF4J 의존성을 추가하는 법을 소개하기도 함. (SLF4J 역시 로깅 브릿지)
- 스프링 프레임워크 [5.0.0.RC3 레퍼런스의 문서 중 로깅](https://docs.spring.io/spring-framework/docs/5.0.0.RC3/spring-framework-reference/overview.html#overview-logging) (GA 문서에서는 로깅 관련 내용을 못찾겠음) 부분에서 `spring-jcl` 이라는 새로운 모듈을 소개. 이는 JCL-over-SLF4J 브릿지 역할. 즉, 직접 JCL 의존성을 제외하고 SLF4J 의존성을 추가할 필요 없이 스프링이 대신해주는 것.
- 스프링 부트 2 역시 스프링 프레임워크 5를 기반으로 하기에 동일하게 생각하면 됨.
- 부트는 기본적으로 로그백을 사용. (`jcl` - `spring-jcl` - `slf4j` - `logback`)
    > Spring Boot has a LoggingSystem abstraction that attempts to configure logging based on the content of the classpath. If Logback is available, it is the first choice.



## 참고
- [Spring Boot 2.1.x Reference: Part IV. Spring Boot features: 27. Logging
](https://docs.spring.io/spring-boot/docs/2.1.x/reference/html/boot-features-logging.html)
- [Spring Boot 2.1.x Reference: Part IX. ‘How-to’ guides: 84. Logging
](https://docs.spring.io/spring-boot/docs/2.1.x/reference/html/howto-logging.html)
- [Spring Blog: Logging Dependencies in Spring](https://spring.io/blog/2009/12/04/logging-dependencies-in-spring/)
- [SlideShare: 스프링 부트와 로깅, Keesun Baik](https://www.slideshare.net/whiteship/ss-47273947)