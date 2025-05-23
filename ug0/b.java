package ug0;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J(\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003J\u0006\u0010\u000b\u001a\u00020\u0003J\u0006\u0010\f\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0010\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u0013\u001a\u00020\u0005R\"\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0015R\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0015R\"\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lug0/b;", "", "", "", "parameters", "", h.F, "d", "i", GetAdInfoRequest.SOURCE_FROM, "j", "g", "b", "", "e", "Lorg/json/JSONObject;", "f", "extInfo", "c", "a", "", "Ljava/util/Map;", "schemeUserData", "sourceFromMap", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: d, reason: collision with root package name */
    public static final b f438933d = new b();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static Map<String, String> parameters = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static Map<String, String> schemeUserData = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static Map<String, String> sourceFromMap = new LinkedHashMap();

    b() {
    }

    private final Map<String, String> d(Map<String, String> parameters2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : parameters2.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if ((Intrinsics.areEqual(key, WadlProxyConsts.CHANNEL) ^ true) || (Intrinsics.areEqual(key, WadlProxyConsts.CHANNEL) && !TextUtils.isEmpty(value) && (Intrinsics.areEqual(value, String.valueOf(0)) ^ true))) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    private final void h(Map<String, String> parameters2) {
        String str = parameters2.get("userdata");
        if (str != null && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    schemeUserData.put(str2, jSONObject.optString(str2));
                }
                return;
            } catch (JSONException unused) {
                cg0.a.a("ECSchemeParameter", "saveSchemeUserDataParams", "parse userData error, userDataStr = " + str);
                return;
            }
        }
        cg0.a.b("ECSchemeParameter", "scheme userData parameter invalid");
    }

    public final void a() {
        schemeUserData.clear();
    }

    public final void b() {
        sourceFromMap.clear();
    }

    public final JSONObject c(String extInfo) {
        JSONObject jSONObject;
        if (extInfo != null) {
            try {
                if (!TextUtils.isEmpty(extInfo)) {
                    jSONObject = new JSONObject(URLDecoder.decode(extInfo));
                    return jSONObject;
                }
            } catch (JSONException unused) {
                cg0.a.a("ECSchemeParameter", "getExtInfo", "parse extInfo error, exInfo = " + extInfo);
                return new JSONObject("{}");
            }
        }
        jSONObject = new JSONObject("{}");
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x002d, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int e() {
        Integer intOrNull;
        String str = parameters.get(WadlProxyConsts.CHANNEL);
        if (str == null) {
            parameters.putAll(d(c.f438934a.a()));
            str = parameters.get(WadlProxyConsts.CHANNEL);
        }
        if (TextUtils.isEmpty(str) || str == null || intOrNull == null) {
            return 0;
        }
        return intOrNull.intValue();
    }

    public final JSONObject f() {
        return c(parameters.get("ext"));
    }

    public final String g() {
        String str = sourceFromMap.get("source_from");
        return str != null ? str : "-1";
    }

    public final void i(Map<String, String> parameters2) {
        parameters.putAll(d(parameters2));
        h(parameters2);
        c.f438934a.b(parameters2);
    }

    public final void j(String sourceFrom) {
        sourceFromMap.put("source_from", sourceFrom);
    }
}
