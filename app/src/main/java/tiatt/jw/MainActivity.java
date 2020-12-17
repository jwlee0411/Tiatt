package tiatt.jw;

import android.os.Build;
import android.os.Bundle;

import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Toast;

import java.util.ArrayList;

import soup.neumorphism.NeumorphImageButton;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    private ArrayList<NeumorphImageButton> bottomButtons = new ArrayList<>();
    private int currentPage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomButtons.add(findViewById(R.id.bottom_dictionary));
        bottomButtons.add(findViewById(R.id.bottom_translate));
        bottomButtons.add(findViewById(R.id.bottom_quiz));
        bottomButtons.add(findViewById(R.id.bottom_match_game));

        for (NeumorphImageButton b : bottomButtons)
            b.setOnClickListener(bottomClickListener);

        ChangeFragment(DictionaryFragment.newInstance());

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//
//        DrawerLayout drawer = findViewById(R.id.drawer_layout);
//        NavigationView navigationView = findViewById(R.id.nav_view);
//        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_dictionary, R.id.nav_translate, R.id.nav_quiz, R.id.nav_word_matching).setDrawerLayout(drawer).build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);


        // Setting BottomNavigationView
//        BottomNavigationView btm = findViewById(R.id.bottomNavView);
//        NavController nav = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupWithNavController(btm, nav);
    }

    private View.OnClickListener bottomClickListener = view -> {
        // currentPage : 바뀌기 전 페이지
        bottomButtons.get(currentPage).setShapeType(0);
        bottomButtons.get(currentPage).setClickable(true);

        switch (view.getId()) {
            case R.id.bottom_dictionary:
                ChangeFragment(DictionaryFragment.newInstance());
                currentPage = 0;
                break;
            case R.id.bottom_translate:
                ChangeFragment(TranslateFragment.newInstance());
                currentPage = 1;
                break;
            case R.id.bottom_quiz:
                ChangeFragment(QuizFragment.newInstance());
                currentPage = 2;
                break;
            case R.id.bottom_match_game:
                ChangeFragment(WordMatchingFragment.newInstance());
                currentPage = 3;
                break;
        }

        // currentPage : 바뀐 후 페이지
        bottomButtons.get(currentPage).setShapeType(1);
        bottomButtons.get(currentPage).setClickable(false);
    };

    private void ChangeFragment(Fragment fragment) {
        FragmentTransaction tran = getSupportFragmentManager().beginTransaction();
        tran.replace(R.id.container, fragment);
        tran.commit();
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


}
