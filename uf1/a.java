package uf1;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.guild.api.IGuildStandalonePageOpenApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.standalone.GuildStandaloneDialogAttachFragment;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f438878a;

    /* renamed from: b, reason: collision with root package name */
    private String f438879b;

    /* renamed from: c, reason: collision with root package name */
    private int f438880c;

    /* renamed from: d, reason: collision with root package name */
    private JumpGuildParam.JoinInfoParam f438881d;

    /* renamed from: e, reason: collision with root package name */
    private GuildAppReportSourceInfo f438882e;

    /* renamed from: f, reason: collision with root package name */
    private final String f438883f = "biz@" + hashCode();

    public a(Bundle bundle) {
        this.f438878a = bundle.getString("guild_id", "");
        this.f438879b = bundle.getString("channelId", "");
        this.f438881d = (JumpGuildParam.JoinInfoParam) bundle.getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM);
        this.f438882e = (GuildAppReportSourceInfo) bundle.getParcelable("GuildAppReportSourceInfo");
        this.f438880c = bundle.getInt(JumpGuildParam.EXTRA_KEY_CHANNEL_LOAD_FROM, 0);
        i(this.f438878a, this.f438879b);
    }

    private int e() {
        int i3 = this.f438880c;
        if (i3 != 2 && i3 != 3) {
            return 0;
        }
        return 1;
    }

    public boolean a() {
        return k();
    }

    public void b() {
        if (k()) {
            QLog.d("Guild.jump.GuildChannelLoadProxyManager", 1, "doOnChannelCreate setChannelPageSourceType 3");
            ((IGuildStandalonePageOpenApi) QRoute.api(IGuildStandalonePageOpenApi.class)).setChannelPageSourceType(this.f438883f, 3);
        }
    }

    public void c(boolean z16) {
        if (k() && z16) {
            QLog.d("Guild.jump.GuildChannelLoadProxyManager", 1, "doOnChannelFinish unSetChannelPageSourceType");
            ((IGuildStandalonePageOpenApi) QRoute.api(IGuildStandalonePageOpenApi.class)).unSetChannelPageSourceType(this.f438883f);
        }
    }

    public JumpGuildParam d() {
        JumpGuildParam.JoinInfoParam joinInfoParam = this.f438881d;
        if (joinInfoParam == null) {
            QLog.e("Guild.jump.GuildChannelLoadProxyManager", 1, "getJumpGuildParam: join info param is null! channelId[" + this.f438879b + "]");
        } else {
            joinInfoParam.setAfterJoinJumpChannelId("");
        }
        JumpGuildParam jumpGuildParam = new JumpGuildParam(this.f438878a, this.f438879b, joinInfoParam);
        jumpGuildParam.extras.putInt(JumpGuildParam.EXTRA_KEY_OPEN_FROM, e());
        return jumpGuildParam;
    }

    public boolean f() {
        return false;
    }

    public boolean g() {
        return false;
    }

    public boolean h() {
        return ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).showNavigateTitle(this.f438878a);
    }

    public void i(String str, String str2) {
        this.f438878a = str;
        this.f438879b = str2;
    }

    public void j(JumpGuildParam.JoinInfoParam joinInfoParam) {
        this.f438881d = joinInfoParam;
    }

    public boolean k() {
        if (this.f438880c == 1) {
            return true;
        }
        return false;
    }

    public void l(Activity activity) {
        if (!TextUtils.isEmpty(this.f438878a) && !TextUtils.isEmpty(this.f438879b)) {
            if (o.c("Guild.jump.GuildChannelLoadProxyManager")) {
                QLog.d("Guild.jump.GuildChannelLoadProxyManager", 1, "onGuildEntranceClicked: is fastclick");
            } else {
                if (!((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).showNavigateTitle(this.f438878a)) {
                    return;
                }
                GuildStandaloneDialogAttachFragment.qh(activity, d());
            }
        }
    }

    public void m(Bundle bundle) {
        this.f438878a = bundle.getString("guild_id", "");
        this.f438879b = bundle.getString("channelId", "");
        this.f438881d = (JumpGuildParam.JoinInfoParam) bundle.getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM);
        this.f438882e = (GuildAppReportSourceInfo) bundle.getParcelable("GuildAppReportSourceInfo");
        this.f438880c = bundle.getInt(JumpGuildParam.EXTRA_KEY_CHANNEL_LOAD_FROM, 0);
        i(this.f438878a, this.f438879b);
    }
}
