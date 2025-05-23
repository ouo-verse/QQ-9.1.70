package us3;

import android.os.Bundle;
import com.tencent.minibox.proxy.ObtainInfoCallback;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J \u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a8\u0006\u0010"}, d2 = {"Lus3/d;", "", "Lcom/tencent/minibox/proxy/ObtainInfoCallback;", "callback", "", tl.h.F, "obtainCallback", "e", "", "cmd", "Landroid/os/Bundle;", "params", "c", "d", "<init>", "()V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f439982a = new d();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"us3/d$a", "Lsd2/a;", "", "", "domainToKeyMap", "", "onSuccess", "errMsg", "onFail", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class a implements sd2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ObtainInfoCallback f439983a;

        a(ObtainInfoCallback obtainInfoCallback) {
            this.f439983a = obtainInfoCallback;
        }

        @Override // sd2.a
        public void onFail(@NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_host_info_callback_success", false);
            this.f439983a.callback(bundle);
            QLog.e("HostInfoUtil", 1, "requestPskey failed, errMsg=" + errMsg);
        }

        @Override // sd2.a
        public void onSuccess(@NotNull Map<String, String> domainToKeyMap) {
            boolean z16;
            Intrinsics.checkNotNullParameter(domainToKeyMap, "domainToKeyMap");
            String str = domainToKeyMap.get("gamecenter.qq.com");
            Bundle bundle = new Bundle();
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                bundle.putBoolean("key_host_info_callback_success", false);
            } else {
                bundle.putBoolean("key_host_info_callback_success", true);
                bundle.putString("key_host_info_pskey", str);
            }
            this.f439983a.callback(bundle);
        }
    }

    d() {
    }

    private final void e(final ObtainInfoCallback obtainCallback) {
        final EIPCResultCallback eIPCResultCallback = new EIPCResultCallback() { // from class: us3.b
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                d.f(ObtainInfoCallback.this, eIPCResult);
            }
        };
        ThreadManagerV2.excute(new Runnable() { // from class: us3.c
            @Override // java.lang.Runnable
            public final void run() {
                d.g(EIPCResultCallback.this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(ObtainInfoCallback obtainCallback, EIPCResult result) {
        String str;
        Intrinsics.checkNotNullParameter(obtainCallback, "$obtainCallback");
        Intrinsics.checkNotNullParameter(result, "result");
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_host_info_callback_success", result.isSuccess());
        Bundle bundle2 = result.data;
        if (bundle2 != null) {
            str = bundle2.getString("key_host_info_letsgo_redinfo");
        } else {
            str = null;
        }
        bundle.putString("key_host_info_letsgo_redinfo", str);
        obtainCallback.callback(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(EIPCResultCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        QIPCClientHelper.getInstance().callServer("minibox_qipc_module", "action_letsgo_redinfo", null, callback);
    }

    private final void h(ObtainInfoCallback callback) {
        Unit unit;
        IPskeyManager iPskeyManager;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iPskeyManager = (IPskeyManager) peekAppRuntime.getRuntimeService(IPskeyManager.class, "all")) != null) {
            iPskeyManager.getPskey(new String[]{"gamecenter.qq.com"}, new a(callback));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_host_info_callback_success", false);
            QLog.e("HostInfoUtil", 1, "requestPskey failed, runtime or manager is null.");
            callback.callback(bundle);
        }
    }

    public final void c(@NotNull String cmd, @Nullable Bundle params, @NotNull ObtainInfoCallback callback) {
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (Intrinsics.areEqual(cmd, "key_host_info_pskey")) {
            h(callback);
        } else if (Intrinsics.areEqual(cmd, "key_host_info_letsgo_redinfo")) {
            e(callback);
        }
    }

    @Nullable
    public final Bundle d(@NotNull String cmd, @Nullable Bundle params) {
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        return null;
    }
}
