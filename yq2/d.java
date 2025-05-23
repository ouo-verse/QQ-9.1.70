package yq2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d implements Handler.Callback {

    /* renamed from: d, reason: collision with root package name */
    private a f451008d;

    /* renamed from: e, reason: collision with root package name */
    private int f451009e;

    /* renamed from: f, reason: collision with root package name */
    private int f451010f;

    /* renamed from: h, reason: collision with root package name */
    private int f451011h = 0;

    /* renamed from: i, reason: collision with root package name */
    public HandlerThread f451012i;

    /* renamed from: m, reason: collision with root package name */
    private Handler f451013m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        int d(a aVar, boolean z16, int i3, int i16);
    }

    public d(int i3, int i16) {
        this.f451009e = 1000 / i3;
        this.f451010f = ((int) ((i16 / 1000.0f) * i3)) + 1;
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("shortvideo_Timer");
        this.f451012i = baseHandlerThread;
        baseHandlerThread.start();
        this.f451013m = new Handler(this.f451012i.getLooper(), this);
    }

    private boolean c(Message message) {
        if (com.tencent.mobileqq.shortvideo.mediadevice.b.f288186b) {
            RMVideoStateMgr u16 = RMVideoStateMgr.u();
            boolean z16 = false;
            if (u16.f185893d) {
                double currentTimeMillis = System.currentTimeMillis() - u16.f185895e;
                u16.H = currentTimeMillis;
                if (currentTimeMillis >= CodecParam.RECORD_MAX_TIME) {
                    z16 = true;
                }
                if (QLog.isColorLevel() && z16) {
                    QLog.d("TCTimer", 2, "handleLooperEvent startTime=" + u16.f185895e + " total=" + u16.H);
                }
            } else if (this.f451011h >= this.f451010f) {
                z16 = true;
            }
            if (z16) {
                this.f451011h = this.f451010f;
            }
            int i3 = this.f451011h;
            int i16 = this.f451009e * i3;
            a aVar = this.f451008d;
            if (aVar != null) {
                aVar.d(aVar, z16, i16, i3);
            }
            this.f451011h++;
        }
        return true;
    }

    public void a() {
        this.f451012i.quit();
    }

    public int b() {
        return this.f451009e;
    }

    public void d() {
        this.f451011h = 0;
    }

    public void e(a aVar) {
        this.f451008d = aVar;
    }

    public void f(int i3) {
        this.f451011h = i3;
    }

    public void g() {
        this.f451013m.sendMessageDelayed(this.f451013m.obtainMessage(1398036036), this.f451009e);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1398036036) {
            return false;
        }
        Handler handler = this.f451013m;
        if (handler != null) {
            this.f451013m.sendMessageDelayed(handler.obtainMessage(1398036036), this.f451009e);
        }
        return c(message);
    }
}
