package tn4;

import android.text.SpannableStringBuilder;
import com.tencent.timi.game.utils.l;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c {
    public static void a(String str, Object... objArr) {
        String str2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        for (int i3 = 0; i3 < objArr.length; i3++) {
            if (i3 > 0) {
                spannableStringBuilder.append((CharSequence) "_");
            }
            Object obj = objArr[i3];
            if (obj != null) {
                str2 = obj.toString();
            } else {
                str2 = "null";
            }
            spannableStringBuilder.append((CharSequence) str2);
        }
        l.e("TRTCRoom", str + ":" + spannableStringBuilder.toString());
    }
}
