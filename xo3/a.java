package xo3;

import com.tencent.ntcompose.lifecycle.viewmodel.g;
import com.tencent.ntcompose.lifecycle.viewmodel.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ/\u0010\b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lxo3/a;", "Lcom/tencent/ntcompose/lifecycle/viewmodel/i$b;", "Lcom/tencent/ntcompose/lifecycle/viewmodel/g;", "T", "Lkotlin/reflect/KClass;", "modelClass", "Lcom/tencent/ntcompose/lifecycle/viewmodel/b;", "extras", "a", "(Lkotlin/reflect/KClass;Lcom/tencent/ntcompose/lifecycle/viewmodel/b;)Lcom/tencent/ntcompose/lifecycle/viewmodel/g;", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a implements i.b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f448236a = new a();

    a() {
    }

    @Override // com.tencent.ntcompose.lifecycle.viewmodel.i.b
    public <T extends g> T a(KClass<T> modelClass, com.tencent.ntcompose.lifecycle.viewmodel.b extras) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(extras, "extras");
        return (T) d.f448243a.d();
    }
}
