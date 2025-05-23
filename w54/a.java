package w54;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import w64.e;
import w64.j;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00028\u0001*\u0004\b\u0001\u0010\u0002*\b\b\u0002\u0010\u0004*\u00020\u0003*\b\b\u0003\u0010\u0006*\u00020\u00052\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0007B\u0015\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00030\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00030\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lw54/a;", "I", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Lw64/j;", "D", "Lv64/a;", "Lw64/e;", "d", "Lw64/e;", "l", "()Lw64/e;", "mDialogContext", "<init>", "(Lw64/e;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class a<I extends T, T, VH extends RecyclerView.ViewHolder, D extends j> extends v64.a<I, T, VH> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e<D> mDialogContext;

    public a(@NotNull e<D> mDialogContext) {
        Intrinsics.checkNotNullParameter(mDialogContext, "mDialogContext");
        this.mDialogContext = mDialogContext;
    }

    @NotNull
    public final e<D> l() {
        return this.mDialogContext;
    }
}
