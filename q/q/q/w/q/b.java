package q.q.q.w.q;

import android.content.Context;
import com.hihonor.honorid.core.helper.handler.ErrorStatus;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import q.q.q.e.w.e;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class b implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    protected final CountDownLatch f428129d;

    /* renamed from: e, reason: collision with root package name */
    protected final AtomicBoolean f428130e;

    /* renamed from: f, reason: collision with root package name */
    protected Context f428131f;

    private void f() {
        if (!this.f428130e.get()) {
            this.f428130e.set(true);
            b(null);
            e();
        }
    }

    protected abstract void a();

    public abstract void b(ErrorStatus errorStatus);

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        e.c("AIDLTask", "finishTask", true);
        a c16 = a.c(this.f428131f);
        if (c16 != null) {
            c16.d();
        }
        this.f428129d.countDown();
        this.f428130e.set(true);
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
        try {
            if (!this.f428129d.await(12000L, TimeUnit.MILLISECONDS)) {
                f();
            }
        } catch (InterruptedException unused) {
            e.c("AIDLTask", "execute await InterruptedException", true);
            f();
        }
    }
}
