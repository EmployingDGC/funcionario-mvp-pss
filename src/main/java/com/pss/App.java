package com.pss;

import com.pss.presenter.PrincipalPresenter;

/**
 * Hello world!
 */
public final class App {
    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        PrincipalPresenter principalView = new PrincipalPresenter();
        principalView.getJanela().setVisible(true);
    }
}
