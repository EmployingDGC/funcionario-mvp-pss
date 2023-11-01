package com.pss.presenter;

import com.pss.view.BaseView;

public class BasePresenter {
    private BaseView filhoView;
    private BasePresenter paiPresenter;

    public BasePresenter(BaseView filhoView, BasePresenter paiPresenter) {
        this.filhoView = filhoView;
        this.paiPresenter = paiPresenter;
    }

    public BaseView getFilhoView() {
        return this.filhoView;
    }

    public void setFilhoView(BaseView filhoView) {
        this.filhoView = filhoView;
    }

    public BasePresenter getPaiPresenter() {
        return this.paiPresenter;
    }
}
