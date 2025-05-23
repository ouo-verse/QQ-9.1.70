package xk1;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.util.Supplier;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.AtButtonActor;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.PicButtonActor;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.InputAnimationControllerImpl;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import xk1.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 D*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001EB'\u0012\u0006\u0010\u001c\u001a\u00028\u0000\u0012\u0006\u0010\"\u001a\u00020\u001d\u0012\u0006\u0010@\u001a\u00020?\u0012\u0006\u0010A\u001a\u00020\u000b\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u0006\u0010\u0010\u001a\u00020\u0004J\"\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u000bJ\b\u0010\u0016\u001a\u00020\u0004H\u0016J\u0006\u0010\u0017\u001a\u00020\u0004R\u0017\u0010\u001c\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\"\u00102\u001a\u00020+8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00107\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b4\u00104\u001a\u0004\b5\u00106R\"\u0010>\u001a\u0002088\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010 \u001a\u0004\b:\u0010;\"\u0004\b<\u0010=\u00a8\u0006F"}, d2 = {"Lxk1/d;", "Lxk1/e;", "AdornType", "Lcom/tencent/mobileqq/guild/feed/widget/comment/f;", "", "e0", "f0", "j0", "m0", "U", "c0", "", "type", "n0", "show", "dismiss", "W", "", "reason", "flag", "hideIntent", "a0", "onBackPressed", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "D", "Lxk1/e;", "X", "()Lxk1/e;", "adornApi", "Lcom/tencent/mobileqq/guild/feed/util/framework/route/a;", "E", "Lcom/tencent/mobileqq/guild/feed/util/framework/route/a;", "Z", "()Lcom/tencent/mobileqq/guild/feed/util/framework/route/a;", "router", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/c;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/c;", "imeHelper", "Lxk1/f;", "G", "Lxk1/f;", "binding", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e;", "H", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e;", "Y", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e;", "i0", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e;)V", "inputAnimController", "<set-?>", "I", "getTransitionState", "()I", "transitionState", "", "J", "d0", "()Z", "setInitialized", "(Z)V", "isInitialized", "Landroid/content/Context;", "context", "style", "<init>", "(Lxk1/e;Lcom/tencent/mobileqq/guild/feed/util/framework/route/a;Landroid/content/Context;I)V", "K", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d<AdornType extends e> extends com.tencent.mobileqq.guild.feed.widget.comment.f {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final AdornType adornApi;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.util.framework.route.a router;

    /* renamed from: F */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.c imeHelper;

    /* renamed from: G, reason: from kotlin metadata */
    private f binding;

    /* renamed from: H, reason: from kotlin metadata */
    public com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e inputAnimController;

    /* renamed from: I, reason: from kotlin metadata */
    private int transitionState;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isInitialized;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\u0019\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0096\u0001J\u0019\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0096\u0001J\b\u0010\u000b\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"xk1/d$b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$b;", "", "f", "", "panelId", "targetHeight", "e", "height", "targetHeightHint", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements e.b {

        /* renamed from: a */
        private final /* synthetic */ e.b f448107a;

        /* renamed from: b */
        final /* synthetic */ d<AdornType> f448108b;

        b(e.b bVar, d<AdornType> dVar) {
            this.f448108b = dVar;
            this.f448107a = bVar;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e.b
        public void a(int height, int targetHeightHint) {
            this.f448107a.a(height, targetHeightHint);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e.b
        public void b() {
            ((d) this.f448108b).imeHelper.e();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e.b
        public void e(int panelId, int targetHeight) {
            this.f448107a.e(panelId, targetHeight);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e.b
        public void f() {
            this.f448107a.f();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"xk1/d$c", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "", "onPreDraw", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: d */
        final /* synthetic */ d<AdornType> f448109d;

        c(d<AdornType> dVar) {
            this.f448109d = dVar;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            f fVar = ((d) this.f448109d).binding;
            if (fVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fVar = null;
            }
            fVar.getInputPanelContainer().getViewTreeObserver().removeOnPreDrawListener(this);
            return this.f448109d.X().onRenderFirstFrame();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull AdornType adornApi, @NotNull com.tencent.mobileqq.guild.feed.util.framework.route.a router, @NotNull Context context, int i3) {
        super(context, i3);
        Intrinsics.checkNotNullParameter(adornApi, "adornApi");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(context, "context");
        this.adornApi = adornApi;
        this.router = router;
        this.imeHelper = new com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.c("InputWindow");
    }

    private final void U() {
        View decorView;
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -1;
            if (Build.VERSION.SDK_INT >= 28) {
                attributes.layoutInDisplayCutoutMode = 3;
            }
            Window window2 = getWindow();
            Intrinsics.checkNotNull(window2);
            window2.setAttributes(attributes);
            Window window3 = getWindow();
            Intrinsics.checkNotNull(window3);
            window3.setSoftInputMode(this.adornApi.g());
        }
        Window window4 = getWindow();
        if (window4 != null && (decorView = window4.getDecorView()) != null) {
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 1024);
        }
    }

    public static /* synthetic */ void b0(d dVar, String str, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i3 = 0;
        }
        if ((i17 & 4) != 0) {
            i16 = 0;
        }
        dVar.a0(str, i3, i16);
    }

    private final void e0() {
        e.b uiStateUpdater = Y().getUiStateUpdater();
        if (uiStateUpdater == null) {
            return;
        }
        Y().i(new b(uiStateUpdater, this));
    }

    private final void f0() {
        InputAnimationControllerImpl inputAnimationControllerImpl = new InputAnimationControllerImpl("InputWindow", this.adornApi.a());
        inputAnimationControllerImpl.d0(new Supplier() { // from class: xk1.c
            @Override // androidx.core.util.Supplier
            public final Object get() {
                Configuration g06;
                g06 = d.g0(d.this);
                return g06;
            }
        });
        inputAnimationControllerImpl.f0(this.adornApi.e());
        i0(inputAnimationControllerImpl);
        f fVar = this.binding;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fVar = null;
        }
        fVar.getInputPanelContainer().getViewTreeObserver().addOnPreDrawListener(new c(this));
    }

    public static final Configuration g0(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.getContext().getResources().getConfiguration();
    }

    private final void j0() {
        f fVar = this.binding;
        f fVar2 = null;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fVar = null;
        }
        fVar.getBlankView().setOnClickListener(new View.OnClickListener() { // from class: xk1.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.k0(d.this, view);
            }
        });
        f fVar3 = this.binding;
        if (fVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fVar2 = fVar3;
        }
        fVar2.getInputPanelContainer().setOnClickListener(new View.OnClickListener() { // from class: xk1.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.l0(view);
            }
        });
    }

    public static final void k0(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b0(this$0, "blankArea", 0, 0, 6, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    public static final void l0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void m0() {
        com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.c cVar = this.imeHelper;
        f fVar = this.binding;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fVar = null;
        }
        cVar.i(fVar.getInput());
    }

    public final void W() {
        if (this.isInitialized) {
            Y().h(false);
        }
    }

    @NotNull
    public final AdornType X() {
        return this.adornApi;
    }

    @NotNull
    public final com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e Y() {
        com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e eVar = this.inputAnimController;
        if (eVar != null) {
            return eVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("inputAnimController");
        return null;
    }

    @NotNull
    /* renamed from: Z, reason: from getter */
    public final com.tencent.mobileqq.guild.feed.util.framework.route.a getRouter() {
        return this.router;
    }

    public final void a0(@NotNull String reason, int flag, int hideIntent) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        this.adornApi.f(hideIntent);
        Y().c(reason, flag);
    }

    public final void c0() {
        if (this.isInitialized) {
            return;
        }
        AdornType adorntype = this.adornApi;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        f b16 = adorntype.b(context);
        this.binding = b16;
        if (b16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            b16 = null;
        }
        setContentView(b16.getRoot());
        U();
        this.adornApi.c();
        j0();
        f0();
        m0();
        this.isInitialized = true;
        this.adornApi.d(this);
        e0();
    }

    /* renamed from: d0, reason: from getter */
    public final boolean getIsInitialized() {
        return this.isInitialized;
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        int i3 = this.transitionState;
        if (i3 != 0) {
            QLog.w("InputWindow", 1, "InputWindow's transitionState=" + i3);
            return;
        }
        this.transitionState = 2;
        b0(this, "dismiss", 1, 0, 4, null);
        this.imeHelper.h();
        super.dismiss();
        this.transitionState = 0;
    }

    public final void i0(@NotNull com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<set-?>");
        this.inputAnimController = eVar;
    }

    public final void n0(int type) {
        Y().h(true);
        int i3 = this.transitionState;
        if (i3 != 0) {
            QLog.w("InputWindow", 1, "InputWindow's transitionState=" + i3);
            return;
        }
        try {
            try {
                this.transitionState = 1;
                if (type != 0) {
                    if (type != 2) {
                        if (type != 3) {
                            if (type != 4) {
                                super.show();
                            } else {
                                PicButtonActor picButtonActor = (PicButtonActor) this.router.b(PicButtonActor.class);
                                if (picButtonActor != null) {
                                    picButtonActor.k();
                                }
                            }
                        } else {
                            super.show();
                            Y().e(1);
                        }
                    } else {
                        AtButtonActor atButtonActor = (AtButtonActor) this.router.b(AtButtonActor.class);
                        if (atButtonActor != null) {
                            atButtonActor.l();
                        }
                    }
                } else {
                    super.show();
                    this.imeHelper.f();
                }
            } catch (Exception e16) {
                QLog.e("InputWindow", 1, "show error! " + e16.getMessage());
            }
        } finally {
            this.transitionState = 0;
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (this.isInitialized) {
            e.d.a(Y(), "onBackPress", 0, 2, null);
        }
    }

    public final void onDestroy() {
        this.isInitialized = false;
        this.imeHelper.h();
        Y().onDestroy();
    }

    @Override // com.tencent.mobileqq.guild.feed.widget.comment.f, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
    }
}
