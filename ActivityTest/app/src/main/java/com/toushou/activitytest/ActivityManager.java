package com.toushou.activitytest;

import android.app.Activity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by toushou on 05/12/2017.
 */

public class ActivityManager {
    private static final String TAG = "ActivityManager";
    private static List<Activity> activities = new ArrayList<Activity>();

    public static void AddActivity(Activity activity){
        activities.add(activity);
    }

    public static void RemoveActivity(Activity activity){
        activities.remove(activity);
        activity.finish();
    }

    public static void FinishAll(){
        for (Activity activity :
                activities) {
            if(!activity.isFinishing()){
                // can't change activities now.
//                activities.remove(activity);
                activity.finish();
            }
        }
    }

    public static void ShowAll(){
        Log.d(TAG, "ShowAll: Start...");
        for (int i = 0; i < activities.size(); i++) {
            String currentActivityClassName = activities.get(i).getClass().getSimpleName();
            Log.d(TAG, "activity " + i + " is - " + currentActivityClassName);
        }
        Log.d(TAG, "ShowAll: End...");
    }
}
