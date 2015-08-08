package com.example.navigationdrawer;

import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements OnItemClickListener {

    
    private DrawerLayout drawerlayout;
    private ListView listview;
    private String[] planets;
    private ActionBarDrawerToggle drawerlistener;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    planets=getResources().getStringArray(R.array.planets);
    drawerlayout=(DrawerLayout)findViewById(R.id.drawerlayout);
    listview=(ListView)findViewById(R.id.drawerlist);
    listview.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,planets));
    listview.setOnItemClickListener(this);
    drawerlistener=new ActionBarDrawerToggle(this, drawerlayout, R.drawable.images, R.string.drawer_open, R.string.drawer_close)
    {
    	@Override
    	public void onDrawerClosed(View drawerView) {
    		// TODO Auto-generated method stub
    		super.onDrawerClosed(drawerView);
    	}
    	
    	@Override
    	public void onDrawerOpened(View drawerView) {
    		// TODO Auto-generated method stub
    		super.onDrawerOpened(drawerView);
    	}
    	
    	
    	
    };
    getSupportActionBar().setHomeButtonEnabled(true);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    drawerlayout.setDrawerListener(drawerlistener);
    
    }
@Override
protected void onPostCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onPostCreate(savedInstanceState);
  drawerlistener.syncState();
}

   @Override
public boolean onCreateOptionsMenu(Menu menu) {
	// TODO Auto-generated method stub
	getMenuInflater().inflate(R.menu.main, menu);
	   return true;
}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        
        if (drawerlistener.onOptionsItemSelected(item)) {
            return true;
        }
        switch(item.getItemId()){
        
        case R.id.search_icon : Toast.makeText(getBaseContext(), "search", Toast.LENGTH_LONG).show();
         
        
        }
        return super.onOptionsItemSelected(item);
        }


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		selectitem(arg2);
	}


	private void selectitem(int arg2) {
		// TODO Auto-generated method stub
		listview.setItemChecked(arg2, true);
		settitle(planets[arg2]);
	}


	private void settitle(String string) {
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle(string);
		
	}
}
