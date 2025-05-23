package zc3;

import android.content.Context;
import android.os.Bundle;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.ark.module.g;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J&\u0010\t\u001a\u00020\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\r"}, d2 = {"Lzc3/a;", "Lcom/tencent/mobileqq/ark/module/g;", "", "params", "", "a", "appName", AdMetricTag.EVENT_NAME, "", "notify", "<init>", "()V", "d", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a implements g {
    @Override // com.tencent.mobileqq.ark.module.g
    public boolean notify(String appName, String eventName, String params) {
        QLog.d("ZootopiaSendGiftArkNotify", 4, "notify appName:" + appName + ", eventName:" + eventName + ", params:" + params);
        if (!Intrinsics.areEqual(appName, "com.tencent.zplan.giftopening")) {
            return false;
        }
        if (!Intrinsics.areEqual(eventName, "enter_mail")) {
            return true;
        }
        a(params);
        return true;
    }

    private final void a(String params) {
        if (params == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        String optString = jSONObject.optString("jumpSrc");
        int optInt = jSONObject.optInt("cardType");
        int optInt2 = jSONObject.optInt("cardId");
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (QLog.isColorLevel()) {
            QLog.d("ZootopiaSendGiftArkNotify", 2, "handleEnterMail activity:" + qBaseActivity + ", jumpSrc:" + optString + ", mailType:" + optInt + ", mailId:" + optInt2 + ", params:" + params);
        }
        if (!(qBaseActivity instanceof Context)) {
            QLog.e("ZootopiaSendGiftArkNotify", 2, "handleEnterMail activity:" + qBaseActivity + " not Context");
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("jumpSrc", optString);
            jSONObject2.put("jumpMsg", "");
            jSONObject2.put("cardType", optInt);
            jSONObject2.put("cardId", optInt2);
            jSONObject2.put("ViewType", 1);
            jSONObject2.put("subSceneType", 2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("SceneType", 2);
            jSONObject2.put("SubScene", jSONObject3);
            params = jSONObject2.toString();
        } catch (Throwable th5) {
            QLog.e("ZootopiaSendGiftArkNotify", 1, "handleEnterMail jsonParams error, ", th5);
        }
        Bundle bundle = new Bundle();
        bundle.putString("ueParams", params);
        bundle.putBoolean("NeedLoading", true);
        Bundle bundle2 = new Bundle();
        bundle2.putBundle("autoOpenUeParams", bundle);
        ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).startPortalActivity(qBaseActivity, ZootopiaSource.Companion.d(ZootopiaSource.INSTANCE, Source.Ark, ZootopiaSource.SUB_SOURCE_ARK_SEND_GIFT, null, 4, null), bundle2);
    }
}
