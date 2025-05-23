package t;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import t.n;

/* compiled from: P */
/* loaded from: classes.dex */
public class f<Data> implements n<File, Data> {

    /* renamed from: a, reason: collision with root package name */
    private final d<Data> f435090a;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class a<Data> implements o<File, Data> {

        /* renamed from: a, reason: collision with root package name */
        private final d<Data> f435091a;

        public a(d<Data> dVar) {
            this.f435091a = dVar;
        }

        @Override // t.o
        @NonNull
        public final n<File, Data> b(@NonNull r rVar) {
            return new f(this.f435091a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class b extends a<ParcelFileDescriptor> {

        /* compiled from: P */
        /* loaded from: classes.dex */
        class a implements d<ParcelFileDescriptor> {
            a() {
            }

            @Override // t.f.d
            public Class<ParcelFileDescriptor> a() {
                return ParcelFileDescriptor.class;
            }

            @Override // t.f.d
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void b(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                parcelFileDescriptor.close();
            }

            @Override // t.f.d
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public ParcelFileDescriptor c(File file) throws FileNotFoundException {
                return ParcelFileDescriptor.open(file, 268435456);
            }
        }

        public b() {
            super(new a());
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface d<Data> {
        Class<Data> a();

        void b(Data data) throws IOException;

        Data c(File file) throws FileNotFoundException;
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class e extends a<InputStream> {

        /* compiled from: P */
        /* loaded from: classes.dex */
        class a implements d<InputStream> {
            a() {
            }

            @Override // t.f.d
            public Class<InputStream> a() {
                return InputStream.class;
            }

            @Override // t.f.d
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void b(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // t.f.d
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public InputStream c(File file) throws FileNotFoundException {
                return new FileInputStream(file);
            }
        }

        public e() {
            super(new a());
        }
    }

    public f(d<Data> dVar) {
        this.f435090a = dVar;
    }

    @Override // t.n
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public n.a<Data> a(@NonNull File file, int i3, int i16, @NonNull com.bumptech.glide.load.e eVar) {
        return new n.a<>(new g0.b(file), new c(file, this.f435090a));
    }

    @Override // t.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean handles(@NonNull File file) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class c<Data> implements com.bumptech.glide.load.data.d<Data> {

        /* renamed from: d, reason: collision with root package name */
        private final File f435092d;

        /* renamed from: e, reason: collision with root package name */
        private final d<Data> f435093e;

        /* renamed from: f, reason: collision with root package name */
        private Data f435094f;

        c(File file, d<Data> dVar) {
            this.f435092d = file;
            this.f435093e = dVar;
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<Data> a() {
            return this.f435093e.a();
        }

        /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object, Data] */
        @Override // com.bumptech.glide.load.data.d
        public void b(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            try {
                Data c16 = this.f435093e.c(this.f435092d);
                this.f435094f = c16;
                aVar.d(c16);
            } catch (FileNotFoundException e16) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", e16);
                }
                aVar.c(e16);
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void cleanup() {
            Data data = this.f435094f;
            if (data != null) {
                try {
                    this.f435093e.b(data);
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }
    }
}
