package com.gto.bang.register;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.gto.bang.R;
import com.gto.bang.base.BaseActivity;

public class RegisterActivity extends BaseActivity {

    private Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_register);
        initViews();
    }

    public void initViews(){

        register=(Button)findViewById(R.id.f_register_ok_btn);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(RegisterActivity.this, "登录", Toast.LENGTH_SHORT);
                t.show();
            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
