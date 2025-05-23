package z62;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.leba.zplan.view.ZPlanGuideFrameLayout;
import com.tencent.mobileqq.leba.zplan.view.ZPlanMaintainingFrameLayout;
import com.tencent.mobileqq.mini.servlet.MiniAppGetNativeAppInfoServlet;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.p;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.bubble.api.IZPlanAvatarBubbleControllerFactory;
import com.tencent.mobileqq.zplan.meme.frameanim.ZPlanAvatarBannerParams;
import com.tencent.mobileqq.zplan.meme.frameanim.model.ZPlanAvatarSource;
import com.tencent.mobileqq.zplan.model.MaintEntryType;
import com.tencent.mobileqq.zplan.model.ZPlanMaintInfo;
import com.tencent.mobileqq.zplan.model.j;
import com.tencent.mobileqq.zplan.report.api.IZPlanReportHelper;
import com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest;
import com.tencent.mobileqq.zplan.utils.ag;
import com.tencent.mobileqq.zplan.utils.api.IZPlanClassObjectFactory;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.mobileqq.zplan.view.AbsZPlanStaticFrameLayout;
import com.tencent.mobileqq.zplan.view.b;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import com.tencent.state.report.SquareReportConst;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.api.IZPlanRefreshMoveListener;
import cooperation.qzone.api.OnRefreshStateListener;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import nk3.i;
import sj3.ZPlanReportEndTaskInfo;
import sj3.ZPlanReportStartTaskInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private AbsZPlanStaticFrameLayout f452052a;

    /* renamed from: b, reason: collision with root package name */
    private ZPlanMaintainingFrameLayout f452053b;

    /* renamed from: c, reason: collision with root package name */
    private ZPlanGuideFrameLayout f452054c;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.zplan.bubble.b f452056e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.mobileqq.zplan.meme.frameanim.a f452057f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.mobileqq.zplan.meme.frameanim.e f452058g;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<ViewGroup> f452059h;

    /* renamed from: i, reason: collision with root package name */
    private View f452060i;

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<QBaseActivity> f452061j;

    /* renamed from: l, reason: collision with root package name */
    private qj3.b f452063l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f452064m;

    /* renamed from: o, reason: collision with root package name */
    private com.tencent.mobileqq.zplan.view.b f452066o;

    /* renamed from: d, reason: collision with root package name */
    private boolean f452055d = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f452062k = false;

    /* renamed from: n, reason: collision with root package name */
    private boolean f452065n = true;

    /* renamed from: p, reason: collision with root package name */
    private AtomicBoolean f452067p = new AtomicBoolean(false);

    /* renamed from: q, reason: collision with root package name */
    private final com.tencent.mobileqq.zplan.servlet.b f452068q = new a();

    /* renamed from: r, reason: collision with root package name */
    private final Observer<Boolean> f452069r = new b();

    /* renamed from: s, reason: collision with root package name */
    private b.a f452070s = new d();

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements com.tencent.mobileqq.zplan.servlet.b {
        a() {
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            List emptyList;
            if (i3 == 6) {
                if (!z16) {
                    QLog.e("Leba.ZplanHeaderLayout", 1, "NOTIFY_UPDATE_AVATAR_IMAGE_WITH_NEW_APPEARANCE result:" + z16);
                    return;
                }
                if (f.this.f452064m) {
                    QLog.i("Leba.ZplanHeaderLayout", 1, "no need to update avatar now, activity paused.");
                    return;
                }
                QLog.i("Leba.ZplanHeaderLayout", 1, "NOTIFY_UPDATE_AVATAR_IMAGE_WITH_NEW_APPEARANCE");
                com.tencent.mobileqq.zplan.meme.frameanim.a aVar = f.this.f452057f;
                if (aVar != null) {
                    aVar.j();
                    return;
                }
                return;
            }
            if (i3 == 27405) {
                try {
                    emptyList = (List) obj;
                } catch (Throwable th5) {
                    QLog.e("Leba.ZplanHeaderLayout", 1, "onUpdate PROFILE_APPEARANCE_KEY exception", th5);
                    emptyList = Collections.emptyList();
                }
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime == null) {
                    QLog.e("Leba.ZplanHeaderLayout", 1, "appRuntime is null when zplan appearanceKey changed!");
                    return;
                }
                if (!emptyList.contains(peekAppRuntime.getCurrentUin())) {
                    QLog.i("Leba.ZplanHeaderLayout", 1, "current uin's appearanceKey not changed.");
                    return;
                }
                com.tencent.mobileqq.zplan.meme.frameanim.a aVar2 = f.this.f452057f;
                if (aVar2 != null) {
                    aVar2.g();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b implements Observer<Boolean> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            QLog.i("Leba.ZplanHeaderLayout", 1, "avatar loading overlay isShowingLoading changed, new value: " + bool);
            if (bool.booleanValue()) {
                f.this.z();
            } else {
                f.this.U();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c extends View.AccessibilityDelegate {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference f452073a;

        c(WeakReference weakReference) {
            this.f452073a = weakReference;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            QBaseActivity qBaseActivity = (QBaseActivity) f.this.f452061j.get();
            ZPlanGuideFrameLayout zPlanGuideFrameLayout = (ZPlanGuideFrameLayout) this.f452073a.get();
            if (accessibilityNodeInfo != null && qBaseActivity != null) {
                accessibilityNodeInfo.setClassName(Button.class.getName());
                String string = qBaseActivity.getString(R.string.f162241zw);
                if (zPlanGuideFrameLayout != null && zPlanGuideFrameLayout.getVisibility() == 0) {
                    string = string + " " + qBaseActivity.getString(R.string.f2203368u);
                }
                accessibilityNodeInfo.setContentDescription(string);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class d implements b.a {
        d() {
        }

        @Override // com.tencent.mobileqq.zplan.view.b.a
        public void gotoPortal(int i3) {
            f.this.F(i3);
            if (f.this.f452063l != null) {
                f.this.f452063l.e("zplan_qzone", String.valueOf(4), "zplan_qzone_jump_to_portal", null);
            }
        }

        @Override // com.tencent.mobileqq.zplan.view.b.a
        public void gotoSmallHome() {
            QBaseActivity qBaseActivity = (QBaseActivity) f.this.f452061j.get();
            if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
                ((IZPlanApi) QRoute.api(IZPlanApi.class)).launchScheme(qBaseActivity, ((IZPlanApi) QRoute.api(IZPlanApi.class)).generateXWConnectScheme("recommend", null, MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin(), false, null));
                f.this.T();
            }
        }

        @Override // com.tencent.mobileqq.zplan.view.b.a
        public void showMaintain() {
            f.this.W();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class e implements com.tencent.mobileqq.zplan.meme.frameanim.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference f452076a;

        e(WeakReference weakReference) {
            this.f452076a = weakReference;
        }

        @Override // com.tencent.mobileqq.zplan.meme.frameanim.f
        public void onManagerResume() {
            AbsZPlanStaticFrameLayout absZPlanStaticFrameLayout = (AbsZPlanStaticFrameLayout) this.f452076a.get();
            if (!f.this.f452067p.getAndSet(true) && absZPlanStaticFrameLayout != null) {
                f.this.X(absZPlanStaticFrameLayout);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: z62.f$f, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public class C11657f extends i {
        C11657f() {
        }

        @Override // nk3.i
        public void onResultFailed() {
            QZLog.e("Leba.ZplanHeaderLayout", 1, "tryRequestBackground failed");
        }

        @Override // nk3.i
        public void onResultForSelectImage(@NonNull com.tencent.mobileqq.zplan.model.g gVar) {
            QZLog.i("Leba.ZplanHeaderLayout", 1, "tryRequestBackground success, dayUrl=" + gVar.i() + ", darkUrl=" + gVar.b());
            com.tencent.mobileqq.zplan.meme.frameanim.a aVar = f.this.f452057f;
            if (aVar != null) {
                aVar.t();
            }
            f.this.f452065n = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class g implements DialogInterface.OnClickListener {
        g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class h implements ValueAnimator.AnimatorUpdateListener {
        h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            f.this.V(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public f(ViewGroup viewGroup, View view, QBaseActivity qBaseActivity) {
        this.f452059h = new WeakReference<>(viewGroup);
        this.f452060i = view;
        this.f452061j = new WeakReference<>(qBaseActivity);
        com.tencent.mobileqq.zplan.view.b b16 = ag.f335760a.b(this.f452060i, ZPlanAvatarSource.LEBA, true, -1L);
        this.f452066o = b16;
        b16.b("em_zplan_xiaowo_entrance_dongtai_background");
        d0();
    }

    private void A() {
        if (!((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).enableQzoneRecordLoadingAnim()) {
            QLog.w("Leba.ZplanHeaderLayout", 1, "record loading overlay is disable by FeatureSwitch.");
            return;
        }
        if (this.f452058g != null) {
            QLog.i("Leba.ZplanHeaderLayout", 1, "already init overlay helper.");
            return;
        }
        QBaseActivity qBaseActivity = this.f452061j.get();
        if (qBaseActivity == null) {
            return;
        }
        p((FrameLayout) this.f452060i);
        this.f452058g = ((IZPlanApi) QRoute.api(IZPlanApi.class)).createAvatarLoadingViewHelper(LayoutInflater.from(qBaseActivity), qBaseActivity, ((IZPlanClassObjectFactory) QRoute.api(IZPlanClassObjectFactory.class)).getZPlanLebaAvatarOverlayViewModelClass());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.f452058g.e(this.f452056e);
        this.f452052a.addView(this.f452058g.f(), layoutParams);
        this.f452057f.q(this.f452058g);
        this.f452058g.c().observe(qBaseActivity, this.f452069r);
    }

    private void C() {
        QBaseActivity qBaseActivity;
        if (this.f452054c != null || (qBaseActivity = this.f452061j.get()) == null) {
            return;
        }
        QLog.i("Leba.ZplanHeaderLayout", 2, "[initZPlanGuideView]");
        this.f452054c = new ZPlanGuideFrameLayout(qBaseActivity);
        ViewGroup viewGroup = this.f452059h.get();
        if (viewGroup != null && (viewGroup instanceof RelativeLayout)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ViewUtils.dip2px(65.0f));
            layoutParams.addRule(8, R.id.x8_);
            layoutParams.bottomMargin = -ViewUtils.dip2px(20.0f);
            viewGroup.addView(this.f452054c, 0, layoutParams);
        }
    }

    private boolean D(Context context) {
        if (context == null || !AppSetting.p(context) || context.getResources().getConfiguration().orientation != 2) {
            return false;
        }
        return true;
    }

    private boolean E() {
        return j.a(((IZPlanApi) QRoute.api(IZPlanApi.class)).getMaintenanceInfo(MaintEntryType.ALL), new Date());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean G(WeakReference weakReference, View view, MotionEvent motionEvent) {
        com.tencent.mobileqq.zplan.view.b bVar = (com.tencent.mobileqq.zplan.view.b) weakReference.get();
        if (bVar == null) {
            return false;
        }
        if (motionEvent.getActionMasked() == 0) {
            bVar.c(null);
        } else if (motionEvent.getActionMasked() == 1) {
            bVar.c(motionEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void H(WeakReference weakReference, WeakReference weakReference2, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.mobileqq.zplan.view.b bVar = (com.tencent.mobileqq.zplan.view.b) weakReference.get();
        b.a aVar = (b.a) weakReference2.get();
        if (bVar != null && aVar != null) {
            bVar.d(aVar);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        ((IZPlanRequest) QRoute.api(IZPlanRequest.class)).requestAddDCBackImage(peekAppRuntime.getLongAccountUin(), 5, null, new C11657f());
    }

    private void R(int i3) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        if (i3 == 3) {
            str = "em_zplan_portal_entrance_dongtai_actionsheet";
        } else {
            str = "em_zplan_entrance_qq_active";
        }
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, str);
        hashMap.put("zplan_action_type", "click");
        hashMap.put("zplan_entrance_status", v());
        hashMap.put("zplan_ziliaodongtai_portal_entrance_split", Integer.valueOf(i3));
        VideoReport.reportEvent("ev_zplan_external_entrance_action", hashMap);
    }

    private void S() {
        if (this.f452062k) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, "em_zplan_entrance_qq_active");
        hashMap.put("zplan_action_type", "imp");
        hashMap.put("zplan_entrance_status", v());
        VideoReport.reportEvent("ev_zplan_external_entrance_action", hashMap);
        this.f452062k = true;
        if (this.f452063l == null) {
            return;
        }
        hashMap.remove(DTParamKey.REPORT_KEY_APPKEY);
        hashMap.put("TAG", "ZPlanHeaderLayout");
        this.f452063l.a(new ZPlanReportStartTaskInfo("zplan_qzone_entrance_expose", "Leba.ZplanHeaderLayout", null, null, hashMap, null), new ZPlanReportEndTaskInfo("zplan_qzone_entrance_expose", "Leba.ZplanHeaderLayout", 0, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, "em_zplan_xiaowo_entrance_dongtai_actionsheet");
        hashMap.put("zplan_action_type", "click");
        hashMap.put("zplan_entrance_status", v());
        VideoReport.reportEvent("ev_zplan_external_entrance_action", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        QLog.i("Leba.ZplanHeaderLayout", 2, "resume temporally hide guide view");
        ZPlanGuideFrameLayout zPlanGuideFrameLayout = this.f452054c;
        if (zPlanGuideFrameLayout == null) {
            QLog.w("Leba.ZplanHeaderLayout", 1, "zplan guide layout haven't initialized when resume!");
            Y();
        } else if (this.f452055d && zPlanGuideFrameLayout.getVisibility() == 8) {
            this.f452054c.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void X(FrameLayout frameLayout) {
        p(frameLayout);
        this.f452056e.g(0L);
    }

    private void Y() {
        QLog.i("Leba.ZplanHeaderLayout", 2, "[showZPlanGuideView]");
        QBaseActivity qBaseActivity = this.f452061j.get();
        if (qBaseActivity == null) {
            return;
        }
        ZPlanGuideFrameLayout zPlanGuideFrameLayout = this.f452054c;
        boolean z16 = true;
        if (zPlanGuideFrameLayout != null && zPlanGuideFrameLayout.getVisibility() == 0) {
            QLog.w("Leba.ZplanHeaderLayout", 1, "already show zplan guide view");
            return;
        }
        C();
        if (((Integer) p.b(qBaseActivity, MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin(), "sp_key_qzone_zplan_guide", 0)).intValue() != 0) {
            z16 = false;
        }
        this.f452055d = z16;
        if (z16 && !E()) {
            ZPlanGuideFrameLayout zPlanGuideFrameLayout2 = this.f452054c;
            if (zPlanGuideFrameLayout2 != null) {
                zPlanGuideFrameLayout2.setVisibility(0);
            }
            qj3.b bVar = this.f452063l;
            if (bVar != null) {
                bVar.e("zplan_qzone_init", String.valueOf(4), "zplan_qzone_guide_view", null);
                return;
            }
            return;
        }
        ZPlanGuideFrameLayout zPlanGuideFrameLayout3 = this.f452054c;
        if (zPlanGuideFrameLayout3 != null) {
            zPlanGuideFrameLayout3.setVisibility(8);
        }
    }

    private void Z() {
        if (this.f452053b != null) {
            if (this.f452052a != null) {
                QLog.e("Leba.ZplanHeaderLayout", 1, "mZPlanStaticLayout should be null!");
            }
            if (r() != this.f452053b.getMShowedGender()) {
                this.f452053b.i();
                return;
            }
            return;
        }
        QLog.i("Leba.ZplanHeaderLayout", 2, "[showZPlanMaintainingView]");
        ViewGroup viewGroup = this.f452059h.get();
        if (viewGroup != null) {
            viewGroup.removeView(this.f452052a);
            this.f452052a = null;
            QBaseActivity qBaseActivity = this.f452061j.get();
            if (qBaseActivity != null) {
                this.f452053b = new ZPlanMaintainingFrameLayout(qBaseActivity);
                viewGroup.addView(this.f452053b, 0, new RelativeLayout.LayoutParams(-1, ViewUtils.getScreenHeight()));
            }
        }
        qj3.b bVar = this.f452063l;
        if (bVar != null) {
            bVar.e("zplan_qzone_init", String.valueOf(4), "zplan_qzone_maintaining", null);
        }
    }

    private void a0() {
        if (this.f452052a != null) {
            if (this.f452053b != null) {
                QLog.e("Leba.ZplanHeaderLayout", 1, "mZPlanMaintainingLayout should be null!");
                return;
            }
            return;
        }
        QLog.i("Leba.ZplanHeaderLayout", 2, "[showZPlanStaticView]");
        ViewGroup viewGroup = this.f452059h.get();
        if (viewGroup != null) {
            ZPlanMaintainingFrameLayout zPlanMaintainingFrameLayout = this.f452053b;
            if (zPlanMaintainingFrameLayout != null) {
                viewGroup.removeView(zPlanMaintainingFrameLayout);
                this.f452053b = null;
            }
            QBaseActivity qBaseActivity = this.f452061j.get();
            if (qBaseActivity != null) {
                this.f452052a = ag.f335760a.c(qBaseActivity);
                viewGroup.addView(this.f452052a, 0, new ViewGroup.LayoutParams(-1, -1));
            }
        }
        com.tencent.mobileqq.qui.b.f276860a.a(this.f452052a, RFWNavigationBarImmersiveHelper.ImmersiveType.ABOVE);
        qj3.b bVar = this.f452063l;
        if (bVar != null) {
            bVar.e("zplan_qzone_init", String.valueOf(4), "zplan_qzone_static_view", null);
        }
        B();
        final WeakReference weakReference = new WeakReference(this.f452066o);
        this.f452060i.setOnTouchListener(new View.OnTouchListener() { // from class: z62.d
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean G;
                G = f.G(weakReference, view, motionEvent);
                return G;
            }
        });
        final WeakReference weakReference2 = new WeakReference(this.f452070s);
        this.f452060i.setOnClickListener(new View.OnClickListener() { // from class: z62.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.H(weakReference, weakReference2, view);
            }
        });
        this.f452060i.setAccessibilityDelegate(new c(new WeakReference(this.f452054c)));
    }

    private void d0() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("Leba.ZplanHeaderLayout", 1, "start zplan openTelemetry report failed, app null.");
            return;
        }
        this.f452063l = ((IZPlanReportHelper) peekAppRuntime.getRuntimeService(IZPlanReportHelper.class, "all")).getZPlanTracer();
        HashMap hashMap = new HashMap();
        hashMap.put("TAG", "ZPlanHeaderLayout");
        this.f452063l.d(new ZPlanReportStartTaskInfo("zplan_qzone", String.valueOf(4), null, null, hashMap, Long.valueOf(ShortVideoConstants.VIDEO_MAX_DURATION)));
    }

    private AppInterface e0() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("Leba.ZplanHeaderLayout", 1, "AppRuntime is null when zplan appearanceKey changed!");
            return null;
        }
        try {
            return (AppInterface) peekAppRuntime;
        } catch (ClassCastException unused) {
            QLog.e("Leba.ZplanHeaderLayout", 1, "AppRuntime can't be cast to AppInterface!");
            return null;
        }
    }

    private void f0() {
        if (!this.f452065n) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: z62.c
            @Override // java.lang.Runnable
            public final void run() {
                f.this.I();
            }
        }, 16, null, true);
    }

    private void n() {
        boolean z16;
        QBaseActivity qBaseActivity = this.f452061j.get();
        QLog.i("Leba.ZplanHeaderLayout", 1, "avatarManagerOnDestroy, mAvatarOverlayViewWiringHelper=" + this.f452058g + ", mActivity=" + qBaseActivity);
        if (this.f452058g != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("avatarManagerOnDestroy, isShowingOverlay=");
            if (this.f452058g.c() != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.i("Leba.ZplanHeaderLayout", 1, sb5.toString());
            if (this.f452058g.c() != null && qBaseActivity != null) {
                this.f452058g.c().removeObservers(qBaseActivity);
            }
            this.f452058g.release();
            this.f452058g = null;
        }
        com.tencent.mobileqq.zplan.meme.frameanim.a aVar = this.f452057f;
        if (aVar == null) {
            return;
        }
        aVar.n();
        this.f452057f = null;
    }

    private void o(String str) {
        if (this.f452063l == null) {
            QLog.e("Leba.ZplanHeaderLayout", 1, "endAllReports failed, reportTracer null.");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("TAG", "ZPlanHeaderLayout");
        hashMap.put("endFrom", str);
        ZPlanReportEndTaskInfo zPlanReportEndTaskInfo = new ZPlanReportEndTaskInfo("zplan_qzone", String.valueOf(4), 0, hashMap);
        ZPlanReportEndTaskInfo zPlanReportEndTaskInfo2 = new ZPlanReportEndTaskInfo("zplan_qzone_init", String.valueOf(4), 0, hashMap);
        ZPlanReportEndTaskInfo zPlanReportEndTaskInfo3 = new ZPlanReportEndTaskInfo("zplan_qzone_avatar_manager", String.valueOf(4), 0, hashMap);
        ZPlanReportEndTaskInfo zPlanReportEndTaskInfo4 = new ZPlanReportEndTaskInfo("zplan_qzone_resource", String.valueOf(4), 0, hashMap);
        ZPlanReportEndTaskInfo zPlanReportEndTaskInfo5 = new ZPlanReportEndTaskInfo("zplan_qzone_player", String.valueOf(4), 0, hashMap);
        this.f452063l.c(zPlanReportEndTaskInfo2);
        this.f452063l.c(zPlanReportEndTaskInfo3);
        this.f452063l.c(zPlanReportEndTaskInfo4);
        this.f452063l.c(zPlanReportEndTaskInfo5);
        this.f452063l.c(zPlanReportEndTaskInfo);
    }

    private void p(FrameLayout frameLayout) {
        com.tencent.mobileqq.zplan.bubble.b bVar = this.f452056e;
        if (bVar != null) {
            bVar.a(frameLayout);
            return;
        }
        com.tencent.mobileqq.zplan.bubble.b generateController = ((IZPlanAvatarBubbleControllerFactory) QRoute.api(IZPlanAvatarBubbleControllerFactory.class)).generateController(frameLayout, 0, 0, "em_zplan_entrance_qq_active");
        this.f452056e = generateController;
        this.f452066o.a(new WeakReference<>(generateController));
    }

    public static Card q(AppRuntime appRuntime, String str) {
        return ((IProfileDataService) appRuntime.getRuntimeService(IProfileDataService.class, "all")).getProfileCardFromCache(str);
    }

    private short r() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Card q16 = q(peekAppRuntime, peekAppRuntime.getCurrentAccountUin());
        if (q16 == null) {
            return (short) -1;
        }
        return q16.shGender;
    }

    private String v() {
        if (E()) {
            return "maintaining";
        }
        return "serviceable";
    }

    private void x() {
        com.tencent.mobileqq.zplan.bubble.b bVar = this.f452056e;
        if (bVar == null) {
            return;
        }
        bVar.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        QLog.i("Leba.ZplanHeaderLayout", 2, "hide guide view temporally");
        ZPlanGuideFrameLayout zPlanGuideFrameLayout = this.f452054c;
        if (zPlanGuideFrameLayout != null && zPlanGuideFrameLayout.getVisibility() != 8) {
            this.f452054c.setVisibility(8);
        }
    }

    void B() {
        if (this.f452057f != null) {
            QLog.i("Leba.ZplanHeaderLayout", 1, "initZPlanSequenceAnimManager already init");
            return;
        }
        if (this.f452052a == null) {
            QLog.e("Leba.ZplanHeaderLayout", 1, "initZPlanSequenceAnimManager mZPlanStaticLayout is null");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ZPlanAvatarBannerParams zPlanAvatarBannerParams = new ZPlanAvatarBannerParams(peekAppRuntime.getCurrentAccountUin(), com.tencent.mobileqq.zplan.meme.frameanim.h.INSTANCE.a(), 4, 1);
        IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
        BaseApplication baseApplication = BaseApplication.context;
        AbsZPlanStaticFrameLayout absZPlanStaticFrameLayout = this.f452052a;
        this.f452057f = iZPlanApi.createZPlanAvatarBannerManager(baseApplication, absZPlanStaticFrameLayout, absZPlanStaticFrameLayout.getAvatarIv(), this.f452052a.getBackgroundContainer(), zPlanAvatarBannerParams);
        this.f452057f.r(new e(new WeakReference(this.f452052a)));
        A();
    }

    public void F(int i3) {
        if (E()) {
            W();
            return;
        }
        y();
        Bundle bundle = new Bundle();
        com.tencent.mobileqq.zplan.meme.frameanim.a aVar = this.f452057f;
        if (aVar != null) {
            bundle.putInt(MiniAppGetNativeAppInfoServlet.KEY_NATIVE_APP_ID, aVar.b());
            this.f452057f.h(i3);
        }
        QBaseActivity qBaseActivity = this.f452061j.get();
        if (qBaseActivity == null) {
            return;
        }
        ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).startPortalActivity(qBaseActivity, ZootopiaSource.create(Source.DynamicEntry), bundle);
        R(i3);
    }

    public void J(Configuration configuration) {
        com.tencent.mobileqq.zplan.meme.frameanim.a aVar = this.f452057f;
        if (aVar != null) {
            aVar.i(configuration);
        }
        c0();
    }

    public void K() {
        QLog.i("Leba.ZplanHeaderLayout", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        ViewGroup viewGroup = this.f452059h.get();
        if (viewGroup != null) {
            AbsZPlanStaticFrameLayout absZPlanStaticFrameLayout = this.f452052a;
            if (absZPlanStaticFrameLayout != null) {
                viewGroup.removeView(absZPlanStaticFrameLayout);
            }
            ZPlanMaintainingFrameLayout zPlanMaintainingFrameLayout = this.f452053b;
            if (zPlanMaintainingFrameLayout != null) {
                viewGroup.removeView(zPlanMaintainingFrameLayout);
            }
            ZPlanGuideFrameLayout zPlanGuideFrameLayout = this.f452054c;
            if (zPlanGuideFrameLayout != null) {
                viewGroup.removeView(zPlanGuideFrameLayout);
            }
        }
        View view = this.f452060i;
        if (view != null) {
            view.setOnTouchListener(null);
            this.f452060i.setOnClickListener(null);
        }
        n();
        this.f452052a = null;
        this.f452054c = null;
        this.f452053b = null;
        this.f452062k = false;
        o(MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    public void L(boolean z16) {
        com.tencent.mobileqq.zplan.meme.frameanim.a aVar = this.f452057f;
        if (aVar != null) {
            aVar.m();
        }
        this.f452064m = true;
        o(MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        if (z16) {
            x();
            com.tencent.mobileqq.zplan.meme.frameanim.a aVar2 = this.f452057f;
            if (aVar2 != null) {
                aVar2.k(false);
            }
        }
        this.f452067p.getAndSet(false);
    }

    public void M() {
        QLog.i("Leba.ZplanHeaderLayout", 1, "onReLoginZplanInfoChanged");
        com.tencent.mobileqq.zplan.meme.frameanim.a aVar = this.f452057f;
        if (aVar != null) {
            aVar.f();
        }
        this.f452065n = true;
        f0();
    }

    public void N() {
        this.f452064m = false;
        HashMap hashMap = new HashMap();
        hashMap.put("TAG", "ZPlanHeaderLayout");
        if (this.f452063l != null) {
            this.f452063l.d(new ZPlanReportStartTaskInfo("zplan_qzone_init", String.valueOf(4), "zplan_qzone", String.valueOf(4), hashMap, Long.valueOf(ShortVideoConstants.VIDEO_MAX_DURATION)));
        }
        com.tencent.mobileqq.zplan.meme.frameanim.a aVar = this.f452057f;
        if (aVar != null) {
            aVar.k(true);
        }
        if (E()) {
            Z();
        } else {
            Y();
            a0();
            com.tencent.mobileqq.zplan.meme.frameanim.a aVar2 = this.f452057f;
            if (aVar2 != null) {
                aVar2.o();
                com.tencent.mobileqq.zplan.meme.frameanim.e eVar = this.f452058g;
                if (eVar != null) {
                    eVar.b(this.f452057f.a());
                }
            }
            f0();
        }
        if (this.f452063l != null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("TAG", "ZPlanHeaderLayout");
            this.f452063l.c(new ZPlanReportEndTaskInfo("zplan_qzone_init", String.valueOf(4), 0, hashMap2));
        }
        S();
    }

    public void O() {
        com.tencent.mobileqq.zplan.meme.frameanim.a aVar = this.f452057f;
        if (aVar != null) {
            aVar.s();
        }
    }

    public void P() {
        com.tencent.mobileqq.zplan.meme.frameanim.a aVar = this.f452057f;
        if (aVar != null) {
            aVar.l();
        }
    }

    public void Q() {
        AppInterface e06 = e0();
        if (e06 == null) {
            QLog.e("Leba.ZplanHeaderLayout", 1, "tryGetAppInterface return null!");
        } else {
            e06.removeObserver(this.f452068q);
        }
    }

    public void V(int i3) {
        View view = this.f452060i;
        if (view == null) {
            return;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i3;
        this.f452060i.setLayoutParams(layoutParams);
    }

    public void W() {
        QBaseActivity qBaseActivity = this.f452061j.get();
        if (qBaseActivity == null) {
            return;
        }
        ZPlanMaintInfo maintenanceInfo = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getMaintenanceInfo(MaintEntryType.ALL);
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(qBaseActivity, 230);
        createCustomDialog.setTitle(maintenanceInfo.f());
        createCustomDialog.setMessage(maintenanceInfo.g());
        createCustomDialog.setPositiveButton(R.string.f162021za, (DialogInterface.OnClickListener) new g(), true);
        createCustomDialog.setNegativeButton((String) null, (DialogInterface.OnClickListener) null);
        createCustomDialog.setCancelable(true);
        createCustomDialog.show();
    }

    protected void b0(int i3) {
        ValueAnimator ofInt = ValueAnimator.ofInt(u(), i3);
        ofInt.setDuration(200L).start();
        ofInt.addUpdateListener(new h());
        ofInt.start();
    }

    public void c0() {
        Integer e16 = ni3.a.f420201a.e();
        if (e16 == null) {
            QLog.e("Leba.ZplanHeaderLayout", 1, "smoothScrollToInitHeight failed, initHeight null.");
            return;
        }
        QLog.d("Leba.ZplanHeaderLayout", 1, "[smoothScrollToInitHeight]configuration changed, try reset visible height and smooth to it, initHeight: " + e16);
        b0(e16.intValue());
    }

    public void m() {
        Q();
        AppInterface e06 = e0();
        if (e06 == null) {
            QLog.e("Leba.ZplanHeaderLayout", 1, "tryGetAppInterface return null!");
        } else {
            e06.addObserver(this.f452068q);
        }
    }

    public int s() {
        int screenHeight;
        int dpToPx;
        QBaseActivity qBaseActivity = this.f452061j.get();
        if (qBaseActivity != null && D(qBaseActivity.getBaseContext())) {
            screenHeight = ImmersiveUtils.getScreenWidth() / 2;
            dpToPx = ImmersiveUtils.dpToPx(16.0f);
        } else {
            screenHeight = ImmersiveUtils.getScreenHeight() / 2;
            dpToPx = ImmersiveUtils.dpToPx(16.0f);
        }
        return screenHeight - dpToPx;
    }

    public ArrayList<IZPlanRefreshMoveListener> t() {
        com.tencent.mobileqq.zplan.meme.frameanim.a aVar = this.f452057f;
        if (aVar == null) {
            return null;
        }
        return (ArrayList) aVar.c();
    }

    public int u() {
        View view = this.f452060i;
        if (view == null) {
            return 0;
        }
        return view.getLayoutParams().height;
    }

    public ArrayList<OnRefreshStateListener> w() {
        com.tencent.mobileqq.zplan.meme.frameanim.a aVar = this.f452057f;
        if (aVar == null) {
            return null;
        }
        return (ArrayList) aVar.d();
    }

    public void y() {
        ZPlanGuideFrameLayout zPlanGuideFrameLayout;
        QLog.i("Leba.ZplanHeaderLayout", 2, "[hideZPlanGuideView]");
        QBaseActivity qBaseActivity = this.f452061j.get();
        if (qBaseActivity != null && (zPlanGuideFrameLayout = this.f452054c) != null && zPlanGuideFrameLayout.getVisibility() != 8) {
            this.f452054c.setVisibility(8);
            this.f452055d = false;
            p.g(qBaseActivity, MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin(), false, "sp_key_qzone_zplan_guide", 1);
        }
    }
}
