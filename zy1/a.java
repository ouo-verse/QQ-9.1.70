package zy1;

import androidx.recyclerview.widget.DiffUtil;
import com.tencent.mobileqq.guild.setting.group.groupshow.delegate.EmptyGroupPageAdapterDelegate;
import com.tencent.mobileqq.guild.setting.group.groupshow.delegate.GroupChatAdapterDelegate;
import com.tencent.mobileqq.guild.setting.group.groupshow.delegate.LoadingAdapterDelegate;
import com.tencent.mobileqq.guild.widget.adapterdelegates.d;
import com.tencent.mobileqq.guild.widget.adapterdelegates.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lzy1/a;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/d;", "Laz1/a;", "Lbz1/a;", "groupChatCallback", "<init>", "(Lbz1/a;)V", "I", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a extends d<az1.a> {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002\u00a8\u0006\u0007"}, d2 = {"Lzy1/a$a;", "", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Laz1/a;", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: zy1.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"zy1/a$a$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Laz1/a;", "oldItem", "newItem", "", "b", "a", "", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: zy1.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes14.dex */
        public static final class C11725a extends DiffUtil.ItemCallback<az1.a> {
            C11725a() {
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean areContentsTheSame(@NotNull az1.a oldItem, @NotNull az1.a newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return oldItem.a(newItem);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public boolean areItemsTheSame(@NotNull az1.a oldItem, @NotNull az1.a newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return oldItem.b(newItem);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            @Nullable
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public Object getChangePayload(@NotNull az1.a oldItem, @NotNull az1.a newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return oldItem.c(newItem);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DiffUtil.ItemCallback<az1.a> b() {
            return new C11725a();
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull bz1.a groupChatCallback) {
        super(INSTANCE.b(), new h());
        Intrinsics.checkNotNullParameter(groupChatCallback, "groupChatCallback");
        this.f236209m.c(new LoadingAdapterDelegate()).c(new GroupChatAdapterDelegate(groupChatCallback)).c(new EmptyGroupPageAdapterDelegate());
    }
}
