# KotlinAndroidExamples

Aplicación con ejemplos de uso de kotlin en Android.
- **Clicks Events**
- **Extensions Functions**
- **Intents**
- **Kotlin Android Extensions**
- **Life Cycle (onResume, onCreate, onPause, onDestroy)**
- **ListView**
- **Permisions**
- **Picasso**
- **Shared Preferences**

## Modificación Manifest
- **Permisos**
```
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.CAMERA" />
```
- **Definir parent activity para la parte de intents**
```
        <activity
            android:name=".activities.IntentExtraActivity"
            android:parentActivityName=".MainActivity">
            <meta-data
                android:name="android.support.PARENT_ACTIVITY"
                android:value=".MainActivity" />
        </activity>
```

