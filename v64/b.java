package v64;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&J5\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH&\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000bJ\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000bJ\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000bH\u0016\u00a8\u0006\u0019"}, d2 = {"Lv64/b;", "T", "", "items", "", "position", "", "a", "(Ljava/lang/Object;I)Z", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "c", "holder", "", "payloads", "", "b", "(Ljava/lang/Object;ILandroidx/recyclerview/widget/RecyclerView$ViewHolder;Ljava/util/List;)V", "g", "d", "e", "f", "<init>", "()V", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class b<T> {
    public abstract boolean a(T items, int position);

    public abstract void b(T items, int position, @NotNull RecyclerView.ViewHolder holder, @NotNull List<? extends Object> payloads);

    @NotNull
    public abstract RecyclerView.ViewHolder c(@NotNull ViewGroup parent);

    public final boolean d(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        return false;
    }

    public void e(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    public void f(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    public final void g(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }
}
