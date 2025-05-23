package z72;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.preload.recyclerview.RFWAbsLoadMoreAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\bR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lz72/d;", "Lcom/tencent/biz/richframework/preload/recyclerview/RFWAbsLoadMoreAdapter;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateViewHolder", "", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "hide", "show", "Lz72/d$a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lz72/d$a;", "mViewHolder", "<init>", "()V", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d extends RFWAbsLoadMoreAdapter {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private a mViewHolder;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lz72/d$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ProgressBar;", "E", "Landroid/widget/ProgressBar;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/ProgressBar;", "mProgressbar", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "l", "()Landroid/widget/TextView;", "mProgressInfo", "Landroid/view/View;", "v", "<init>", "(Landroid/view/View;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final ProgressBar mProgressbar;

        /* renamed from: F, reason: from kotlin metadata */
        private final TextView mProgressInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View v3) {
            super(v3);
            Intrinsics.checkNotNullParameter(v3, "v");
            View findViewById = v3.findViewById(R.id.lz7);
            Intrinsics.checkNotNullExpressionValue(findViewById, "v.findViewById(com.tence\u2026mobileqq.R.id.pb_loading)");
            this.mProgressbar = (ProgressBar) findViewById;
            View findViewById2 = v3.findViewById(R.id.kbr);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "v.findViewById(com.tence\u2026bileqq.qqui.R.id.tv_tips)");
            this.mProgressInfo = (TextView) findViewById2;
        }

        /* renamed from: l, reason: from getter */
        public final TextView getMProgressInfo() {
            return this.mProgressInfo;
        }

        /* renamed from: m, reason: from getter */
        public final ProgressBar getMProgressbar() {
            return this.mProgressbar;
        }
    }

    public final void hide() {
        a aVar = this.mViewHolder;
        View view = aVar != null ? aVar.itemView : null;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.f169066hn3, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026ng_footer, parent, false)");
        a aVar = new a(inflate);
        this.mViewHolder = aVar;
        return aVar;
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
        TextView mProgressInfo;
        a aVar = this.mViewHolder;
        ProgressBar mProgressbar = aVar != null ? aVar.getMProgressbar() : null;
        if (mProgressbar != null) {
            mProgressbar.setVisibility(8);
        }
        if (hasMore) {
            a aVar2 = this.mViewHolder;
            mProgressInfo = aVar2 != null ? aVar2.getMProgressInfo() : null;
            if (mProgressInfo == null) {
                return;
            }
            mProgressInfo.setText("");
            return;
        }
        a aVar3 = this.mViewHolder;
        mProgressInfo = aVar3 != null ? aVar3.getMProgressInfo() : null;
        if (mProgressInfo == null) {
            return;
        }
        mProgressInfo.setText("\u5230\u5e95\u5566~");
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        a aVar = this.mViewHolder;
        ProgressBar mProgressbar = aVar != null ? aVar.getMProgressbar() : null;
        if (mProgressbar != null) {
            mProgressbar.setVisibility(0);
        }
        a aVar2 = this.mViewHolder;
        TextView mProgressInfo = aVar2 != null ? aVar2.getMProgressInfo() : null;
        if (mProgressInfo == null) {
            return;
        }
        mProgressInfo.setText("\u6b63\u5728\u52a0\u8f7d\u66f4\u591a");
    }

    public final void show() {
        a aVar = this.mViewHolder;
        View view = aVar != null ? aVar.itemView : null;
        if (view == null) {
            return;
        }
        view.setVisibility(0);
    }
}
