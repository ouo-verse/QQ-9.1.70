package yq1;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.guild.mainframe.centerpanel.GuildCenterPanelController;
import com.tencent.mobileqq.guild.util.debug.GuildJumpDebugUtils;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppChnnPreInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import wh2.em;

/* compiled from: P */
/* loaded from: classes14.dex */
public class d implements j {

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements em {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IGPSService f450975a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f450976b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f450977c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.guild.mainframe.i f450978d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IGProChannelInfo f450979e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ IGProGuildInfo f450980f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Bundle f450981g;

        a(IGPSService iGPSService, String str, String str2, com.tencent.mobileqq.guild.mainframe.i iVar, IGProChannelInfo iGProChannelInfo, IGProGuildInfo iGProGuildInfo, Bundle bundle) {
            this.f450975a = iGPSService;
            this.f450976b = str;
            this.f450977c = str2;
            this.f450978d = iVar;
            this.f450979e = iGProChannelInfo;
            this.f450980f = iGProGuildInfo;
            this.f450981g = bundle;
        }

        @Override // wh2.em
        public void onResult(int i3, String str) {
            IGProAppChnnPreInfo appChnnPreInfo = this.f450975a.getAppChnnPreInfo(this.f450976b, this.f450977c);
            if (QLog.isColorLevel()) {
                QLog.d("Guild.jump.GuildAppChannelOpenAction", 2, "onFetchAppInfoList result:", Integer.valueOf(i3), " errMsg:", str, " appChnnPreInfo:", appChnnPreInfo);
            }
            if (appChnnPreInfo != null) {
                d.this.j(this.f450978d, this.f450979e, this.f450980f, this.f450976b, this.f450977c, appChnnPreInfo, this.f450981g);
            } else {
                QLog.e("Guild.jump.GuildAppChannelOpenAction", 1, "onFetchAppInfoList failed. result:", Integer.valueOf(i3), " errMsg:", str);
            }
        }
    }

    private void e(com.tencent.mobileqq.guild.mainframe.i iVar) {
        iVar.Z0().r();
    }

    private boolean f(com.tencent.mobileqq.guild.mainframe.i iVar) {
        return iVar.Z0().q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(com.tencent.mobileqq.guild.mainframe.i iVar) {
        if (f(iVar)) {
            i(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(com.tencent.mobileqq.guild.mainframe.i iVar) {
        if (f(iVar)) {
            e(iVar);
        }
    }

    private static void i(com.tencent.mobileqq.guild.mainframe.i iVar) {
        GuildCenterPanelController Z0 = iVar.Z0();
        if (Z0 != null) {
            Z0.z(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(@NonNull final com.tencent.mobileqq.guild.mainframe.i iVar, @NonNull IGProChannelInfo iGProChannelInfo, IGProGuildInfo iGProGuildInfo, String str, String str2, IGProAppChnnPreInfo iGProAppChnnPreInfo, Bundle bundle) {
        GuildClientParams e16 = new GuildClientParams().a((int) iGProAppChnnPreInfo.getAppid()).e0(str).f(str2).d0(bundle).g(iGProChannelInfo.getChannelName()).c0(iGProGuildInfo.getAvatarUrl(100)).i0(iGProAppChnnPreInfo.getJumpType()).j0(iGProAppChnnPreInfo.getJumpUrl()).e();
        GuildJumpDebugUtils.a("GUILD_JUMP", "GuildAppChannelOpenAction::openChannelInternal(): params = ", e16);
        kg1.a.d(iVar.getActivity(), e16);
        QLog.d("Guild.jump.GuildAppChannelOpenAction", 1, "openChannelInternal info: " + iGProAppChnnPreInfo);
        if (iGProAppChnnPreInfo.getJumpType() == 1) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: yq1.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.this.g(iVar);
                }
            });
        } else {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: yq1.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.this.h(iVar);
                }
            }, 1000L);
        }
        return true;
    }

    @Override // yq1.j
    public boolean a(@NonNull com.tencent.mobileqq.guild.mainframe.i iVar, @NonNull IGProChannelInfo iGProChannelInfo, Bundle bundle) {
        IGPSService iGPSService = (IGPSService) iVar.getApp().getRuntimeService(IGPSService.class, "");
        IGProGuildInfo guildInfo = iGPSService.getGuildInfo(iGProChannelInfo.getGuildId());
        String guildId = iGProChannelInfo.getGuildId();
        String channelUin = iGProChannelInfo.getChannelUin();
        GuildJumpDebugUtils.a("GUILD_JUMP", "GuildAppChannelOpenAction::openChannel bundle:", bundle);
        IGProAppChnnPreInfo appChnnPreInfo = iGPSService.getAppChnnPreInfo(guildId, channelUin);
        if (appChnnPreInfo == null) {
            QLog.w("Guild.jump.GuildAppChannelOpenAction", 1, "openChannel error! app info is null. guildId=" + guildId + " channelId=" + channelUin);
            new ArrayList().add(channelUin);
            iGPSService.refreshAppChannelPreInfos(guildId, true, new a(iGPSService, guildId, channelUin, iVar, iGProChannelInfo, guildInfo, bundle));
            return true;
        }
        return j(iVar, iGProChannelInfo, guildInfo, guildId, channelUin, appChnnPreInfo, bundle);
    }
}
