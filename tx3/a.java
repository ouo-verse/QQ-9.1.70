package tx3;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.ark.ark;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.graytips.handler.c;
import com.tencent.qqnt.kernelpublic.nativeinterface.JsonGrayElement;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rx3.i;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J:\u0010\u0011\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0014"}, d2 = {"Ltx3/a;", "Lcom/tencent/qqnt/graytips/handler/c;", "Landroid/content/Context;", "context", "", "param", "Lgv3/a;", "aioAbility", "", "c", "b", "Lmqq/app/AppRuntime;", "app", "", "jp", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/JsonGrayElement;", "jsonGrayElement", "a", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a implements c {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Regex f437882b = new Regex("^0[xX]");

    private final void b(Context context, String param) {
        String url;
        boolean z16;
        try {
            url = new JSONObject(param).optString("transferaccountsdata");
        } catch (JSONException e16) {
            QLog.e("QWalletGrayTipActionHandler", 1, "handleCollectMoneyJump: url not found in param " + param, e16);
            url = "";
        }
        Intrinsics.checkNotNullExpressionValue(url, "url");
        if (url.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.d("QWalletGrayTipActionHandler", 1, "handleCollectMoneyJump: empty url");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("url", url);
        RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTE_BROWSER);
    }

    /* JADX WARN: Type inference failed for: r5v8, types: [T, java.lang.Object] */
    private final void c(Context context, String param, gv3.a aioAbility) {
        List split$default;
        boolean startsWith$default;
        List split$default2;
        ?? orNull;
        boolean z16;
        com.tencent.aio.api.runtime.a a16;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        String str = "";
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        boolean z17 = true;
        try {
            JSONObject jSONObject = new JSONObject(param);
            Regex regex = f437882b;
            String optString = jSONObject.optString("authkey");
            Intrinsics.checkNotNullExpressionValue(optString, "optString(\"authkey\")");
            byte[] hexStr2Bytes = HexUtil.hexStr2Bytes(regex.replace(optString, ""));
            Intrinsics.checkNotNullExpressionValue(hexStr2Bytes, "hexStr2Bytes(hexRegex.re\u2026ptString(\"authkey\"), \"\"))");
            String str2 = new String(hexStr2Bytes, Charsets.UTF_8);
            String optString2 = jSONObject.optString("redbagdata");
            Intrinsics.checkNotNullExpressionValue(optString2, "optString(\"redbagdata\")");
            split$default = StringsKt__StringsKt.split$default((CharSequence) optString2, new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
            for (Object obj : split$default) {
                int i3 = 0;
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default((String) obj, "listid", false, 2, null);
                if (startsWith$default) {
                    split$default2 = StringsKt__StringsKt.split$default((CharSequence) obj, new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null);
                    orNull = CollectionsKt___CollectionsKt.getOrNull(split$default2, 1);
                    objectRef.element = orNull;
                    CharSequence charSequence = (CharSequence) orNull;
                    if (charSequence != null && charSequence.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (!z16) {
                        if (str2.length() != 0) {
                            z17 = false;
                        }
                        if (!z17) {
                            if (aioAbility != null && (a16 = aioAbility.a()) != null && (g16 = a16.g()) != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null) {
                                i3 = c16.e();
                                str = c16.j();
                            }
                            int a17 = i.f432935a.a(i3);
                            String b16 = com.tencent.mobileqq.base.a.b();
                            String c17 = com.tencent.mobileqq.base.a.c();
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("listid", objectRef.element);
                            jSONObject2.put("name", b16);
                            jSONObject2.put("grouptype", a17);
                            jSONObject2.put(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, str);
                            jSONObject2.put("authkey", str2);
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("userId", c17);
                            jSONObject3.put(HippyHeaderListViewController.VIEW_TAG, "redgiftDetail");
                            jSONObject3.put(j.T0, "appid#1344242394|bargainor_id#1000030201|channel#graytips");
                            jSONObject3.put("come_from", 2);
                            jSONObject3.put("extra_data", jSONObject2.toString());
                            Intent intent = new Intent();
                            intent.putExtra(ark.ARKMETADATA_JSON, jSONObject3.toString());
                            intent.putExtra("callbackSn", "0");
                            intent.putExtra("pay_requestcode", 5);
                            RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTER_PAY_BRIDGE);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        } catch (JSONException e16) {
            QLog.e("QWalletGrayTipActionHandler", 1, "handleRedPacketJump: ", e16);
        }
    }

    @Override // com.tencent.qqnt.graytips.handler.c
    public void a(@NotNull AppRuntime app, @NotNull Context context, int jp5, @NotNull String param, @NotNull JsonGrayElement jsonGrayElement, @Nullable gv3.a aioAbility) {
        String jsonStr;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(jsonGrayElement, "jsonGrayElement");
        if (jsonGrayElement.busiId != 81) {
            QLog.w("QWalletGrayTipActionHandler", 1, "handleOnClick: busiId is not qwallet, jsonGrayElement " + jsonGrayElement);
            return;
        }
        boolean z16 = false;
        try {
            jsonStr = new JSONArray(param).optString(0);
        } catch (JSONException e16) {
            QLog.e("QWalletGrayTipActionHandler", 1, "handleOnClick: invalid param " + param, e16);
            jsonStr = "";
        }
        Intrinsics.checkNotNullExpressionValue(jsonStr, "jsonStr");
        if (jsonStr.length() == 0) {
            z16 = true;
        }
        if (z16) {
            QLog.d("QWalletGrayTipActionHandler", 1, "handleOnClick: empty param in array");
            return;
        }
        if (jp5 != 1) {
            if (jp5 != 2) {
                QLog.w("QWalletGrayTipActionHandler", 1, "handleOnClick: invalid jp " + jp5);
                return;
            }
            b(context, jsonStr);
            return;
        }
        c(context, jsonStr, aioAbility);
    }
}
