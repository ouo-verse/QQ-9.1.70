package t;

import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import t.n;

/* compiled from: P */
/* loaded from: classes.dex */
public class b<Data> implements n<byte[], Data> {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC11266b<Data> f435078a;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class a implements o<byte[], ByteBuffer> {

        /* compiled from: P */
        /* renamed from: t.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C11265a implements InterfaceC11266b<ByteBuffer> {
            C11265a() {
            }

            @Override // t.b.InterfaceC11266b
            public Class<ByteBuffer> a() {
                return ByteBuffer.class;
            }

            @Override // t.b.InterfaceC11266b
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public ByteBuffer b(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }
        }

        @Override // t.o
        @NonNull
        public n<byte[], ByteBuffer> b(@NonNull r rVar) {
            return new b(new C11265a());
        }
    }

    /* compiled from: P */
    /* renamed from: t.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC11266b<Data> {
        Class<Data> a();

        Data b(byte[] bArr);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class d implements o<byte[], InputStream> {

        /* compiled from: P */
        /* loaded from: classes.dex */
        class a implements InterfaceC11266b<InputStream> {
            a() {
            }

            @Override // t.b.InterfaceC11266b
            public Class<InputStream> a() {
                return InputStream.class;
            }

            @Override // t.b.InterfaceC11266b
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public InputStream b(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }
        }

        @Override // t.o
        @NonNull
        public n<byte[], InputStream> b(@NonNull r rVar) {
            return new b(new a());
        }
    }

    public b(InterfaceC11266b<Data> interfaceC11266b) {
        this.f435078a = interfaceC11266b;
    }

    @Override // t.n
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public n.a<Data> a(@NonNull byte[] bArr, int i3, int i16, @NonNull com.bumptech.glide.load.e eVar) {
        return new n.a<>(new g0.b(bArr), new c(bArr, this.f435078a));
    }

    @Override // t.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean handles(@NonNull byte[] bArr) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class c<Data> implements com.bumptech.glide.load.data.d<Data> {

        /* renamed from: d, reason: collision with root package name */
        private final byte[] f435080d;

        /* renamed from: e, reason: collision with root package name */
        private final InterfaceC11266b<Data> f435081e;

        c(byte[] bArr, InterfaceC11266b<Data> interfaceC11266b) {
            this.f435080d = bArr;
            this.f435081e = interfaceC11266b;
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<Data> a() {
            return this.f435081e.a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void b(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            aVar.d(this.f435081e.b(this.f435080d));
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.d
        public void cleanup() {
        }
    }
}
