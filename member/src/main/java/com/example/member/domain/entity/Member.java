package com.example.member.domain.entity;

import com.example.member.domain.dto.MemberDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Member {

    @Id
    private Long id;

    private String name;

    private String email;

    private int communityCount;

    public Member(MemberDto dto) {
        BeanUtils.copyProperties(dto, this);
    }

    public MemberDto toDto() {
        MemberDto dto = new MemberDto();
        BeanUtils.copyProperties(this, dto);
        return dto;
    }

}
