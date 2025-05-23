package w93;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightVersionInfo;
import v93.WinkResponseData;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J,\u0010\t\u001a\u00020\b\"\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006J4\u0010\f\u001a\u00020\b\"\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\u000b\u001a\u00020\nJ\u0099\u0001\u0010\u0018\u001a\u00020\b\"\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u00042y\u0010\u0017\u001au\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00018\u0000\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\rJ1\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019\"\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\nJ \u0010 \u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u0012J\u0006\u0010!\u001a\u00020\u0016R\u0018\u0010$\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006'"}, d2 = {"Lw93/e;", "", "Lcom/tencent/mobileqq/pb/MessageMicro;", "T", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", Const.BUNDLE_KEY_REQUEST, "Lw93/a;", "winkRequestCallback", "", "f", "", "externalLogField", "g", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "", "isSuccess", "", "retCode", "errMsg", "rsp", "", "rspCallback", "j", "Lv93/a;", "k", "(Lcom/tencent/biz/richframework/network/request/BaseRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "cmdName", "costMs", "returnCode", "e", "c", "b", "Ljava/lang/String;", "lightSdkVersionCache", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f445096a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String lightSdkVersionCache;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J=\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"w93/e$a", "Lw93/a;", "", "isSuccess", "", "retCode", "", "msg", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "pbRequest", "pbResponse", "", "a", "(ZJLjava/lang/String;Lcom/tencent/biz/richframework/network/request/BaseRequest;Lcom/tencent/mobileqq/pb/MessageMicro;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a<T> implements w93.a<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function5<BaseRequest, Boolean, Long, String, T, Unit> f445098a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ BaseRequest f445099b;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function5<? super BaseRequest, ? super Boolean, ? super Long, ? super String, ? super T, Unit> function5, BaseRequest baseRequest) {
            this.f445098a = function5;
            this.f445099b = baseRequest;
        }

        /* JADX WARN: Incorrect types in method signature: (ZJLjava/lang/String;Lcom/tencent/biz/richframework/network/request/BaseRequest;TT;)V */
        @Override // w93.a
        public void a(boolean isSuccess, long retCode, @Nullable String msg2, @Nullable BaseRequest pbRequest, @Nullable MessageMicro pbResponse) {
            this.f445098a.invoke(this.f445099b, Boolean.valueOf(isSuccess), Long.valueOf(retCode), msg2, pbResponse);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J=\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"w93/e$b", "Lw93/a;", "", "isSuccess", "", "retCode", "", "errMsg", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "pbRequest", "pbResponse", "", "a", "(ZJLjava/lang/String;Lcom/tencent/biz/richframework/network/request/BaseRequest;Lcom/tencent/mobileqq/pb/MessageMicro;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b<T> implements w93.a<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<WinkResponseData<T>> f445100a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ BaseRequest f445101b;

        /* JADX WARN: Multi-variable type inference failed */
        b(Continuation<? super WinkResponseData<T>> continuation, BaseRequest baseRequest) {
            this.f445100a = continuation;
            this.f445101b = baseRequest;
        }

        /* JADX WARN: Incorrect types in method signature: (ZJLjava/lang/String;Lcom/tencent/biz/richframework/network/request/BaseRequest;TT;)V */
        @Override // w93.a
        public void a(boolean isSuccess, long retCode, @Nullable String errMsg, @Nullable BaseRequest pbRequest, @Nullable MessageMicro pbResponse) {
            Continuation<WinkResponseData<T>> continuation = this.f445100a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(new WinkResponseData(isSuccess, retCode, errMsg, this.f445101b, pbResponse)));
        }
    }

    e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(long j3, final String reqCmdName, w93.a winkRequestCallback, final String externalLogField, BaseRequest baseRequest, final boolean z16, final long j16, String str, final MessageMicro messageMicro) {
        Intrinsics.checkNotNullParameter(winkRequestCallback, "$winkRequestCallback");
        Intrinsics.checkNotNullParameter(externalLogField, "$externalLogField");
        final long currentTimeMillis = System.currentTimeMillis() - j3;
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: w93.d
            @Override // java.lang.Runnable
            public final void run() {
                e.i(reqCmdName, externalLogField, z16, j16, currentTimeMillis, messageMicro);
            }
        });
        e eVar = f445096a;
        Intrinsics.checkNotNullExpressionValue(reqCmdName, "reqCmdName");
        eVar.e(reqCmdName, currentTimeMillis, j16);
        winkRequestCallback.a(z16, j16, str, baseRequest, messageMicro);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(String str, String externalLogField, boolean z16, long j3, long j16, MessageMicro messageMicro) {
        Integer num;
        Intrinsics.checkNotNullParameter(externalLogField, "$externalLogField");
        if (messageMicro != null) {
            num = Integer.valueOf(messageMicro.getSerializedSize());
        } else {
            num = null;
        }
        w53.b.f("WinkRequestUtils", "wink request end, cmdName: " + str + " " + externalLogField + ", isSuccess:" + z16 + ", retCode:" + j3 + ", cost " + j16 + " ms, size:" + num);
    }

    public final void c() {
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        if (applicationContext != null) {
            VSNetworkHelper.getInstance().cancelRequest(applicationContext);
        }
    }

    @NotNull
    public final String d() {
        List split$default;
        String str = lightSdkVersionCache;
        if (str != null) {
            return str;
        }
        String str2 = LightVersionInfo.VERSION_NAME;
        if (!TextUtils.isEmpty(LightVersionInfo.VERSION_NAME)) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) LightVersionInfo.VERSION_NAME, new String[]{"."}, false, 0, 6, (Object) null);
            Object[] array = split$default.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr = (String[]) array;
            if (strArr.length > 3) {
                str2 = strArr[0] + "." + strArr[1] + "." + strArr[2];
            }
        }
        lightSdkVersionCache = str2;
        return str2;
    }

    public final void e(@NotNull String cmdName, long costMs, long returnCode) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(cmdName, "cmdName");
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.XSJ_SEARCH_PASTE_COST_TIME, String.valueOf(costMs));
        pairArr[1] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.XSJ_NETWORK_REQUEST_COMMAND, cmdName);
        if (returnCode == 0) {
            returnCode = 999999999;
        }
        pairArr[2] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.XSJ_NETWORK_REQUEST_RETURN_CODE, String.valueOf(returnCode));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        com.tencent.mobileqq.wink.report.e.o(com.tencent.mobileqq.wink.report.e.f326265a, "performance#editor_page#network_request", mapOf, false, 4, null);
    }

    public final <T extends MessageMicro<T>> int f(@NotNull BaseRequest request, @NotNull w93.a<T> winkRequestCallback) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(winkRequestCallback, "winkRequestCallback");
        return g(request, winkRequestCallback, "");
    }

    public final <T extends MessageMicro<T>> int g(@NotNull BaseRequest request, @NotNull final w93.a<T> winkRequestCallback, @NotNull final String externalLogField) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(winkRequestCallback, "winkRequestCallback");
        Intrinsics.checkNotNullParameter(externalLogField, "externalLogField");
        final String cmdName = request.getCmdName();
        final long currentTimeMillis = System.currentTimeMillis();
        w53.b.f("WinkRequestUtils", "wink request begin, cmdName: " + cmdName + " " + externalLogField);
        return VSNetworkHelper.getInstance().sendRequest(MobileQQ.sMobileQQ.getApplicationContext(), request, new VSDispatchObserver.OnVSRspCallBack() { // from class: w93.c
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                e.h(currentTimeMillis, cmdName, winkRequestCallback, externalLogField, baseRequest, z16, j3, str, (MessageMicro) obj);
            }
        });
    }

    public final <T extends MessageMicro<T>> int j(@NotNull BaseRequest request, @NotNull Function5<? super BaseRequest, ? super Boolean, ? super Long, ? super String, ? super T, Unit> rspCallback) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(rspCallback, "rspCallback");
        return f(request, new a(rspCallback, request));
    }

    @Nullable
    public final <T extends MessageMicro<T>> Object k(@NotNull BaseRequest baseRequest, @NotNull Continuation<? super WinkResponseData<T>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        f445096a.f(baseRequest, new b(safeContinuation, baseRequest));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
