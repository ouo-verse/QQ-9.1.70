package to;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes36.dex */
public class f extends b {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<CharSequence, CharSequence> f437005a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private final int f437006b;

    /* renamed from: c, reason: collision with root package name */
    private final int f437007c;

    public f(CharSequence[]... charSequenceArr) {
        int i3 = Integer.MAX_VALUE;
        int i16 = 0;
        if (charSequenceArr != null) {
            int i17 = 0;
            for (CharSequence[] charSequenceArr2 : charSequenceArr) {
                this.f437005a.put(charSequenceArr2[0], charSequenceArr2[1]);
                int length = charSequenceArr2[0].length();
                i3 = length < i3 ? length : i3;
                if (length > i17) {
                    i17 = length;
                }
            }
            i16 = i17;
        }
        this.f437006b = i3;
        this.f437007c = i16;
    }

    @Override // to.b
    public int a(CharSequence charSequence, int i3, Writer writer) throws IOException {
        int i16 = this.f437007c;
        if (i3 + i16 > charSequence.length()) {
            i16 = charSequence.length() - i3;
        }
        while (i16 >= this.f437006b) {
            CharSequence charSequence2 = this.f437005a.get(charSequence.subSequence(i3, i3 + i16));
            if (charSequence2 != null) {
                writer.write(charSequence2.toString());
                return i16;
            }
            i16--;
        }
        return 0;
    }
}
