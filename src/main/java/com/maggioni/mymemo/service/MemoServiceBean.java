package com.maggioni.mymemo.service;

import com.maggioni.mymemo.data.MemoStore;
import com.maggioni.mymemo.model.Memo;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@RequestScoped
@Transactional(value=Transactional.TxType.REQUIRED)
public class MemoServiceBean {

    @Inject
    private MemoStore memoStore;

    public List<Memo> getAllMemos() {
        return memoStore.findAll();
    }

    public void addMemo(Memo memo) {
        Memo newMemo = new Memo();
        newMemo.setDescription(memo.getDescription());
        newMemo.setCreated(new Date());
        memoStore.persist(newMemo);
    }

    public void resetMemos() {
        memoStore.removeAll();
    }
}
