package com.example.springcore;

import com.example.springcore.member.Grade;
import com.example.springcore.member.Member;
import com.example.springcore.member.MemberService;
import com.example.springcore.member.MemberServiceImpl;
import com.example.springcore.order.Order;
import com.example.springcore.order.OrderService;
import com.example.springcore.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig(); // AppConfig에서 가져오기
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();


//        MemberService memberService = new MemberServiceImpl(null);
//        OrderService orderService = new OrderServiceImpl(null,null);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = "+ order);
        System.out.println("order = "+ order.calculatePrice());

    }
}
