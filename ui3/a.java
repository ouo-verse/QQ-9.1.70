package ui3;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import cooperation.qzone.QzoneIPCModule;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import mb4.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J&\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0002\u00a8\u0006\u0010"}, d2 = {"Lui3/a;", "", "", "modId", "pakCount", "", "pakSize", "", "isPreDownload", "", "b", QCircleWeakNetReporter.KEY_COST, QzoneIPCModule.RESULT_CODE, "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f439038a = new a();

    a() {
    }

    public final void a(int modId, long cost, boolean isPreDownload, int resultCode) {
        Object obj;
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100233", false);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("k_mod_map_id", String.valueOf(modId));
        linkedHashMap.put("k_cost", String.valueOf(cost));
        String str = "1";
        if (isPreDownload) {
            obj = "1";
        } else {
            obj = "0";
        }
        linkedHashMap.put("k_is_predownload", obj);
        if (!isSwitchOn) {
            str = "0";
        }
        linkedHashMap.put("k_switch_state", str);
        linkedHashMap.put("k_result_code", String.valueOf(resultCode));
        c.c(c.f416532a, "e_zplan_common_mod_end_download", linkedHashMap, false, 4, null);
    }

    public final void b(int modId, int pakCount, long pakSize, boolean isPreDownload) {
        Object obj;
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100233", false);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("k_mod_map_id", String.valueOf(modId));
        linkedHashMap.put("k_pak_count", String.valueOf(pakCount));
        linkedHashMap.put("k_pak_size", String.valueOf(pakSize));
        String str = "1";
        if (isPreDownload) {
            obj = "1";
        } else {
            obj = "0";
        }
        linkedHashMap.put("k_is_predownload", obj);
        if (!isSwitchOn) {
            str = "0";
        }
        linkedHashMap.put("k_switch_state", str);
        c.c(c.f416532a, "e_zplan_common_mod_start_download", linkedHashMap, false, 4, null);
    }
}
