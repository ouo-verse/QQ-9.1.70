package yi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016R\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lyi/k;", "Lxi/c;", "Lcom/qzone/reborn/groupalbum/selectmedia/adapter/a;", "holder", "", "i", tl.h.F, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "c", "helper", "Lwi/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "o", "", "Ljava/lang/String;", "curPageId", "", "f", "()I", "itemViewType", "<init>", "()V", "d", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class k extends xi.c {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String curPageId = "";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(k this$0, View view) {
        View.OnClickListener loadMoreAction;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        xi.b m3 = this$0.m();
        if (m3 == null || (loadMoreAction = m3.getLoadMoreAction()) == null) {
            return;
        }
        loadMoreAction.onClick(view);
    }

    @Override // xi.a
    public View c(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.f127831q, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026ter_load_more_item, null)");
        return inflate;
    }

    @Override // xi.a
    public int f() {
        return 10;
    }

    @Override // xi.a
    public void h(com.qzone.reborn.groupalbum.selectmedia.adapter.a holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    @Override // xi.a
    public void i(com.qzone.reborn.groupalbum.selectmedia.adapter.a holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    @Override // xi.a
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void a(com.qzone.reborn.groupalbum.selectmedia.adapter.a helper, wi.b item) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(item, "item");
        QUIButton qUIButton = (QUIButton) helper.itemView.findViewById(R.id.mgo);
        if (qUIButton != null) {
            qUIButton.setOnClickListener(new View.OnClickListener() { // from class: yi.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    k.p(k.this, view);
                }
            });
        }
        ViewGroup.LayoutParams layoutParams = helper.itemView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        View view = helper.itemView;
        layoutParams.width = -1;
        view.setLayoutParams(layoutParams);
    }
}
