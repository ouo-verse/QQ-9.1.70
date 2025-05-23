package xk1;

import android.content.Context;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.InputAnimationControllerImpl;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&J\u0014\u0010\n\u001a\u00020\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\bH&J\b\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH&J\b\u0010\u0011\u001a\u00020\u0010H&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&R\u0014\u0010\u0016\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0017"}, d2 = {"Lxk1/e;", "", "Landroid/content/Context;", "context", "Lxk1/f;", "b", "", "c", "Lxk1/d;", "inputWindow", "d", "", "onRenderFirstFrame", "", "hideIntent", "f", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$c;", "a", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/InputAnimationControllerImpl$b;", "e", "g", "()I", "windowSoftInputMode", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface e {
    @NotNull
    e.c a();

    @NotNull
    f b(@NotNull Context context);

    void c();

    void d(@NotNull d<?> inputWindow);

    @Nullable
    InputAnimationControllerImpl.b e();

    void f(int hideIntent);

    int g();

    boolean onRenderFirstFrame();
}
