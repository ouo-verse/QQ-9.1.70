package xo2;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchReportApi;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.af;
import com.tencent.mobileqq.search.util.n;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService;
import com.tencent.qqnt.kernel.nativeinterface.IUnifySearchCallback;
import com.tencent.qqnt.kernel.nativeinterface.UfsExtensionRequestInfo;
import com.tencent.qqnt.kernel.nativeinterface.UfsItemRequestBusiMask;
import com.tencent.qqnt.kernel.nativeinterface.UfsItemRequestUserData;
import com.tencent.qqnt.kernel.nativeinterface.UfsReqBody;
import com.tencent.qqnt.kernel.nativeinterface.UfsRootSearcherRequest;
import com.tencent.qqnt.kernel.nativeinterface.UfsRspBody;
import com.tencent.qqnt.studymode.api.IStudyModeApi;
import com.tencent.shadow.dynamic.host.Constant;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import java.nio.charset.Charset;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 32\u00020\u0001:\u00013B\u0007\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J8\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\fH\u0002J@\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0017\u001a\u00020\fH\u0002J\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u00192\u0006\u0010\u0018\u001a\u00020\fH\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u00e6\u0001\u0010-\u001a\u00020*2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u001d\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u00152\u0006\u0010!\u001a\u00020\u001e2d\u0010,\u001a`\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110'\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b()\u0012\u0004\u0012\u00020*0\"j\u0002`+J\u0092\u0001\u00100\u001a\u00020*2\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010.\u001a\u00020\n2\b\u0010/\u001a\u0004\u0018\u00010\f2d\u0010,\u001a`\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110'\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b()\u0012\u0004\u0012\u00020*0\"j\u0002`+\u00a8\u00064"}, d2 = {"Lxo2/c;", "", "", "c", "", "keyWordSrc", "", "latitude", "longitude", "", "", "idList", "", "traceId", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsExtensionRequestInfo;", "e", IProfileCardConst.KEY_FROM_TYPE, "keyword", "time", "businessMaskArray", "cookie", "Landroid/os/Bundle;", "d", "f", "uin", "", "g", "(Ljava/lang/String;)[Ljava/lang/String;", "count", "fromAction", "", "hasLocalData", WadlProxyConsts.EXTRA_DATA, "isMoreSearch", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "errCode", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsRspBody;", "rsp", "extra", "", "Lcom/tencent/mobileqq/search/business/repo/ntUnifySearchCallback;", "callback", h.F, "groupMask", "sessionInfo", "j", "<init>", "()V", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static long[] f448235b = {1001, Constant.FROM_ID_UNINSTALL_PLUGIN, Constant.FROM_ID_START_ACTIVITY, Constant.FROM_ID_STOP_SERVICE, 2073745984, 1006, 1007, 1108, 1109, 1111, 1110};

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0019\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\tR\u0014\u0010\u0011\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\tR\u0014\u0010\u0012\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\tR\u0014\u0010\u0013\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\tR\u0014\u0010\u0015\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\tR\u0014\u0010\u0016\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\tR\u0014\u0010\u0017\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\tR\u0014\u0010\u0018\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\tR\u0014\u0010\u0019\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\fR\u0014\u0010\u001a\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\fR\u0014\u0010\u001b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\fR\u0014\u0010\u001c\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\tR\u0014\u0010\u001d\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\tR\u0014\u0010\u001e\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\tR\u0014\u0010\u001f\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\tR\u0014\u0010 \u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010\t\u00a8\u0006#"}, d2 = {"Lxo2/c$a;", "", "", "groupMask", "", "a", "b", "", "CMD_DYNAMIC_UNITE_SEARCH", "Ljava/lang/String;", "", "FROM_CLICK_BUTTON", "I", "FROM_CLICK_HOT_WORD", "GROUP_MASK_GUILD_SEARCH", "KEY_IS_FIRST_REQ", "KEY_KEYWORD", "KEY_MASKS", "KEY_MATCH_COUNT", "KEY_SEARCH_DEVICE_INFO", "KEY_SEND_REQ_TIME", "KEY_SOURCE", "KEY_TIME", "KEY_TRACE_ID", "KEY_WORD_SRC", "KEY_WORD_SRC_HOT_WORD", "KEY_WORD_SRC_NOT_HOT_WORD", "KEY_WORD_SRC_UNKNOWN", "NET_RESULT_CODE", "PREF_TAG_UNIFY_HOTWORD_TITLE_LIST", "STEP_NET_QUERY", "STEP_NET_UI", "TAG", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: xo2.c$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(long groupMask) {
            if (groupMask != 1100 && groupMask != 1101 && groupMask != 1701 && groupMask != 1108 && groupMask != 1109) {
                return true;
            }
            return false;
        }

        public final boolean b(long groupMask) {
            if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
                if (groupMask == 1100 || groupMask == 1012 || groupMask == Constant.FROM_ID_START_ACTIVITY) {
                    return true;
                }
                return false;
            }
            return false;
        }

        Companion() {
        }
    }

    private final byte[] c() {
        boolean b16 = ap2.a.f26672a.b();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("noNeedAICard", b16);
        af afVar = af.f284993a;
        QLog.i("QS.UnifySearchNtRepo", 1, "noNeedAICard=" + b16, null);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        byte[] bytes = jSONObject2.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    private final Bundle d(int fromType, String keyword, String time, List<Long> businessMaskArray, byte[] cookie, String traceId) {
        Bundle bundle = new Bundle();
        bundle.putInt(IProfileCardConst.KEY_FROM_TYPE, fromType);
        bundle.putString("keyword", keyword);
        bundle.putString("time", time);
        long[] jArr = new long[businessMaskArray.size()];
        boolean z16 = false;
        int i3 = 0;
        for (Object obj : businessMaskArray) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            jArr[i3] = ((Number) obj).longValue();
            i3 = i16;
        }
        bundle.putLongArray("masks", jArr);
        if (cookie == null) {
            z16 = true;
        }
        bundle.putBoolean("isFirstReq", z16);
        bundle.putLong(ISearchReportApi.KEY_SEND_REQ_TIME, System.currentTimeMillis());
        bundle.putString("traceId", traceId);
        return bundle;
    }

    private final UfsExtensionRequestInfo e(int keyWordSrc, double latitude, double longitude, List<Long> idList, String traceId) {
        List emptyList;
        boolean z16;
        UfsExtensionRequestInfo ufsExtensionRequestInfo = new UfsExtensionRequestInfo();
        ufsExtensionRequestInfo.keyWordSrc = keyWordSrc;
        ufsExtensionRequestInfo.latitude = (float) latitude;
        ufsExtensionRequestInfo.longitude = (float) longitude;
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
        String curAreainfo = from.decodeString("cur_city", null);
        int decodeInt = from.decodeInt("cur_adcode", 0);
        ufsExtensionRequestInfo.adcode = decodeInt;
        if (QLog.isColorLevel()) {
            QLog.d("UnifySearchNtRepo", 2, "unifySearch, area:" + curAreainfo + " code:" + decodeInt);
        }
        if (!TextUtils.isEmpty(curAreainfo)) {
            Intrinsics.checkNotNullExpressionValue(curAreainfo, "curAreainfo");
            List<String> split = new Regex("-").split(curAreainfo, 0);
            if (!split.isEmpty()) {
                ListIterator<String> listIterator = split.listIterator(split.size());
                while (listIterator.hasPrevious()) {
                    if (listIterator.previous().length() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                        break;
                    }
                }
            }
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            Object[] array = emptyList.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr = (String[]) array;
            if (strArr != null) {
                if (strArr.length == 2) {
                    String str = strArr[1];
                    Charset charset = Charsets.UTF_8;
                    byte[] bytes = str.getBytes(charset);
                    Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                    ufsExtensionRequestInfo.region = bytes;
                    byte[] bytes2 = strArr[0].getBytes(charset);
                    Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
                    ufsExtensionRequestInfo.city = bytes2;
                } else if (strArr.length == 1) {
                    byte[] bytes3 = strArr[0].getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes3, "this as java.lang.String).getBytes(charset)");
                    ufsExtensionRequestInfo.city = bytes3;
                }
            }
        }
        if (idList != null) {
            ufsExtensionRequestInfo.pubaccLocalResultList.addAll(idList);
        }
        byte[] bytes4 = traceId.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes4, "this as java.lang.String).getBytes(charset)");
        ufsExtensionRequestInfo.traceId = bytes4;
        ufsExtensionRequestInfo.studyMode = ((IStudyModeApi) QRoute.api(IStudyModeApi.class)).isStudyMode();
        return ufsExtensionRequestInfo;
    }

    private final String f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_info", PlatformInfor.g().getDeviceInfor());
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("UnifySearchNtRepo", 2, "getMergedJsonData JSONException", e16);
            }
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        return jSONObject2;
    }

    private final String[] g(String uin) {
        List emptyList;
        boolean z16;
        String string = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getString("pref_tag_unify_hotword_title_list" + uin, "");
        Intrinsics.checkNotNull(string);
        List<String> split = new Regex("_").split(string, 0);
        if (!split.isEmpty()) {
            ListIterator<String> listIterator = split.listIterator(split.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        Object[] array = emptyList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) array;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(IPerformanceReportTask reportTask, Function4 callback, Bundle extraBundle, int i3, String errMsg, UfsRspBody rsp) {
        Intrinsics.checkNotNullParameter(reportTask, "$reportTask");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(extraBundle, "$extraBundle");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        reportTask.setResultCode(i3);
        reportTask.setResultMsg(errMsg);
        reportTask.report();
        callback.invoke(Integer.valueOf(i3), errMsg, rsp, extraBundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(IPerformanceReportTask reportTask, Function4 callback, Bundle extraBundle, int i3, String errMsg, UfsRspBody rsp) {
        Intrinsics.checkNotNullParameter(reportTask, "$reportTask");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(extraBundle, "$extraBundle");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        reportTask.setResultCode(i3);
        reportTask.setResultMsg(errMsg);
        reportTask.report();
        callback.invoke(Integer.valueOf(i3), errMsg, rsp, extraBundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x015a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(@NotNull String keyword, @NotNull String time, int count, @NotNull List<Long> businessMaskArray, @Nullable List<Long> idList, int fromAction, @Nullable byte[] cookie, double latitude, double longitude, boolean hasLocalData, int fromType, @Nullable Bundle extraData, boolean isMoreSearch, @NotNull final Function4<? super Integer, ? super String, ? super UfsRspBody, ? super Bundle, Unit> callback) {
        int i3;
        int i16;
        int i17;
        IKernelUnifySearchService c16;
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(businessMaskArray, "businessMaskArray");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (TextUtils.isEmpty(keyword)) {
            QLog.e("UnifySearchNtRepo", 2, "send uniteSearch. keyword is empty.");
            return;
        }
        String r16 = SearchUtils.r();
        Intrinsics.checkNotNullExpressionValue(r16, "generateTraceId()");
        final IPerformanceReportTask a16 = Reporters.f231995a.c().a("UnifySearch.Unite");
        a16.setExtra("keyword", keyword);
        a16.setExtra("searchReqTraceId", r16);
        a16.setExtra("isFirstPageReq", Boolean.TRUE);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        String currentAccountUin = appInterface != null ? appInterface.getCurrentAccountUin() : null;
        if (currentAccountUin == null) {
            currentAccountUin = "";
        }
        String[] g16 = g(currentAccountUin);
        if (g16 != null) {
            if (!(g16.length == 0)) {
                int length = g16.length;
                int i18 = 0;
                while (true) {
                    if (i18 >= length) {
                        i3 = 2;
                        break;
                    } else {
                        if (Intrinsics.areEqual(g16[i18], keyword)) {
                            i3 = 1;
                            break;
                        }
                        i18++;
                    }
                }
                UfsReqBody ufsReqBody = new UfsReqBody();
                Charset charset = Charsets.UTF_8;
                byte[] bytes = keyword.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                ufsReqBody.keyWord = bytes;
                String subVersion = AppSetting.f99551k;
                Intrinsics.checkNotNullExpressionValue(subVersion, "subVersion");
                byte[] bytes2 = subVersion.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
                ufsReqBody.version = bytes2;
                if (isMoreSearch) {
                    UfsRootSearcherRequest ufsRootSearcherRequest = new UfsRootSearcherRequest();
                    ufsRootSearcherRequest.business = 128;
                    ufsRootSearcherRequest.busiMaskList.addAll(SearchUtils.j(f448235b));
                    UfsItemRequestUserData ufsItemRequestUserData = new UfsItemRequestUserData();
                    byte[] bytes3 = "3".getBytes(charset);
                    Intrinsics.checkNotNullExpressionValue(bytes3, "this as java.lang.String).getBytes(charset)");
                    ufsItemRequestUserData.userData = bytes3;
                    ufsItemRequestUserData.rptBusiMask = 1108L;
                    ufsRootSearcherRequest.userDataList.add(ufsItemRequestUserData);
                    ufsReqBody.reqEntity = ufsRootSearcherRequest;
                }
                UfsRootSearcherRequest ufsRootSearcherRequest2 = new UfsRootSearcherRequest();
                ufsRootSearcherRequest2.business = 128;
                ufsRootSearcherRequest2.pageSize = count;
                ufsRootSearcherRequest2.busiMaskList.addAll(businessMaskArray);
                if (cookie != null) {
                    ufsRootSearcherRequest2.cookie = cookie;
                }
                String qua3 = QUA.getQUA3();
                Intrinsics.checkNotNullExpressionValue(qua3, "getQUA3()");
                byte[] bytes4 = qua3.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes4, "this as java.lang.String).getBytes(charset)");
                ufsRootSearcherRequest2.qua = bytes4;
                byte[] bytes5 = f().getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes5, "this as java.lang.String).getBytes(charset)");
                ufsRootSearcherRequest2.jsonData = bytes5;
                ufsReqBody.reqTopic = ufsRootSearcherRequest2;
                i16 = fromAction;
                if (i16 == 6) {
                    i16 = 1;
                }
                if (i16 > 0) {
                    i16--;
                }
                ufsReqBody.fromAction = i16;
                if (hasLocalData) {
                    ufsReqBody.clientHasPeopleAndQun = 1;
                }
                if (fromType != 1) {
                    i17 = 0;
                    ufsReqBody.fromTabbarIndex = 0;
                } else if (fromType == 2) {
                    i17 = 0;
                    ufsReqBody.fromTabbarIndex = 1;
                } else if (fromType != 21) {
                    i17 = 0;
                    ufsReqBody.fromTabbarIndex = 0;
                } else {
                    i17 = 0;
                    ufsReqBody.fromTabbarIndex = 2;
                }
                if (extraData != null) {
                    int i19 = extraData.getInt("matchCount", i17);
                    int i26 = extraData.getInt("source", i17);
                    int i27 = extraData.getInt("keyWordSrc", i3);
                    if (i27 != 0) {
                        i3 = i27;
                    }
                    ufsReqBody.locateResultCount = i19;
                    ufsReqBody.source = i26;
                    if (QLog.isColorLevel()) {
                        QLog.d("UnifySearchNtRepo", 2, "matchCount=" + i19 + " source=" + i26);
                    }
                }
                ufsReqBody.extensionRequestInfo = e(i3, latitude, longitude, idList, r16);
                ufsReqBody.bytesExtension = c();
                final Bundle d16 = d(fromType, keyword, time, businessMaskArray, cookie, r16);
                c16 = n.c();
                if (c16 == null) {
                    c16.unifySearch(ufsReqBody, new IUnifySearchCallback() { // from class: xo2.b
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IUnifySearchCallback
                        public final void onResult(int i28, String str, UfsRspBody ufsRspBody) {
                            c.i(IPerformanceReportTask.this, callback, d16, i28, str, ufsRspBody);
                        }
                    });
                    return;
                }
                return;
            }
        }
        i3 = 0;
        UfsReqBody ufsReqBody2 = new UfsReqBody();
        Charset charset2 = Charsets.UTF_8;
        byte[] bytes6 = keyword.getBytes(charset2);
        Intrinsics.checkNotNullExpressionValue(bytes6, "this as java.lang.String).getBytes(charset)");
        ufsReqBody2.keyWord = bytes6;
        String subVersion2 = AppSetting.f99551k;
        Intrinsics.checkNotNullExpressionValue(subVersion2, "subVersion");
        byte[] bytes22 = subVersion2.getBytes(charset2);
        Intrinsics.checkNotNullExpressionValue(bytes22, "this as java.lang.String).getBytes(charset)");
        ufsReqBody2.version = bytes22;
        if (isMoreSearch) {
        }
        UfsRootSearcherRequest ufsRootSearcherRequest22 = new UfsRootSearcherRequest();
        ufsRootSearcherRequest22.business = 128;
        ufsRootSearcherRequest22.pageSize = count;
        ufsRootSearcherRequest22.busiMaskList.addAll(businessMaskArray);
        if (cookie != null) {
        }
        String qua32 = QUA.getQUA3();
        Intrinsics.checkNotNullExpressionValue(qua32, "getQUA3()");
        byte[] bytes42 = qua32.getBytes(charset2);
        Intrinsics.checkNotNullExpressionValue(bytes42, "this as java.lang.String).getBytes(charset)");
        ufsRootSearcherRequest22.qua = bytes42;
        byte[] bytes52 = f().getBytes(charset2);
        Intrinsics.checkNotNullExpressionValue(bytes52, "this as java.lang.String).getBytes(charset)");
        ufsRootSearcherRequest22.jsonData = bytes52;
        ufsReqBody2.reqTopic = ufsRootSearcherRequest22;
        i16 = fromAction;
        if (i16 == 6) {
        }
        if (i16 > 0) {
        }
        ufsReqBody2.fromAction = i16;
        if (hasLocalData) {
        }
        if (fromType != 1) {
        }
        if (extraData != null) {
        }
        ufsReqBody2.extensionRequestInfo = e(i3, latitude, longitude, idList, r16);
        ufsReqBody2.bytesExtension = c();
        final Bundle d162 = d(fromType, keyword, time, businessMaskArray, cookie, r16);
        c16 = n.c();
        if (c16 == null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x004e, code lost:
    
        if (r10 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j(@Nullable String keyword, @Nullable String time, long groupMask, @Nullable String sessionInfo, @NotNull final Function4<? super Integer, ? super String, ? super UfsRspBody, ? super Bundle, Unit> callback) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (TextUtils.isEmpty(keyword)) {
            QLog.e("UnifySearchNtRepo", 2, "[uniteMoreSearch] keyword is empty.");
            return;
        }
        final IPerformanceReportTask a16 = Reporters.f231995a.c().a("UnifySearch.Unite");
        a16.setExtra("keyword", keyword);
        a16.setExtra("isFirstPageReq", Boolean.FALSE);
        UfsReqBody ufsReqBody = new UfsReqBody();
        boolean z16 = false;
        if (keyword != null) {
            bArr = keyword.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bArr, "this as java.lang.String).getBytes(charset)");
        }
        bArr = new byte[0];
        ufsReqBody.keyWord = bArr;
        String subVersion = AppSetting.f99551k;
        Intrinsics.checkNotNullExpressionValue(subVersion, "subVersion");
        Charset charset = Charsets.UTF_8;
        byte[] bytes = subVersion.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        ufsReqBody.version = bytes;
        UfsRootSearcherRequest ufsRootSearcherRequest = new UfsRootSearcherRequest();
        ufsRootSearcherRequest.business = 128;
        String qua3 = QUA.getQUA3();
        Intrinsics.checkNotNullExpressionValue(qua3, "getQUA3()");
        byte[] bytes2 = qua3.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
        ufsRootSearcherRequest.qua = bytes2;
        byte[] bytes3 = f().getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes3, "this as java.lang.String).getBytes(charset)");
        ufsRootSearcherRequest.jsonData = bytes3;
        UfsItemRequestUserData ufsItemRequestUserData = new UfsItemRequestUserData();
        byte[] bytes4 = "3".getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes4, "this as java.lang.String).getBytes(charset)");
        ufsItemRequestUserData.userData = bytes4;
        ufsItemRequestUserData.rptBusiMask = 1108L;
        ufsRootSearcherRequest.userDataList.add(ufsItemRequestUserData);
        UfsItemRequestBusiMask ufsItemRequestBusiMask = new UfsItemRequestBusiMask();
        ufsItemRequestBusiMask.groupMask = groupMask;
        if (sessionInfo != null) {
            byte[] bytes5 = sessionInfo.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes5, "this as java.lang.String).getBytes(charset)");
            ufsItemRequestBusiMask.sessionInfo = bytes5;
        }
        ufsRootSearcherRequest.requestBusiMask = ufsItemRequestBusiMask;
        ufsReqBody.reqEntity = ufsRootSearcherRequest;
        ufsReqBody.source = 5;
        final Bundle bundle = new Bundle();
        bundle.putString("time", time);
        bundle.putString("keyword", keyword);
        bundle.putLongArray("masks", new long[]{groupMask});
        if (sessionInfo == null) {
            z16 = true;
        }
        bundle.putBoolean("isFirstReq", z16);
        bundle.putLong(ISearchReportApi.KEY_SEND_REQ_TIME, System.currentTimeMillis());
        IKernelUnifySearchService c16 = n.c();
        if (c16 != null) {
            c16.unifySearch(ufsReqBody, new IUnifySearchCallback() { // from class: xo2.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IUnifySearchCallback
                public final void onResult(int i3, String str, UfsRspBody ufsRspBody) {
                    c.k(IPerformanceReportTask.this, callback, bundle, i3, str, ufsRspBody);
                }
            });
        }
    }
}
