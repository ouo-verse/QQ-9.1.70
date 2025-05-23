package v6;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.Interpolator;

/* compiled from: P */
/* loaded from: classes36.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private long f441168a;

    /* renamed from: b, reason: collision with root package name */
    protected float f441169b;

    /* renamed from: c, reason: collision with root package name */
    protected View f441170c;

    /* renamed from: d, reason: collision with root package name */
    protected b f441171d;

    /* renamed from: g, reason: collision with root package name */
    protected int f441174g = 0;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f441175h = false;

    /* renamed from: i, reason: collision with root package name */
    protected Handler f441176i = new a(Looper.getMainLooper());

    /* renamed from: e, reason: collision with root package name */
    protected long f441172e = d();

    /* renamed from: f, reason: collision with root package name */
    protected Interpolator f441173f = e();

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            float f16;
            super.handleMessage(message);
            if (message.what == 1 && !c.this.f441175h) {
                long currentTimeMillis = System.currentTimeMillis() - c.this.f441168a;
                c cVar = c.this;
                float f17 = cVar.f441169b;
                if (f17 == 0.0f && cVar.f441174g == 0) {
                    f16 = ((float) currentTimeMillis) / ((float) cVar.f441172e);
                } else if (cVar.f441174g == -1) {
                    f16 = f17 - (((float) currentTimeMillis) / ((float) cVar.f441172e));
                } else {
                    f16 = (((float) currentTimeMillis) / ((float) cVar.f441172e)) + f17;
                }
                float f18 = cVar.f(f16);
                c.this.c(f18);
                b bVar = c.this.f441171d;
                if (bVar != null) {
                    bVar.a(f18);
                }
                c cVar2 = c.this;
                if (cVar2.f441169b >= 0.0f) {
                    if (f16 > 1.0f || f16 < 0.0f) {
                        cVar2.i();
                        b bVar2 = c.this.f441171d;
                        if (bVar2 != null) {
                            bVar2.onAnimationFinish();
                            return;
                        }
                        return;
                    }
                } else if (f16 < -1.0f || f16 > 0.0f) {
                    cVar2.i();
                    b bVar3 = c.this.f441171d;
                    if (bVar3 != null) {
                        bVar3.onAnimationFinish();
                        return;
                    }
                    return;
                }
                cVar2.f441176i.sendEmptyMessageDelayed(1, 10L);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public interface b {
        void a(float f16);

        void b();

        void c(int i3);

        void onAnimationFinish();
    }

    public c(View view) {
        this.f441170c = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x001c, code lost:
    
        if (r4 > 0.0f) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0010, code lost:
    
        if (r4 < 0.0f) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001f, code lost:
    
        r1 = r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public float f(float f16) {
        float f17 = 0.0f;
        if (this.f441169b >= 0.0f) {
            if (f16 > 1.0f) {
                f16 = 1.0f;
            }
        } else if (f16 < -1.0f) {
            f16 = -1.0f;
        }
        Interpolator interpolator = this.f441173f;
        return (interpolator == null || this.f441174g != 0) ? f17 : interpolator.getInterpolation(f17);
    }

    public abstract void c(float f16);

    public abstract long d();

    public abstract Interpolator e();

    public void g(b bVar) {
        this.f441171d = bVar;
    }

    public void h() {
        i();
        this.f441168a = System.currentTimeMillis();
        b bVar = this.f441171d;
        if (bVar != null) {
            bVar.b();
        }
        this.f441175h = false;
        this.f441176i.sendEmptyMessage(1);
    }

    public void i() {
        this.f441175h = true;
        if (this.f441176i.hasMessages(1)) {
            this.f441176i.removeMessages(1);
        }
    }
}
