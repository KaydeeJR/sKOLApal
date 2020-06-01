package com.janerose.skolapal;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.janerose.skolapal.ui.notes.NotesFragment;
import com.janerose.skolapal.ui.study.StudyFragment;
import com.janerose.skolapal.ui.timetable.TimeTableFragment;
import com.janerose.skolapal.ui.today.TodayFragment;
import com.janerose.skolapal.ui.todo.ToDoFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar skolapalToolbar = findViewById(R.id.skolapal_toolbar);
        setSupportActionBar(skolapalToolbar);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                Fragment fragment;
                switch (item.getItemId())
                {
                    case R.id.action_notes:
                        fragment = NotesFragment.newInstance();
                        Toast.makeText(MainActivity.this, "Notes Fragment", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_study:
                        fragment = StudyFragment.newInstance();
                        Toast.makeText(MainActivity.this, "Study Fragment", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_timetable:
                        fragment = TimeTableFragment.newInstance();
                        Toast.makeText(MainActivity.this, "Timetable Fragment",
                                       Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_to_do:
                        fragment = ToDoFragment.newInstance();
                        Toast.makeText(MainActivity.this, "ToDo Fragment", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_today:
                        fragment = TodayFragment.newInstance();
                        Toast.makeText(MainActivity.this, "Today Fragment", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        fragment=TodayFragment.newInstance();
                }
                loadFragment(fragment);
                return true;
            }
        });
        navView.setSelectedItemId(R.id.action_today);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration =
            new AppBarConfiguration.Builder(R.id.navigation_notes, R.id.navigation_study,
                                            R.id.navigation_timetable, R.id.navigation_to_do,
                                            R.id.navigation_today).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    private void loadFragment(Fragment fragment)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_fragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}