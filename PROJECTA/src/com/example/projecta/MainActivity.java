package com.example.projecta;



import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements OnItemClickListener  {
	 
	
	private DrawerLayout drawerlayout;
	    private ListView listview;
	    private String[] about;
	    private ActionBarDrawerToggle drawerlistener;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	
     about=getResources().getStringArray(R.array.project);
	drawerlayout=(DrawerLayout)findViewById(R.id.drawerlayout);
	listview=(ListView)findViewById(R.id.drawerlist);
	 listview.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,about));
	    listview.setOnItemClickListener(this);
	    drawerlayout.setDrawerListener(drawerlistener);
	drawerlistener=new ActionBarDrawerToggle(this, drawerlayout,R.drawable.images , R.string.drawer_open, R.string.drawer_close){
		
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
	
	
	
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
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
		 
		return super.onOptionsItemSelected(item);
	}
	protected void onPostCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onPostCreate(savedInstanceState);
	  drawerlistener.syncState();
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		
		
		selectitem(arg2);
		Fragment frag = null;
		switch(arg2){
		 case 0:
	            frag = new FragmentA();
	            break;
	        case 1:
	            frag = new FragmentB();
	            break;
	        case 2:
	            frag = new FragmentC();
	            break;
	        case 3:
	            frag = new FragmentD();
	            break;
	       
	 
	        default:
	            break;
		}
	            if (frag != null) {
	                FragmentManager fragmentManager = getFragmentManager();
	                fragmentManager.beginTransaction()
	                        .replace(R.id.maincontent, frag).commit();
	            }
		
		drawerlayout.closeDrawer(listview);
		
		}
		
  private void selectitem(int arg2) {
		// TODO Auto-generated method stub
		listview.setItemChecked(arg2, true);
		settitle(about[arg2]);
	}


	private void settitle(String string) {
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle(string);
		
	}
}

