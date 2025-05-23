package uo1;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.message.aa;
import com.tencent.mobileqq.guild.report.g;
import com.tencent.mobileqq.guild.report.model.PushReportData;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.guild.widget.GuildLevelRoleView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCheckInNotifyInfo;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J2\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0016"}, d2 = {"Luo1/b;", "", "Landroid/content/Intent;", "contentIntent", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProCheckInNotifyInfo;", "checkInNotifyInfo", "", "b", "Lmqq/app/AppRuntime;", "app", "", "title", "contentText", "Landroid/graphics/Bitmap;", "icon", "Landroid/app/PendingIntent;", "pendingIntent", "f", "c", "d", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f439371a = new b();

    b() {
    }

    private final void b(Intent contentIntent, GProCheckInNotifyInfo checkInNotifyInfo) {
        AppInterface l3 = ch.l();
        Intrinsics.checkNotNullExpressionValue(l3, "appInterface()");
        PushReportData pushReportData = new PushReportData();
        pushReportData.setAction("receive");
        pushReportData.setUin(l3.getCurrentAccountUin());
        pushReportData.setTime(NetConnInfoCenter.getServerTime());
        pushReportData.setAppStatus(2);
        pushReportData.setPushType(PushReportData.PushType.PUSH_TYPE_CHECK_IN.ordinal());
        pushReportData.setGuildId(String.valueOf(checkInNotifyInfo.guildId));
        pushReportData.setChannelId(pushReportData.getGuildId());
        contentIntent.putExtra(PushReportData.GUILD_NOTIFY_REPORT, (Parcelable) pushReportData);
        Object businessHandler = l3.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildReportHandlerName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.guild.report.IGuildReportHandler");
        ((g) businessHandler).L0(pushReportData);
    }

    private final PendingIntent c(AppRuntime app, GProCheckInNotifyInfo checkInNotifyInfo) {
        JumpGuildParam jumpGuildParam = new JumpGuildParam(String.valueOf(checkInNotifyInfo.guildId), "");
        jumpGuildParam.extras.putString("PGIN_SOURCE_REPORT_KEY", "qq_push");
        Intent intent = ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).createGotoConversationGuildIntent(app.getApplicationContext(), jumpGuildParam);
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        b(intent, checkInNotifyInfo);
        PendingIntent activity = PendingIntent.getActivity(BaseApplication.context, NotificationUtil.Constants.NOTIFY_ID_GUILD_COMMON, intent, aa.F(app, 134217728));
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(\n           \u2026UPDATE_CURRENT)\n        )");
        return activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(AppRuntime appRuntime, String title, String contentText, PendingIntent pendingIntent, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(appRuntime, "$appRuntime");
        Intrinsics.checkNotNullParameter(contentText, "$contentText");
        Intrinsics.checkNotNullParameter(pendingIntent, "$pendingIntent");
        b bVar = f439371a;
        Intrinsics.checkNotNullExpressionValue(title, "title");
        bVar.f(appRuntime, title, contentText, bitmap, pendingIntent);
    }

    private final void f(AppRuntime app, String title, String contentText, Bitmap icon, PendingIntent pendingIntent) {
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        bigTextStyle.bigText(contentText);
        NotificationCompat.Builder contentIntent = new NotificationCompat.Builder(app.getApp()).setSmallIcon(tp1.a.g()).setLargeIcon(icon).setWhen(System.currentTimeMillis()).setContentTitle(title).setContentText(contentText).setAutoCancel(true).setPriority(2).setStyle(bigTextStyle).setTicker(contentText).setChannelId(QQNotificationManager.CHANNEL_ID_OTHER).setContentIntent(pendingIntent);
        Intrinsics.checkNotNullExpressionValue(contentIntent, "Builder(app.app)\n       \u2026tentIntent(pendingIntent)");
        QQNotificationManager.getInstance().notify("BaseGuildMessageProcessor.GuildS2CMessageProcessor", NotificationUtil.Constants.NOTIFY_ID_GUILD_COMMON, contentIntent.build());
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildCheckInPush", 2, "createSystemNotification " + title + " content=" + contentText);
        }
    }

    public final void d(@NotNull GProCheckInNotifyInfo checkInNotifyInfo) {
        Intrinsics.checkNotNullParameter(checkInNotifyInfo, "checkInNotifyInfo");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildCheckInPush", 2, "recGuildCheckInPush notification " + checkInNotifyInfo);
        }
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        IGPSService iGPSService = (IGPSService) runtimeService;
        String valueOf = String.valueOf(checkInNotifyInfo.guildId);
        IGProGuildInfo guildInfo = iGPSService.getGuildInfo(valueOf);
        if (guildInfo == null) {
            Logger.b bVar = new Logger.b();
            String str = "recGuildCheckInPush error null guildInfo key: " + valueOf;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildCheckInPush", 1, (String) it.next(), null);
            }
            return;
        }
        if (!iGPSService.isGuildMember(valueOf)) {
            Logger.b bVar2 = new Logger.b();
            String str2 = "recGuildCheckInPush error not guild member: " + valueOf;
            if (str2 instanceof String) {
                bVar2.a().add(str2);
            }
            Iterator<T> it5 = bVar2.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("GuildCheckInPush", 1, (String) it5.next(), null);
            }
            return;
        }
        String avatarUrl = guildInfo.getAvatarUrl(100);
        final PendingIntent c16 = c(peekAppRuntime, checkInNotifyInfo);
        final String guildName = guildInfo.getGuildName();
        final String str3 = checkInNotifyInfo.f359284msg;
        if (str3 == null) {
            str3 = "\u4eca\u5929\u8fd8\u6ca1\u6709\u5b8c\u6210\u7b7e\u5230\u54e6";
        }
        int f16 = QQGuildUIUtil.f(48.0f);
        v.f(avatarUrl, f16, f16, new GuildLevelRoleView.a() { // from class: uo1.a
            @Override // com.tencent.mobileqq.guild.widget.GuildLevelRoleView.a
            public final void a(Bitmap bitmap) {
                b.e(AppRuntime.this, guildName, str3, c16, bitmap);
            }
        });
    }
}
