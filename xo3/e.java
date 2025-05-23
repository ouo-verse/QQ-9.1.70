package xo3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\"*\u0010\u0006\u001a\u0004\u0018\u00010\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00028@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0007"}, d2 = {"", "T", "Lkotlin/reflect/KClass;", "", "a", "(Lkotlin/reflect/KClass;)Ljava/lang/String;", "canonicalName", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e {
    public static final <T> String a(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        return kClass.getQualifiedName();
    }
}
