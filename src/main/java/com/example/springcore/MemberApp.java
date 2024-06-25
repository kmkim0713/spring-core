package com.example.springcore;

import com.example.springcore.member.Grade;
import com.example.springcore.member.Member;
import com.example.springcore.member.MemberService;
import com.example.springcore.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig(); // AppConfig에서 가져오기
        MemberService memberService = appConfig.memberService();

        Member member = new Member(1L, "memberA", Grade.VIP); // new 자동완성 cmd + option + v
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());

    }
}
