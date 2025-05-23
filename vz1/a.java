package vz1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import vp1.dn;
import vz1.a;
import wz1.GuildSettingMemberData;
import yz1.q;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u001b\u001cB\u0017\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001c\u0010\b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001c\u0010\f\u001a\u00020\u000b2\n\u0010\t\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\n\u001a\u00020\u0006H\u0016R\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lvz1/a;", "Landroidx/recyclerview/widget/ListAdapter;", "Lwz1/a;", "Lvz1/a$b;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "holder", "position", "", "i0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "Lvz1/c;", BdhLogUtil.LogTag.Tag_Conn, "Lvz1/c;", "getCallback", "()Lvz1/c;", "callback", "<init>", "(Ljava/lang/String;Lvz1/c;)V", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a extends ListAdapter<GuildSettingMemberData, b> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final c callback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lvz1/a$a;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lwz1/a;", "oldItem", "newItem", "", "b", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: vz1.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static final class C11447a extends DiffUtil.ItemCallback<GuildSettingMemberData> {
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull GuildSettingMemberData oldItem, @NotNull GuildSettingMemberData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (Intrinsics.areEqual(oldItem.getTinyId(), newItem.getTinyId()) && Intrinsics.areEqual(oldItem.getUserName(), newItem.getUserName())) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull GuildSettingMemberData oldItem, @NotNull GuildSettingMemberData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (Intrinsics.areEqual(oldItem.getTinyId(), newItem.getTinyId()) && Intrinsics.areEqual(oldItem.getUserName(), newItem.getUserName())) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lvz1/a$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lwz1/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "guildId", "Lvz1/c;", "callback", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "E", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lvp1/dn;", UserInfo.SEX_FEMALE, "Lvp1/dn;", "getBinding", "()Lvp1/dn;", "binding", "<init>", "(Lvz1/a;Landroid/content/Context;Lvp1/dn;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final Context context;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final dn binding;
        final /* synthetic */ a G;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull a aVar, @NotNull Context context, dn binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.G = aVar;
            this.context = context;
            this.binding = binding;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(GuildSettingMemberData item, String guildId, c callback, b this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(item, "$item");
            Intrinsics.checkNotNullParameter(guildId, "$guildId");
            Intrinsics.checkNotNullParameter(callback, "$callback");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!QQGuildUIUtil.v()) {
                int userType = item.getUserType();
                boolean z16 = false;
                if (userType != 2) {
                    if (userType != 3) {
                        IGProUserInfo userInfo = item.getUserInfo();
                        if (userInfo != null && userInfo.getRobotType() == 1) {
                            z16 = true;
                        }
                        String tinyId = item.getTinyId();
                        LinearLayout root = this$0.binding.getRoot();
                        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
                        callback.b(tinyId, z16, root);
                    } else {
                        LinearLayout root2 = this$0.binding.getRoot();
                        Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
                        callback.c(root2);
                    }
                } else if (q.f451648a.d(ch.L(guildId))) {
                    LinearLayout root3 = this$0.binding.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root3, "binding.root");
                    callback.a(root3);
                } else {
                    QQToastUtil.showQQToast(0, "\u9891\u9053\u6682\u4e0d\u652f\u6301\u6210\u5458\u52a0\u5165");
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void m(@NotNull final GuildSettingMemberData item, @NotNull final String guildId, @NotNull final c callback) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(callback, "callback");
            int userType = item.getUserType();
            if (userType != 2) {
                if (userType != 3) {
                    this.binding.f442957d.setText(ch.d0(item.getUserInfo()));
                    this.binding.f442956c.setAvatarTinyId(guildId, item.getTinyId());
                    this.binding.f442955b.setVisibility(8);
                    this.binding.f442956c.setVisibility(0);
                    this.binding.f442955b.setAlpha(1.0f);
                    this.binding.f442957d.setAlpha(1.0f);
                } else {
                    this.binding.f442955b.setImageDrawable(ResourcesCompat.getDrawable(this.context.getResources(), R.drawable.guild_setting_member_remove_minus_icon, null));
                    this.binding.f442957d.setText(item.getUserName());
                    this.binding.f442955b.setVisibility(0);
                    this.binding.f442956c.setVisibility(8);
                    this.binding.f442955b.setAlpha(1.0f);
                    this.binding.f442957d.setAlpha(1.0f);
                }
            } else {
                this.binding.f442955b.setImageDrawable(ResourcesCompat.getDrawable(this.context.getResources(), R.drawable.guild_setting_member_invite_add_icon, null));
                this.binding.f442957d.setText(item.getUserName());
                this.binding.f442955b.setVisibility(0);
                this.binding.f442956c.setVisibility(8);
                if (q.f451648a.d(ch.L(guildId))) {
                    this.binding.f442955b.setAlpha(1.0f);
                    this.binding.f442957d.setAlpha(1.0f);
                } else {
                    this.binding.f442955b.setAlpha(0.3f);
                    this.binding.f442957d.setAlpha(0.3f);
                }
            }
            this.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: vz1.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a.b.n(GuildSettingMemberData.this, guildId, callback, this, view);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull String guildId, @NotNull c callback) {
        super(new C11447a());
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.guildId = guildId;
        this.callback = callback;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull b holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        GuildSettingMemberData item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "item");
        holder.m(item, this.guildId, this.callback);
        holder.itemView.setTag(item);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        dn g16 = dn.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n            Lay\u2026          false\n        )");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new b(this, context, g16);
    }
}
