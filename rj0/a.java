package rj0;

import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.base.network.api.IECNetworkJsonContracts;
import com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tenpay.sdk.util.UinConfigManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import org.json.JSONArray;
import org.json.JSONObject;
import sj0.ECBillModel;
import sj0.ECFilterOptionItem;
import sj0.ECFilterOptionModel;
import sj0.ECTaxLinkModel;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J5\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ;\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0006\u0010\n\u001a\u00020\u00022\u0018\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\f0\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J;\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0006\u0010\n\u001a\u00020\u00022\u0018\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\f0\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0010JK\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0018\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\f0\u000bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u000b0\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lrj0/a;", "", "", "token", "service", "method", "Lcom/tencent/ecommerce/base/network/api/d;", "Lsj0/d;", "e", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cookie", "", "Lkotlin/Pair;", "option", "Lsj0/a;", "d", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "c", "a", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lsj0/c;", "b", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f431541a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"rj0/a$c", "Lcom/tencent/ecommerce/base/network/api/IECNetworkJsonContracts;", "", "Lsj0/d;", "params", "Lorg/json/JSONObject;", "b", "", "rsp", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes36.dex */
    public static final class c implements IECNetworkJsonContracts<String, ECTaxLinkModel> {
        c() {
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkJsonContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ECTaxLinkModel decodeResponse(byte[] rsp) {
            JSONObject a16 = com.tencent.ecommerce.base.network.api.c.a(rsp);
            return new ECTaxLinkModel(a16.optInt("valid"), a16.optString("url"));
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkJsonContracts
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public JSONObject encodeRequestParams(String params) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("token", params);
            return jSONObject;
        }
    }

    a() {
    }

    final /* synthetic */ Object a(String str, String str2, String str3, List<Pair<String, String>> list, Continuation<? super ECNetworkResponse<ECBillModel>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", pair.getFirst());
            jSONObject.put("value", pair.getSecond());
            Unit unit = Unit.INSTANCE;
            jSONArray.mo162put(jSONObject);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("cookie", str3);
        jSONObject2.put("options", jSONArray);
        Unit unit2 = Unit.INSTANCE;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        com.tencent.ecommerce.base.network.service.a.c(str, str2, jSONObject2, new C11145a(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final Object b(Continuation<? super ECNetworkResponse<List<ECFilterOptionModel>>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        com.tencent.ecommerce.base.network.service.a.c("trpc.ecom.income_detail_page_svr.IncomeDetailPageSvr", "/trpc.ecom.income_detail_page_svr.IncomeDetailPageSvr/GetOptions", new JSONObject(), new b(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final Object c(String str, List<Pair<String, String>> list, Continuation<? super ECNetworkResponse<ECBillModel>> continuation) {
        return a("trpc.ecom.income_detail_page_svr.IncomeDetailPageSvr", "/trpc.ecom.income_detail_page_svr.IncomeDetailPageSvr/GetPaymentBillsV2", str, list, continuation);
    }

    public final Object d(String str, List<Pair<String, String>> list, Continuation<? super ECNetworkResponse<ECBillModel>> continuation) {
        return a("trpc.ecom.income_detail_page_svr.IncomeDetailPageSvr", "/trpc.ecom.income_detail_page_svr.IncomeDetailPageSvr/GetSettlementBillsV2", str, list, continuation);
    }

    public final Object e(String str, String str2, String str3, Continuation<? super ECNetworkResponse<ECTaxLinkModel>> continuation) {
        return com.tencent.ecommerce.base.network.service.a.e(str2, str3, new c(), str, continuation);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\u000b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"rj0/a$a", "Lcom/tencent/ecommerce/base/network/service/IECJsonNetworkCallback;", "Lorg/json/JSONObject;", "reqParams", "respData", "", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "", "onSuccess", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "onError", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: rj0.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11145a implements IECJsonNetworkCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation f431542a;

        C11145a(Continuation continuation) {
            this.f431542a = continuation;
        }

        @Override // com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback
        public void onError(JSONObject reqParams, ECRemoteResponse errorResponse) {
            if (errorResponse == null) {
                this.f431542a.resumeWith(Result.m476constructorimpl(new ECNetworkResponse(-1, "unknown error", null, null, 8, null)));
            } else {
                this.f431542a.resumeWith(Result.m476constructorimpl(new ECNetworkResponse(errorResponse.getCode(), errorResponse.getMsg(), null, null, 8, null)));
            }
        }

        @Override // com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback
        public void onSuccess(JSONObject reqParams, JSONObject respData, String traceInfo) {
            if (respData == null) {
                this.f431542a.resumeWith(Result.m476constructorimpl(new ECNetworkResponse(0, "", null, null, 8, null)));
                return;
            }
            String optString = respData.optString("cookie");
            boolean optBoolean = respData.optBoolean("is_end");
            JSONArray optJSONArray = respData.optJSONArray("bills");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    arrayList.add(optJSONArray.optJSONObject(i3));
                }
            }
            this.f431542a.resumeWith(Result.m476constructorimpl(new ECNetworkResponse(0, "", new ECBillModel(optString, optBoolean, arrayList, respData.optString(UinConfigManager.KEY_ADS)), null, 8, null)));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\u000b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"rj0/a$b", "Lcom/tencent/ecommerce/base/network/service/IECJsonNetworkCallback;", "Lorg/json/JSONObject;", "reqParams", "respData", "", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "", "onSuccess", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "onError", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes36.dex */
    public static final class b implements IECJsonNetworkCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation f431543a;

        b(Continuation continuation) {
            this.f431543a = continuation;
        }

        @Override // com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback
        public void onError(JSONObject reqParams, ECRemoteResponse errorResponse) {
            if (errorResponse == null) {
                this.f431543a.resumeWith(Result.m476constructorimpl(new ECNetworkResponse(-1, "unknown error", null, null, 8, null)));
            } else {
                this.f431543a.resumeWith(Result.m476constructorimpl(new ECNetworkResponse(errorResponse.getCode(), errorResponse.getMsg(), null, null, 8, null)));
            }
        }

        @Override // com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback
        public void onSuccess(JSONObject reqParams, JSONObject respData, String traceInfo) {
            JSONArray jSONArray = respData != null ? respData.getJSONArray("options") : null;
            if (jSONArray == null) {
                this.f431543a.resumeWith(Result.m476constructorimpl(new ECNetworkResponse(0, "", null, null, 8, null)));
                return;
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            int i3 = 0;
            while (i3 < length) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                String optString = optJSONObject.optString("text");
                String optString2 = optJSONObject.optString("key");
                JSONArray optJSONArray = optJSONObject.optJSONArray("values");
                ArrayList arrayList2 = new ArrayList();
                if (optJSONArray != null) {
                    int length2 = optJSONArray.length();
                    int i16 = 0;
                    while (i16 < length2) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i16);
                        arrayList2.add(new ECFilterOptionItem(optJSONObject2.optString("text"), optJSONObject2.optString("value"), optJSONObject2.optInt("type")));
                        i16++;
                        jSONArray = jSONArray;
                    }
                }
                arrayList.add(new ECFilterOptionModel(optString, optString2, arrayList2));
                i3++;
                jSONArray = jSONArray;
            }
            this.f431543a.resumeWith(Result.m476constructorimpl(new ECNetworkResponse(0, "", arrayList, null, 8, null)));
        }
    }

    public static /* synthetic */ Object f(a aVar, String str, String str2, String str3, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = "trpc.ecom.income_detail_page_svr.IncomeDetailPageSvr";
        }
        if ((i3 & 4) != 0) {
            str3 = "/trpc.ecom.income_detail_page_svr.IncomeDetailPageSvr/GetTaxLinkV2";
        }
        return aVar.e(str, str2, str3, continuation);
    }
}
