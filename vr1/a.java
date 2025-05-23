package vr1;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.guild.mainframe.i;
import com.tencent.mobileqq.guild.mainframe.k;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a extends k {

    /* renamed from: e, reason: collision with root package name */
    private FrameLayout f443191e;

    /* renamed from: f, reason: collision with root package name */
    private int f443192f;

    /* renamed from: h, reason: collision with root package name */
    private Intent f443193h;

    /* renamed from: i, reason: collision with root package name */
    private List<gs1.a> f443194i;

    /* renamed from: m, reason: collision with root package name */
    private final GPServiceObserver f443195m;

    /* compiled from: P */
    /* renamed from: vr1.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    class C11437a extends GPServiceObserver {
        C11437a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAddGuildWithInfo(IGProGuildInfo iGProGuildInfo, int i3) {
            if (iGProGuildInfo == null) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("Guild.MF.End.GuildEndPanelController", 2, "onAddGuildWithInfo: guild: ", iGProGuildInfo.getGuildID());
            }
            if (a.this.f443193h != null && TextUtils.equals(a.this.f443193h.getStringExtra("guild_id"), iGProGuildInfo.getGuildID())) {
                a aVar = a.this;
                aVar.t(aVar.f443193h);
            }
        }
    }

    public a(i iVar) {
        super(iVar);
        this.f443192f = 0;
        this.f443193h = null;
        this.f443194i = new ArrayList();
        this.f443195m = new C11437a();
        q();
    }

    private void j() {
        ((IGPSService) this.f227466d.getApp().getRuntimeService(IGPSService.class, "")).addObserver(this.f443195m);
    }

    private gs1.a k(int i3) {
        for (gs1.a aVar : this.f443194i) {
            if (aVar.k() == i3) {
                return aVar;
            }
        }
        return null;
    }

    private boolean l(int i3, Intent intent) {
        if (i3 == 1) {
            return m(intent);
        }
        if (i3 == 6) {
            return true;
        }
        if (i3 == 5) {
            return n(intent);
        }
        return false;
    }

    private boolean m(Object obj) {
        if (obj == null) {
            obj = this.f227466d.getActivity().getIntent();
        }
        if (!(obj instanceof Intent)) {
            QLog.d("Guild.MF.End.GuildEndPanelController", 1, "isEnableEndPage data null");
            return false;
        }
        Intent intent = (Intent) obj;
        String stringExtra = intent.getStringExtra("uin");
        String stringExtra2 = intent.getStringExtra("guild_id");
        if (!TextUtils.isEmpty(stringExtra2) && !TextUtils.isEmpty(stringExtra) && !o(stringExtra2, stringExtra)) {
            IGProChannelInfo channelInfo = ((IGPSService) this.f227466d.getApp().getRuntimeService(IGPSService.class, "")).getChannelInfo(stringExtra);
            if ((channelInfo == null || channelInfo.getType() != 1) && ((IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class)).getChannelType(this.f227466d.getApp(), stringExtra2, stringExtra) != 1000001 && ((IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class)).getChannelType(this.f227466d.getApp(), stringExtra2, stringExtra) != 1000137) {
                return false;
            }
            return true;
        }
        QLog.d("Guild.MF.End.GuildEndPanelController", 1, "isEnableEndPage guildId = " + stringExtra2 + "channelId = " + stringExtra);
        return false;
    }

    private boolean n(Intent intent) {
        if (intent == null) {
            intent = this.f227466d.getActivity().getIntent();
        }
        if (!(intent instanceof Intent)) {
            QLog.d("Guild.MF.End.GuildEndPanelController", 1, "isEnableEndPage data null");
            return false;
        }
        String stringExtra = intent.getStringExtra("uin");
        String stringExtra2 = intent.getStringExtra("guild_id");
        if (!TextUtils.isEmpty(stringExtra2) && !TextUtils.isEmpty(stringExtra) && !o(stringExtra2, stringExtra)) {
            GuildClientParams guildClientParams = (GuildClientParams) intent.getParcelableExtra("EXTRA_KEY_CLIENT_PARAM");
            if ((guildClientParams == null || guildClientParams.q() != 1000050) && ((IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class)).getChannelType(this.f227466d.getApp(), stringExtra2, stringExtra) != 1000050) {
                return false;
            }
            return true;
        }
        QLog.d("Guild.MF.End.GuildEndPanelController", 1, "isEnableEndPage guildId = " + stringExtra2 + "channelId = " + stringExtra);
        return false;
    }

    private boolean o(String str, String str2) {
        IGPSService iGPSService = (IGPSService) this.f227466d.getApp().getRuntimeService(IGPSService.class, "");
        IGProGuildInfo guildInfo = iGPSService.getGuildInfo(str);
        IGProChannelInfo channelInfo = iGPSService.getChannelInfo(str2);
        if (guildInfo != null && channelInfo != null) {
            return false;
        }
        return true;
    }

    private void r() {
        ((IGPSService) this.f227466d.getApp().getRuntimeService(IGPSService.class, "")).deleteObserver(this.f443195m);
    }

    private void s(boolean z16) {
        this.f227466d.N().i(z16);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void a(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.End.GuildEndPanelController", 2, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        }
        Iterator<gs1.a> it = this.f443194i.iterator();
        while (it.hasNext()) {
            it.next().a(z16);
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void b(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.End.GuildEndPanelController", 2, "onAfterAccountChanged isSwitchAccount = " + z16);
        }
        Iterator<gs1.a> it = this.f443194i.iterator();
        while (it.hasNext()) {
            it.next().b(z16);
        }
        j();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k
    public void h(View view) {
        if (view instanceof FrameLayout) {
            this.f443191e = (FrameLayout) view;
            Iterator<gs1.a> it = this.f443194i.iterator();
            while (it.hasNext()) {
                it.next().m(this.f443191e);
            }
            return;
        }
        QLog.e("Guild.MF.End.GuildEndPanelController", 2, "initView view error !");
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public boolean onBackPressed() {
        Iterator<gs1.a> it = this.f443194i.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            if (it.next().onBackPressed()) {
                z16 = true;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.End.GuildEndPanelController", 2, "onBackPressed result = " + z16);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.End.GuildEndPanelController", 2, "onBackPressed end result = " + z16);
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onBeforeAccountChanged() {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.End.GuildEndPanelController", 2, "onBeforeAccountChanged");
        }
        Iterator<gs1.a> it = this.f443194i.iterator();
        while (it.hasNext()) {
            it.next().onBeforeAccountChanged();
        }
        r();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onCreate() {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.End.GuildEndPanelController", 2, "onCreate");
        }
        Iterator<gs1.a> it = this.f443194i.iterator();
        while (it.hasNext()) {
            it.next().onCreate();
        }
        j();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onDestroy() {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.End.GuildEndPanelController", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        Iterator<gs1.a> it = this.f443194i.iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
        r();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onResume(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.End.GuildEndPanelController", 2, "onResume tabChange = " + z16);
        }
        Iterator<gs1.a> it = this.f443194i.iterator();
        while (it.hasNext()) {
            it.next().onResume(z16);
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onStart() {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.End.GuildEndPanelController", 2, "onStart");
        }
        Iterator<gs1.a> it = this.f443194i.iterator();
        while (it.hasNext()) {
            it.next().onStart();
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onStop() {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.End.GuildEndPanelController", 2, DKHippyEvent.EVENT_STOP);
        }
        Iterator<gs1.a> it = this.f443194i.iterator();
        while (it.hasNext()) {
            it.next().onStop();
        }
    }

    public void p(int i3, Intent intent) {
        gs1.a k3;
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.End.GuildEndPanelController", 2, "openGuildAttachContainer frameType = " + i3);
        }
        this.f443193h = intent;
        boolean l3 = l(i3, intent);
        s(l3);
        if (!l3) {
            Iterator<gs1.a> it = this.f443194i.iterator();
            while (it.hasNext()) {
                it.next().l();
            }
            return;
        }
        if (i3 == this.f443192f && (k3 = k(i3)) != null && !k3.i(intent)) {
            return;
        }
        this.f443192f = i3;
        for (gs1.a aVar : this.f443194i) {
            if (aVar.k() != i3) {
                aVar.l();
            }
        }
        for (gs1.a aVar2 : this.f443194i) {
            if (aVar2.k() == i3) {
                aVar2.n(intent);
            }
        }
    }

    public void t(Intent intent) {
        if (!this.f227466d.N().h()) {
            int t16 = this.f227466d.Z0().t();
            if (l(t16, intent)) {
                p(t16, intent);
            }
        }
    }

    private void q() {
    }
}
