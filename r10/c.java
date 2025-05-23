package r10;

import UserGrowth.stSimpleMetaComment;
import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.widget.pull2refresh.BaseAdapter;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001B#\u0012\u0006\u0010!\u001a\u00020 \u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u001e\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006&"}, d2 = {"Lr10/c;", "Lcom/tencent/widget/pull2refresh/BaseAdapter;", "LUserGrowth/stSimpleMetaComment;", "Lcom/tencent/widget/pull2refresh/BaseViewHolder;", "", "position", "getCustomItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateCustomViewHolder", "holder", "", "onBindCustomViewHolder", "data", "p", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "d", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "getMFragment", "()Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "setMFragment", "(Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;)V", "mFragment", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "e", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "getMVerticalData", "()Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "setMVerticalData", "(Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;)V", "mVerticalData", "Landroid/content/Context;", "context", "fragment", "verticalData", "<init>", "(Landroid/content/Context;Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c extends BaseAdapter<stSimpleMetaComment, BaseViewHolder<stSimpleMetaComment>> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private WSVerticalPageFragment mFragment;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private j mVerticalData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, WSVerticalPageFragment wSVerticalPageFragment, j jVar) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mFragment = wSVerticalPageFragment;
        this.mVerticalData = jVar;
    }

    @Override // com.tencent.widget.pull2refresh.BaseAdapter
    public int getCustomItemViewType(int position) {
        return 0;
    }

    @Override // com.tencent.widget.pull2refresh.HeaderAndFooterAdapter
    public void onBindCustomViewHolder(BaseViewHolder<stSimpleMetaComment> holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bindData(getDataList().get(position));
    }

    @Override // com.tencent.widget.pull2refresh.HeaderAndFooterAdapter
    public BaseViewHolder<stSimpleMetaComment> onCreateCustomViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new f(parent, this.mFragment, this.mVerticalData);
    }

    public final void p(stSimpleMetaComment data) {
        Intrinsics.checkNotNullParameter(data, "data");
        getDataList().add(data);
        notifyItemInserted(getItemCount());
    }
}
