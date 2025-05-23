package ss;

import android.app.Dialog;
import android.view.Window;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.IFeatureServiceProxy;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {
    public static void a(Dialog dialog) {
        if (!((IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class)).isFeatureSwitchOn("aio_capture_dialog_hide_navigation")) {
            dialog.show();
            return;
        }
        Window window = dialog.getWindow();
        window.setFlags(8, 8);
        dialog.show();
        window.getDecorView().setSystemUiVisibility(5894);
        window.clearFlags(8);
    }
}
