package ru.a799000.android.weighcalculator2.ui.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import ru.a799000.android.weighcalculator2.R;
import ru.a799000.android.weighcalculator2.mvp.model.intities.Product;


public class AdapterListProduct extends RecyclerView.Adapter<AdapterListProduct.ViewHolder> implements RealmChangeListener {

    private final RealmResults<Product> mList;

    private CallBackClickItem mCallBackClickItem;


    public AdapterListProduct(RealmResults<Product> list, CallBackClickItem CallBackClickItem) {
        mList = list;
        mCallBackClickItem = CallBackClickItem;
        mList.addChangeListener(this);
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int i) {
        holder.setItem((Product) mList.get(i));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    @Override
    public void onChange(Object element) {
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.tv_name)
        TextView tvName;

        @BindView(R.id.tv_weight)
        TextView tvWeight;

        @BindView(R.id.tv_sites)
        TextView tvSites;

        Product mItem;


        public void setItem(Product item) {
            mItem = item;

            tvName.setText(mItem.getName());
            //tvWeight.setText(mItem.get);
            //tvSites.setText(mItem.getSites());
        }

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, itemView);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mCallBackClickItem.click(Long.toString(mItem.getId()));
        }
    }

    public interface CallBackClickItem {
        void click(String id);
    }

}
