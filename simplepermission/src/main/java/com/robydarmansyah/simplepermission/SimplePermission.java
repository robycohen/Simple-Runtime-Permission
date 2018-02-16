package com.robydarmansyah.simplepermission;

import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;

/**
 * Created by roby on 2/16/18.
 */

public class SimplePermission implements SimplePermissionInstance.OnPermissionResult {

    public final static String READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE;
    public final static String WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    public final static String CAMERA = Manifest.permission.CAMERA;
    public final static String ACCESS_FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    public final static String ACCESS_COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    public final static String READ_CALENDAR = Manifest.permission.READ_CALENDAR;
    public final static String WRITE_CALENDAR = Manifest.permission.WRITE_CALENDAR;
    public final static String READ_CONTACTS = Manifest.permission.READ_CONTACTS;
    public final static String GET_ACCOUNTS = Manifest.permission.GET_ACCOUNTS;
    public final static String RECORD_AUDIO = Manifest.permission.RECORD_AUDIO;
    public final static String READ_PHONE_STATE = Manifest.permission.READ_PHONE_STATE;
    public final static String READ_PHONE_NUMBERS = Manifest.permission.READ_PHONE_NUMBERS;
    public final static String CALL_PHONE = Manifest.permission.CALL_PHONE;
    public final static String ANSWER_PHONE_CALLS = Manifest.permission.ANSWER_PHONE_CALLS;
    public final static String READ_CALL_LOG = Manifest.permission.READ_CALL_LOG;
    public final static String WRITE_CALL_LOG = Manifest.permission.WRITE_CALL_LOG;
    public final static String ADD_VOICEMAIL = Manifest.permission.ADD_VOICEMAIL;
    public final static String USE_SIP = Manifest.permission.USE_SIP;
    public final static String PROCESS_OUTGOING_CALLS = Manifest.permission.PROCESS_OUTGOING_CALLS;
    public final static String BODY_SENSORS = Manifest.permission.BODY_SENSORS;
    public final static String SEND_SMS = Manifest.permission.SEND_SMS;
    public final static String RECEIVE_SMS = Manifest.permission.RECEIVE_SMS;
    public final static String READ_SMS = Manifest.permission.READ_SMS;
    public final static String RECEIVE_WAP_PUSH = Manifest.permission.RECEIVE_WAP_PUSH;
    public final static String RECEIVE_MMS = Manifest.permission.RECEIVE_MMS;

    private OnRequestResult onRequestResult;
    private Activity activity;

    private SimplePermission(Activity activity) {
        this.activity = activity;
    }

    public static SimplePermission with(Activity activity) {
        return new SimplePermission(activity);
    }

    public SimplePermission request(String... permissions) {
        initial(activity,permissions);
        return this;
    }

    public void onRequestResultListener(OnRequestResult onRequestResult) {
        this.onRequestResult = onRequestResult;
    }

    private void initial(Context context,String...permissions) {
        Intent intent = getIntent(context, SimplePermissionActivity.class);
        if (context instanceof Application) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
        SimplePermissionInstance.requestResult(this,permissions);
    }

    private Intent getIntent(Context context, Class<?> clazz) {
        return new Intent(context, clazz);
    }

    @Override
    public void onGrantedResult() {
        onRequestResult.onGranted();
    }

    @Override
    public void onDeniedResult() {
        onRequestResult.onDenied();
    }

    public interface OnRequestResult {
        void onGranted();
        void onDenied();
    }

}
