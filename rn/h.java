package rn;

import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.qzone.picload.c;

/* compiled from: P */
/* loaded from: classes36.dex */
public class h {
    public static void a(ImageView imageView, String str, int i3) {
        if (imageView == null || TextUtils.isEmpty(str) || i3 == 0) {
            return;
        }
        com.tencent.mobileqq.qzone.picload.c.a().j(imageView, new c.C8489c().h(str).f("").e(i3).g(true));
    }
}
