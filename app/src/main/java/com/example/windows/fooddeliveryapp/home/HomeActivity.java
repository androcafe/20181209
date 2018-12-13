package com.example.windows.fooddeliveryapp.home;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;
import android.support.v7.widget.SearchView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.windows.fooddeliveryapp.R;
import com.example.windows.fooddeliveryapp.admin.AdminOrderActivity;
import com.example.windows.fooddeliveryapp.order.OrderFragment;
import com.example.windows.fooddeliveryapp.order.PastOrderFragement;

import java.util.Locale;

import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Fragment fragment;

    //Language Change
    Locale myLocale;
    String currentLanguage = "en", currentLang;

    //Shared Prference
    public static String MyPref="MyFoodPref";
    public static String LANGUAGE="Language";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getResources().getString(R.string.home_title));

        //Initializing Shared Preference
        sharedPreferences=getSharedPreferences(MyPref,Context.MODE_PRIVATE);

        if(sharedPreferences.contains(LANGUAGE))
        {
            String lan= sharedPreferences.getString(LANGUAGE,null);
            System.out.println("localName "+lan);
            if(lan.equals("mr"))
            {

            }
        }
        else
        {
            showLanguageDialog();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        // bind the view using butterknife
        ButterKnife.bind(this);

       // sharedPreferences=getSharedPreferences(LoginActivity)

        fragment=HomeFragment.newInstance();
        loadFragment(fragment);
    }

    private void showLanguageDialog() {

        final String[] language=getResources().getStringArray(R.array.language);

        AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
        //alt_bld.setIcon(R.drawable.icon);
        alt_bld.setTitle("Select a Group Name");
        alt_bld.setCancelable(false);

        alt_bld.setSingleChoiceItems(language, -1, new DialogInterface
                .OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {

                SharedPreferences.Editor editor=sharedPreferences.edit();

                if(language[item].equals("मराठी"))
                {
                    Toast.makeText(getApplicationContext(),
                            "Group Name = "+language[item], Toast.LENGTH_SHORT).show();
                    editor.putString(LANGUAGE,"mr");
                    setLocale("mr");
                    dialog.dismiss();// dismiss the alertbox after chose option
                }
                else
                {
                    Toast.makeText(getApplicationContext(),
                            "Group Name = "+language[item], Toast.LENGTH_SHORT).show();
                    editor.putString(LANGUAGE,"en");
                    setLocale("en");
                    dialog.dismiss();// dismiss the alertbox after chose option
                }

                editor.commit();

            }
        });
        AlertDialog alert = alt_bld.create();
        alert.show();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem mSearch = menu.findItem(R.id.nav_search);

        SearchView mSearchView = (SearchView) mSearch.getActionView();
        mSearchView.setQueryHint("Search");
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
               //mAdapter.getFilter().filter(newText);
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.nav_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
             fragment=HomeFragment.newInstance();
             loadFragment(fragment);
        } else if (id == R.id.nav_track_order) {
             fragment= OrderFragment.newInstance();
             loadFragment(fragment);

        } else if (id == R.id.nav_past_order) {
            fragment=PastOrderFragement.newInstance();
            loadFragment(fragment);

        } else if (id == R.id.nav_admin_order) {
            Intent intent=new Intent(HomeActivity.this,AdminOrderActivity.class);
            finish();
            startActivity(intent);

        } /*(else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void loadFragment(Fragment fragment) {

        if(fragment!=null)
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.framelayout_home,fragment)
                    .addToBackStack(null)
                    .commit();
        }
    }

    public void setLocale(String localeName) {
        System.out.println("localName "+localeName);
        if (!localeName.equals(currentLanguage)) {
            currentLang=localeName;
            myLocale = new Locale(localeName);
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.locale = myLocale;
            res.updateConfiguration(conf, dm);
            Intent refresh = new Intent(HomeActivity.this, HomeActivity.class);
            refresh.putExtra(currentLang, localeName);
            startActivity(refresh);
        }

    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }
}