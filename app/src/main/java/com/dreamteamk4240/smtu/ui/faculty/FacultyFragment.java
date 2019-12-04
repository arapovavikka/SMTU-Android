package com.dreamteamk4240.smtu.ui.faculty;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dreamteamk4240.smtu.R;
import com.dreamteamk4240.smtu.data.PersonImage;
import com.dreamteamk4240.smtu.twoLevelList.ExpandableRecyclerAdapter;
import com.dreamteamk4240.smtu.twoLevelList.FacultyItem;
import com.dreamteamk4240.smtu.twoLevelList.FacultyAdapter;
import com.dreamteamk4240.smtu.twoLevelList.Department;
import com.dreamteamk4240.smtu.ui.faculty.recyclerView.ImageRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FacultyFragment extends Fragment {

    private FacultyViewModel facultyViewModel;
    private FacultyAdapter mAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        facultyViewModel =
                ViewModelProviders.of(this).get(FacultyViewModel.class);
        View root = inflater.inflate(R.layout.fragment_faculty, container, false);
        FrameLayout frameFaculty = root.findViewById(R.id.faculty_frame);
        frameFaculty.setBackground(root.getResources().getDrawable(R.color.main_items_background));
        View loadingView = inflater.inflate(R.layout.loading, container, false);
        facultyViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        LinearLayout progressBar = loadingView.findViewById(R.id.progress_bar);
        downloadData(progressBar, frameFaculty, root);
        return root;
    }

    private void downloadData(View progressBarView, FrameLayout frameLayout, View root) {

//        frameLayout.addView(progressBarView);
        frameLayout.removeAllViews();
        // frameLayout.addView(initRecyclerTextView(root));
        frameLayout.addView(getImageRecyclerView(root.getContext()));
    }
    private View getTest(final Context context){
        Department movie_one = new Department("The Shawshank Redemption");
        Department movie_two  = new Department("The Godfather");
        Department movie_three = new Department("The Dark Knight");
        Department movie_four  = new Department("Schindler's List ");
        Department movie_five = new Department("12 Angry Men ");
        Department movie_six = new Department("Pulp Fiction");
        Department movie_seven = new Department("The Lord of the Rings: The Return of the King");
        Department movie_eight = new Department("The Good, the Bad and the Ugly");
        Department movie_nine = new Department("Fight Club");
        Department movie_ten = new Department("Star Wars: Episode V - The Empire Strikes");
        Department movie_eleven = new Department("Forrest Gump");
        Department movie_tweleve = new Department("Inception");

        FacultyItem molvie_category_one = new FacultyItem("Drama", Arrays.asList(movie_one, movie_two, movie_three, movie_four));
        FacultyItem molvie_category_two = new FacultyItem("Action", Arrays.asList(movie_five, movie_six, movie_seven,movie_eight));
        FacultyItem molvie_category_three = new FacultyItem("History", Arrays.asList(movie_nine, movie_ten, movie_eleven,movie_tweleve));
        FacultyItem molvie_category_four = new FacultyItem("Thriller", Arrays.asList(movie_one, movie_five, movie_nine,movie_tweleve));

        final List<FacultyItem> movieCategories = Arrays.asList(molvie_category_one,  molvie_category_two, molvie_category_three,molvie_category_four);

        RecyclerView recyclerView = new RecyclerView(context);
        mAdapter = new FacultyAdapter(context, movieCategories);
        mAdapter.setExpandCollapseListener(new ExpandableRecyclerAdapter.ExpandCollapseListener() {
            @Override
            public void onListItemExpanded(int position) {
                FacultyItem expandedFacultyItem = movieCategories.get(position);

                String toastMsg = getResources().getString(R.string.expanded, expandedFacultyItem.getName());
                Toast.makeText(context,
                        toastMsg,
                        Toast.LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onListItemCollapsed(int position) {
                FacultyItem collapsedFacultyItem = movieCategories.get(position);

                String toastMsg = getResources().getString(R.string.collapsed, collapsedFacultyItem.getName());
                Toast.makeText(context,
                        toastMsg,
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });

        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        return recyclerView;
    }

    private ArrayList<PersonImage> getListOfPersonsWithImage(Context context){
        ArrayList<PersonImage> personImages = new ArrayList<>();
        personImages.add(new PersonImage("Воршевский Александр Алексеевич",
               R.drawable.p100677,"заведующий лабораторией, Старший преподаватель"));
        personImages.add(new PersonImage("Воршевский Александр Алексеевич",
                R.drawable.p100677,"заведующий лабораторией, Старший преподаватель"));
        personImages.add(new PersonImage("Воршевский Александр Алексеевич",
                R.drawable.p100677,"заведующий лабораторией, Старший преподаватель"));
        personImages.add(new PersonImage("Воршевский Александр Алексеевич",
                R.drawable.p100677,"заведующий лабораторией, Старший преподаватель"));
        personImages.add(new PersonImage("Воршевский Александр Алексеевич",
                R.drawable.p100677,"заведующий лабораторией, Старший преподаватель"));
        personImages.add(new PersonImage("Воршевский Александр Алексеевич",
                R.drawable.p100677,"заведующий лабораторией, Старший преподаватель"));
        personImages.add(new PersonImage("Воршевский Александр Алексеевич",
                R.drawable.p100677,"заведующий лабораторией, Старший преподаватель"));
        personImages.add(new PersonImage("Воршевский Александр Алексеевич",
                R.drawable.p100677,"заведующий лабораторией, Старший преподаватель"));
        personImages.add(new PersonImage("Воршевский Александр Алексеевич",
                R.drawable.p100677,"заведующий лабораторией, Старший преподаватель"));
        personImages.add(new PersonImage("Воршевский Александр Алексеевич",
                R.drawable.p100677,"заведующий лабораторией, Старший преподаватель"));
        personImages.add(new PersonImage("Воршевский Александр Алексеевич",
                R.drawable.p100677,"заведующий лабораторией, Старший преподаватель"));
        personImages.add(new PersonImage("Воршевский Александр Алексеевич",
                R.drawable.p100677,"заведующий лабораторией, Старший преподаватель"));
        personImages.add(new PersonImage("Воршевский Александр Алексеевич",
                R.drawable.p100677,"заведующий лабораторией, Старший преподаватель"));
        personImages.add(new PersonImage("Воршевский Александр Алексеевич",
                R.drawable.p100677,"заведующий лабораторией, Старший преподаватель"));
        personImages.add(new PersonImage("Воршевский Александр Алексеевич",
                R.drawable.p100677,"заведующий лабораторией, Старший преподаватель"));
        return personImages;
    }


    private View getImageRecyclerView(Context context){
        RecyclerView recyclerView = new RecyclerView(context);
        recyclerView.setBackgroundColor(context.getResources().getColor(R.color.main_items_background));
        RecyclerView.LayoutManager layoutManager =new GridLayoutManager(context,2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        ImageRecyclerViewAdapter adapter = new ImageRecyclerViewAdapter(getListOfPersonsWithImage(context)
        ,context);
        recyclerView.setAdapter(adapter);

        return recyclerView;

    }


}