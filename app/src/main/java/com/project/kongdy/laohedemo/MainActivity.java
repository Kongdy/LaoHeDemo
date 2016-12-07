package com.project.kongdy.laohedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;
import com.rey.material.widget.Button;
import com.rey.material.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        Spinner.OnItemSelectedListener{

    private MaterialEditText me_input;
    private Spinner sp_toast_time;
    private Button btn_show;

    private int toast_time_length = Toast.LENGTH_SHORT;

    private final static String[] TOAST_TIME_LENGTH_ARRAY = new String[]{
       "短",  "长"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        me_input = (MaterialEditText) findViewById(R.id.me_input);
        sp_toast_time = (Spinner) findViewById(R.id.sp_toast_time);
        btn_show = (Button) findViewById(R.id.btn_show);

        ArrayAdapter<String> bloodTypeAdapter = new ArrayAdapter<>(this,R.layout.row_spn,
                TOAST_TIME_LENGTH_ARRAY);
        bloodTypeAdapter.setDropDownViewResource(R.layout.row_spn_dropdown);
        sp_toast_time.setAdapter(bloodTypeAdapter);
        sp_toast_time.setOnItemSelectedListener(this);

        btn_show.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String text = String.valueOf(me_input.getText());
        if(!TextUtils.isEmpty(text)) {
            Toast.makeText(this,text,toast_time_length).show();
            me_input.setText("");
        }
    }

    @Override
    public void onItemSelected(Spinner parent, View view, int position, long id) {
        toast_time_length = position;
    }
}
