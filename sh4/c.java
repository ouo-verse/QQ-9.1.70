package sh4;

import android.view.View;
import androidx.lifecycle.Observer;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\"\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u0004B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lsh4/c;", "T", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "Landroidx/lifecycle/Observer;", "view", "<init>", "(Landroid/view/View;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
abstract class c<T> extends WeakReference<View> implements Observer<T> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
    }
}
