package xm0;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.open.appcommon.Common;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001$B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004J\u0016\u0010\t\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004J$\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\"\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013R\u001a\u0010\u0019\u001a\u00020\n8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R \u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00040\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006%"}, d2 = {"Lxm0/b;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "Lxm0/b$a;", "inputCallBack", "Ljava/lang/ref/WeakReference;", "c", "weakCallBack", "", "d", "e", "", "action", "Landroid/os/Bundle;", "params", "", "callbackId", "Leipc/EIPCResult;", "onCall", "data", "Leipc/EIPCResultCallback;", "callback", "b", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "Ljava/util/concurrent/CopyOnWriteArrayList;", "f", "Ljava/util/concurrent/CopyOnWriteArrayList;", "mCallBackList", "Ljava/util/concurrent/atomic/AtomicBoolean;", h.F, "Ljava/util/concurrent/atomic/AtomicBoolean;", "mIsRegisteredIPCMoudle", "<init>", "()V", "a", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final b f448145d = new b();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG = "AdDownload.DownloadIPCHalfScreenClient";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<WeakReference<a>> mCallBackList = new CopyOnWriteArrayList<>();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicBoolean mIsRegisteredIPCMoudle = new AtomicBoolean(false);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lxm0/b$a;", "", "", "actionType", "data", "", "onEvent", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public interface a {
        void onEvent(@Nullable String actionType, @Nullable String data);
    }

    b() {
        super(xm0.a.f448135a.g());
    }

    private final WeakReference<a> c(a inputCallBack) {
        a aVar;
        WeakReference<a> next;
        Iterator<WeakReference<a>> it = mCallBackList.iterator();
        do {
            aVar = null;
            if (!it.hasNext()) {
                return null;
            }
            next = it.next();
            if (next != null) {
                aVar = next.get();
            }
        } while (aVar != inputCallBack);
        QLog.i(TAG, 1, "[register] duplicate IChangeBackgroundStatusCallBack");
        return next;
    }

    public final void b(@NotNull String data, @Nullable String action, @Nullable EIPCResultCallback callback) {
        Intrinsics.checkNotNullParameter(data, "data");
        Bundle bundle = new Bundle();
        xm0.a aVar = xm0.a.f448135a;
        bundle.putString(aVar.b(), data);
        bundle.putString(aVar.f(), Common.m());
        QIPCClientHelper.getInstance().getClient().callServer(aVar.e(), action, bundle, callback);
    }

    public final void d(@Nullable WeakReference<a> weakCallBack) {
        a aVar;
        if (weakCallBack != null) {
            aVar = weakCallBack.get();
        } else {
            aVar = null;
        }
        if (aVar == null) {
            QLog.i(TAG, 1, "[register] callBackToRegister is null");
            return;
        }
        if (c(aVar) != null) {
            QLog.i(TAG, 1, "[register] duplicate callBackToRegister");
            return;
        }
        mCallBackList.add(weakCallBack);
        try {
            if (!mIsRegisteredIPCMoudle.getAndSet(true)) {
                QIPCClientHelper.getInstance().register(this);
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[register] real");
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "[register] ipc module error.", e16);
        }
    }

    public final void e(@Nullable WeakReference<a> weakCallBack) {
        a aVar;
        if (weakCallBack != null) {
            aVar = weakCallBack.get();
        } else {
            aVar = null;
        }
        if (aVar == null) {
            QLog.i(TAG, 1, "[unRegister] callBackToUnregister is null");
            return;
        }
        WeakReference<a> c16 = c(aVar);
        if (c16 != null) {
            mCallBackList.remove(c16);
        }
        if (mCallBackList.size() > 0) {
            QLog.i(TAG, 1, "[unRegister] no need to unRegister module");
            return;
        }
        try {
            if (QIPCClientHelper.getInstance().getClient() != null && mIsRegisteredIPCMoudle.getAndSet(false)) {
                QIPCClientHelper.getInstance().getClient().unRegisterModule(this);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "[unregister] real");
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "[unregister] ipc module error.", e16);
        }
    }

    @Override // eipc.EIPCModule
    @Nullable
    public EIPCResult onCall(@Nullable String action, @NotNull Bundle params, int callbackId) {
        a aVar;
        Intrinsics.checkNotNullParameter(params, "params");
        try {
            Iterator<WeakReference<a>> it = mCallBackList.iterator();
            while (it.hasNext()) {
                WeakReference<a> next = it.next();
                if (next != null) {
                    aVar = next.get();
                } else {
                    aVar = null;
                }
                if (aVar != null) {
                    aVar.onEvent(action, params.getString(xm0.a.f448135a.a()));
                }
            }
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "[onCall] ipc module error.", e16);
        }
        return null;
    }
}
