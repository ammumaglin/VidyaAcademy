package com.vidhya.vidyaacademy;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import pl.droidsonroids.gif.GifImageView;

public class RecyclerViewForStudentInfo_princi extends RecyclerView.Adapter<RecyclerViewForStudentInfo_princi.ViewHolder> {
    TextView Student_Name, RegNo, Email, Adddress;
    CircleImageView iv_student_photo;
    ArrayList<Princi_Stud_CardDetails> list;
    Context context;
    String AdminID;
    String ClassID;

    public RecyclerViewForStudentInfo_princi(Context context, ArrayList<Princi_Stud_CardDetails> arrayList, String ClassID,String AdminID) {
        this.list = arrayList;
        this.context = context;
        this.ClassID = ClassID;
        this.AdminID=AdminID;

    }


    @NonNull
    @Override
    public RecyclerViewForStudentInfo_princi.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        CardView view = (CardView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_princi_card_stud, viewGroup, false);
        return new RecyclerViewForStudentInfo_princi.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewForStudentInfo_princi.ViewHolder viewHolder, final int i) {
        final int j;
        final CardView cardView = viewHolder.cardView;
        final Context context = cardView.getContext();
        iv_student_photo = cardView.findViewById(R.id.princi_iv_student_photo);
        Student_Name = (TextView) cardView.findViewById(R.id.tv_princi_card_name);
        RegNo = (TextView) cardView.findViewById(R.id.tv_princi_card_reg_no);
        Email = (TextView) cardView.findViewById(R.id.tv_princi_card__grade);
      //  Adddress=(TextView) cardView.findViewById(R.id.tv_princi_card_address);

        Student_Name.setText(list.get(i).getName().toString());
        RegNo.setText(list.get(i).getPhno().toString());
        Email.setText(list.get(i).getEmail().toString());
      //  Adddress.setText(list.get(i).getAddress().toString());

        Glide.with(context).load(list.get(i).getImage()).into(iv_student_photo);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("nadeem",ClassID);


                Intent intent = new Intent(context, StudentDetails_approval_princi.class);
                intent.putExtra( "ClassID",ClassID );
                intent.putExtra( "AdminID",AdminID);
                intent.putExtra( "RegNo",list.get( i ).getPhno() );
                /*intent.putExtra("Student Name",list.get(i).getRegno());
                intent.putExtra("Nadeem",uids);*/
                context.startActivity(intent);
            }
        });



    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        public ViewHolder(View view){
            super(view);
            cardView =(CardView)view.findViewById(R.id.princi_cardview_forStudent);
        }
    }

    @Override
    public int getItemCount() {
        int length=list.size();
        return length;
    }


}
