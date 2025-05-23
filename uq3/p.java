package uq3;

import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Object> f439820a = new ConcurrentHashMap<>();

    public static boolean a(@NonNull String str) {
        boolean E;
        ConcurrentHashMap<String, Object> concurrentHashMap = f439820a;
        Object obj = concurrentHashMap.get(str);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        synchronized (p.class) {
            E = o.E();
            concurrentHashMap.put(str, Boolean.valueOf(E));
        }
        QLog.d("QFSUnitedConfigHelperWithCache", 1, "enableUseNativeFragment:" + E);
        return E;
    }
}
