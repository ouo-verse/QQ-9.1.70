package xy;

import UserGrowth.stNotifyMsg;
import android.content.Context;
import android.view.ViewGroup;
import bz.j;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.widget.pull2refresh.BaseAdapter;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u001e\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0016\u0010\u0011\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u0018"}, d2 = {"Lxy/a;", "Lcom/tencent/widget/pull2refresh/BaseAdapter;", "Lyy/c;", "Lcom/tencent/widget/pull2refresh/BaseViewHolder;", "data", "", "p", "", "position", "getCustomItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateCustomViewHolder", "holder", "", "onBindCustomViewHolder", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "getItemId", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a extends BaseAdapter<yy.c, BaseViewHolder<yy.c>> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.widget.pull2refresh.BaseAdapter
    public int getCustomItemViewType(int position) {
        return getDataList().get(position).g();
    }

    @Override // com.tencent.widget.pull2refresh.BaseAdapter, com.tencent.widget.pull2refresh.HeaderAndFooterAdapter, android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // com.tencent.widget.pull2refresh.HeaderAndFooterAdapter
    public void onBindCustomViewHolder(BaseViewHolder<yy.c> holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bindData(getDataList().get(position));
    }

    @Override // com.tencent.widget.pull2refresh.HeaderAndFooterAdapter
    public BaseViewHolder<yy.c> onCreateCustomViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return j.f29427a.a(parent, viewType);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(BaseViewHolder<yy.c> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        yy.c item = getItem(holder.getAdapterPosition());
        if (p(item)) {
            String e16 = item.e();
            Intrinsics.checkNotNullExpressionValue(e16, "data.sopName");
            stNotifyMsg a16 = item.a();
            String str = a16 != null ? a16.msgID : null;
            if (str == null) {
                str = "";
            }
            b.e(e16, str, String.valueOf(item.f()));
        }
    }

    private final boolean p(yy.c data) {
        return (data == null || data.g() == -2 || data.g() == -1) ? false : true;
    }
}
