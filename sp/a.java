package sp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.adelie.av.qav.AdelieAVController;
import com.tencent.adelie.av.ui.AdelieAVFloatWindowManager;
import com.tencent.adelie.av.ui.AdelieAvatarHelper;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.av.utils.e;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    public static String f434113d = "AccountReceiver";

    /* renamed from: a, reason: collision with root package name */
    AppInterface f434114a;

    /* renamed from: b, reason: collision with root package name */
    boolean f434115b = false;

    /* renamed from: c, reason: collision with root package name */
    C11244a f434116c;

    public a(AppInterface appInterface) {
        this.f434114a = appInterface;
        this.f434116c = new C11244a(appInterface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b() {
        String str;
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        up.a E = AdelieAVController.D().E();
        qQAppInterface.getAVNotifyCenter().V0(e.d(), 0);
        if (E != null && E.f439387f > 0) {
            qQAppInterface.getAVNotifyCenter().q0(String.valueOf(E.f439387f));
            str = String.valueOf(E.f439387f);
        } else {
            str = "";
        }
        VideoMsgTools.l(qQAppInterface, 1043, 45, true, str, qQAppInterface.getCurrentAccountUin(), true, null, true, new Object[0]);
        AdelieAVController.D().B();
        AdelieAVFloatWindowManager.z().D();
        AdelieAVController.x();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AdelieAvatarHelper.p().g(str);
    }

    public void c() {
        if (QLog.isColorLevel()) {
            QLog.d(f434113d, 2, "regist QQ Account Receiver, Declare permissions");
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_KICKED);
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_EXPIRED);
        intentFilter.addAction(NewIntent.ACTION_LOGOUT);
        if (this.f434114a.getApplication().registerReceiver(this.f434116c, intentFilter, "com.tencent.msg.permission.pushnotify", null) != null) {
            this.f434115b = true;
        }
    }

    public void d() {
        if (this.f434115b) {
            this.f434114a.getApplication().unregisterReceiver(this.f434116c);
            this.f434116c = null;
            this.f434115b = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: sp.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static class C11244a extends BroadcastReceiver {

        /* renamed from: b, reason: collision with root package name */
        public static String f434117b = "AccountReceiver";

        /* renamed from: a, reason: collision with root package name */
        AppInterface f434118a;

        public C11244a(AppInterface appInterface) {
            this.f434118a = appInterface;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getAction() == null) {
                return;
            }
            try {
                if (QLog.isColorLevel()) {
                    QLog.d(f434117b, 2, "recv account broadcast: " + intent.getAction());
                }
                if (intent.getAction().equals(NewIntent.ACTION_ACCOUNT_KICKED)) {
                    a.b();
                    return;
                }
                if (intent.getAction().equals(NewIntent.ACTION_ACCOUNT_EXPIRED)) {
                    a.b();
                } else if (intent.getAction().equals(NewIntent.ACTION_LOGOUT)) {
                    a.b();
                } else if (NewIntent.ACTION_ACCOUNT_CHANGED.equals(intent.getAction())) {
                    a.b();
                }
            } catch (RuntimeException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(f434117b, 2, "RuntimeException", e16);
                }
            }
        }
    }
}
