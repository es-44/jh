package com.example.member.service;

import com.example.member.domain.dto.MemberDto;
import com.example.member.domain.entity.Member;
import com.example.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public void joinMember(MemberDto dto) {

        Member member = new Member(dto);
        memberRepository.save(member);
    }

}
