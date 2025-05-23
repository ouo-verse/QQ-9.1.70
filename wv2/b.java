package wv2;

import android.content.Context;
import androidx.annotation.NonNull;
import bw2.h;
import cw2.c;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {
    public static com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.b a(@NonNull a aVar, Context context) {
        int i3 = aVar.f446566b;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    if (i3 != 102) {
                        if (i3 != 104) {
                            return new dw2.a(context, aVar);
                        }
                        return new aw2.b(context, aVar);
                    }
                    return new h(context, aVar);
                }
                return new cw2.b(context, aVar);
            }
            return new c(context, aVar);
        }
        return new xv2.a(context, aVar);
    }
}
