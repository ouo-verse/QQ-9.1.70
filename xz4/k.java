package xz4;

import com.xingin.xhssharesdk.XhsSdkInject;
import com.xingin.xhssharesdk.core.XhsShareSdk;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class k implements oz4.a {
    @Override // oz4.a
    public final void a(String str) {
        if (XhsSdkInject.isDebugTracker()) {
            XhsShareSdk.b("XhsShare_SdkTrackerLog", str);
        }
    }
}
