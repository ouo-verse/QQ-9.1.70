package xw;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: g, reason: collision with root package name */
    private static Boolean f448867g;

    /* renamed from: a, reason: collision with root package name */
    private VideoAppInterface f448868a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f448869b;

    /* renamed from: d, reason: collision with root package name */
    private yw.a f448871d;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<Activity> f448872e;

    /* renamed from: f, reason: collision with root package name */
    private String f448873f = null;

    /* renamed from: c, reason: collision with root package name */
    private c f448870c = new c(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f448874d;

        a(Activity activity) {
            this.f448874d = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            try {
                b.this.m();
                Intent intent = new Intent(this.f448874d, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", "https://ti.qq.com/realname/index.html?source=watchtogether");
                this.f448874d.startActivityForResult(intent, 21001);
                if (QLog.isColorLevel()) {
                    QLog.i("WTogetherRealNameVideoProcessHelper", 2, "showRealNameDialog click confirm.");
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: xw.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class DialogInterfaceOnClickListenerC11568b implements DialogInterface.OnClickListener {
        DialogInterfaceOnClickListenerC11568b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (b.this.f448871d != null) {
                b.this.f448871d.onCancel();
            }
            if (QLog.isColorLevel()) {
                QLog.i("WTogetherRealNameVideoProcessHelper", 2, "showRealNameDialog click cancel.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class c extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<b> f448877a;

        c(b bVar) {
            this.f448877a = new WeakReference<>(bVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            if (QLog.isColorLevel()) {
                QLog.i("WTogetherRealNameVideoProcessHelper", 2, "onReceive action[" + action + "]");
            }
            if ("tencent.video.q2v.avReceivePushMsg".equals(action)) {
                boolean booleanExtra = intent.getBooleanExtra("real_name_result", false);
                b bVar = this.f448877a.get();
                if (bVar != null) {
                    bVar.f(booleanExtra);
                    bVar.n();
                }
            }
        }
    }

    public b(VideoAppInterface videoAppInterface) {
        this.f448868a = videoAppInterface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z16) {
        f448867g = Boolean.valueOf(z16);
    }

    private void h() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("tencent.video.q2v.avReceiveRealNameMsg");
        this.f448868a.getApplication().registerReceiver(this.f448870c, intentFilter);
        this.f448869b = true;
        if (QLog.isColorLevel()) {
            QLog.i("WTogetherRealNameVideoProcessHelper", 2, "register");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.f448868a.B0();
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        try {
            QLog.d("WTogetherRealNameVideoProcessHelper", 1, "unRegister start ");
            if (this.f448869b) {
                this.f448868a.getApplication().unregisterReceiver(this.f448870c);
                this.f448869b = false;
            }
        } catch (Exception e16) {
            QLog.d("WTogetherRealNameVideoProcessHelper", 1, "unregisterReceiver error : ", e16.getMessage());
        }
        if (QLog.isColorLevel()) {
            QLog.i("WTogetherRealNameVideoProcessHelper", 2, "unRegister");
        }
    }

    public void e(yw.a aVar) {
        if (g()) {
            aVar.a(true);
        } else {
            k(aVar);
            l();
        }
    }

    public boolean g() {
        Boolean valueOf = Boolean.valueOf(this.f448868a.S());
        f448867g = valueOf;
        return valueOf.booleanValue();
    }

    public void i(Activity activity) {
        this.f448872e = new WeakReference<>(activity);
    }

    public void j(String str) {
        this.f448873f = str;
    }

    public void k(yw.a aVar) {
        this.f448871d = aVar;
    }

    public void l() {
        Activity activity;
        String str;
        if (QLog.isColorLevel()) {
            QLog.i("WTogetherRealNameVideoProcessHelper", 2, "showRealNameDialog");
        }
        WeakReference<Activity> weakReference = this.f448872e;
        if (weakReference != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        Activity activity2 = activity;
        if (activity2 != null && (activity2 instanceof AVActivity)) {
            AVActivity aVActivity = (AVActivity) activity2;
            if (!aVActivity.isFinishing() && !aVActivity.isDestroyed()) {
                String string = activity2.getString(R.string.f170545zd2);
                String string2 = activity2.getString(R.string.f170544zd1);
                String str2 = this.f448873f;
                if (str2 != null) {
                    str = str2;
                } else {
                    str = string2;
                }
                QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity2, 230, string, str, activity2.getString(R.string.f2036650t), activity2.getString(R.string.f2036850v), new a(activity2), new DialogInterfaceOnClickListenerC11568b());
                createCustomDialog.setCancelable(false);
                createCustomDialog.show();
            }
        }
    }
}
