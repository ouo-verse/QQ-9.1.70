package so;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.Log;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.state.data.SquareJSConst;
import com.tenpay.sdk.util.QQFaceFileUtil;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b {

    /* renamed from: e, reason: collision with root package name */
    private static final Object f434009e = new Object();

    /* renamed from: f, reason: collision with root package name */
    private static volatile b f434010f;

    /* renamed from: b, reason: collision with root package name */
    private String f434012b;

    /* renamed from: c, reason: collision with root package name */
    private InterfaceC11240b f434013c;

    /* renamed from: d, reason: collision with root package name */
    private BroadcastReceiver f434014d = new a();

    /* renamed from: a, reason: collision with root package name */
    private Context f434011a = BaseApplication.getContext();

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (b.this.f434013c == null || intent == null) {
                return;
            }
            try {
                if ("com.tencent.process.exit".equals(intent.getAction())) {
                    ArrayList<String> stringArrayList = intent.getExtras().getStringArrayList("procNameList");
                    if (b.this.g(intent.getExtras().getString("verify"), stringArrayList) && b.this.f(stringArrayList)) {
                        QZLog.e(QZLog.TO_DEVICE_TAG, "***exitProcexx*** receive broacast action=" + intent.getAction());
                        if (b.this.f434013c != null) {
                            b.this.f434013c.onExit();
                        }
                    }
                }
            } catch (Exception e16) {
                QZLog.e(QZLog.TO_DEVICE_TAG, "error on $qqExitBroadcastReceiver :", e16);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: so.b$b, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public interface InterfaceC11240b {
        void onExit();
    }

    b() {
    }

    public static b d() {
        if (f434010f == null) {
            synchronized (f434009e) {
                if (f434010f == null) {
                    f434010f = new b();
                }
            }
        }
        return f434010f;
    }

    private String e(ArrayList<String> arrayList, boolean z16) {
        String obj;
        Time time = new Time();
        time.setToNow();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("com.tencent.process.exit");
        sb5.append(time.year);
        sb5.append(time.month + 1);
        sb5.append(time.monthDay);
        sb5.append(time.hour);
        if (z16) {
            sb5.append(time.minute - 1);
        } else {
            sb5.append(time.minute);
        }
        if (arrayList == null) {
            obj = "null";
        } else {
            obj = arrayList.toString();
        }
        sb5.append(obj);
        return MD5.toMD5(MD5.toMD5(sb5.toString()) + sb5.toString());
    }

    public void h(String str, InterfaceC11240b interfaceC11240b) {
        this.f434013c = interfaceC11240b;
        this.f434012b = str;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.process.exit");
        this.f434011a.registerReceiver(this.f434014d, intentFilter);
    }

    public void i(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            QZLog.d("BroadcastManager", 1, "[sendBroadcast] action is empty, end flow.");
            return;
        }
        if (this.f434011a == null) {
            QZLog.d("BroadcastManager", 1, "[sendBroadcast] current context is null, update context.");
            this.f434011a = BaseApplication.getContext();
        }
        Intent intent = new Intent();
        intent.setAction(str);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        Context context = this.f434011a;
        if (context != null) {
            context.sendBroadcast(intent, str2);
        } else {
            QZLog.d("BroadcastManager", 1, "[sendBroadcast] context is null, send broadcast fail.");
        }
    }

    public void j(ArrayList<String> arrayList) {
        try {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList(SquareJSConst.Params.PARAMS_UIN_LIST, arrayList);
            i("com.tencent.qqhead.getheadreq", QQFaceFileUtil.QQFaceImageGetter.ReceiverQQFacePermission, bundle);
        } catch (Throwable th5) {
            QZLog.w(QZLog.TO_DEVICE_TAG, Log.getStackTraceString(th5));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return true;
        }
        String str = this.f434012b;
        if (str == null) {
            return false;
        }
        return arrayList.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(String str, ArrayList<String> arrayList) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return str.equals(e(arrayList, false)) || str.equals(e(arrayList, true));
    }
}
