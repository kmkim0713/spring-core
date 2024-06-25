package com.example.springcore;

import com.example.springcore.member.MemberService;
import com.example.springcore.member.MemberServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl();
    }



}
