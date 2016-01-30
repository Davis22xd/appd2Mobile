package com.mobile.appd2.MVPAppd2.Presenter;

import android.content.SharedPreferences;

import com.mobile.appd2.MVPAppd2.Interactor.BudgetInteractorImpl;
import com.mobile.appd2.MVPAppd2.Listener.BudgetListener;
import com.mobile.appd2.MVPAppd2.View.BudgetStateView;
import com.mobile.appd2.MVPAppd2.Interactor.BudgetInteractor;

/**
 * Created by david on 29/11/15.
 */
public class BudgetPresenterImpl implements BudgetPresenter {

    private BudgetStateView BudgetStateView;

    private BudgetInteractor BudgetInterator;
    public BudgetPresenterImpl(BudgetStateView BudgetStateView) {
        this.BudgetStateView = BudgetStateView;
        BudgetInterator = new BudgetInteractorImpl();
    }

    @Override
    public void saveBudget(int budget) {
        BudgetInterator.saveBudget(budget);
        BudgetStateView.goNextStep();
    }

    @Override
    public void generateVoID(SharedPreferences preference) {
        BudgetInterator.generateVoID(preference);
    }
}
