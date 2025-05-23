package xg0;

import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.report.service.k;
import com.tencent.ecommerce.base.report.service.m;
import com.tencent.ecommerce.base.somanager.api.IECLoadSoCallback;
import com.tencent.ecommerce.base.somanager.api.IECSoManager;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lxg0/a;", "", "", "a", "Lcom/tencent/ecommerce/base/somanager/api/IECLoadSoCallback;", "callback", "", "b", "", QzoneIPCModule.RESULT_CODE, "Lcom/tencent/ecommerce/base/report/service/k;", "showPageCostTime", "c", "Lcom/tencent/ecommerce/base/somanager/api/IECSoManager;", "Lcom/tencent/ecommerce/base/somanager/api/IECSoManager;", "soManagerProxy", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f447957b = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final IECSoManager soManagerProxy = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getSoManagerDelegate();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"xg0/a$a", "Lcom/tencent/ecommerce/base/somanager/api/IECLoadSoCallback;", "", "result", "", WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_RESULT, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: xg0.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11546a implements IECLoadSoCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IECLoadSoCallback f447958a;

        C11546a(IECLoadSoCallback iECLoadSoCallback) {
            this.f447958a = iECLoadSoCallback;
        }

        @Override // com.tencent.ecommerce.base.somanager.api.IECLoadSoCallback
        public void loadResult(int result) {
            cg0.a.b("ECSoManager", "[loadPtsLiteSo] end result = " + result + " callback = " + this.f447958a + '}');
            this.f447958a.loadResult(result);
        }
    }

    a() {
    }

    public final boolean a() {
        IECSoManager iECSoManager = soManagerProxy;
        if (iECSoManager == null) {
            cg0.a.a("ECSoManager", "isPtsSoReady", "[isPtsSoReady] soManagerDelegate is null");
            return true;
        }
        return iECSoManager.isPtsLiteSoReady();
    }

    public final void b(IECLoadSoCallback callback) {
        IECSoManager iECSoManager = soManagerProxy;
        if (iECSoManager == null) {
            cg0.a.a("ECSoManager", "loadPtsLiteSo", "[loadPtsLiteSo] soManagerDelegate is null");
            callback.loadResult(-1);
            return;
        }
        cg0.a.b("ECSoManager", "[loadPtsLiteSo] begin callback = " + callback);
        iECSoManager.loadPtsLiteSo(new C11546a(callback));
    }

    public final void c(int resultCode, k showPageCostTime) {
        showPageCostTime.b(new m().a(false).c(resultCode).d());
    }
}
