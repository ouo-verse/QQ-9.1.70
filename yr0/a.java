package yr0;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.aio.data.AIOParam;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.util.h;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guildlive.utils.GuildLiveLogUtil;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IGuildLiveChannelApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.message.utils.IGuildDirectMsgUtilApi;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProTopMsg;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u000b\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u000e\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u001a\n\u0010\b\u001a\u00020\u0007*\u00020\u0006\u001a\n\u0010\t\u001a\u00020\u0001*\u00020\u0006\u001a\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0000\u001a.\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0001\u001a\u0010\u0010\u0013\u001a\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u0000\u001a\u0018\u0010\u0017\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u0001\u001a\u0016\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003\u001a\u0018\u0010\u001a\u001a\u00020\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0019\u001a\u00020\u0007\u001a\u000e\u0010\u001b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0000\u001a\u000e\u0010\u001c\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0000\u001a\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0000H\u0002\u001a2\u0010\"\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001e\u001a\u00020\u00032\u0018\b\u0002\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010\u001f\u001a2\u0010$\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0018\b\u0002\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010\u001f\"\"\u0010*\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)\u00a8\u0006+"}, d2 = {"Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "", "g", "", "guildId", "i", "Lcom/tencent/aio/api/runtime/a;", "", "a", "e", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "msgItem", "", "l", "channelId", "tinyId", "isRobot", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, h.F, "Landroid/view/View;", "view", "show", ReportConstant.COSTREPORT_PREFIX, "d", "seq", "j", "b", "k", "c", "id", "", "", "elementParams", "p", "eventId", DomainData.DOMAIN_NAME, "Z", "f", "()Z", "r", "(Z)V", "isLiveSpeakClose", "aio-guild-live_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f451053a;

    public static final long a(@NotNull com.tencent.aio.api.runtime.a aVar) {
        long coerceAtMost;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(Long.MAX_VALUE, aVar.g().l().getLong("extra_key_show_max_msg_seq"));
        return coerceAtMost;
    }

    @NotNull
    public static final String b(@NotNull GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        String nickFromMsg = msgItem.getMsgRecord().sendMemberName;
        if (com.tencent.guild.aio.util.h.f112401a.a(msgItem) && !TextUtils.isEmpty(nickFromMsg)) {
            Intrinsics.checkNotNullExpressionValue(nickFromMsg, "nickFromMsg");
            return nickFromMsg;
        }
        String c16 = c(msgItem);
        if (TextUtils.isEmpty(c16)) {
            if (!TextUtils.isEmpty(nickFromMsg)) {
                Intrinsics.checkNotNullExpressionValue(nickFromMsg, "nickFromMsg");
                return nickFromMsg;
            }
            String str = msgItem.getMsgRecord().sendNickName;
            Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.sendNickName");
            return str;
        }
        return c16;
    }

    private static final String c(GuildMsgItem guildMsgItem) {
        String guildId = guildMsgItem.getMsgRecord().guildId;
        IGuildDirectMsgUtilApi iGuildDirectMsgUtilApi = (IGuildDirectMsgUtilApi) QRoute.api(IGuildDirectMsgUtilApi.class);
        String str = guildMsgItem.getMsgRecord().peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "it.msgRecord.peerUid");
        long sourceGuildId = iGuildDirectMsgUtilApi.getSourceGuildId(str);
        if (sourceGuildId != 0) {
            guildId = String.valueOf(sourceGuildId);
        }
        String str2 = guildMsgItem.getMsgRecord().senderUid.toString();
        Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
        return iq0.a.u(str2, guildId);
    }

    public static final boolean d(@NotNull String guildId, @NotNull String channelId) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IGProGuildInfo iGProGuildInfo = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGProGuildInfo = iGPSService.getGuildInfo(guildId);
        }
        if (((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).isQQGuildManager(iGProGuildInfo)) {
            return true;
        }
        Boolean hasTargetSecondaryPermission = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).hasTargetSecondaryPermission(30004, guildId, channelId);
        Intrinsics.checkNotNullExpressionValue(hasTargetSecondaryPermission, "api(IQQGuildUtilApi::cla\u2026,\n        channelId\n    )");
        return hasTargetSecondaryPermission.booleanValue();
    }

    public static final boolean e(@NotNull com.tencent.aio.api.runtime.a aVar) {
        AppInterface appInterface;
        ArrayList<IGProTopMsg> topMsgList;
        Object lastOrNull;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        IQQGuildUtilApi iQQGuildUtilApi = (IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class);
        AIOParam aioParam = aVar.g();
        Intrinsics.checkNotNullExpressionValue(aioParam, "aioParam");
        String g16 = com.tencent.guild.aio.util.a.g(aioParam);
        AIOParam aioParam2 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(aioParam2, "aioParam");
        Boolean hasPermission = iQQGuildUtilApi.hasTargetSecondaryPermission(30004, g16, com.tencent.guild.aio.util.a.b(aioParam2));
        Intrinsics.checkNotNullExpressionValue(hasPermission, "hasPermission");
        if (hasPermission.booleanValue() || ((IGuildLiveChannelApi) QRoute.api(IGuildLiveChannelApi.class)).isSelfLiving()) {
            return true;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService == null) {
            return false;
        }
        AIOParam aioParam3 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(aioParam3, "aioParam");
        IGProChannelInfo channelInfo = iGPSService.getChannelInfo(com.tencent.guild.aio.util.a.b(aioParam3));
        if (channelInfo != null && (topMsgList = channelInfo.getTopMsgList()) != null) {
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) topMsgList);
            IGProTopMsg iGProTopMsg = (IGProTopMsg) lastOrNull;
            if (iGProTopMsg != null) {
                return Intrinsics.areEqual(String.valueOf(iGProTopMsg.getTopMsgOperatorTinyId()), iGPSService.getSelfTinyId());
            }
        }
        return false;
    }

    public static final boolean f() {
        return f451053a;
    }

    public static final boolean g(@NotNull GuildMsgItem guildMsgItem) {
        Intrinsics.checkNotNullParameter(guildMsgItem, "<this>");
        if (guildMsgItem.isLocalSend() && guildMsgItem.getMsgRecord().sendStatus != 2) {
            return false;
        }
        return true;
    }

    public static final boolean h(@Nullable GuildMsgItem guildMsgItem) {
        MsgRecord msgRecord;
        if (guildMsgItem == null || (msgRecord = guildMsgItem.getMsgRecord()) == null || msgRecord.fromAppid != GuildMsgItem.ROBOT_MSG_FLAG) {
            return false;
        }
        return true;
    }

    public static final boolean i(@NotNull String guildId) {
        AppInterface appInterface;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            return iGPSService.isGuest(guildId);
        }
        return true;
    }

    public static final boolean j(@Nullable String str, long j3) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        String str2;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IGProChannelInfo iGProChannelInfo = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        String str3 = "";
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            str2 = iGPSService.getSelfTinyId();
        } else {
            str2 = null;
        }
        if (str2 != null) {
            str3 = str2;
        }
        if (iGPSService != null) {
            iGProChannelInfo = iGPSService.getChannelInfo(str);
        }
        if (iGProChannelInfo == null || iGProChannelInfo.getTopMsgList() == null) {
            return false;
        }
        Iterator<IGProTopMsg> it = iGProChannelInfo.getTopMsgList().iterator();
        while (it.hasNext()) {
            IGProTopMsg next = it.next();
            if (next.getTopMsgSeq() == j3) {
                return Intrinsics.areEqual(String.valueOf(next.getTopMsgOperatorTinyId()), str3);
            }
        }
        return false;
    }

    public static final boolean k(@NotNull GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        h.MemberRoleInfo d16 = com.tencent.guild.aio.util.h.f112401a.d(msgItem);
        if (d16 == null || d16.getType() != 6) {
            return false;
        }
        return true;
    }

    public static final void l(@NotNull Activity activity, @NotNull GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        String str = msgItem.getMsgRecord().guildId;
        Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.guildId");
        String str2 = msgItem.getMsgRecord().peerUid;
        Intrinsics.checkNotNullExpressionValue(str2, "msgItem.msgRecord.peerUid");
        String str3 = msgItem.getMsgRecord().senderUid;
        Intrinsics.checkNotNullExpressionValue(str3, "msgItem.msgRecord.senderUid");
        m(activity, str, str2, str3, h(msgItem));
    }

    public static final void m(@NotNull Activity activity, @NotNull String guildId, @NotNull String channelId, @NotNull String tinyId, boolean z16) {
        String str;
        JumpGuildParam.JoinInfoParam joinInfoParam;
        JumpGuildParam.JoinInfoParam joinInfoParam2;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        if (((IGuildLiveChannelApi) QRoute.api(IGuildLiveChannelApi.class)).guildLiveVideoIsLandScreenState()) {
            GuildLiveLogUtil.INSTANCE.e("LiveAioExt", "[openGuildMemberCard] is LandScreenState");
            return;
        }
        Bundle startParamsBundle = ((IGuildLiveChannelApi) QRoute.api(IGuildLiveChannelApi.class)).getStartParamsBundle();
        String str2 = null;
        if (startParamsBundle != null && (joinInfoParam2 = (JumpGuildParam.JoinInfoParam) startParamsBundle.getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM)) != null) {
            str = joinInfoParam2.getMainSource();
        } else {
            str = null;
        }
        String str3 = "";
        if (str == null) {
            str = "";
        }
        if (startParamsBundle != null && (joinInfoParam = (JumpGuildParam.JoinInfoParam) startParamsBundle.getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM)) != null) {
            str2 = joinInfoParam.getSubSource();
        }
        if (str2 != null) {
            str3 = str2;
        }
        GuildProfileData guildProfileData = new GuildProfileData(guildId, channelId, tinyId, 2, GuildProfileData.getSceneTypeBySource(str, str3, 4));
        guildProfileData.getGuildBaseProfileData().r(channelId);
        guildProfileData.getGuildBaseProfileData().y(z16);
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openGuildProfileDialog(activity, guildProfileData);
    }

    public static final void n(@NotNull String eventId, @Nullable View view, @Nullable Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
    }

    public static /* synthetic */ void o(String str, View view, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        n(str, view, map);
    }

    public static final void p(@Nullable View view, @NotNull String id5, @Nullable Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(id5, "id");
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put("dt_pgid", "pg_sgrp_stream_aio");
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(view, id5, hashMap);
    }

    public static /* synthetic */ void q(View view, String str, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        p(view, str, map);
    }

    public static final void r(boolean z16) {
        f451053a = z16;
    }

    public static final void s(@Nullable View view, boolean z16) {
        int i3;
        if (view != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }
}
