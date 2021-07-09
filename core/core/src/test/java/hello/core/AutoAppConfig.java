package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// 배제할 자동 주입 설정 ( 자동 주입 필터 )
@ComponentScan(
        basePackages = "hello.core.member", // 탐색할 패키지의 시작위치를 지정
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

//    @Bean(name = "memoryMemberRepoistory")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
