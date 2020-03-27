//Assignment Inclass 10
//File Name: Group12_InClass10
//Sanika Pol
//Snehal Kekane

package com.example.inclass10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements EditFragment.iEditFragmentOps,SelectFragment.ToEditFromSelectAvatar,DisplayFragment.iDisplayFragmentOps{
    User user = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container,new EditFragment(),"edit")
                .commit();
    }

    @Override
    public void startSelectAvatar() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container,new SelectFragment(),"selectAvatar")
                .addToBackStack(null)
                .commit();
    }


    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount() > 0){
            getSupportFragmentManager().popBackStack();
        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    public void updateEdit(String gender) {
        getSupportFragmentManager().popBackStack();
        EditFragment ef = (EditFragment) getSupportFragmentManager().findFragmentByTag("edit");
        if(gender.equals("female"))ef.setAvatar("female");
        else ef.setAvatar("male");
    }

    @Override
    public void startDisplayProfile() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container,new DisplayFragment(),"display")
                .commit();
    }

    @Override
    public void sendData(User user) {
        this.user = user;
    }

    @Override
    public User receiveData() {
        return user;
    }

    @Override
    public void stopFrag() {
        if(getSupportFragmentManager().getBackStackEntryCount() > 0){
            getSupportFragmentManager().popBackStack();
        }
        else{
            super.onBackPressed();
        }
    }
}
