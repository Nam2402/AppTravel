package com.example.nam.travel.views.location.detailLocation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.nam.travel.R;

public class DetailLocationActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView btnLike, btnComment, btnNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_location);

        btnLike = findViewById(R.id.btn_like);
        btnComment = findViewById(R.id.btn_comment);
        btnNote = findViewById(R.id.btn_note);

        btnLike.setOnClickListener(this);
        btnComment.setOnClickListener(this);
        btnNote.setOnClickListener(this);
    }
    public void onClick(View view)
    {
        switch (view.getId()) {
            case R.id.btn_comment:
                Intent intent = new Intent(DetailLocationActivity.this, CommentActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_note:
                intent = new Intent(DetailLocationActivity.this, NoteActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_like:
                btnLike.setImageResource(R.drawable.ic_favorite_border_red_24dp);
                break;
        }
    }


}
