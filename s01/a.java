package s01;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static int f433062c = 4;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<HandlerThread> f433063a;

    /* renamed from: b, reason: collision with root package name */
    private AtomicInteger f433064b;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        static final a f433065a = new a();
    }

    public static a b() {
        return b.f433065a;
    }

    public int a() {
        return this.f433064b.getAndIncrement();
    }

    public Looper c(int i3) {
        int i16 = i3 % f433062c;
        if (i16 >= this.f433063a.size()) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("FrameDecoderExecutor-" + i16);
            baseHandlerThread.start();
            this.f433063a.add(baseHandlerThread);
            Looper looper = baseHandlerThread.getLooper();
            if (looper != null) {
                return looper;
            }
            return Looper.getMainLooper();
        }
        if (this.f433063a.get(i16) != null) {
            Looper looper2 = this.f433063a.get(i16).getLooper();
            if (looper2 != null) {
                return looper2;
            }
            return Looper.getMainLooper();
        }
        return Looper.getMainLooper();
    }

    a() {
        this.f433063a = new ArrayList<>();
        this.f433064b = new AtomicInteger(0);
    }
}
