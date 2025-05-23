package zg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.util.h;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RoundRectURLImageView;
import ho.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zg.d;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\t\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0019B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\nH\u0016R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lzg/d;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lzg/d$b;", "", "Lzg/a;", "newData", "", "setData", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "l0", "getItemCount", "viewHolder", "position", "k0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "mGameplayItemDataList", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d extends RecyclerView.Adapter<b> {

    /* renamed from: C, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static int D = ViewUtils.dip2px(48.0f);
    private static int E = ViewUtils.dip2px(48.0f);

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final List<QZoneFeedBottomContainerItemData> mGameplayItemDataList = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lzg/d$a;", "", "", "SMALL_ICON_WIDTH", "I", "b", "()I", "setSMALL_ICON_WIDTH", "(I)V", "SMALL_ICON_HEIGHT", "a", "setSMALL_ICON_HEIGHT", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: zg.d$a, reason: from kotlin metadata */
    /* loaded from: classes36.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return d.E;
        }

        public final int b() {
            return d.D;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u001c\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\f0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0014\u001a\n \r*\u0004\u0018\u00010\u00110\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lzg/d$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "view", "", "position", "Lzg/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "o", "gameplayItemData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/widget/RoundRectURLImageView;", "kotlin.jvm.PlatformType", "E", "Lcom/tencent/widget/RoundRectURLImageView;", "iconImageVIew", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "titleTextView", "itemView", "<init>", "(Landroid/view/View;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final RoundRectURLImageView iconImageVIew;

        /* renamed from: F, reason: from kotlin metadata */
        private final TextView titleTextView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            RoundRectURLImageView roundRectURLImageView = (RoundRectURLImageView) itemView.findViewById(R.id.kct);
            roundRectURLImageView.setRadius(ViewUtils.dip2px(4.0f));
            this.iconImageVIew = roundRectURLImageView;
            this.titleTextView = (TextView) itemView.findViewById(R.id.nhg);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(QZoneFeedBottomContainerItemData gameplayItemData, Context context, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(gameplayItemData, "$gameplayItemData");
            if (!h.a()) {
                lg.d.f414454a.t(gameplayItemData);
                ho.d g16 = i.g();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                g16.e(context, gameplayItemData.getJumpurl());
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        private final void o(View view, int position, QZoneFeedBottomContainerItemData item) {
            HashMap hashMap = new HashMap();
            hashMap.put("item_position", Integer.valueOf(position));
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.ADID, item.getAdID());
            fo.c.o(view, "em_qz_play_recommend_item", new fo.b().i(String.valueOf(item.hashCode())).l(hashMap));
        }

        public final void m(final QZoneFeedBottomContainerItemData gameplayItemData, int position) {
            Intrinsics.checkNotNullParameter(gameplayItemData, "gameplayItemData");
            final Context context = this.itemView.getContext();
            this.titleTextView.setText(gameplayItemData.getName());
            RoundRectURLImageView roundRectURLImageView = this.iconImageVIew;
            String icon = gameplayItemData.getIcon();
            Companion companion = d.INSTANCE;
            com.qzone.reborn.util.h.i(context, roundRectURLImageView, icon, companion.b(), companion.a());
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: zg.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.b.n(QZoneFeedBottomContainerItemData.this, context, view);
                }
            });
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            o(itemView, position, gameplayItemData);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.mGameplayItemDataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b viewHolder, int position) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        viewHolder.m(this.mGameplayItemDataList.get(position), position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.f130508y, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026item_view, parent, false)");
        return new b(inflate);
    }

    public final void setData(List<QZoneFeedBottomContainerItemData> newData) {
        Intrinsics.checkNotNullParameter(newData, "newData");
        this.mGameplayItemDataList.clear();
        this.mGameplayItemDataList.addAll(newData);
        notifyDataSetChanged();
    }
}
