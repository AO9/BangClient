package com.gto.bang.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.gto.bang.R;
import com.gto.bang.base.BaseActivity;
import com.gto.bang.home.HMainActivity;
import com.gto.bang.register.RegisterActivity;

public class LoginActivity extends BaseActivity {

    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setNavigationMode(android.support.v7.app.ActionBar.NAVIGATION_MODE_STANDARD);
        setContentView(R.layout.bang_login);
        initViews();
    }

    public void initViews(){

        login=(Button)findViewById(R.id.home_login_btn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this, HMainActivity.class);
                startActivity(intent);
                Toast t = Toast.makeText(LoginActivity.this, "登录", Toast.LENGTH_SHORT);
                t.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.register, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent;
        switch (id) {
            case R.id.action_register:
                intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                return true;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
