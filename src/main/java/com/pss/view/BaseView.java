package com.pss.view;

import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class BaseView extends JPanel {
    public BaseView(LayoutManager layout) {
        this.setLayout(layout);
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }
}
