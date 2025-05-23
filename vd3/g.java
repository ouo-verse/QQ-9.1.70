package vd3;

import com.tencent.mobileqq.zootopia.ZootopiaUEActivity;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zootopia.ueloading.ZPlanUELoaderControllerV2;
import com.tencent.mobileqq.zootopia.ueloading.prepare.preparer.ParallelPreparer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lvd3/g;", "", "Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderControllerV2;", "ueLoaderController", "", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class g {
    public final void a(ZPlanUELoaderControllerV2 ueLoaderController) {
        Intrinsics.checkNotNullParameter(ueLoaderController, "ueLoaderController");
        QLog.i("ZPlanUELoaderPreparer", 1, "prepare");
        if (ueLoaderController.getEnterParams() == null) {
            QLog.e("ZPlanUELoaderPreparer", 1, "prepare enterParams is null");
            QQToastUtil.showQQToast(1, "\u4e50\u56ed\u8fdb\u5165\u5931\u8d25\uff0c\u53c2\u6570\u6709\u8bef");
            ZootopiaUEActivity zootopiaUEActivity = ueLoaderController.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String();
            if (zootopiaUEActivity != null) {
                zootopiaUEActivity.finish();
                return;
            }
            return;
        }
        ZootopiaEnterParams enterParams = ueLoaderController.getEnterParams();
        Intrinsics.checkNotNull(enterParams);
        new ParallelPreparer(ueLoaderController).a(enterParams, enterParams.toJsonObject(), ueLoaderController);
    }
}
