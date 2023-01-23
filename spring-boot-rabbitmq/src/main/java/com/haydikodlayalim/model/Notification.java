package com.haydikodlayalim.model;

import java.io.Serializable;
import java.util.Date;

// bu nesneyi kuyruga gondermek icin serializable interface ini implemente etmek zorundayiz.
// boylelikle java tarafindan anlamli bir sekilde isleme alinacaktir.

public class Notification implements Serializable {

    private String notificationId;
    private Date createdAt;
    private Boolean seen; // goruldu mu onu kontrol ediyor
    private String message;

    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getSeen() {
        return seen;
    }

    public void setSeen(Boolean seen) {
        this.seen = seen;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId='" + notificationId + '\'' +
                ", createdAt=" + createdAt +
                ", seen=" + seen +
                ", message='" + message + '\'' +
                '}';
    }
}
