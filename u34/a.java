package u34;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.preload.recyclerview.RFWAbsLoadMoreAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.util.LoadingUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000  2\u00020\u0001:\u0002!\"B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0016J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J \u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\tH\u0014J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006#"}, d2 = {"Lu34/a;", "Lcom/tencent/biz/richframework/preload/recyclerview/RFWAbsLoadMoreAdapter;", "", "j0", "", "hasMore", "i0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateViewHolder", "onLoadMoreStart", "onLoadMoreEnd", "position", "getItemViewType", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAdapterDestroyed", "dx", "dy", "orientation", "startLoadMore", "isLoading", "setLoadState", "Lu34/a$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lu34/a$b;", "mViewHolder", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a extends RFWAbsLoadMoreAdapter {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b mViewHolder;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lu34/a$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/ImageView;", "mProgressbar", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "l", "()Landroid/widget/TextView;", "mProgressInfo", "Landroid/view/View;", "v", "<init>", "(Landroid/view/View;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final ImageView mProgressbar;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final TextView mProgressInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View v3) {
            super(v3);
            Intrinsics.checkNotNullParameter(v3, "v");
            View findViewById = v3.findViewById(R.id.ysu);
            Intrinsics.checkNotNullExpressionValue(findViewById, "v.findViewById(R.id.loading_icon)");
            ImageView imageView = (ImageView) findViewById;
            this.mProgressbar = imageView;
            View findViewById2 = v3.findViewById(R.id.yt9);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "v.findViewById(R.id.loading_tip)");
            this.mProgressInfo = (TextView) findViewById2;
            imageView.setImageDrawable(LoadingUtil.getLoadingDrawable(v3.getContext(), 2));
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final TextView getMProgressInfo() {
            return this.mProgressInfo;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final ImageView getMProgressbar() {
            return this.mProgressbar;
        }
    }

    private final void i0(boolean hasMore) {
        String string;
        b bVar = this.mViewHolder;
        if (bVar != null) {
            bVar.itemView.setVisibility(0);
            bVar.getMProgressbar().setVisibility(8);
            TextView mProgressInfo = bVar.getMProgressInfo();
            if (hasMore) {
                string = bVar.itemView.getContext().getString(R.string.f1628021e);
            } else {
                string = bVar.itemView.getContext().getString(R.string.f1628221g);
            }
            mProgressInfo.setText(string);
        }
    }

    private final void j0() {
        b bVar = this.mViewHolder;
        if (bVar != null) {
            bVar.itemView.setVisibility(0);
            bVar.getMProgressbar().setVisibility(0);
            bVar.getMProgressInfo().setText(bVar.itemView.getContext().getString(R.string.f1628121f));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return Integer.MAX_VALUE;
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.RFWAbsLoadMoreAdapter, com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter
    public void onAdapterDestroyed(@Nullable RecyclerView recyclerView) {
        if (recyclerView == null) {
            return;
        }
        super.onAdapterDestroyed(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.hmv, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026      false\n            )");
        b bVar = new b(inflate);
        this.mViewHolder = bVar;
        View view = bVar.itemView;
        if (view != null) {
            view.setVisibility(8);
        }
        b bVar2 = this.mViewHolder;
        Intrinsics.checkNotNull(bVar2);
        return bVar2;
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
        i0(hasMore);
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        j0();
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.RFWAbsLoadMoreAdapter
    public void setLoadState(boolean isLoading, boolean hasMore) {
        super.setLoadState(isLoading, hasMore);
        if (isLoading) {
            j0();
        } else {
            i0(hasMore);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.preload.recyclerview.RFWAbsLoadMoreAdapter
    public void startLoadMore(int dx5, int dy5, int orientation) {
        if (this.mRecyclerView == null) {
            return;
        }
        super.startLoadMore(dx5, dy5, orientation);
    }
}
