package yi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lyi/d;", "Lxi/c;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "c", "Lcom/qzone/reborn/groupalbum/selectmedia/adapter/a;", "helper", "Lwi/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "o", "", "f", "()I", "itemViewType", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d extends xi.c {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(d this$0, com.qzone.reborn.groupalbum.selectmedia.adapter.a helper, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(helper, "$helper");
        xi.b m3 = this$0.m();
        if (m3 != null) {
            xi.b.I0(m3, helper.getAdapterPosition(), false, false, null, 14, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // xi.a
    public View c(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.f127841r, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026_adapter_time_item, null)");
        return inflate;
    }

    @Override // xi.a
    public int f() {
        return 0;
    }

    @Override // xi.a
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void a(final com.qzone.reborn.groupalbum.selectmedia.adapter.a helper, wi.b item) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(item, "item");
        zi.a aVar = (zi.a) item;
        helper.itemView.setOnClickListener(new View.OnClickListener() { // from class: yi.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.p(d.this, helper, view);
            }
        });
        ((CheckBox) helper.getView(R.id.l2q)).setChecked(aVar.getIsExpanded());
        helper.l(R.id.ngt, zi.c.a(aVar));
    }
}
