package z23;

import com.google.protobuf.nano.MessageNano;
import com.qzone.misc.network.qboss.model.QBossDBData;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.vas.sso.api.IZplanVasProxyServlet;
import com.tencent.qphone.base.util.QLog;
import e33.RspErrorData;
import e33.b;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import t74.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u001e\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J \u0010\u0015\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u001c\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\f0\u0004\u00a8\u0006\u001b"}, d2 = {"Lz23/b;", "", "", "needBubble", "Lcom/tencent/mobileqq/zootopia/api/e;", "Low4/d;", "callback", "", "g", "", QBossDBData.JSON_STRING, "Lkotlin/Pair;", "Low4/b;", "f", "Lorg/json/JSONObject;", "jObj", "i", "entry", "", "ts", "limit", "d", "c", "e", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"z23/b$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Low4/d;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: z23.b$b, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11646b implements com.tencent.mobileqq.zootopia.api.e<ow4.d> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ MMKVOptionEntity f451796e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f451797f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<ow4.b> f451798h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ ow4.b f451799i;

        C11646b(MMKVOptionEntity mMKVOptionEntity, String str, com.tencent.mobileqq.zootopia.api.e<ow4.b> eVar, ow4.b bVar) {
            this.f451796e = mMKVOptionEntity;
            this.f451797f = str;
            this.f451798h = eVar;
            this.f451799i = bVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(ow4.d result) {
            Intrinsics.checkNotNullParameter(result, "result");
            ow4.b bVar = result.f424395a;
            if (bVar == null) {
                onResultFailure(-1, "result.entry is null");
                return;
            }
            b bVar2 = b.this;
            Intrinsics.checkNotNullExpressionValue(bVar, "result.entry");
            long currentTimeMillis = System.currentTimeMillis();
            ow4.f fVar = result.f424396b;
            String d16 = bVar2.d(bVar, currentTimeMillis, fVar != null ? fVar.f424400a : 0L);
            this.f451796e.encodeString("entryKey" + this.f451797f, d16);
            com.tencent.mobileqq.zootopia.api.e<ow4.b> eVar = this.f451798h;
            ow4.b bVar3 = result.f424395a;
            Intrinsics.checkNotNullExpressionValue(bVar3, "result.entry");
            eVar.onResultSuccess(bVar3);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            ow4.b bVar = this.f451799i;
            if (bVar != null) {
                this.f451798h.onResultSuccess(bVar);
            } else {
                this.f451798h.onResultFailure(error, message);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"z23/b$c", "Le33/b;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class c implements e33.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<ow4.d> f451800a;

        c(com.tencent.mobileqq.zootopia.api.e<ow4.d> eVar) {
            this.f451800a = eVar;
        }

        @Override // e33.b
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZplanEntranceService", 1, "getEntry error " + errCode + " " + errMsg);
            this.f451800a.onResultFailure(errCode != null ? errCode.intValue() : -1, errMsg);
        }

        @Override // e33.a
        public void b(RspErrorData rspErrorData) {
            b.a.a(this, rspErrorData);
        }

        @Override // e33.a
        public void onReceive(byte[] data) {
            try {
                this.f451800a.onResultSuccess(ow4.d.c(data));
            } catch (Throwable unused) {
                QLog.e("ZplanEntranceService", 1, "getEntry parse data error");
                this.f451800a.onResultFailure(-1, "parse rsp error");
            }
        }
    }

    private final ow4.b c(JSONObject jObj) {
        ow4.b bVar = new ow4.b();
        bVar.f424392d = jObj.optString(WadlProxyConsts.KEY_JUMP_URL);
        bVar.f424389a = jObj.optInt("type");
        bVar.f424393e = jObj.optString("adId");
        ow4.a aVar = new ow4.a();
        aVar.f424387a = jObj.optString("bubbleText");
        aVar.f424388b = jObj.optInt("bubbleTime", 0) * 1000;
        bVar.f424391c = aVar;
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String d(ow4.b entry, long ts5, long limit) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("lastReqTs", ts5);
        jSONObject.put(WadlProxyConsts.KEY_JUMP_URL, entry.f424392d);
        jSONObject.put("type", entry.f424389a);
        jSONObject.put("adId", entry.f424393e);
        jSONObject.put("limit", limit);
        ow4.a aVar = entry.f424391c;
        String str = aVar != null ? aVar.f424387a : null;
        if (str == null) {
            str = "";
        }
        jSONObject.put("bubbleText", str);
        ow4.a aVar2 = entry.f424391c;
        jSONObject.put("bubbleTime", aVar2 != null ? aVar2.f424388b : 0);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jObj.toString()");
        return jSONObject2;
    }

    private final Pair<Boolean, ow4.b> f(String jString) {
        try {
            JSONObject jSONObject = new JSONObject(jString);
            return new Pair<>(Boolean.valueOf(i(jSONObject)), c(jSONObject));
        } catch (Exception e16) {
            QLog.e("ZplanEntranceService", 1, "parse Entry error " + jString, e16);
            return new Pair<>(Boolean.TRUE, null);
        }
    }

    private final void g(boolean needBubble, com.tencent.mobileqq.zootopia.api.e<ow4.d> callback) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        final AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            QLog.e("ZplanEntranceService", 1, "getEntry error app is null");
            callback.onResultFailure(-1, "app is null");
        } else {
            final ow4.c cVar = new ow4.c();
            cVar.f424394a = needBubble;
            final c cVar2 = new c(callback);
            l.f435563a.f(new Runnable() { // from class: z23.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.h(AppInterface.this, cVar, cVar2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(AppInterface appInterface, ow4.c req, c observer) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(req, "$req");
        Intrinsics.checkNotNullParameter(observer, "$observer");
        QRouteApi api = QRoute.api(IZplanVasProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZplanVasProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(req);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZplanVasProxyServlet.a.a((IZplanVasProxyServlet) api, appInterface, "trpc.qmeta.zplan_entry_svr.ZplanEntry", "GetEntry", byteArray, emptyMap, observer, 0, 64, null);
    }

    private final boolean i(JSONObject jObj) {
        return System.currentTimeMillis() - jObj.optLong("lastReqTs", 0L) > jObj.optLong("limit", 0L) * ((long) 1000);
    }

    public final void e(boolean needBubble, com.tencent.mobileqq.zootopia.api.e<ow4.b> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentUin = peekAppRuntime != null ? peekAppRuntime.getCurrentUin() : null;
        String str = currentUin == null ? "" : currentUin;
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
        String entryCacheString = from.decodeString("entryKey" + str, "");
        Intrinsics.checkNotNullExpressionValue(entryCacheString, "entryCacheString");
        Pair<Boolean, ow4.b> f16 = f(entryCacheString);
        QLog.i("ZplanEntranceService", 1, "local entryInfo " + f16.getFirst() + " " + (f16.getSecond() != null));
        ow4.b second = f16.getSecond();
        if (!needBubble && second != null) {
            second.f424391c = null;
        }
        if (!f16.getFirst().booleanValue() && second != null) {
            callback.onResultSuccess(second);
        } else {
            g(needBubble, new C11646b(from, str, callback, second));
        }
    }
}
