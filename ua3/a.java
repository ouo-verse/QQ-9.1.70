package ua3;

import android.text.TextUtils;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.mobileqq.winkpublish.util.b;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.manager.MainTicketCallback;
import mqq.manager.MainTicketInfo;
import mqq.manager.TicketManager;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static final String f438645b = UploadConstants.TAG + "LoginData";

    /* renamed from: c, reason: collision with root package name */
    private static volatile a f438646c = null;

    /* renamed from: d, reason: collision with root package name */
    private static final Object f438647d = new Object();

    /* renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap<Long, String> f438648a = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: ua3.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public class C11334a implements MainTicketCallback {
        C11334a() {
        }

        @Override // mqq.manager.MainTicketCallback
        public void onFail(int i3, String str) {
            QLog.w(a.f438645b, 1, "errorCode:" + i3 + " errorMsg:" + str);
            a aVar = a.this;
            aVar.f438648a.put(Long.valueOf(aVar.f()), "");
        }

        @Override // mqq.manager.MainTicketCallback
        public void onSuccess(MainTicketInfo mainTicketInfo) {
            QLog.i(a.f438645b, 1, "preGetA2... onSuccess info:" + a.this.f());
            a aVar = a.this;
            aVar.f438648a.put(Long.valueOf(aVar.f()), mainTicketInfo.getA2());
        }
    }

    public static a d() {
        if (f438646c == null) {
            synchronized (f438647d) {
                if (f438646c == null) {
                    f438646c = new a();
                }
            }
        }
        return f438646c;
    }

    public byte[] b(boolean z16) {
        return b.b(c(z16));
    }

    public String c(boolean z16) {
        TicketManager e16 = e();
        if (e16 == null) {
            return "";
        }
        if (e16.useAsyncTicketInterface()) {
            if (!TextUtils.isEmpty(this.f438648a.get(Long.valueOf(f())))) {
                return this.f438648a.get(Long.valueOf(f()));
            }
            QLog.w(f438645b, 1, "a2Map is null");
            if (z16) {
                String a26 = e16.getA2(g());
                this.f438648a.put(Long.valueOf(f()), a26);
                return a26;
            }
            h();
            return null;
        }
        return e16.getA2(g());
    }

    public TicketManager e() {
        if (MobileQQ.sMobileQQ.peekAppRuntime() != null) {
            return (TicketManager) MobileQQ.sMobileQQ.peekAppRuntime().getManager(2);
        }
        return null;
    }

    public long f() {
        String g16 = g();
        if (TextUtils.isEmpty(g16)) {
            return 0L;
        }
        try {
            return Long.parseLong(g16);
        } catch (Exception e16) {
            QLog.w(f438645b, 1, e16.getMessage());
            return 0L;
        }
    }

    public String g() {
        return ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
    }

    public void h() {
        String str = f438645b;
        QLog.w(str, 1, "preGetA2...");
        TicketManager e16 = e();
        if (e16 == null) {
            QLog.e(str, 1, "ticketManager == null");
        } else {
            e16.getA2(f(), 16, new C11334a());
        }
    }

    public void i() {
        QLog.i(f438645b, 1, "resetA2...");
        this.f438648a.clear();
    }
}
