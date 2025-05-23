package w64;

import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.launch.d;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mvi.base.route.VMMessenger;
import com.tencent.robot.widget.bottomdialog.BottomSheetDialogMsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import w64.j;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 ,*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u0004:\u0001%B\u0015\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001fR\u0016\u0010#\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\"R\u0014\u0010'\u001a\u00020$8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020!8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010(\u00a8\u0006-"}, d2 = {"Lw64/b;", "Lw64/j;", "T", "Landroid/widget/PopupWindow;", "Lw64/o;", "", "l", tl.h.F, "i", "j", "showDialog", "", "r", "needAnimation", "b", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "g", "Lcom/tencent/input/base/launch/b;", "c", "Lw64/n;", "d", "Lw64/n;", "mDialogFactory", "Lw64/h;", "e", "Lw64/h;", "mCreateParams", "Lw64/e;", "f", "Lw64/e;", "mDialogContext", "Lcom/tencent/input/base/launch/b;", "mExternalProvider", "", "I", "mTransitionState", "Landroid/view/View;", "a", "()Landroid/view/View;", "anchor", "()I", "transitionState", "<init>", "(Lw64/n;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b<T extends j> extends PopupWindow implements o {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final n<T> mDialogFactory;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h<T> mCreateParams;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private e<T> mDialogContext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.input.base.launch.b mExternalProvider;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mTransitionState;

    public b(@NotNull n<T> mDialogFactory) {
        Intrinsics.checkNotNullParameter(mDialogFactory, "mDialogFactory");
        this.mDialogFactory = mDialogFactory;
        h<T> hVar = new h<>(mDialogFactory);
        this.mCreateParams = hVar;
        h();
        l();
        d<T> c16 = hVar.c();
        e<T> eVar = this.mDialogContext;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogContext");
            eVar = null;
        }
        c16.c(eVar, hVar.i(), hVar.d());
        i();
        hVar.c().d(this);
    }

    private final void h() {
        setContentView(new CoordinatorLayout(this.mCreateParams.b()));
    }

    private final void i() {
        com.tencent.input.base.launch.c cVar = new com.tencent.input.base.launch.c();
        d.a aVar = new d.a();
        e<T> eVar = this.mDialogContext;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogContext");
            eVar = null;
        }
        d.a d16 = aVar.d(eVar);
        View contentView = getContentView();
        Intrinsics.checkNotNull(contentView, "null cannot be cast to non-null type android.view.ViewGroup");
        this.mExternalProvider = cVar.a(d16.e((ViewGroup) contentView).b(this.mCreateParams.b()).c(this.mCreateParams.f()).f(this.mCreateParams.h()).g(this.mCreateParams.i()).a());
        j();
    }

    private final void j() {
        View hostView = this.mCreateParams.h().getHostView();
        ViewGroup.LayoutParams layoutParams = hostView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        ((CoordinatorLayout.LayoutParams) layoutParams).setBehavior(this.mCreateParams.c().g(hostView));
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: w64.a
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                b.k(b.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(b this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        e<T> eVar = this$0.mDialogContext;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogContext");
            eVar = null;
        }
        com.tencent.mvi.base.route.j e16 = eVar.e();
        View contentView = this$0.getContentView();
        Intrinsics.checkNotNullExpressionValue(contentView, "contentView");
        e16.h(new BottomSheetDialogMsgIntent.OnDialogDismissed(0, contentView));
    }

    private final void l() {
        g gVar = new g();
        gVar.p(this.mCreateParams.g());
        gVar.m(this.mCreateParams.e());
        gVar.n(this.mCreateParams.f());
        gVar.o(new VMMessenger(false, null, 3, 0 == true ? 1 : 0));
        gVar.l(this.mCreateParams.d());
        this.mDialogContext = gVar;
    }

    @Override // w64.o
    @NotNull
    public View a() {
        return this.mCreateParams.a();
    }

    @Override // w64.o
    public void b(boolean needAnimation) {
        boolean z16;
        this.mCreateParams.c().a();
        if (isShowing() && getMTransitionState() != 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!needAnimation) {
            if (z16) {
                this.mTransitionState = 2;
                this.mCreateParams.c().e(false);
                this.mTransitionState = 0;
                return;
            }
            e<T> eVar = this.mDialogContext;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogContext");
                eVar = null;
            }
            com.tencent.mvi.base.route.j e16 = eVar.e();
            View contentView = getContentView();
            Intrinsics.checkNotNullExpressionValue(contentView, "contentView");
            e16.h(new BottomSheetDialogMsgIntent.OnDialogDismissed(1, contentView));
            return;
        }
        if (z16) {
            this.mCreateParams.c().e(true);
        }
    }

    @Override // w64.o
    @NotNull
    public com.tencent.input.base.launch.b c() {
        com.tencent.input.base.launch.b bVar = this.mExternalProvider;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mExternalProvider");
            return null;
        }
        return bVar;
    }

    @Override // w64.o
    /* renamed from: e, reason: from getter */
    public int getMTransitionState() {
        return this.mTransitionState;
    }

    @Override // w64.o
    public void onDestroy() {
        this.mCreateParams.h().destroy();
        this.mCreateParams.c().h();
    }

    @Override // w64.o
    public boolean r() {
        return isShowing();
    }

    @Override // w64.o
    public void showDialog() {
        if (a().getWindowToken() != null && this.mTransitionState == 0) {
            this.mTransitionState = 1;
            this.mCreateParams.c().f();
            if (this.mTransitionState == 1) {
                e<T> eVar = this.mDialogContext;
                if (eVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDialogContext");
                    eVar = null;
                }
                com.tencent.mvi.base.route.j e16 = eVar.e();
                View contentView = getContentView();
                Intrinsics.checkNotNullExpressionValue(contentView, "contentView");
                e16.h(new BottomSheetDialogMsgIntent.OnDialogShowed(contentView));
                this.mCreateParams.c().b();
            }
            this.mTransitionState = 0;
        }
    }

    @Override // w64.o
    @NotNull
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public b<T> d() {
        return this;
    }
}
