package t01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b extends c {

    /* renamed from: e, reason: collision with root package name */
    private final File f435223e;

    public b(File file) throws IOException {
        super(new e(new FileInputStream(file)));
        this.f435223e = file;
    }

    @Override // t01.c, t01.d
    public void reset() throws IOException {
        this.f435224d.close();
        this.f435224d = new e(new FileInputStream(this.f435223e));
    }
}
