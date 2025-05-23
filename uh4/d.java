package uh4;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0002H&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016\u00a8\u0006\u0012"}, d2 = {"Luh4/d;", "", "", "onShow", "onHide", "b", "e", "onBackground", "d", "Landroid/view/View;", "getView", "Luh4/c;", "f", "Luh4/b;", "a", "Ljava/lang/Object;", "obj", "setLaunchParam", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public interface d {
    @NotNull
    b a();

    void b();

    void d();

    void e();

    @NotNull
    c f();

    @NotNull
    View getView();

    void onBackground();

    void onHide();

    void onShow();

    void setLaunchParam(@Nullable Object obj);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes26.dex */
    public static final class a {
        @NotNull
        public static b a(@NotNull d dVar) {
            return new b();
        }

        public static void b(@NotNull d dVar, @Nullable Object obj) {
        }
    }
}
