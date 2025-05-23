package rr1;

import android.content.Intent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.guild.inbox.centerpanel.notice.GuildNoticeFragment;
import com.tencent.mobileqq.guild.mainframe.k;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.util.q;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class h extends gs1.a {

    /* renamed from: e, reason: collision with root package name */
    private FrameLayout f432013e;

    /* renamed from: f, reason: collision with root package name */
    private GuildNoticeFragment f432014f;

    /* renamed from: h, reason: collision with root package name */
    private rr1.a f432015h;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a extends rr1.a {
        a() {
        }

        @Override // rr1.a
        public void c(i iVar) {
            if (((k) h.this).f227466d.Z0().t() != 4 || iVar.f() != 3) {
                return;
            }
            if (iVar.c() == 3) {
                h.this.r("pgout");
                return;
            }
            if (iVar.c() != 1) {
                return;
            }
            if (h.this.f432014f != null) {
                h.this.f432014f.onResume();
                h.this.r("pgin");
            }
            if (QLog.isColorLevel()) {
                QLog.d("Guild.C2C.GuildNoticeCenterPanelController", 2, "clearNoticeRedPoint");
            }
        }
    }

    public h(com.tencent.mobileqq.guild.mainframe.i iVar) {
        super(iVar);
        this.f432015h = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(String str) {
        GuildNoticeFragment guildNoticeFragment = this.f432014f;
        if (guildNoticeFragment != null && guildNoticeFragment.getView() != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
            hashMap.put("pgid", "pg_sgrp_auditnotification_set");
            VideoReport.reportEvent(str, this.f432014f.getView(), hashMap);
        }
    }

    @Override // gs1.a
    public boolean i(Intent intent) {
        return false;
    }

    @Override // gs1.a
    public int k() {
        return 4;
    }

    @Override // gs1.a
    public void l() {
        GuildNoticeFragment guildNoticeFragment = this.f432014f;
        if (guildNoticeFragment == null) {
            return;
        }
        q.b(guildNoticeFragment);
        this.f432014f = null;
        if (QLog.isColorLevel()) {
            QLog.d("Guild.C2C.GuildNoticeCenterPanelController", 2, "hide noticeFragment !");
        }
    }

    @Override // gs1.a
    public void m(ViewGroup viewGroup) {
        this.f432013e = (FrameLayout) viewGroup;
    }

    @Override // gs1.a
    public void n(Intent intent) {
        if (this.f432014f != null) {
            if (QLog.isColorLevel()) {
                QLog.d("Guild.C2C.GuildNoticeCenterPanelController", 2, "remove noticeFragment !");
            }
            q.b(this.f432014f);
        }
        GuildNoticeFragment Kh = GuildNoticeFragment.Kh(new Intent());
        this.f432014f = Kh;
        Kh.Ph(g());
        FragmentTransaction beginTransaction = j().beginTransaction();
        beginTransaction.add(this.f432013e.getId(), this.f432014f, "GuildChannelNoticeFrameController_QQGuildChannelNoticeFragment");
        beginTransaction.commitAllowingStateLoss();
        if (QLog.isColorLevel()) {
            QLog.d("Guild.C2C.GuildNoticeCenterPanelController", 2, "show noticeFragment !");
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public boolean onBackPressed() {
        boolean z16;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onBackPressed noticeFragment is null ? ");
            if (this.f432014f == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("Guild.C2C.GuildNoticeCenterPanelController", 2, sb5.toString());
        }
        if (this.f432013e == null || this.f227466d.Z0().t() != 4) {
            return false;
        }
        if (this.f227466d.Z0().o()) {
            this.f227466d.Z0().z(1);
            return true;
        }
        if (this.f227466d.Z0().q()) {
            this.f227466d.Z0().z(2);
            return true;
        }
        if (this.f227466d.Z0().p()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onBeforeAccountChanged() {
        GuildNoticeFragment guildNoticeFragment = this.f432014f;
        if (guildNoticeFragment != null) {
            q.b(guildNoticeFragment);
            this.f432014f = null;
            if (this.f227466d.Z0().t() == 4) {
                GuildMainFrameUtils.d(this.f227466d);
            }
            if (QLog.isColorLevel()) {
                QLog.d("Guild.C2C.GuildNoticeCenterPanelController", 2, "onBeforeAccountChanged");
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onCreate() {
        super.onCreate();
        this.f227466d.N().addGestureListener(this.f432015h);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onDestroy() {
        GuildNoticeFragment guildNoticeFragment = this.f432014f;
        if (guildNoticeFragment != null) {
            q.b(guildNoticeFragment);
            this.f432014f = null;
            if (QLog.isColorLevel()) {
                QLog.d("Guild.C2C.GuildNoticeCenterPanelController", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
            }
        }
        this.f227466d.N().removeGestureListener(this.f432015h);
    }
}
