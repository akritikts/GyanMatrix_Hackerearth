package in.silive.hackerearthgyanmatrix.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

import in.silive.hackerearthgyanmatrix.R;

public class BatsmenDetail extends AppCompatActivity {
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batsmen_detail);
        String s = getIntent().getStringExtra("ITEM");

        back = (Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BatsmenDetail.this,MainActivity.class);
                startActivity(i);
            }
        });


    }
}
