package rf3;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zootopia.recommend.common.ZplanCardFeedsListView;
import com.tencent.mobileqq.zplan.api.IZplanCacheApi;
import com.tencent.mobileqq.zplan.api.ZplanCacheComponentType;
import com.tencent.mobileqq.zplan.card.impl.view.avatar.ZPlanAvatarCard;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.avatar.event.StretchAvatarEvent;
import com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView;
import com.tencent.sqshow.zootopia.card.view.widget.ZootopiaTopTitleView;
import com.tencent.sqshow.zootopia.guide.ZplanGuideManager;
import com.tencent.sqshow.zootopia.guide.ZplanGuideTriggerEvent;
import com.tencent.sqshow.zootopia.guide.l;
import com.tencent.sqshow.zootopia.recommend.main.tab.a;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.view.pull2refresh.ZootopiaPullRefreshLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rf3.e;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0004\n\u0002\b\b*\u000204\u0018\u0000 :2\u00020\u0001:\u0001$B\u0017\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010*\u001a\u00020'\u00a2\u0006\u0004\b8\u00109J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\n\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u000b\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\bH\u0002J\b\u0010\u0019\u001a\u00020\bH\u0002J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u0006\u0010\u001e\u001a\u00020\bJ\u0006\u0010\u001f\u001a\u00020\bJ\u0017\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006;"}, d2 = {"Lrf3/e;", "", "", "targetState", "", "withAnim", "Lrf3/a;", "listener", "", "v", "r", "t", "Lcom/tencent/sqshow/zootopia/avatar/b;", "avatarView", "Landroid/view/View;", "realAvatarView", "k", "Landroid/view/ViewGroup;", "containerView", "p", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "disableTouchEvent", h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, HippyTKDListViewAdapter.X, "Landroid/support/v7/widget/RecyclerView;", "i", "Lcom/tencent/sqshow/zootopia/card/view/widget/ZootopiaTopTitleView;", "j", "o", DomainData.DOMAIN_NAME, "canScroll", "y", "(Z)V", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zplan/card/impl/view/avatar/ZPlanAvatarCard;", "b", "Lcom/tencent/mobileqq/zplan/card/impl/view/avatar/ZPlanAvatarCard;", "cardView", "c", "Z", "mIsAnimating", "d", "mAnimatingEndDone", "rf3/e$c", "e", "Lrf3/e$c;", "mStretchEvent", "rf3/e$b", "f", "Lrf3/e$b;", "mScrollListener", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/zplan/card/impl/view/avatar/ZPlanAvatarCard;)V", "g", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ZPlanAvatarCard cardView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean mIsAnimating;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mAnimatingEndDone;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final c mStretchEvent;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final b mScrollListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"rf3/e$b", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "Landroid/support/v7/widget/RecyclerView;", "recyclerView", "", "newState", "dy", "", "onScrolled", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int newState, int dy5) {
            Rect rect = new Rect();
            boolean globalVisibleRect = e.this.cardView.getGlobalVisibleRect(rect);
            int mHeight = e.this.cardView.getMHeight();
            int i3 = globalVisibleRect ? rect.bottom - rect.top : 0;
            double d16 = 1 - ((i3 * 1.0d) / mHeight);
            QLog.d("ZPlanAvatarCardSwitchHelper", 1, "recyclerView " + newState + " " + dy5 + " expectHeight " + mHeight + " exposeHeight " + i3);
            ZootopiaTopTitleView j3 = e.this.j();
            if (j3 != null) {
                j3.setBackGroundAlpha((float) d16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\n\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0007j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b`\tH\u0016\u00a8\u0006\u000b"}, d2 = {"rf3/e$c", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/sqshow/zootopia/avatar/event/StretchAvatarEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class c implements SimpleEventReceiver<StretchAvatarEvent> {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"rf3/e$c$a", "Lrf3/a;", "", "c", "b", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes36.dex */
        public static final class a implements rf3.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CountDownLatch f431402a;

            a(CountDownLatch countDownLatch) {
                this.f431402a = countDownLatch;
            }

            @Override // rf3.a
            public void a() {
                this.f431402a.countDown();
            }

            @Override // rf3.a
            public void b() {
                this.f431402a.countDown();
            }

            @Override // rf3.a
            public void c() {
                this.f431402a.countDown();
            }
        }

        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(e this$0, SimpleBaseEvent simpleBaseEvent, CountDownLatch lock) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(lock, "$lock");
            StretchAvatarEvent stretchAvatarEvent = (StretchAvatarEvent) simpleBaseEvent;
            this$0.v(stretchAvatarEvent.getTargetState(), stretchAvatarEvent.getWithAnim(), new a(lock));
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public ArrayList<Class<StretchAvatarEvent>> getEventClass() {
            ArrayList<Class<StretchAvatarEvent>> arrayList = new ArrayList<>();
            arrayList.add(StretchAvatarEvent.class);
            return arrayList;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(final SimpleBaseEvent event) {
            if (event instanceof StretchAvatarEvent) {
                if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                    QLog.i("ZPlanAvatarCardSwitchHelper", 1, "StretchAvatarEvent in main thread: " + event);
                    StretchAvatarEvent stretchAvatarEvent = (StretchAvatarEvent) event;
                    e.w(e.this, stretchAvatarEvent.getTargetState(), stretchAvatarEvent.getWithAnim(), null, 4, null);
                    return;
                }
                QLog.i("ZPlanAvatarCardSwitchHelper", 1, "StretchAvatarEvent in sub thread: " + event);
                long currentTimeMillis = System.currentTimeMillis();
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final e eVar = e.this;
                uIHandlerV2.post(new Runnable() { // from class: rf3.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.c.b(e.this, event, countDownLatch);
                    }
                });
                try {
                    countDownLatch.await(2000L, TimeUnit.MILLISECONDS);
                    QLog.e("ZPlanAvatarCardSwitchHelper", 1, "StretchAvatarEvent in sub thread End[" + (System.currentTimeMillis() - currentTimeMillis) + "ms]: " + event);
                } catch (InterruptedException e16) {
                    QLog.e("ZPlanAvatarCardSwitchHelper", 1, "StretchAvatarEvent in sub thread-InterruptedException: " + event, e16);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"rf3/e$d", "Loc4/a;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class d extends oc4.a {
        d() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            QLog.i("ZPlanAvatarCardSwitchHelper", 1, "switchToFull onAnimationEnd");
            e.this.m(2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"rf3/e$e", "Loc4/a;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: rf3.e$e, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11138e extends oc4.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ViewGroup f431405e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f431406f;

        C11138e(ViewGroup viewGroup, View view) {
            this.f431405e = viewGroup;
            this.f431406f = view;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            QLog.i("ZPlanAvatarCardSwitchHelper", 1, "switchToSmall onAnimationEnd");
            e.this.p(this.f431405e, this.f431406f);
        }
    }

    public e(Context context, ZPlanAvatarCard cardView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cardView, "cardView");
        this.context = context;
        this.cardView = cardView;
        this.mStretchEvent = new c();
        this.mScrollListener = new b();
    }

    private final void h(boolean disableTouchEvent) {
        Object cache = ((IZplanCacheApi) QRoute.api(IZplanCacheApi.class)).getCache(this.context, ZplanCacheComponentType.CARD_LIST_VIEW);
        ZplanCardFeedsListView zplanCardFeedsListView = cache instanceof ZplanCardFeedsListView ? (ZplanCardFeedsListView) cache : null;
        if (zplanCardFeedsListView == null) {
            return;
        }
        zplanCardFeedsListView.setDisableTouchEvent(disableTouchEvent);
    }

    private final RecyclerView i() {
        ZootopiaPullRefreshLayout d16;
        Object cache = ((IZplanCacheApi) QRoute.api(IZplanCacheApi.class)).getCache(this.context, ZplanCacheComponentType.CARD_LIST_VIEW);
        ZplanCardFeedsListView zplanCardFeedsListView = cache instanceof ZplanCardFeedsListView ? (ZplanCardFeedsListView) cache : null;
        if (zplanCardFeedsListView == null || (d16 = zplanCardFeedsListView.d()) == null) {
            return null;
        }
        return d16.E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ZootopiaTopTitleView j() {
        Object cache = ((IZplanCacheApi) QRoute.api(IZplanCacheApi.class)).getCache(this.context, ZplanCacheComponentType.CARD_TOP_LIST);
        if (cache instanceof ZootopiaTopTitleView) {
            return (ZootopiaTopTitleView) cache;
        }
        return null;
    }

    private final void l(int targetState) {
        com.tencent.sqshow.zootopia.avatar.b bVar = (com.tencent.sqshow.zootopia.avatar.b) CommonExKt.p(this.context, ZplanCacheComponentType.AVATAR_COMPONENT_VIEW);
        this.mAnimatingEndDone = false;
        this.mIsAnimating = true;
        h(true);
        if (targetState == 1) {
            y(false);
        } else {
            y(true);
        }
        if (bVar != null) {
            bVar.d(targetState);
        }
        com.tencent.sqshow.zootopia.recommend.main.tab.a aVar = (com.tencent.sqshow.zootopia.recommend.main.tab.a) CommonExKt.p(this.context, ZplanCacheComponentType.MAIN_TAB);
        if (targetState == 2) {
            if (aVar != null) {
                a.C9836a.a(aVar, false, null, 3, null);
            }
        } else if (aVar != null) {
            a.C9836a.b(aVar, false, null, 3, null);
        }
        QLog.i("ZPlanAvatarCardSwitchHelper", 1, "onAnimBegin currentState:" + this.cardView.getMState());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(int targetState) {
        com.tencent.sqshow.zootopia.avatar.b bVar = (com.tencent.sqshow.zootopia.avatar.b) CommonExKt.p(this.context, ZplanCacheComponentType.AVATAR_COMPONENT_VIEW);
        if (bVar != null) {
            bVar.setState(targetState);
        }
        this.mIsAnimating = false;
        this.mAnimatingEndDone = true;
        this.cardView.setMState$zplan_impl_release(targetState);
        if (targetState == 1) {
            y(true);
            Object cache = ((IZplanCacheApi) QRoute.api(IZplanCacheApi.class)).getCache(this.context, ZplanCacheComponentType.CARD_TOP_LIST);
            ZootopiaTopTitleView zootopiaTopTitleView = cache instanceof ZootopiaTopTitleView ? (ZootopiaTopTitleView) cache : null;
            if (zootopiaTopTitleView != null) {
                zootopiaTopTitleView.F();
            }
            l.f370718a.a(true);
            SimpleEventBus.getInstance().dispatchEvent(new ZplanGuideTriggerEvent(6));
        } else if (targetState == 2) {
            y(false);
            if (bVar != null) {
                bVar.a(true);
            }
            ZplanGuideManager.INSTANCE.a().i(11);
        }
        h(false);
        QLog.i("ZPlanAvatarCardSwitchHelper", 1, "onAnimEnd targetState:" + targetState);
    }

    private final void q() {
        SimpleEventBus.getInstance().registerReceiver(this.mStretchEvent);
        RecyclerView i3 = i();
        if (i3 != null) {
            i3.addOnScrollListener(this.mScrollListener);
        }
    }

    private final void r(a listener, boolean withAnim) {
        QLog.i("ZPlanAvatarCardSwitchHelper", 1, "switchToFull mState:" + this.cardView.getMState() + ", mIsAnimating:" + this.mIsAnimating);
        if (this.cardView.getMState() == 2 || this.mIsAnimating) {
            if (listener != null) {
                listener.c();
                return;
            }
            return;
        }
        l(2);
        ArrayList arrayList = new ArrayList();
        com.tencent.sqshow.zootopia.avatar.b bVar = (com.tencent.sqshow.zootopia.avatar.b) CommonExKt.p(this.context, ZplanCacheComponentType.AVATAR_COMPONENT_VIEW);
        boolean isLoadingShowing = bVar != null ? bVar.isLoadingShowing() : true;
        if (isLoadingShowing) {
            this.cardView.getMBgImageView().setImageResource(R.drawable.h5j);
        } else {
            Bitmap e16 = bVar != null ? bVar.e() : null;
            QLog.i("ZPlanAvatarCardSwitchHelper", 1, "switchToFull frame:" + e16);
            if (e16 != null) {
                this.cardView.Q(e16);
                QLog.i("ZPlanAvatarCardSwitchHelper", 1, "switchToFull captureAvatarBg succeed. width:" + e16.getWidth() + ", height:" + e16.getHeight());
            }
        }
        if (listener != null) {
            listener.b();
        }
        if (bVar != null) {
            bVar.g();
        }
        ve3.a aVar = (ve3.a) CommonExKt.p(this.context, ZplanCacheComponentType.AVATAR_FULL_CONTAINER);
        View view = bVar != null ? bVar.getView() : null;
        ViewGroup view2 = aVar != null ? aVar.getView() : null;
        ViewGroup c16 = aVar != null ? aVar.c() : null;
        if (view != null && view2 != null && c16 != null) {
            aVar.b();
            view.setAlpha(0.0f);
            bVar.i(2);
            ViewParent parent = view.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            view.setAlpha(1.0f);
            c16.addView(view, layoutParams);
            c16.setAlpha(0.0f);
            view2.setVisibility(0);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(c16, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            ofFloat.addListener(new d());
            arrayList.add(ofFloat);
            ISceneLoadingView f16 = bVar.f();
            if (f16 != null) {
                f16.setSwitchState(2);
            }
            ZootopiaTopTitleView zootopiaTopTitleView = (ZootopiaTopTitleView) CommonExKt.p(this.context, ZplanCacheComponentType.CARD_TOP_LIST);
            if (zootopiaTopTitleView != null) {
                zootopiaTopTitleView.setTitleState(isLoadingShowing ? 2 : 3);
            }
            AnimatorSet animatorSet = new AnimatorSet();
            QLog.i("ZPlanAvatarCardSwitchHelper", 1, "switchToFull animList:" + arrayList);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSet.play((Animator) it.next());
            }
            animatorSet.setDuration(250L);
            animatorSet.start();
            if (listener != null) {
                listener.a();
            }
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: rf3.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.s(e.this);
                }
            }, 260L);
            return;
        }
        QLog.e("ZPlanAvatarCardSwitchHelper", 1, "containerView:" + view2 + ", realAvatarView:" + view + ", containerContentView:" + c16);
        if (listener != null) {
            listener.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mAnimatingEndDone) {
            return;
        }
        this$0.m(2);
    }

    private final void t(a listener, boolean withAnim) {
        Bitmap e16;
        ImageView a16;
        ImageView a17;
        QLog.i("ZPlanAvatarCardSwitchHelper", 1, "switchToSmall mState:" + this.cardView.getMState() + ", mIsAnimating:" + this.mIsAnimating);
        if (this.cardView.getMState() == 1 || this.mIsAnimating) {
            if (listener != null) {
                listener.c();
                return;
            }
            return;
        }
        l(1);
        ArrayList arrayList = new ArrayList();
        com.tencent.sqshow.zootopia.avatar.b bVar = (com.tencent.sqshow.zootopia.avatar.b) CommonExKt.p(this.context, ZplanCacheComponentType.AVATAR_COMPONENT_VIEW);
        ve3.a aVar = (ve3.a) CommonExKt.p(this.context, ZplanCacheComponentType.AVATAR_FULL_CONTAINER);
        boolean isLoadingShowing = bVar != null ? bVar.isLoadingShowing() : true;
        if (isLoadingShowing) {
            if (aVar != null && (a17 = aVar.a()) != null) {
                a17.setScaleType(ImageView.ScaleType.CENTER_CROP);
                a17.setImageResource(R.drawable.h5j);
            }
        } else if (bVar != null && (e16 = bVar.e()) != null && aVar != null && (a16 = aVar.a()) != null) {
            a16.setScaleType(ImageView.ScaleType.FIT_XY);
            a16.setImageBitmap(e16);
        }
        if (listener != null) {
            listener.b();
        }
        if (bVar != null) {
            bVar.g();
        }
        final View view = bVar != null ? bVar.getView() : null;
        final ViewGroup view2 = aVar != null ? aVar.getView() : null;
        ViewGroup c16 = aVar != null ? aVar.c() : null;
        if (view != null && view2 != null && c16 != null) {
            boolean z16 = isLoadingShowing || !withAnim;
            if (z16) {
                view.setAlpha(1.0f);
                k(bVar, view);
                view2.setVisibility(8);
            } else {
                view.setAlpha(0.0f);
                k(bVar, view);
                c16.setAlpha(1.0f);
                view2.setVisibility(0);
                arrayList.add(ObjectAnimator.ofFloat(c16, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f));
            }
            ISceneLoadingView f16 = bVar.f();
            if (f16 != null) {
                f16.setSwitchState(1);
            }
            ZootopiaTopTitleView zootopiaTopTitleView = (ZootopiaTopTitleView) CommonExKt.p(this.context, ZplanCacheComponentType.CARD_TOP_LIST);
            if (zootopiaTopTitleView != null) {
                zootopiaTopTitleView.setTitleState(1);
            }
            if (listener != null) {
                listener.a();
            }
            if (z16) {
                p(view2, view);
                return;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            QLog.i("ZPlanAvatarCardSwitchHelper", 1, "switchToSmall animList:" + arrayList);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSet.play((Animator) it.next());
            }
            animatorSet.setDuration(250L);
            animatorSet.addListener(new C11138e(view2, view));
            if (listener != null) {
                listener.a();
            }
            animatorSet.start();
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: rf3.c
                @Override // java.lang.Runnable
                public final void run() {
                    e.u(e.this, view2, view);
                }
            }, 260L);
            return;
        }
        QLog.e("ZPlanAvatarCardSwitchHelper", 1, "avatarCompView:" + bVar + ", fullContainer:" + aVar);
        if (listener != null) {
            listener.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(e this$0, ViewGroup viewGroup, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mAnimatingEndDone) {
            return;
        }
        this$0.p(viewGroup, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(int targetState, boolean withAnim, a listener) {
        QLog.i("ZPlanAvatarCardSwitchHelper", 1, "toTargetState targetState:" + targetState);
        if (targetState == 2) {
            r(listener, withAnim);
        } else {
            t(listener, withAnim);
        }
    }

    private final void x() {
        SimpleEventBus.getInstance().unRegisterReceiver(this.mStretchEvent);
        RecyclerView i3 = i();
        if (i3 != null) {
            i3.removeOnScrollListener(this.mScrollListener);
        }
    }

    public final void n() {
        q();
        QLog.i("ZPlanAvatarCardSwitchHelper", 1, NodeProps.ON_ATTACHED_TO_WINDOW);
    }

    public final void o() {
        x();
        QLog.i("ZPlanAvatarCardSwitchHelper", 1, NodeProps.ON_DETACHED_FROM_WINDOW);
    }

    public final void y(boolean canScroll) {
        Object cache = ((IZplanCacheApi) QRoute.api(IZplanCacheApi.class)).getCache(this.context, ZplanCacheComponentType.CARD_LIST_VIEW);
        ZplanCardFeedsListView zplanCardFeedsListView = cache instanceof ZplanCardFeedsListView ? (ZplanCardFeedsListView) cache : null;
        if (zplanCardFeedsListView == null) {
            return;
        }
        zplanCardFeedsListView.setCanScroll(canScroll);
        zplanCardFeedsListView.d().setRefreshEnable(canScroll);
    }

    private final void k(com.tencent.sqshow.zootopia.avatar.b avatarView, View realAvatarView) {
        avatarView.i(1);
        ViewParent parent = realAvatarView.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(realAvatarView);
        }
        e84.b b16 = com.tencent.sqshow.zootopia.avatar.f.f369932a.b();
        this.cardView.E(realAvatarView, false, new FrameLayout.LayoutParams(b16.a().width(), b16.a().height()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(ViewGroup containerView, View realAvatarView) {
        containerView.setVisibility(8);
        realAvatarView.setAlpha(1.0f);
        m(1);
    }

    static /* synthetic */ void w(e eVar, int i3, boolean z16, a aVar, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            aVar = null;
        }
        eVar.v(i3, z16, aVar);
    }
}
