package com.mobile.appd2.MVPAppd2.Interactor;

import android.content.Context;
import android.content.SharedPreferences;

import com.mobile.appd2.MVPAppd2.Listener.BudgetListener;
import com.mobile.appd2.MVPAppd2.View.BudgetStateView;

import java.util.UUID;

/**
 * Created by david on 29/11/15.
 */
public class BudgetInteractorImpl implements BudgetInteractor {

    private  BudgetListener BudgetListener;
    private  SharedPreferences sharedpreferences;
    private SharedPreferences.Editor editor;
    private BudgetStateView BudgetStateView;

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    private  int budget;

    private UUID uniqueKey;

    public UUID getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(UUID uniqueKey) {
        this.uniqueKey = uniqueKey;
    }

    public BudgetInteractorImpl(BudgetStateView BudgetStateView) {
        this.BudgetStateView = BudgetStateView;
        setUniqueKey(UUID.randomUUID());
    }

    @Override
    public void saveBudget(int budget) {
       setBudget(budget);
        BudgetStateView.goNextStep(uniqueKey, this.budget);
//        editor.putString("budget", String.valueOf(getBudget()));
//        System.out.println("la clave es: " + budget);
    }

//    @Override
//    public void generateVoID(SharedPreferences preference) {
////        sharedpreferences = preference;
////        editor = sharedpreferences.edit();
//        setUniqueKey(UUID.randomUUID());
////        editor.putString("PlanVo",uniqueKey.toString());
////        System.out.println("la clave es: " + uniqueKey);
//    }

}
