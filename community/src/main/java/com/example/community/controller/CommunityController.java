package com.example.community.controller;

import com.example.community.domain.dto.CommunityDto;
import com.example.community.domain.dto.CommunityMemberDto;
import com.example.community.service.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("community")
public class CommunityController {

    private final CommunityService communityService;

    @GetMapping
    public CommunityMemberDto joinCommunity(@RequestBody CommunityMemberDto dto) {

        return communityService.joinCommunity(dto);
    }


}
