package com.chend.hPoker;

import java.util.ArrayList;
import java.util.List;

public class People{
    private Integer id;
    private String name;
    public List<Poker> pokers;

    public People (Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
        this.pokers = new ArrayList<Poker>();
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof People))
            return false;
        People other = (People) obj;
        if(id!=null&&name==null) {
            if(!id.equals(other.id)) {
                return false;
            }
        }else if(name!=null&&id==null) {
            if(!name.equals(other.name)) {
                return false;
            }
        }else if(!name.equals(other.name)||!id.equals(other.id)){
            return false;
        }
        return true;
    }

}
