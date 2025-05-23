package tm3;

import android.os.SystemClock;
import e55.c;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J \u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0011"}, d2 = {"Ltm3/a;", "", "Le55/c;", "anchorInfo", "", "startTimeMs", "", "c", "b", "a", "", "pkType", "f", "e", "d", "<init>", "()V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f436625a = new a();

    a() {
    }

    public final void a(long startTimeMs) {
        com.tencent.report.a.f364907a.h("ev_qqlive_lppk_mate_cancel", new HashMap());
    }

    public final void b(long startTimeMs) {
        HashMap hashMap = new HashMap();
        hashMap.put("qqlive_lp_anchor_id", "0");
        hashMap.put("qqlive_lp_result", "2");
        com.tencent.report.a.f364907a.h("ev_qqlive_lppk_mate_solution", hashMap);
    }

    public final void c(@Nullable c anchorInfo, long startTimeMs) {
        if (anchorInfo != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("qqlive_lp_anchor_id", String.valueOf(anchorInfo.f395735a));
            hashMap.put("qqlive_lp_result", "1");
            com.tencent.report.a.f364907a.h("ev_qqlive_lppk_mate_solution", hashMap);
        }
    }

    public final void d(int pkType, long startTimeMs) {
        String str;
        HashMap hashMap = new HashMap();
        if (pkType != 1) {
            if (pkType != 2) {
                str = "";
            } else {
                str = "ev_qqlive_pwpk_lp_match_cancel";
            }
        } else {
            str = "ev_qqlive_pwpk_cancel_random_match";
        }
        hashMap.put("qqlive_lp_pp_times", String.valueOf(SystemClock.elapsedRealtime() - startTimeMs));
        com.tencent.report.a.f364907a.h(str, hashMap);
    }

    public final void e(int pkType, long startTimeMs) {
        HashMap hashMap = new HashMap();
        hashMap.put("qqlive_lp_anchor_id", "0");
        hashMap.put("qqlive_lp_result", "2");
        hashMap.put("qqlive_lp_pp_times", String.valueOf(SystemClock.elapsedRealtime() - startTimeMs));
        String str = "ev_qqlive_pwpk_result_random_match";
        if (pkType != 1 && pkType != 2) {
            str = "";
        }
        com.tencent.report.a.f364907a.h(str, hashMap);
    }

    public final void f(int pkType, @Nullable c anchorInfo, long startTimeMs) {
        String str;
        if (anchorInfo != null) {
            HashMap hashMap = new HashMap();
            if (pkType != 1) {
                if (pkType != 2) {
                    str = "";
                } else {
                    str = "ev_qqlive_pwpk_lp_match_result";
                }
            } else {
                str = "ev_qqlive_pwpk_result_random_match";
            }
            hashMap.put("qqlive_lp_anchor_id", String.valueOf(anchorInfo.f395735a));
            hashMap.put("qqlive_lp_result", "1");
            hashMap.put("qqlive_lp_pp_times", String.valueOf(SystemClock.elapsedRealtime() - startTimeMs));
            com.tencent.report.a.f364907a.h(str, hashMap);
        }
    }
}
