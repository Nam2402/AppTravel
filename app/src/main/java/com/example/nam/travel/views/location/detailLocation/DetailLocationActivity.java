package com.example.nam.travel.views.location.detailLocation;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nam.travel.R;
import com.example.nam.travel.api.ApiClient;
import com.example.nam.travel.api.ApiImageClient;
import com.example.nam.travel.models.location.LocationProfile;
import com.example.nam.travel.models.review.Review;
import com.example.nam.travel.models.review.ReviewPagination;
import com.example.nam.travel.presenters.detailLocation.DetailLocationPresenter;
import com.example.nam.travel.presenters.review.ReviewPresenter;
import com.example.nam.travel.views.adapter.PictureAdapter;
import com.example.nam.travel.views.adapter.ReviewAdapter;
import com.example.nam.travel.views.note.NoteActivity;
import com.example.nam.travel.views.review.CommentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DetailLocationActivity extends AppCompatActivity implements View.OnClickListener, MenuItem.OnMenuItemClickListener,OnMapReadyCallback, IDetailLocationActivity{
    private Long idLocation;
    private ImageView btnLike, btnComment, btnNote, pictureTop;
    private DetailLocationPresenter detailLocationPresenter;
    private ImageView showMenu;
    private LocationProfile locationProfile;
    private RecyclerView recyclerViewPicture, recyclerViewReview;
    private TextView locationName, count, txtAddress, txtDetailLocation, txtLoadMore;
    private GoogleMap mMap;
    private RatingBar ratingBar;
    private List<Review> listReview;
    private ReviewPresenter reviewPresenter;
    private ReviewAdapter reviewAdapter;
    private int crrPage, sumPage;
    private ProgressBar pbLoadMore;
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_location);
        Intent intent = getIntent();
        idLocation = intent.getLongExtra("idLocation", 0L);

        mapped();

        txtLoadMore.setOnClickListener(this);
        btnLike.setOnClickListener(this);
        btnComment.setOnClickListener(this);
        btnNote.setOnClickListener(this);
        showMenu.setOnClickListener(this);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    public void mapped() {
        showMenu = (ImageView) findViewById(R.id.show_dropdown_menu);
        btnLike = findViewById(R.id.btn_like);
        btnComment = findViewById(R.id.btn_comment);
        btnNote = findViewById(R.id.btn_note);
        pictureTop = findViewById(R.id.toppicture);
        locationName = findViewById(R.id.location_name);
        ratingBar = findViewById(R.id.ratingBar);
        count = findViewById(R.id.count);
        txtAddress = findViewById(R.id.tv_address);
        txtDetailLocation = findViewById(R.id.tv_detail_location);
        txtLoadMore = findViewById(R.id.tv_load_more);
        pbLoadMore = findViewById(R.id.pb_load_more);
        pbLoadMore.getIndeterminateDrawable().setColorFilter(Color.GRAY, android.graphics.PorterDuff.Mode.MULTIPLY);

        recyclerViewPicture = (RecyclerView)findViewById(R.id.recycler_view_list_picture);
        recyclerViewPicture.setLayoutManager(new LinearLayoutManager(this));

        recyclerViewReview = findViewById(R.id.recycler_view_review);
        recyclerViewPicture.setLayoutManager(new LinearLayoutManager(this));

        detailLocationPresenter = new DetailLocationPresenter(this);
        detailLocationPresenter.getDetailLocation(idLocation);
        reviewPresenter = new ReviewPresenter(this);

    }

    public float getRating(BigDecimal sumRating, long numRating) {
        if(numRating == 0) return 0f;
        return sumRating.floatValue() / numRating;
    }

    public void onClick(View view)
    {
        switch (view.getId()) {
            case R.id.btn_comment:
                Intent intent = new Intent(DetailLocationActivity.this, CommentActivity.class);
                intent.putExtra("idLocation", idLocation);
                startActivity(intent);
                break;
            case R.id.btn_note:
                intent = new Intent(DetailLocationActivity.this, NoteActivity.class);
                intent.putExtra("idLocation", idLocation);
                startActivity(intent);
                break;
            case R.id.btn_like:
                detailLocationPresenter.favoriteLocation(idLocation);
                break;
            case R.id.tv_load_more:
                reviewPresenter.getMoreReview(locationProfile.getId(), crrPage + 1);
                txtLoadMore.setVisibility(View.GONE);
                pbLoadMore.setVisibility(View.VISIBLE);
                break;
            case R.id.show_dropdown_menu:
                PopupMenu dropDownMenu = new PopupMenu(getApplicationContext(), showMenu);
                dropDownMenu.getMenuInflater().inflate(R.menu.drop_down_menu, dropDownMenu.getMenu());
                dropDownMenu.getMenu().getItem(0).setTitle(locationProfile.getPhone());
                dropDownMenu.getMenu().getItem(1).setTitle(locationProfile.getAddress());
//                showMenu.setText("DropDown Menu");
//                dropDownMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//
//                    @Override
//                    public boolean onMenuItemClick(MenuItem menuItem) {
//                        Toast.makeText(getApplicationContext(), "You have clicked " + menuItem.getTitle(), Toast.LENGTH_LONG).show();
//                        return true;
//                    }
//                });
                dropDownMenu.show();
                break;
        }
    }

    public void setColorForBtnFavorite() {
        if(locationProfile.isFavorite()) {
            btnLike.setImageResource(R.drawable.ic_favorite_border_red_24dp);
        } else {
            btnLike.setImageResource(R.drawable.ic_favorite_border_black_24dp);
        }
    }

    @Override
    public void favoriteLocationFailure() {
        Toast.makeText(getBaseContext(), "Favorite Location Failure", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void favoriteLocationSuccess() {
        locationProfile.setFavorite(!locationProfile.isFavorite());
        setColorForBtnFavorite();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if(locationProfile != null) {
            mMap = googleMap;
            mMap.setMinZoomPreference(12);
            LatLng ny = new LatLng(locationProfile.getLatitude(), locationProfile.getLongitude());
            mMap.moveCamera(CameraUpdateFactory.newLatLng(ny));
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }

    @Override
    public void getDetailLocationSuccess(LocationProfile locationProfile) {
        this.locationProfile = locationProfile;
        locationName.setText(locationProfile.getName());
        String urlImage;

        if(this.locationProfile.getPictureList().size() > 0) {
            urlImage = locationProfile.getPictureList().get(0).getImage();
            urlImage = ApiClient.BASE_URL + "/downloadFile/" + urlImage;
        } else
        {
            urlImage = ApiImageClient.URL_IMAGE_DEFAULT;
        }

        float rating = getRating(locationProfile.getSumRating(),locationProfile.getNumRating());
        ratingBar.setRating(rating);
        count.setText("" + locationProfile.getNumRating() + " đánh giá");

        setColorForBtnFavorite();
        txtAddress.setText(locationProfile.getAddress());
        txtDetailLocation.setText(locationProfile.getContent());

//        locationProfile.setLatitude(16.061482);
//        locationProfile.setLongitude(108.223197);


        LatLng sydney = new LatLng(locationProfile.getLatitude(), locationProfile.getLongitude());

        mMap.setMinZoomPreference(14);
        mMap.addMarker(new MarkerOptions().position(sydney).title(locationProfile.getName()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        Picasso.with(this).load(urlImage).into(pictureTop);
        recyclerViewPicture.setHasFixedSize(true);
        PictureAdapter pictureAdapter = new PictureAdapter(this.locationProfile.getPictureList(), this);

        recyclerViewPicture.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewPicture.setAdapter(pictureAdapter);

        //fakeDataReview();
        recyclerViewReview.setHasFixedSize(true);
        this.listReview = this.locationProfile.getEvaluationPaginationDTO().getListEvaluation();
        this.crrPage = this.locationProfile.getEvaluationPaginationDTO().getCrrPage();
        this.sumPage = this.locationProfile.getEvaluationPaginationDTO().getSumPage();

        System.out.println("Crr Page : " + crrPage + " SUM PAGE : " + sumPage + " ID : " + locationProfile.getId());
        if(crrPage >= sumPage) {
            txtLoadMore.setVisibility(View.GONE);
        }

        reviewAdapter = new ReviewAdapter(this.listReview, this);

        recyclerViewReview.setLayoutManager( new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerViewReview.setAdapter(reviewAdapter);
        initCollapsingToolbar();

    }
    private void initCollapsingToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String name = locationProfile.getName();
        setTitle(name);
        //Display back home button
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void getDetailLocationFailure() {
        Toast.makeText(getBaseContext(), "Get Location Failure", Toast.LENGTH_SHORT).show();
    }


    public void fakeDataReview() {
        List<Review> listReview = new ArrayList<>();
        listReview.add(new Review("User 01", "Địa điêm thú vị, sẽ đến tham quan lần nữa nếu có dịp", 4L, new Date()));
        listReview.add(new Review("User 01", "Địa điêm thú vị, sẽ đến tham quan lần nữa nếu có dịp", 4L, new Date()));
        ReviewPagination reviewPagination = new ReviewPagination();
        reviewPagination.setCrrPage(1);
        reviewPagination.setListEvaluation(listReview);
        reviewPagination.setSumPage(1);
        locationProfile.setEvaluationPaginationDTO(reviewPagination);
    }

//    static class LoadingViewHolder extends RecyclerView.ViewHolder {
//        public ProgressBar progressBar;
//        public LoadingViewHolder(View itemView) {
//            super(itemView);
//            progressBar = (ProgressBar) itemView.findViewById(R.id.pb_load_more);
//        }
//    }
    @Override
    public void getLoadMoreReviewSuccess(ReviewPagination reviewPagination) {
        this.listReview.addAll(reviewPagination.getListEvaluation());
        this.crrPage = reviewPagination.getCrrPage();
        this.sumPage = reviewPagination.getSumPage();
        pbLoadMore.setVisibility(View.GONE);
        reviewAdapter.notifyDataSetChanged();
        if(crrPage >= sumPage) {
            txtLoadMore.setVisibility(View.GONE);
        } else {
            txtLoadMore.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void getLoadMoreReviewFailure() {
        Toast.makeText(getBaseContext(), "Get Location Failure", Toast.LENGTH_SHORT).show();
        pbLoadMore.setVisibility(View.GONE);
    }
}