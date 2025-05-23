package rk3;

import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mb4.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J0\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0002J \u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J \u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0002J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u0011"}, d2 = {"Lrk3/b;", "", "", "mapId", "", ZPlanPublishSource.FROM_SCHEME, "time", "", "a", "event", "", "c", "source", "e", "d", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f431651a = new b();

    b() {
    }

    private final Map<String, String> a(int mapId, String scheme, String time) {
        HashMap hashMap = new HashMap();
        hashMap.put("k_mod_map_id", String.valueOf(mapId));
        if (scheme == null) {
            scheme = "";
        }
        hashMap.put("k_action_scheme", scheme);
        if (time.length() == 0) {
            time = String.valueOf(System.currentTimeMillis());
        }
        hashMap.put("k_action_time", time);
        return hashMap;
    }

    public final void c(String event, int mapId, String scheme) {
        Intrinsics.checkNotNullParameter(event, "event");
        c.c(c.f416532a, event, b(this, mapId, scheme, null, 4, null), false, 4, null);
    }

    public final void d(int mapId, String scheme) {
        c("e_zplan_small_home_float_kill_service", mapId, scheme);
    }

    static /* synthetic */ Map b(b bVar, int i3, String str, String str2, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            str2 = "";
        }
        return bVar.a(i3, str, str2);
    }

    public final void e(int mapId, String scheme, int source) {
        Map b16 = b(this, mapId, scheme, null, 4, null);
        b16.put("k_float_source", String.valueOf(source));
        c.c(c.f416532a, "e_zplan_small_home_float_notification", b16, false, 4, null);
    }
}
