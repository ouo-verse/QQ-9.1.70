package xz4;

import android.text.TextUtils;
import com.xingin.xhssharesdk.XhsSdkInject;
import com.xingin.xhssharesdk.core.XhsShareSdk;
import oz4.h;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class l implements h.a {
    public final String a() {
        String str;
        if (TextUtils.isEmpty(XhsShareSdk.f389978b)) {
            if (!TextUtils.isEmpty(XhsSdkInject.getUid())) {
                str = XhsSdkInject.getUid();
            } else {
                str = "" + System.currentTimeMillis();
            }
            XhsShareSdk.f389978b = str;
        }
        return XhsShareSdk.f389978b;
    }
}
