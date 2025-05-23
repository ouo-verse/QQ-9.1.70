package rz1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b&\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0000H\u0016\u00a8\u0006\t"}, d2 = {"Lrz1/b;", "", "newItem", "", "b", "a", "c", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class b {
    public boolean a(@NotNull b newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (getClass().isInstance(newItem) && Intrinsics.areEqual(this, newItem)) {
            return true;
        }
        return false;
    }

    public boolean b(@NotNull b newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return getClass().isInstance(newItem);
    }

    @Nullable
    public Object c(@NotNull b newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return null;
    }
}
