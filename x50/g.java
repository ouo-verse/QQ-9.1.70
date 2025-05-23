package x50;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.events.QFSFeedPositionChangeEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSMainTabSelectEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFollowTabLiveListEvent;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.immersive.utils.bo;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.biz.qqcircle.utils.bv;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QFSRichImageView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.order.IOrderElement;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import fa0.d;
import ga0.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import x50.c;

/* compiled from: P */
/* loaded from: classes4.dex */
public class g extends u implements SimpleEventReceiver, View.OnClickListener, d.a, IOrderElement, c.a {
    private x50.b D;
    private fa0.d<x50.b> E;
    private int I;
    private String J;
    private boolean K;
    private x50.c L;

    /* renamed from: d, reason: collision with root package name */
    private View f447240d;

    /* renamed from: e, reason: collision with root package name */
    private View f447241e;

    /* renamed from: f, reason: collision with root package name */
    private View f447242f;

    /* renamed from: h, reason: collision with root package name */
    private QFSRichImageView f447243h;

    /* renamed from: i, reason: collision with root package name */
    private QFSRichImageView f447244i;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f447245m = false;
    private boolean C = false;
    private int F = 0;
    private int G = 0;
    private boolean H = true;

    private void D9(@NonNull View view, @NonNull x50.b bVar, String str) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_operation_activity_id", Integer.valueOf(bVar.f447218a));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_RECOM_SHOW_STYLE, str);
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_OPERATION_PANEL_CLOSE_BUTTON);
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    private void E9(@NonNull View view, @NonNull x50.b bVar, String str) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_RECOM_SHOW_STYLE, str);
        buildElementParams.put("xsj_operation_activity_id", Integer.valueOf(bVar.f447218a));
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_OPERATION_PANEL);
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    private void F9() {
        QLog.d("QFSMainPagePagAdPart", 1, "changeToCollapseMode");
        if (this.f447240d == null) {
            return;
        }
        this.f447245m = false;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f447240d, "translationX", 0.0f, cx.a(8.0f));
        ofFloat.setDuration(120L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f447240d, "translationX", cx.a(8.0f), -cx.a(94.0f));
        ofFloat2.setDuration(200L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new b());
        animatorSet.play(ofFloat).before(ofFloat2);
        animatorSet.start();
        VideoReport.traversePage(this.f447242f);
    }

    private void H9(QFSRichImageView qFSRichImageView) {
        if (qFSRichImageView != null) {
            qFSRichImageView.Q(null);
        }
    }

    private void I9() {
        QLog.d("QFSMainPagePagAdPart", 1, "fetchData");
        ga0.c.m().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J9() {
        QLog.d("QFSMainPagePagAdPart", 1, "handleCollapseViewAppear");
        fa0.d<x50.b> dVar = this.E;
        x50.b bVar = this.D;
        if (this.f447241e != null && dVar != null && bVar != null) {
            dVar.j(bVar.f447221d, this.f447243h);
            this.f447241e.setVisibility(0);
            View view = this.f447240d;
            if (view != null) {
                view.setVisibility(8);
                H9(this.f447244i);
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f447241e, "translationX", -cx.a(36.0f), 0.0f);
            ofFloat.setDuration(160L);
            ofFloat.addListener(new c(bVar));
            ofFloat.start();
            return;
        }
        QLog.e("QFSMainPagePagAdPart", 1, "handleCollapseViewAppear mCollapsedContainer == null || resLoadManager == null");
    }

    private void K9(@NonNull QFSFeedPositionChangeEvent qFSFeedPositionChangeEvent) {
        int position = qFSFeedPositionChangeEvent.getPosition();
        if (this.G == position) {
            return;
        }
        this.G = position;
        int i3 = this.F + 1;
        this.F = i3;
        if (i3 >= 3 && this.f447245m) {
            F9();
        }
    }

    private void L9(@NonNull x50.b bVar) {
        if (this.f447242f != null) {
            return;
        }
        View inflate = ((ViewStub) getPartRootView().findViewById(R.id.sci)).inflate();
        this.f447242f = inflate;
        View findViewById = inflate.findViewById(R.id.f33320w5);
        this.f447240d = findViewById;
        QFSRichImageView qFSRichImageView = (QFSRichImageView) findViewById.findViewById(R.id.f33330w6);
        this.f447244i = qFSRichImageView;
        qFSRichImageView.setOnClickListener(this);
        this.f447244i.setRepeatTimes(-1);
        View findViewById2 = this.f447240d.findViewById(R.id.f33290w2);
        findViewById2.setOnClickListener(this);
        View findViewById3 = this.f447242f.findViewById(R.id.f349510j);
        this.f447241e = findViewById3;
        View findViewById4 = findViewById3.findViewById(R.id.f33300w3);
        findViewById4.setOnClickListener(this);
        QFSRichImageView qFSRichImageView2 = (QFSRichImageView) this.f447241e.findViewById(R.id.f33310w4);
        this.f447243h = qFSRichImageView2;
        qFSRichImageView2.setOnClickListener(this);
        this.f447243h.setRepeatTimes(-1);
        E9(this.f447244i, bVar, "open");
        E9(this.f447243h, bVar, QCircleDaTongConstant.ElementParamValue.CONTAINER_STATUS_STOW);
        D9(findViewById2, bVar, "open");
        D9(findViewById4, bVar, QCircleDaTongConstant.ElementParamValue.CONTAINER_STATUS_STOW);
    }

    private boolean M9() {
        x50.c cVar = this.L;
        if (cVar != null && cVar.a() != null) {
            List<c.a> a16 = cVar.a();
            for (int i3 = 0; i3 < a16.size(); i3++) {
                c.a aVar = a16.get(i3);
                if (aVar != null && TextUtils.equals(aVar.tabName, this.J)) {
                    if (TextUtils.equals(aVar.tabType, this.I + "")) {
                        QLog.d(getTAG(), 1, "open show by white list");
                        return false;
                    }
                }
            }
        }
        int i16 = this.I;
        if ((i16 != 1 || !this.K) && i16 != 11 && 8 != i16) {
            return false;
        }
        return true;
    }

    private void N9(String str) {
        QLog.d(getTAG(), 1, "jumpToContent jumpUrl:" + str);
        QCircleSchemeLauncher.f(getContext(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O9() {
        View view = this.f447242f;
        if (view == null) {
            return;
        }
        QLog.d(getTAG(), 1, "tryDismissAdViewWithAnim");
        if (view.getVisibility() == 8) {
            return;
        }
        view.clearAnimation();
        view.setVisibility(8);
    }

    private void P9() {
        try {
            this.L = (x50.c) bv.a(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("102694", ""), x50.c.class);
        } catch (Exception e16) {
            QLog.e("QFSMainPagePagAdPart", 1, "convert json error:" + e16);
        }
    }

    private void Q9(x50.b bVar) {
        QLog.d(getTAG(), 1, "onAdInfoChange:" + bVar + ",oldAdInfo:" + this.D);
        this.D = bVar;
        if (bVar == null) {
            com.tencent.biz.qqcircle.immersive.manager.e.a().inactivateElement(this);
            return;
        }
        fa0.d<x50.b> dVar = new fa0.d<>(bVar);
        this.E = dVar;
        if (dVar.r()) {
            QLog.d(getTAG(), 1, "onAdInfoChange res load succeed");
            com.tencent.biz.qqcircle.immersive.manager.e.a().notifyGroupActivate(this);
        } else {
            this.E.x(this);
            this.E.v();
        }
    }

    private void R9(QFSFollowTabLiveListEvent qFSFollowTabLiveListEvent) {
        if (qFSFollowTabLiveListEvent == null) {
            return;
        }
        this.K = qFSFollowTabLiveListEvent.mIsShowLiveList;
        QLog.d(getTAG(), 1, "onLiveStatusChange mCurrentIsShowLiveHead = " + this.K);
        U9();
    }

    private void S9(QFSMainTabSelectEvent qFSMainTabSelectEvent) {
        if (qFSMainTabSelectEvent == null || !qFSMainTabSelectEvent.isSelected()) {
            return;
        }
        this.I = qFSMainTabSelectEvent.getTabType();
        this.J = qFSMainTabSelectEvent.getName();
        U9();
    }

    private void T9(ASEngineTabStatusEvent aSEngineTabStatusEvent) {
        if (!ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE.equals(aSEngineTabStatusEvent.getBusinessKey())) {
            return;
        }
        QLog.d(getTAG(), 1, "onReceiveEvent onTabSelect change to :" + aSEngineTabStatusEvent.isSelected());
        if (aSEngineTabStatusEvent.isSelected()) {
            I9();
            com.tencent.biz.qqcircle.immersive.manager.e.a().notifyGroupActivate(this);
        } else {
            this.C = false;
        }
    }

    private void U9() {
        if (!com.tencent.biz.qqcircle.immersive.manager.e.a().isElementActivating(this)) {
            return;
        }
        if (M9()) {
            View view = this.f447242f;
            if (view != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        x50.b bVar = this.D;
        if (bVar == null) {
            QLog.d(getTAG(), 1, "resetViewByUiStats adInfo == null");
        } else {
            L9(bVar);
            V9();
        }
    }

    private void V9() {
        View view = this.f447242f;
        if (view == null) {
            QLog.d(getTAG(), 1, "[showRootView] rootContainer is null");
            return;
        }
        if (view.getVisibility() != 0) {
            view.setVisibility(0);
            x50.b bVar = this.D;
            if (bVar != null) {
                ga0.d.b().d(101, String.valueOf(bVar.f447218a), bVar.f447226i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W9(QFSRichImageView qFSRichImageView, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        qFSRichImageView.M(str);
    }

    private void X9() {
        getMainHandler().post(new Runnable() { // from class: x50.f
            @Override // java.lang.Runnable
            public final void run() {
                g.this.O9();
            }
        });
    }

    private void Y9() {
        if (!isElementCanActivate()) {
            return;
        }
        if (M9()) {
            QLog.d(getTAG(), 1, "tryShowAdViewWithAnim but mCurrentTabSourceType is " + this.I);
            return;
        }
        QLog.d(getTAG(), 1, "tryShowAdViewWithAnim");
        x50.b bVar = this.D;
        if (bVar == null) {
            QLog.d(getTAG(), 1, "tryShowAdViewWithAnim adInfo == null");
            com.tencent.biz.qqcircle.immersive.manager.e.a().inactivateElement(this);
        } else {
            this.F = 0;
            L9(bVar);
            G9();
            V9();
        }
    }

    @Override // fa0.d.a
    public void A2() {
        QLog.d("QFSMainPagePagAdPart", 1, "onPreloadSucceed");
        com.tencent.biz.qqcircle.immersive.manager.e.a().notifyGroupActivate(this);
    }

    @Override // ga0.c.a
    public void A5(x50.b bVar) {
        QLog.d(getTAG(), 1, "async get config succeed bubbleInfo\uff1a" + bVar);
        Q9(bVar);
        x50.b bVar2 = this.D;
        if (bVar2 != null) {
            bo.e(bVar2.f447225h);
            ga0.c.m().p(null);
        }
    }

    public void G9() {
        QLog.d("QFSMainPagePagAdPart", 1, "changeToExpandMode");
        fa0.d<x50.b> dVar = this.E;
        x50.b bVar = this.D;
        View view = this.f447240d;
        if (view != null && dVar != null && bVar != null) {
            view.setVisibility(0);
            dVar.j(bVar.f447219b, this.f447244i);
            this.f447245m = true;
            View view2 = this.f447241e;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            H9(this.f447243h);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f447240d, "translationX", cx.a(-72.0f), cx.a(8.0f));
            ofFloat.setDuration(240L);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f447240d, "translationX", cx.a(8.0f), 0.0f);
            ofFloat2.setDuration(120L);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(ofFloat).before(ofFloat2);
            animatorSet.addListener(new a(bVar));
            animatorSet.start();
            VideoReport.traversePage(this.f447242f);
            return;
        }
        QLog.e("QFSMainPagePagAdPart", 1, "mExpandContainer == null || resLoadManager == null");
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getContextHashCode() {
        if (getContext() == null) {
            return "";
        }
        return String.valueOf(getContext().hashCode());
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ String getElementExtraKey() {
        return com.tencent.biz.richframework.order.a.a(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSFeedPositionChangeEvent.class);
        arrayList.add(ASEngineTabStatusEvent.class);
        arrayList.add(QFSMainTabSelectEvent.class);
        arrayList.add(QFSFollowTabLiveListEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getGroup() {
        return "folder_pendant";
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ String getGroupExtraKey() {
        return com.tencent.biz.richframework.order.a.b(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSMainPagePagAdPart";
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 101;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ boolean isDataReady() {
        return com.tencent.biz.richframework.order.a.c(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        fa0.d<x50.b> dVar;
        if (!isPartEnable() || this.D == null || (dVar = this.E) == null || !dVar.r() || this.C) {
            return false;
        }
        if (!f40.b.a(this)) {
            return true;
        }
        QLog.e("QFSMainPagePagAdPart", 1, "isElementCanActivate elementShowHistory containChangeTabElement");
        return false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        return !((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.D != null) {
            int id5 = view.getId();
            if (id5 != R.id.f33330w6 && id5 != R.id.f33310w4) {
                if (id5 == R.id.f33290w2 || id5 == R.id.f33300w3) {
                    this.C = true;
                    com.tencent.biz.qqcircle.immersive.manager.e.a().inactivateElement(this);
                }
            } else {
                N9(this.D.f447225h);
                ga0.d.b().d(102, String.valueOf(this.D.f447218a), this.D.f447226i);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        Y9();
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        X9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        com.tencent.biz.qqcircle.immersive.manager.e.a().addElement(this);
        P9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        x50.b n3 = ga0.c.m().n();
        if (!Objects.equals(n3, this.D)) {
            Q9(n3);
        }
        x50.b bVar = this.D;
        if (bVar == null) {
            QLog.d(getTAG(), 1, "async get config");
            ga0.c.m().p(this);
            if (this.H) {
                I9();
            }
        } else {
            bo.e(bVar.f447225h);
            View view = this.f447242f;
            if (view != null && view.getVisibility() == 0) {
                ga0.d.b().d(101, String.valueOf(this.D.f447218a), this.D.f447226i);
            }
        }
        this.H = false;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSFeedPositionChangeEvent) {
            K9((QFSFeedPositionChangeEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof ASEngineTabStatusEvent) {
            T9((ASEngineTabStatusEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSMainTabSelectEvent) {
            S9((QFSMainTabSelectEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSFollowTabLiveListEvent) {
            R9((QFSFollowTabLiveListEvent) simpleBaseEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ x50.b f447246d;

        a(x50.b bVar) {
            this.f447246d = bVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            g gVar = g.this;
            gVar.W9(gVar.f447244i, this.f447246d.f447220c);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            g.this.J9();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ x50.b f447249d;

        c(x50.b bVar) {
            this.f447249d = bVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            g gVar = g.this;
            gVar.W9(gVar.f447243h, this.f447249d.f447222e);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    @Override // fa0.d.a
    public void h4() {
    }
}
