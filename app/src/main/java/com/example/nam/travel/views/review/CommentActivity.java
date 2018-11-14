package com.example.nam.travel.views.review;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.nam.travel.R;
import com.example.nam.travel.models.review.ReviewDTO;
import com.example.nam.travel.models.review.ReviewRequest;
import com.example.nam.travel.presenters.review.AddReviewPresenter;
import com.example.nam.travel.presenters.review.IAddReviewPresenter;

public class CommentActivity extends AppCompatActivity implements View.OnClickListener, ICommentActivity{
    private IAddReviewPresenter iAddReviewPresenter;
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private RatingBar ratingBar;
    private EditText edReview;
    private boolean isUpdate = false;
    private Button btReview;
    private Long idLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        Intent intent = getIntent();
        idLocation = intent.getLongExtra("idLocation", 1L);
        initCollapsingToolbar();
        mapped();
        btReview.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_review :
                long rating = (long) Math.round(ratingBar.getRating());
                String comment = edReview.getText().toString();
                ReviewRequest reviewRequest = new ReviewRequest(idLocation, rating, comment);
                if(isUpdate) {
                    iAddReviewPresenter.editReview(reviewRequest);
                } else {
                    iAddReviewPresenter.addReview(reviewRequest);
                }
                break;
        }
    }

    private void mapped() {
        ratingBar = findViewById(R.id.ratingBar);
        edReview = findViewById(R.id.et_review);
        btReview = findViewById(R.id.btn_review);
        iAddReviewPresenter = new AddReviewPresenter(this);
        iAddReviewPresenter.getReview(idLocation);
    }

    private void initCollapsingToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Đánh giá");
        //Display back home button
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void getReviewSuccess(ReviewDTO reviewDTO) {
        if(reviewDTO != null) {
            ratingBar.setRating(reviewDTO.getScore());
            edReview.setText(reviewDTO.getContent());
            isUpdate = true;
            btReview.setText("Cập nhật");
        } else {
            Toast.makeText(getBaseContext(), "DO NOTHING", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void getReviewFailure() {

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
    public void addReviewSuccess() {
        onBackPressed();
    }

    @Override
    public void addReviewFailure() {
        Toast.makeText(getBaseContext(), "add Review Failure", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void editReviewSuccess(){
        onBackPressed();
    }

    @Override
    public void editReviewFailure(){
        Toast.makeText(getBaseContext(), "edit Review Failure", Toast.LENGTH_SHORT).show();
    }
}
