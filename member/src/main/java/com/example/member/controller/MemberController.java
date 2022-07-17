package com.example.member.controller;

import com.example.member.domain.dto.MemberDto;
import com.example.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public MemberDto joinMember(@RequestBody MemberDto dto) {
        return memberService.joinMember(dto);
    }

}
