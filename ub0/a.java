package ub0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bJ\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000fH\u0016R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lub0/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lub0/d;", "", "Lo20/a;", "items", "", "setData", "", "addedUin", "i0", "removedUin", "j0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "l0", "getItemCount", "holder", "position", "k0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "itemsList", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class a extends RecyclerView.Adapter<d> {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<o20.a> itemsList = new ArrayList();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemsList.size();
    }

    public final void i0(@NotNull String addedUin) {
        Intrinsics.checkNotNullParameter(addedUin, "addedUin");
        int size = this.itemsList.size();
        for (int i3 = 0; i3 < size; i3++) {
            o20.a aVar = this.itemsList.get(i3);
            if (Intrinsics.areEqual(aVar.a().e(), addedUin)) {
                aVar.d(true);
                notifyDataSetChanged();
                return;
            }
        }
    }

    public final void j0(@NotNull String removedUin) {
        Intrinsics.checkNotNullParameter(removedUin, "removedUin");
        int size = this.itemsList.size();
        for (int i3 = 0; i3 < size; i3++) {
            o20.a aVar = this.itemsList.get(i3);
            if (Intrinsics.areEqual(aVar.a().e(), removedUin)) {
                aVar.d(false);
                notifyDataSetChanged();
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull d holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (ab0.a.a(position, this.itemsList)) {
            return;
        }
        holder.o(this.itemsList.get(position), position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public d onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.g8q, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new d(itemView);
    }

    public final void setData(@NotNull List<? extends o20.a> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.itemsList.clear();
        this.itemsList.addAll(items);
        notifyDataSetChanged();
    }
}
