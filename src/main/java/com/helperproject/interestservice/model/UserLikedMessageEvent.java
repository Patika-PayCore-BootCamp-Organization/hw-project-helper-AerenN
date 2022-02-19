package com.helperproject.interestservice.model;

import lombok.Getter;

@Getter
public class UserLikedMessageEvent {
    private String username;
    private String messageId;
    private String tag;
    //private LocalDateTime likedDate;

    public UserLikedMessageEvent(String username, String messageId, String tag) {
        this.username = username;
        this.messageId = messageId;
        this.tag = tag;
        //this.likedDate = LocalDateTime.now();
    }

    public UserLikedMessageEvent() {
    }
}

