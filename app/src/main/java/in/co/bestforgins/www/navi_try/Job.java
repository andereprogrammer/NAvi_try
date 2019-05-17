package in.co.bestforgins.www.navi_try;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Job extends AppCompatActivity implements View.OnClickListener {

    public static final String RMVALUE="in.co.bestforgins.www.navi_try.RMVALUE";
    public static final String WEIGHTJOB="in.co.bestforgins.www.navi_try.WEIGHTJOB";
    public static final String WEIGHTRM="in.co.bestforgins.www.navi_try.WEIGHTRM";
    public static final String SHORTO="in.co.bestforgins.www.navi_try.SHORTO";
    public static final String HT="in.co.bestforgins.www.navi_try.HT";
    public static final String RMRATE="in.co.bestforgins.www.navi_try.RMRATE";
    public static final String CUTTING="in.co.bestforgins.www.navi_try.CUTTING";
    public static final String ITEMQTY="in.co.bestforgins.www.navi_try.ITEM";

    EditText editText_name,editText_shorto, editText_ratecp,  editText_cutting, editText_prod, editText_ht, editText_wei_rm, editText_rmrate, editText_weightj;
    Button click_on;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);
        editText_name = findViewById(R.id.editText);
        editText_prod = findViewById(R.id.editText2);
        editText_ratecp = findViewById(R.id.editText3);
        editText_wei_rm = findViewById(R.id.editText4);
        editText_rmrate = findViewById(R.id.editText5);
        editText_weightj = findViewById(R.id.editText6);
        editText_cutting = findViewById(R.id.editText7);
        editText_ht = findViewById(R.id.transport1);
        editText_shorto= findViewById(R.id.shorto);
        click_on = findViewById(R.id.Next_button);
        click_on.setOnClickListener(Job.this);


    }

    @Override
    public void onClick(View view) {


                if (editText_cutting.getText().toString().equals("")|| editText_prod.getText().toString().equals("")||editText_ratecp.getText().toString().equals("")||editText_ht.getText().toString().equals("")){

                    Toast.makeText(this,"Please enter value",Toast.LENGTH_SHORT).show();

                }else{
                    calc();

                }




    }
    public  void calc(){
        float num1, num2, num3, item_value,  ht,shorto,weigtj,weigtrm, rmrateq,heat,cutting,shorttreat ;
        double k = 1.04,rmvalue;
        num1 = Float.parseFloat(editText_prod.getText().toString());
        num2 = Float.parseFloat((editText_ratecp.getText().toString()));
        num3 = Float.parseFloat(editText_cutting.getText().toString());
        weigtj = Float.parseFloat(editText_weightj.getText().toString());
        ht = Float.parseFloat(editText_ht.getText().toString());
        weigtrm = Float.parseFloat(editText_wei_rm.getText().toString());
        shorto = Float.parseFloat(editText_shorto.getText().toString());
        rmrateq= Float.parseFloat(editText_rmrate.getText().toString());
        item_value=num2*num1;
        heat = num1*ht*weigtj;
        cutting = num1*num3;
        shorttreat = num1*shorto*weigtj;
        rmvalue=weigtrm*num1*rmrateq*k;




        Intent intent = new Intent(this, all_other.class);
        intent.putExtra(ITEMQTY, item_value);
        intent.putExtra(CUTTING, cutting);
        intent.putExtra(WEIGHTJOB, weigtj);
        intent.putExtra(WEIGHTRM, weigtrm);
        intent.putExtra(RMRATE, num2);
        intent.putExtra(HT, heat);
        intent.putExtra(SHORTO, shorttreat);
        intent.putExtra(RMVALUE, rmvalue);

        startActivity(intent);
    }


}
