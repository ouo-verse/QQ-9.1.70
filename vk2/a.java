package vk2;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002R$\u0010\t\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\b\u00a8\u0006\f"}, d2 = {"Lvk2/a;", "", "Lkotlin/Function0;", "", "listener", "b", "a", "Lmqq/util/WeakReference;", "Lmqq/util/WeakReference;", "changeListener", "<init>", "()V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f441761a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WeakReference<Function0<Unit>> changeListener;

    a() {
    }

    @Nullable
    public final Function0<Unit> a() {
        WeakReference<Function0<Unit>> weakReference = changeListener;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final void b(@NotNull Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        changeListener = new WeakReference<>(listener);
    }
}
