package com.softserve.itacademy.ToBuyList.entity;

import java.time.LocalDate;
import java.util.Objects;

public class List {
    private Integer id;
    private Integer idUser;
    private String name;
    private LocalDate createDate;
    private LocalDate updateDate;
    private Boolean isDone;

    public List() {
    }

    public List(Integer idUser, String name, LocalDate createDate, LocalDate updateDate, Boolean isDone) {
        this.idUser = idUser;
        this.name = name;
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

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        List list = (List) o;
        return id.equals(list.id) &&
                idUser.equals(list.idUser) &&
                name.equals(list.name) &&
                createDate.equals(list.createDate) &&
                updateDate.equals(list.updateDate) &&
                isDone.equals(list.isDone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idUser, createDate);
    }

    @Override
    public String toString() {
        return "List{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", isDone=" + isDone +
                '}';
    }
}
