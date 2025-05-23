package q12;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.util.IGuildFastClickUtilApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bz;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\f\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006!"}, d2 = {"Lq12/c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lq12/c$b;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProChannelActivity;", "newData", "", "setData", "", "position", "k0", "Lq12/d;", "listener", "o0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "n0", "holder", "l0", "getItemCount", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "data", BdhLogUtil.LogTag.Tag_Conn, "Lq12/d;", "mItemClickListener", "<init>", "()V", "D", "a", "b", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c extends RecyclerView.Adapter<b> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private d mItemClickListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<IGProChannelActivity> data = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lq12/c$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "setOperationImageView", "(Landroid/widget/ImageView;)V", "operationImageView", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private ImageView operationImageView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.f211600_);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.operation_image)");
            this.operationImageView = (ImageView) findViewById;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final ImageView getOperationImageView() {
            return this.operationImageView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(c this$0, int i3, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IGuildFastClickUtilApi iGuildFastClickUtilApi = (IGuildFastClickUtilApi) QRoute.api(IGuildFastClickUtilApi.class);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (!iGuildFastClickUtilApi.isFastClick(it)) {
            IGProChannelActivity k06 = this$0.k0(i3);
            d dVar = this$0.mItemClickListener;
            if (dVar != null) {
                dVar.a(i3, k06);
            }
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.data.size();
    }

    @Nullable
    public final IGProChannelActivity k0(int position) {
        if (position >= 0 && position < this.data.size()) {
            return this.data.get(position);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull b holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ((IQQGuildAvatarApi) bz.b(IQQGuildAvatarApi.class)).loadCommonPic(this.data.get(position).getImageUrl(), holder.getOperationImageView(), true, (Drawable) new ColorDrawable(0));
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: q12.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.m0(c.this, position, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.f1r, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026ration_banner_item, null)");
        b bVar = new b(inflate);
        bVar.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return bVar;
    }

    public final void o0(@Nullable d listener) {
        this.mItemClickListener = listener;
    }

    public final void setData(@NotNull List<? extends IGProChannelActivity> newData) {
        Intrinsics.checkNotNullParameter(newData, "newData");
        this.data.clear();
        this.data.addAll(newData);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.comm.GuildOperationBannerAdapter", "setData: " + this.data.size());
        }
        notifyDataSetChanged();
    }
}
