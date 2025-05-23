package q1;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.j;
import com.google.common.collect.ah;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: P */
@GwtIncompatible
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private static final ah<File> f428178a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final p1.a<File> f428179b = new b();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class a extends ah<File> {
        a() {
        }

        public String toString() {
            return "Files.fileTreeTraverser()";
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class b implements p1.a<File> {
        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class c extends q1.a {

        /* renamed from: a, reason: collision with root package name */
        private final File f428180a;

        /* synthetic */ c(File file, f fVar) {
            this(file);
        }

        @Override // q1.a
        public byte[] b() throws IOException {
            try {
                FileInputStream fileInputStream = (FileInputStream) e.a().b(c());
                return q1.b.k(fileInputStream, fileInputStream.getChannel().size());
            } finally {
            }
        }

        public FileInputStream c() throws IOException {
            return new FileInputStream(this.f428180a);
        }

        public String toString() {
            return "Files.asByteSource(" + this.f428180a + ")";
        }

        c(File file) {
            this.f428180a = (File) j.m(file);
        }
    }

    public static q1.a a(File file) {
        return new c(file, null);
    }

    public static q1.c b(File file, Charset charset) {
        return a(file).a(charset);
    }

    @Beta
    public static String c(String str) {
        j.m(str);
        String name = new File(str).getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf != -1) {
            return name.substring(0, lastIndexOf);
        }
        return name;
    }

    @Beta
    @Deprecated
    public static String d(File file, Charset charset) throws IOException {
        return b(file, charset).a();
    }
}
