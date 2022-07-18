package com.example.member.domain.event;

import com.example.member.domain.dto.MemberDto;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class MemberEvent extends Event {

    private MemberDto dto;

    public MemberEvent() {
        super(MemberEvent.class.getSimpleName());
    }

    public MemberEvent(MemberDto dto) {
        this();
        this.dto = dto;
    }

    public MemberEvent(MemberDto dto, EventType type) {
        this();
        this.dto = dto;
        this.setStatus(type);
    }

}
