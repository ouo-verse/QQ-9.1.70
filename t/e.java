package t;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import t.n;

/* compiled from: P */
/* loaded from: classes.dex */
public final class e<Model, Data> implements n<Model, Data> {

    /* renamed from: a, reason: collision with root package name */
    private final a<Data> f435084a;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface a<Data> {
        Class<Data> a();

        void b(Data data) throws IOException;

        Data decode(String str) throws IllegalArgumentException;
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class c<Model> implements o<Model, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final a<InputStream> f435088a = new a();

        /* compiled from: P */
        /* loaded from: classes.dex */
        class a implements a<InputStream> {
            a() {
            }

            @Override // t.e.a
            public Class<InputStream> a() {
                return InputStream.class;
            }

            @Override // t.e.a
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void b(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // t.e.a
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public InputStream decode(String str) {
                if (str.startsWith("data:image")) {
                    int indexOf = str.indexOf(44);
                    if (indexOf != -1) {
                        if (str.substring(0, indexOf).endsWith(";base64")) {
                            return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                        }
                        throw new IllegalArgumentException("Not a base64 image data URL.");
                    }
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                throw new IllegalArgumentException("Not a valid image data URL.");
            }
        }

        @Override // t.o
        @NonNull
        public n<Model, InputStream> b(@NonNull r rVar) {
            return new e(this.f435088a);
        }
    }

    public e(a<Data> aVar) {
        this.f435084a = aVar;
    }

    @Override // t.n
    public n.a<Data> a(@NonNull Model model, int i3, int i16, @NonNull com.bumptech.glide.load.e eVar) {
        return new n.a<>(new g0.b(model), new b(model.toString(), this.f435084a));
    }

    @Override // t.n
    public boolean handles(@NonNull Model model) {
        return model.toString().startsWith("data:image");
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static final class b<Data> implements com.bumptech.glide.load.data.d<Data> {

        /* renamed from: d, reason: collision with root package name */
        private final String f435085d;

        /* renamed from: e, reason: collision with root package name */
        private final a<Data> f435086e;

        /* renamed from: f, reason: collision with root package name */
        private Data f435087f;

        b(String str, a<Data> aVar) {
            this.f435085d = str;
            this.f435086e = aVar;
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<Data> a() {
            return this.f435086e.a();
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, Data] */
        @Override // com.bumptech.glide.load.data.d
        public void b(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            try {
                Data decode = this.f435086e.decode(this.f435085d);
                this.f435087f = decode;
                aVar.d(decode);
            } catch (IllegalArgumentException e16) {
                aVar.c(e16);
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void cleanup() {
            try {
                this.f435086e.b(this.f435087f);
            } catch (IOException unused) {
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
