package so0;

import android.text.Editable;
import android.text.Spanned;
import android.text.style.ReplacementSpan;
import com.tencent.guild.aio.input.at.utils.AtTroopMemberSpan;

/* compiled from: P */
/* loaded from: classes6.dex */
public class e {
    public static boolean a(Spanned spanned) {
        AtTroopMemberSpan[] atTroopMemberSpanArr;
        if (spanned == null || (atTroopMemberSpanArr = (AtTroopMemberSpan[]) spanned.getSpans(0, spanned.length(), AtTroopMemberSpan.class)) == null || atTroopMemberSpanArr.length <= 0) {
            return false;
        }
        return true;
    }

    public static <T> boolean b(Editable editable, int i3, int i16, int i17, Class<T> cls) {
        Object[] spans;
        if (i3 < 0 || (spans = editable.getSpans(i16, i17, cls)) == null) {
            return false;
        }
        for (Object obj : spans) {
            int spanStart = editable.getSpanStart(obj);
            int spanEnd = editable.getSpanEnd(obj);
            if (i3 >= spanStart && i3 < spanEnd) {
                return true;
            }
        }
        return false;
    }

    public static int c(Editable editable, int i3) {
        boolean z16;
        boolean z17;
        String obj = editable.toString();
        int length = obj.length();
        if (i3 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i16 = 0;
        int i17 = -1;
        while (z16 && i16 < length) {
            int i18 = i3 - 1;
            i17 = Math.max(obj.lastIndexOf("@", i18), obj.lastIndexOf("\uff20", i18));
            boolean b16 = b(editable, i17, i17, i3, AtTroopMemberSpan.class);
            boolean b17 = b(editable, i17, i17, i3, ReplacementSpan.class);
            if (i17 != -1 && !b16 && b17) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                i3 = i17;
            } else if (b16) {
                return -1;
            }
            i16++;
            z16 = z17;
        }
        return i17;
    }
}
