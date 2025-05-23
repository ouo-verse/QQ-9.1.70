package ri0;

import android.app.Activity;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.biz.common.ECMsgBox;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\r\u00a8\u0006\u0016"}, d2 = {"Lri0/e;", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "Lorg/json/JSONObject;", "data", "", "onCallbackFinished", "", "a", "Ljava/lang/String;", "TAG", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "b", "Ljava/lang/ref/WeakReference;", "activityRef", "Lcom/tencent/ecommerce/biz/common/ECMsgBox;", "c", "msgBoxRef", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "msgBox", "<init>", "(Landroid/app/Activity;Lcom/tencent/ecommerce/biz/common/ECMsgBox;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class e implements IECSchemeCallback {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "HRSignAlertCallback";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<Activity> activityRef;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<ECMsgBox> msgBoxRef;

    public e(Activity activity, ECMsgBox eCMsgBox) {
        this.activityRef = new WeakReference<>(activity);
        this.msgBoxRef = new WeakReference<>(eCMsgBox);
    }

    @Override // com.tencent.ecommerce.base.router.api.IECSchemeCallback
    public void onCallbackFinished(JSONObject data) {
        if (data.optBoolean("cancelDialog")) {
            cg0.a.b(this.TAG, "\u6536\u8d77\u5f39\u7a97");
            Activity activity = this.activityRef.get();
            if (activity != null) {
                activity.finish();
            }
        }
        if (data.optBoolean("regSuccess")) {
            cg0.a.b(this.TAG, "\u7b7e\u7ea6\u6210\u529f");
            ECMsgBox eCMsgBox = this.msgBoxRef.get();
            if (eCMsgBox != null) {
                eCMsgBox.b();
            }
        }
    }
}
