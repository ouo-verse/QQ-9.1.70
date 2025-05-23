package vu1;

import androidx.recyclerview.widget.DiffUtil;
import com.tencent.mobileqq.guild.mission.beginmission.mainframe.view.MissionAdapterDelegate;
import com.tencent.mobileqq.guild.mission.beginmission.mainframe.view.MissionListEnterAdapterDelegate;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import uu1.Mission;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003R(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lvu1/c;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/d;", "Luu1/a;", "", "list", "", "l0", "I", "Ljava/util/List;", "k0", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c extends com.tencent.mobileqq.guild.widget.adapterdelegates.d<Mission> {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private List<Mission> list;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"vu1/c$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Luu1/a;", "oldItem", "newItem", "", "b", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends DiffUtil.ItemCallback<Mission> {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull Mission oldItem, @NotNull Mission newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull Mission oldItem, @NotNull Mission newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (oldItem.getMissionId() == newItem.getMissionId()) {
                return true;
            }
            return false;
        }
    }

    public c() {
        super(new a());
        this.list = new ArrayList();
        this.f236209m.c(new MissionAdapterDelegate());
        this.f236209m.c(new MissionListEnterAdapterDelegate());
    }

    @NotNull
    public final List<Mission> k0() {
        return this.list;
    }

    public final void l0(@NotNull List<Mission> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.list = list;
        this.C.submitList(list);
    }
}
