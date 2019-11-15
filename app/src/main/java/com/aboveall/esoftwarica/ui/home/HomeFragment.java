package com.aboveall.esoftwarica.ui.home;

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

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aboveall.esoftwarica.R;
import com.aboveall.esoftwarica.adapter.StudentAdapter;
import com.aboveall.esoftwarica.ui.student.Students;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

   
    private RecyclerView recyclerView;
    static List<Students> studentsList=new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        
        recyclerView=root.findViewById(R.id.studentRecycler);
        
        Students students=new Students("1","a","a","Male");
        
        studentsList= students.getStudentsList();
        if(studentsList.isEmpty()) {
            studentsList.add(new Students("Nischal", "12", "asdf", "Male"));
            studentsList.add(new Students("Rachal", "11", "asdf", "Female"));
            students.setStudentsList(studentsList);
        }

        StudentAdapter studentAdapter = new StudentAdapter(getActivity(),studentsList);
        recyclerView.setAdapter(studentAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return root;
    }
}