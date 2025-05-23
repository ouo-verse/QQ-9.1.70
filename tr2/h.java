package tr2;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.business.bi;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.mobileqq.together.TogetherOperationHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import javax.annotation.Nullable;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes9.dex */
public class h implements ur2.a {

    /* renamed from: a, reason: collision with root package name */
    QQAppInterface f437194a;

    /* renamed from: b, reason: collision with root package name */
    com.tencent.mobileqq.intervideo.yiqikan.h f437195b;

    /* renamed from: c, reason: collision with root package name */
    private tr2.d f437196c;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a extends tr2.d {
        a() {
        }

        @Override // tr2.d
        protected void c(boolean z16, Bundle bundle) {
            String string = bundle.getString("KEY_SESSION_UIN");
            int i3 = bundle.getInt("KEY_SESSION_TYPE");
            int i16 = bundle.getInt("KEY_FROM", -1);
            String string2 = bundle.getString("jump_url", "");
            String string3 = bundle.getString("error_msg", "");
            int i17 = bundle.getInt("error_code", 0);
            if (z16 && !TextUtils.isEmpty(string2)) {
                h.this.o(string2, i3, string, i16);
                return;
            }
            if (i17 == 10004 && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                h hVar = h.this;
                hVar.r(hVar.f437194a.getApplication(), string2, i3, string, i16, string3);
            } else {
                MobileQQ application = h.this.f437194a.getApplication();
                if (TextUtils.isEmpty(string3)) {
                    string3 = application.getString(R.string.boo);
                }
                QQToast.makeText(application, 1, string3, 0).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f437198d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f437199e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Bundle f437200f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f437201h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Context f437202i;

        b(String str, int i3, Bundle bundle, int i16, Context context) {
            this.f437198d = str;
            this.f437199e = i3;
            this.f437200f = bundle;
            this.f437201h = i16;
            this.f437202i = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            String str;
            h hVar = h.this;
            String str2 = this.f437198d;
            if (this.f437199e == 8) {
                str = "clk_openframe_open";
            } else {
                str = "clk_joinbar_open";
            }
            hVar.p(str2, str);
            dialogInterface.dismiss();
            int i16 = this.f437199e;
            if (i16 == 8) {
                h.this.q(this.f437200f, this.f437198d, this.f437201h, i16);
            } else {
                h.this.n(this.f437202i, this.f437201h, this.f437198d, i16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f437204d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f437205e;

        c(String str, int i3) {
            this.f437204d = str;
            this.f437205e = i3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            String str;
            h hVar = h.this;
            String str2 = this.f437204d;
            if (this.f437205e == 8) {
                str = "clk_openframe_cancel";
            } else {
                str = "clk_joinbar_cancel";
            }
            hVar.p(str2, str);
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f437207d;

        d(String str) {
            this.f437207d = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            h.this.p(this.f437207d, "clk_unableframe_cancel");
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f437209d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f437210e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f437211f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f437212h;

        e(String str, String str2, int i3, int i16) {
            this.f437209d = str;
            this.f437210e = str2;
            this.f437211f = i3;
            this.f437212h = i16;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            h.this.p(this.f437209d, "clk_unableframe_open");
            dialogInterface.dismiss();
            h.this.o(this.f437210e, this.f437211f, this.f437209d, this.f437212h);
        }
    }

    public h(QQAppInterface qQAppInterface) {
        a aVar = new a();
        this.f437196c = aVar;
        this.f437194a = qQAppInterface;
        qQAppInterface.addObserver(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Context context, int i3, String str, int i16) {
        bi biVar = new bi();
        int d16 = biVar.f202613b.d();
        TroopInfo B = ((TroopManager) this.f437194a.getManager(QQManagerFactory.TROOP_MANAGER)).B(str);
        if (d16 != 0 && B != null) {
            g.i(context, biVar.f202613b.b(), biVar.f202613b.c(), biVar.f202613b.a(), g.e(false, B.isTroopOwner(this.f437194a.getCurrentAccountUin()), B.isOwnerOrAdmin(), B.troopowneruin, str, i16), i3);
            return;
        }
        QQToast.makeText(context, 0, R.string.boo, 0).show();
        if (QLog.isColorLevel()) {
            QLog.d("WatchTogetherManager", 2, "reopenCategoryPage version=", Integer.valueOf(d16), " troopInfo=", B);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str, int i3, String str2, int i16) {
        TroopInfo B = ((TroopManager) this.f437194a.getManager(QQManagerFactory.TROOP_MANAGER)).B(str2);
        if (B == null) {
            QQToast.makeText(this.f437194a.getApplication(), 0, R.string.boo, 0).show();
            if (QLog.isColorLevel()) {
                QLog.d("WatchTogetherManager", 2, "reopenVideoRoom troopInfo=", B);
                return;
            }
            return;
        }
        g.j(this.f437194a, 1, str, null, g.e(false, B.isTroopOwner(this.f437194a.getCurrentAccountUin()), B.isOwnerOrAdmin(), B.troopowneruin, str2, i16), i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str, String str2) {
        ((tr2.b) this.f437194a.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).N("video_tab", str2, 0, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(Bundle bundle, String str, int i3, int i16) {
        ((TogetherOperationHandler) this.f437194a.getBusinessHandler(BusinessHandlerFactory.TOGETHER_OPERATOR_HANDLER)).I2(bundle.getInt(PictureConst.KEY_CATEGORY_ID, 0), bundle.getString("video_id", ""), bundle.getString("title_name", ""), bundle.getString("room_cover", ""), 1, str, i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Context context, String str, int i3, String str2, int i16, String str3) {
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        if (baseActivity != null && !baseActivity.isFinishing()) {
            p(str2, "exp_unableframe");
            DialogUtil.createCustomDialog(baseActivity, 230, (String) null, str3, context.getResources().getString(R.string.f168132et), context.getResources().getString(R.string.f171151ok), new d(str2), new e(str2, str, i3, i16)).show();
        } else {
            QLog.e("WatchTogetherManager", 1, "topActivity is null or finishing");
        }
    }

    private void s(Context context, int i3, int i16, String str, Bundle bundle) {
        String str2;
        if (i3 == 8) {
            str2 = "exp_openframe";
        } else {
            str2 = "exp_joinbar";
        }
        p(str, str2);
        DialogUtil.createCustomDialog(context, 230, (String) null, context.getResources().getString(R.string.f2054855q), context.getResources().getString(R.string.cancel), context.getResources().getString(R.string.zpm), new b(str, i3, bundle, i16, context), new c(str, i3)).show();
    }

    @Override // ur2.a
    public void a(Context context, int i3, int i16, int i17, @Nullable Map<String, f> map, @Nullable Bundle bundle) {
        QLog.i("WatchTogetherManager", 1, "notifySessionChange  serviceType = " + i3 + " from = " + i17);
    }

    @Override // ur2.a
    public QQCustomDialog b() {
        return null;
    }

    @Override // ur2.a
    public void c(f fVar, int i3, String str, long j3, long j16, Object obj) {
        QLog.i("WatchTogetherManager", 1, "onPushMessageReceive");
        m().i((WatchTogetherSession) fVar, i3);
    }

    @Override // ur2.a
    public void d(Context context, String str, int i3, int i16, Bundle bundle) {
        s(context, i16, i3, str, bundle);
    }

    @Override // ur2.a
    public boolean e(Context context, String str, int i3, int i16, Map<String, f> map, @Nullable Bundle bundle) {
        WatchTogetherSession watchTogetherSession = (WatchTogetherSession) map.get("2_1_" + str);
        QLog.i("WatchTogetherManager", 1, "join  groupuin = " + str + " from = " + i16);
        if (i16 == 2) {
            m().j("4", watchTogetherSession, bundle);
        } else {
            if ((i16 != 1 && i16 != 8) || watchTogetherSession == null) {
                return false;
            }
            if (!TextUtils.isEmpty(watchTogetherSession.M) && !watchTogetherSession.M.contains("fromid")) {
                watchTogetherSession.M += "&fromid=10011";
            }
            m().m(watchTogetherSession, bundle);
        }
        return false;
    }

    @Override // ur2.a
    public boolean f(Context context, String str, int i3, int i16, Map<String, f> map, @Nullable Bundle bundle) {
        String str2;
        if (i16 == 0) {
            str2 = "2";
        } else {
            str2 = "";
        }
        QLog.i("WatchTogetherManager", 1, "start  groupuin = " + str + " miniapp_from = " + str2);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("2_1_");
        sb5.append(str);
        WatchTogetherSession watchTogetherSession = (WatchTogetherSession) map.get(sb5.toString());
        if (watchTogetherSession == null) {
            try {
                watchTogetherSession = (WatchTogetherSession) g.a(2, 1, str);
            } catch (Throwable unused) {
            }
        }
        m().j(str2, watchTogetherSession, bundle);
        return false;
    }

    @Override // ur2.a
    public boolean g(Context context, String str, int i3, int i16, boolean z16, Map<String, f> map, @Nullable Bundle bundle) {
        return true;
    }

    @Override // ur2.a
    public String getBusinessName() {
        return tr2.a.f437154b;
    }

    public com.tencent.mobileqq.intervideo.yiqikan.h m() {
        if (this.f437195b == null) {
            this.f437195b = (com.tencent.mobileqq.intervideo.yiqikan.h) this.f437194a.getManager(QQManagerFactory.WATCH_LIVE_TOGETHER);
        }
        return this.f437195b;
    }

    @Override // ur2.a
    public void onDestroy() {
        this.f437194a.removeObserver(this.f437196c);
    }
}
