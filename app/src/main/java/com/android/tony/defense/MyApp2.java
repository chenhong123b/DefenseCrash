package com.android.tony.defense;

import android.app.Application;
import android.content.Context;

import com.android.tony.defenselib.DefenseCrash;
import com.android.tony.defenselib.DefenseCrashApplication;
import com.android.tony.defenselib.handler.IExceptionHandler;

public class MyApp2 extends DefenseCrashApplication {

    @Override
    public void onCaughtException(Thread thread, Throwable throwable, boolean isSafeMode) {
        throwable.printStackTrace();
    }


}
