package wx;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: h, reason: collision with root package name */
    private static b f446638h;

    /* renamed from: i, reason: collision with root package name */
    private static Rect f446639i = new Rect();

    /* renamed from: a, reason: collision with root package name */
    private SessionInfo f446640a;

    /* renamed from: b, reason: collision with root package name */
    private QQAppInterface f446641b;

    /* renamed from: c, reason: collision with root package name */
    private Context f446642c;

    /* renamed from: d, reason: collision with root package name */
    private AbsListView f446643d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f446644e = false;

    /* renamed from: f, reason: collision with root package name */
    Handler f446645f = new a(Looper.getMainLooper());

    /* renamed from: g, reason: collision with root package name */
    public boolean f446646g = true;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                b bVar = b.this;
                bVar.f446644e = true;
                bVar.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        QLog.d("NowVideoController", 2, "Check play()");
    }

    public static b d() {
        if (f446638h == null) {
            synchronized (b.class) {
                if (f446638h == null) {
                    f446638h = new b();
                }
            }
        }
        return f446638h;
    }

    public void c() {
        this.f446643d = null;
        this.f446646g = true;
        this.f446642c = null;
        this.f446641b = null;
        this.f446644e = false;
        this.f446640a = null;
    }

    public void e() {
        if (QLog.isColorLevel()) {
            QLog.d("NowVideoController", 2, "onNetWifi2Mobile(): ====>");
        }
        QQAppInterface qQAppInterface = this.f446641b;
        if (qQAppInterface == null || this.f446643d == null || this.f446642c == null || !qQAppInterface.getMessageFacade().K1()) {
            return;
        }
        this.f446645f.removeMessages(2);
        this.f446645f.sendEmptyMessage(2);
        f();
    }

    public void f() {
    }
}
