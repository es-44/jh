package com.example.member.service;

import com.example.member.domain.dto.MemberDto;
import com.example.member.domain.entity.Member;
import com.example.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final StreamBridge streamBridge;

    @Transactional
    public MemberDto joinMember(MemberDto dto) {

        Member member = memberRepository.save(new Member(dto));
        MemberDto savedMember = member.toDto();

        streamBridge.send("member-output-0", savedMember);

        return savedMember;
    }

}
