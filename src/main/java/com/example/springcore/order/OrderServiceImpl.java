package com.example.springcore.order;

import com.example.springcore.discount.DiscountPolicy;
import com.example.springcore.discount.FixDiscountPolicy;
import com.example.springcore.discount.RateDiscountPolicy;
import com.example.springcore.member.Member;
import com.example.springcore.member.MemberRepository;
import com.example.springcore.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    // 인터페이스만 주고, 누군가가 주입해주어야함
    private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
