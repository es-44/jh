package com.example.community.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommunityMemberDto {

    private Long id;

    private Long communityId;

    private Long memberId;
}
