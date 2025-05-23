package ta4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.service.api.IZootopiaPortalMallSendGiftService;
import com.tencent.mobileqq.zplan.api.IZPlanFriendApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ZootopiaPortalGiftData;
import com.tencent.util.QQCustomArkDialogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\f"}, d2 = {"Lta4/b;", "", "Lcom/tencent/sqshow/zootopia/data/p;", "giftData", "Landroid/os/Bundle;", "b", "Landroid/content/Context;", "context", "", "c", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f435764a = new b();

    b() {
    }

    private final Bundle b(ZootopiaPortalGiftData giftData) {
        Bundle bundle = new Bundle();
        bundle.putString("appName", IZootopiaPortalMallSendGiftService.SEND_GIFT_ARK_NAME);
        bundle.putString(QQCustomArkDialogUtil.APP_VIEW, "giftgiving");
        bundle.putString(QQCustomArkDialogUtil.APP_MIN_VERSION, "0.0.0.2");
        bundle.putString(QQCustomArkDialogUtil.META_DATA, giftData.c());
        bundle.putString("forward_ark_app_name", IZootopiaPortalMallSendGiftService.SEND_GIFT_ARK_NAME);
        bundle.putString("forward_ark_app_view", "giftgiving");
        bundle.putString("forward_ark_app_ver", "0.0.0.2");
        bundle.putString("forward_ark_app_meta", giftData.c());
        bundle.putString("forward_ark_app_prompt", "[\u8d85\u7ea7QQ\u79c0]\u793c\u7269\u5df2\u9001\u8fbe");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forward", 0);
            jSONObject.put("type", "normal");
            bundle.putString(AppConstants.Key.FORWARD_ARK_APP_CONFIG, jSONObject.toString());
        } catch (Throwable th5) {
            QLog.e("ZootopiaSendGiftUtil", 1, "sendGiftPreView format config throw t:" + th5);
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ZootopiaPortalGiftData giftData, Context context) {
        Intrinsics.checkNotNullParameter(giftData, "$giftData");
        Intrinsics.checkNotNullParameter(context, "$context");
        Bundle b16 = f435764a.b(giftData);
        Intent intent = new Intent();
        intent.putExtra("forward_type", 27);
        intent.putExtra("is_ark_display_share", true);
        intent.putExtra(IZootopiaPortalMallSendGiftService.FORWARD_ZPLAN_SEND_GIFT, true);
        intent.putExtras(b16);
        intent.putExtra("gift_item_id", giftData.getItemId());
        intent.putExtra("gift_icon_url", giftData.getCoinIcon());
        intent.putExtra("forward_type", 49);
        ((IZPlanFriendApi) QRoute.api(IZPlanFriendApi.class)).openNativeForwardRecentPage(context, intent, EmoticonPackage.MAGIC_FACE_EPID, false, 0);
    }

    public final void c(final Context context, final ZootopiaPortalGiftData giftData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(giftData, "giftData");
        ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: ta4.a
            @Override // java.lang.Runnable
            public final void run() {
                b.d(ZootopiaPortalGiftData.this, context);
            }
        });
    }
}
