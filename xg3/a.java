package xg3;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.mobileqq.zootopia.utils.m;
import ec3.b;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJN\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJv\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007\u00a8\u0006\u001b"}, d2 = {"Lxg3/a;", "Lec3/b;", "", "modId", HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, "newVersion", "diffUrl", "", "diffSize", "fullUrl", "fullSize", "", "clientEnableDiff", "isDiffUpdate", "", "f", "isSuccess", "", "errCode", "errMsg", "totalCostTime", "patchOnlyTime", "loadAndPatchTime", "finalMd5CheckTime", "e", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a extends b {
    public final void e(boolean isSuccess, int errCode, String errMsg, String modId, String baseVersion, String newVersion, String diffUrl, long diffSize, String fullUrl, long fullSize, long totalCostTime, long patchOnlyTime, long loadAndPatchTime, long finalMd5CheckTime) {
        HashMap hashMapOf;
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(modId, "modId");
        Intrinsics.checkNotNullParameter(baseVersion, "baseVersion");
        Intrinsics.checkNotNullParameter(newVersion, "newVersion");
        Intrinsics.checkNotNullParameter(diffUrl, "diffUrl");
        Intrinsics.checkNotNullParameter(fullUrl, "fullUrl");
        int i3 = isSuccess ? 0 : errCode;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("k_net_type", m.f329564a.b()), TuplesKt.to("k_errcode", String.valueOf(i3)), TuplesKt.to("k_download_task_id", modId), TuplesKt.to("k_mod_update_base_version", baseVersion), TuplesKt.to("k_mod_update_new_version", newVersion), TuplesKt.to("k_mod_update_diff_url", diffUrl), TuplesKt.to("k_mod_update_diff_size", String.valueOf(diffSize)), TuplesKt.to("k_mod_update_full_url", fullUrl), TuplesKt.to("k_mod_update_full_size", String.valueOf(fullSize)), TuplesKt.to("k_cost_time", String.valueOf(totalCostTime)), TuplesKt.to("k_cost_time_patch_only", String.valueOf(patchOnlyTime)), TuplesKt.to("k_cost_time_load_patch_total", String.valueOf(loadAndPatchTime)), TuplesKt.to("k_cost_time_final_md5_check", String.valueOf(finalMd5CheckTime)));
        c("e_zplan_mod_update_diff_finish", i3, errMsg, hashMapOf);
    }

    public final void f(String modId, String baseVersion, String newVersion, String diffUrl, long diffSize, String fullUrl, long fullSize, boolean clientEnableDiff, boolean isDiffUpdate) {
        HashMap hashMapOf;
        Intrinsics.checkNotNullParameter(modId, "modId");
        Intrinsics.checkNotNullParameter(baseVersion, "baseVersion");
        Intrinsics.checkNotNullParameter(newVersion, "newVersion");
        Intrinsics.checkNotNullParameter(diffUrl, "diffUrl");
        Intrinsics.checkNotNullParameter(fullUrl, "fullUrl");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("k_net_type", m.f329564a.b()), TuplesKt.to("k_errcode", String.valueOf(0)), TuplesKt.to("k_download_task_id", modId), TuplesKt.to("k_mod_update_base_version", baseVersion), TuplesKt.to("k_mod_update_new_version", newVersion), TuplesKt.to("k_mod_update_diff_url", diffUrl), TuplesKt.to("k_mod_update_diff_size", String.valueOf(diffSize)), TuplesKt.to("k_mod_update_full_url", fullUrl), TuplesKt.to("k_mod_update_full_size", String.valueOf(fullSize)), TuplesKt.to("k_mod_update_diff_client_switch", String.valueOf(clientEnableDiff)), TuplesKt.to("k_mod_update_is_diff", String.valueOf(isDiffUpdate)));
        c("e_zplan_mod_update_create", 0, "", hashMapOf);
    }
}
