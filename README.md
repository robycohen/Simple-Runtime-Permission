# Simple Request Runtime Permission
This library Simplify request runtime permission process available in Android M and above.

# Setup
1. Add it in your root build.gradle at the end of repositories
```
allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	}
  
```
2. Add the dependency in your gradle
```
dependencies {
		compile 'com.github.User:Repo:Tag'
	}
```

# Usage
1. Add uses-permission to AndroidManifest
```
<uses-permission android:name="android.permission.CAMERA"/>
```
2. Request Permission
```
SimplePermission.with(MainActivity.this)
                .request(SimplePermission.CAMERA,SimplePermission.WRITE_EXTERNAL_STORAGE)
                .onRequestResultListener(new SimplePermission.OnRequestResult() {
                    @Override
                    public void onGranted() {
                        Toast.makeText(getApplicationContext(),"Permission Granted",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onDenied() {
                        Toast.makeText(getApplicationContext(),"Permission Denied",Toast.LENGTH_LONG).show();
                    }
                });
```

# Screenshots
![alt text](https://github.com/robycohen/Simple-Runtime-Permission/blob/master/preview.png)




