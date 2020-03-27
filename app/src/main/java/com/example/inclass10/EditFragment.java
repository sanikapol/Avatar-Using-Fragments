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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class EditFragment extends Fragment {

    private iEditFragmentOps mContext;

    private EditText et_fname, et_lname;
    private Button btn_save;
    private ImageView iv_avatar;
    private String gender = "";
    private TextView tv_selectAvatar;

    public EditFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = (iEditFragmentOps) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit, container, false);
        btn_save = view.findViewById(R.id.btn_save);
        iv_avatar = view.findViewById(R.id.iv_edit_avatar);
        et_fname = view.findViewById(R.id.et_edit_fname);
        et_lname = view.findViewById(R.id.et_edit_lname);
        tv_selectAvatar = view.findViewById(R.id.tv_selectAvatar);

        iv_avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startSelectAvatar();
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_fname.getText().toString().trim().equals("") ){
                    Toast.makeText(getActivity(), "First name cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else if((et_lname.getText().toString().trim().equals(""))){
                    Toast.makeText(getActivity(), "Last name cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else if(gender.equals("")){
                    tv_selectAvatar.setText("Please Select Avatar");
                }
                else{
                    User user = new User();
                    user.setFname(et_fname.getText().toString());
                    user.setLname(et_lname.getText().toString());
                    if(gender.equals("female")) user.setGender("female");
                    else user.setGender("male");
                    mContext.sendData(user);
                    mContext.startDisplayProfile();
                }

            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(gender == "female"){
            iv_avatar.setImageResource(R.drawable.female);
        }
        else if(gender == "male"){
            iv_avatar.setImageResource(R.drawable.male);
        }
    }

    public void setAvatar(String gender){
        this.gender = gender;
    }


    public interface iEditFragmentOps {
        // TODO: Update argument type and name
        void startSelectAvatar();
        void startDisplayProfile();
        void sendData(User user);
    }
}
