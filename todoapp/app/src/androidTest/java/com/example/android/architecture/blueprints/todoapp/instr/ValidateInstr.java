package com.example.android.architecture.blueprints.todoapp.instr;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.Iterator;

import cucumber.api.CucumberOptions;
import cucumber.runtime.ClassFinder;
import cucumber.runtime.CucumberException;
import cucumber.runtime.RuntimeOptionsFactory;
import cucumber.runtime.android.DexClassFinder;
import dalvik.system.DexFile;

public class ValidateInstr extends CucRunner {


    private ClassFinder classFinder;

    @Override
    public void onCreate(final Bundle bundle) {
        bundle.putString("features", "features");
        bundle.putString("glue", "com.example.android.architecture.blueprints.todoapp.feature");
        bundle.putString("tags", "@newAndroid--~@skip--~@skipAndroid");
        bundle.putString("format", "json:" + getContext().getFilesDir().getAbsolutePath() + "/cuc");
        Log.e("CUC-TEST", "cuc bundle: " + bundle);
        Log.e("CUC-TEST", "logs: " + getContext().getFilesDir().getAbsolutePath());
        this.classFinder = this.createDexClassFinder(this.getContext());
        Iterator var2 = this.classFinder.getDescendants(Object.class, this.getContext().getPackageName()).iterator();

        Class clazz;
        do {
            if(!var2.hasNext()) {
                throw new CucumberException("No CucumberOptions annotation");
            }

            clazz = (Class)var2.next();
            Log.e("TMP cuc", "Class check: " + clazz);
        } while(!clazz.isAnnotationPresent(CucumberOptions.class));

        Log.d("TMP cuc", "Found CucumberOptions in class " + clazz.getName());
        RuntimeOptionsFactory factory = new RuntimeOptionsFactory(clazz);

        super.onCreate(bundle);
    }

    private ClassFinder createDexClassFinder(Context context) {
        String apkPath = context.getPackageCodePath();
        return new DexClassFinder(this.newDexFile(apkPath));
    }

    private DexFile newDexFile(String apkPath) {
        try {
            return new DexFile(apkPath);
        } catch (IOException var3) {
            throw new CucumberException("Failed to open " + apkPath);
        }
    }

    @Override
    public void finish(int resultCode, Bundle results) {
        Log.e("CUC-TEST", "cuc results: " + results);
        super.finish(resultCode, results);
    }
}
