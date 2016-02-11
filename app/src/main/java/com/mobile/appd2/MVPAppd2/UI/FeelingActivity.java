package com.mobile.appd2.MVPAppd2.UI;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.mobile.appd2.MVPAppd2.Adapter.RecyclerViewAdapter;
import com.mobile.appd2.MVPAppd2.Clases.Feeling;
import com.mobile.appd2.MVPAppd2.R;

import java.util.ArrayList;
import java.util.List;


public class FeelingActivity extends ActionBarActivity {

    private GridLayoutManager lLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(null);

//        Toolbar topToolBar = (Toolbar)findViewById(R.id.toolbar);
//        setSupportActionBar(topToolBar);
//        topToolBar.setLogo(R.drawable.logo);
//        topToolBar.setLogoDescription(getResources().getString(R.string.logo_desc));

        List<Feeling> rowListItem = getAllItemList();
        lLayout = new GridLayoutManager(FeelingActivity.this, 2);

        RecyclerView rView = (RecyclerView)findViewById(R.id.recycler_view);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);

        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(FeelingActivity.this, rowListItem);
        rView.setAdapter(rcAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        if(id == R.id.action_refresh){
//            Toast.makeText(MainActivity.this, "Refresh App", Toast.LENGTH_LONG).show();
//        }
//        if(id == R.id.action_new){
//            Toast.makeText(MainActivity.this, "Create Text", Toast.LENGTH_LONG).show();
//        }

        return super.onOptionsItemSelected(item);
    }

    private List<Feeling> getAllItemList(){

        List<Feeling> feelingList = new ArrayList<Feeling>();
        feelingList.add(new Feeling("Alternativo", R.drawable.alternativo));
        feelingList.add(new Feeling("Aventurero", R.drawable.alternativo));
        feelingList.add(new Feeling("Romántico", R.drawable.alternativo));
        feelingList.add(new Feeling("Relajado", R.drawable.alternativo));
        feelingList.add(new Feeling("Loco", R.drawable.alternativo));
        feelingList.add(new Feeling("Elegante", R.drawable.alternativo));

        return feelingList;
    }
}
