package hello.core;

import hello.core.Order.OrderService;
import hello.core.Order.OrderServiceImpl;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    //bean이라고 작성하면 이제는 return new 옆에 나온 객체를 관리한다.

    /*
    *  현재 new MemmoryMemberRepository를 2번 호출하는데 싱글톤이 깨는거 아니야? 우선 테스트 작성해보자
    *  @Bean memberService -> new MemoryMemberRepository()
    *  @Bean orderService -> new MemoryMemberRepository()
    *
    * 예상 호출
    * call AppConfig.memberService
    * call AppConfig.memberRepository
    * call AppConfig.memberRepository
    * call AppConfig.orderService
    * call AppConfig.memberRepository
    *
    * 실제 호출
    * call AppConfig.memberService
    * call AppConfig.memberRepository
    * call AppConfig.orderService
    *
    * 스프링이 싱글톤을 어떻게든 유지시키는구나...
    * */

    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");;
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }


}
