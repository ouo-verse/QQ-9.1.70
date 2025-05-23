package vu;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.tencent.av.mmkv.QavMMKVMigrateTask;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, String> f443504b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private static final Map<String, QavMMKVMigrateTask> f443505c = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    private final MMKVOptionEntity f443506a = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QAV);

    /* compiled from: P */
    /* renamed from: vu.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C11441a {

        /* renamed from: a, reason: collision with root package name */
        private static final a f443507a = new a();
    }

    a() {
    }

    public static a c() {
        return C11441a.f443507a;
    }

    public static boolean e(@NonNull AppRuntime appRuntime, @NonNull String str, boolean z16) {
        return QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").getBoolean(str, z16, true);
    }

    private static SharedPreferences f(String str, int i3) {
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(MobileQQ.sMobileQQ, str, QMMKVFile.FILE_QAV);
        Map<String, String> map = f443504b;
        if (map.containsKey(str)) {
            return new b(fromSpAdapter, str, QMMKVFile.FILE_QAV, true);
        }
        if (fromSpAdapter.getBoolean("_qav_migrate_flag_", false)) {
            map.put(str, str);
            if (str.equals("qav_config_287_0")) {
                QLog.d("QavMMKV", 1, "Migrate. MoreFuc=" + fromSpAdapter.getInt("MoreFuc", 0));
            }
            return new b(fromSpAdapter, str, QMMKVFile.FILE_QAV, true);
        }
        Map<String, QavMMKVMigrateTask> map2 = f443505c;
        if (map2.get(str) == null) {
            QavMMKVMigrateTask qavMMKVMigrateTask = new QavMMKVMigrateTask(str, i3, QMMKVFile.FILE_QAV);
            map2.put(str, qavMMKVMigrateTask);
            ThreadManagerV2.excute(qavMMKVMigrateTask, 16, null, true);
        }
        return new b(MobileQQ.sMobileQQ.getSharedPreferences(str, i3), str, QMMKVFile.FILE_QAV, false);
    }

    public static SharedPreferences g(@NonNull String str) {
        return h(str, 4);
    }

    public static SharedPreferences h(@NonNull String str, int i3) {
        return f(str, i3);
    }

    private String l(String str, String str2) {
        return str + "_" + str2;
    }

    public static void o(@NonNull AppRuntime appRuntime, @NonNull String str, boolean z16) {
        QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").putBoolean(str, z16, true);
    }

    public long a(String str) {
        return this.f443506a.decodeLong(l(str, "KEY_OLK_AUTH_DEADLINE"), 0L);
    }

    public MMKVOptionEntity b() {
        return this.f443506a;
    }

    public long d(String str) {
        return this.f443506a.decodeLong(str, 0L);
    }

    public String i(String str) {
        return this.f443506a.decodeString(str, "");
    }

    public boolean j(String str) {
        return this.f443506a.decodeBool(l(str, "KEY_OLK_AUTH_RESULT"), false);
    }

    public boolean k() {
        return this.f443506a.decodeBool(l(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount(), "KEY_ENABLE_VIDEO_SR"), false);
    }

    public void m(String str, long j3) {
        this.f443506a.encodeLong(str, j3);
    }

    public void n(String str, String str2) {
        this.f443506a.encodeString(str, str2);
    }

    public void p(String str, long j3) {
        this.f443506a.encodeLong(l(str, "KEY_OLK_AUTH_DEADLINE"), j3);
    }

    public void q(String str, boolean z16) {
        this.f443506a.encodeBool(l(str, "KEY_OLK_AUTH_RESULT"), z16);
    }

    public void r(boolean z16) {
        this.f443506a.encodeBool(l(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount(), "KEY_ENABLE_VIDEO_SR"), z16);
    }
}
