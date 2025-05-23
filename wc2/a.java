package wc2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.config.business.af;
import com.tencent.mobileqq.config.business.ah;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.bs;
import com.tencent.mobileqq.onlinestatus.bv;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager;
import com.tencent.mobileqq.onlinestatus.manager.f;
import com.tencent.mobileqq.onlinestatus.w;
import com.tencent.mobileqq.onlinestatus.weather.OnlineStatusWeatherModel;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.weather.util.i;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a extends w {

    /* renamed from: k, reason: collision with root package name */
    private boolean f445382k;

    /* renamed from: l, reason: collision with root package name */
    private OnlineStatusWeatherModel f445383l;

    /* renamed from: m, reason: collision with root package name */
    private wc2.c f445384m;

    /* compiled from: P */
    /* renamed from: wc2.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    class C11474a extends QQPermission.BasePermissionsListener {
        C11474a() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public boolean isShowGuide(List<String> list) {
            return false;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            ((OnlineStatusDataManager) ((IOnlineStatusManagerService) ((w) a.this).f256880i.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(f.class)).O(9);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
            if (i.a(((w) a.this).f256879h, QQPermissionConstants.Business.SCENE.QQ_ONLINE_STATUS_WEATHER_SCENE)) {
                ((OnlineStatusDataManager) ((IOnlineStatusManagerService) ((w) a.this).f256880i.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(f.class)).O(9);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b extends QQPermission.BasePermissionsListener {
        b() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class c extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OnlineStatusPermissionChecker.OnlineStatusPermissionItem f445387a;

        c(OnlineStatusPermissionChecker.OnlineStatusPermissionItem onlineStatusPermissionItem) {
            this.f445387a = onlineStatusPermissionItem;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public boolean isShowGuide(List<String> list) {
            return false;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            a.this.s(this.f445387a);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
            if (i.a(((w) a.this).f256879h, QQPermissionConstants.Business.SCENE.QQ_ONLINE_STATUS_WEATHER_SCENE)) {
                a.this.s(this.f445387a);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class d extends wc2.c {
        d() {
        }

        @Override // wc2.c
        public void a(boolean z16, Bundle bundle) {
            super.a(z16, bundle);
            if (z16 && bundle != null) {
                a.this.f445383l = (OnlineStatusWeatherModel) bundle.getParcelable("weatherModel");
            }
            a.this.j();
            if (((w) a.this).f256881j && ((w) a.this).f256877f != null) {
                ((w) a.this).f256877f.f();
            }
        }
    }

    public a(long j3, w.a aVar, AppInterface appInterface, QBaseActivity qBaseActivity) {
        super(j3, aVar, appInterface, qBaseActivity);
        this.f445382k = true;
        d dVar = new d();
        this.f445384m = dVar;
        appInterface.registObserver(dVar);
    }

    @Override // com.tencent.mobileqq.onlinestatus.w
    public void b(boolean z16) {
        this.f445382k = z16;
        if (!z16) {
            return;
        }
        QQPermissionFactory.getQQPermission(this.f256879h, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_ONLINE_STATUS_WEATHER_ID, QQPermissionConstants.Business.SCENE.QQ_ONLINE_STATUS_WEATHER_SCENE)).requestPermissions(QQPermissionConstants.Permission.GROUP_LOCATION, 2, new C11474a());
    }

    @Override // com.tencent.mobileqq.onlinestatus.w
    public void c() {
        super.c();
        if (!this.f445382k) {
            QQPermissionFactory.getQQPermission(this.f256879h, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_ONLINE_STATUS_WEATHER_ID, QQPermissionConstants.Business.SCENE.QQ_ONLINE_STATUS_WEATHER_SCENE)).requestPermissions(QQPermissionConstants.Permission.GROUP_LOCATION, 2, new b());
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.w
    public void d() {
        jc2.b bVar;
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c H = bs.H("OnlineStatusWeatherDisplayInfo");
        af a16 = ah.f202497a.a();
        if (a16 != null && (bVar = a16.f202496d) != null && !TextUtils.isEmpty(bVar.f409781a) && H != null && bs.d0(H)) {
            com.tencent.mobileqq.onlinestatus.af.n0(this.f256879h, a16.f202496d.f409781a);
            bv.a("0X800AF98");
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.w
    public void f(boolean z16, OnlineStatusPermissionChecker.OnlineStatusPermissionItem onlineStatusPermissionItem) {
        if (z16) {
            s(onlineStatusPermissionItem);
        } else {
            QQPermissionFactory.getQQPermission(this.f256879h, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_ONLINE_STATUS_WEATHER_ID, QQPermissionConstants.Business.SCENE.QQ_ONLINE_STATUS_WEATHER_SCENE)).requestPermissions(QQPermissionConstants.Permission.GROUP_LOCATION, 2, new c(onlineStatusPermissionItem));
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.w
    public void h() {
        super.h();
        this.f256880i.unRegistObserver(this.f445384m);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.onlinestatus.w
    public void j() {
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c H;
        this.f256872a = this.f256879h.getString(R.string.f197244jh);
        this.f256875d = true;
        if (this.f445383l != null) {
            H = com.tencent.mobileqq.onlinestatus.af.C().j(this.f445383l);
        } else {
            H = bs.H("OnlineStatusWeatherDisplayInfo");
        }
        if (H != null) {
            this.f256873b = bs.M(this.f256880i, H, false);
        }
    }

    public void s(OnlineStatusPermissionChecker.OnlineStatusPermissionItem onlineStatusPermissionItem) {
        Intent intent = new Intent();
        if (onlineStatusPermissionItem != null) {
            intent.putExtra("online_status_permission_item", onlineStatusPermissionItem);
        }
        ((OnlineStatusDataManager) ((IOnlineStatusManagerService) this.f256880i.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(f.class)).K(8, intent, this.f445383l);
    }
}
