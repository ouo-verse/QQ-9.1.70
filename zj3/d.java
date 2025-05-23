package zj3;

import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.zplan.reshub.impl.shiply.delegate.ShiplySSOBusinessHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.standard.net.IRNetwork;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.os.MqqHandler;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016JT\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lzj3/d;", "Lcom/tencent/raft/standard/net/IRNetwork;", "Lcom/tencent/raft/standard/net/IRNetwork$NetworkStatus;", "getNetworkStatus", "Lcom/tencent/raft/standard/net/IRNetwork$HttpMethod;", "method", "", "urlString", "", "headers", "parameters", "", "payload", "Lcom/tencent/raft/standard/net/IRNetwork$INetworkResult;", "result", "", "requestWithMethod", "Lcom/tencent/rdelivery/dependencyimpl/c;", "a", "Lcom/tencent/rdelivery/dependencyimpl/c;", "getHttpsURLConnectionNetwork", "()Lcom/tencent/rdelivery/dependencyimpl/c;", "httpsURLConnectionNetwork", "<init>", "(Lcom/tencent/rdelivery/dependencyimpl/c;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d implements IRNetwork {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.rdelivery.dependencyimpl.c httpsURLConnectionNetwork;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"zj3/d$a", "Lzj3/b;", "", "type", "", "isSuccess", "", "data", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class a extends b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MqqHandler f452648d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Runnable f452649e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f452650f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ IRNetwork.INetworkResult f452651h;

        a(MqqHandler mqqHandler, Runnable runnable, Ref.BooleanRef booleanRef, IRNetwork.INetworkResult iNetworkResult) {
            this.f452648d = mqqHandler;
            this.f452649e = runnable;
            this.f452650f = booleanRef;
            this.f452651h = iNetworkResult;
        }

        @Override // zj3.b
        public void a(int type, boolean isSuccess, Object data) {
            this.f452648d.removeCallbacks(this.f452649e);
            if (this.f452650f.element) {
                QLog.i("ShiplySSONetworkImpl", 1, "requestWithMethod onReceive return for ManualTimeout");
                return;
            }
            String str = data instanceof String ? (String) data : null;
            QLog.i("ShiplySSONetworkImpl", 1, "requestWithMethod,type = " + type + ",isSuccess = " + isSuccess + " ,threadId = " + Thread.currentThread().getId() + ",isMainThread = " + Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()));
            if (isSuccess) {
                IRNetwork.INetworkResult iNetworkResult = this.f452651h;
                if (iNetworkResult != null) {
                    if (str == null) {
                        str = "";
                    }
                    iNetworkResult.onSuccess(str);
                    return;
                }
                return;
            }
            IRNetwork.ResultInfo resultInfo = new IRNetwork.ResultInfo();
            resultInfo.setErrorType(IRNetwork.ResultInfo.ErrorType.OTHER_ERROR);
            resultInfo.setErrorCode(-222);
            IRNetwork.INetworkResult iNetworkResult2 = this.f452651h;
            if (iNetworkResult2 != null) {
                iNetworkResult2.onFail(resultInfo);
            }
        }
    }

    public d(com.tencent.rdelivery.dependencyimpl.c httpsURLConnectionNetwork) {
        Intrinsics.checkNotNullParameter(httpsURLConnectionNetwork, "httpsURLConnectionNetwork");
        this.httpsURLConnectionNetwork = httpsURLConnectionNetwork;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Ref.BooleanRef isManualTimeout, IRNetwork.INetworkResult iNetworkResult) {
        Intrinsics.checkNotNullParameter(isManualTimeout, "$isManualTimeout");
        isManualTimeout.element = true;
        QLog.i("ShiplySSONetworkImpl", 1, "requestWithMethod failed for ManualTimeout");
        IRNetwork.ResultInfo resultInfo = new IRNetwork.ResultInfo();
        resultInfo.setErrorType(IRNetwork.ResultInfo.ErrorType.OTHER_ERROR);
        resultInfo.setErrorCode(-555);
        if (iNetworkResult != null) {
            iNetworkResult.onFail(resultInfo);
        }
    }

    @Override // com.tencent.raft.standard.net.IRNetwork
    public IRNetwork.NetworkStatus getNetworkStatus() {
        return this.httpsURLConnectionNetwork.getNetworkStatus();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e0  */
    @Override // com.tencent.raft.standard.net.IRNetwork
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void requestWithMethod(IRNetwork.HttpMethod method, String urlString, Map<String, String> headers, Map<String, String> parameters, Object payload, final IRNetwork.INetworkResult result) {
        boolean z16;
        boolean contains$default;
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        AppInterface j3 = yj3.a.f450500a.j();
        if (j3 == null) {
            QLog.i("ShiplySSONetworkImpl", 1, "requestWithMethod failed for null app");
            IRNetwork.ResultInfo resultInfo = new IRNetwork.ResultInfo();
            resultInfo.setErrorType(IRNetwork.ResultInfo.ErrorType.OTHER_ERROR);
            resultInfo.setErrorCode(-111);
            if (result != null) {
                result.onFail(resultInfo);
                return;
            }
            return;
        }
        try {
            IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFeatureRuntimeService.class, "all");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026ant.ALL\n                )");
            IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) runtimeService;
            if (iFeatureRuntimeService.isFeatureSwitchEnable("fekitso_switch_898")) {
                JSONObject jSONObject = iFeatureRuntimeService.getJSONObject("fekitso_switch_898", "{}");
                String str = "0";
                String optString = jSONObject != null ? jSONObject.optString("reshub_force_https", "0") : null;
                if (optString != null) {
                    str = optString;
                }
                z16 = Intrinsics.areEqual(str, "1");
                try {
                    QLog.i("ShiplySSONetworkImpl", 1, "forceUseHttps:" + z16 + " by FEKit_FESoManager,check switch:" + jSONObject);
                } catch (Throwable th5) {
                    th = th5;
                    QLog.e("ShiplySSONetworkImpl", 1, "runtimeService exception:" + th);
                    QLog.i("ShiplySSONetworkImpl", 1, "requestWithMethod,isLogin = " + j3.isLogin());
                    if (urlString.length() <= 0) {
                    }
                    this.httpsURLConnectionNetwork.requestWithMethod(method, urlString, headers, parameters, payload, result);
                }
            } else {
                z16 = false;
            }
        } catch (Throwable th6) {
            th = th6;
            z16 = false;
        }
        QLog.i("ShiplySSONetworkImpl", 1, "requestWithMethod,isLogin = " + j3.isLogin());
        if (urlString.length() <= 0) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) urlString, (CharSequence) "rdelivery.qq.com/v3/config/pull", false, 2, (Object) null);
            if (contains$default && j3.isLogin() && !z16) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                    MqqHandler subThreadHandler = ThreadManager.getSubThreadHandler();
                    Runnable runnable = new Runnable() { // from class: zj3.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            d.b(Ref.BooleanRef.this, result);
                        }
                    };
                    subThreadHandler.postDelayed(runnable, 30000L);
                    BusinessHandler businessHandler = j3.getBusinessHandler(ShiplySSOBusinessHandler.INSTANCE.a());
                    Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.reshub.impl.shiply.delegate.ShiplySSOBusinessHandler");
                    ((ShiplySSOBusinessHandler) businessHandler).F2((String) payload, new a(subThreadHandler, runnable, booleanRef, result));
                    m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
                } catch (Throwable th7) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th7));
                }
                Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                if (m479exceptionOrNullimpl != null) {
                    QLog.e("ShiplySSONetworkImpl", 1, "requestWithMethod failed", m479exceptionOrNullimpl);
                    IRNetwork.ResultInfo resultInfo2 = new IRNetwork.ResultInfo();
                    resultInfo2.setErrorType(IRNetwork.ResultInfo.ErrorType.OTHER_ERROR);
                    resultInfo2.setErrorCode(-333);
                    if (result != null) {
                        result.onFail(resultInfo2);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        this.httpsURLConnectionNetwork.requestWithMethod(method, urlString, headers, parameters, payload, result);
    }
}
