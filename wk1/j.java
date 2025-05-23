package wk1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0016J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0016\u00a8\u0006\b"}, d2 = {"Lwk1/j;", "", "", "action", "msg", "", "c", "d", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface j {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a {
        public static void a(@NotNull j jVar, @NotNull String action, @Nullable Object obj) {
            Intrinsics.checkNotNullParameter(action, "action");
        }

        @Nullable
        public static Object b(@NotNull j jVar, @NotNull String action, @Nullable Object obj) {
            Intrinsics.checkNotNullParameter(action, "action");
            return null;
        }
    }

    void c(@NotNull String action, @Nullable Object msg2);

    @Nullable
    Object d(@NotNull String action, @Nullable Object msg2);
}
