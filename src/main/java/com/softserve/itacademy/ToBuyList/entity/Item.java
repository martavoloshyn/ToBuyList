package com.softserve.itacademy.ToBuyList.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Item {

    private Integer id;
    private Integer idList;
    private String text;
    private LocalDate createDate;
    private LocalDate updateDate;
    private Boolean isDone;

    public Item() {
    }

    public Item(Integer idList, String text, LocalDate createDate, LocalDate updateDate, Boolean isDone) {
        this.idList = idList;
        this.text = text;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.isDone = isDone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdList() {
        return idList;
    }

    public void setIdList(Integer idList) {
        this.idList = idList;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id.equals(item.id) &&
                idList.equals(item.idList) &&
                text.equals(item.text) &&
                createDate.equals(item.createDate) &&
                updateDate.equals(item.updateDate) &&
                isDone.equals(item.isDone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idList, createDate);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", idList=" + idList +
                ", text='" + text + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", isDone=" + isDone +
                '}';
    }
}
