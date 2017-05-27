package ru.a799000.android.weighcalculator2.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by Alex on 23.05.2017.
 */

public interface MainActivityView extends MvpView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void startDetailProductActivityView(String idProdact);

}
