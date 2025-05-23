package wj1;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareListAdapter;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u00002\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0001\u001a\u0016\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "adapter", "Lkotlin/Pair;", "", "a", "b", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d {
    @NotNull
    public static final Pair<Integer, Integer> a(@NotNull RFWConcatAdapter rFWConcatAdapter, @NotNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter) {
        Intrinsics.checkNotNullParameter(rFWConcatAdapter, "<this>");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> adapters = rFWConcatAdapter.getAdapters();
        Intrinsics.checkNotNullExpressionValue(adapters, "adapters");
        Iterator<T> it = adapters.iterator();
        int i3 = 0;
        int i16 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            RecyclerView.Adapter adapter2 = (RecyclerView.Adapter) it.next();
            if (!Intrinsics.areEqual(adapter2, adapter)) {
                i16 += adapter2.getItemCount();
            } else {
                i3 = i16 + adapter2.getItemCount();
                break;
            }
        }
        return TuplesKt.to(Integer.valueOf(i16), Integer.valueOf(i3));
    }

    @NotNull
    public static final Pair<Integer, Integer> b(@NotNull RFWConcatAdapter rFWConcatAdapter) {
        Intrinsics.checkNotNullParameter(rFWConcatAdapter, "<this>");
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> adapters = rFWConcatAdapter.getAdapters();
        Intrinsics.checkNotNullExpressionValue(adapters, "adapters");
        Iterator<T> it = adapters.iterator();
        while (it.hasNext()) {
            RecyclerView.Adapter adapter = (RecyclerView.Adapter) it.next();
            if (adapter instanceof GuildFeedSquareListAdapter) {
                return a(rFWConcatAdapter, adapter);
            }
        }
        return TuplesKt.to(0, 0);
    }
}
