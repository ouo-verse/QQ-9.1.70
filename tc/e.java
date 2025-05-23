package tc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.lifecycle.MutableLiveData;
import com.qzone.reborn.base.n;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes36.dex */
public class e extends n {
    private NetworkState.NetworkStateListener C;

    /* renamed from: i, reason: collision with root package name */
    public MutableLiveData<Boolean> f435819i = new MutableLiveData<>(Boolean.TRUE);

    /* renamed from: m, reason: collision with root package name */
    protected boolean f435820m;

    /* JADX INFO: Access modifiers changed from: private */
    public void O1(boolean z16) {
        QZLog.w(getLogTag(), "onNetworkConnect() connected: " + z16);
        Message obtain = Message.obtain();
        obtain.what = 86;
        obtain.obj = Boolean.valueOf(z16);
        new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: tc.d
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean P1;
                P1 = e.this.P1(message);
                return P1;
            }
        }).sendMessageDelayed(obtain, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean P1(Message message) {
        if (message.what != 86) {
            return false;
        }
        Q1(((Boolean) message.obj).booleanValue());
        return false;
    }

    protected void Q1(boolean z16) {
        QZLog.w(getLogTag(), "onNetStateChanged() hasNet: " + z16);
        this.f435819i.setValue(Boolean.valueOf(z16));
    }

    public void R1(boolean z16) {
        this.f435820m = z16;
        if (z16) {
            if (this.C == null) {
                this.C = new NetworkState.NetworkStateListener() { // from class: tc.c
                    @Override // cooperation.qzone.util.NetworkState.NetworkStateListener
                    public final void onNetworkConnect(boolean z17) {
                        e.this.O1(z17);
                    }
                };
            }
            NetworkState.addListener(this.C);
            this.f435819i.setValue(Boolean.valueOf(NetworkState.isNetSupport()));
            QZLog.w(getLogTag(), "setNetStateCallback isNetSupport(): " + this.f435819i.getValue());
            return;
        }
        NetworkState.NetworkStateListener networkStateListener = this.C;
        if (networkStateListener != null) {
            NetworkState.removeListener(networkStateListener);
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QZoneNetworkStateViewModel";
    }

    public void onDestroy() {
        NetworkState.NetworkStateListener networkStateListener;
        if (!this.f435820m || (networkStateListener = this.C) == null) {
            return;
        }
        NetworkState.removeListener(networkStateListener);
    }
}
