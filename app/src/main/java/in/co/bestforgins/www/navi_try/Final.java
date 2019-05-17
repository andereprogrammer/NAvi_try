package in.co.bestforgins.www.navi_try;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Final extends AppCompatActivity {





    TextView t1,t2,t3,t4,t5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        t1=findViewById(R.id.Get_me);
        t2=findViewById(R.id.final1);
        t3=findViewById(R.id.itemgot);
        t4=findViewById(R.id.actual_tran);
        t5=findViewById(R.id.actual_value);
        String  pro="PROFIT";
        String kio="LOSS";
        Intent intent=getIntent();
        float actual_tran=intent.getFloatExtra(all_other.AGAINTRAN,0);
        float actual_value=intent.getFloatExtra(all_other.AGAINVALUE,0);
        Double valued=intent.getDoubleExtra(all_other.CORRECTED,0);
        Double difference=intent.getDoubleExtra(all_other.DIFFERENCE,0);
        if(difference>0){
            t1.setText(pro);
            t2.setText("DIFFERENCE :"+difference);
            t3.setText("TOTAL :"+valued);
            t4.setText("TRANSPORT :"+actual_tran);
            t5.setText("ITEM_VALUE :"+actual_value);

        }else{
            t1.setText(kio);
            t2.setText("DIFFERENCE :"+difference);
            t3.setText("TOTAL :"+valued);
            t4.setText("TRANSPORT :"+actual_tran);
            t5.setText("ITEM_VALUE :"+actual_value);
        }




    }
}
