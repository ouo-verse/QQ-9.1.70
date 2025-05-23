package uk3;

import com.tencent.mobileqq.zplan.model.AccessibleDetail;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002J\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\u0003\u001a\u00020\u0002JF\u0010\u000f\u001a\u00020\u00062>\u0010\u000e\u001a:\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\n\u0018\u00010\fj\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\n\u0018\u0001`\rRV\u0010\u0015\u001a6\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\n0\fj\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\n`\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Luk3/b;", "", "", "uin", "Lcom/tencent/mobileqq/zplan/model/AccessibleDetail;", "detail", "", "e", "scene", "b", "", "c", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "otherMap", "d", "Ljava/util/HashMap;", "a", "()Ljava/util/HashMap;", "setAccessibleCache", "(Ljava/util/HashMap;)V", "accessibleCache", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f439110a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static HashMap<Long, Map<Long, AccessibleDetail>> accessibleCache = new HashMap<>();

    b() {
    }

    public final HashMap<Long, Map<Long, AccessibleDetail>> a() {
        return accessibleCache;
    }

    public final AccessibleDetail b(long uin, long scene) {
        if (i.f439124a.d()) {
            QLog.i("AccessibleDetailMemoryCache", 1, "getAccessibleDetail is ForceAccessible");
            return new AccessibleDetail(scene, 1, 1, 1, 1, 1, 2, 1);
        }
        return c(uin).get(Long.valueOf(scene));
    }

    public final synchronized Map<Long, AccessibleDetail> c(long uin) {
        Map<Long, AccessibleDetail> map;
        map = accessibleCache.get(Long.valueOf(uin));
        if (map == null) {
            map = new HashMap<>();
            accessibleCache.put(Long.valueOf(uin), map);
        }
        return map;
    }

    public final synchronized void d(HashMap<Long, Map<Long, AccessibleDetail>> otherMap) {
        if (otherMap == null) {
            return;
        }
        for (Map.Entry<Long, Map<Long, AccessibleDetail>> entry : otherMap.entrySet()) {
            Map<Long, AccessibleDetail> value = entry.getValue();
            Map<Long, AccessibleDetail> map = accessibleCache.get(entry.getKey());
            if (map == null) {
                accessibleCache.put(entry.getKey(), value);
            } else {
                for (Map.Entry<Long, AccessibleDetail> entry2 : value.entrySet()) {
                    if (map.get(entry2.getKey()) == null) {
                        map.put(entry2.getKey(), entry2.getValue());
                    }
                }
            }
        }
    }

    public final void e(long uin, AccessibleDetail detail) {
        Intrinsics.checkNotNullParameter(detail, "detail");
        c(uin).put(Long.valueOf(detail.getAppid()), detail);
    }
}
