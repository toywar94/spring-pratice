package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration

//@conponent라고 붙은 애를 자동으로 등록
@ComponentScan(
        //만약 basePackages를 지정하지 않으면 default인데
        //default = hello.core를 다 뒤진다.
        basePackages = "hello.core.member", //member만 뒤진다 {"",""} 여러개 가능
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)//제외하기
)

public class AutoAppConfig {
/*
    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    */
}
