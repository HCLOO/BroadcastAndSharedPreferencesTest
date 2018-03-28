package com.example.think.broatcastandsharedtest;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Think on 2018/3/21.
 */

public class ActivityCollector {

    public static List<Activity> activityList=new ArrayList<>();

    public static void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activityList.remove(activity);
    }

    public static void removeAll() {
        for (Activity activity : activityList)
            if (!activity.isFinishing())
                activity.finish();
        activityList.clear();
    }
}
