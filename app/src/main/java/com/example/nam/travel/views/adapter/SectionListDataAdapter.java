package com.example.nam.travel.views.adapter;

/**
 * Created by Nam on 10/14/2018.
 */

import android.app.Activity;
import android.content.Context;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nam.travel.R;
import com.example.nam.travel.api.ApiImageClient;
import com.example.nam.travel.api.ApiImageInterface;
import com.example.nam.travel.models.SingleItemModel;

import com.example.nam.travel.models.locationOfPlaceCategory.LocationForType;
import com.squareup.picasso.Picasso;


import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

import static android.support.v4.content.ContextCompat.startActivity;

public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.SingleItemRowHolder>{

    private List<LocationForType> itemModels;
    private Context mContext;

    public SectionListDataAdapter(List<LocationForType> itemModels, Context mContext) {
        this.itemModels = itemModels;
        this.mContext = mContext;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_place_type, null);
        SingleItemRowHolder singleItemRowHolder = new SingleItemRowHolder(v);
        return singleItemRowHolder;
    }

    @Override
    public void onBindViewHolder(final SingleItemRowHolder holder, int position) {
        LocationForType itemModel = itemModels.get(position);

        holder.tvDetail.setText(itemModel.getIntroduction());
        holder.tvTitle.setText(itemModel.getName());

        Picasso.with(mContext).load("https://travellingrecommend.herokuapp.com/image/sun.jpg").into(holder.itemImage);


//        ApiImageInterface retrofitImageAPI = ApiImageClient.getImageClient().create(ApiImageInterface.class);
//        Call<ResponseBody> call;
//        if (itemModel.getPictureList().size() > 0) {
//            String imageName = itemModel.getPictureList().get(0).getImage();
//            call = retrofitImageAPI.getImageDetails(imageName);
//        } else {
//            call = retrofitImageAPI.getImageDetails("default_avatar.png");
//        }
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
//                if (response.isSuccessful()) {
//                    if (response.body() != null) {
//                        Bitmap bitmap = BitmapFactory.decodeStream(response.body().byteStream());
//                        holder.itemImage.setImageBitmap(bitmap);
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return (null != itemModels ? itemModels.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView tvTitle;
        protected ImageView itemImage;
        protected TextView tvDetail;

        public SingleItemRowHolder(View itemView) {
            super(itemView);
            this.tvTitle = itemView.findViewById(R.id.tvTitle);
            this.itemImage = itemView.findViewById(R.id.itemImage);
            this.tvDetail = itemView.findViewById(R.id.tvDetail);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Toast.makeText(view.getContegxt(), tvTitle.getText(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContext, DetailLocationActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }
    }

}
