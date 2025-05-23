package sx1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.google.gson.Gson;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildWebApi;
import com.tencent.mobileqq.guild.config.QQGuildMCBean;
import com.tencent.mobileqq.guild.media.core.EnterChannelState;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.core.data.r;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.robot.api.model.GuildChannel;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfo;
import com.tencent.mobileqq.guild.robot.components.guilds.RobotCommonGuildFragment;
import com.tencent.mobileqq.guild.util.bs;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.bv;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotClientInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotData;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotInfoRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGProFetchGuildRobotInfoCallback;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import sx1.a;
import sx1.f;

/* compiled from: P */
/* loaded from: classes14.dex */
public class f {

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements IGProFetchGuildRobotInfoCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RobotInfo f434927a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f434928b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f434929c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f434930d;

        a(RobotInfo robotInfo, int i3, String str, Activity activity) {
            this.f434927a = robotInfo;
            this.f434928b = i3;
            this.f434929c = str;
            this.f434930d = activity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void c(Activity activity, int i3) {
            QQToast.makeText(activity, 4, i3, 0).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void d(Activity activity, RobotCommonGuildFragment robotCommonGuildFragment) {
            if (activity instanceof FragmentActivity) {
                robotCommonGuildFragment.show(((FragmentActivity) activity).getSupportFragmentManager(), RobotCommonGuildFragment.class.getName());
            }
        }

        private void e(int i3, String str) {
            final int i16;
            QLog.e("RobotUtil", 1, "openRobotCommonGuildFragment | result = " + i3 + " errMsg=" + str);
            if (i3 == 10010) {
                i16 = R.string.f154291ee;
            } else {
                i16 = R.string.f154081du;
            }
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final Activity activity = this.f434930d;
            uIHandlerV2.post(new Runnable() { // from class: sx1.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.a.c(activity, i16);
                }
            });
        }

        private void f(GProGuildRobotInfoRsp gProGuildRobotInfoRsp) {
            GProGuildRobotData robotData = gProGuildRobotInfoRsp.getRobotData();
            this.f434927a.u(robotData.getRobotUin());
            if (this.f434927a.k() == 0) {
                this.f434927a.t(robotData.getRobotTid());
            }
            this.f434927a.s(robotData.getRobotName());
            this.f434927a.q(robotData.getRobotAvatar());
            this.f434927a.r(robotData.getRobotDesc());
            HashMap hashMap = new HashMap();
            hashMap.put("qq_robot_invite_state", Integer.valueOf(robotData.getShowInvite()));
            hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
            hashMap.put("qq_robot_role_type", Integer.valueOf(gProGuildRobotInfoRsp.getRole()));
            hashMap.put("qq_robot_robot_id", Long.valueOf(robotData.getRobotUin()));
            hashMap.put("qq_robot_user_from", Integer.valueOf(this.f434928b));
            hashMap.put("qq_robot_robot_role_type", Integer.valueOf(gProGuildRobotInfoRsp.getRole()));
            hashMap.put("qq_robot_channel_id", this.f434929c);
            hashMap.put("qq_robot_channel_name", robotData.getRobotName());
            Gson gson = new Gson();
            Bundle bundle = new Bundle();
            bundle.putString("ROBOT_INFO_KEY", gson.toJson(this.f434927a));
            bundle.putSerializable("ROBOT_COMMON_GUILD_DA_TONG_DATA", hashMap);
            final RobotCommonGuildFragment robotCommonGuildFragment = new RobotCommonGuildFragment();
            robotCommonGuildFragment.setArguments(bundle);
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final Activity activity = this.f434930d;
            uIHandlerV2.post(new Runnable() { // from class: sx1.d
                @Override // java.lang.Runnable
                public final void run() {
                    f.a.d(activity, robotCommonGuildFragment);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGProFetchGuildRobotInfoCallback
        public void onFetchGuildRobotInfo(int i3, String str, GProGuildRobotInfoRsp gProGuildRobotInfoRsp) {
            if (i3 == 0 && gProGuildRobotInfoRsp != null) {
                f(gProGuildRobotInfoRsp);
            } else {
                e(i3, str);
            }
        }
    }

    @NonNull
    public static GProGuildRobotInfoReq b(GuildChannel guildChannel, RobotInfo robotInfo, int i3) {
        return new GProGuildRobotInfoReq(guildChannel.b(), robotInfo.l(), robotInfo.k(), guildChannel.a(), d(), i3, robotInfo.c(), 0L);
    }

    public static void c(AppRuntime appRuntime, String str, String str2) {
        Context applicationContext;
        byte[] bytes;
        if (appRuntime == null || (applicationContext = appRuntime.getApplicationContext()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("hide_more_button", false);
        bundle.putBoolean("hide_operation_bar", true);
        if (str2 == null) {
            bytes = null;
        } else {
            bytes = str2.getBytes(StandardCharsets.UTF_8);
        }
        bundle.putByteArray("SafeReportData", bytes);
        ((IGuildWebApi) QRoute.api(IGuildWebApi.class)).openWebUrlOnlyForGuild(applicationContext, str, bundle, null, null);
    }

    public static GProGuildRobotClientInfo d() {
        return new GProGuildRobotClientInfo(2, AppSetting.f99551k, Integer.parseInt(AppSetting.f99542b));
    }

    public static boolean e(String str) {
        boolean z16;
        if (j.c().l().getValue() == EnterChannelState.IDLE) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return false;
        }
        r userInfoList = j.c().getUserInfoList();
        if (userInfoList.f228125a != null && userInfoList.f228125a.size() != 0) {
            Iterator<p> it = userInfoList.f228125a.iterator();
            while (it.hasNext()) {
                String str2 = it.next().f228093a;
                if (str2 != null && str2.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static xw1.c f() {
        bs bsVar = bs.f235483a;
        QQGuildMCBean.c guildRobotInline = bsVar.h("100567").getGuildConfigBean().getGuildRobotInline();
        xw1.c cVar = new xw1.c();
        if (guildRobotInline.getEnableRobotInline() == 0) {
            QLog.i("RobotUtil", 1, "getRobotConfig: mEnableRobotInline is false");
        }
        cVar.g(Integer.valueOf(guildRobotInline.getEnableRobotInline()));
        if (guildRobotInline.getRobotInlineCacheDuration() > 0) {
            cVar.f(Long.valueOf(guildRobotInline.getRobotInlineCacheDuration()));
        }
        if (guildRobotInline.getRobotInlineRequestTimeout() > 0) {
            cVar.i(Integer.valueOf(guildRobotInline.getRobotInlineRequestTimeout()));
        }
        if (guildRobotInline.getRobotInlineTypeTimeout() > 0) {
            cVar.l(Integer.valueOf(guildRobotInline.getRobotInlineTypeTimeout()));
        }
        QQGuildMCBean.d robotSlashCmd = bsVar.h("100593").getGuildConfigBean().getRobotSlashCmd();
        cVar.h(Integer.valueOf(robotSlashCmd.getIsSupportSlash()));
        if (robotSlashCmd.getRobotSlashCmdCacheDuration() > 0) {
            cVar.k(Integer.valueOf(robotSlashCmd.getRobotSlashCmdCacheDuration()));
        }
        cVar.j(Integer.valueOf(robotSlashCmd.getRobotSlashCmdCacheCapacity()));
        return cVar;
    }

    @Nullable
    public static ac g() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("RobotUtil", 1, "peekAppRuntime is null");
            return null;
        }
        return ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).getRobotService();
    }

    public static boolean h(String str, String str2) {
        if (sx1.a.c(str, str2, 0, 1, 31, new a.b()) != null) {
            return true;
        }
        return false;
    }

    public static boolean i(int i3, int i16) {
        if (i3 == 2) {
            return true;
        }
        if (i3 == 1 && i16 != 1) {
            return true;
        }
        return false;
    }

    public static boolean j(Context context) {
        double d16;
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            d16 = Math.sqrt(Math.pow(displayMetrics.widthPixels / displayMetrics.xdpi, 2.0d) + Math.pow(displayMetrics.heightPixels / displayMetrics.ydpi, 2.0d));
        } catch (Throwable th5) {
            QLog.d("RobotUtil", 1, "isTablet", th5);
            d16 = 0.0d;
        }
        if (d16 > 6.5d) {
            return true;
        }
        return false;
    }

    public static void k(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                ((IGuildWebApi) QRoute.api(IGuildWebApi.class)).openWebUrlOnlyForGuild(context, str, null, null, null);
            } catch (Exception e16) {
                QLog.i("RobotUtil", 1, e16.toString());
            }
        }
    }

    public static void l(Activity activity, String str, String str2, String str3, String str4, int i3, int i16) {
        ac g16 = g();
        if (g16 == null) {
            return;
        }
        RobotInfo robotInfo = new RobotInfo();
        robotInfo.p(bv.b(str, 0L));
        robotInfo.n(bv.b(str2, 0L));
        robotInfo.t(bv.b(str3, 0L));
        robotInfo.u(bv.b(str4, 0L));
        robotInfo.o(i16);
        g16.fetchGuildRobotInfo(new GProGuildRobotInfoReq(robotInfo.e(), robotInfo.l(), robotInfo.k(), robotInfo.b(), d(), 0, robotInfo.c(), robotInfo.a()), new a(robotInfo, i3, str, activity));
    }

    public static void a() {
    }
}
