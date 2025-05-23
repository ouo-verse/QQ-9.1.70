package q;

import java.io.File;

/* compiled from: P */
/* loaded from: classes.dex */
class a {
    public boolean a(File file) {
        return file.exists();
    }

    public File b(String str) {
        return new File(str);
    }

    public long c(File file) {
        return file.length();
    }
}
