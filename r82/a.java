package r82;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.guild.component.banner.DownToUpViewSwitcher;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0007J\u001c\u0010\f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u00020\u00062\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016R\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lr82/a;", "Lcom/tencent/mobileqq/guild/component/banner/DownToUpViewSwitcher$d;", "Lr82/a$a;", "", "", "tipsList", "", "setData", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "k0", "viewHolder", "index", "j0", "getItemCount", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "dataList", "<init>", "()V", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a extends DownToUpViewSwitcher.d<C11122a> {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<String> dataList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lr82/a$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "l", "()Landroid/widget/TextView;", "text", "Landroid/view/View;", "view", "<init>", "(Lr82/a;Landroid/view/View;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: r82.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public final class C11122a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final TextView text;
        final /* synthetic */ a F;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11122a(a aVar, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.F = aVar;
            View findViewById = view.findViewById(R.id.f163185org);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.tips_content_tv)");
            this.text = (TextView) findViewById;
        }

        /* renamed from: l, reason: from getter */
        public final TextView getText() {
            return this.text;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<String> list = this.dataList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C11122a viewHolder, int index) {
        String str;
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        TextView text = viewHolder.getText();
        List<String> list = this.dataList;
        if (list == null || (str = list.get(index)) == null) {
            str = "";
        }
        text.setText(str);
    }

    @Override // com.tencent.mobileqq.guild.component.banner.DownToUpViewSwitcher.d
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public C11122a i0(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cx5, parent, false);
        if (!FontSettingManager.isFontSizeNormal()) {
            FontSettingManager.resetViewSize2Normal(itemView.getContext(), itemView);
        }
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new C11122a(this, itemView);
    }

    public final void setData(List<String> tipsList) {
        this.dataList = tipsList;
        notifyDataSetChanged();
    }
}
