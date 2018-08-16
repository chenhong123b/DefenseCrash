# DefenseCrash Document
Defense the java crash for Android applications.

[![License](https://img.shields.io/badge/license-Apache%202-green.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![Download](https://api.bintray.com/packages/xuuhaoo/maven/DefenseCrash/images/download.svg)](https://bintray.com/xuuhaoo/maven/DefenseCrash/_latestVersion)

### <font id="1">DefenseCrash</font>
The library is designed to catch Java crashes, which can be effectively reduced by integrating DefenseCrash, such as avoid NPE or IOB crashes during use, improve user experience.

### <font id="2">Maven Configuration</font>

* <font size=2>Please add the code into your project gradle file</font>

```groovy
allprojects {
    repositories {
    	maven { url 'https://dl.bintray.com/xuuhaoo/maven/'}
    }
}
```

* <font size=2>Make sure you already done with above instructions in project gradle 
files, than you need put this into Module build.gradle file</font>

```groovy
dependencies {
    compile 'com.tonystark.android:defense_crash:2.0.0'
}
```

### <font id=“3”> DefenseCrash Integrated </font>

<font size=2>We provide you two options for choosing: </font>

* <font size=2>Options 1: You should manually install the defense as following code</font>

```java
public class MyApp extends Application implements IExceptionHandler {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
	// step1: Initialize the lib.
        DefenseCrash.initialize();
	// setp2: Install the fire wall defense.
        DefenseCrash.install(this);
    }

    @Override
    public void onCaughtException(Thread thread, Throwable throwable, boolean isSafeMode) {
	// step3: Print the error when crashed during runtime.
        throwable.printStackTrace();
	// step4: Upload this throwable to your crash collection sdk.
    }

    @Override
    public void onEnterSafeMode() {
	// We enter the safe mode to keep the main looper loop after crashed.You’d better do nothing here,we just notify you.
    }

    @Override
    public void onMayBeBlackScreen(Throwable throwable) {
	// onLayout(),onMeasure() or onDraw() has breaks down,
	// it causes the drawing to be abnormal and the choreographer to break down.
	// We will notify you on this method,you’d better finish this activity or restart the application.
    }
}
```

* <font size=2>Options 2: To facilitate some users, we provide a DefenseCrashApplication super class for you to integrate,as following code</font>

```java
public class MyApp extends DefenseCrashApplication {
    @Override
    public void onCaughtException(Thread thread, Throwable throwable, boolean isSafeMode) {
		// step1: Print the error when crashed during runtime.
        throwable.printStackTrace();
		// step2: Upload this throwable to your crash collection sdk.
    }

    @Override
    public void onEnterSafeMode() {
		// We enter the safe mode to keep the main looper loop after crashed.You’d better do nothing here,we just notify you.
    }

    @Override
    public void onMayBeBlackScreen(Throwable throwable) {
		// onLayout(),onMeasure() or onDraw() has breaks down, 
		// it causes the drawing to be abnormal and the choreographer to break down.
		// We will notify you on this method,you’d better finish this activity or restart the application.
    }
}
```
#It is Done!

---

### <font id=“4”> Licenses </font>
```
   Copyright [2018] [徐昊]

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