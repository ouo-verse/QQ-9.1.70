package tn;

import android.app.Activity;
import android.content.DialogInterface;
import android.widget.TextView;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.component.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQCustomDialog;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import yo.d;
import yo.g;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f436635a = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: tn.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public class DialogInterfaceOnClickListenerC11300a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f436636d;

        DialogInterfaceOnClickListenerC11300a(Activity activity) {
            this.f436636d = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            a.this.d(this.f436636d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class b implements DialogInterface.OnDismissListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            a.this.f436635a = false;
        }
    }

    public void e(Activity activity, QZoneResult qZoneResult) {
        c(activity, qZoneResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Activity activity) {
        QZLog.d("QZoneServerResultPreProcessor", 1, "jumpBindPhoneUrl");
        d.b(activity, new g(QzoneConfig.getInstance().getConfig("QZoneSetting", "bind_phone_h5_url", "https://accounts.qq.com/safe/setup/securityphone")));
    }

    private void c(Activity activity, QZoneResult qZoneResult) {
        if (activity == null || qZoneResult == null || this.f436635a || qZoneResult.getReturnCode() != -10024) {
            return;
        }
        QZLog.d("QZoneServerResultPreProcessor", 1, "checkBindPhoneResult need show dialog");
        QQCustomDialog f16 = new e().f(activity, 230, activity.getString(R.string.f2191965r), activity.getString(R.string.f2191765p), activity.getString(R.string.f2191865q), activity.getString(R.string.f2191665o), new DialogInterfaceOnClickListenerC11300a(activity), null);
        if (f16 == null) {
            return;
        }
        TextView btnLeft = f16.getBtnLeft();
        if (btnLeft != null) {
            btnLeft.setTextColor(-7829368);
        }
        f16.setOnDismissListener(new b());
        this.f436635a = true;
        f16.show();
    }
}
