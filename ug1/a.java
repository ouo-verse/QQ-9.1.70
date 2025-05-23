package ug1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.guild.api.IGuildContentShareApi;
import com.tencent.mobileqq.guild.contentshare.AbsGuildContentShareTemplate;
import com.tencent.mobileqq.guild.contentshare.d;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u000b\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002$%B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u00a2\u0006\u0004\b!\u0010\"J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0006\u0010\u0010\u001a\u00020\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\t\u001a\u00020\u0005J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\t\u001a\u00020\u0005R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001d\u00a8\u0006&"}, d2 = {"Lug1/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lug1/a$b;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "l0", "holder", "position", "", "k0", "getItemCount", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onDetachedFromRecyclerView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/guild/contentshare/AbsGuildContentShareTemplate;", "i0", "Landroid/view/View;", "j0", "Lcom/tencent/mobileqq/guild/contentshare/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/contentshare/d;", "getShareInfo", "()Lcom/tencent/mobileqq/guild/contentshare/d;", "shareInfo", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/Map;", "templateMap", "D", "viewMap", "<init>", "(Lcom/tencent/mobileqq/guild/contentshare/d;)V", "E", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a extends RecyclerView.Adapter<b> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Map<Integer, AbsGuildContentShareTemplate> templateMap;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Map<Integer, View> viewMap;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d shareInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lug1/a$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "position", "Landroid/view/View;", "view", "", "l", "Lcom/tencent/mobileqq/guild/contentshare/d;", "E", "Lcom/tencent/mobileqq/guild/contentshare/d;", "getShareInfo", "()Lcom/tencent/mobileqq/guild/contentshare/d;", "shareInfo", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/guild/contentshare/d;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final d shareInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View itemView, @NotNull d shareInfo) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(shareInfo, "shareInfo");
            this.shareInfo = shareInfo;
        }

        public final void l(int position, @Nullable View view) {
            int b16;
            LinearLayout.LayoutParams layoutParams;
            QLog.i("GuildContentShareAdapter", 1, "bindData parentWidth=" + this.itemView.getMeasuredWidth());
            if (this.itemView instanceof LinearLayout) {
                if (position <= 1) {
                    b16 = ((IGuildContentShareApi) QRoute.api(IGuildContentShareApi.class)).getContentShareMaxWidth();
                } else {
                    b16 = (int) cw.b(428);
                }
                if (view != null) {
                    ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                    if (layoutParams2 instanceof LinearLayout.LayoutParams) {
                        layoutParams = (LinearLayout.LayoutParams) layoutParams2;
                    } else {
                        layoutParams = null;
                    }
                    if (layoutParams == null) {
                        layoutParams = new LinearLayout.LayoutParams(b16, -2);
                    }
                    view.setLayoutParams(layoutParams);
                    View view2 = this.itemView;
                    Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type android.widget.LinearLayout");
                    ((LinearLayout) view2).setOrientation(1);
                    View view3 = this.itemView;
                    Intrinsics.checkNotNull(view3, "null cannot be cast to non-null type android.widget.LinearLayout");
                    ((LinearLayout) view3).setGravity(17);
                    View view4 = this.itemView;
                    Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type android.widget.LinearLayout");
                    ((LinearLayout) view4).addView(view);
                }
            }
        }
    }

    public a(@NotNull d shareInfo) {
        Intrinsics.checkNotNullParameter(shareInfo, "shareInfo");
        this.shareInfo = shareInfo;
        this.templateMap = new LinkedHashMap();
        this.viewMap = new LinkedHashMap();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return ((IGuildContentShareApi) QRoute.api(IGuildContentShareApi.class)).getTemplateSize();
    }

    @Nullable
    public final AbsGuildContentShareTemplate i0(int position) {
        return this.templateMap.get(Integer.valueOf(position));
    }

    @Nullable
    public final View j0(int position) {
        return this.viewMap.get(Integer.valueOf(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull b holder, int position) {
        View view;
        Intrinsics.checkNotNullParameter(holder, "holder");
        AbsGuildContentShareTemplate template = ((IGuildContentShareApi) QRoute.api(IGuildContentShareApi.class)).getTemplate(position);
        QLog.i("GuildContentShareAdapter", 1, "onBindViewHolder holder.itemView.width=" + holder.itemView.getMeasuredWidth() + " shareInfo.width=" + this.shareInfo.getWidth());
        View view2 = holder.itemView;
        view2.measure(View.MeasureSpec.makeMeasureSpec(view2.getMeasuredWidth(), 1073741824), 0);
        if (template != null) {
            Context context = holder.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "holder.itemView.context");
            d dVar = this.shareInfo;
            View view3 = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(view3, "holder.itemView");
            view = template.j(context, dVar, view3);
        } else {
            view = null;
        }
        this.templateMap.put(Integer.valueOf(position), template);
        this.viewMap.put(Integer.valueOf(position), view);
        holder.l(position, view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LinearLayout linearLayout = new LinearLayout(parent.getContext());
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        linearLayout.measure(View.MeasureSpec.makeMeasureSpec(((IGuildContentShareApi) QRoute.api(IGuildContentShareApi.class)).getContentShareMaxWidth(), 1073741824), 0);
        QLog.i("GuildContentShareAdapter", 1, "onCreateViewHolder parent.width=" + parent.getMeasuredWidth() + " view.width=" + linearLayout.getWidth());
        return new b(linearLayout, this.shareInfo);
    }

    public final void onDestroy() {
        for (AbsGuildContentShareTemplate absGuildContentShareTemplate : this.templateMap.values()) {
            if (absGuildContentShareTemplate != null) {
                absGuildContentShareTemplate.e();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.templateMap.clear();
        this.viewMap.clear();
    }
}
