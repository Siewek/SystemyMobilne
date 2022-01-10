package com.example.zad6again;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class TaskListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new TaskListFragment();
    }
}