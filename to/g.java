package to;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public class g extends b {

    /* renamed from: a, reason: collision with root package name */
    private final List<Integer> f437008a;

    public g(Integer... numArr) {
        if (numArr.length > 0) {
            this.f437008a = Arrays.asList(numArr);
        } else {
            this.f437008a = Arrays.asList(0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0071, code lost:
    
        if (r9.charAt(r4) != ';') goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0073, code lost:
    
        r0 = 1;
     */
    @Override // to.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a(CharSequence charSequence, int i3, Writer writer) throws IOException {
        int i16;
        int parseInt;
        int length = charSequence.length();
        if (charSequence.charAt(i3) == '&' && i3 < length - 2 && charSequence.charAt(i3 + 1) == '#') {
            int i17 = i3 + 2;
            char charAt = charSequence.charAt(i17);
            if (charAt == 'x' || charAt == 'X') {
                i17++;
                if (i17 == length) {
                    return 0;
                }
                i16 = 1;
            } else {
                i16 = 0;
            }
            int i18 = i17;
            while (i18 < length && ((charSequence.charAt(i18) >= '0' && charSequence.charAt(i18) <= '9') || ((charSequence.charAt(i18) >= 'a' && charSequence.charAt(i18) <= 'f') || (charSequence.charAt(i18) >= 'A' && charSequence.charAt(i18) <= 'F')))) {
                i18++;
            }
            int i19 = 0;
            if (i19 == 0) {
                if (d(0)) {
                    return 0;
                }
                if (d(2)) {
                    throw new IllegalArgumentException("Semi-colon required at end of numeric entity");
                }
            }
            try {
                if (i16 != 0) {
                    parseInt = Integer.parseInt(charSequence.subSequence(i17, i18).toString(), 16);
                } else {
                    parseInt = Integer.parseInt(charSequence.subSequence(i17, i18).toString(), 10);
                }
                if (parseInt > 65535) {
                    char[] chars = Character.toChars(parseInt);
                    writer.write(chars[0]);
                    writer.write(chars[1]);
                } else {
                    writer.write(parseInt);
                }
                return ((i18 + 2) - i17) + i16 + i19;
            } catch (NumberFormatException unused) {
            }
        }
        return 0;
    }

    public boolean d(Integer num) {
        List<Integer> list = this.f437008a;
        if (list == null) {
            return false;
        }
        return list.contains(num);
    }
}
