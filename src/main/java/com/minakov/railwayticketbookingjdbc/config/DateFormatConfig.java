package com.minakov.railwayticketbookingjdbc.config;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class DateFormatConfig {

    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    public static SimpleDateFormat userBirthdayFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
}
