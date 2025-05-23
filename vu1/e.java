package vu1;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.mission.beginmission.missionlist.MissionListDialogFragment;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import uu1.Mission;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lvu1/e;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Luu1/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "missionIcon", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class e extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ImageView missionIcon;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View findViewById = itemView.findViewById(R.id.icon);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.icon)");
        this.missionIcon = (ImageView) findViewById;
        itemView.setTag(2);
        a aVar = a.f443516a;
        itemView.setLayoutParams(new RecyclerView.LayoutParams(aVar.a(), aVar.a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(e this$0, Mission item, View view) {
        Map mapOf;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        MissionListDialogFragment.Companion companion = MissionListDialogFragment.INSTANCE;
        Context context = this$0.itemView.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        companion.a((FragmentActivity) context, item.getGuildId());
        View view2 = this$0.itemView;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_master_guide_type", 4));
        VideoReport.reportEvent("clck", view2, mapOf);
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void m(@NotNull final Mission item) {
        int i3;
        Intrinsics.checkNotNullParameter(item, "item");
        View view = this.itemView;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        VideoReport.setElementId(view, "em_sgrp_master_guide");
        VideoReport.setElementExposePolicy(view, exposurePolicy);
        VideoReport.setElementClickPolicy(view, clickPolicy);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: vu1.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                e.n(e.this, item, view2);
            }
        });
        if (QQTheme.isVasTheme()) {
            i3 = R.drawable.guild_vas_theme_channel_item_bg_with_border;
        } else {
            i3 = R.drawable.guild_theme_channel_item_bg_with_border;
        }
        this.itemView.setBackground(QQGuildUIUtil.m(i3));
        Context i16 = ch.i();
        Intrinsics.checkNotNullExpressionValue(i16, "appContext()");
        this.missionIcon.setImageDrawable(GuildUIUtils.w(i16, R.drawable.guild_begin_mission_list_icon, Integer.valueOf(R.color.qui_common_text_primary)));
    }
}
