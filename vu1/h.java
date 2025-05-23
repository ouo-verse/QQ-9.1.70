package vu1;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.mission.beginmission.mainframe.model.MissionId;
import com.tencent.mobileqq.guild.mission.beginmission.presentdialog.MissionPresentDialogFragment;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
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
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"Lvu1/h;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "missionId", "Landroid/graphics/drawable/Drawable;", "o", "Luu1/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mission", "", "guildId", "p", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "missionIcon", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "missionName", "G", "missionDes", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class h extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ImageView missionIcon;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final TextView missionName;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final TextView missionDes;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View findViewById = itemView.findViewById(R.id.zbu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.mission_icon)");
        this.missionIcon = (ImageView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.zbx);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.mission_name)");
        TextView textView = (TextView) findViewById2;
        this.missionName = textView;
        View findViewById3 = itemView.findViewById(R.id.zbt);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.mission_desc)");
        this.missionDes = (TextView) findViewById3;
        textView.getPaint().setFakeBoldText(true);
        itemView.setTag(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(h this$0, Mission item, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.p(item, item.getGuildId());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final Drawable o(int missionId) {
        Integer valueOf = Integer.valueOf(R.color.qui_common_text_primary);
        switch (missionId) {
            case 1:
                if (QQTheme.isVasTheme()) {
                    Context i3 = ch.i();
                    Intrinsics.checkNotNullExpressionValue(i3, "appContext()");
                    return GuildUIUtils.w(i3, R.drawable.guild_begin_mission_create_sub_channel_icon, valueOf);
                }
                if (GuildThemeManager.f235286a.b()) {
                    return QQGuildUIUtil.m(R.drawable.guild_begin_mission_create_sub_channel_icon_night);
                }
                return QQGuildUIUtil.m(R.drawable.guild_begin_mission_create_sub_channel_icon);
            case 2:
                if (QQTheme.isVasTheme()) {
                    Context i16 = ch.i();
                    Intrinsics.checkNotNullExpressionValue(i16, "appContext()");
                    return GuildUIUtils.w(i16, R.drawable.guild_begin_mission_robot_icon, valueOf);
                }
                if (GuildThemeManager.f235286a.b()) {
                    return QQGuildUIUtil.m(R.drawable.guild_begin_mission_robot_icon_night);
                }
                return QQGuildUIUtil.m(R.drawable.guild_begin_mission_robot_icon);
            case 3:
                if (QQTheme.isVasTheme()) {
                    Context i17 = ch.i();
                    Intrinsics.checkNotNullExpressionValue(i17, "appContext()");
                    return GuildUIUtils.w(i17, R.drawable.guild_begin_mission_invite_icon, valueOf);
                }
                if (GuildThemeManager.f235286a.b()) {
                    return QQGuildUIUtil.m(R.drawable.guild_begin_mission_invite_icon_night);
                }
                return QQGuildUIUtil.m(R.drawable.guild_begin_mission_invite_icon);
            case 4:
                if (QQTheme.isVasTheme()) {
                    Context i18 = ch.i();
                    Intrinsics.checkNotNullExpressionValue(i18, "appContext()");
                    return GuildUIUtils.w(i18, R.drawable.guild_begin_mission_manage_icon, valueOf);
                }
                if (GuildThemeManager.f235286a.b()) {
                    return QQGuildUIUtil.m(R.drawable.guild_begin_mission_manage_icon_night);
                }
                return QQGuildUIUtil.m(R.drawable.guild_begin_mission_manage_icon);
            case 5:
                if (QQTheme.isVasTheme()) {
                    Context i19 = ch.i();
                    Intrinsics.checkNotNullExpressionValue(i19, "appContext()");
                    return GuildUIUtils.w(i19, R.drawable.guild_begin_mission_message_icon, valueOf);
                }
                if (GuildThemeManager.f235286a.b()) {
                    return QQGuildUIUtil.m(R.drawable.guild_begin_mission_message_icon_night);
                }
                return QQGuildUIUtil.m(R.drawable.guild_begin_mission_message_icon);
            case 6:
                if (QQTheme.isVasTheme()) {
                    Context i26 = ch.i();
                    Intrinsics.checkNotNullExpressionValue(i26, "appContext()");
                    return GuildUIUtils.w(i26, R.drawable.guild_begin_mission_welcome_icon, valueOf);
                }
                if (GuildThemeManager.f235286a.b()) {
                    return QQGuildUIUtil.m(R.drawable.guild_begin_mission_welcome_icon_night);
                }
                return QQGuildUIUtil.m(R.drawable.guild_begin_mission_welcome_icon);
            default:
                throw new IllegalArgumentException("Illegal missionId");
        }
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
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.mission.MissionConstant", 2, "itemWidth:" + ((int) (a.f443516a.b() * 0.9d)));
        }
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams((int) (r4.b() * 0.9d), a.f443516a.a()));
        this.missionIcon.setImageDrawable(o(item.getMissionId()));
        this.missionIcon.setBackground(QQGuildUIUtil.m(R.drawable.guild_token_bg_middle_light_corner_6));
        this.missionName.setText(item.getMissionName());
        this.missionDes.setText(item.getMissionDes());
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: vu1.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                h.n(h.this, item, view2);
            }
        });
        if (QQTheme.isVasTheme()) {
            i3 = R.drawable.guild_vas_theme_channel_item_bg_with_border;
        } else {
            i3 = R.drawable.guild_theme_channel_item_bg_with_border;
        }
        this.itemView.setBackground(QQGuildUIUtil.m(i3));
    }

    public final void p(@NotNull Mission mission, @NotNull String guildId) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(mission, "mission");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        if (QQGuildUIUtil.v()) {
            return;
        }
        switch (mission.getMissionId()) {
            case 1:
                MissionPresentDialogFragment.Companion companion = MissionPresentDialogFragment.INSTANCE;
                Context context = this.itemView.getContext();
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                FragmentManager supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "itemView.context as Frag\u2026y).supportFragmentManager");
                companion.a(supportFragmentManager, guildId, 1);
                break;
            case 2:
                MissionPresentDialogFragment.Companion companion2 = MissionPresentDialogFragment.INSTANCE;
                Context context2 = this.itemView.getContext();
                Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                FragmentManager supportFragmentManager2 = ((FragmentActivity) context2).getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "itemView.context as Frag\u2026y).supportFragmentManager");
                companion2.a(supportFragmentManager2, guildId, 2);
                break;
            case 3:
                tu1.a aVar = tu1.a.f437478a;
                Context context3 = this.itemView.getContext();
                Intrinsics.checkNotNull(context3, "null cannot be cast to non-null type android.app.Activity");
                aVar.b((Activity) context3, guildId);
                break;
            case 4:
                if (mission.getIsFinish()) {
                    IQQGuildRouterApi iQQGuildRouterApi = (IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class);
                    QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
                    Intrinsics.checkNotNull(qBaseActivity, "null cannot be cast to non-null type android.app.Activity");
                    iQQGuildRouterApi.openGuildInfoSetting(qBaseActivity, uu1.e.j(mission.getGuildId()), 0, 2);
                    break;
                } else {
                    wu1.a.f446537c.a(guildId, new String[]{"enter_setting", "click_management"});
                    break;
                }
            case 5:
                Context context4 = this.itemView.getContext();
                Intrinsics.checkNotNull(context4, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
                tu1.a.c((QBaseActivity) context4, guildId);
                break;
            case 6:
                break;
            default:
                throw new IllegalArgumentException("Illegal missionId");
        }
        View view = this.itemView;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_master_guide_type", Integer.valueOf(MissionId.INSTANCE.a(mission.getMissionId()))));
        VideoReport.reportEvent("clck", view, mapOf);
    }
}
