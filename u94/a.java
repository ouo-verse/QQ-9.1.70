package u94;

import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.data.l;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import uv4.az;
import uv4.b;
import uv4.bd;
import uv4.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lu94/a;", "", "", "data", "", "a", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f438601a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"u94/a$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/c;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: u94.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11332a implements e<c> {
        C11332a() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(c result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("ZPlanStoreItemBuyHandler_", 1, "handleStoreBuySucceedEvent onResultSuccess");
            l y16 = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.y();
            az[] azVarArr = result.f440398a;
            Intrinsics.checkNotNullExpressionValue(azVarArr, "result.list");
            y16.d(azVarArr);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("ZPlanStoreItemBuyHandler_", 1, "handleStoreBuySucceedEvent onResultFailure error:" + error + ", message:" + message);
        }
    }

    a() {
    }

    public final void a(String data) {
        JSONObject jSONObject;
        com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.r().e(Boolean.TRUE);
        if (data == null || data.length() == 0) {
            QLog.e("ZPlanStoreItemBuyHandler_", 1, "handleStoreBuySucceedEvent data.isNullOrEmpty");
            return;
        }
        try {
            jSONObject = new JSONObject(data);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            QLog.e("ZPlanStoreItemBuyHandler_", 1, "handleStoreBuySucceedEvent jsonObject is null");
            return;
        }
        int optInt = jSONObject.optInt("gender");
        JSONArray optJSONArray = jSONObject.optJSONArray("item_list");
        if (optJSONArray == null) {
            QLog.e("ZPlanStoreItemBuyHandler_", 1, "handleStoreBuySucceedEvent itemList is null");
            return;
        }
        int length = optJSONArray.length();
        if (length == 0) {
            QLog.e("ZPlanStoreItemBuyHandler_", 1, "handleStoreBuySucceedEvent size is 0");
            return;
        }
        QLog.i("ZPlanStoreItemBuyHandler_", 1, "handleStoreBuySucceedEvent gender:" + optInt + ", size:" + length);
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
            bd bdVar = new bd();
            bdVar.f440321b = jSONObject2.optInt("item_id");
            long optLong = jSONObject2.optLong("ugc_id");
            bdVar.f440322c = optLong;
            QLog.i("ZPlanStoreItemBuyHandler_", 1, "handleStoreBuySucceedEvent itemId:" + bdVar.f440321b + ", ugcId:" + optLong);
            arrayList.add(bdVar);
        }
        b bVar = new b();
        bVar.f440299b = optInt;
        Object[] array = arrayList.toArray(new bd[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        bVar.f440298a = (bd[]) array;
        va4.a.b(va4.a.f441274a, bVar, new C11332a(), 0, 4, null);
    }
}
