package com.example.user_pc.splashscreen2.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.user_pc.splashscreen2.R;
import com.example.user_pc.splashscreen2.books.BookIssueActivity;
import com.example.user_pc.splashscreen2.adapter.CustomAdapter;
import com.example.user_pc.splashscreen2.books.HighSchoolEnglish;
import com.example.user_pc.splashscreen2.books.OxfordEnglish;
import com.example.user_pc.splashscreen2.utils.ChildInfo;
import com.example.user_pc.splashscreen2.utils.GroupInfo;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by USER-pC on 08/20/17.
 */

public class Tab1Fragment extends android.support.v4.app.Fragment {
    private static final String TAG = "Tab1Fragment";

    private LinkedHashMap<String, GroupInfo> subjects = new LinkedHashMap<String, GroupInfo>();
    private ArrayList<GroupInfo> deptList = new ArrayList<GroupInfo>();

    private CustomAdapter listAdapter;
    private ExpandableListView simpleExpandableListView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment,container,false);

        // add data for displaying in expandable list view
        loadData();

        //get reference of the ExpandableListView
        simpleExpandableListView = (ExpandableListView) view.findViewById(R.id.simpleExpandableListView);
        // create the adapter by passing your ArrayList data
        listAdapter = new CustomAdapter(getActivity(), deptList);
        // attach the adapter to the expandable list view
        simpleExpandableListView.setAdapter(listAdapter);

        //expand all the Groups
        expandAll();

        // setOnChildClickListener listener for child row click
        simpleExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //get the group header
                GroupInfo headerInfo = deptList.get(groupPosition);
                //get the child info
                ChildInfo detailInfo =  headerInfo.getProductList().get(childPosition);
                //display it or do something with it
                Toast.makeText(getActivity(), " Clicked on :: " + headerInfo.getName()
                        + "/" + detailInfo.getSequence(), Toast.LENGTH_LONG).show();

                if(groupPosition==0){
                    switch (childPosition) {
                        case 0:
                            Intent i = new Intent(getActivity(),BookIssueActivity.class);
                            startActivity(i);
                            break;

                        case 1:
                            Intent in = new Intent(getActivity(),OxfordEnglish.class);
                            startActivity(in);
                            break;

                        case 2:
                            Intent intent = new Intent(getActivity(),HighSchoolEnglish.class);
                            startActivity(intent);
                            break;
                    }
                }
                return false;
            }
        });
        // setOnGroupClickListener listener for group heading click
        simpleExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                //get the group header
                GroupInfo headerInfo = deptList.get(groupPosition);
                //display it or do something with it
                Toast.makeText(getActivity(), " Header is :: " + headerInfo.getName(),
                        Toast.LENGTH_LONG).show();

                return false;
            }
        });

        return view;
    }


    //method to expand all groups
    private void expandAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++){
            simpleExpandableListView.expandGroup(i);
        }
    }

    //method to collapse all groups
    private void collapseAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++){
            simpleExpandableListView.collapseGroup(i);
        }
    }

    //load some initial data into out list
    private void loadData(){

        addProduct("English","Advanced Learners functional English");
        addProduct("English","Oxford English for Computing");
        addProduct("English","High School English Grammer and Composition");

        addProduct("Physics-1"," Physics-2");
        addProduct("Physics-1","Fundamentals of Physics");

        addProduct("Math-1","Integral Calculus");
        addProduct("Math-1","Integral Calculus by Abdul Matin");
        addProduct("Math-1","Integral Calculus by B.C Das");
        addProduct("Math-1","Differential Calculus\n");

        addProduct("Math-2","Linear Algebra, Schaums Outline Series");
        addProduct("Math-2","Linear Algebra by Abdur Rahman");

        addProduct("Fundamentals of Computer","Computer Fundamentals");
        addProduct("Fundamentals of Computer","Programming in C");

    }



    //here we maintain our products in various departments
    private int addProduct(String department, String product){

        int groupPosition = 0;

        //check the hash map if the group already exists
        GroupInfo headerInfo = subjects.get(department);
        //add the group if doesn't exists
        if(headerInfo == null){
            headerInfo = new GroupInfo();
            headerInfo.setName(department);
            subjects.put(department, headerInfo);
            deptList.add(headerInfo);
        }

        //get the children for the group
        ArrayList<ChildInfo> productList = headerInfo.getProductList();
        //size of the children list
        int listSize = productList.size();
        //add to the counter
        listSize++;

        //create a new child and add that to the group
        ChildInfo detailInfo = new ChildInfo();
        detailInfo.setSequence(String.valueOf(listSize));
        detailInfo.setName(product);
        productList.add(detailInfo);
        headerInfo.setProductList(productList);

        //find the group position inside the list
        groupPosition = deptList.indexOf(headerInfo);
        return groupPosition;
    }
}
