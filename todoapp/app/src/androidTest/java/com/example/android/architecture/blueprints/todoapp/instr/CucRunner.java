package com.example.android.architecture.blueprints.todoapp.instr;


import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.test.runner.MonitoringInstrumentation;
import android.util.Log;

import cucumber.api.android.CucumberInstrumentationCore;


public class CucRunner extends MonitoringInstrumentation
{
    private CucumberInstrumentationCore cucumberInstrumentationCore = new CucumberInstrumentationCore(this);

    private static final String TAG="CUC-TEST";

    public CucRunner() {}

    @Override
    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Log.d(TAG, "tarator-runner on Create");
        this.cucumberInstrumentationCore.create(bundle);
        start();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "tarator-runner on Start");
        waitForIdleSync();
        this.cucumberInstrumentationCore.start();

    }

    @Override
    public void finish(int resultCode, Bundle results) {
        //todo smth
        super.finish(resultCode, results);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void callApplicationOnCreate(Application app) {
        super.callApplicationOnCreate(app);
    }


    @Override
    public void callActivityOnCreate(Activity activity, Bundle bundle) {
        super.callActivityOnCreate(activity, bundle);
    }
}