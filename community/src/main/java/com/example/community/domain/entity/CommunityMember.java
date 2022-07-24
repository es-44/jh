package com.example.community.domain.entity;

import com.example.community.domain.dto.CommunityMemberDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class CommunityMember {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "communityId", nullable = false, insertable = false)
    private Community community;

    private Long memberId;

    public CommunityMember(CommunityMemberDto dto) {
        BeanUtils.copyProperties(dto, this);
    }

}
