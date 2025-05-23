package tk0;

import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u00a8\u0006\t"}, d2 = {"Ltk0/c;", "", "Lkotlin/reflect/KClass;", "Ltk0/b;", "source", "", "a", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f436439a = new c();

    c() {
    }

    @NotNull
    public final String a(@NotNull KClass<? extends b> source) {
        Intrinsics.checkNotNullParameter(source, "source");
        String canonicalName = JvmClassMappingKt.getJavaClass((KClass) source).getCanonicalName();
        Intrinsics.checkNotNull(canonicalName);
        return canonicalName;
    }
}
