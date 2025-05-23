package u01;

import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b implements c {

    /* renamed from: a, reason: collision with root package name */
    private final File f438016a;

    public b(String str) {
        this.f438016a = new File(str);
    }

    @Override // u01.c
    public synchronized t01.d obtain() throws IOException {
        return new t01.b(this.f438016a);
    }

    public b(File file) {
        this.f438016a = file;
    }
}
