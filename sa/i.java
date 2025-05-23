package sa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import wa.QZAlbumxParentFamilyBean;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001fB/\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\u0012\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001c\u0010\u0007\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\u000b\u001a\u00020\n2\n\u0010\b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R&\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R$\u0010\u001c\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lsa/i;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lsa/i$a;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "m0", "holder", "position", "", "k0", "getItemCount", "", "Lwa/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "items", "Lkotlin/Function2;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function2;", "listener", "D", "Lwa/b;", "j0", "()Lwa/b;", "n0", "(Lwa/b;)V", "selectedFamilyBean", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class i extends RecyclerView.Adapter<a> {

    /* renamed from: C, reason: from kotlin metadata */
    private final Function2<Integer, QZAlbumxParentFamilyBean, Unit> listener;

    /* renamed from: D, reason: from kotlin metadata */
    private QZAlbumxParentFamilyBean selectedFamilyBean;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final List<QZAlbumxParentFamilyBean> items;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lsa/i$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/RadioButton;", "E", "Landroid/widget/RadioButton;", "l", "()Landroid/widget/RadioButton;", "radioButton", "Landroid/view/View;", "view", "<init>", "(Lsa/i;Landroid/view/View;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final RadioButton radioButton;
        final /* synthetic */ i F;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i iVar, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.F = iVar;
            View findViewById = view.findViewById(R.id.kg7);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.identity_radio_button)");
            this.radioButton = (RadioButton) findViewById;
        }

        /* renamed from: l, reason: from getter */
        public final RadioButton getRadioButton() {
            return this.radioButton;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(List<QZAlbumxParentFamilyBean> items, Function2<? super Integer, ? super QZAlbumxParentFamilyBean, Unit> listener) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.items = items;
        this.listener = listener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(i this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.selectedFamilyBean = this$0.items.get(i3);
        this$0.notifyDataSetChanged();
        this$0.listener.invoke(Integer.valueOf(i3), this$0.items.get(i3));
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    /* renamed from: j0, reason: from getter */
    public final QZAlbumxParentFamilyBean getSelectedFamilyBean() {
        return this.selectedFamilyBean;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getRadioButton().setText(this.items.get(position).getName());
        RadioButton radioButton = holder.getRadioButton();
        String name = this.items.get(position).getName();
        QZAlbumxParentFamilyBean qZAlbumxParentFamilyBean = this.selectedFamilyBean;
        radioButton.setChecked(Intrinsics.areEqual(name, qZAlbumxParentFamilyBean != null ? qZAlbumxParentFamilyBean.getName() : null));
        if (holder.getRadioButton().isChecked()) {
            holder.getRadioButton().setTextColor(holder.getRadioButton().getResources().getColor(R.color.qui_button_text_primary_default));
        } else {
            holder.getRadioButton().setTextColor(holder.getRadioButton().getResources().getColor(R.color.qui_button_text_secondary_default));
        }
        holder.getRadioButton().setOnClickListener(new View.OnClickListener() { // from class: sa.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.l0(i.this, position, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.f129275m, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new a(this, view);
    }

    public final void n0(QZAlbumxParentFamilyBean qZAlbumxParentFamilyBean) {
        this.selectedFamilyBean = qZAlbumxParentFamilyBean;
    }
}
