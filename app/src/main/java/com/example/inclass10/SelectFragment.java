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
import android.widget.ImageView;


public class SelectFragment extends Fragment {


    private ToEditFromSelectAvatar context;

    private ImageView iv_female,iv_male;

    public SelectFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = (ToEditFromSelectAvatar) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_select, container, false);
        iv_female = view.findViewById(R.id.iv_female);
        iv_male = view.findViewById(R.id.iv_male);

        iv_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.updateEdit("female");
            }
        });

        iv_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.updateEdit("male");
            }
        });

        return view;
    }



    public interface ToEditFromSelectAvatar {
        // TODO: Update argument type and name
        void updateEdit(String gender);
    }
}
