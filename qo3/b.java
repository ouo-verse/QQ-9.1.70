package qo3;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.now.pkgame.pkgame.sei.Pos;
import com.tencent.qqlive.common.api.IAegisLogApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\"\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005\u00a8\u0006\u0007"}, d2 = {"", "seiData", "Lqo3/a;", "a", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "mAegisLog", "qq-live-linkpk-ui-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final IAegisLogApi f429125a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"qo3/b$a", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/tencent/now/pkgame/pkgame/sei/Pos;", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class a extends TypeToken<List<Pos>> {
        a() {
        }
    }

    static {
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        f429125a = (IAegisLogApi) api;
    }

    @NotNull
    public static final SeiConfig a(@Nullable byte[] bArr) {
        boolean contains$default;
        String replace$default;
        List list;
        if (bArr == null) {
            return new SeiConfig(null, 1, null, 1080, 1920);
        }
        String str = new String(bArr, Charsets.UTF_8);
        List list2 = null;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "OnTencentMixInfo", false, 2, (Object) null);
        if (contains$default) {
            replace$default = StringsKt__StringsJVMKt.replace$default(str, "OnTencentMixInfo", "", false, 4, (Object) null);
            try {
                JSONObject jSONObject = new JSONObject(replace$default);
                String optString = jSONObject.optString("type");
                int optInt = jSONObject.optInt("mute");
                int optInt2 = jSONObject.optInt("w");
                int optInt3 = jSONObject.optInt(h.F);
                JSONArray optJSONArray = jSONObject.optJSONArray(com.tencent.luggage.wxa.c8.c.G);
                if (optJSONArray != null) {
                    list2 = (List) new Gson().fromJson(optJSONArray.toString(), new a().getType());
                }
                if (list2 == null) {
                    list = new ArrayList();
                } else {
                    list = list2;
                }
                return new SeiConfig(optString, Integer.valueOf(optInt), list, optInt2, optInt3);
            } catch (JSONException e16) {
                f429125a.e("SeiParseHelper", e16.toString());
                return new SeiConfig(null, 1, null, 1080, 1920);
            }
        }
        return new SeiConfig(null, 1, null, 1080, 1920);
    }
}
