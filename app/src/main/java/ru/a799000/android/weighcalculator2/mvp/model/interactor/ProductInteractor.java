package ru.a799000.android.weighcalculator2.mvp.model.interactor;

import javax.inject.Inject;

import ru.a799000.android.weighcalculator2.app.App;
import ru.a799000.android.weighcalculator2.mvp.model.intities.Product;
import ru.a799000.android.weighcalculator2.repository.realm.repository.IBarcodeRepository;
import ru.a799000.android.weighcalculator2.repository.realm.repository.IProductRepository;

/**
 * Created by Alex on 24.05.2017.
 */

public class ProductInteractor {
    @Inject
    IProductRepository mProductRepository;

    @Inject
    IBarcodeRepository mBarcodeRepository;

    @Inject
    public ProductInteractor() {
        App.getAppComponent().injectProductInteractor(this);
    }

    public Product getProduct(long id){

        Product product= new Product();

        mProductRepository.getProductById(id, new IProductRepository.OnGetProductByIdCallback() {
            @Override
            public void onSuccess(Product productRealm) {

                product.setId(productRealm.getId());
                product.setName(productRealm.getName());
                product.setStart(productRealm.getStart());
                product.setFinish(productRealm.getFinish());
                product.setCoef(productRealm.getCoef());
                product.setInitBarcode(productRealm.getInitBarcode());
            }

            @Override
            public void onError(String message) {

            }
        });


        return product;
    }


    public void dellProduct(Product product){
        if(product.getId() != 0){
            mProductRepository.deleteProductById(product.getId(),null);
        }
    }

    public void saveProduct(Product product){
        mProductRepository.saveProduct(product,null);
    }


}
