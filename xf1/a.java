package xf1;

import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B#\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0010\u0010\u001f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u001e\u00a2\u0006\u0004\b \u0010!J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0002J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005J\u001a\u0010\u0011\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J \u0010\u0013\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J0\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016R\u0016\u0010\u001d\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lxf1/a;", "Lcom/tencent/mobileqq/guild/channel/manage/a;", "Lcom/tencent/mobileqq/guild/channel/manage/b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "isDragStart", "", "a", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "target", "c", NodeProps.ENABLED, "b", "", "actionState", "onSelectedChanged", "clearView", "onMove", "getMovementFlags", "viewSize", "viewSizeOutOfBounds", "totalSize", "", "msSinceStartScroll", "interpolateOutOfBoundsScroll", "d", "Z", "disDragEnabled", "", "dataList", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Ljava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a extends com.tencent.mobileqq.guild.channel.manage.a<com.tencent.mobileqq.guild.channel.manage.b> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean disDragEnabled;

    public a(@Nullable RecyclerView recyclerView, @Nullable List<? extends com.tencent.mobileqq.guild.channel.manage.b> list) {
        super(recyclerView, list);
    }

    private final void a(RecyclerView.ViewHolder viewHolder, boolean isDragStart) {
        View view;
        float f16;
        if (viewHolder != null) {
            view = viewHolder.itemView;
        } else {
            view = null;
        }
        if (view != null) {
            try {
                viewHolder.itemView.setOutlineProvider(ViewOutlineProvider.BOUNDS);
                View view2 = viewHolder.itemView;
                if (isDragStart) {
                    f16 = 20.0f;
                } else {
                    f16 = 0.0f;
                }
                view2.setTranslationZ(f16);
            } catch (Exception e16) {
                Logger.f235387a.d().w(QPublicBaseFragment.TAG, 1, "setItemShadow " + e16);
            }
        }
    }

    private final boolean c(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        h hVar;
        int adapterPosition = viewHolder.getAdapterPosition();
        int adapterPosition2 = target.getAdapterPosition();
        RecyclerView.Adapter adapter = this.f215078a.getAdapter();
        if (adapter instanceof h) {
            hVar = (h) adapter;
        } else {
            hVar = null;
        }
        if (hVar == null) {
            return true;
        }
        if (!hVar.m0(adapterPosition) || !hVar.m0(adapterPosition2) || !super.onMove(recyclerView, viewHolder, target)) {
            return false;
        }
        if (hVar.k0(adapterPosition)) {
            hVar.notifyItemRangeChanged(adapterPosition, 2);
        } else if (hVar.l0(adapterPosition)) {
            hVar.notifyItemRangeChanged(adapterPosition - 1, 2);
        }
        if (hVar.k0(adapterPosition2)) {
            hVar.notifyItemRangeChanged(adapterPosition2, 2);
        } else if (hVar.l0(adapterPosition2)) {
            hVar.notifyItemRangeChanged(adapterPosition2 - 1, 2);
        }
        return true;
    }

    public final void b(boolean enabled) {
        this.disDragEnabled = enabled;
    }

    @Override // com.tencent.mobileqq.guild.channel.manage.a, androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        super.clearView(recyclerView, viewHolder);
        a(viewHolder, false);
    }

    @Override // com.tencent.mobileqq.guild.channel.manage.a, androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Object obj = this.f215079b.get(viewHolder.getAdapterPosition());
        Intrinsics.checkNotNull(obj);
        if (((com.tencent.mobileqq.guild.channel.manage.b) obj).f215084d != null && !this.disDragEnabled) {
            return super.getMovementFlags(recyclerView, viewHolder);
        }
        return ItemTouchHelper.Callback.makeMovementFlags(0, 0);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int interpolateOutOfBoundsScroll(@NotNull RecyclerView recyclerView, int viewSize, int viewSizeOutOfBounds, int totalSize, long msSinceStartScroll) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        return ((int) Math.signum(viewSizeOutOfBounds)) * 4;
    }

    @Override // com.tencent.mobileqq.guild.channel.manage.a, androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder, @NotNull RecyclerView.ViewHolder target) {
        String valueOf;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(target, "target");
        int adapterPosition = viewHolder.getAdapterPosition();
        int adapterPosition2 = target.getAdapterPosition();
        Object obj = this.f215079b.get(adapterPosition);
        Intrinsics.checkNotNull(obj);
        com.tencent.mobileqq.guild.channel.manage.b bVar = (com.tencent.mobileqq.guild.channel.manage.b) obj;
        Object obj2 = this.f215079b.get(adapterPosition2);
        Intrinsics.checkNotNull(obj2);
        com.tencent.mobileqq.guild.channel.manage.b bVar2 = (com.tencent.mobileqq.guild.channel.manage.b) obj2;
        IGProChannel iGProChannel = bVar.f215084d;
        if (iGProChannel == null) {
            valueOf = "";
        } else {
            valueOf = String.valueOf(iGProChannel.getGuildId());
        }
        if (ch.m0(valueOf)) {
            return c(recyclerView, viewHolder, target);
        }
        int i3 = bVar.f215087g;
        if (i3 != 0 && ((i3 != 1 || bVar.f215086f == bVar2.f215086f) && bVar2.f215081a != 1)) {
            return c(recyclerView, viewHolder, target);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.channel.manage.a, androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
        super.onSelectedChanged(viewHolder, actionState);
        if (viewHolder != null) {
            a(viewHolder, true);
        }
    }
}
