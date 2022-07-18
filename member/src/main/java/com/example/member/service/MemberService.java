package com.example.member.service;

import com.example.member.domain.dto.MemberDto;
import com.example.member.domain.entity.Member;
import com.example.member.domain.event.EventType;
import com.example.member.domain.event.MemberEvent;
import com.example.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final StreamBridge streamBridge;

    public MemberDto joinMember(MemberDto dto) {

        Member member = memberRepository.save(new Member(dto));
        MemberDto savedMember = member.toDto();

        sendSuccessMessage(savedMember);

        return savedMember;
    }

    private void sendSuccessMessage(MemberDto savedMember) {

        MemberEvent event = new MemberEvent(savedMember, EventType.SUCCESS);

        streamBridge.send("member-output-0",
                MessageBuilder
                        .withPayload(event)
                        .setHeader("type", event.getClass().getSimpleName())
                        .build());
    }

    private void sendFailMessage(MemberDto failedMember) {

        MemberEvent event = new MemberEvent(failedMember, EventType.FAIL);

        streamBridge.send("member-output-0",
                MessageBuilder
                        .withPayload(event)
                        .setHeader("type", event.getClass().getSimpleName())
                        .build());
    }

}
