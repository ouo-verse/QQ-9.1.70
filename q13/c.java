package q13;

import QC.UniBusinessItem;
import QC.UniSetReq;
import QC.UniSetRsp;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.vas.api.IJce;
import com.tencent.mobileqq.vas.util.VasUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import q13.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016JH\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016\u00a8\u0006\u0015"}, d2 = {"Lq13/c;", "Lq13/d;", "", "appId", "itemId", "Lq13/d$a;", "observer", "", "b", "", "itemType", "appid", "pageId", "moduleId", "actionId", "actionValue", "", "operTime", "a", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c implements d {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(d.a observer, int i3, boolean z16, Object obj) {
        Intrinsics.checkNotNullParameter(observer, "$observer");
        if (obj instanceof UniSetRsp) {
            observer.a(i3, z16, ((UniSetRsp) obj).ret);
        } else {
            observer.a(i3, false, -1);
        }
    }

    @Override // q13.d
    public void a(@NotNull String itemId, @NotNull String itemType, @NotNull String appid, @NotNull String pageId, @NotNull String moduleId, int actionId, int actionValue, long operTime) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        Intrinsics.checkNotNullParameter(appid, "appid");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(moduleId, "moduleId");
        ((IMobileReportManager) QRoute.api(IMobileReportManager.class)).reportAction(itemId, itemType, appid, pageId, moduleId, actionId, actionValue, operTime);
    }

    @Override // q13.d
    public void b(int appId, int itemId, @NotNull final d.a observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        IJce build = VasUtil.getService().getJceRequset().build("QC.UniBusinessLogicServer.UniBusinessLogicObj", "QCUniBusinessLogic.uniSet", "stReq", "rsp");
        UniSetReq uniSetReq = new UniSetReq();
        uniSetReq.stLogin = IJce.Util.getLoginInfo();
        UniBusinessItem uniBusinessItem = new UniBusinessItem();
        uniSetReq.stUniBusinessItem = uniBusinessItem;
        uniBusinessItem.appid = appId;
        uniBusinessItem.itemid = itemId;
        build.request("uniSet", uniSetReq, new UniSetRsp(), new BusinessObserver() { // from class: q13.b
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                c.d(d.a.this, i3, z16, obj);
            }
        }, false);
    }
}
