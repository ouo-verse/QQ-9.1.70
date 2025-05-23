package sh4;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lsh4/b;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/LifecycleRegistry;", "getLifecycle", "d", "Landroidx/lifecycle/LifecycleRegistry;", "a", "()Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
final class b implements LifecycleOwner {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    @NotNull
    /* renamed from: a, reason: from getter */
    public final LifecycleRegistry getLifecycleRegistry() {
        return this.lifecycleRegistry;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NotNull
    public LifecycleRegistry getLifecycle() {
        return this.lifecycleRegistry;
    }
}
