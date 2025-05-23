package v6;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.Interpolator;
import com.qzone.feed.gift.util.FeedGiftUtil;
import com.qzone.feed.gift.widget.CardFlipLayout;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends c {

    /* renamed from: j, reason: collision with root package name */
    private View f441163j;

    /* renamed from: k, reason: collision with root package name */
    private View f441164k;

    /* renamed from: l, reason: collision with root package name */
    private int f441165l;

    /* renamed from: m, reason: collision with root package name */
    private Handler f441166m;

    /* compiled from: P */
    /* renamed from: v6.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    class HandlerC11398a extends Handler {
        HandlerC11398a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 != 2) {
                    return;
                }
                a.this.t();
                a.this.q();
                return;
            }
            if (message.obj instanceof Boolean) {
                a.this.n();
                if (((Boolean) message.obj).booleanValue()) {
                    a.this.f441163j.setVisibility(8);
                    a.this.f441164k.setVisibility(0);
                } else {
                    a.this.f441163j.setVisibility(0);
                    a.this.f441164k.setVisibility(8);
                }
            }
        }
    }

    public a(View view, View view2, View view3) {
        super(view);
        this.f441165l = 1;
        this.f441166m = new HandlerC11398a(Looper.getMainLooper());
        this.f441163j = view2;
        this.f441164k = view3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        View view = this.f441163j;
        this.f441163j = this.f441164k;
        this.f441164k = view;
    }

    @Override // v6.c
    public long d() {
        return 400L;
    }

    @Override // v6.c
    public Interpolator e() {
        return new b();
    }

    public void o(boolean z16) {
        Message obtain = Message.obtain();
        obtain.obj = Boolean.valueOf(z16);
        obtain.what = 1;
        this.f441166m.sendMessage(obtain);
    }

    public void p(int i3) {
        q();
        s(i3);
        h();
    }

    public void r() {
        if (this.f441166m.hasMessages(2)) {
            this.f441166m.removeMessages(2);
        }
        this.f441166m.sendEmptyMessage(2);
    }

    public void s(int i3) {
        this.f441165l = i3;
    }

    public void q() {
        this.f441169b = 0.0f;
        this.f441174g = 0;
        this.f441165l = 1;
    }

    @Override // v6.c
    public void c(float f16) {
        float f17 = (float) (((((FeedGiftUtil.b() ? -1 : 1) * this.f441165l) * 180.0d) * (f16 * 3.141592653589793d)) / 3.141592653589793d);
        View view = this.f441170c;
        if (view instanceof CardFlipLayout) {
            ((CardFlipLayout) view).setMatrix(f17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
    }
}
