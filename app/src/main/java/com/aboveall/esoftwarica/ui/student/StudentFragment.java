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
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aboveall.esoftwarica.BottomNav;
import com.aboveall.esoftwarica.MainActivity;
import com.aboveall.esoftwarica.R;
import com.aboveall.esoftwarica.adapter.StudentAdapter;
import com.aboveall.esoftwarica.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class StudentFragment extends Fragment {
    EditText etName,etAge,etAddress;
    Button btnSave;
    RadioButton rbmale,rbfemale;
    RadioGroup radioGroup;
    RecyclerView studentRecyclerView;

    static List<Students> studentsList =new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_student, container, false);

        etName = root.findViewById(R.id.etName);
        etAge = root.findViewById(R.id.etAge);
        etAddress = root.findViewById(R.id.etAddress);
        btnSave = root.findViewById(R.id.btnSave);
        rbmale = root.findViewById(R.id.rbmale);
        rbfemale = root.findViewById(R.id.rbfemale);
        radioGroup= root.findViewById(R.id.radioGroup);
        studentRecyclerView=root.findViewById(R.id.studentRecycler);
        final List<Students>[] studentsList = new List[]{new ArrayList<>()};

btnSave.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String name,address,gender,age;
        if (!etName.getText().toString().isEmpty()) {
            name = etName.getText().toString();
            if (!etAge.getText().toString().isEmpty()) {
                age = (etAge.getText().toString());
                if (!etAddress.getText().toString().isEmpty()) {
                    address = (etAddress.getText().toString());
                    try {
                        int selectGender = radioGroup.getCheckedRadioButtonId();
                        RadioButton radioButton = root.findViewById(selectGender);
                        gender = radioButton.getText().toString();

                        Students students = new Students(name, age, address, gender);
                        studentsList[0] =students.getStudentsList();
                        studentsList[0].add(students);
                        students.setStudentsList(studentsList[0]);
                        Toast.makeText(getActivity(), "Save Successful", Toast.LENGTH_SHORT).show();


                    } catch (Exception e) {
                        Toast.makeText(getActivity(), "error", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "Please Select address", Toast.LENGTH_SHORT).show();

                }
            } else {
                Toast.makeText(getActivity(), "Please Enter age", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getActivity(), "Please Enter name", Toast.LENGTH_SHORT).show();

        }

    }

});
        return root;
    }
}