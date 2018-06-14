package com.suntist.suntist;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import modelclass.Detail;

public class DetailActivity extends AppCompatActivity {

    EditText nameText,mobileText;
    TextView name,email;
    Button male1,female1,submit;
    ListView listView;
    String flag_sex, nameString, mobileString;
    List<Detail> detail;
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_detail);


        nameText=(EditText)findViewById(R.id.nameText);
        mobileText=(EditText)findViewById(R.id.mobileText);

        name=(TextView) findViewById(R.id.name);
        email=(TextView) findViewById(R.id.email);

        male1=(Button) findViewById(R.id.male1);
        female1=(Button) findViewById(R.id.female1);
        submit=(Button) findViewById(R.id.submit);
        submit.setEnabled(false);

        listView=(ListView)findViewById(R.id.listView);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            name.setText(bundle.getString("name"));
            email.setText(bundle.getString("email"));

        }


        detail=new ArrayList<>();
        listAdapter=new ListAdapter(DetailActivity.this,detail);
        listView.setAdapter(listAdapter);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Detail detail1=new Detail();
                detail1.setName(nameString);
                detail1.setMobileno(mobileString);
                detail1.setSex(flag_sex);
                detail.add(detail1);
                listAdapter.notifyDataSetChanged();
            }
        });

        male1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                flag_sex="Male";
                male1.setBackgroundResource(R.drawable.button_selected);
                female1.setBackgroundResource(R.drawable.button1);

                male1.setTextColor(Color.parseColor("#ffffff"));
                female1.setTextColor(Color.parseColor("#cccccc"));

                if(validate())
                    submit.setEnabled(true);

            }
        });

        female1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                flag_sex="Female";
                female1.setBackgroundResource(R.drawable.button_selected);
                male1.setBackgroundResource(R.drawable.button1);

                female1.setTextColor(Color.parseColor("#ffffff"));
                male1.setTextColor(Color.parseColor("#cccccc"));


                if(validate())
                    submit.setEnabled(true);


            }
        });


        nameText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    // code to execute when EditText loses focus
                    if(validate())
                        submit.setEnabled(true);
                }
            }
        });

        mobileText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    // code to execute when EditText loses focus

                    if(validate())
                        submit.setEnabled(true);
                }
            }
        });

        mobileText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                if(validate())
                    submit.setEnabled(true);
                else
                    submit.setEnabled(false);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int arg1, int arg2, int arg3) {

            }

            @Override
            public void afterTextChanged(Editable arg0) {

                if(validate())
                    submit.setEnabled(true);
                else
                    submit.setEnabled(false);
            }

        });

        nameText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                if(validate())
                    submit.setEnabled(true);
                else
                    submit.setEnabled(false);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int arg1, int arg2, int arg3) {

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                if(validate())
                    submit.setEnabled(true);
                else
                    submit.setEnabled(false);

            }

        });


    }

    private boolean validate(){
        nameString=nameText.getText().toString();
        mobileString=mobileText.getText().toString();
        if(nameString==null||nameString.length()==0)
            return false;
        else if(mobileString==null||mobileString.length()==0)
        return false;
        else if(flag_sex==null||flag_sex.length()==0)
            return false;
        else
            return true;
    }
}
