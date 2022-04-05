package zaycev.net;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Build;
import android.widget.Toast;

public class ApplicationStartClass extends Application {
    private static SharedPreferences sharedPreferences;
    private static String sharedPreferencesFile;

    @Override
    public void onCreate() {
        super.onCreate();

        sharedPreferencesFile = getPackageName();
        sharedPreferences = getSharedPreferences(sharedPreferencesFile, MODE_PRIVATE);

        int launchedTimes = sharedPreferences.getInt("launchAmounts", 1);

        SharedPreferences.Editor preferencesEditor = sharedPreferences.edit();


        if (launchedTimes < 3) {
            preferencesEditor.putInt("launchAmounts",
                    launchedTimes + 1);
            preferencesEditor.apply();
        } else if (launchedTimes == 3) {
            Toast.makeText(this, "App launched " + launchedTimes + " times",
                    Toast.LENGTH_SHORT).show();

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                deleteSharedPreferences(sharedPreferencesFile);
            } else {
                preferencesEditor.clear();
            }
        }
    }
}
