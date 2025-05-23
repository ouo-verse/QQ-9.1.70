package xm0;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.open.appcommon.Common;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J$\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\"\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0010R\u001a\u0010\u0016\u001a\u00020\u00078\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lxm0/e;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "Lxm0/e$a;", "callback", "", "c", "unregister", "", "action", "Landroid/os/Bundle;", "params", "", "callbackId", "Leipc/EIPCResult;", "onCall", "data", "Leipc/EIPCResultCallback;", "b", "e", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "f", "Lxm0/e$a;", "mDownloadClient2WebCallback", "<init>", "()V", "a", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class e extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final e f448154d = new e();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG = "AdDownload.DownloadIPCWebClient";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static a mDownloadClient2WebCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lxm0/e$a;", "", "", "actionType", "data", "", "onEvent", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public interface a {
        void onEvent(@Nullable String actionType, @Nullable String data);
    }

    e() {
        super(xm0.a.f448135a.g());
    }

    public final void b(@NotNull String data, @Nullable String action, @Nullable EIPCResultCallback callback) {
        Intrinsics.checkNotNullParameter(data, "data");
        Bundle bundle = new Bundle();
        xm0.a aVar = xm0.a.f448135a;
        bundle.putString(aVar.b(), data);
        bundle.putString(aVar.f(), Common.m());
        QIPCClientHelper.getInstance().getClient().callServer(aVar.e(), action, bundle, callback);
    }

    public final void c(@Nullable a callback) {
        if (mDownloadClient2WebCallback != null) {
            return;
        }
        try {
            mDownloadClient2WebCallback = callback;
            QIPCClientHelper.getInstance().register(this);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "register real");
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "register ipc module error.", e16);
        }
    }

    @Override // eipc.EIPCModule
    @Nullable
    public EIPCResult onCall(@Nullable String action, @NotNull Bundle params, int callbackId) {
        Intrinsics.checkNotNullParameter(params, "params");
        try {
            a aVar = mDownloadClient2WebCallback;
            if (aVar != null) {
                aVar.onEvent(action, params.getString(xm0.a.f448135a.a()));
                return null;
            }
            return null;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public final void unregister() {
        try {
            mDownloadClient2WebCallback = null;
            if (QIPCClientHelper.getInstance().getClient() != null) {
                QIPCClientHelper.getInstance().getClient().unRegisterModule(this);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "unregister real");
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "unregister ipc module error.", e16);
        }
    }
}
