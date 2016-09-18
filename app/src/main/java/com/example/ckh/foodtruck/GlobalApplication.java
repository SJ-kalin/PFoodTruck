package com.example.ckh.foodtruck;

import android.app.Activity;
import android.app.Application;
import com.kakao.auth.*;

/**
 * Created by Ckh on 2016-09-16.
 * Application class의 상속
 * AndroidManifest에 등록 해주어야함.
 */
public class GlobalApplication extends Application {
    private static volatile GlobalApplication instance = null;
    private static volatile Activity currentActivity = null;
    public static String User_info_name=null;

    public static Activity getCurrentActivity() {
        return currentActivity;
    }
    // Activity가 올라올때마다 Activity의 onCreate에서 호출해줘야한다.

    public static void setCurrentActivity(Activity currentActivity) {
        GlobalApplication.currentActivity = currentActivity;
    }
    public static GlobalApplication getGlobalApplicationContext() {
        if(instance == null)
            throw new IllegalStateException("this application does not inherit com.kakao.GlobalApplication");
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        KakaoSDK.init(new KakaoSDKAdapter());

    }
    /**
     * 애플리케이션 종료시 singleton 어플리케이션 객체 초기화한다.
     */
    @Override
    public void onTerminate() {
        super.onTerminate();
        instance = null;
    }
}