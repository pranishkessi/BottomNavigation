package com.si.bottomnavigation.ui.home;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.si.bottomnavigation.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.StudentViewHolder> {
    List<HomeViewModel> students;
    Context mcontext;

    public HomeAdapter(List<HomeViewModel> students, Context mcontext) {
        this.students = students;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_students,parent,false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, final int position) {
        final HomeViewModel home = students.get(position);
        if(home.getGender().equalsIgnoreCase("male")){
            holder.imgProfile.setImageResource(R.drawable.male);
            holder.name.setText("Mr. "+home.getName());
        }else if(home.getGender().equalsIgnoreCase("female")){
            holder.imgProfile.setImageResource(R.drawable.female);
            holder.name.setText("Mrs. "+home.getName());
        }
        else{
            holder.imgProfile.setImageResource(R.drawable.female);
        }

        holder.address.setText(home.getAddress());
        holder.age.setText(home.getAge()+" years");
        holder.gender.setText(home.getGender());

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                students.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imgProfile;
        TextView name,address,age,gender;
        Button delete;
        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);

            imgProfile = itemView.findViewById(R.id.student_img);
            name = itemView.findViewById(R.id.student_name);
            address = itemView.findViewById(R.id.student_address);
            age = itemView.findViewById(R.id.student_age);
            gender = itemView.findViewById(R.id.student_gender);
            delete = itemView.findViewById(R.id.btndelete);
        }
    }
}
