package v64;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00028\u0001*\u0004\b\u0001\u0010\u0002*\b\b\u0002\u0010\u0004*\u00020\u00032\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00060\u0005B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001e\u0010\u000b\u001a\u00020\n2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J4\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0006H\u0016J-\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00028\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\u0006\u0010\t\u001a\u00020\bH&\u00a2\u0006\u0004\b\u0012\u0010\u0013J5\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u00022\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0006H&\u00a2\u0006\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lv64/a;", "I", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Lv64/b;", "", "items", "", "position", "", "i", "holder", "", "payloads", "", "k", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, h.F, "(Ljava/lang/Object;Ljava/util/List;I)Z", "j", "(Ljava/lang/Object;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILjava/util/List;)V", "<init>", "()V", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class a<I extends T, T, VH extends RecyclerView.ViewHolder> extends b<List<? extends T>> {
    public abstract boolean h(T item, @NotNull List<? extends T> items, int position);

    @Override // v64.b
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean a(@NotNull List<? extends T> items, int position) {
        Intrinsics.checkNotNullParameter(items, "items");
        return h(items.get(position), items, position);
    }

    public abstract void j(I item, @NotNull VH holder, int position, @NotNull List<? extends Object> payloads);

    @Override // v64.b
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull List<? extends T> items, int position, @NotNull RecyclerView.ViewHolder holder, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        j(items.get(position), holder, position, payloads);
    }
}
