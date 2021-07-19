package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    void vip_o(){

        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    void vip_o2(){

        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 1000000);

        //then
        assertThat(discount).isEqualTo(100000);
    }

//    @Test
//    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
//    void vip_x(){
//
//
//        //given
//        Member member = new Member(2L, "memberBA", Grade.BASIC);
//
//        //when
//        int discount = discountPolicy.discount(member, 10000);
//        System.out.println("discount = " + discount);
//
//        //then
//        assertThat(discount).isEqualTo(1000);
//
//    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x2(){


        //given
        Member member = new Member(2L, "memberBA", Grade.BASIC);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(0);

    }

}