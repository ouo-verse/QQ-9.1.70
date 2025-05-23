package u5;

import android.content.SharedPreferences;
import android.text.TextUtils;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public static class a implements SharedPreferences.Editor {

        /* renamed from: d, reason: collision with root package name */
        private final SharedPreferences.Editor f438269d;

        public a(SharedPreferences.Editor editor) {
            this.f438269d = editor;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            commit();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.f438269d.clear();
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            this.f438269d.apply();
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z16) {
            this.f438269d.putBoolean(str, z16);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f16) {
            this.f438269d.putFloat(str, f16);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i3) {
            this.f438269d.putInt(str, i3);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j3) {
            this.f438269d.putLong(str, j3);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            this.f438269d.putString(str, str2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            this.f438269d.putStringSet(str, set);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            this.f438269d.remove(str);
            return this;
        }
    }

    public static void A(String str, String str2, boolean z16) {
        SharedPreferences.Editor c16 = c(str);
        c16.putBoolean(str2, z16);
        c16.commit();
    }

    public static void B(String str, boolean z16) {
        A(LocalMultiProcConfig.PREFS_NAME_LOCAL_QZ_SETTING, str, z16);
    }

    public static void C(String str, boolean z16, long j3) {
        SharedPreferences.Editor d16 = d(j3);
        d16.putBoolean(str, z16);
        d16.commit();
    }

    public static void D(String str, int i3) {
        E(LocalMultiProcConfig.PREFS_NAME_LOCAL_QZ_SETTING, str, i3);
    }

    public static void E(String str, String str2, int i3) {
        SharedPreferences.Editor c16 = c(str);
        c16.putInt(str2, i3);
        c16.commit();
    }

    public static void F(String str, int i3, long j3) {
        SharedPreferences.Editor d16 = d(j3);
        d16.putInt(str, i3);
        d16.commit();
    }

    public static void G(String str, long j3) {
        H(LocalMultiProcConfig.PREFS_NAME_LOCAL_QZ_SETTING, str, j3);
    }

    public static void H(String str, String str2, long j3) {
        SharedPreferences.Editor c16 = c(str);
        c16.putLong(str2, j3);
        c16.commit();
    }

    public static void I(String str, long j3, long j16) {
        SharedPreferences.Editor d16 = d(j16);
        d16.putLong(str, j3);
        d16.commit();
    }

    public static void J(String str, String str2) {
        K(LocalMultiProcConfig.PREFS_NAME_LOCAL_QZ_SETTING, str, str2);
    }

    public static void K(String str, String str2, String str3) {
        SharedPreferences.Editor c16 = c(str);
        c16.putString(str2, str3);
        c16.commit();
    }

    public static void L(String str, String str2, long j3) {
        SharedPreferences.Editor d16 = d(j3);
        d16.putString(str, str2);
        d16.commit();
    }

    private static void O(long j3) {
        I("wns_next_public_push_time", System.currentTimeMillis() + (QZoneConfigHelper.n0() * 1000), j3);
    }

    public static void P(String str) {
        SharedPreferences.Editor b16 = b();
        b16.remove(str);
        b16.commit();
    }

    public static void Q(String str, long j3) {
        SharedPreferences.Editor d16 = d(j3);
        d16.remove(str);
        d16.commit();
    }

    public static void R(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        B("occur_forward_action" + str, z16);
    }

    public static boolean a(String str) {
        return o().contains(str);
    }

    public static SharedPreferences.Editor b() {
        return c(LocalMultiProcConfig.PREFS_NAME_LOCAL_QZ_SETTING);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static SharedPreferences.Editor c(String str) {
        return new a(p(str).edit());
    }

    public static SharedPreferences.Editor d(long j3) {
        return new a(q(j3).edit());
    }

    public static boolean e(String str, String str2, boolean z16) {
        return p(str).getBoolean(str2, z16);
    }

    public static boolean f(String str, boolean z16) {
        return e(LocalMultiProcConfig.PREFS_NAME_LOCAL_QZ_SETTING, str, z16);
    }

    public static boolean g(String str, boolean z16, long j3) {
        return q(j3).getBoolean(str, z16);
    }

    public static int h(String str, int i3) {
        return i(LocalMultiProcConfig.PREFS_NAME_LOCAL_QZ_SETTING, str, i3);
    }

    public static int i(String str, String str2, int i3) {
        return p(str).getInt(str2, i3);
    }

    public static int j(String str, int i3, long j3) {
        return q(j3).getInt(str, i3);
    }

    public static long k(String str, long j3) {
        return l(LocalMultiProcConfig.PREFS_NAME_LOCAL_QZ_SETTING, str, j3);
    }

    public static long l(String str, String str2, long j3) {
        return p(str).getLong(str2, j3);
    }

    public static long m(String str, long j3, long j16) {
        return q(j16).getLong(str, j3);
    }

    public static boolean n(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return f("occur_forward_action" + str, false);
    }

    public static SharedPreferences o() {
        return p(LocalMultiProcConfig.PREFS_NAME_LOCAL_QZ_SETTING);
    }

    public static long r(long j3) {
        return m("server_next_public_push_time", 0L, j3);
    }

    public static String s(String str, String str2) {
        return t(LocalMultiProcConfig.PREFS_NAME_LOCAL_QZ_SETTING, str, str2);
    }

    public static String t(String str, String str2, String str3) {
        return p(str).getString(str2, str3);
    }

    public static String u(String str, String str2, long j3) {
        return q(j3).getString(str, str2);
    }

    public static int v() {
        return h("qzone_sync_qfs_memory_count", 0);
    }

    public static long w(long j3) {
        return m("wns_next_public_push_time", 0L, j3);
    }

    public static void x(long j3) {
        C("qzone_sync_qfs_memory_bubble_show", true, j3);
    }

    public static void y(int i3) {
        D("qzone_sync_qfs_memory_count", i3);
    }

    public static boolean z(long j3) {
        return g("qzone_sync_qfs_memory_bubble_show", false, j3);
    }

    public static SharedPreferences p(String str) {
        return LocalMultiProcConfig.getPreferences(str, 0);
    }

    public static void M(HashMap<String, String> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return;
        }
        SharedPreferences.Editor c16 = c(LocalMultiProcConfig.PREFS_NAME_LOCAL_QZ_SETTING);
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            c16.putString(entry.getKey(), entry.getValue());
        }
        c16.commit();
    }

    public static void N(long j3, long j16) {
        I("server_next_public_push_time", j3 * 1000, j16);
        O(j16);
    }

    public static SharedPreferences q(long j3) {
        String str;
        if (j3 == 0) {
            str = LocalMultiProcConfig.PREFS_NAME_LOCAL_QZ_SETTING;
        } else {
            str = j3 + "_preference";
        }
        return p(str);
    }
}
