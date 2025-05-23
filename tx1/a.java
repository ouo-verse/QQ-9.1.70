package tx1;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.guild.util.as;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f437872a;

    /* renamed from: b, reason: collision with root package name */
    private String f437873b;

    /* renamed from: c, reason: collision with root package name */
    private int f437874c;

    /* renamed from: d, reason: collision with root package name */
    private long f437875d;

    /* renamed from: e, reason: collision with root package name */
    private b f437876e;

    /* renamed from: f, reason: collision with root package name */
    private final GPServiceObserver f437877f = new C11311a();

    /* compiled from: P */
    /* renamed from: tx1.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    class C11311a extends GPServiceObserver {
        C11311a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(String str) {
            a aVar = a.this;
            if (aVar.k(aVar.f437872a, str)) {
                a.this.j();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelPermissionChanged(String str, HashSet<String> hashSet) {
            if (TextUtils.equals(a.this.f437872a, str) && hashSet != null && hashSet.contains(a.this.f437873b)) {
                a.this.j();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface b {
        void a(boolean z16, boolean z17, boolean z18);
    }

    public a(IGProChannelInfo iGProChannelInfo) {
        this.f437872a = "";
        this.f437873b = "";
        this.f437874c = 0;
        this.f437875d = 0L;
        if (iGProChannelInfo == null) {
            QLog.e("Guild.rg.GuildChannelSettingRoleManager", 1, "channelInfo must not be null");
            return;
        }
        this.f437873b = iGProChannelInfo.getChannelUin();
        this.f437872a = iGProChannelInfo.getGuildId();
        this.f437874c = iGProChannelInfo.getType();
        this.f437875d = iGProChannelInfo.getApplicationId();
        e();
    }

    private void e() {
        ((IGPSService) i().getRuntimeService(IGPSService.class, "")).addObserver(this.f437877f);
    }

    private boolean g() {
        IGProChannelInfo channelInfo = ((IGPSService) i().getRuntimeService(IGPSService.class, "")).getChannelInfo(this.f437873b);
        if (channelInfo == null) {
            QLog.i("Guild.rg.GuildChannelSettingRoleManager", 1, "checkChannelAdmin: channel info is null! id[" + this.f437873b + "]");
            return false;
        }
        QLog.i("Guild.rg.GuildChannelSettingRoleManager", 1, "checkChannelAdmin: channelId[" + this.f437873b + "] Admin[" + channelInfo.isChannelOrCategoryAdmin() + "]");
        return channelInfo.isChannelOrCategoryAdmin();
    }

    private AppRuntime i() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.f437876e != null) {
            this.f437876e.a(f(), h(), g());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k(String str, String str2) {
        if (TextUtils.equals(this.f437872a, str) && TextUtils.equals(this.f437873b, str2)) {
            return true;
        }
        return false;
    }

    private void m() {
        ((IGPSService) i().getRuntimeService(IGPSService.class, "")).deleteObserver(this.f437877f);
    }

    public boolean f() {
        return as.k(this.f437872a, this.f437873b, this.f437874c, this.f437875d);
    }

    public boolean h() {
        return ((IQQGuildService) i().getRuntimeService(IQQGuildService.class, "")).isCurrentGuildManager((AppInterface) i(), this.f437872a);
    }

    public void l() {
        QLog.i("Guild.rg.GuildChannelSettingRoleManager", 1, "release: channelId[" + this.f437873b + "]");
        this.f437876e = null;
        m();
    }

    public void n(b bVar) {
        this.f437876e = bVar;
    }

    public void o(IGProChannelInfo iGProChannelInfo) {
        if (iGProChannelInfo == null) {
            QLog.e("Guild.rg.GuildChannelSettingRoleManager", 1, "channelInfo must not be null");
            return;
        }
        this.f437873b = iGProChannelInfo.getChannelUin();
        this.f437872a = iGProChannelInfo.getGuildId();
        this.f437874c = iGProChannelInfo.getType();
        this.f437875d = iGProChannelInfo.getApplicationId();
    }
}
