package wv0;

import com.tencent.icgame.api.ITimiGameApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005J.\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0005\u00a8\u0006\u0011"}, d2 = {"Lwv0/b;", "", "", "", "a", "", "giftMainId", "invokeSource", "", "b", "giftBatchId", "", "isCombo", "comboCnt", "c", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f446564a = new b();

    b() {
    }

    private final Map<String, String> a() {
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", "pg_qq_gift_panel");
        r42.b bVar = r42.b.f430720a;
        hashMap.put("qqlive_user_id", String.valueOf(bVar.o()));
        long f16 = bVar.i().f();
        hashMap.put("qqlive_anchor_id", String.valueOf(f16));
        hashMap.put("qqlive_room_id", String.valueOf(r42.a.e(bVar.i(), f16, 0, 2, null)));
        return hashMap;
    }

    public final void b(int giftMainId, int invokeSource) {
        Map<String, String> a16 = a();
        a16.put("dt_eid", "em_icgame_combo_giftarea");
        a16.put("icgame_gift_refid", String.valueOf(giftMainId));
        a16.put("icgame_gift_soure", String.valueOf(invokeSource));
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent("imp", a16);
    }

    public final void c(int giftMainId, int giftBatchId, int invokeSource, boolean isCombo, int comboCnt) {
        String str;
        Map<String, String> a16 = a();
        a16.put("dt_eid", "em_icgame_combo_giftoption");
        a16.put("icgame_gift_refid", String.valueOf(giftMainId));
        a16.put("icgame_many_gift_id", String.valueOf(giftBatchId));
        a16.put("icgame_gift_soure", String.valueOf(invokeSource));
        if (isCombo) {
            str = "1";
        } else {
            str = "2";
        }
        a16.put("icgame_is_combo", str);
        a16.put("icgame_combo_cnt", String.valueOf(comboCnt));
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent("imp", a16);
    }
}
