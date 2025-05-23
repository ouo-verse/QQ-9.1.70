package wa0;

import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.immersive.events.QFSRerankFinishEvent;
import com.tencent.biz.qqcircle.utils.k;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.HashSet;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {

    /* renamed from: d, reason: collision with root package name */
    private static volatile c f445117d;

    /* renamed from: e, reason: collision with root package name */
    private static final HashSet<String> f445118e = new HashSet<>();

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f445119a = false;

    /* renamed from: b, reason: collision with root package name */
    private boolean f445120b = false;

    /* renamed from: c, reason: collision with root package name */
    private int f445121c = -1;

    c() {
    }

    private static String c() {
        try {
            return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_rank_black_list_model", "OPD2404|");
        } catch (Exception unused) {
            return "OPD2404|";
        }
    }

    private int e() {
        Map<String, String> d16 = k.d("tedgers2_global_config_0714");
        if (!k.f(d16)) {
            QLog.d("TEDGEQFS_QFSRankExpInit", 1, "[getExpRerankType] getTEdgeRSExp is not valid exp");
            return -1;
        }
        String b16 = k.b("tedgers2_global_config_0714");
        String c16 = k.c("tedgers2_global_config_0714");
        QLog.d("TEDGEQFS_QFSRankExpInit", 1, "[getExpRerankType] name: " + c16 + ", expAssignment\uff1a" + b16);
        k.j(c16);
        if (!d16.isEmpty() && d16.containsKey("rerank_mode")) {
            return Integer.parseInt(d16.get("rerank_mode"));
        }
        QLog.e("TEDGEQFS_QFSRankExpInit", 1, "[getExpRerankType] failed,expParamsMap is empty");
        return -1;
    }

    public static c f() {
        if (f445117d == null) {
            synchronized (c.class) {
                if (f445117d == null) {
                    f445117d = new c();
                }
            }
        }
        return f445117d;
    }

    private void h() {
        RFWThreadManager.getInstance().getSerialThreadHandler().postDelayed(new Runnable() { // from class: wa0.b
            @Override // java.lang.Runnable
            public final void run() {
                c.this.b();
            }
        }, 5000L);
    }

    private static boolean i() {
        String mobileModel = QCircleDeviceInfoUtils.getMobileModel();
        if (!f445118e.isEmpty()) {
            return !r2.contains(mobileModel.toLowerCase());
        }
        try {
            String c16 = c();
            if (!TextUtils.isEmpty(c16)) {
                QLog.d("TEDGEQFS_QFSRankExpInit", 2, "mobileModel:" + mobileModel);
                String[] split = c16.split("\\|");
                if (split == null) {
                    return true;
                }
                for (String str : split) {
                    f445118e.add(str.toLowerCase());
                }
            }
        } catch (Exception e16) {
            RFWLog.d("TEDGEQFS_QFSRankExpInit", RFWLog.CLR, e16);
        }
        return !f445118e.contains(mobileModel.toLowerCase());
    }

    private boolean j() {
        if (!uq3.c.L6(HostDataTransUtils.isStudyMode()) && !uq3.c.M6()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        try {
            int e16 = e();
            QLog.d("TEDGEQFS_QFSRankExpInit", 1, "getExpRerankType expRerankType:" + e16);
            int m3 = m(e16);
            if (m3 == 0) {
                this.f445119a = true;
                QLog.d("TEDGEQFS_QFSRankExpInit", 1, "expInit:don't rerank");
            } else if (m3 == 2) {
                this.f445119a = true;
                QLog.d("TEDGEQFS_QFSRankExpInit", 1, "expInit:use TEdgeRS rerank v2");
            } else if (!this.f445120b) {
                QLog.d("TEDGEQFS_QFSRankExpInit", 1, "expInit initDelay");
                this.f445120b = true;
                h();
            }
            this.f445121c = m3;
            if (this.f445119a) {
                SimpleEventBus.getInstance().dispatchEvent(new QFSRerankFinishEvent());
            }
        } catch (Exception e17) {
            QLog.e("TEDGEQFS_QFSRankExpInit", 1, "expInit init error:" + e17);
        }
    }

    public static void l() {
        if (f445117d != null) {
            synchronized (c.class) {
                if (f445117d != null) {
                    f445117d = null;
                }
            }
        }
    }

    private int m(int i3) {
        if (i3 == 2 && !uq3.c.n0()) {
            QLog.d("TEDGEQFS_QFSRankExpInit", 1, "[expInit]v2 wns return false");
            return 0;
        }
        return i3;
    }

    public void b() {
        if (!j()) {
            QLog.e("TEDGEQFS_QFSRankExpInit", 1, "expInit:no qcircle show entrance,direct return!");
            return;
        }
        if (!uq3.k.a().c("sp_key_personal_recommend_switch_open", true)) {
            QLog.e("TEDGEQFS_QFSRankExpInit", 1, "expInit: recommend switch is close");
        } else if (!i()) {
            QLog.e("TEDGEQFS_QFSRankExpInit", 1, "expInit: not enable mode close");
        } else {
            if (this.f445119a) {
                return;
            }
            RFWThreadManager.getInstance().getSerialThreadHandler().post(new Runnable() { // from class: wa0.a
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.k();
                }
            });
        }
    }

    public String d() {
        return "";
    }

    public int g() {
        return this.f445121c;
    }
}
