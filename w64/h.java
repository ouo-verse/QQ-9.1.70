package w64;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVB;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import w64.j;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0017\b\u0016\u0012\f\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000E\u00a2\u0006\u0004\bG\u0010HR\"\u0010\n\u001a\u00028\u00008\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u0004\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00128\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\f\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010'\u001a\u00020!8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R>\u00101\u001a\u001e\u0012\u0006\b\u0001\u0012\u00020)\u0012\u0006\b\u0001\u0012\u00020*\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000+0(8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b#\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00108\u001a\u0002028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0006\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010>\u001a\u0002098\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b-\u0010:\u001a\u0004\b\u001a\u0010;\"\u0004\b<\u0010=R(\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000?8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b4\u0010@\u001a\u0004\b\u0013\u0010A\"\u0004\bB\u0010C\u00a8\u0006I"}, d2 = {"Lw64/h;", "Lw64/j;", "T", "", "a", "Lw64/j;", "g", "()Lw64/j;", "p", "(Lw64/j;)V", "params", "Landroid/view/View;", "b", "Landroid/view/View;", "()Landroid/view/View;", "j", "(Landroid/view/View;)V", "anchor", "Landroid/content/Context;", "c", "Landroid/content/Context;", "()Landroid/content/Context;", "k", "(Landroid/content/Context;)V", "context", "Landroidx/fragment/app/Fragment;", "d", "Landroidx/fragment/app/Fragment;", "e", "()Landroidx/fragment/app/Fragment;", DomainData.DOMAIN_NAME, "(Landroidx/fragment/app/Fragment;)V", "fragment", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "f", "()Landroidx/lifecycle/LifecycleOwner;", "o", "(Landroidx/lifecycle/LifecycleOwner;)V", "lifecycleOwner", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lw64/e;", "Lcom/tencent/mvi/mvvm/BaseVB;", tl.h.F, "()Lcom/tencent/mvi/mvvm/BaseVB;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Lcom/tencent/mvi/mvvm/BaseVB;)V", "rootVB", "Lcom/tencent/mvi/runtime/strategy/b;", "Lcom/tencent/mvi/runtime/strategy/b;", "i", "()Lcom/tencent/mvi/runtime/strategy/b;", "r", "(Lcom/tencent/mvi/runtime/strategy/b;)V", "strategyService", "Lml3/b;", "Lml3/b;", "()Lml3/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lml3/b;)V", "emitterService", "Lw64/d;", "Lw64/d;", "()Lw64/d;", "l", "(Lw64/d;)V", "dialogAdornApi", "Lw64/n;", "dialogFactory", "<init>", "(Lw64/n;)V", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class h<T extends j> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public T params;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public View anchor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public Context context;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public Fragment fragment;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public LifecycleOwner lifecycleOwner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public BaseVB<? extends ol3.b, ? extends MviUIState, e<T>> rootVB;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public com.tencent.mvi.runtime.strategy.b strategyService;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public ml3.b emitterService;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public d<T> dialogAdornApi;

    public h(@NotNull n<T> dialogFactory) {
        Intrinsics.checkNotNullParameter(dialogFactory, "dialogFactory");
        p(dialogFactory.a().a());
        f c16 = dialogFactory.c();
        j(c16.a());
        k(c16.buildContext());
        n(c16.b());
        o(c16.c());
        q(dialogFactory.e().a());
        r(dialogFactory.b().a());
        m(dialogFactory.d().a());
        l(dialogFactory.f());
    }

    @NotNull
    public final View a() {
        View view = this.anchor;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("anchor");
        return null;
    }

    @NotNull
    public final Context b() {
        Context context = this.context;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("context");
        return null;
    }

    @NotNull
    public final d<T> c() {
        d<T> dVar = this.dialogAdornApi;
        if (dVar != null) {
            return dVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dialogAdornApi");
        return null;
    }

    @NotNull
    public final ml3.b d() {
        ml3.b bVar = this.emitterService;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("emitterService");
        return null;
    }

    @NotNull
    public final Fragment e() {
        Fragment fragment = this.fragment;
        if (fragment != null) {
            return fragment;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fragment");
        return null;
    }

    @NotNull
    public final LifecycleOwner f() {
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner != null) {
            return lifecycleOwner;
        }
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
        return null;
    }

    @NotNull
    public final T g() {
        T t16 = this.params;
        if (t16 != null) {
            return t16;
        }
        Intrinsics.throwUninitializedPropertyAccessException("params");
        return null;
    }

    @NotNull
    public final BaseVB<? extends ol3.b, ? extends MviUIState, e<T>> h() {
        BaseVB<? extends ol3.b, ? extends MviUIState, e<T>> baseVB = this.rootVB;
        if (baseVB != null) {
            return baseVB;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rootVB");
        return null;
    }

    @NotNull
    public final com.tencent.mvi.runtime.strategy.b i() {
        com.tencent.mvi.runtime.strategy.b bVar = this.strategyService;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("strategyService");
        return null;
    }

    public final void j(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.anchor = view;
    }

    public final void k(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    public final void l(@NotNull d<T> dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<set-?>");
        this.dialogAdornApi = dVar;
    }

    public final void m(@NotNull ml3.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.emitterService = bVar;
    }

    public final void n(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<set-?>");
        this.fragment = fragment;
    }

    public final void o(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<set-?>");
        this.lifecycleOwner = lifecycleOwner;
    }

    public final void p(@NotNull T t16) {
        Intrinsics.checkNotNullParameter(t16, "<set-?>");
        this.params = t16;
    }

    public final void q(@NotNull BaseVB<? extends ol3.b, ? extends MviUIState, e<T>> baseVB) {
        Intrinsics.checkNotNullParameter(baseVB, "<set-?>");
        this.rootVB = baseVB;
    }

    public final void r(@NotNull com.tencent.mvi.runtime.strategy.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.strategyService = bVar;
    }
}
