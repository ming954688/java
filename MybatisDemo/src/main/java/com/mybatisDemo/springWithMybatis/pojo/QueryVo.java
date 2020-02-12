package com.mybatisDemo.springWithMybatis.pojo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * 描述: TODO
 * Author: Ming
 * Date: 2020/2/12 18:01
 * version: 1.0
 */
public class QueryVo implements Serializable {

    private Integer[] ids;

    private List<Integer> idsList;

    private User user;

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }

    public List<Integer> getIdsList() {
        return idsList;
    }

    public void setIdsList(List<Integer> idsList) {
        this.idsList = idsList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "ids=" + Arrays.toString(ids) +
                ", idsList=" + idsList +
                ", user=" + user +
                '}';
    }
}
