package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.Order.OrderServiceImpl;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1= memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();
        //싱글톤이네...
        System.out.println("memberRepository1 = " + memberRepository1);
        System.out.println("memberRepository2 = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);

        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository1);
        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository2);

    }

    @Test
    void configurationDeepTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
        //bean = class hello.core.AppConfig$$EnhancerBySpringCGLIB$$5e368a5b

    }
    
}
