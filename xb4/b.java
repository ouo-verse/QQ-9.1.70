package xb4;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ark.ark;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.parser.JumpParserResult;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.api.IVasZplanApi;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.mobileqq.zplan.model.AccessibleDetail;
import com.tencent.mobileqq.zplan.model.AddWhiteListResponse;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.ag;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import nk3.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b,\u0010-J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\bJ,\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\rj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001`\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\bJ\u001e\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\u0013\u001a\u00020\u00042\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0010J\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bJ\u001f\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bJ\u0018\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010#\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010\bJ'\u0010%\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010$\u001a\u00020\u0018\u00a2\u0006\u0004\b%\u0010&J\u0018\u0010*\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010)\u001a\u00020\bJ\u000e\u0010+\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b\u00a8\u0006."}, d2 = {"Lxb4/b;", "", "Landroid/os/Bundle;", "bundle", "Lorg/json/JSONObject;", "j", "g", ark.ARKMETADATA_JSON, "", "o", h.F, "encodedJson", DomainData.DOMAIN_NAME, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "p", "", "r", "map", ReportConstant.COSTREPORT_PREFIX, "schemeUrl", "i", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "", "sceneType", "", "c", "(Lcom/tencent/mobileqq/zootopia/ZootopiaSource;Ljava/lang/Integer;)V", "e", "f", "d", "Landroid/content/Context;", "context", ISchemeApi.KEY_SUB_SCHEME, "l", "mapId", "b", "(Lcom/tencent/mobileqq/zootopia/ZootopiaSource;Ljava/lang/Integer;I)V", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "gender", "originParams", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f447772a = new b();

    b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:
    
        if (r2 != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m(String str, Context context) {
        boolean startsWith$default;
        boolean startsWith$default2;
        Intrinsics.checkNotNullParameter(context, "$context");
        String str2 = str == null ? "" : str;
        if (str == null || str.length() == 0) {
            return;
        }
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "http://", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(str, "https://", false, 2, null);
        }
        int pxToDp = ViewUtils.pxToDp(ImmersiveUtils.getStatusBarHeight(context));
        QLog.i("ZootopiaSchemeHelper", 4, "startWith http statusBarHeight:" + pxToDp);
        str2 = str + "&statusBarHeight=" + pxToDp;
        ((ISchemeApi) QRoute.api(ISchemeApi.class)).launchScheme(context, str2);
        QLog.i("ZootopiaSchemeHelper", 1, "subScheme == " + str);
    }

    public final void b(ZootopiaSource source, Integer sceneType, int mapId) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (((sceneType != null && sceneType.intValue() == 7) || (sceneType != null && sceneType.intValue() == 6)) && mapId == 200001) {
            if (Intrinsics.areEqual(source.getSubSource(), ZootopiaSource.SUB_SOURCE_XSJ) || Intrinsics.areEqual(source.getSubSource(), ZootopiaSource.SUB_SOURCE_LEBA)) {
                IVasZplanApi iVasZplanApi = (IVasZplanApi) QRoute.api(IVasZplanApi.class);
                ArrayList arrayList = new ArrayList();
                arrayList.add(200001L);
                iVasZplanApi.addWhiteList(arrayList, "smallHome");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0073 A[Catch: all -> 0x0099, TryCatch #0 {all -> 0x0099, blocks: (B:3:0x0007, B:10:0x0042, B:11:0x004e, B:12:0x006d, B:14:0x0073, B:16:0x007f, B:24:0x008d, B:31:0x001b, B:33:0x0022), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008d A[Catch: all -> 0x0099, TRY_LEAVE, TryCatch #0 {all -> 0x0099, blocks: (B:3:0x0007, B:10:0x0042, B:11:0x004e, B:12:0x006d, B:14:0x0073, B:16:0x007f, B:24:0x008d, B:31:0x001b, B:33:0x0022), top: B:2:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(ZootopiaSource source, Integer sceneType) {
        List<Long> mutableListOf;
        Iterator<Long> it;
        boolean z16;
        Intrinsics.checkNotNullParameter(source, "source");
        try {
            if (!Intrinsics.areEqual(source.getSubSource(), ZootopiaSource.SUB_SOURCE_SEARCH)) {
                return;
            }
            if (sceneType != null && sceneType.intValue() == 7) {
                mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(1001L, 2001L, 200001L);
                List<Long> list = mutableListOf;
                long longAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getLongAccountUin();
                QRouteApi api = QRoute.api(IZPlanAccessibleHelper.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanAccessibleHelper::class.java)");
                IZPlanAccessibleHelper iZPlanAccessibleHelper = (IZPlanAccessibleHelper) api;
                it = list.iterator();
                z16 = true;
                while (it.hasNext()) {
                    z16 = z16 && iZPlanAccessibleHelper.isZPlanAccessible(it.next().longValue(), longAccountUin);
                    if (!z16) {
                        break;
                    }
                }
                if (z16) {
                    iZPlanAccessibleHelper.addZPlanWhiteList(longAccountUin, list, "search", new a(longAccountUin, list));
                    return;
                }
                return;
            }
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(1001L);
            List<Long> list2 = mutableListOf;
            long longAccountUin2 = MobileQQ.sMobileQQ.peekAppRuntime().getLongAccountUin();
            QRouteApi api2 = QRoute.api(IZPlanAccessibleHelper.class);
            Intrinsics.checkNotNullExpressionValue(api2, "api(IZPlanAccessibleHelper::class.java)");
            IZPlanAccessibleHelper iZPlanAccessibleHelper2 = (IZPlanAccessibleHelper) api2;
            it = list2.iterator();
            z16 = true;
            while (it.hasNext()) {
            }
            if (z16) {
            }
        } catch (Throwable th5) {
            QLog.e("ZootopiaSchemeHelper", 1, "addWhiteListIfFromSearch source=" + source + " sceneType=" + sceneType, th5);
        }
    }

    public final String d(String schemeUrl, Bundle bundle) {
        boolean startsWith$default;
        int indexOf$default;
        int indexOf$default2;
        String replace;
        Intrinsics.checkNotNullParameter(schemeUrl, "schemeUrl");
        if (bundle == null || TextUtils.isEmpty(schemeUrl)) {
            return schemeUrl;
        }
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(schemeUrl, ISchemeApi.SCHEME_PREFIX_ZPLAN, false, 2, null);
        if (!startsWith$default) {
            return schemeUrl;
        }
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) schemeUrl, ISchemeApi.KEY_PAGE_DATA, 0, false, 6, (Object) null);
        if (indexOf$default > 0) {
            try {
                CharSequence subSequence = schemeUrl.subSequence(indexOf$default + 8 + 1, schemeUrl.length());
                indexOf$default2 = StringsKt__StringsKt.indexOf$default(subSequence, ContainerUtils.FIELD_DELIMITER, 0, false, 6, (Object) null);
                if (indexOf$default2 > 0) {
                    subSequence = subSequence.subSequence(0, indexOf$default2);
                }
                JSONObject jSONObject = new JSONObject(URLDecoder.decode(subSequence.toString(), "UTF-8"));
                Set<String> keySet = bundle.keySet();
                Intrinsics.checkNotNullExpressionValue(keySet, "bundle.keySet()");
                for (String str : keySet) {
                    jSONObject.put(str, bundle.get(str));
                }
                String obj = subSequence.toString();
                String encode = URLEncoder.encode(jSONObject.toString(), "UTF-8");
                Intrinsics.checkNotNullExpressionValue(encode, "encode(json.toString(), \"UTF-8\")");
                replace = StringsKt__StringsJVMKt.replace(schemeUrl, obj, encode, true);
                QLog.i("ZootopiaSchemeHelper", 1, "finalSchemeUrl " + replace);
                return replace;
            } catch (Exception e16) {
                QLog.e("ZootopiaSchemeHelper", 1, "bundleToJsonString error: " + e16.getMessage());
                return schemeUrl;
            }
        }
        return schemeUrl + "&pageData=" + h(bundle);
    }

    public final String e(String schemeUrl) {
        Intrinsics.checkNotNullParameter(schemeUrl, "schemeUrl");
        ZootopiaSource b16 = ag.f373258a.b();
        return f(schemeUrl, b16 != null ? ah.a(b16) : null);
    }

    public final String f(String schemeUrl, ZootopiaSource source) {
        boolean startsWith$default;
        boolean contains$default;
        boolean contains$default2;
        Intrinsics.checkNotNullParameter(schemeUrl, "schemeUrl");
        if (TextUtils.isEmpty(schemeUrl)) {
            return schemeUrl;
        }
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(schemeUrl, ISchemeApi.SCHEME_PREFIX_ZPLAN, false, 2, null);
        if (!startsWith$default) {
            return schemeUrl;
        }
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) schemeUrl, (CharSequence) "referer=", false, 2, (Object) null);
        if (contains$default || source == null) {
            return schemeUrl;
        }
        int value = source.getMainSource().getValue();
        String subSource = source.getSubSource();
        String str = "&referer=" + value;
        if (!TextUtils.isEmpty(subSource)) {
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) schemeUrl, (CharSequence) "subReferer=", false, 2, (Object) null);
            if (!contains$default2) {
                str = str + "&subReferer=" + subSource;
            }
        }
        QLog.i("ZootopiaSchemeHelper", 1, "appendRootSourceIfNecessary, original = " + schemeUrl + ", appendPostFix = " + str);
        return schemeUrl + str;
    }

    public final JSONObject g(Bundle bundle) {
        Set<String> keySet;
        boolean startsWith$default;
        String replace$default;
        JSONObject jSONObject = new JSONObject();
        if (bundle != null && (keySet = bundle.keySet()) != null) {
            for (String key : keySet) {
                try {
                    Object obj = bundle.get(key);
                    if (obj instanceof Bundle) {
                        jSONObject.put(key, f447772a.g((Bundle) obj));
                    } else if (obj instanceof String) {
                        Intrinsics.checkNotNullExpressionValue(key, "key");
                        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(key, "_&#$@&_", false, 2, null);
                        if (startsWith$default) {
                            JSONArray jSONArray = new JSONArray((String) obj);
                            replace$default = StringsKt__StringsJVMKt.replace$default(key, "_&#$@&_", "", false, 4, (Object) null);
                            jSONObject.put(replace$default, jSONArray);
                        } else {
                            jSONObject.put(key, obj);
                        }
                    } else {
                        jSONObject.put(key, obj);
                    }
                } catch (JSONException e16) {
                    QLog.e("ZootopiaSchemeHelper", 1, "bundleToJsonString error: " + e16.getMessage());
                }
            }
        }
        return jSONObject;
    }

    public final String h(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        return o(g(bundle));
    }

    public final String i(String schemeUrl) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(schemeUrl, "schemeUrl");
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(schemeUrl)) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(schemeUrl, ISchemeApi.SCHEME_PREFIX_ZPLAN, false, 2, null);
            if (startsWith$default) {
                jSONObject.put("schemeType", "zplan");
                JumpParserResult parseUrl = ((ISchemeApi) QRoute.api(ISchemeApi.class)).parseUrl(schemeUrl);
                if (parseUrl != null) {
                    jSONObject.put("prefix_domain", parseUrl.getAction());
                    HashMap<String, String> paramMap = parseUrl.getParamMap();
                    if (paramMap != null) {
                        Intrinsics.checkNotNullExpressionValue(paramMap, "paramMap");
                        for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                            jSONObject.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
            } else {
                jSONObject.put("schemeType", "others");
                jSONObject.put("url_info", schemeUrl);
            }
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonRet.toString()");
        return jSONObject2;
    }

    public final JSONObject j(Bundle bundle) {
        JSONObject jSONObject = null;
        Bundle bundle2 = bundle != null ? bundle.getBundle("ueParams") : null;
        if (bundle2 != null) {
            jSONObject = g(bundle2);
        } else {
            String string = bundle != null ? bundle.getString("ueParams") : null;
            if (string != null) {
                try {
                    jSONObject = new JSONObject(string);
                } catch (JSONException unused) {
                }
            }
        }
        if (bundle != null) {
            bundle.remove("ueParams");
        }
        return jSONObject;
    }

    public final void l(final Context context, final String subScheme) {
        Intrinsics.checkNotNullParameter(context, "context");
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: xb4.a
            @Override // java.lang.Runnable
            public final void run() {
                b.m(subScheme, context);
            }
        }, 500L);
    }

    public final Bundle n(String encodedJson) {
        if (encodedJson == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(ISchemeApi.INSTANCE.a(encodedJson));
            Bundle bundle = new Bundle();
            Iterator keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "json.keys()");
            while (keys.hasNext()) {
                String str = (String) keys.next();
                Object obj = jSONObject.get(str);
                if (obj instanceof String) {
                    bundle.putString(str, (String) obj);
                } else if (obj instanceof Integer) {
                    bundle.putInt(str, ((Number) obj).intValue());
                } else if (obj instanceof Long) {
                    bundle.putLong(str, ((Number) obj).longValue());
                } else if (obj instanceof Float) {
                    bundle.putFloat(str, ((Number) obj).floatValue());
                } else if (obj instanceof Double) {
                    bundle.putDouble(str, ((Number) obj).doubleValue());
                } else if (obj instanceof Boolean) {
                    bundle.putBoolean(str, ((Boolean) obj).booleanValue());
                } else if (obj instanceof JSONArray) {
                    bundle.putString("_&#$@&_" + str, obj.toString());
                } else if (obj instanceof JSONObject) {
                    Bundle n3 = f447772a.n(obj.toString());
                    if (n3 != null) {
                        bundle.putBundle(str, n3);
                    }
                } else {
                    QLog.w("ZootopiaSchemeHelper", 1, "jsonToBundle error: key=" + str + ", value=" + obj);
                }
            }
            return bundle;
        } catch (JSONException e16) {
            QLog.e("ZootopiaSchemeHelper", 1, "jsonToBundle error: " + e16.getMessage());
            return null;
        }
    }

    public final String o(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        ISchemeApi.Companion companion = ISchemeApi.INSTANCE;
        String jSONObject = json.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "json.toString()");
        return companion.b(jSONObject);
    }

    public final HashMap<String, Object> p(String encodedJson) {
        if (encodedJson == null) {
            return new HashMap<>();
        }
        try {
            JSONObject jSONObject = new JSONObject(URLDecoder.decode(encodedJson, "UTF-8"));
            HashMap<String, Object> hashMap = new HashMap<>();
            Iterator keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "json.keys()");
            while (keys.hasNext()) {
                String it = (String) keys.next();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                Object obj = jSONObject.get(it);
                Intrinsics.checkNotNullExpressionValue(obj, "json.get(it)");
                hashMap.put(it, obj);
            }
            return hashMap;
        } catch (UnsupportedEncodingException e16) {
            QLog.e("ZootopiaSchemeHelper", 1, "encode json string error: " + e16.getMessage());
            return new HashMap<>();
        } catch (JSONException e17) {
            QLog.e("ZootopiaSchemeHelper", 1, "jsonToMap error: " + e17.getMessage());
            return new HashMap<>();
        }
    }

    public final String q(String originParams) {
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(originParams, "originParams");
        boolean z16 = true;
        if (originParams.length() == 0) {
            jSONObject = new JSONObject();
        } else {
            jSONObject = new JSONObject(originParams);
        }
        if (!((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch() && !SimpleUIUtil.isNowElderMode()) {
            z16 = false;
        }
        jSONObject.put("is_teen", z16);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "if (originParams.isEmpty\u2026e())\n        }.toString()");
        return jSONObject2;
    }

    public final JSONObject s(Map<String, ? extends Object> map) {
        boolean startsWith$default;
        String replace$default;
        Intrinsics.checkNotNullParameter(map, "map");
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (!(entry.getValue() instanceof Map)) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(key, "_&#$@&_", false, 2, null);
                if (startsWith$default && (value instanceof String)) {
                    JSONArray jSONArray = new JSONArray((String) value);
                    replace$default = StringsKt__StringsJVMKt.replace$default(key, "_&#$@&_", "", false, 4, (Object) null);
                    jSONObject.put(replace$default, jSONArray);
                } else {
                    jSONObject.put(key, value);
                }
            } else {
                Object value2 = entry.getValue();
                Map<String, ? extends Object> map2 = value2 instanceof Map ? (Map) value2 : null;
                if (map2 != null) {
                    jSONObject.put(key, f447772a.s(map2));
                }
            }
        }
        return jSONObject;
    }

    public final String k(UEAvatarGender gender, String originParams) {
        dw4.b value;
        int i3;
        Intrinsics.checkNotNullParameter(originParams, "originParams");
        QLog.i("ZootopiaSchemeHelper", 1, "filterSceneParams originParams:" + originParams);
        if (originParams.length() == 0) {
            return originParams;
        }
        JSONObject jSONObject = new JSONObject(originParams);
        JSONArray optJSONArray = jSONObject.optJSONArray("FemaleGoods");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("FemaleUgcids");
        JSONArray optJSONArray3 = jSONObject.optJSONArray("MaleGoods");
        JSONArray optJSONArray4 = jSONObject.optJSONArray("MaleUgcids");
        if ((optJSONArray == null && optJSONArray2 == null && optJSONArray3 == null && optJSONArray4 == null) || (value = com.tencent.sqshow.dresskey.b.f369818a.l("ZootopiaSchemeHelperfilterSceneParams", true).getValue()) == null) {
            return originParams;
        }
        QLog.i("ZootopiaSchemeHelper", 1, "filterSceneParams gender:" + value.f395116c);
        if (gender != null) {
            i3 = gender.getIndex();
        } else {
            i3 = value.f395116c;
        }
        if (i3 == 1) {
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                return originParams;
            }
            if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                return originParams;
            }
            jSONObject.remove("FemaleGoods");
            jSONObject.remove("FemaleUgcids");
            jSONObject.put("MaleGoods", optJSONArray);
            jSONObject.put("MaleUgcids", optJSONArray2);
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "{\n                    sc\u2026tring()\n                }");
            return jSONObject2;
        }
        if (i3 != 2) {
            return originParams;
        }
        if (optJSONArray != null && optJSONArray.length() > 0) {
            return originParams;
        }
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            return originParams;
        }
        jSONObject.remove("MaleGoods");
        jSONObject.remove("MaleUgcids");
        jSONObject.put("FemaleGoods", optJSONArray3);
        jSONObject.put("FemaleUgcids", optJSONArray4);
        String jSONObject3 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "{\n                    sc\u2026tring()\n                }");
        return jSONObject3;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"xb4/b$a", "Lnk3/c;", "Lcom/tencent/mobileqq/zplan/model/a;", NotificationCompat.CATEGORY_ERROR, "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class a implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f447773a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<Long> f447774b;

        a(long j3, List<Long> list) {
            this.f447773a = j3;
            this.f447774b = list;
        }

        @Override // nk3.c
        public void a(AddWhiteListResponse err) {
            if (QLog.isColorLevel()) {
                QLog.i("ZootopiaSchemeHelper", 2, "addWhiteListIfFromSearch uin=" + this.f447773a + " appIds=" + this.f447774b + " " + err);
            }
            boolean z16 = false;
            if (err != null && err.getErrCode() == 0) {
                z16 = true;
            }
            if (z16) {
                Iterator<Long> it = this.f447774b.iterator();
                while (it.hasNext()) {
                    long longValue = it.next().longValue();
                    QRouteApi api = QRoute.api(IZPlanAccessibleHelper.class);
                    Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanAccessibleHelper::class.java)");
                    IZPlanAccessibleHelper iZPlanAccessibleHelper = (IZPlanAccessibleHelper) api;
                    AccessibleDetail zplanAccessibleDetailFromCacheOnly = iZPlanAccessibleHelper.getZplanAccessibleDetailFromCacheOnly(longValue, this.f447773a);
                    if (zplanAccessibleDetailFromCacheOnly == null) {
                        QLog.e("ZootopiaSchemeHelper", 1, "addWhiteListIfFromSearch uin=" + this.f447773a + " appId=" + longValue + " oldCache == null");
                    } else {
                        iZPlanAccessibleHelper.updateCache(this.f447773a, new AccessibleDetail(zplanAccessibleDetailFromCacheOnly.getAppid(), zplanAccessibleDetailFromCacheOnly.getAppidExist(), zplanAccessibleDetailFromCacheOnly.getPhonePass(), 1, zplanAccessibleDetailFromCacheOnly.settingPass & zplanAccessibleDetailFromCacheOnly.getAppidExist() & zplanAccessibleDetailFromCacheOnly.getPhonePass() & zplanAccessibleDetailFromCacheOnly.getSwitchPass(), zplanAccessibleDetailFromCacheOnly.getSwitchPass(), zplanAccessibleDetailFromCacheOnly.getEntranceType(), zplanAccessibleDetailFromCacheOnly.settingPass));
                    }
                }
            }
        }
    }

    public final Map<String, Object> r(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Set<String> keySet = bundle.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "bundle.keySet()");
        for (String key : keySet) {
            Object obj = bundle.get(key);
            if (obj != null) {
                Intrinsics.checkNotNullExpressionValue(obj, "bundle.get(key) ?: return@forEach");
                if (obj instanceof Bundle) {
                    Map<String, Object> r16 = f447772a.r((Bundle) obj);
                    if (r16 != null) {
                        Intrinsics.checkNotNullExpressionValue(key, "key");
                        hashMap.put(key, r16);
                    }
                } else {
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    hashMap.put(key, obj);
                }
            }
        }
        return hashMap;
    }
}
