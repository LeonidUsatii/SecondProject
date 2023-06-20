package de.ait.models;

import java.time.LocalDateTime;


public class Order { // заказ
    private String id;
    private LocalDateTime dateTime;

    private String goodId;
    private String userId;

    public Order(String id, LocalDateTime dateTime, String goodId, String userId) {
        this.id = id;
        this.dateTime = dateTime;
        this.goodId = goodId;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getGoodId() {
        return goodId;
    }

    public String getUserId() {
        return userId;
    }
}
