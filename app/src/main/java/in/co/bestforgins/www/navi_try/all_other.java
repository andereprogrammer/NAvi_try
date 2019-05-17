package in.co.bestforgins.www.navi_try;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class all_other extends AppCompatActivity implements View.OnClickListener {

    public static final String DIFFERENCE = "in.co.bestforgins.www.navi_try.DIFF";

    public static final String CORRECTED = "in.co.bestforgins.www.navi_try.mine";
    public static final String AGAINVALUE = "in.co.bestforgins.www.navi_try.given";
    public static final String AGAINTRAN = "in.co.bestforgins.www.navi_try.tragiven";
    Button getter;
    EditText editText_die, editText_ndie, editText_foil, editText_trcs, editText_wt, editText_hd;
    TextView  recieve, recieve1,recieve3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_other);

        editText_die = findViewById(R.id.edit_diecs);
        editText_ndie = findViewById(R.id.editText10_ndie);
        editText_foil = findViewById(R.id.editText18_foil);
        editText_trcs = findViewById(R.id.editText17_trcs);
        recieve = findViewById(R.id.recieve1);
        recieve1 = findViewById(R.id.recieve2);
        recieve3 = findViewById(R.id.textView24);


        //etrn.setText(transport);
        editText_wt = findViewById(R.id.editText20_wtqty);
        editText_hd = findViewById(R.id.editText21_hd);
        getter = findViewById(R.id.Calculate_button);

        getter.setOnClickListener(all_other.this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

          case   R.id.Calculate_button:
                openActivity();


        }
    }

    public void openActivity() {


        Intent intent = getIntent();

        float item_value;
        item_value = intent.getFloatExtra(Job.ITEMQTY, 0);
        float cutting = intent.getFloatExtra(Job.CUTTING, 0);
        float shorting = intent.getFloatExtra(Job.SHORTO, 0);
        float heating = intent.getFloatExtra(Job.HT,0);
        Double rmvalu = intent.getDoubleExtra(Job.RMVALUE,0);



        recieve.setText(Job.CUTTING);
        recieve1.setText(Job.ITEMQTY);
        recieve3.setText(Job.RMVALUE);


        Float diecs = Float.parseFloat(editText_die.getText().toString());
        Float trcs = Float.parseFloat(editText_trcs.getText().toString());
        Float hd = Float.parseFloat(editText_hd.getText().toString());
        Float foil = Float.parseFloat(editText_foil.getText().toString());
        Float ndie = Float.parseFloat(editText_ndie.getText().toString());
        Float wt = Float.parseFloat(editText_wt.getText().toString());
        Float transport = wt*trcs;
        int constant = 13500;
        Float furnance = foil*ndie;
        Double item = cutting+shorting+heating+rmvalu+transport+constant+furnance+diecs+hd,diff;
        Intent intent1 = new Intent(this, Final.class);
        diff = item_value - item;
        intent1.putExtra(DIFFERENCE, diff);
        intent1.putExtra(CORRECTED,item);
        intent1.putExtra(AGAINVALUE,item_value);
        intent1.putExtra(AGAINTRAN,transport);
        startActivity(intent1);
    }


}
