package uf2;

import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyDexResApi;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.d;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rdelivery.reshub.api.i;
import com.tencent.util.AppSetting;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Luf2/c;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/d;", "", "resId", "", "validateResFile", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/c;", "a", "Lcom/tencent/rdelivery/reshub/api/i;", "b", "Lcom/tencent/rdelivery/reshub/api/i;", "()Lcom/tencent/rdelivery/reshub/api/i;", "resHub", "c", "testResHub", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c implements d {

    /* renamed from: a, reason: collision with root package name */
    public static final c f438902a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final i resHub = ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).getResHubInstance();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final i testResHub = ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).getTestResHubInstance();

    c() {
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.d
    public com.tencent.mobileqq.qqecommerce.biz.kuikly.api.c a(String resId, boolean validateResFile) {
        i iVar;
        Intrinsics.checkNotNullParameter(resId, "resId");
        if (!AppSetting.isPublicVersion()) {
            r1 = ((IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class)).getShiplyTestBundleList().indexOf(resId) >= 0;
            QLog.w("QQKuiklyDexResFetcherFactory", 1, "createResHub isTest:" + r1);
        }
        if (r1) {
            iVar = testResHub;
        } else {
            iVar = resHub;
        }
        return new b(iVar, resId, validateResFile, r1);
    }

    public final i b() {
        return resHub;
    }

    public final i c() {
        return testResHub;
    }
}
