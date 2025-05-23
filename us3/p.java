package us3;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qq.minibox.api.data.VirtualAppInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ*\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\bJ0\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0006J\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0006\u00a8\u0006\u0019"}, d2 = {"Lus3/p;", "", "Lcom/tencent/qq/minibox/api/data/MiniBoxAppDataInfo;", "appDataInfo", "", "isSucc", "", "errCode", "", "msg", "", "f", "errMsg", "e", "appId", "is64Bit", "isLocalBlocked", "c", "g", "from", "b", "result", "a", "<init>", "()V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final p f440002a = new p();

    p() {
    }

    public static /* synthetic */ void d(p pVar, String str, boolean z16, boolean z17, boolean z18, int i3, int i16, Object obj) {
        if ((i16 & 16) != 0) {
            i3 = 0;
        }
        pVar.c(str, z16, z17, z18, i3);
    }

    public final void a(int result) {
        new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setBussinessId("1").setPageId("969").setOperModule("9080").setModuleType("908009").setOperId("907426").setExt(5, String.valueOf(result)).report();
    }

    public final void b(int from) {
        new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setBussinessId("1").setPageId("969").setOperModule("9080").setModuleType("908001").setOperId("907426").setExt(5, String.valueOf(from)).report();
    }

    public final void c(@NotNull String appId, boolean isSucc, boolean is64Bit, boolean isLocalBlocked, int errCode) {
        int i3;
        String str;
        Intrinsics.checkNotNullParameter(appId, "appId");
        String str2 = "1";
        WadlReportBuilder operId = new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setBussinessId("1").setPageId("969").setOperModule("9080").setModuleType("908001").setOperId("908001").setOperId("907300");
        if (isSucc) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        WadlReportBuilder ext = operId.setRetId(i3).setGameAppId(appId).setExt(5, String.valueOf(errCode));
        if (is64Bit) {
            str = "1";
        } else {
            str = "2";
        }
        WadlReportBuilder ext2 = ext.setExt(6, str);
        if (!isLocalBlocked) {
            str2 = "2";
        }
        ext2.setExt(7, str2).report();
    }

    public final void e(@NotNull VirtualAppInfo appDataInfo, boolean isSucc, int errCode, @NotNull String errMsg) {
        int i3;
        Intrinsics.checkNotNullParameter(appDataInfo, "appDataInfo");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        WadlReportBuilder operId = new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setBussinessId("1").setPageId("969").setOperModule("9080").setModuleType("908001").setOperId("908001").setOperId("907303");
        if (isSucc) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        operId.setRetId(i3).setGameAppId(appDataInfo.getAppId()).setExt(5, String.valueOf(errCode)).setExt(6, errMsg).report();
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportMiniGameVirtual(appDataInfo.getAppId(), "page_view", "virtual_success", "", null, null, String.valueOf(appDataInfo.getScene()), appDataInfo.getVia(), appDataInfo.getReportData());
    }

    public final void f(@NotNull VirtualAppInfo appDataInfo, boolean isSucc, int errCode, @NotNull String msg2) {
        int i3;
        Intrinsics.checkNotNullParameter(appDataInfo, "appDataInfo");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        WadlReportBuilder operId = new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setBussinessId("1").setPageId("969").setOperModule("9080").setModuleType("908001").setOperId("908001").setOperId("907302");
        if (isSucc) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        operId.setRetId(i3).setGameAppId(appDataInfo.getAppId()).setExt(6, String.valueOf(errCode)).setExt(5, msg2).report();
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportMiniGameVirtual(appDataInfo.getAppId(), "page_view", "virtual_visit", "", null, null, String.valueOf(appDataInfo.getScene()), appDataInfo.getVia(), appDataInfo.getReportData());
    }

    public final void g(@NotNull String appId, boolean isSucc) {
        int i3;
        Intrinsics.checkNotNullParameter(appId, "appId");
        WadlReportBuilder operId = new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setBussinessId("1").setPageId("969").setOperModule("9080").setModuleType("908001").setOperId("908001").setOperId("907301");
        if (isSucc) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        operId.setRetId(i3).setGameAppId(appId).report();
    }
}
