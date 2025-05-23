package xm0;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gdtad.downloader.p;
import com.tencent.gdtad.downloader.t;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)J$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u001a\u0010\u0011\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\u0015\u001a\u00020\u00062\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012J\u0016\u0010\u0016\u001a\u00020\u00062\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012R\u001a\u0010\u001b\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001eR\"\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010!R\u0017\u0010'\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\u0017\u0010&\u00a8\u0006*"}, d2 = {"Lxm0/c;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "", "processName", "data", "action", "", "d", "Lcom/tencent/open/downloadnew/DownloadInfo;", "info", "f", "Landroid/os/Bundle;", "params", "", "callbackId", "Leipc/EIPCResult;", "onCall", "c", "Ljava/lang/ref/WeakReference;", "Lxm0/d;", "weakListener", "g", h.F, "e", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/concurrent/ConcurrentHashMap;", "mProcessMap", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "mListeners", "Lcom/tencent/gdtad/downloader/t;", "i", "Lcom/tencent/gdtad/downloader/t;", "()Lcom/tencent/gdtad/downloader/t;", "downloadTaskListener", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final c f448149d = new c();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG = "AdDownload.DownloadIPCMainClient";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ConcurrentHashMap<String, Boolean> mProcessMap = new ConcurrentHashMap<>();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static CopyOnWriteArrayList<WeakReference<d>> mListeners = new CopyOnWriteArrayList<>();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final t downloadTaskListener = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"xm0/c$a", "Lcom/tencent/gdtad/downloader/t;", "Lcom/tencent/open/downloadnew/DownloadInfo;", "info", "", "f", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a extends t {
        a() {
        }

        @Override // com.tencent.gdtad.downloader.t
        public void f(@Nullable DownloadInfo info) {
            JSONObject jSONObject;
            c cVar = c.f448149d;
            if (info != null) {
                jSONObject = info.l();
            } else {
                jSONObject = null;
            }
            cVar.c(String.valueOf(jSONObject), xm0.a.f448135a.d());
            cVar.f(info);
        }
    }

    c() {
        super(xm0.a.f448135a.e());
    }

    private final void d(String processName, String data, String action) {
        if (data != null) {
            Bundle bundle = new Bundle();
            xm0.a aVar = xm0.a.f448135a;
            bundle.putString(aVar.a(), data);
            QIPCServerHelper.getInstance().callClient(processName, aVar.g(), action, bundle, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(DownloadInfo info) {
        d dVar;
        Iterator<WeakReference<d>> it = mListeners.iterator();
        while (it.hasNext()) {
            WeakReference<d> next = it.next();
            if (next != null && (dVar = next.get()) != null) {
                dVar.a(info);
            }
        }
    }

    public final void c(@Nullable String data, @Nullable String action) {
        for (String processName : mProcessMap.keySet()) {
            boolean isProcessRunning = QIPCServerHelper.getInstance().isProcessRunning(processName);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "callClient data:" + data + " processName:" + processName + " isProcessRunning:" + isProcessRunning);
            }
            if (isProcessRunning) {
                Intrinsics.checkNotNullExpressionValue(processName, "processName");
                d(processName, data, action);
            }
        }
    }

    @NotNull
    public final t e() {
        return downloadTaskListener;
    }

    public final void g(@Nullable WeakReference<d> weakListener) {
        if (weakListener == null) {
            QLog.e(TAG, 1, "[registerListener] error, weakListener is null");
        } else if (weakListener.get() == null) {
            QLog.e(TAG, 1, "[registerListener] error, listener is null");
        } else {
            QLog.i(TAG, 1, "[registerListener]");
            mListeners.add(weakListener);
        }
    }

    public final void h(@Nullable WeakReference<d> weakListener) {
        if (weakListener == null) {
            QLog.e(TAG, 1, "[unRegisterListener] error, weakListener is null");
            return;
        }
        d dVar = weakListener.get();
        if (dVar == null) {
            QLog.e(TAG, 1, "[unRegisterListener] error, listener is null");
            return;
        }
        Iterator<WeakReference<d>> it = mListeners.iterator();
        while (it.hasNext()) {
            WeakReference<d> next = it.next();
            if (next != null && Intrinsics.areEqual(next.get(), dVar)) {
                QLog.i(TAG, 1, "[unRegisterListener]");
                mListeners.remove(next);
                return;
            }
        }
        QLog.e(TAG, 1, "[unRegisterListener] error, not exists");
    }

    @Override // eipc.EIPCModule
    @Nullable
    public EIPCResult onCall(@NotNull String action, @NotNull Bundle params, int callbackId) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(params, "params");
        xm0.a aVar = xm0.a.f448135a;
        if (Intrinsics.areEqual(aVar.c(), action)) {
            String callProcessName = params.getString(aVar.f(), null);
            if (!TextUtils.isEmpty(callProcessName)) {
                ConcurrentHashMap<String, Boolean> concurrentHashMap = mProcessMap;
                Intrinsics.checkNotNullExpressionValue(callProcessName, "callProcessName");
                concurrentHashMap.put(callProcessName, Boolean.TRUE);
            }
            p.f109191a.i(new JSONObject(params.getString(aVar.b(), null)), downloadTaskListener);
        }
        return null;
    }
}
