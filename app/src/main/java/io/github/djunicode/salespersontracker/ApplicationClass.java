package io.github.djunicode.salespersontracker;

import android.app.Application;

public class ApplicationClass extends Application
{
    private static String salespersonName;

    public static String getSalespersonName() {
        return salespersonName;
    }

    public static void setSalespersonName(String salespersonName) {
        ApplicationClass.salespersonName = salespersonName;
    }
}
