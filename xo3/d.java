package xo3;

import com.tencent.ntcompose.lifecycle.viewmodel.b;
import com.tencent.ntcompose.lifecycle.viewmodel.g;
import com.tencent.ntcompose.lifecycle.viewmodel.h;
import com.tencent.ntcompose.lifecycle.viewmodel.i;
import java.util.Arrays;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u0007\u001a\u00020\u0006\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00028\u0000\"\b\b\u0000\u0010\t*\u00020\u0002H\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0010\u001a\u00020\u000f2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\fH\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011JK\u0010\u0015\u001a\u00028\u0000\"\b\b\u0000\u0010\t*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u001a\u0010\u000e\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\r0\u0014\"\u0006\u0012\u0002\b\u00030\rH\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lxo3/d;", "", "Lcom/tencent/ntcompose/lifecycle/viewmodel/g;", "T", "Lkotlin/reflect/KClass;", "modelClass", "", "c", "(Lkotlin/reflect/KClass;)Ljava/lang/String;", "VM", "d", "()Lcom/tencent/ntcompose/lifecycle/viewmodel/g;", "", "Lcom/tencent/ntcompose/lifecycle/viewmodel/h;", "initializers", "Lcom/tencent/ntcompose/lifecycle/viewmodel/i$b;", "a", "(Ljava/util/Collection;)Lcom/tencent/ntcompose/lifecycle/viewmodel/i$b;", "Lcom/tencent/ntcompose/lifecycle/viewmodel/b;", "extras", "", "b", "(Lkotlin/reflect/KClass;Lcom/tencent/ntcompose/lifecycle/viewmodel/b;[Lcom/tencent/ntcompose/lifecycle/viewmodel/h;)Lcom/tencent/ntcompose/lifecycle/viewmodel/g;", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f448243a = new d();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c0\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lxo3/d$a;", "Lcom/tencent/ntcompose/lifecycle/viewmodel/b$b;", "", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class a implements b.InterfaceC9259b<String> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f448244a = new a();

        a() {
        }
    }

    d() {
    }

    public final i.b a(Collection<? extends h<?>> initializers) {
        Intrinsics.checkNotNullParameter(initializers, "initializers");
        Object[] array = initializers.toArray(new h[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        h[] hVarArr = (h[]) array;
        return new com.tencent.ntcompose.lifecycle.viewmodel.d((h[]) Arrays.copyOf(hVarArr, hVarArr.length));
    }

    public final <VM extends g> VM b(KClass<VM> modelClass, com.tencent.ntcompose.lifecycle.viewmodel.b extras, h<?>... initializers) {
        VM vm5;
        h<?> hVar;
        Function1<com.tencent.ntcompose.lifecycle.viewmodel.b, ?> b16;
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(initializers, "initializers");
        int length = initializers.length;
        int i3 = 0;
        while (true) {
            vm5 = null;
            if (i3 >= length) {
                hVar = null;
                break;
            }
            hVar = initializers[i3];
            if (Intrinsics.areEqual(hVar.a(), modelClass)) {
                break;
            }
            i3++;
        }
        if (hVar != null && (b16 = hVar.b()) != null) {
            vm5 = (VM) b16.invoke(extras);
        }
        if (vm5 != null) {
            return vm5;
        }
        throw new IllegalArgumentException(("No initializer set for given class " + e.a(modelClass)).toString());
    }

    public final <T extends g> String c(KClass<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        String a16 = e.a(modelClass);
        if (a16 != null) {
            return "com.tencent.ntcompose.lifecycle.ViewModelProvider.DefaultKey:" + a16;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels".toString());
    }

    public final <VM extends g> VM d() {
        throw new UnsupportedOperationException("`Factory.create(String, CreationExtras)` is not implemented. You may need to override the method and provide a custom implementation. Note that using `Factory.create(String)` is not supported and considered an error.");
    }
}
