package com.aboveall.esoftwarica.ui.student;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aboveall.esoftwarica.MainActivity;
import com.aboveall.esoftwarica.R;
import com.aboveall.esoftwarica.adapter.StudentAdapter;
import com.aboveall.esoftwarica.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class StudentFragment extends Fragment {

    private EditText etName,etAge,etAddress;
    private Button btnSave;
    private RadioButton rbmale,rbfemale;
    private ImageView imageView;
    private RecyclerView studenRecyclerView;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_student, container, false);

        etName = root.findViewById(R.id.etName);
        etAge = root.findViewById(R.id.etAge);
        etAddress = root.findViewById(R.id.etAddress);
        btnSave = root.findViewById(R.id.btnSave);
        rbmale = root.findViewById(R.id.rbmale);
        rbfemale = root.findViewById(R.id.rbfemale);
        imageView = root.findViewById(R.id.imageView);
        studenRecyclerView=root.findViewById(R.id.studentRecycler);

        List<Students> studentsList=new ArrayList<>();
        studentsList.add(new Students("Nischal","12","asdf","male"));

        StudentAdapter studentAdapter=new StudentAdapter(this,studentsList);

        studenRecyclerView.setAdapter(studentAdapter);
        studenRecyclerView.setLayoutManager(new LinearLayoutManager());

btnSave.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String name,address,gender,age;
        int image;

        name=etName.getText().toString();
        address=etAddress.getText().toString();
        age=etAge.getText().toString();

        //gender=etName.getText().toString();

        if (v.getId()==R.id.btnSave){

           if (rbmale.isChecked()){
               //ImageView imageView=(ImageView) findViewById(R.id.imageView);
               imageView.setImageResource(R.drawable.ic_person_black_24dp);
           }else{
               imageView.setImageResource(R.drawable.ic_adb_black_24dp);
           }


          //  Toast.makeText(StudentFragment.this, "The Data is Saved", Toast.LENGTH_SHORT).show();
        }


    }
});



        return root;
    }
}