package ut3;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.qqlive.superplayer.tools.utils.d;
import com.tencent.qqlive.tvkplayer.tpplayer.tools.TVKPlayerStrategy;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static int f440021a = -1;

    public static SharedPreferences a(Context context) {
        try {
            String str = context.getPackageName() + "_preferences";
            d.d("MediaPlayerMgr[TVKPlayerStrategy.java]", "getSharedPreferences, name = " + str);
            return context.getSharedPreferences(str, 0);
        } catch (Exception e16) {
            d.b("MediaPlayerMgr[TVKPlayerStrategy.java]", e16);
            d.d("MediaPlayerMgr[TVKPlayerStrategy.java]", "[getSharedPreferences] Failed to get SharedPreferences");
            return null;
        }
    }

    public static boolean b(Context context) {
        int i3 = f440021a;
        if (i3 != -1) {
            if (i3 == 0) {
                return false;
            }
            return true;
        }
        f440021a = 0;
        return false;
    }

    public static boolean c(Context context) {
        int i3 = f440021a;
        if (i3 != -1) {
            if (i3 != 0) {
                return true;
            }
            return false;
        }
        f440021a = 0;
        SharedPreferences a16 = a(context);
        if (a16 == null) {
            d.d("MediaPlayerMgr[TVKPlayerStrategy.java]", "[isBlackListForSelfPlayerByCrash] Failed to get SharedPreferences");
            return false;
        }
        try {
            boolean z16 = a16.getBoolean(TVKPlayerStrategy.SELFPLAYER_CRASH_STATE, false);
            int i16 = a16.getInt(TVKPlayerStrategy.SELFPLAYER_CRASH_STATE, 0);
            if (z16) {
                int i17 = i16 + 1;
                if (i17 > vt3.d.X0.a().intValue()) {
                    f440021a = 1;
                    d.d("MediaPlayerMgr[TVKPlayerStrategy.java]", "isBlackListForSelfPlayerByCrash, crashCountInt: " + i17);
                    i17 = 0;
                } else {
                    f440021a = 0;
                }
                a16.edit().putInt(TVKPlayerStrategy.SELFPLAYER_CRASH_COUNT, i17).apply();
            } else {
                f440021a = 0;
                a16.edit().putInt(TVKPlayerStrategy.SELFPLAYER_CRASH_COUNT, 0).apply();
            }
            a16.edit().putBoolean(TVKPlayerStrategy.SELFPLAYER_CRASH_STATE, false).apply();
        } catch (Exception e16) {
            d.b("MediaPlayerMgr[TVKPlayerStrategy.java]", e16);
        }
        if (f440021a != 0) {
            return true;
        }
        return false;
    }

    public static boolean d(Context context) {
        int i3;
        boolean z16;
        SharedPreferences a16 = a(context);
        if (a16 == null) {
            d.d("MediaPlayerMgr[TVKPlayerStrategy.java]", "[isEnabledHWDec] Failed to get SharedPreferences");
            return true;
        }
        try {
            boolean z17 = false;
            if (!a16.getBoolean(TVKPlayerStrategy.HARDWARE_ACCELERATE_STATE, true)) {
                d.d("MediaPlayerMgr[TVKPlayerStrategy.java]", "[isEnabledHWDec] HA user setting: false");
                return false;
            }
            boolean z18 = a16.getBoolean(TVKPlayerStrategy.HARDWARE_ACCELERATE_CRASH, false);
            int i16 = a16.getInt(TVKPlayerStrategy.HA_TURN_OFF_COUNT, 0);
            int i17 = a16.getInt(TVKPlayerStrategy.HA_CRASH_COUNT, 0);
            if (z18) {
                i3 = vt3.d.f443489z.a().intValue();
                i17++;
                if (i17 > vt3.d.A.a().intValue()) {
                    a16.edit().putBoolean(TVKPlayerStrategy.HARDWARE_ACCELERATE_STATE, false).apply();
                    z16 = false;
                    i3 = 0;
                    i17 = 0;
                } else if (i3 <= 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                a16.edit().putBoolean(TVKPlayerStrategy.HARDWARE_ACCELERATE_CRASH, false).apply();
            } else {
                i3 = i16 - 1;
                if (i3 < (-vt3.d.B.a().intValue())) {
                    i3 = 0;
                    i17 = 0;
                }
                if (i3 <= 0) {
                    z17 = true;
                }
                z16 = z17;
            }
            d.d("MediaPlayerMgr[TVKPlayerStrategy.java]", "[isEnabledHWDec]isCrash:" + z18 + ", crashCount:" + i17 + ", turnOffCount:" + i3 + ", HA enabled:" + z16 + ", ha_crash_retry_interval:" + vt3.d.f443489z.a() + ", ha_crash_retry_count:" + vt3.d.A.a() + ", ha_crash_reset_interval:" + vt3.d.B.a());
            a16.edit().putInt(TVKPlayerStrategy.HA_CRASH_COUNT, i17).apply();
            a16.edit().putInt(TVKPlayerStrategy.HA_TURN_OFF_COUNT, i3).apply();
            return z16;
        } catch (Exception e16) {
            d.b("MediaPlayerMgr[TVKPlayerStrategy.java]", e16);
            d.d("MediaPlayerMgr[TVKPlayerStrategy.java]", "[isEnabledHWDec] failed to get user setting: true by default");
            return true;
        }
    }

    public static boolean e(Context context) {
        if (b(context) || c(context)) {
            return false;
        }
        return true;
    }
}
