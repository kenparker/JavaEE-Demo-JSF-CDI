package com.maggioni.mymemo.data;

import com.maggioni.mymemo.model.Memo;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Singleton;
import javax.enterprise.context.SessionScoped;


@SessionScoped
public class MemoStore implements Serializable{
    
    private static final long serialVersionUID = -3258831452772896931L;
    private List<Memo> memos;

    public MemoStore() {
        super();
        memos = new LinkedList<Memo>();
    }

    public List<Memo> findAll() {
        return memos;
    }

    public void persist(Memo memo) {
        memos.add(memo);
    }

    public void removeAll() {
        memos.clear();
    }
}
