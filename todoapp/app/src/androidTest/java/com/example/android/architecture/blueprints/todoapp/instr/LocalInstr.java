package com.example.android.architecture.blueprints.todoapp.instr;

import android.os.Bundle;

public class LocalInstr extends CucRunner {

    @Override
    public void onCreate(final Bundle bundle) {
        bundle.putString("features", "features");
        bundle.putString("glue", "com.example.android.architecture.blueprints.todoapp.feature");
        bundle.putString("tags", "@newAndroid--~@skip--~@skipAndroid");
        super.onCreate(bundle);
    }

}
