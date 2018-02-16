package com.robydarmansyah.simplepermission;

/**
 * Created by roby on 2/16/18.
 */

public class SimplePermissionInstance {


    private static OnPermissionResult onPermissionResult;
    private static String[] permission;

    public static SimplePermissionInstance requestResult(OnPermissionResult onPermissionResult, String... permission){
        return new SimplePermissionInstance(onPermissionResult,permission);
    }

    private SimplePermissionInstance(OnPermissionResult onPermissionResult, String... permission){
        this.onPermissionResult=onPermissionResult;
        this.permission=permission;
    }

    public static String[] requestPermission(){
        return permission;
    }

    public static void onRequested(boolean granted){
        if(granted){
            onPermissionResult.onGrantedResult();
        }else {
            onPermissionResult.onDeniedResult();
        }
    }


    public interface OnPermissionResult {

        void onGrantedResult();

        void onDeniedResult();
    }

}
