package com.example.member.domain.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Event {

    private String id;
    private String name;
    private EventType status;

    public Event(String name) {
        this(UUID.randomUUID().toString(), name, Enum.valueOf(EventType.class, "NULL"));
    }

}
