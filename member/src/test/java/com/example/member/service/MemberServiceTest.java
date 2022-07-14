package com.example.member.service;

import com.example.member.domain.dto.MemberDto;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    MemberService memberService;

    @Test
    public void joinMember() {

        MemberDto dto = new MemberDto();

        dto.setId(0l);
        dto.setName("테스터");
        dto.setEmail("test@gmail.com");
        dto.setCommunityCount(0);

        memberService.joinMember(dto);

    }



}