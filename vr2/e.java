package vr2;

import com.tencent.mobileqq.aio.utils.b;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0002J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0003\u00a8\u0006\r"}, d2 = {"Lvr2/e;", "", "", "", "a", "eid", "", "chatType", "timbreId", "", "b", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f443201a = new e();

    e() {
    }

    private final Map<String, Object> a() {
        Map<String, Object> emptyMap;
        com.tencent.mobileqq.aio.utils.a e16;
        Map<String, Object> a16;
        b.a g16 = com.tencent.mobileqq.aio.utils.b.f194119a.g();
        if (g16 != null && (e16 = g16.e()) != null && (a16 = e16.a()) != null) {
            return a16;
        }
        emptyMap = MapsKt__MapsKt.emptyMap();
        return emptyMap;
    }

    public final void b(String eid, int chatType, String timbreId) {
        Intrinsics.checkNotNullParameter(eid, "eid");
        Intrinsics.checkNotNullParameter(timbreId, "timbreId");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("dt_pgid", "pg_aio");
        linkedHashMap.put("qq_pgid", "pg_aio");
        linkedHashMap.put("eid", eid);
        linkedHashMap.put("qq_eid", eid);
        linkedHashMap.put("cur_pg", a());
        linkedHashMap.put("chat_type", Integer.valueOf(chatType));
        linkedHashMap.put("timbre_id", timbreId);
        VideoReport.reportEvent("qq_clck", linkedHashMap);
    }

    public static /* synthetic */ void c(e eVar, String str, int i3, String str2, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        if ((i16 & 4) != 0) {
            str2 = "";
        }
        eVar.b(str, i3, str2);
    }
}
