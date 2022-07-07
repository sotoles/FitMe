package com.group5.fitme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class nextpage extends AppCompatActivity implements View.OnClickListener {

    DrawerLayout drawerLayout;
    public TextView ce, ms, me, bc, fx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nextpage);

        ce = (TextView) findViewById (R.id.ce);
        ms = (TextView) findViewById (R.id.ms);
        me = (TextView) findViewById (R.id.me);
        bc = (TextView) findViewById (R.id.bc);
        fx = (TextView) findViewById (R.id.fx);


        ce.setOnClickListener(this);
        ms.setOnClickListener(this);
        me.setOnClickListener(this);
        bc.setOnClickListener(this);
        fx.setOnClickListener(this);

        drawerLayout = findViewById(R.id.drawer_layout);
    }
    public void ClickMenu(View view){
        openDrawer(drawerLayout);}

    public static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);}

    public void ClickLogo(View view){
        closeDrawer(drawerLayout);}

    public static void closeDrawer(DrawerLayout drawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);}}

    public void ClickBMI(View view){
        Intent intent = new Intent(getApplicationContext(), MyBMI.class);
        startActivity(intent);}
    public void ClickLogout(View view){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        Toast.makeText(nextpage.this, "Logged out Successfully!", Toast.LENGTH_SHORT).show();}
    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.ce:
                i = new Intent(this,cardview.class);
                startActivity(i);
                break;
            case R.id.ms:
                i = new Intent(this,card2.class);
                startActivity(i);
                break;
            case R.id.me:
                i = new Intent(this,card3.class);
                startActivity(i);
                break;
            case R.id.bc:
                i = new Intent(this,card4.class);
                startActivity(i);
                break;
            case R.id.fx:
                i = new Intent(this,card5.class);
                startActivity(i);
                break;
        }

    }
}