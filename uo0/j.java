package uo0;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.tencent.guild.aio.input.at.utils.AtUserHelper;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes6.dex */
public class j extends k {

    /* renamed from: c */
    private final AppRuntime f439336c;

    /* renamed from: d */
    public final String f439337d;

    /* renamed from: e */
    public final String f439338e;

    /* renamed from: f */
    private final List<String> f439339f;

    /* renamed from: i */
    private boolean f439342i;

    /* renamed from: k */
    private long f439344k;

    /* renamed from: l */
    private f f439345l;

    /* renamed from: g */
    private boolean f439340g = true;

    /* renamed from: h */
    private boolean f439341h = false;

    /* renamed from: j */
    private List<IGProUserInfo> f439343j = new ArrayList();

    public j(@NonNull AppRuntime appRuntime, @NonNull String str, @NonNull String str2, @NonNull List<String> list, boolean z16) {
        this.f439342i = false;
        this.f439336c = appRuntime;
        this.f439337d = str;
        this.f439338e = str2;
        this.f439339f = list;
        this.f439342i = z16;
    }

    public void p(boolean z16, List<IGProUserInfo> list) {
        this.f439340g = z16;
        this.f439341h = false;
        if (j()) {
            return;
        }
        if (list == null) {
            QLog.e("RecentUserSearch", 1, "onFetchMemberListWithRole, roleList == null");
        } else {
            this.f439343j.addAll(list);
            d();
        }
    }

    @Override // uo0.k, ze1.c
    public void a() {
        if (this.f439341h) {
            QLog.i("RecentUserSearch", 1, "loadMoreData but now is loading data");
            return;
        }
        f fVar = this.f439345l;
        if (fVar != null) {
            fVar.c(this.f439336c, this.f439337d, this.f439338e, new ArrayList(), true, true, 60L, new i(this));
            this.f439341h = true;
        }
    }

    @Override // uo0.k, ze1.c
    public boolean b() {
        return this.f439340g;
    }

    @Override // uo0.k
    public String f() {
        StringBuilder sb5 = new StringBuilder(getClass().getSimpleName());
        sb5.append(":");
        sb5.append(this.f439337d);
        sb5.append(":");
        sb5.append(this.f439338e);
        for (String str : this.f439339f) {
            sb5.append(":");
            sb5.append(str);
        }
        return sb5.toString();
    }

    @Override // uo0.k
    public String h() {
        return "";
    }

    @Override // uo0.k
    public List<IGProUserInfo> i() {
        return this.f439343j;
    }

    @Override // uo0.k
    public boolean l() {
        if (SystemClock.elapsedRealtime() - this.f439344k > 10000) {
            return true;
        }
        return false;
    }

    @Override // uo0.k
    public void m() {
        this.f439344k = 0L;
        IGProChannelInfo channelInfo = ((IGPSService) this.f439336c.getRuntimeService(IGPSService.class, "")).getChannelInfo(this.f439338e);
        if (this.f439345l == null) {
            f g16 = AtUserHelper.g(this.f439337d);
            if (g16 == null) {
                g16 = new f();
            }
            this.f439345l = g16;
        }
        if (channelInfo != null && channelInfo.getType() == 7) {
            List<IGProUserInfo> e16 = AtUserHelper.e(this.f439337d);
            if (e16 != null && !e16.isEmpty()) {
                p(true ^ this.f439345l.getMIsFinish(), e16);
                return;
            }
            this.f439345l.c(this.f439336c, this.f439337d, this.f439338e, this.f439339f, false, false, 60L, new i(this));
        } else {
            this.f439345l.c(this.f439336c, this.f439337d, this.f439338e, Collections.emptyList(), false, true, 60L, new i(this));
        }
        this.f439341h = true;
    }
}
