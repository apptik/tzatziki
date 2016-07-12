package io.apptik.bddexample;


import android.os.Bundle;
import android.support.test.runner.MonitoringInstrumentation;

import cucumber.api.android.CucumberInstrumentationCore;


public class CucRunner extends MonitoringInstrumentation {
    private CucumberInstrumentationCore cucumberInstrumentationCore = new
            CucumberInstrumentationCore(this);

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        //note you can put those in CucumberOptions also
        bundle.putString("features", "features");
        bundle.putString("glue", "io.apptik.bddexample.test.feature");
        //bundle.putString("tags", "~@skipAndroid");
        this.cucumberInstrumentationCore.create(bundle);
        start();
    }

    @Override
    public void onStart() {
        super.onStart();
        //normally waitForIdleSync this is called by the MonitoringInstrumentation
        //however it'll not hurt if we do it and prevent from errors if Google changes it
        waitForIdleSync();
        this.cucumberInstrumentationCore.start();
    }
}