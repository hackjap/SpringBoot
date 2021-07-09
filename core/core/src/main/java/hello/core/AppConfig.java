package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 역할을 생성하고 구현체까지 부여하여 service에는 오직 실행에만 집중할 수 있도록 한다. = DI(Dependancy Injection) 의존관계 주입
@Configuration
public class AppConfig { // AppConfig = 공연 기획자 ( 역할과 구현을 분리 )

//    @Bean memberService -> new MemoryMemberRepository
//    @Bean orderService -> new MemoryMemberRepository


    // call AppConfig.memberService
    // call AppConfig.memberRepository
    // call AppConfig.orderService

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() { // 역할과 구현을 한 눈에 파악됨
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());

    }


    @Bean
    public DiscountPolicy discountPolicy() {
//      return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }


}
