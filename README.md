# Advertisement

广告SDK


## 特点

* 代码简单，


## TODO 



# 效果图:

![recyleview](pics/pic1.png)







![config_glide](pics/pic2.png)




```


# 引用

### :



Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
		implementation 'com.github.User:Repo:Tag'
	}

```



# 初始化

### 调用方法前:



 kunAd = KunAd.getInstance(this, "你的渠道号");
        kunAd.setTimeout(5000);

```


# 开屏广告

> 任意时机

```
kunAd.adSplashShow(this, new KunListener() {
            @Override
            public void onAdFailed(String msg) {
                System.out.println(msg);
            }

            @Override
            public void onCancel() {
                startActivity(new Intent(getApplication(), MainActivity.class));
                finish();

            }

            @Override
            public void onSuccess() {

            }

            @Override
            public void onClick() {
                kunAd.onDestroy(SplashActivity.this);
            }

            @Override
            public void onExp() {

            }

            @Override
            public void onStartDownload() {
                startActivity(new Intent(getApplication(), MainActivity.class));
                finish();
            }
        });
```


# 插屏广告

> 任意时机

```
   kunAd.adIntervalShow(SplashActivity.this, new KunListener() {
            @Override
            public void onAdFailed(String msg) {
                System.out.println(msg);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onSuccess() {

            }

            @Override
            public void onClick() {

            }

            @Override
            public void onExp() {

            }

            @Override
            public void onStartDownload() {

            }
        });
```

# 代码混淆


```
 -keep public class * extends android.app.Activity
 -keep public class * extends android.app.Application
 -keep public class * extends android.app.Service
 -keep public class * extends android.content.BroadcastReceiver
 -keep public class * extends android.content.ContentProvider
 -keep public class * extends android.app.backup.BackupAgentHelper
 -keep public class * extends android.preference.Preference
 -keep public class com.android.vending.licensing.ILicensingService
 -keep class com.analytics.sdk.Ads {*;}
 -keep class com.analytics.sdk.model.** {*;}
 -keep class com.analytics.sdk.inter {*;}
```


# 错误码对照表


```
错误码 错误原因
0 请求成功
400 未接受到客户端参数
50001 渠道 ID 不存在
50002 获取广告失败
99 程序内部错误
```


