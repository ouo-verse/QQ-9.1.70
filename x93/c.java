package x93;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.IQQWinkLaunchReporter;
import com.tencent.mobileqq.wink.schema.WinkSchemeBean;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

/* compiled from: P */
@Deprecated
/* loaded from: classes21.dex */
public class c extends a {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(Context context, WinkSchemeBean winkSchemeBean, Bundle bundle, WeakReference weakReference, int i3, String str, WinkPublishServiceProxy2 winkPublishServiceProxy2) {
        if (uq3.c.g6() && winkPublishServiceProxy2.getRunningTasks() != null && winkPublishServiceProxy2.getRunningTasks().size() > 0) {
            QLog.w("WinkPageSchemeParser", 1, "[launchWinkPageByScheme] hasRunningTask");
            QQToast.makeText(context, MobileQQ.sMobileQQ.getResources().getString(R.string.f193944ak), 0).show();
            Intent intent = new Intent();
            intent.setPackage(context.getPackageName());
            intent.setAction("CANCEL_JUMPER_TO_QQ_CIRCLE_PUBLISH");
            context.sendBroadcast(intent);
            return;
        }
        Bundle f16 = y93.b.f(winkSchemeBean, bundle);
        Context context2 = (Context) weakReference.get();
        if (context2 == null) {
            QLog.w("WinkPageSchemeParser", 1, "[launchWinkPageByScheme] invalid context");
        } else {
            y93.a.i(context2, f16, i3, str);
        }
    }

    private void d(final Context context, final WinkSchemeBean winkSchemeBean, @Nullable final Bundle bundle) {
        if (winkSchemeBean == null || FastClickUtils.isFastDoubleClick("WinkPageSchemeParser")) {
            return;
        }
        final String e16 = y93.b.e(winkSchemeBean);
        final int d16 = y93.b.d(winkSchemeBean);
        ((IQQWinkLaunchReporter) QRoute.api(IQQWinkLaunchReporter.class)).reportOnClick(context, e16, d16, winkSchemeBean.getSchemeAction());
        final WeakReference weakReference = new WeakReference(context);
        WinkPublishHelper2.INSTANCE.bindService(1, new WinkPublishHelper2.Callback() { // from class: x93.b
            @Override // com.tencent.mobileqq.winkpublish.WinkPublishHelper2.Callback
            public final void onServiceConnected(WinkPublishServiceProxy2 winkPublishServiceProxy2) {
                c.c(context, winkSchemeBean, bundle, weakReference, d16, e16, winkPublishServiceProxy2);
            }
        });
    }

    @Override // x93.a
    public void a(Context context, WinkSchemeBean winkSchemeBean, Bundle bundle) {
        d(context, winkSchemeBean, bundle);
    }
}
