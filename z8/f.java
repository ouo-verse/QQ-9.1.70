package z8;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0002R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lz8/f;", "", "", "uid", "Lz8/e;", "a", "", "b", "Ljava/util/Map;", "batchUtilMap", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f452141a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, e> batchUtilMap = new LinkedHashMap();

    f() {
    }

    public final e a(String uid) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Map<String, e> map = batchUtilMap;
        e eVar = map.get(uid);
        if (eVar == null) {
            eVar = new e();
            map.put(uid, eVar);
        }
        return eVar;
    }
}
