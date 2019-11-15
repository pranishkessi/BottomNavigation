package com.si.bottomnavigation.ui.add_student;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

import com.si.bottomnavigation.R;
import com.si.bottomnavigation.ui.home.HomeAdapter;
import com.si.bottomnavigation.ui.home.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

public class StudentsFragment extends Fragment {

    EditText name, age, address;
    RadioGroup gender;
    Button save;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_students, container, false);
        name = root.findViewById(R.id.etname);
        age = root.findViewById(R.id.etage);
        address = root.findViewById(R.id.etaddress);
        gender = root.findViewById(R.id.gender);
        save = root.findViewById(R.id.btnadd);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sname="",sage="",saddress="",sgender="";

                if(!TextUtils.isEmpty(name.getText().toString())) {
                    sname = name.getText().toString();

                    if(!TextUtils.isEmpty(address.getText().toString())){
                        saddress = address.getText().toString();

                        if(!TextUtils.isEmpty((age.getText().toString()))){
                            sage = age.getText().toString();

                            int selected = gender.getCheckedRadioButtonId();
                            if(selected>0){
                                final RadioButton radioButton = getView().findViewById(selected);
                                sgender = radioButton.getText().toString();

                                List<HomeViewModel> students = new ArrayList<>();

                                HomeViewModel homeViewModel = new HomeViewModel(sname, sage, saddress, sgender);

                                students = homeViewModel.getSlist();
                                students.add(homeViewModel);
                                homeViewModel.setSlist(students);

                                name.setText("");
                                age.setText("");
                                address.setText("");
                                gender.clearCheck();
                                Toast.makeText(getContext(), "Data Successfully added", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(getActivity(), "Please Select Gender", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            age.setError("Please enter Student's age.");
                        }
                    }
                    else{
                        address.setError("Please enter Student's Address");
                        return;
                    }

                }
                else{
                    name.setError("Please enter Student's name");
                    return;
                }

            }
        });
        return root;
    }
}