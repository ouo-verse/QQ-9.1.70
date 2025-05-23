package t;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import t.n;

/* compiled from: P */
/* loaded from: classes.dex */
public class d implements n<File, ByteBuffer> {

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class b implements o<File, ByteBuffer> {
        @Override // t.o
        @NonNull
        public n<File, ByteBuffer> b(@NonNull r rVar) {
            return new d();
        }
    }

    @Override // t.n
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public n.a<ByteBuffer> a(@NonNull File file, int i3, int i16, @NonNull com.bumptech.glide.load.e eVar) {
        return new n.a<>(new g0.b(file), new a(file));
    }

    @Override // t.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean handles(@NonNull File file) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class a implements com.bumptech.glide.load.data.d<ByteBuffer> {

        /* renamed from: d, reason: collision with root package name */
        private final File f435083d;

        a(File file) {
            this.f435083d = file;
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        @Override // com.bumptech.glide.load.data.d
        public void b(@NonNull Priority priority, @NonNull d.a<? super ByteBuffer> aVar) {
            try {
                aVar.d(h0.a.a(this.f435083d));
            } catch (IOException e16) {
                if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                    Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e16);
                }
                aVar.c(e16);
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

        @Override // com.bumptech.glide.load.data.d
        public void cleanup() {
        }
    }
}
