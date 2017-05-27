package ru.a799000.android.weighcalculator2.ui.activitys;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.RealmResults;
import ru.a799000.android.weighcalculator2.R;
import ru.a799000.android.weighcalculator2.mvp.model.intities.Product;
import ru.a799000.android.weighcalculator2.mvp.presenters.MainActivityPresenter;
import ru.a799000.android.weighcalculator2.mvp.view.MainActivityView;
import ru.a799000.android.weighcalculator2.repository.realm.init.TestFill;
import ru.a799000.android.weighcalculator2.repository.realm.repository.IProductRepository;
import ru.a799000.android.weighcalculator2.repository.realm.repository.impl.ProductRepository;
import ru.a799000.android.weighcalculator2.ui.adapters.AdapterListProduct;

public class MainActivity extends MvpAppCompatActivity
        implements MainActivityView, NavigationView.OnNavigationItemSelectedListener {


    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;


    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @InjectPresenter
    MainActivityPresenter mPresenter;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();

    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.onStart();
        mRecyclerView.setAdapter(new AdapterListProduct(mPresenter.getProducts(), id -> mPresenter.clickItem(id)));
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.onStop();
    }

    void init(){
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //*********************************************************************************************
    // EVRNTS

    @OnClick(R.id.fab)
    public void onClickFab(){

//        TestFill.tillProduct();
//
//        IProductRepository productRepository = new ProductRepository();
//        productRepository.getAllProduct(new IProductRepository.OnGetAllProductCallback() {
//            @Override
//            public void onSuccess(RealmResults<Product> products) {
//                Snackbar.make(fab, "Товаров: " + products.size(), Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//
//            @Override
//            public void onError(String message) {
//
//            }
//        });

        mPresenter.addProdact();

    }

    @Override
    public void startDetailProductActivityView(String id) {
        startActivity(ProdactDetailActivity.getIntent(this,id));
    }
}
