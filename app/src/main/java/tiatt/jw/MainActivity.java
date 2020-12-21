package tiatt.jw;

import android.os.Build;
import android.os.Bundle;

import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.widget.DatePicker;

import java.util.ArrayList;

import soup.neumorphism.NeumorphImageButton;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    private ArrayList<NeumorphImageButton> bottomButtons = new ArrayList<>();
    private int currentPage = 0, nextPage = 0;

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

        // 초기 화면 설정
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

        switch (view.getId()) {
            case R.id.bottom_dictionary:
                nextPage = 0;
                ChangeFragment(DictionaryFragment.newInstance());
                break;
            case R.id.bottom_translate:
                nextPage = 1;
                ChangeFragment(TranslateFragment.newInstance());
                break;
            case R.id.bottom_quiz:
                nextPage = 2;
                ChangeFragment(QuizFragment.newInstance());
                break;
            case R.id.bottom_match_game:
                nextPage = 3;
                ChangeFragment(WordMatchingFragment.newInstance());
                break;
        }

        // currentPage : 바뀌기 전 페이지
        bottomButtons.get(currentPage).setShapeType(0);
        bottomButtons.get(currentPage).setClickable(true);
        // nextPage : 바뀐 후 페이지
        bottomButtons.get(nextPage).setShapeType(1);
        bottomButtons.get(nextPage).setClickable(false);

        currentPage = nextPage;
    };

    private void ChangeFragment(Fragment fragment) {
        FragmentTransaction tran = getSupportFragmentManager().beginTransaction();

        if (nextPage > currentPage) tran.setCustomAnimations(R.anim.slide_left_enter, R.anim.slide_left_exit);
        else                        tran.setCustomAnimations(R.anim.slide_right_enter, R.anim.slide_right_exit);

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
