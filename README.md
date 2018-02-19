# Simple Runtime Permission
This library simplify request runtime permission process available in Android M and above.

# Setup
1. Add JitPack repository to your root build.gradle
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
	compile 'com.github.robycohen:Simple-Runtime-Permission:1.0'
}
```

# Usage
1. Add uses-permission to AndroidManifest
```
<uses-permission android:name="android.permission.CAMERA"/>
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
```
2. Request Permissions
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

# License
```
Copyright (C) 2018 Roby Darmansyah

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```


