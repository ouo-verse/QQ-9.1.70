package w64;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import w64.j;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007\u00a2\u0006\u0004\b,\u0010-J\u000f\u0010\u0004\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\"\u0010\u0013\u001a\u00028\u00008\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0005\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0019\u001a\u00020\u00068\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001f\u001a\u00020\b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010%\u001a\u00020\n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010+\u001a\u00020\f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000b\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lw64/g;", "Lw64/j;", "T", "Lw64/e;", "f", "()Lw64/j;", "Landroidx/fragment/app/Fragment;", "c", "Landroidx/lifecycle/LifecycleOwner;", "d", "Lcom/tencent/mvi/base/route/j;", "e", "Lml3/b;", "b", "a", "Lw64/j;", "k", "p", "(Lw64/j;)V", "mParams", "Landroidx/fragment/app/Fragment;", tl.h.F, "()Landroidx/fragment/app/Fragment;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Landroidx/fragment/app/Fragment;)V", "mFragment", "Landroidx/lifecycle/LifecycleOwner;", "i", "()Landroidx/lifecycle/LifecycleOwner;", DomainData.DOMAIN_NAME, "(Landroidx/lifecycle/LifecycleOwner;)V", "mLifecycleOwner", "Lcom/tencent/mvi/base/route/j;", "j", "()Lcom/tencent/mvi/base/route/j;", "o", "(Lcom/tencent/mvi/base/route/j;)V", "mMessenger", "Lml3/b;", "g", "()Lml3/b;", "l", "(Lml3/b;)V", "mEmitter", "<init>", "()V", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class g<T extends j> extends e<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public T mParams;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public Fragment mFragment;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public LifecycleOwner mLifecycleOwner;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public com.tencent.mvi.base.route.j mMessenger;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public ml3.b mEmitter;

    @Override // com.tencent.mvi.api.runtime.b
    @NotNull
    public ml3.b b() {
        return g();
    }

    @Override // com.tencent.mvi.api.runtime.b
    @NotNull
    public Fragment c() {
        return h();
    }

    @Override // com.tencent.mvi.api.runtime.b
    @NotNull
    public LifecycleOwner d() {
        return i();
    }

    @Override // com.tencent.mvi.api.runtime.b
    @NotNull
    public com.tencent.mvi.base.route.j e() {
        return j();
    }

    @Override // w64.e
    @NotNull
    public T f() {
        return k();
    }

    @NotNull
    public final ml3.b g() {
        ml3.b bVar = this.mEmitter;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mEmitter");
        return null;
    }

    @NotNull
    public final Fragment h() {
        Fragment fragment = this.mFragment;
        if (fragment != null) {
            return fragment;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mFragment");
        return null;
    }

    @NotNull
    public final LifecycleOwner i() {
        LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
        if (lifecycleOwner != null) {
            return lifecycleOwner;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mLifecycleOwner");
        return null;
    }

    @NotNull
    public final com.tencent.mvi.base.route.j j() {
        com.tencent.mvi.base.route.j jVar = this.mMessenger;
        if (jVar != null) {
            return jVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mMessenger");
        return null;
    }

    @NotNull
    public final T k() {
        T t16 = this.mParams;
        if (t16 != null) {
            return t16;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mParams");
        return null;
    }

    public final void l(@NotNull ml3.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mEmitter = bVar;
    }

    public final void m(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<set-?>");
        this.mFragment = fragment;
    }

    public final void n(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<set-?>");
        this.mLifecycleOwner = lifecycleOwner;
    }

    public final void o(@NotNull com.tencent.mvi.base.route.j jVar) {
        Intrinsics.checkNotNullParameter(jVar, "<set-?>");
        this.mMessenger = jVar;
    }

    public final void p(@NotNull T t16) {
        Intrinsics.checkNotNullParameter(t16, "<set-?>");
        this.mParams = t16;
    }
}
