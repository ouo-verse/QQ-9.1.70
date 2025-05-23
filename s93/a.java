package s93;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.wink.qzone.templatelibrary.utils.WinkQZoneTemplateLibJumpHelper;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s93.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\b\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f B\u001b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\nH\u0016R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Ls93/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "materials", "", "l0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "getItemCount", "holder", "position", "onBindViewHolder", "Landroid/os/Bundle;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/os/Bundle;", "bundle", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/utils/WinkQZoneTemplateLibJumpHelper;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/utils/WinkQZoneTemplateLibJumpHelper;", "jumpHelper", "", "D", "Ljava/util/List;", "<init>", "(Landroid/os/Bundle;Lcom/tencent/mobileqq/wink/qzone/templatelibrary/utils/WinkQZoneTemplateLibJumpHelper;)V", "E", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private final WinkQZoneTemplateLibJumpHelper jumpHelper;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private List<MetaMaterial> materials = new ArrayList();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Bundle bundle;

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Ls93/a$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "o", "Landroid/view/View;", "view", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "", "position", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "icon", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "title", "G", "hotIcon", "itemView", "<init>", "(Ls93/a;Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final ImageView icon;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final TextView title;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final ImageView hotIcon;
        final /* synthetic */ a H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull a aVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.H = aVar;
            View findViewById = itemView.findViewById(R.id.sgh);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.ai_tool_item_icon)");
            this.icon = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.sgi);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.ai_tool_item_title)");
            this.title = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.sgg);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.ai_tool_item_hot_icon)");
            this.hotIcon = (ImageView) findViewById3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(b this$0, MetaMaterial material, a this$1, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(material, "$material");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            View itemView = this$0.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            this$0.p(itemView, material);
            WinkQZoneTemplateLibJumpHelper winkQZoneTemplateLibJumpHelper = this$1.jumpHelper;
            if (winkQZoneTemplateLibJumpHelper != null) {
                Context context = this$0.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                winkQZoneTemplateLibJumpHelper.k(context, this$1.bundle, material, null, "1");
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        private final void o(MetaMaterial material) {
            if (Intrinsics.areEqual(com.tencent.mobileqq.wink.editor.c.d0(material), "\u70ed\u95e8")) {
                this.hotIcon.setVisibility(0);
                Option obtain = Option.obtain();
                obtain.setLoadingDrawableColor(this.itemView.getContext().getColor(R.color.ajr));
                obtain.setTargetView(this.hotIcon);
                obtain.setUrl("https://downv6.qq.com/shadow_qqcamera/QZoneTemplateLib/qvideo_icon_new.png");
                QQPicLoader.f201806a.d().loadImage(obtain, null);
                return;
            }
            this.hotIcon.setVisibility(8);
        }

        private final void p(View view, MetaMaterial material) {
            Map<String, ?> mutableMapOf;
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("material_id", material.f30533id));
            com.tencent.mobileqq.wink.report.e.f326265a.l(view, WinkDaTongReportConstant.ElementId.EM_QZ_AI_TOOL_EN, mutableMapOf, material.f30533id);
        }

        private final void q(View view, MetaMaterial material) {
            Map<String, ?> mutableMapOf;
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("material_id", material.f30533id));
            com.tencent.mobileqq.wink.report.e.f326265a.e(view, WinkDaTongReportConstant.ElementId.EM_QZ_AI_TOOL_EN, mutableMapOf, material.f30533id);
        }

        public final void m(int position) {
            String s16;
            final MetaMaterial metaMaterial = (MetaMaterial) this.H.materials.get(position);
            this.title.setText(com.tencent.mobileqq.wink.editor.c.a0(metaMaterial));
            Option obtain = Option.obtain();
            obtain.setLoadingDrawableColor(this.itemView.getContext().getColor(R.color.ajr));
            obtain.setTargetView(this.icon);
            if (QQTheme.isNowThemeIsNight()) {
                s16 = com.tencent.mobileqq.wink.editor.c.r(metaMaterial);
            } else {
                s16 = com.tencent.mobileqq.wink.editor.c.s(metaMaterial);
            }
            obtain.setUrl(s16);
            QQPicLoader.f201806a.d().loadImage(obtain, null);
            o(metaMaterial);
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            q(itemView, metaMaterial);
            View view = this.itemView;
            final a aVar = this.H;
            view.setOnClickListener(new View.OnClickListener() { // from class: s93.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    a.b.n(a.b.this, metaMaterial, aVar, view2);
                }
            });
        }
    }

    public a(@Nullable Bundle bundle, @Nullable WinkQZoneTemplateLibJumpHelper winkQZoneTemplateLibJumpHelper) {
        this.bundle = bundle;
        this.jumpHelper = winkQZoneTemplateLibJumpHelper;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.materials.size();
    }

    public final void l0(@NotNull List<MetaMaterial> materials) {
        Intrinsics.checkNotNullParameter(materials, "materials");
        this.materials = TypeIntrinsics.asMutableList(materials);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof b) {
            ((b) holder).m(position);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.i7k, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new b(this, itemView);
    }
}
