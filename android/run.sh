adb reverse tcp:8081 tcp:8081
./gradlew :app:installDebug
adb shell am start -n com.chaiapp/.MainActivity
adb logcat -s "CHAI"
