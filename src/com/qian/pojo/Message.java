package com.qian.pojo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.util.Date;

public class Message {
    private int mid;
    private String mContent;
    private String username;
    private LocalDateTime mDate;

    public Message() {
    }

    public Message(int mid, String mContent, String username, LocalDateTime mDate) {
        this.mid = mid;
        this.mContent = mContent;
        this.username = username;
        this.mDate = mDate;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

   public LocalDateTime getmDate() {
        return mDate;
    }

    public void setmDate(LocalDateTime mDate) {
        this.mDate = mDate;
    }


    @Override
    public String toString() {
        return "Message{" +
                "mid=" + mid +
                ", mContent='" + mContent + '\'' +
                ", username='" + username + '\'' +
                ", mDate=" + mDate +
                '}';
    }
}