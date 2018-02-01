package com.example.qklahpita.draw;

import android.content.DialogInterface;
import android.support.annotation.IdRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

public class DrawActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "DrawActivity";
    private ImageView ivColor;
    private ImageView ivDone;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);

        setupUI();
    }

    private void setupUI() {
        ivColor = findViewById(R.id.iv_color);
        ivDone = findViewById(R.id.iv_done);
        radioGroup = findViewById(R.id.gr_pen_size);
        radioGroup.check(R.id.rb_medium);

        ivColor.setOnClickListener(this);
        ivDone.setOnClickListener(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i) {
                    case R.id.rb_thin: {

                        break;
                    }
                    case R.id.rb_medium: {

                        break;
                    }
                    case R.id.rb_strong: {

                        break;
                    }
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_color: {
                ColorPickerDialogBuilder
                        .with(this)
                        .setTitle("Choose color")
                        .initialColor(ContextCompat.getColor(this, R.color.colorAccent))
                        .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                        .density(12)
                        .setOnColorSelectedListener(new OnColorSelectedListener() {
                            @Override
                            public void onColorSelected(int selectedColor) {

                            }
                        })
                        .setPositiveButton("Ok", new ColorPickerClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int selectedColor, Integer[] allColors) {

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .build()
                        .show();
                break;
            }
            case R.id.iv_done: {

                break;
            }
        }
    }
}
