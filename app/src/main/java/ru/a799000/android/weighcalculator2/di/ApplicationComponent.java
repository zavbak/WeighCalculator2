package ru.a799000.android.weighcalculator2.di;

import javax.inject.Singleton;

import dagger.Component;
import io.realm.RealmConfiguration;
import ru.a799000.android.weighcalculator2.mvp.model.interactor.BarcodeInteractor;
import ru.a799000.android.weighcalculator2.mvp.model.interactor.ProductInteractor;
import ru.a799000.android.weighcalculator2.mvp.model.interactor.SumBarcodeInteractor;
import ru.a799000.android.weighcalculator2.mvp.presenters.BarcodeDetailActivityPresenter;
import ru.a799000.android.weighcalculator2.mvp.presenters.BarcodesActivityPresenter;
import ru.a799000.android.weighcalculator2.mvp.presenters.MainActivityPresenter;
import ru.a799000.android.weighcalculator2.mvp.presenters.ProdactDetailPresenter;


/**
 * Created by user on 17.05.2017.
 */

@Singleton
@Component(modules={ApplicationModule.class,RealmModule.class})
public interface ApplicationComponent {
    RealmConfiguration getRealmConfiguration();
    void injectMainActivityPresenter(MainActivityPresenter mainActivityPresenter);
    void injectProdactDetailPresenter(ProdactDetailPresenter prodactDetailPresenter);
    void injectBarcodesActivityPresenter(BarcodesActivityPresenter barcodesActivityPresenter);
    void injectBarcodeDetailActivityPresenter(BarcodeDetailActivityPresenter barcodeDetailActivityPresenter);

    void injectProductInteractor(ProductInteractor productHelper);
    void injectBarcodeInteractor(BarcodeInteractor barcodeInteractor);
    void injectSumBarcodeInteractor(SumBarcodeInteractor sumBarcodeInteractor);
}
