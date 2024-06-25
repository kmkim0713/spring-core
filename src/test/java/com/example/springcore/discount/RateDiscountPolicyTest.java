package com.example.springcore.discount;

import com.example.springcore.member.Grade;
import com.example.springcore.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();


    // 테스트에는 실패 테스트도 꼭 만들어보자

    @Test
    @DisplayName("VIP는 10% 할인 적용")
    void vip_o() {

        // given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        // when
        int discount = discountPolicy.discount(member, 10000);

        // then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야함")
    void vip_x() {

        // given
        Member member = new Member(2L, "memberVIP", Grade.BASIC);

        // when
        int discount = discountPolicy.discount(member, 10000);

        // then
        Assertions.assertThat(discount).isEqualTo(0);

    }

}