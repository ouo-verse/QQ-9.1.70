package un1;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.feedsquare.adapter.j;
import com.tencent.qqmini.sdk.widget.ToastView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import vn1.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0015\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0010\u001a\u00060\rj\u0002`\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\b\u0010\u0013\u00a8\u0006\u001b"}, d2 = {"Lun1/c;", "", "", ToastView.ICON_LOADING, "hasMore", "", "c", "Lun1/a;", "a", "Lun1/a;", "b", "()Lun1/a;", "mFeedsAdapter", "Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/j;", "Lcom/tencent/mobileqq/guild/feed/topic/adapter/TopicListLoadMoreAdapter;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/j;", "mLoadAdapter", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "()Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;", "", "Lvn1/a;", "feedsManager", "<init>", "(Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mFeedsAdapter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final j mLoadAdapter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RFWConcatAdapter concatAdapter;

    public c(@NotNull AdapterDelegatesManager<List<vn1.a>> feedsManager) {
        Intrinsics.checkNotNullParameter(feedsManager, "feedsManager");
        a aVar = new a(feedsManager);
        aVar.setHasStableIds(true);
        this.mFeedsAdapter = aVar;
        j jVar = new j(e.a(), R.string.f144670pe, 0, 4, null);
        jVar.setHasStableIds(true);
        this.mLoadAdapter = jVar;
        RFWConcatAdapter.Config.Builder builder = new RFWConcatAdapter.Config.Builder();
        builder.setIsolateViewTypes(false);
        builder.setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS);
        this.concatAdapter = new RFWConcatAdapter(builder.build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{aVar, jVar});
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final RFWConcatAdapter getConcatAdapter() {
        return this.concatAdapter;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final a getMFeedsAdapter() {
        return this.mFeedsAdapter;
    }

    public final void c(boolean loading, boolean hasMore) {
        this.mLoadAdapter.setLoadState(loading, hasMore);
        this.mLoadAdapter.onLoadMoreEnd(hasMore);
    }
}
