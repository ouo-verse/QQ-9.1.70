package yf1;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingMviContext;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingUIState;
import com.tencent.mobileqq.guild.channel.managev2.b;
import com.tencent.mobileqq.guild.channel.managev2.item.arrowform.h;
import com.tencent.mobileqq.guild.channel.managev2.utils.ChannelSettingUtils;
import com.tencent.mobileqq.guild.media.thirdapp.widget.GuildMediaActivityPermissionExampleDialogFragment;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.GuildOpenBindPermissionUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.df;
import com.tencent.mobileqq.qqguildsdk.data.dx;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016\u00a8\u0006\u0015"}, d2 = {"Lyf1/f;", "Lcom/tencent/mobileqq/guild/channel/managev2/item/arrowform/h;", "Landroid/view/View;", "view", "", ReportConstant.COSTREPORT_PREFIX, "u", "t", "v", "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingMviContext;", "context", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/qqguildsdk/data/dx;", "permissionInfo", "r", "p", "Lcom/tencent/mobileqq/guild/channel/managev2/b;", "intent", "o", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class f extends h {
    private final void s(View view) {
        DeviceType a16 = PadUtil.a(BaseApplication.getContext());
        if (a16 != DeviceType.TABLET && a16 != DeviceType.FOLD) {
            u();
        } else {
            t();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void t() {
        FragmentActivity requireActivity = ((ChannelSettingMviContext) getMContext()).c().requireActivity();
        if (requireActivity == null) {
            return;
        }
        FragmentManager supportFragmentManager = requireActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        supportFragmentManager.beginTransaction().add(new GuildMediaActivityPermissionExampleDialogFragment(), "GuildMediaThirdPartPermissionExampleDialogFragment").commitAllowingStateLoss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void u() {
        ((ChannelSettingMviContext) getMContext()).c().getChildFragmentManager().beginTransaction().add(new GuildMediaActivityPermissionExampleDialogFragment(), "GuildMediaThirdPartPermissionExampleDialogFragment").commitAllowingStateLoss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v(View view) {
        Map mapOf;
        ArrayList<df> authControlStatusList = ((ChannelSettingMviContext) getMContext()).getParams().getChannelInfo().getAuthControlStatusList();
        Intrinsics.checkNotNullExpressionValue(authControlStatusList, "mContext.params.channelInfo.authControlStatusList");
        int i3 = 1;
        for (df dfVar : authControlStatusList) {
            if (dfVar.getAuthControlKey() == 5 && dfVar.getAuthControlValue() == 1) {
                i3 = 2;
            }
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_channel_set_authority", Integer.valueOf(i3)));
        ChannelSettingUtils.i(view, "em_sgrp_channel_set_playmodule", mapOf);
    }

    @Override // com.tencent.mobileqq.guild.channel.managev2.item.arrowform.h, com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: o */
    public void handleIntent(@NotNull com.tencent.mobileqq.guild.channel.managev2.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof b.a) {
            s(((b.a) intent).getView());
        } else {
            super.handleIntent(intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.channel.managev2.item.arrowform.h
    public void p(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        v(view);
        Context context = ((ChannelSettingMviContext) getMContext()).c().getContext();
        if (context != null) {
            GuildOpenBindPermissionUtils.t(context, ((ChannelSettingMviContext) getMContext()).getParams().getChannelInfo());
        }
    }

    @Override // com.tencent.mobileqq.guild.channel.managev2.item.arrowform.h
    public void q(@NotNull ChannelSettingMviContext context) {
        ArrayList arrayList;
        String desc;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(context, "context");
        Logger.a d16 = Logger.f235387a.d();
        String channelId = context.getParams().getChannelId();
        ArrayList<df> authControlStatusList = context.getParams().getChannelInfo().getAuthControlStatusList();
        if (authControlStatusList != null) {
            Intrinsics.checkNotNullExpressionValue(authControlStatusList, "authControlStatusList");
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(authControlStatusList, 10);
            arrayList = new ArrayList(collectionSizeOrDefault);
            for (df dfVar : authControlStatusList) {
                arrayList.add(dfVar.getAuthControlKey() + " " + dfVar.getAuthControlValue() + ",");
            }
        } else {
            arrayList = null;
        }
        d16.d("Guild.mnr.ChannelSettingArrowFormBaseViewModel", 1, "openActivity cId:" + channelId + " statusList:" + arrayList);
        if (context.getParams().getChannelInfo().getAuthControlStatusList().isEmpty()) {
            String qqStr = HardCodeUtil.qqStr(R.string.f139560bl);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_all_menber)");
            updateUI(new ChannelSettingUIState.SettingItemDescUIState(qqStr));
            return;
        }
        ArrayList<df> authControlStatusList2 = context.getParams().getChannelInfo().getAuthControlStatusList();
        Intrinsics.checkNotNullExpressionValue(authControlStatusList2, "context.params.channelInfo.authControlStatusList");
        for (df dfVar2 : authControlStatusList2) {
            if (dfVar2.getAuthControlKey() == 5) {
                int authControlValue = dfVar2.getAuthControlValue();
                if (authControlValue != 0) {
                    if (authControlValue != 1) {
                        desc = HardCodeUtil.qqStr(R.string.f139560bl);
                    } else {
                        desc = HardCodeUtil.qqStr(R.string.f156951ll);
                    }
                } else {
                    desc = HardCodeUtil.qqStr(R.string.f139560bl);
                }
                Intrinsics.checkNotNullExpressionValue(desc, "desc");
                updateUI(new ChannelSettingUIState.SettingItemDescUIState(desc));
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.channel.managev2.item.arrowform.h
    public void r(@NotNull dx permissionInfo) {
        Intrinsics.checkNotNullParameter(permissionInfo, "permissionInfo");
        updateUI(new ChannelSettingUIState.SettingItemEnableUIState(permissionInfo.a(20013)));
    }
}
