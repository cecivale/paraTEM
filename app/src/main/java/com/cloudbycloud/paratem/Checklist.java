package com.cloudbycloud.paratem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.LinkedList;

public class Checklist extends AppCompatActivity {

    private static final String LOG_TAG =
            Checklist.class.getSimpleName();

    private final LinkedList<String> checklistItems = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private ChecklistAdapter mAdapter;
    private int yesCount = 0;
    private int noCount = 0;
    private TextView mYesCount;
    private TextView mNoCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist);

        // TODO create dataset checklist
        for (int i = 0; i < 14; i++) {
            checklistItems.addLast("Item " + i);
        }

        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.recyclerview);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new ChecklistAdapter(this, checklistItems);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,  LinearLayoutManager.HORIZONTAL, false));
        mRecyclerView.setLayoutFrozen(true);

        // Get references to counts
        mYesCount = (TextView) findViewById(R.id.num_scoreYes);
        mNoCount = (TextView) findViewById(R.id.num_scoreNo);
    }

    public void gotoNextItem(View view) {
        mRecyclerView.setLayoutFrozen(false);
        Log.d(LOG_TAG, "Go to next called");
        int position = ((LinearLayoutManager) mRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
        ((LinearLayoutManager) mRecyclerView.getLayoutManager()).scrollToPositionWithOffset(position + 1, 1);
        mRecyclerView.setLayoutFrozen(true);
        String buttonType = view.getTag().toString();
        Log.d(LOG_TAG, buttonType);
        if (buttonType.equals("Yes")) {
            ++yesCount;
            if (mYesCount != null)
                mYesCount.setText(Integer.toString(yesCount));
        } else if (buttonType.equals("No")) {
            ++noCount;
            Log.d(LOG_TAG, String.valueOf(noCount));
            if (mNoCount != null)
                mNoCount.setText(Integer.toString(noCount));
        }
        return;
    }

}

