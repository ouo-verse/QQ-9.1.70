package wy2;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.view.WindowManager;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.util.ba;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.List;
import kotlinx.coroutines.DebugKt;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private b f446748a;

    /* renamed from: b, reason: collision with root package name */
    public int f446749b = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final c f446750a = new c();
    }

    c() {
        this.f446748a = null;
        this.f446748a = b.a();
    }

    public static c d() {
        return a.f446750a;
    }

    public Bitmap a(Bitmap bitmap, int i3) {
        if (bitmap != null) {
            return Bitmap.createScaledBitmap(bitmap, i3, i3, true);
        }
        return null;
    }

    public String b() {
        return b.f446742g;
    }

    public String c() {
        return b.f446743h;
    }

    public int e() {
        return 1;
    }

    public boolean f() {
        if (this.f446748a.d(0) || !this.f446748a.d(1)) {
            return false;
        }
        return true;
    }

    @TargetApi(16)
    public Notification g(Intent intent, Bitmap bitmap, String str, String str2, String str3, boolean z16, BaseQQAppInterface baseQQAppInterface, boolean z17, boolean z18) {
        int i3;
        int i16;
        if (intent.getIntExtra("uintype", -1) == 1008) {
            if (!AppConstants.REMINDER_UIN.equals(intent.getStringExtra("uin"))) {
                i3 = R.drawable.br7;
            }
            i3 = R.drawable.b8g;
        } else if (intent.getIntExtra("uintype", -1) == 1010 && String.valueOf(AppConstants.DATE_UIN).equals(intent.getStringExtra("uin"))) {
            i3 = R.drawable.eya;
        } else {
            if ((intent.getIntExtra("uintype", -1) == 1001 || intent.getIntExtra("uintype", -1) == 10002) && String.valueOf(AppConstants.LBS_HELLO_UIN).equals(intent.getStringExtra("uin"))) {
                i3 = R.drawable.icon_recent_lbs_hello_notify_small;
            }
            i3 = R.drawable.b8g;
        }
        if (intent.getBooleanExtra("qav_notify_flag", false)) {
            i3 = R.drawable.h9n;
        }
        intent.putExtra(QQNotificationManager.PARAM_NOTIFYID, i3);
        if (z18) {
            i16 = 201326592;
        } else {
            i16 = 134217728;
        }
        PendingIntent activity = PendingIntent.getActivity(BaseApplication.getContext(), 0, intent, i16);
        if (QLog.isColorLevel()) {
            QLog.i("MobileQQService", 2, "buildNotification by getActivity(kapalai). contentIntent=" + activity + ",flag=" + i16);
        }
        Notification.Builder ticker = new Notification.Builder(BaseApplication.getContext()).setSmallIcon(i3).setAutoCancel(true).setWhen(System.currentTimeMillis()).setTicker(str);
        if (z17) {
            ticker.setOngoing(true);
        }
        try {
            Method declaredMethod = Class.forName("android.app.Notification$Builder").getDeclaredMethod("setInternalApp", Integer.TYPE);
            if (declaredMethod != null) {
                declaredMethod.invoke(ticker, 1);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (ba.a(BaseApplication.getContext(), baseQQAppInterface)) {
            Calendar.getInstance().get(11);
            ticker.setLights(-16711936, 2000, 2000);
        }
        if (z16) {
            if (bitmap != null) {
                ticker.setLargeIcon(bitmap);
            }
            ticker.setContentTitle(str2).setContentText(str3).setContentIntent(activity);
        } else {
            ticker.setContentTitle(str2).setContentText(str3).setContentIntent(activity);
            if (bitmap != null) {
                ticker.setLargeIcon(bitmap);
            }
        }
        try {
            return ticker.build();
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.e("kapalaiBuildNotificationForMeizu", 2, e17.getMessage());
            }
            return new Notification(i3, str, System.currentTimeMillis());
        }
    }

    public Intent h(Intent intent) {
        intent.putExtra(b(), Integer.parseInt(c()));
        return null;
    }

    public String i(Camera.Parameters parameters) {
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        if (supportedFlashModes.contains("torch")) {
            return "torch";
        }
        if (supportedFlashModes.contains("on")) {
            return "on";
        }
        if (supportedFlashModes.contains("auto")) {
            return "auto";
        }
        return DebugKt.DEBUG_PROPERTY_VALUE_OFF;
    }

    public void j(WindowManager.LayoutParams layoutParams) {
        layoutParams.screenBrightness = 0.035f;
    }

    public void k(Intent intent) {
        intent.setFlags(337641472);
    }
}
