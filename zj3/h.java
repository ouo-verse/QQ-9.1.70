package zj3;

import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\t\u00a8\u0006\r"}, d2 = {"Lzj3/h;", "Lcom/tencent/rdelivery/reshub/api/m;", "Lcom/tencent/rdelivery/reshub/api/a;", "appInfo", "", "resId", "", "a", "", "Ljava/util/Map;", "minVersionMap", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class h implements com.tencent.rdelivery.reshub.api.m {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Map<String, Integer> minVersionMap;

    public h() {
        Map<String, Integer> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(ITDocFileBrowserFacade.NATIVE_ENGINE_SO_NAME, 50), TuplesKt.to(SoLoadConstants.SONAME_TPCORE_MASTER, 10), TuplesKt.to(SoLoadConstants.SONAME_DOWNLOADPROXY, 30));
        this.minVersionMap = mapOf;
    }

    @Override // com.tencent.rdelivery.reshub.api.m
    public int a(com.tencent.rdelivery.reshub.api.a appInfo, String resId) {
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        Intrinsics.checkNotNullParameter(resId, "resId");
        Integer num = this.minVersionMap.get(resId);
        int intValue = num != null ? num.intValue() : 0;
        if (QLog.isColorLevel() && intValue > 0) {
            QLog.d("ZPLanResHubVersionDelegate", 2, "[getMinVersion],resID:" + resId + ", minResVersion:" + intValue);
        }
        return intValue;
    }
}
