package in.co.bestforgins.www.navi_try;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout draw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar tool=findViewById(R.id.toolbar);
        setSupportActionBar(tool);
        draw=findViewById(R.id.profit_layout);
        NavigationView navigationView=findViewById(R.id.nav_viewg);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle tog=new ActionBarDrawerToggle(this,draw,tool,R.string.navi_gate,R.string.navi_gate_close);
        draw.addDrawerListener(tog);
        tog.syncState();
    }

    @Override
    public void onBackPressed() {
        if(draw.isDrawerOpen(GravityCompat.START)){
            draw.closeDrawer(GravityCompat.START);


        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.nav_dayjob:
                startActivity(new Intent(this,Profit_loss.class));
                break;
            case R.id.nav_profit:
                startActivity(new Intent(this,Job.class));
                break;
            case R.id.nav_viewed:
                startActivity(new Intent(this,Final.class));
                break;


        }
        return true;
    }
}
