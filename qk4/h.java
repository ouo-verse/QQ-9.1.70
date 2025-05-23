package qk4;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqgift.api.IQQGiftComboView;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.api.IQQLiveReportApi;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import com.tencent.timi.game.gift.impl.timi.TimiGiftPanelEvent;
import com.tencent.timi.game.liveroom.impl.room.quickgift.quicksendgift.FreeGiftSendResultEvent;
import com.tencent.timi.game.liveroom.impl.room.util.QuickGiftBalanceEvent;
import java.util.ArrayList;
import pk4.b;
import qk4.b;

/* compiled from: P */
/* loaded from: classes26.dex */
public class h implements SimpleEventReceiver {
    private com.tencent.mobileqq.qqgift.data.service.d D;
    private long E;
    private int F;
    private c55.d G;

    /* renamed from: d, reason: collision with root package name */
    private Activity f429027d;

    /* renamed from: e, reason: collision with root package name */
    private View f429028e;

    /* renamed from: f, reason: collision with root package name */
    private FrameLayout f429029f;

    /* renamed from: h, reason: collision with root package name */
    private IQQGiftComboView f429030h = (IQQGiftComboView) QRoute.api(IQQGiftComboView.class);

    /* renamed from: i, reason: collision with root package name */
    private long f429031i = 0;

    /* renamed from: m, reason: collision with root package name */
    private long f429032m = 0;
    private long C = System.currentTimeMillis();
    private rh2.a H = new e();

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements b.InterfaceC11084b {
        a() {
        }

        @Override // qk4.b.InterfaceC11084b
        public void a() {
            h.this.I();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class e implements rh2.a {
        e() {
        }

        @Override // rh2.a
        public void h(long j3, long j16, long j17, int i3) {
            AegisLogger.i("Gift|quick_send_gift", "IQQGiftBalanceCallback.onReceive", "requestBalance success, balance=" + j3 + ", seq=" + j17);
            h.this.f429031i = j3;
            h.this.f429032m = j16;
        }

        @Override // qh2.d
        public void onFailed(int i3, String str) {
            AegisLogger.i("Gift|quick_send_gift", "IQQGiftBalanceCallback.onFailed", "requestBalance fail, errCode=" + i3 + ", errMsg=" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        if (this.D != null) {
            long j3 = this.f429032m;
            if (j3 >= 0) {
                this.f429032m = j3 - r0.f264878f;
            }
            if (this.f429032m < 0) {
                this.f429032m = 0L;
                long j16 = this.f429031i - r0.f264878f;
                this.f429031i = j16;
                if (j16 <= 0) {
                    this.f429031i = 0L;
                    G(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void z() {
        pk4.b.t(new rk4.a(this.H));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(boolean z16) {
        View view;
        if (!w() && (view = this.f429028e) != null) {
            view.setVisibility(8);
            this.f429030h.hideAnimation(this.f429028e);
        }
    }

    private void H() {
        AegisLogger.i("Gift|quick_send_gift", "sendFreeGift, isPackage:" + this.D.f264875d0);
        pk4.b.L(this.f429027d, this.f429031i, this.D, 1, new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        pk4.b.p(this.f429027d, true, this.D, this.f429031i, this.f429032m, new b());
    }

    private void t() {
        if (this.f429029f == null) {
            AegisLogger.e("Gift|quick_send_gift", "buildComboSendView", "fail, container is null");
            return;
        }
        if (!w()) {
            AegisLogger.e("Gift|quick_send_gift", "buildComboSendView", "fail, still in last audience room");
        } else if (this.f429030h.isPagSoReady(BaseApplication.context)) {
            AegisLogger.i("Gift|quick_send_gift", "buildComboSendView", "success, pag so is ready!");
            x();
        } else {
            AegisLogger.w("Gift|quick_send_gift", "buildComboSendView", "pending, try load pag so...");
            this.f429030h.loadPag(BaseApplication.context, new IQQGiftComboView.a() { // from class: qk4.f
                @Override // com.tencent.mobileqq.qqgift.api.IQQGiftComboView.a
                public final void onComplete() {
                    h.this.y();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void x() {
        View v3 = v(this.f429029f.getContext());
        v3.setVisibility(8);
        this.f429029f.removeAllViews();
        this.f429029f.addView(v3);
    }

    private View v(Context context) {
        View view = this.f429028e;
        if (view != null) {
            return view;
        }
        View createView = this.f429030h.createView(context, pk4.b.v(), new d());
        this.f429028e = createView;
        return createView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w() {
        if (this.f429028e == null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y() {
        AegisLogger.i("Gift|quick_send_gift", "buildComboSendView", "success, pad so load complete!");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: qk4.g
            @Override // java.lang.Runnable
            public final void run() {
                h.this.x();
            }
        });
    }

    public void A(Activity activity, long j3, int i3) {
        this.E = j3;
        this.F = i3;
        this.f429027d = activity;
        FrameLayout frameLayout = this.f429029f;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        t();
        ThreadManagerV2.excute(new Runnable() { // from class: qk4.e
            @Override // java.lang.Runnable
            public final void run() {
                h.this.z();
            }
        }, 16, null, false);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    public void B() {
        View view = this.f429028e;
        if (view != null) {
            view.setVisibility(8);
            this.f429030h.hideAnimation(this.f429028e);
            this.f429030h.removePagloadCallbacks();
            this.f429028e.setOnClickListener(null);
            this.f429028e = null;
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    public void C() {
        if (this.D == null) {
            AegisLogger.e("Gift|quick_send_gift", "onQuickBtnClick", "fail, quickGiftData is null");
        } else if (!com.tencent.mobileqq.qqlive.sail.c.f272176a.m().F(this.E, 0)) {
            AegisLogger.w("Gift|quick_send_gift", "handlerGiftEntrance", "anchor is not QQAnchor");
            gt3.a.INSTANCE.a().a("\u5916\u90e8\u5185\u5bb9\u6e90\u623f\u95f4\u4e0d\u652f\u6301\u9001\u793c", 0, BaseApplication.context);
        } else {
            H();
        }
    }

    public void D() {
        if (this.G == null) {
            AegisLogger.e("Gift|quick_send_gift", "onQuickBtnClick", "fail, quickGiftConf is null");
            return;
        }
        if (this.D == null) {
            AegisLogger.e("Gift|quick_send_gift", "onQuickBtnClick", "fail, quickGiftData is null");
            return;
        }
        if (!com.tencent.mobileqq.qqlive.sail.c.f272176a.m().F(this.E, 0)) {
            AegisLogger.w("Gift|quick_send_gift", "handlerGiftEntrance", "anchor is not QQAnchor");
            gt3.a.INSTANCE.a().a("\u5916\u90e8\u5185\u5bb9\u6e90\u623f\u95f4\u4e0d\u652f\u6301\u9001\u793c", 0, BaseApplication.context);
            return;
        }
        b.Companion companion = qk4.b.INSTANCE;
        Activity activity = this.f429027d;
        c55.d dVar = this.G;
        if (companion.d(activity, dVar.f30392c, this.D, this.f429031i, this.f429032m, this.E, this.F, dVar.f30393d, new a())) {
            AegisLogger.i("Gift|quick_send_gift", "onQuickBtnClick", "fail, first show");
        } else {
            I();
        }
    }

    public void J(FrameLayout frameLayout) {
        this.f429029f = frameLayout;
    }

    public void K(c55.d dVar) {
        this.G = dVar;
    }

    public void L(com.tencent.mobileqq.qqgift.data.service.d dVar) {
        this.D = dVar;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QuickGiftBalanceEvent.class);
        arrayList.add(TimiGiftPanelEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QuickGiftBalanceEvent) {
            z();
        } else if ((simpleBaseEvent instanceof TimiGiftPanelEvent) && ((TimiGiftPanelEvent) simpleBaseEvent).getCmd() == 2) {
            z();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class d implements ph2.b {

        /* renamed from: d, reason: collision with root package name */
        private int f429036d = 1;

        /* renamed from: e, reason: collision with root package name */
        private int f429037e = 1;

        /* renamed from: f, reason: collision with root package name */
        private b.k f429038f = new a();

        d() {
        }

        @Override // ph2.b
        public void c(int i3, int i16, boolean z16) {
            if (h.this.w()) {
                AegisLogger.i("Gift|quick_send_gift", "QQGiftComboSendViewListener.onSend", "fail, had exit room");
                return;
            }
            this.f429036d = i3;
            this.f429037e = i16;
            pk4.b.J(h.this.f429027d, h.this.f429031i, h.this.f429032m, this.f429038f, i3, i16, h.this.C, h.this.D);
            h.this.E();
        }

        @Override // ph2.b
        public void i() {
            pk4.b.K(h.this.D, h.this.C, this.f429036d, this.f429037e, h.this.f429031i);
            h.this.G(false);
            h.this.z();
        }

        @Override // ph2.b
        public void j() {
            QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
            if (c16 != null) {
                ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).qualityReport(new QQLiveQualityReportData.Builder().eventId(QQLiveReportConstants.Event.E_AUDIENCE_GIFTCOMBO_RESOURCE_INVALID).traceId(c16.n()).ext6(QQLiveReportConstants.Scene.SCENE_QUICK_GIFT_COMBO));
            }
        }

        @Override // ph2.b
        public void e() {
        }

        /* compiled from: P */
        /* loaded from: classes26.dex */
        class a implements b.k {
            a() {
            }

            @Override // pk4.b.k
            public void a(int i3, String str) {
                h.this.G(true);
            }

            @Override // pk4.b.k
            public void b(int i3, String str) {
                h.this.G(true);
            }

            @Override // pk4.b.k
            public void e(int i3, String str) {
                h.this.G(true);
                h.this.z();
            }

            @Override // pk4.b.k
            public void f(String str) {
                h.this.G(true);
            }

            @Override // pk4.b.k
            public void c(com.tencent.mobileqq.qqgift.data.service.d dVar) {
            }

            @Override // pk4.b.k
            public void d(com.tencent.mobileqq.qqgift.data.service.d dVar) {
            }
        }

        @Override // ph2.b
        public void b(int i3) {
        }

        @Override // ph2.b
        public void s(int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements b.k {
        b() {
        }

        @Override // pk4.b.k
        public void d(com.tencent.mobileqq.qqgift.data.service.d dVar) {
            if (h.this.w()) {
                return;
            }
            if (h.this.f429029f != null) {
                h.this.f429029f.setVisibility(0);
            }
            h.this.C = System.currentTimeMillis();
            h.this.f429028e.setVisibility(0);
            h.this.f429030h.showAnimation(h.this.f429028e);
            pk4.b.J(h.this.f429027d, h.this.f429031i, h.this.f429032m, null, 1, 1, h.this.C, h.this.D);
            h.this.E();
        }

        @Override // pk4.b.k
        public void c(com.tencent.mobileqq.qqgift.data.service.d dVar) {
        }

        @Override // pk4.b.k
        public void f(String str) {
        }

        @Override // pk4.b.k
        public void a(int i3, String str) {
        }

        @Override // pk4.b.k
        public void b(int i3, String str) {
        }

        @Override // pk4.b.k
        public void e(int i3, String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class c implements b.k {
        c() {
        }

        @Override // pk4.b.k
        public void b(int i3, String str) {
            AegisLogger.e("Gift|quick_send_gift", "freeGift onSendGiftFail", "errCode:" + i3 + ", errMsg:" + str);
            SimpleEventBus.getInstance().dispatchEvent(new FreeGiftSendResultEvent(false, h.this.D.f264875d0));
        }

        @Override // pk4.b.k
        public void c(com.tencent.mobileqq.qqgift.data.service.d dVar) {
            AegisLogger.i("Gift|quick_send_gift", "freeGift onSendGiftSuccess");
            SimpleEventBus.getInstance().dispatchEvent(new FreeGiftSendResultEvent(true, h.this.D.f264875d0));
        }

        @Override // pk4.b.k
        public void d(com.tencent.mobileqq.qqgift.data.service.d dVar) {
        }

        @Override // pk4.b.k
        public void f(String str) {
        }

        @Override // pk4.b.k
        public void a(int i3, String str) {
        }

        @Override // pk4.b.k
        public void e(int i3, String str) {
        }
    }
}
