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

    private EditText etName,etAge,etAddress;
    private Button btnSave;
    private RadioButton rbmale,rbfemale;
    RadioGroup radioGroup;
    private TextView tvGender;
   // private ImageView imageView;
    private RecyclerView studenRecyclerView;

    static List<Students> studentsList=new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_student, container, false);

        etName = root.findViewById(R.id.etName);
        etAge = root.findViewById(R.id.etAge);
        etAddress = root.findViewById(R.id.etAddress);
        btnSave = root.findViewById(R.id.btnSave);
        rbmale = root.findViewById(R.id.rbmale);
        rbfemale = root.findViewById(R.id.rbfemale);
        tvGender= root.findViewById(R.id.tvGender);
        radioGroup= root.findViewById(R.id.radioGroup);
        //imageView = root.findViewById(R.id.imageView);
        studenRecyclerView=root.findViewById(R.id.studentRecycler);

         final List<Students> studentsList = new ArrayList<>();



btnSave.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String name,address,gender,age;
       // int image;

        name=etName.getText().toString();
        address=etAddress.getText().toString();
        age=etAge.getText().toString();
      //  image=Integer.parseInt(imageView.getTransitionName());

        //gender=etName.getText().toString();


            int selectGender=radioGroup.getCheckedRadioButtonId();
            RadioButton radioButton=root.findViewById(selectGender);
            gender=radioButton.getText().toString();

         /*   if (rbmale.isChecked()) {
                //ImageView imageView=(ImageView) findViewById(R.id.imageView);
                tvGender.setText("Male");
                imageView.setImageResource(R.drawable.ic_person_black_24dp);
            } else if (rbfemale.isChecked()) {
                tvGender.setText("Female");
                imageView.setImageResource(R.drawable.ic_adb_black_24dp);
            }
        }*/

         Students students=new Students(name,age,address,gender);
         studentsList=students.getStudentsList();
         studentsList.add(students);
         students.setStudentsList(studentsList);
            Toast.makeText(getActivity(), "Save Successful", Toast.LENGTH_SHORT).show();


          //  Toast.makeText(StudentFragment.this, "The Data is Saved", Toast.LENGTH_SHORT).show();
        }



});




        return root;
    }
}