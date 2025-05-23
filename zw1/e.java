package zw1;

import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.robot.api.model.GuildChannel;
import com.tencent.mobileqq.guild.robot.components.audio.AudioRobotListFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.GProGetGuildRobotListFilter;
import com.tencent.qqnt.kernel.nativeinterface.GProGetGuildRobotListReq;
import com.tencent.qqnt.kernel.nativeinterface.GProGetGuildRobotListRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotDownMicReq;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotUpMicReq;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotUpMicRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGProRobotSimpleResultCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGuildRobotListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IUpMicGuildRobotCallback;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import zw1.e;

/* compiled from: P */
/* loaded from: classes14.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    private static long f453598b;

    /* renamed from: c, reason: collision with root package name */
    private static long f453599c;

    /* renamed from: d, reason: collision with root package name */
    private static GProGetGuildRobotListRsp f453600d;

    /* renamed from: e, reason: collision with root package name */
    private static ArrayList<GProGuildRobotInfo> f453601e = new ArrayList<>(0);

    /* renamed from: f, reason: collision with root package name */
    private static ArrayList<GProGuildRobotInfo> f453602f = new ArrayList<>(0);

    /* renamed from: a, reason: collision with root package name */
    private final AudioRobotListFragment f453603a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements IGetGuildRobotListCallback {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(int i3, GProGetGuildRobotListRsp gProGetGuildRobotListRsp, String str) {
            if (i3 == 0 && gProGetGuildRobotListRsp != null) {
                d(gProGetGuildRobotListRsp);
            } else {
                c(i3, str);
            }
        }

        private void c(int i3, String str) {
            QLog.i("RobotListController", 1, "getRobotInfo errCode:" + i3 + ";msg:" + str);
            if (e.this.f453603a != null) {
                e.this.f453603a.rh(null, false);
            }
        }

        private void d(GProGetGuildRobotListRsp gProGetGuildRobotListRsp) {
            e.f453598b = SystemClock.elapsedRealtime();
            e.f453600d = gProGetGuildRobotListRsp;
            if (e.this.f453603a != null) {
                if (gProGetGuildRobotListRsp != null) {
                    e.f453602f = gProGetGuildRobotListRsp.getRecommendList();
                    e.f453601e = gProGetGuildRobotListRsp.getAddedList();
                    e.this.f453603a.rh(e.f453600d, true);
                    return;
                }
                e.this.f453603a.rh(e.f453600d, false);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGuildRobotListCallback
        public void onGetGuildRobotList(final int i3, final String str, final GProGetGuildRobotListRsp gProGetGuildRobotListRsp) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: zw1.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.a.this.b(i3, gProGetGuildRobotListRsp, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b extends qx1.a<GProGuildRobotUpMicRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GProGuildRobotInfo f453605a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AppRuntime f453606b;

        b(GProGuildRobotInfo gProGuildRobotInfo, d dVar, AppRuntime appRuntime) {
            this.f453605a = gProGuildRobotInfo;
            this.f453606b = appRuntime;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(int i3, String str, GProGuildRobotInfo gProGuildRobotInfo, AppRuntime appRuntime, d dVar) {
            QLog.i("RobotListController", 1, "upMicRobot errCode:" + i3 + ";msg:" + str);
            if (e.this.f453603a != null) {
                e.this.f453603a.sh(false, i3, str, gProGuildRobotInfo.getRobotName());
            } else {
                QQToast.makeText(appRuntime.getApplicationContext(), 4, str, 0).show();
            }
            if (dVar != null) {
                dVar.a(false, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(GProGuildRobotInfo gProGuildRobotInfo, d dVar) {
            e.r();
            if (e.this.f453603a != null) {
                e.this.f453603a.sh(true, 0, "", gProGuildRobotInfo.getRobotName());
            }
            if (dVar != null) {
                dVar.a(true, "");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // qx1.a
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void c(final int i3, final String str, GProGuildRobotUpMicRsp gProGuildRobotUpMicRsp) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final GProGuildRobotInfo gProGuildRobotInfo = this.f453605a;
            final AppRuntime appRuntime = this.f453606b;
            final d dVar = null;
            uIHandlerV2.post(new Runnable(i3, str, gProGuildRobotInfo, appRuntime, dVar) { // from class: zw1.f

                /* renamed from: e, reason: collision with root package name */
                public final /* synthetic */ int f453612e;

                /* renamed from: f, reason: collision with root package name */
                public final /* synthetic */ String f453613f;

                /* renamed from: h, reason: collision with root package name */
                public final /* synthetic */ GProGuildRobotInfo f453614h;

                /* renamed from: i, reason: collision with root package name */
                public final /* synthetic */ AppRuntime f453615i;

                @Override // java.lang.Runnable
                public final void run() {
                    e.b.this.g(this.f453612e, this.f453613f, this.f453614h, this.f453615i, null);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // qx1.a
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void d(GProGuildRobotUpMicRsp gProGuildRobotUpMicRsp) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final GProGuildRobotInfo gProGuildRobotInfo = this.f453605a;
            final d dVar = null;
            uIHandlerV2.post(new Runnable(gProGuildRobotInfo, dVar) { // from class: zw1.g

                /* renamed from: e, reason: collision with root package name */
                public final /* synthetic */ GProGuildRobotInfo f453617e;

                @Override // java.lang.Runnable
                public final void run() {
                    e.b.this.h(this.f453617e, null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c implements IGProRobotSimpleResultCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GProGuildRobotInfo f453608a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AppRuntime f453609b;

        c(GProGuildRobotInfo gProGuildRobotInfo, AppRuntime appRuntime) {
            this.f453608a = gProGuildRobotInfo;
            this.f453609b = appRuntime;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(int i3, String str) {
            if (i3 != 0) {
                c(i3, str);
            } else {
                d();
            }
        }

        private void c(int i3, String str) {
            QLog.e("RobotListController", 1, "downMicRobot errCode:" + i3 + ";msg:" + str);
            if (e.this.f453603a != null) {
                e.this.f453603a.qh(false, i3, str, this.f453608a.getRobotName());
            } else {
                QQToast.makeText(this.f453609b.getApplicationContext(), 4, this.f453609b.getApplicationContext().getString(R.string.f143360lv), 0).show();
            }
        }

        private void d() {
            e.r();
            if (e.this.f453603a != null) {
                e.this.f453603a.qh(true, 0, "", this.f453608a.getRobotName());
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGProRobotSimpleResultCallback
        public void onResult(final int i3, final String str) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: zw1.h
                @Override // java.lang.Runnable
                public final void run() {
                    e.c.this.b(i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface d {
        void a(boolean z16, String str);
    }

    public e(@Nullable AudioRobotListFragment audioRobotListFragment) {
        this.f453603a = audioRobotListFragment;
    }

    public static ArrayList<GProGuildRobotInfo> j() {
        return f453602f;
    }

    public static ArrayList<GProGuildRobotInfo> k() {
        return f453601e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(GProGuildRobotInfo gProGuildRobotInfo, d dVar, AppRuntime appRuntime, int i3, String str, GProGuildRobotUpMicRsp gProGuildRobotUpMicRsp) {
        new b(gProGuildRobotInfo, dVar, appRuntime).a(i3, str, gProGuildRobotUpMicRsp);
    }

    public static void r() {
        f453598b = 0L;
    }

    public void h() {
        AudioRobotListFragment audioRobotListFragment = this.f453603a;
        if (audioRobotListFragment != null && audioRobotListFragment.isAdded()) {
            this.f453603a.dismiss();
        }
    }

    public void i(GuildChannel guildChannel, GProGuildRobotInfo gProGuildRobotInfo) {
        ac g16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (g16 = sx1.f.g()) == null) {
            return;
        }
        g16.downMicGuildRobot(new GProGuildRobotDownMicReq(guildChannel.b(), guildChannel.a(), gProGuildRobotInfo.getRobotUin(), gProGuildRobotInfo.getRobotTid()), new c(gProGuildRobotInfo, peekAppRuntime));
    }

    public void l(GuildChannel guildChannel, int i3, boolean z16) {
        m(guildChannel, i3, z16, 0, 100);
    }

    public void m(GuildChannel guildChannel, int i3, boolean z16, int i16, int i17) {
        if (!z16 && guildChannel.a() == f453599c && f453600d != null && SystemClock.elapsedRealtime() - f453598b < MiniBoxNoticeInfo.MIN_5) {
            AudioRobotListFragment audioRobotListFragment = this.f453603a;
            if (audioRobotListFragment != null) {
                audioRobotListFragment.rh(f453600d, true);
                return;
            }
            return;
        }
        f453599c = guildChannel.a();
        ac g16 = sx1.f.g();
        if (g16 == null) {
            return;
        }
        g16.getGuildRobotList(new GProGetGuildRobotListReq(guildChannel.b(), i16, i17, new GProGetGuildRobotListFilter(true), guildChannel.a(), sx1.f.d(), new ArrayList(0)), new a());
    }

    public int n() {
        GProGetGuildRobotListRsp gProGetGuildRobotListRsp = f453600d;
        if (gProGetGuildRobotListRsp == null) {
            if (QLog.isColorLevel()) {
                QLog.i("RobotListController", 2, "mListReply \u4e3a null");
                return 0;
            }
            return 0;
        }
        return gProGetGuildRobotListRsp.getRole();
    }

    public void o() {
        AudioRobotListFragment audioRobotListFragment = this.f453603a;
        if (audioRobotListFragment != null) {
            FragmentTransaction beginTransaction = audioRobotListFragment.getFragmentManager().beginTransaction();
            beginTransaction.hide(this.f453603a);
            beginTransaction.commit();
        }
    }

    public void q() {
        r();
        AudioRobotListFragment audioRobotListFragment = this.f453603a;
        if (audioRobotListFragment != null) {
            audioRobotListFragment.refresh();
        }
    }

    public void s() {
        FragmentManager fragmentManager;
        AudioRobotListFragment audioRobotListFragment = this.f453603a;
        if (audioRobotListFragment == null || (fragmentManager = audioRobotListFragment.getFragmentManager()) == null) {
            return;
        }
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.show(this.f453603a);
        beginTransaction.commit();
    }

    public void t(GuildChannel guildChannel, GProGuildRobotInfo gProGuildRobotInfo) {
        u(guildChannel, gProGuildRobotInfo, null);
    }

    public void u(GuildChannel guildChannel, final GProGuildRobotInfo gProGuildRobotInfo, final d dVar) {
        ac g16;
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (g16 = sx1.f.g()) == null) {
            return;
        }
        g16.upMicGuildRobot(new GProGuildRobotUpMicReq(guildChannel.b(), guildChannel.a(), gProGuildRobotInfo.getRobotUin(), false, new ArrayList(0), gProGuildRobotInfo.getRobotTid()), new IUpMicGuildRobotCallback(gProGuildRobotInfo, dVar, peekAppRuntime) { // from class: zw1.c

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ GProGuildRobotInfo f453592b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ AppRuntime f453593c;

            {
                this.f453593c = peekAppRuntime;
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IUpMicGuildRobotCallback
            public final void onUpMicGuildRobot(int i3, String str, GProGuildRobotUpMicRsp gProGuildRobotUpMicRsp) {
                e.this.p(this.f453592b, null, this.f453593c, i3, str, gProGuildRobotUpMicRsp);
            }
        });
    }
}
