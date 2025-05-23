package uk0;

import android.view.Surface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Luk0/d;", "", "Landroid/view/Surface;", "surface", "", "width", "height", "", "a", "onSurfaceChanged", "b", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public interface d {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class a {
        public static void a(@NotNull d dVar, @NotNull Surface surface) {
            Intrinsics.checkNotNullParameter(surface, "surface");
        }

        public static void b(@NotNull d dVar, @NotNull Surface surface) {
            Intrinsics.checkNotNullParameter(surface, "surface");
        }
    }

    void a(@NotNull Surface surface, int width, int height);

    void b(@NotNull Surface surface);

    void onSurfaceChanged(@NotNull Surface surface);
}
