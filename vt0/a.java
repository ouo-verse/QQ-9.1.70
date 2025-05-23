package vt0;

import android.content.Context;
import android.provider.Settings;

/* compiled from: P */
@Deprecated
/* loaded from: classes7.dex */
public final class a {
    public static boolean a(Context context) {
        int i3;
        try {
            i3 = Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation");
        } catch (Settings.SettingNotFoundException e16) {
            e16.printStackTrace();
            i3 = 0;
        }
        if (i3 != 1) {
            return false;
        }
        return true;
    }
}
