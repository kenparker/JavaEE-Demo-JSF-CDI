package com.maggioni.mymemo.controller;

import com.maggioni.mymemo.model.Memo;
import com.maggioni.mymemo.service.MemoServiceBean;
import java.io.Serializable;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ViewScoped
@Named
public class MemoController implements Serializable{
    
    private static final long serialVersionUID = 8994022512914167890L;
    private Memo memo;

    @Inject
    private MemoServiceBean memoService;

    public MemoController() {
        memo = new Memo();
    }

    public Memo getMemo() {
        return memo;
    }

    public void setMemo(Memo memo) {
        this.memo = memo;
    }

    public void doAdd(ActionEvent event) {
        memoService.addMemo(memo);
        memo.setDescription("");
    }

    public void doReset(ActionEvent event) {
        memoService.resetMemos();
    }

    public List<Memo> getMemos() {
        System.out.println("get Memo startet");
        return memoService.getAllMemos();
    }
}
