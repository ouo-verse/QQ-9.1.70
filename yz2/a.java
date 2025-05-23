package yz2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vip.api.IVipInfoUtils;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lyz2/a;", "Ly71/a;", "", "c", "Landroid/content/Context;", "context", "", "a", "b", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a implements y71.a {
    @Override // y71.a
    public void a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Bundle bundle = new Bundle();
        bundle.putString(VasH5PayUtil.SERVICENAME, "\u8d85\u7ea7\u4f1a\u5458");
        bundle.putString(VasH5PayUtil.SERVICECODE, "CJCLUBT");
        bundle.putString(VasH5PayUtil.OFFERID, "1450000516");
        bundle.putInt(VasH5PayUtil.OPENMONTH, 3);
        bundle.putString(VasH5PayUtil.PAY_URL, VasH5PayUtil.H5_PAY_URL + "mvip.pt.vipsite.tqtips_chengyuan");
        bundle.putString(VasH5PayUtil.VIPTYPE, "svip");
        VasH5PayUtil.openClubPay(context, bundle);
    }

    @Override // y71.a
    public void b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra("url", "https://m.vip.qq.com/freedom/freedom_group_all.html?_wv=1");
        RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTE_BROWSER);
    }

    @Override // y71.a
    public boolean c() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return true;
        }
        String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(peekAppRuntime.getCurrentUin());
        IVasInfoService iVasInfoService = (IVasInfoService) QRoute.api(IVasInfoService.class);
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        if (iVasInfoService.getVasSimpleInfoWithUid(uid, "AtAllVipGuideImpl") == null) {
            return true;
        }
        return !IVipInfoUtils.INSTANCE.a().getHighestVipType(r0).a();
    }
}
