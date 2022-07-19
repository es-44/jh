package com.example.community.domain.event;

import com.example.community.domain.dto.CommunityDto;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class CommunityEvent extends Event {

    private CommunityDto dto;

    public CommunityEvent() {
        super(CommunityEvent.class.getSimpleName());
    }

    public CommunityEvent(CommunityDto dto) {
        this();
        this.dto = dto;
    }

    public CommunityEvent(CommunityDto dto, EventType type) {
        this();
        this.dto = dto;
        this.setStatus(type);
    }

}
