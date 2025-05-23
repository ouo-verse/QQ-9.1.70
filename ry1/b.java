package ry1;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.message.aa;
import com.tencent.mobileqq.guild.report.g;
import com.tencent.mobileqq.guild.report.model.PushReportData;
import com.tencent.mobileqq.guild.schedule.detail.GuildScheduleDetailFragment;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.guild.widget.GuildLevelRoleView;
import com.tencent.mobileqq.mini.servlet.GetGuildJoinUrlServlet;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProOtherJumpAddress;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleNotifyInfo;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J2\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\bH\u0002J\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002J2\u0010\u001d\u001a\u00020\u000f2\"\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0018j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00192\u0006\u0010\u001c\u001a\u00020\u001b\u00a8\u0006 "}, d2 = {"Lry1/b;", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProScheduleNotifyInfo;", "scheduleNotifyInfo", "", "i", "Lmqq/app/AppRuntime;", "app", "Landroid/app/PendingIntent;", "d", "b", "Landroid/content/Intent;", "contentIntent", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProScheduleInfo;", GameCenterUtil.CONF_KEY_SCHEDULE_INFO, "", "c", "title", "contentText", "Landroid/graphics/Bitmap;", "icon", "pendingIntent", h.F, "f", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", Node.ATTRS_ATTR, "Landroid/content/Context;", "context", "e", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f432950a = new b();

    b() {
    }

    private final String b(GProScheduleNotifyInfo scheduleNotifyInfo) {
        String str = "mqqapi://guild/schedule_notify" + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + "guildid" + ContainerUtils.KEY_VALUE_DELIMITER + String.valueOf(scheduleNotifyInfo.guildId) + ContainerUtils.FIELD_DELIMITER + "channelid" + ContainerUtils.KEY_VALUE_DELIMITER + String.valueOf(scheduleNotifyInfo.channelId) + ContainerUtils.FIELD_DELIMITER + "scheduleid" + ContainerUtils.KEY_VALUE_DELIMITER + String.valueOf(scheduleNotifyInfo.scheduleInfo.scheduleId) + ContainerUtils.FIELD_DELIMITER + "jump_channel_id" + ContainerUtils.KEY_VALUE_DELIMITER + scheduleNotifyInfo.scheduleInfo.channelInfo.channelId;
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder(JumpConsta\u2026)\n            .toString()");
        return str;
    }

    private final void c(Intent contentIntent, GProScheduleInfo scheduleInfo) {
        AppInterface l3 = ch.l();
        Intrinsics.checkNotNullExpressionValue(l3, "appInterface()");
        PushReportData pushReportData = new PushReportData();
        pushReportData.setAction("receive");
        pushReportData.setUin(l3.getCurrentAccountUin());
        pushReportData.setTime(NetConnInfoCenter.getServerTime());
        pushReportData.setAppStatus(2);
        pushReportData.setPushType(PushReportData.PushType.PUSH_TYPE_SCHEDULE.ordinal());
        pushReportData.setGuildId(String.valueOf(scheduleInfo.channelInfo.guildId));
        pushReportData.setChannelId(String.valueOf(scheduleInfo.channelInfo.channelId));
        pushReportData.setSenderTinyId(String.valueOf(scheduleInfo.creator.tinyId));
        pushReportData.setChannelType(11);
        pushReportData.setScheduleId(String.valueOf(scheduleInfo.scheduleId));
        contentIntent.putExtra(PushReportData.GUILD_NOTIFY_REPORT, (Parcelable) pushReportData);
        Object businessHandler = l3.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildReportHandlerName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.guild.report.IGuildReportHandler");
        ((g) businessHandler).L0(pushReportData);
    }

    private final PendingIntent d(AppRuntime app, GProScheduleNotifyInfo scheduleNotifyInfo) {
        String b16;
        Intent intent;
        long serverTime = NetConnInfoCenter.getServerTime() * 1000;
        GProScheduleInfo scheduleInfo = scheduleNotifyInfo.scheduleInfo;
        if (serverTime < scheduleInfo.startTimeMs) {
            intent = ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).createConversationTabUrlIntent(app.getApplicationContext(), b(scheduleNotifyInfo));
            Intrinsics.checkNotNullExpressionValue(intent, "api(IGuildMainFrameApi::\u2026licationContext, jumpUrl)");
        } else if (!GuildMainFrameUtils.q(String.valueOf(scheduleInfo.channelInfo.channelId))) {
            JumpGuildParam jumpGuildParam = new JumpGuildParam(String.valueOf(scheduleInfo.channelInfo.guildId), String.valueOf(scheduleInfo.channelInfo.channelId));
            jumpGuildParam.extras.putString("PGIN_SOURCE_REPORT_KEY", "qq_push");
            intent = ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).createGotoConversationGuildIntent(app.getApplicationContext(), jumpGuildParam);
            Intrinsics.checkNotNullExpressionValue(intent, "api(IGuildMainFrameApi::\u2026nContext, jumpGuildParam)");
        } else {
            GProOtherJumpAddress gProOtherJumpAddress = scheduleInfo.otherJumpAddress;
            if (gProOtherJumpAddress.addressType == 1) {
                b16 = gProOtherJumpAddress.address;
                Intrinsics.checkNotNullExpressionValue(b16, "{\n                    sc\u2026address\n                }");
            } else {
                b16 = b(scheduleNotifyInfo);
            }
            Intent createConversationTabUrlIntent = ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).createConversationTabUrlIntent(app.getApplicationContext(), b16);
            Intrinsics.checkNotNullExpressionValue(createConversationTabUrlIntent, "api(IGuildMainFrameApi::\u2026licationContext, jumpUrl)");
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.sch.GuildSchedulePush", 2, "jump url " + b16);
            }
            intent = createConversationTabUrlIntent;
        }
        Intrinsics.checkNotNullExpressionValue(scheduleInfo, "scheduleInfo");
        c(intent, scheduleInfo);
        PendingIntent activity = PendingIntent.getActivity(BaseApplication.context, NotificationUtil.Constants.NOTIFY_ID_GUILD_COMMON, intent, aa.F(app, 134217728));
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(\n           \u2026UPDATE_CURRENT)\n        )");
        return activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(AppRuntime appRuntime, String title, String contentText, PendingIntent pendingIntent, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(appRuntime, "$appRuntime");
        Intrinsics.checkNotNullParameter(contentText, "$contentText");
        Intrinsics.checkNotNullParameter(pendingIntent, "$pendingIntent");
        b bVar = f432950a;
        Intrinsics.checkNotNullExpressionValue(title, "title");
        bVar.h(appRuntime, title, contentText, bitmap, pendingIntent);
    }

    private final void h(AppRuntime app, String title, String contentText, Bitmap icon, PendingIntent pendingIntent) {
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        bigTextStyle.bigText(contentText);
        NotificationCompat.Builder contentIntent = new NotificationCompat.Builder(app.getApp()).setSmallIcon(tp1.a.g()).setLargeIcon(icon).setWhen(System.currentTimeMillis()).setContentTitle(title).setContentText(contentText).setAutoCancel(true).setPriority(2).setStyle(bigTextStyle).setTicker(contentText).setChannelId(QQNotificationManager.CHANNEL_ID_OTHER).setContentIntent(pendingIntent);
        Intrinsics.checkNotNullExpressionValue(contentIntent, "Builder(app.app)\n       \u2026tentIntent(pendingIntent)");
        QQNotificationManager.getInstance().notify("BaseGuildMessageProcessor.GuildS2CMessageProcessor", NotificationUtil.Constants.NOTIFY_ID_GUILD_COMMON, contentIntent.build());
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.sch.GuildSchedulePush", 2, "createSystemNotification " + title + " content=" + contentText);
        }
    }

    private final String i(GProScheduleNotifyInfo scheduleNotifyInfo) {
        long serverTime = NetConnInfoCenter.getServerTime() * 1000;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            GProScheduleInfo gProScheduleInfo = scheduleNotifyInfo.scheduleInfo;
            d16.d("Guild.sch.GuildSchedulePush", 2, "getServerTime " + serverTime + ", schedule start time: " + gProScheduleInfo.startTimeMs + ", end time: " + gProScheduleInfo.endTimeMs);
        }
        GProScheduleInfo gProScheduleInfo2 = scheduleNotifyInfo.scheduleInfo;
        if (serverTime < gProScheduleInfo2.startTimeMs) {
            return "[\u65b0\u65e5\u7a0b]\u7ba1\u7406\u5458\u9080\u8bf7\u4f60\u9884\u7ea6\u65e5\u7a0b\uff1a";
        }
        if (serverTime > gProScheduleInfo2.endTimeMs) {
            return "[\u65e5\u7a0b\u7ed3\u675f]";
        }
        return "[\u65e5\u7a0b\u5f00\u59cb]\u4f60\u9884\u7ea6\u7684\u65e5\u7a0b\u5df2\u5f00\u59cb\uff1a";
    }

    public final void e(@NotNull HashMap<String, String> attrs, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        Intrinsics.checkNotNullParameter(context, "context");
        if (!(context instanceof Activity)) {
            QLog.e("Guild.sch.GuildSchedulePush", 1, "openScheduleNotify,context is not activity");
            return;
        }
        String str = attrs.get("guildid");
        String str2 = attrs.get("channelid");
        String str3 = attrs.get("scheduleid");
        IGProGuildInfo L = ch.L(str);
        if (L != null && L.isMember()) {
            QLog.d("Guild.sch.GuildSchedulePush", 1, "openScheduleNotify guildId:", str, " channelId:", str2, " scheduleId:", str3);
            Intent intent = GuildScheduleDetailFragment.ai(context, null, str, str2, str3, new JumpGuildParam(str, str2));
            intent.putExtra(GetGuildJoinUrlServlet.BUNDLE_KEY_URL, "");
            ty1.a.i("gpro_quality#event#schedule_channel_detail", null, 2, null);
            GuildSplitViewUtils guildSplitViewUtils = GuildSplitViewUtils.f235370a;
            Intrinsics.checkNotNullExpressionValue(intent, "intent");
            GuildSplitViewUtils.p(guildSplitViewUtils, context, intent, GuildScheduleDetailFragment.class, null, 8, null);
            return;
        }
        QLog.e("Guild.sch.GuildSchedulePush", 1, "openScheduleNotify, guildInfo is null or is not member.");
    }

    public final void f(@NotNull GProScheduleNotifyInfo scheduleNotifyInfo) {
        final AppRuntime peekAppRuntime;
        Intrinsics.checkNotNullParameter(scheduleNotifyInfo, "scheduleNotifyInfo");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.sch.GuildSchedulePush", 2, "onGuildScheduleNotify notification " + scheduleNotifyInfo);
        }
        if (!scheduleNotifyInfo.needNotify || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        IGPSService iGPSService = (IGPSService) runtimeService;
        String valueOf = String.valueOf(scheduleNotifyInfo.guildId);
        String valueOf2 = String.valueOf(scheduleNotifyInfo.channelId);
        IGProGuildInfo guildInfo = iGPSService.getGuildInfo(valueOf);
        if (guildInfo == null) {
            Logger.b bVar = new Logger.b();
            String str = "onGuildScheduleNotify error null guildInfo key: " + valueOf;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.sch.GuildSchedulePush", 1, (String) it.next(), null);
            }
            return;
        }
        if (iGPSService.getChannelInfo(valueOf2) == null) {
            Logger.b bVar2 = new Logger.b();
            String str2 = "onGuildScheduleNotify error null channelInfo key: " + valueOf2;
            if (str2 instanceof String) {
                bVar2.a().add(str2);
            }
            Iterator<T> it5 = bVar2.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("Guild.sch.GuildSchedulePush", 1, (String) it5.next(), null);
            }
            return;
        }
        String avatarUrl = guildInfo.getAvatarUrl(100);
        final PendingIntent d16 = d(peekAppRuntime, scheduleNotifyInfo);
        final String guildName = guildInfo.getGuildName();
        final String str3 = i(scheduleNotifyInfo) + scheduleNotifyInfo.scheduleInfo.title;
        int f16 = QQGuildUIUtil.f(48.0f);
        v.f(avatarUrl, f16, f16, new GuildLevelRoleView.a() { // from class: ry1.a
            @Override // com.tencent.mobileqq.guild.widget.GuildLevelRoleView.a
            public final void a(Bitmap bitmap) {
                b.g(AppRuntime.this, guildName, str3, d16, bitmap);
            }
        });
    }
}
