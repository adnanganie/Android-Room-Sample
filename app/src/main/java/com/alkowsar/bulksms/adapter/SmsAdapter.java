package com.alkowsar.bulksms.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alkowsar.bulksms.R;
import com.alkowsar.bulksms.model.OnStudentDetailsClickListiner;
import com.alkowsar.bulksms.model.Student;

import java.util.ArrayList;
import java.util.List;

public class SmsAdapter extends RecyclerView.Adapter<SmsAdapter.ViewHolder>{
    private OnStudentDetailsClickListiner listener;
    List<Student>students;

    public SmsAdapter(OnStudentDetailsClickListiner listener, List<Student> students) {
        this.listener = listener;
        this.students = students;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_student,parent,false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tvId.setText(String.valueOf(students.get(position).getId()));
        holder.tvFirstName.setText(students.get(position).getFirstName());
        holder.tvLastName.setText(students.get(position).getLastName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(position);
            }
        });
}

    @Override
    public int getItemCount() {
        return students.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvId;
        TextView tvFirstName;
        TextView tvLastName;

        public ViewHolder(View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvId);
            tvFirstName = itemView.findViewById(R.id.tv_firstName);
            tvLastName = itemView.findViewById(R.id.tv_lastName);
        }
    }
   public void addAll(List<Student> students){
        if (students == null)
            students = new ArrayList<>();

        this.students.addAll(students);
    }
}
