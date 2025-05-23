package yu2;

import android.content.Context;
import com.tencent.qqlive.ona.protocol.jce.AdInsideVideoItem;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    public static int a(Context context, AdInsideVideoItem adInsideVideoItem, boolean z16) {
        return b(adInsideVideoItem, context, z16, false);
    }

    public static int b(AdInsideVideoItem adInsideVideoItem, Context context, boolean z16, boolean z17) {
        if (z16) {
            return 11;
        }
        boolean k3 = y.k(context);
        if (z17) {
            if (k3) {
                return 15;
            }
            return 14;
        }
        if (k3) {
            return 12;
        }
        return 13;
    }
}
