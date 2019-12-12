package com.shg.keyebang.view.activity.CourseList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.shg.keyebang.R;
import com.shg.keyebang.model.User;
import com.shg.keyebang.view.activity.BaseFragment;
import com.shg.keyebang.view.general.TitleBarLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class CourseListFragment extends BaseFragment  {
    private MainCoursesFragment mainCoursesFragment;
    private OptionalCourseFragment optionalCourseFragment;
    private CoursesViewPagerAdapter adapter;
    private TitleBarLayout titleBar;
    private EditText searchText;
    private ImageView search;
    private TabLayout courseListTabLayout;
    private ViewPager courseListViewPager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainCoursesFragment = new MainCoursesFragment();
        optionalCourseFragment = new OptionalCourseFragment();
        adapter = new CoursesViewPagerAdapter(getChildFragmentManager(), mainCoursesFragment, optionalCourseFragment);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_courselist, container, false);
        titleBar = view.findViewById(R.id.courseListBar);
        searchText = view.findViewById(R.id.searchText);
        search = view.findViewById(R.id.searchIcon);
        courseListTabLayout = view.findViewById(R.id.courseListTabLayout);
        courseListViewPager = view.findViewById(R.id.courseListViewPager);

        init();

        return view;
    }

    @Override
    protected void init() {
        courseListViewPager.setAdapter(adapter);
        courseListTabLayout.setupWithViewPager(courseListViewPager);
        courseListTabLayout.getTabAt(0).setText("必修课");
        courseListTabLayout.getTabAt(1).setText("选修课");

        search.setOnClickListener(v -> toastAndLog("Search"));
        titleBar.setTitle("您的课程列表");
    }
}