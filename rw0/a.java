package rw0;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.ManagementHistoryView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.widget.pull2refresh.BaseAdapter;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010\t\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u001c\u0010\r\u001a\u00020\f2\n\u0010\n\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\u0014"}, d2 = {"Lrw0/a;", "Lcom/tencent/widget/pull2refresh/BaseAdapter;", "Lsw0/a;", "Lrw0/a$a;", "", "getItemCount", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "holder", "position", "", "p", "getCustomItemViewType", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class a extends BaseAdapter<sw0.a, C11164a> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lrw0/a$a;", "Lcom/tencent/widget/pull2refresh/BaseViewHolder;", "Lsw0/a;", "data", "", "b", "Landroid/view/ViewGroup;", "view", "<init>", "(Lrw0/a;Landroid/view/ViewGroup;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: rw0.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public final class C11164a extends BaseViewHolder<sw0.a> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f432589d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11164a(@NotNull a aVar, ViewGroup view) {
            super(view, R.layout.fbl);
            Intrinsics.checkNotNullParameter(view, "view");
            this.f432589d = aVar;
        }

        @Override // com.tencent.widget.pull2refresh.BaseViewHolder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void bindData(@NotNull sw0.a data) {
            Intrinsics.checkNotNullParameter(data, "data");
            View findViewById = this.itemView.findViewById(R.id.f165695xa1);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById<Ma\u2026ryView>(R.id.historyView)");
            ((ManagementHistoryView) findViewById).setData(data);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.widget.pull2refresh.BaseAdapter
    public int getCustomItemViewType(int position) {
        return 0;
    }

    @Override // com.tencent.widget.pull2refresh.BaseAdapter, android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getDataList().size();
    }

    @Override // com.tencent.widget.pull2refresh.HeaderAndFooterAdapter
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onBindCustomViewHolder(@NotNull C11164a holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        sw0.a aVar = getDataList().get(position);
        Intrinsics.checkNotNullExpressionValue(aVar, "dataList[position]");
        holder.bindData(aVar);
    }

    @Override // com.tencent.widget.pull2refresh.HeaderAndFooterAdapter
    @NotNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public C11164a onCreateCustomViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new C11164a(this, parent);
    }
}
