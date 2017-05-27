package ru.a799000.android.weighcalculator2.repository.realm.init;

import com.arellomobile.mvp.presenter.InjectPresenter;

import io.realm.RealmResults;
import ru.a799000.android.weighcalculator2.mvp.model.intities.Barcode;
import ru.a799000.android.weighcalculator2.mvp.model.intities.Product;
import ru.a799000.android.weighcalculator2.repository.realm.repository.IBarcodeRepository;
import ru.a799000.android.weighcalculator2.repository.realm.repository.IProductRepository;
import ru.a799000.android.weighcalculator2.repository.realm.repository.impl.BarcodeRepository;
import ru.a799000.android.weighcalculator2.repository.realm.repository.impl.ProductRepository;

/**
 * Created by Alex on 23.05.2017.
 */

public class TestFill {



    public static void tillBarcode(long idProduct){

        IBarcodeRepository.OnSaveBarcodeCallback callbackAdd = new IBarcodeRepository.OnSaveBarcodeCallback() {
            @Override
            public void onSuccess(long id) {

            }

            @Override
            public void onError(String message) {

            }
        };



        IBarcodeRepository barcodeRepository = new BarcodeRepository();


        Barcode barcode = new Barcode();
        barcode.setBarcode("77777777777777777");
        barcode.setWeight(Float.parseFloat("25.6"));
        barcode.setPlaces(5);
        barcodeRepository.saveBarcodeByProduct(barcode,idProduct,callbackAdd);


        barcode = new Barcode();
        barcode.setBarcode("9999999999999999999");
        barcode.setWeight(Float.parseFloat("16.6"));
        barcode.setPlaces(4);
        barcodeRepository.saveBarcodeByProduct(barcode,idProduct,callbackAdd);

        barcode = new Barcode();
        barcode.setBarcode("222222222222222222222222");
        barcode.setWeight(Float.parseFloat("33.3"));
        barcode.setPlaces(8);
        barcodeRepository.saveBarcodeByProduct(barcode,idProduct,callbackAdd);


    }


    public static void tillProduct(){

        IProductRepository.OnAddProductCallback callbackAddProduct = new IProductRepository.OnAddProductCallback() {
            @Override
            public void onSuccess(long id) {
                tillBarcode(id);
            }

            @Override
            public void onError(String message) {

            }
        };

        IProductRepository productRepository = new ProductRepository();





        Product product = new Product();

        product.setName("Свинина на кости");
        product.setInitBarcode("22222222222222222222");
        product.setStart(2);
        product.setStart(5);
        product.setCoef(Float.parseFloat("0.01"));
        productRepository.saveProduct(product,callbackAddProduct);

        product = new Product();
        product.setName("Говядина на кости");
        product.setInitBarcode("33333333333333333333333");
        product.setStart(6);
        product.setStart(7);
        product.setCoef(Float.parseFloat("0.1"));
        productRepository.saveProduct(product,callbackAddProduct);

        product = new Product();
        product.setName("Курица на кости");
        product.setInitBarcode("88888888888888");
        product.setStart(3);
        product.setStart(6);
        product.setCoef(Float.parseFloat("0.01"));
        productRepository.saveProduct(product,callbackAddProduct); ;


    }
}
