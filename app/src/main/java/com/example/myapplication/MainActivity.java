package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;
import Models.LoginData;
public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.mainPageFragment, R.id.smartphoneFragment,
                R.id.notebookFragment, R.id.wirelessHeadphonesFragment, R.id.wireHeadphonesFragment, R.id.accessoryFragment)
                .setOpenableLayout(drawer).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.action_menu, menu);
        return true;
    }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case R.id.Login:
                if (LoginData.getUsername()==null)

                    Navigation.findNavController(this, R.id.nav_host_fragment_content_main).navigate(R.id.LoginFragment);
                else{
                    Toast.makeText(this.getApplicationContext(),R.string.AlreadySignIn,Toast.LENGTH_SHORT).show();
                    }
                break;
            case R.id.Cart:
                if (LoginData.getUsername()==null)
                {
                    Toast.makeText(this.getApplicationContext(),R.string.SignInRequired,Toast.LENGTH_SHORT).show();
                }
                else {
                     Navigation.findNavController(this, R.id.nav_host_fragment_content_main).navigate(R.id.CartFragment);
                    }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}