package com.example.community.service;

import com.example.community.domain.dto.CommunityMemberDto;
import com.example.community.domain.entity.Community;
import com.example.community.domain.dto.CommunityDto;
import com.example.community.domain.entity.CommunityMember;
import com.example.community.domain.event.CommunityEvent;
import com.example.community.domain.event.EventType;
import com.example.community.repository.CommunityMemberRepository;
import com.example.community.repository.CommunityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class CommunityService {

    private final StreamBridge streamBridge;
    private final CommunityMemberRepository communityMemberRepository;
    private final CommunityRepository communityRepository;

    public CommunityMemberDto joinCommunity(CommunityMemberDto dto) {

        // join
        Community community = communityRepository.findById(dto.getCommunityId()).orElseGet(null);
        CommunityMember communityMember = new CommunityMember(dto);
        communityMember.setCommunity(community);

        communityMemberRepository.save(communityMember);

        // send message

        // log

        return null;

    }
}
