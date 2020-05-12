package com.company;

import java.util.Date;

public class Historie {
    Integer id;
    Integer proId;
    Integer kunId;

    String status;
    Date zeitstempel;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getProId() {
        return proId;
    }
    public void setProId(Integer proId) {
        this.proId = proId;
    }
    public Integer getKunId() {
        return kunId;
    }
    public void setKunId(Integer kunId) {
        this.kunId = kunId;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Date getZeitstempel() {
        return zeitstempel;
    }
    public void setZeitstempel(Date zeitstempel) {
        this.zeitstempel = zeitstempel;
    }

    @Override
    public String toString() {
        return "Historie{" +
                "id=" + id +
                ", proId=" + proId +
                ", kunId=" + kunId +
                ", status='" + status + '\'' +
                ", zeitstempel=" + zeitstempel +
                '}';
    }
}
