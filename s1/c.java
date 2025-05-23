package s1;

import com.google.common.annotations.GwtCompatible;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public final class c {
    public static int a(int i3, int i16) {
        if (i3 < i16) {
            return -1;
        }
        if (i3 > i16) {
            return 1;
        }
        return 0;
    }

    public static int b(long j3) {
        if (j3 > TTL.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (j3 < WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
            return Integer.MIN_VALUE;
        }
        return (int) j3;
    }
}
