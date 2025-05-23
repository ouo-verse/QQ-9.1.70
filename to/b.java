package to;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/* compiled from: P */
/* loaded from: classes36.dex */
public abstract class b {
    public abstract int a(CharSequence charSequence, int i3, Writer writer) throws IOException;

    public final String b(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter(charSequence.length() * 2);
            c(charSequence, stringWriter);
            return stringWriter.toString();
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }

    public final void c(CharSequence charSequence, Writer writer) throws IOException {
        if (writer == null) {
            throw new IllegalArgumentException("The Writer must not be null");
        }
        if (charSequence == null) {
            return;
        }
        int length = charSequence.length();
        int i3 = 0;
        while (i3 < length) {
            int a16 = a(charSequence, i3, writer);
            if (a16 == 0) {
                char[] chars = Character.toChars(Character.codePointAt(charSequence, i3));
                writer.write(chars);
                i3 += chars.length;
            } else {
                for (int i16 = 0; i16 < a16; i16++) {
                    i3 += Character.charCount(Character.codePointAt(charSequence, i3));
                }
            }
        }
    }
}
