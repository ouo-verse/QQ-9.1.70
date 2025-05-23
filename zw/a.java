package zw;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.utils.VideoUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;
import eipc.EIPCResult;
import eipc.EIPClientConnectListener;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0002\u0019\rB\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J&\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0002R\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lzw/a;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "", "disconnect", "d", "", "action", "Landroid/os/Bundle;", "params", "", "callbackId", "Leipc/EIPCResult;", "onCall", "b", "c", "Lcom/tencent/av/app/VideoAppInterface;", "Lcom/tencent/av/app/VideoAppInterface;", "appInterface", "Lzw/a$b;", "e", "Lzw/a$b;", "mConnectListener", "<init>", "(Lcom/tencent/av/app/VideoAppInterface;)V", "f", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class a extends QIPCModule {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private VideoAppInterface appInterface;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b mConnectListener;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0002\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0016\u001a\u00020\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lzw/a$b;", "Leipc/EIPClientConnectListener;", "Leipc/EIPCOnGetConnectionListener;", "Leipc/EIPCConnection;", "serverProxy", "", "connectSuccess", "connectFailed", "conn", "onConnectBind", "onConnectUnbind", "Ljava/util/concurrent/atomic/AtomicInteger;", "d", "Ljava/util/concurrent/atomic/AtomicInteger;", "a", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setMConnectFlag", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "mConnectFlag", "", "b", "()Z", "isBind", "<init>", "()V", "e", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class b implements EIPClientConnectListener, EIPCOnGetConnectionListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private AtomicInteger mConnectFlag = new AtomicInteger(0);

        @NotNull
        /* renamed from: a, reason: from getter */
        public final AtomicInteger getMConnectFlag() {
            return this.mConnectFlag;
        }

        public final boolean b() {
            if (this.mConnectFlag.get() == 2) {
                return true;
            }
            return false;
        }

        @Override // eipc.EIPClientConnectListener
        public void connectFailed() {
            this.mConnectFlag.set(3);
            QLog.i("QAVClientQIPCModule", 1, "connectFailed");
        }

        @Override // eipc.EIPClientConnectListener
        public void connectSuccess(@NotNull EIPCConnection serverProxy) {
            Intrinsics.checkNotNullParameter(serverProxy, "serverProxy");
            this.mConnectFlag.set(2);
            QLog.i("QAVClientQIPCModule", 1, "connectSuccess, server[" + serverProxy.procName + "]");
        }

        @Override // eipc.EIPCOnGetConnectionListener
        public void onConnectBind(@Nullable EIPCConnection conn) {
            if (conn == null) {
                return;
            }
            QLog.i("QAVClientQIPCModule", 1, "onConnectBind, [" + conn.procName + "]");
            if (TextUtils.equals("com.tencent.mobileqq", conn.procName)) {
                this.mConnectFlag.set(2);
            }
        }

        @Override // eipc.EIPCOnGetConnectionListener
        public void onConnectUnbind(@Nullable EIPCConnection conn) {
            if (conn == null) {
                return;
            }
            QLog.i("QAVClientQIPCModule", 1, "onConnectUnbind, [" + conn.procName + "]");
            if (TextUtils.equals("com.tencent.mobileqq", conn.procName)) {
                this.mConnectFlag.set(4);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull VideoAppInterface appInterface) {
        super("QAVClientQIPCModule");
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        this.appInterface = appInterface;
        this.mConnectListener = new b();
        QIPCClientHelper.getInstance().register(this);
        QIPCClientHelper.getInstance().getClient().addListener(this.mConnectListener);
        d();
    }

    @NotNull
    public final EIPCResult b() {
        EIPCResult eIPCResult = new EIPCResult();
        eIPCResult.data = new Bundle();
        if (!this.mConnectListener.b()) {
            if (QLog.isColorLevel()) {
                QLog.i("QAVClientQIPCModule", 2, "isAudioType not bind");
            }
            eIPCResult.data.putBoolean("isAudioType", false);
            return eIPCResult;
        }
        boolean f16 = VideoUtil.f(this.appInterface);
        if (QLog.isColorLevel()) {
            QLog.i("QAVClientQIPCModule", 2, "isAudioType, " + f16);
        }
        eIPCResult.data.putBoolean("isAudioType", VideoUtil.f(this.appInterface));
        return eIPCResult;
    }

    public final void c() {
        if (!this.mConnectListener.b()) {
            if (QLog.isColorLevel()) {
                QLog.i("QAVClientQIPCModule", 2, "setInSmallHome not bind");
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.i("QAVClientQIPCModule", 2, "setInSmallHome called");
            }
            SessionInfo f16 = n.e().f();
            if (f16 != null) {
                f16.H2 = true;
            }
        }
    }

    public final void d() {
        if (this.mConnectListener.b()) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("QAVClientQIPCModule", 2, "connect, [" + this.mConnectListener.getMConnectFlag().get() + "]");
        }
        QIPCClientHelper.getInstance().getClient().connect(this.mConnectListener);
    }

    public final void disconnect() {
        if (QLog.isColorLevel()) {
            QLog.i("QAVClientQIPCModule", 2, "disconnect");
        }
        QIPCClientHelper.getInstance().disconnect();
    }

    @Override // eipc.EIPCModule
    @Nullable
    public EIPCResult onCall(@Nullable String action, @Nullable Bundle params, int callbackId) {
        if (QLog.isColorLevel()) {
            QLog.i("QAVClientQIPCModule", 2, "onCall, action[" + action + "]");
        }
        if (Intrinsics.areEqual(action, "action_get_is_audio_type")) {
            return b();
        }
        if (Intrinsics.areEqual(action, "action_set_in_small_home")) {
            c();
        }
        return null;
    }
}
