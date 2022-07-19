package com.example.community.domain.entity;

import com.example.community.domain.dto.CommunityDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Community {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public Community(CommunityDto dto) {
        BeanUtils.copyProperties(dto, this);
    }

    public CommunityDto toDto() {
        CommunityDto dto = new CommunityDto();
        BeanUtils.copyProperties(this, dto);
        return dto;
    }

}
