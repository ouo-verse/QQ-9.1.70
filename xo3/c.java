package xo3;

import com.tencent.ntcompose.lifecycle.viewmodel.b;
import com.tencent.ntcompose.lifecycle.viewmodel.f;
import com.tencent.ntcompose.lifecycle.viewmodel.g;
import com.tencent.ntcompose.lifecycle.viewmodel.i;
import com.tencent.ntcompose.lifecycle.viewmodel.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import xo3.d;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0015\u0010\u0016J1\u0010\b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lxo3/c;", "", "Lcom/tencent/ntcompose/lifecycle/viewmodel/g;", "T", "Lkotlin/reflect/KClass;", "modelClass", "", "key", "a", "(Lkotlin/reflect/KClass;Ljava/lang/String;)Lcom/tencent/ntcompose/lifecycle/viewmodel/g;", "Lcom/tencent/ntcompose/lifecycle/viewmodel/j;", "Lcom/tencent/ntcompose/lifecycle/viewmodel/j;", "store", "Lcom/tencent/ntcompose/lifecycle/viewmodel/i$b;", "b", "Lcom/tencent/ntcompose/lifecycle/viewmodel/i$b;", "factory", "Lcom/tencent/ntcompose/lifecycle/viewmodel/b;", "c", "Lcom/tencent/ntcompose/lifecycle/viewmodel/b;", "extras", "<init>", "(Lcom/tencent/ntcompose/lifecycle/viewmodel/j;Lcom/tencent/ntcompose/lifecycle/viewmodel/i$b;Lcom/tencent/ntcompose/lifecycle/viewmodel/b;)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final j store;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final i.b factory;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.ntcompose.lifecycle.viewmodel.b extras;

    public c(j store, i.b factory, com.tencent.ntcompose.lifecycle.viewmodel.b extras) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(extras, "extras");
        this.store = store;
        this.factory = factory;
        this.extras = extras;
    }

    public final <T extends g> T a(KClass<T> modelClass, String key) {
        T t16;
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(key, "key");
        T t17 = (T) this.store.b(key);
        if (modelClass.isInstance(t17)) {
            Intrinsics.checkNotNull(t17, "null cannot be cast to non-null type T of com.tencent.ntcompose.lifecycle.viewmodel.internal.ViewModelProviderImpl.getViewModel");
            return t17;
        }
        f fVar = new f(this.extras);
        fVar.b(d.a.f448244a, key);
        try {
            t16 = (T) this.factory.a(modelClass, fVar);
        } catch (Error unused) {
            t16 = (T) this.factory.a(modelClass, b.a.f339329b);
        }
        this.store.c(key, t16);
        return t16;
    }

    public static /* synthetic */ g b(c cVar, KClass kClass, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = d.f448243a.c(kClass);
        }
        return cVar.a(kClass, str);
    }
}
