package sc2;

import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.bs;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager;
import com.tencent.mobileqq.onlinestatus.w;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vashealth.api.IQQHealthStatusApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c;
import h43.e;
import h43.f;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b extends w {

    /* renamed from: k, reason: collision with root package name */
    private boolean f433651k;

    /* renamed from: l, reason: collision with root package name */
    private h43.a f433652l;

    public b(long j3, w.a aVar, AppInterface appInterface, QBaseActivity qBaseActivity) {
        super(j3, aVar, appInterface, qBaseActivity);
        this.f433651k = true;
        this.f433652l = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(f fVar) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        ((IOnlineStatusService) peekAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).setStepStatusInfo(fVar);
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        this.f433652l = new h43.a() { // from class: sc2.a
            @Override // h43.a
            public final void a(f fVar) {
                b.this.m(fVar);
            }
        };
        ((IQQHealthStatusApi) QRoute.api(IQQHealthStatusApi.class)).getStepInfo(peekAppRuntime.getCurrentUin(), Boolean.TRUE, this.f433652l);
    }

    @Override // com.tencent.mobileqq.onlinestatus.w
    public void b(boolean z16) {
        this.f433651k = z16;
        if (!z16) {
            return;
        }
        if (!((IQQHealthStatusApi) QRoute.api(IQQHealthStatusApi.class)).getStepPermission()) {
            ((IQQHealthStatusApi) QRoute.api(IQQHealthStatusApi.class)).requestStepPermission(new a(), this.f256879h);
        } else {
            o();
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.w
    public void c() {
        if (!((IQQHealthStatusApi) QRoute.api(IQQHealthStatusApi.class)).getStepPermission() && !this.f433651k) {
            ((IQQHealthStatusApi) QRoute.api(IQQHealthStatusApi.class)).requestStepPermission(new C11221b(), null);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.w
    public void d() {
        ((IQQHealthStatusApi) QRoute.api(IQQHealthStatusApi.class)).jumpToMainPage();
    }

    @Override // com.tencent.mobileqq.onlinestatus.w
    public void f(boolean z16, OnlineStatusPermissionChecker.OnlineStatusPermissionItem onlineStatusPermissionItem) {
        if (z16) {
            n(onlineStatusPermissionItem);
        } else if (((IQQHealthStatusApi) QRoute.api(IQQHealthStatusApi.class)).getStepPermission()) {
            n(onlineStatusPermissionItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.onlinestatus.w
    public void j() {
        this.f256875d = true;
        this.f256873b = HardCodeUtil.qqStr(R.string.f2054155j);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && ((IQQHealthStatusApi) QRoute.api(IQQHealthStatusApi.class)).getStepPermission()) {
            c H = bs.H("OnlineStatusStepCountDisplayInfo");
            if (H == null) {
                QLog.e("OnlineStatusStepCountDisplayInfo", 1, "updateData simpleInfo is null");
            } else {
                this.f256873b = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getDisplayOnlineStatusInfo(peekAppRuntime, H, null, 7, ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getOnlineStatusItem(AppRuntime.Status.online, 2017L, false), Boolean.TRUE);
            }
        }
    }

    public void n(OnlineStatusPermissionChecker.OnlineStatusPermissionItem onlineStatusPermissionItem) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        OnlineStatusDataManager onlineStatusDataManager = (OnlineStatusDataManager) ((IOnlineStatusManagerService) peekAppRuntime.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(com.tencent.mobileqq.onlinestatus.manager.f.class);
        Intent intent = new Intent();
        if (onlineStatusPermissionItem != null) {
            intent.putExtra("online_status_permission_item", onlineStatusPermissionItem);
        }
        onlineStatusDataManager.I(intent);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements e {
        a() {
        }

        @Override // h43.e
        public void b() {
            b.this.o();
        }

        @Override // h43.e
        public void a() {
        }
    }

    /* compiled from: P */
    /* renamed from: sc2.b$b, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    class C11221b implements e {
        C11221b() {
        }

        @Override // h43.e
        public void b() {
            b.this.n(null);
        }

        @Override // h43.e
        public void a() {
        }
    }
}
