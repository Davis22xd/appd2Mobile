package com.mobile.appd2.MVPAppd2.View;

import java.util.UUID;

/**
 * Created by david on 29/11/15.
 */
public interface BudgetStateView {
    void goNextStep(UUID uniqueKey, int budget);
}
