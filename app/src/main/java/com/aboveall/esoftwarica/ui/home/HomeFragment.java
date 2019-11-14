package com.aboveall.esoftwarica.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.aboveall.esoftwarica.R;

public class HomeFragment extends Fragment {

    private TextView tvName,tvAge,tvAddress,tvGender;
    private Button btnDelete;
    private ImageView imageView;
   // private HomeViewModel homeViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
      //  homeViewModel =
        //        ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);

        tvName = root.findViewById(R.id.tvName);
        tvAge = root.findViewById(R.id.tvAge);
        tvAddress = root.findViewById(R.id.tvAddress);
        tvGender = root.findViewById(R.id.tvGender);
        btnDelete = root.findViewById(R.id.btnDelete);
        imageView = root.findViewById(R.id.imageView);




      /*  homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });*/
        return root;
    }
}