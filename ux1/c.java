package ux1;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildChannelIconUtil;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0018\u0019\u001aB\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0014\u0010\u0011\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001b"}, d2 = {"Lux1/c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "holder", "position", "", "onBindViewHolder", "getItemCount", "getItemViewType", "", "Lcom/tencent/mobileqq/guild/channel/manage/b;", "list", "setData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "mDataList", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<com.tencent.mobileqq.guild.channel.manage.b> mDataList = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lux1/c$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/channel/manage/b;", "data", "", "l", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "mChannelIconView", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "mChannelName", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private ImageView mChannelIconView;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private TextView mChannelName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.trz);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.channel_icon)");
            this.mChannelIconView = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.ato);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.channel_name)");
            this.mChannelName = (TextView) findViewById2;
            itemView.setClickable(true);
        }

        public final void l(@NotNull com.tencent.mobileqq.guild.channel.manage.b data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.mChannelName.setText(data.f215083c.getChannelName());
            ImageView imageView = this.mChannelIconView;
            imageView.setBackground(ResourcesCompat.getDrawable(imageView.getResources(), er1.a.c(), null));
            GuildChannelIconUtil.r(this.mChannelIconView, data.f215083c.getType(), data.f215083c.getTextChannelSubtypeId(), null, 8, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lux1/c$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/channel/manage/b;", "data", "", "l", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "mTitle", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private TextView mTitle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.tsi);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.channel_title)");
            this.mTitle = (TextView) findViewById;
        }

        public final void l(@NotNull com.tencent.mobileqq.guild.channel.manage.b data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.mTitle.setText(data.f215082b);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.mDataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.mDataList.get(position).f215081a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        com.tencent.mobileqq.guild.channel.manage.b bVar = this.mDataList.get(position);
        int i3 = bVar.f215081a;
        if (i3 == 1) {
            ((b) holder).l(bVar);
        } else if (i3 == 0) {
            ((a) holder).l(bVar);
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.rg.ChannelPermissionForRoleAdapter", "onBindViewHolder pos:" + position + " data:" + bVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 0) {
            if (viewType == 1) {
                View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.ehr, parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026ry_layout, parent, false)");
                return new b(inflate);
            }
            throw new IllegalArgumentException("Guild.rg.ChannelPermissionForRoleAdapter onCreateViewHolder viewType is error");
        }
        View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.f168045ei2, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context).inf\u2026em_layout, parent, false)");
        return new a(inflate2);
    }

    public final void setData(@NotNull List<com.tencent.mobileqq.guild.channel.manage.b> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.mDataList = list;
        notifyDataSetChanged();
    }
}
