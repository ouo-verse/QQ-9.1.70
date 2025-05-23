package wd3;

import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.business.BaseUpdateBusiness;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.UpdateListenerParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0014J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0014"}, d2 = {"Lwd3/a;", "Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness;", "Lcom/tencent/vas/update/business/BaseUpdateBusiness;", "", "id", "", "getScid", "", "getBid", "getFrom", "getBusinessDir", "Lcom/tencent/vas/update/entity/UpdateListenerParams;", "params", "", "onLoadSuccess", "onLoadFail", "onProgress", "<init>", "()V", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a extends QQVasUpdateBusiness<BaseUpdateBusiness> {
    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return 315L;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    @NotNull
    protected String getBusinessDir() {
        return "Zootopia";
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    @NotNull
    public String getFrom() {
        return "downloadZootopiaResource";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    @NotNull
    public String getScid(int id5) {
        return "zplan.animation." + id5 + ".zip";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness, com.tencent.vas.update.business.BaseUpdateBusiness, com.tencent.vas.update.callback.listener.IUpdateListener
    public void onLoadFail(@NotNull UpdateListenerParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        QLog.i("ZootopiaVasUpdateBusiness", 1, "onLoadFail");
        BusinessUpdateParams businessUpdateParams = params.mBusinessUpdateParams;
        if (businessUpdateParams != null && businessUpdateParams.mBid == getBid()) {
            super.onLoadFail(params);
        }
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness, com.tencent.vas.update.business.BaseUpdateBusiness, com.tencent.vas.update.callback.listener.IUpdateListener
    public void onLoadSuccess(@NotNull UpdateListenerParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        QLog.i("ZootopiaVasUpdateBusiness", 1, "onLoadSuccess");
        BusinessUpdateParams businessUpdateParams = params.mBusinessUpdateParams;
        if (businessUpdateParams != null && businessUpdateParams.mBid == getBid()) {
            super.onLoadSuccess(params);
        }
    }

    @Override // com.tencent.vas.update.business.BaseUpdateBusiness, com.tencent.vas.update.callback.listener.IUpdateListener
    public void onProgress(@NotNull UpdateListenerParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        BusinessUpdateParams businessUpdateParams = params.mBusinessUpdateParams;
        if (businessUpdateParams != null && businessUpdateParams.mBid == getBid()) {
            super.onProgress(params);
        }
    }
}
