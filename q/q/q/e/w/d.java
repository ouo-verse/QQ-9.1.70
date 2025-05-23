package q.q.q.e.w;

import android.content.Context;
import android.util.Log;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.File;
import q.q.q.e.w.b;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class d extends b {

    /* renamed from: b, reason: collision with root package name */
    private static final q.q.q.e.w.a f428117b = q.q.q.e.w.a.e();

    /* renamed from: c, reason: collision with root package name */
    private static String f428118c = b.a();

    /* renamed from: d, reason: collision with root package name */
    private static d f428119d;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static class a extends BaseThread {
        private Context C;

        a(Context context) {
            this.C = context;
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                try {
                    String d16 = b.a.d(this.C);
                    b.a.a(this.C);
                    Log.i("honorid", "deleteLogFile");
                    d.k(d16);
                    d.f428117b.g(new File(d16, "honorid_advanced_log.txt"));
                    c.c(d.f428117b);
                } catch (ArrayIndexOutOfBoundsException e16) {
                    Log.e("honorid", "ArrayIndexOutOfBoundsException" + e16.getMessage());
                    b.a.a(this.C);
                } catch (Exception e17) {
                    Log.e("honorid", "Exception" + e17.getClass().getSimpleName());
                    b.a.a(this.C);
                }
            } catch (Throwable th5) {
                b.a.a(this.C);
                throw th5;
            }
        }
    }

    d(Context context) {
        new a(context).start();
    }

    private static synchronized void f(int i3, String str, String str2, Throwable th5, int i16) {
        synchronized (d.class) {
            if (!h(i3)) {
                return;
            }
            if (str2 == null) {
                str2 = "";
            }
            try {
                try {
                    Log.println(i3, f428118c + str, str2);
                } catch (IllegalArgumentException e16) {
                    Log.e("honorid", "println IllegalArgumentException" + e16.getMessage());
                }
            } catch (Exception e17) {
                Log.e("honorid", "println Exception" + e17.getClass().getSimpleName());
            }
        }
    }

    private static boolean h(int i3) {
        return Log.isLoggable("honorid", i3);
    }

    public static synchronized d j(Context context) {
        d dVar;
        synchronized (d.class) {
            if (f428119d == null) {
                f428119d = new d(context);
                f428118c = b.b(context);
            }
            dVar = f428119d;
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(String str) {
        File file = new File(str, "apphnid.txt");
        File file2 = new File(str, "apphnid.txt.bak");
        h45.c.e(file);
        h45.c.e(file2);
    }

    @Override // q.q.q.e.w.b
    public void c(String str, String str2) {
        f(3, str, str2, null, 2);
    }

    @Override // q.q.q.e.w.b
    public void d(String str, String str2) {
        f(6, str, str2, null, 2);
        c.b(str, str2);
    }

    @Override // q.q.q.e.w.b
    public void e(String str, String str2) {
        f(4, str, str2, null, 2);
        c.f(str, str2);
    }
}
