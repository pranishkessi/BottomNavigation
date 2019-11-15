package com.si.bottomnavigation.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.si.bottomnavigation.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = root.findViewById(R.id.recycle);

        List<HomeViewModel> students = new ArrayList<>();
        HomeViewModel home = new HomeViewModel("Samyam Dabadi","21","Naikap","male");

        students = home.getSlist();

        if(students.isEmpty()) {
            students.add(home);
            students.add(new HomeViewModel("Abhishek Dhakal", "20", "London", "female"));
        }


        home.setSlist(students);

        HomeAdapter homeAdapter = new HomeAdapter(students,getActivity());
        recyclerView.setAdapter(homeAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return root;
    }
}