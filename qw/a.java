package qw;

import android.content.Context;
import android.content.Intent;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.ScreenRecordHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static String f430218b = "a";

    /* renamed from: c, reason: collision with root package name */
    private static a f430219c;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<Context> f430220a;

    private AVActivity a() {
        WeakReference<Context> weakReference = this.f430220a;
        if (weakReference == null || weakReference.get() == null || !(this.f430220a.get() instanceof AVActivity)) {
            return null;
        }
        return (AVActivity) this.f430220a.get();
    }

    public static a b() {
        if (f430219c == null) {
            f430219c = new a();
        }
        return f430219c;
    }

    public void c(Context context) {
        QLog.e(f430218b, 1, "[setContent] context=" + context);
        this.f430220a = new WeakReference<>(context);
    }

    public void d(Intent intent) {
        AVActivity a16 = a();
        if (a16 == null) {
            QLog.e(f430218b, 1, "[startCapture] context is null.");
            return;
        }
        ScreenRecordHelper d36 = a16.d3();
        d36.x(intent);
        d36.g();
        QLog.d(f430218b, 1, "[startCapture].");
    }
}
