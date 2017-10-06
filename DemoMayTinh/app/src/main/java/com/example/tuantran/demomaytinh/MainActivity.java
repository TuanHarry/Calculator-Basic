package com.example.tuantran.demomaytinh;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnClickListener {

    Float fthamso1, fthamso2;
    String stoantu,sxuat = "";
    EditText etgiatri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etgiatri = (EditText)findViewById(R.id.etKetQua);
        int[] idButton = {R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9,
                R.id.btnCham,R.id.btnChia,R.id.btnCong,R.id.btnTru,R.id.btnNhan,R.id.btnDelele,R.id.btnBang};
        // Duyet tung id
        for(int id:idButton){
            View v= (View)findViewById(id);
            v.setOnClickListener(this);
        }
    }

    private void ToanTu(){
        fthamso1 = Float.parseFloat(etgiatri.getText().toString());
        sxuat = "0";
    }



    @Override
    public void onClick(View view) {
        // check empty
        if(TextUtils.isEmpty(etgiatri.getText().toString())){
            return ;
        }


        switch (view.getId()){
            case R.id.btnDelele:
                etgiatri.setText("0");
                sxuat =null;
                ToanTu();

                break;

            case R.id.btnCong :
                stoantu ="+";
                ToanTu();
                break;

            case R.id.btnTru :
                stoantu ="-";
                ToanTu();
                break;

            case R.id.btnNhan :
                stoantu ="*";
                ToanTu();
                break;

            case R.id.btnChia :
                stoantu ="/";
                ToanTu();
                break;

            case R.id.btnBang :
                Float ketqua = 0.0f;
                fthamso2 = Float.parseFloat(etgiatri.getText().toString());

                if(stoantu.equals("+")){
                    ketqua = fthamso1 + fthamso2;
                }
                if(stoantu.equals("-")){
                    ketqua = fthamso1 - fthamso2;
                }
                if(stoantu.equals("*")){
                    ketqua = fthamso1 * fthamso2;
                }
                if(stoantu.equals("/")){
                    if(fthamso2 == 0){
                        etgiatri = null;
                        sxuat = null;
                        this.finish();
                    }
                    ketqua = fthamso1 / fthamso2;
                }
                etgiatri.setText(String.valueOf((double)Math.round(ketqua*1000000)/1000000));
                fthamso1 = 0.0f;
                fthamso2 = 0.0f;
                sxuat = "0";
                break;


            default:
                if(sxuat.equals("0")){
                    sxuat = "";
                }sxuat +=((Button)view).getText().toString();
                etgiatri.setText(sxuat);

        }
    }
}
