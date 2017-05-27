package ru.a799000.android.weighcalculator2.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import io.realm.RealmResults;
import ru.a799000.android.weighcalculator2.app.App;
import ru.a799000.android.weighcalculator2.mvp.model.intities.Product;
import ru.a799000.android.weighcalculator2.mvp.view.MainActivityView;
import ru.a799000.android.weighcalculator2.repository.realm.repository.IProductRepository;

/**
 * Created by Alex on 23.05.2017.
 */

@InjectViewState
public class MainActivityPresenter extends MvpPresenter<MainActivityView> {

    @Inject
    IProductRepository mProductRepository;

    RealmResults<Product> mProducts;

    public MainActivityPresenter() {
        App.getAppComponent().injectMainActivityPresenter(this);
    }

    public void onStart() {
        mProductRepository.getAllProduct(new IProductRepository.OnGetAllProductCallback() {
            @Override
            public void onSuccess(RealmResults<Product> products) {
                mProducts = products;
            }

            @Override
            public void onError(String message) {

            }
        });
    }


    public void onStop(){

    }


    public RealmResults<Product> getProducts() {
        return mProducts;
    }

    public void clickItem(String id) {
        getViewState().startDetailProductActivityView(id);
    }

    public void addProdact() {
        getViewState().startDetailProductActivityView(null);
    }
}
