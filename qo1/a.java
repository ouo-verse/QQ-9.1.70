package qo1;

import android.annotation.SuppressLint;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeAudioInactiveAdapterDelegate;
import com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeAudioListenChannelAdapterDelegate;
import com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeAudioLobbyChannelAdapterDelegate;
import com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeAudioNormalChannelAdapterDelegate;
import com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeAudioPlayChannelAdapterDelegate;
import com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeAudioScreenChannelAdapterDelegate;
import com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeEmptyAdapterDelegate;
import com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeLiveChannelAdapterDelegate;
import com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeLiveInactiveAdapterDelegate;
import com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeSpaceDelegate;
import com.tencent.mobileqq.guild.widget.adapterdelegates.ViewHolderVisibleAwareNotifier;
import com.tencent.mobileqq.guild.widget.adapterdelegates.d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import so1.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u0017\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lqo1/a;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/d;", "Lso1/h;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/ViewHolderVisibleAwareNotifier;", "I", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/ViewHolderVisibleAwareNotifier;", "viewHolderVisibleAwareNotifier", "Landroidx/lifecycle/LifecycleOwner;", "viewLifecycleOwner", "Lqo1/a$b;", "callback", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Lqo1/a$b;)V", "J", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a extends d<h> {

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final ViewHolderVisibleAwareNotifier viewHolderVisibleAwareNotifier;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lqo1/a$a;", "", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lso1/h;", "b", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: qo1.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0017\u00a8\u0006\b"}, d2 = {"qo1/a$a$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lso1/h;", "oldItem", "newItem", "", "b", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: qo1.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public static final class C11089a extends DiffUtil.ItemCallback<h> {
            C11089a() {
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            @SuppressLint({"DiffUtilEquals"})
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean areContentsTheSame(@NotNull h oldItem, @NotNull h newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return newItem.e(oldItem);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public boolean areItemsTheSame(@NotNull h oldItem, @NotNull h newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem.getChannelId(), newItem.getChannelId());
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DiffUtil.ItemCallback<h> b() {
            return new C11089a();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lqo1/a$b;", "", "Lso1/h;", "uiData", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {
        void a(@NotNull h uiData);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull LifecycleOwner viewLifecycleOwner, @NotNull b callback) {
        super(INSTANCE.b());
        Intrinsics.checkNotNullParameter(viewLifecycleOwner, "viewLifecycleOwner");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ViewHolderVisibleAwareNotifier viewHolderVisibleAwareNotifier = new ViewHolderVisibleAwareNotifier();
        this.viewHolderVisibleAwareNotifier = viewHolderVisibleAwareNotifier;
        ViewHolderVisibleAwareNotifier.c(viewHolderVisibleAwareNotifier, viewLifecycleOwner, null, 2, null);
        this.f236209m.c(new GuildHomeLiveChannelAdapterDelegate(callback)).c(new GuildHomeAudioNormalChannelAdapterDelegate(callback)).c(new GuildHomeAudioListenChannelAdapterDelegate(callback)).c(new GuildHomeAudioLobbyChannelAdapterDelegate(callback)).c(new GuildHomeAudioPlayChannelAdapterDelegate(callback)).c(new GuildHomeAudioScreenChannelAdapterDelegate(callback)).c(new GuildHomeLiveInactiveAdapterDelegate(callback)).c(new GuildHomeAudioInactiveAdapterDelegate(callback)).c(new GuildHomeEmptyAdapterDelegate(callback)).c(new GuildHomeSpaceDelegate());
    }

    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.d, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        this.viewHolderVisibleAwareNotifier.d(holder);
    }

    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.d, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        this.viewHolderVisibleAwareNotifier.e(holder);
    }
}
