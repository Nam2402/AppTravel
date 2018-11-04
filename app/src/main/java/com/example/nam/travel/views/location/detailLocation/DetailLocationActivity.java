package com.example.nam.travel.views.location.detailLocation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.nam.travel.R;

public class DetailLocationActivity extends AppCompatActivity implements View.OnClickListener, MenuItem.OnMenuItemClickListener{
    private ImageView btnLike, btnComment, btnNote;
    ImageView showMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_location);

        showMenu = (ImageView) findViewById(R.id.show_dropdown_menu);
        btnLike = findViewById(R.id.btn_like);
        btnComment = findViewById(R.id.btn_comment);
        btnNote = findViewById(R.id.btn_note);

        btnLike.setOnClickListener(this);
        btnComment.setOnClickListener(this);
        btnNote.setOnClickListener(this);
        showMenu.setOnClickListener(this);

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

            case R.id.show_dropdown_menu:
                PopupMenu dropDownMenu = new PopupMenu(getApplicationContext(), showMenu);
                dropDownMenu.getMenuInflater().inflate(R.menu.drop_down_menu, dropDownMenu.getMenu());
//                showMenu.setText("DropDown Menu");
                dropDownMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Toast.makeText(getApplicationContext(), "You have clicked " + menuItem.getTitle(), Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
                dropDownMenu.show();
                break;
        }
    }


    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }
}
