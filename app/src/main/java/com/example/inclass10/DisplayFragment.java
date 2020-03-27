//Assignment Inclass 10
//File Name: Group12_InClass10
//Sanika Pol
//Snehal Kekane
package com.example.inclass10;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class DisplayFragment extends Fragment {


    public DisplayFragment() {
        // Required empty public constructor
    }

    ImageView iv_dispAvatar;
    TextView tv_name,tv_gender;
    Button btn_edit;
    User user = null;

    iDisplayFragmentOps mcontext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mcontext = (iDisplayFragmentOps) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_display, container, false);
        iv_dispAvatar = view.findViewById(R.id.iv_dispAvatar);
        tv_name = view.findViewById(R.id.tv_name);
        tv_gender = view.findViewById(R.id.tv_gender);
        btn_edit = view.findViewById(R.id.btn_Edit);
        user = mcontext.receiveData();
        tv_name.setText(user.getFname() + " " + user.getLname());
        if(user.getGender().equals("female")) tv_gender.setText("Female");
        else tv_gender.setText("Male");
        if(user.getGender().equals("female")) iv_dispAvatar.setImageResource(R.drawable.female);
        else iv_dispAvatar.setImageResource(R.drawable.male);

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mcontext.stopFrag();

            }
        });

        return view;
    }


    public interface iDisplayFragmentOps{
        User receiveData();
        void stopFrag();
    }

}
