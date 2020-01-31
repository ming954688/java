package com.springDemo4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionBean {
    //数组类型, list类型
    private String[] arrs;

    private List list;

    private Map map;

    private Set set;

    @Override
    public String toString() {
        return "CollectionBean{" +
                "arrs=" + Arrays.toString(arrs) +
                ", list=" + list +
                ", map=" + map +
                ", set=" + set +
                '}';
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setList(List list) {
        this.list = list;
    }

    public void setArrs(String[] arrs) {
        this.arrs = arrs;
    }

    public void setSet(Set set) {
        this.set = set;
    }
}
