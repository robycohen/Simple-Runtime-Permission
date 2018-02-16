package com.robydarmansyah.simplepermission;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.PermissionChecker;
import android.view.WindowManager;

/**
 * Created by roby on 2/16/18.
 */

public class SimplePermissionActivity extends Activity{


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        checkPermission();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        checkPermission();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void checkPermission(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if (!checkHasPermissions(SimplePermissionInstance.requestPermission())) {
                requestPermissions(SimplePermissionInstance.requestPermission(), 17276);
            }else {
                SimplePermissionInstance.onRequested(true);
                finish();
            }
        }else {
            SimplePermissionInstance.onRequested(true);
            finish();
        }
    }

    private boolean checkHasPermissions(String... permissions) {
        for (String permission : permissions) {
            if (ActivityCompat.checkSelfPermission(this,permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

            if (requestCode == 17276) {
                boolean allgranted = false;

                for (int i = 0; i < grantResults.length; i++) {
                    if (grantResults[i] == PermissionChecker.PERMISSION_GRANTED) {
                        allgranted = true;
                    } else {
                        allgranted = false;
                        break;
                    }
                }

                if (allgranted) {
                    SimplePermissionInstance.onRequested(true);
                } else {
                    SimplePermissionInstance.onRequested(false);
                }
            }

        finish();
    }

}
