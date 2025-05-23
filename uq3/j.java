package uq3;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qmmkv.MMKVAdapter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qcircle.cooperation.config.QFSMMKVMigrateTask;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes22.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static final Set<String> f439808a = new CopyOnWriteArraySet();

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, QFSMMKVMigrateTask> f439809b = new ConcurrentHashMap();

    public static MMKVAdapter a(@NonNull Context context, @NonNull String str) {
        return (MMKVAdapter) QMMKV.fromSpAdapter(context, str, "QCIRCLE_MMKV_COMMON");
    }

    public static String b(String str) {
        return "sp_has_migrate_" + str;
    }

    public static SharedPreferences c(@NonNull String str, int i3, boolean z16) {
        Application application = RFWApplication.getApplication();
        if (application == null) {
            return null;
        }
        MMKVAdapter a16 = a(application, str);
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_use_mmkv_direct_9030", true)) {
            return new m(a16, str, true, z16);
        }
        Set<String> set = f439808a;
        if (set.contains(str)) {
            return new m(a16, str, true, z16);
        }
        if (a16.getBoolean(b(str), false)) {
            set.add(str);
            QLog.d("QFSMMKVMigrateUtil", 1, "[getSharedPreferences] hasMigrate spName=" + str);
            return new m(a16, str, true, z16);
        }
        Map<String, QFSMMKVMigrateTask> map = f439809b;
        if (map.get(str) == null) {
            QFSMMKVMigrateTask qFSMMKVMigrateTask = new QFSMMKVMigrateTask(str, z16);
            map.put(str, qFSMMKVMigrateTask);
            RFWThreadManager.getInstance().getSerialThreadHandler().post(qFSMMKVMigrateTask);
            QLog.d("QFSMMKVMigrateUtil", 1, "[getSharedPreferences] create migrateTask spName=" + str);
        }
        QLog.w("QFSMMKVMigrateUtil", 1, "sp has not migrate to mmkv\uff0cuse old spName=" + str);
        return new m(application.getSharedPreferences(str, i3), str, false, false);
    }

    private static boolean d(Object obj) {
        if (obj instanceof Set) {
            Iterator it = ((Set) obj).iterator();
            while (it.hasNext()) {
                if (it.next() instanceof String) {
                    return true;
                }
            }
        }
        if (obj instanceof HashSet) {
            Iterator it5 = ((HashSet) obj).iterator();
            while (it5.hasNext()) {
                if (it5.next() instanceof String) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean e(Context context, String str, boolean z16) {
        Map<String, ?> map;
        int i3;
        String key;
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 4);
        if (sharedPreferences != null) {
            map = sharedPreferences.getAll();
        } else {
            map = null;
        }
        MMKVAdapter a16 = a(context, str);
        if (map != null) {
            i3 = map.size();
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
            for (Map.Entry<String, ?> entry : map.entrySet()) {
                if (z16) {
                    key = entry.getKey() + "_" + account;
                } else {
                    key = entry.getKey();
                }
                Object value = entry.getValue();
                if (!TextUtils.isEmpty(key) && value != null) {
                    if (value instanceof Boolean) {
                        a16.putBoolean(key, ((Boolean) value).booleanValue());
                    } else if (value instanceof Integer) {
                        a16.putInt(key, ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        a16.putLong(key, ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        a16.putFloat(key, ((Float) value).floatValue());
                    } else if (value instanceof String) {
                        a16.putString(key, (String) value);
                    } else if (d(value)) {
                        a16.putStringSet(key, (Set) value);
                    } else {
                        QLog.e("QFSMMKVMigrateUtil", 1, "[migrateToSpAdapter] error: spName=" + str, ", key=", key + ", val=" + value);
                    }
                }
            }
        }
        a16.putBoolean(b(str), true);
        f439809b.remove(str);
        QLog.d("QFSMMKVMigrateUtil", 1, "[migrateToSpAdapter] success, spName=" + str, ", size=" + i3);
        return true;
    }
}
