package w;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.e;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes.dex */
public class a implements e<ByteBuffer> {

    /* renamed from: a, reason: collision with root package name */
    private final ByteBuffer f443806a;

    /* compiled from: P */
    /* renamed from: w.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C11448a implements e.a<ByteBuffer> {
        @Override // com.bumptech.glide.load.data.e.a
        @NonNull
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        @Override // com.bumptech.glide.load.data.e.a
        @NonNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public e<ByteBuffer> build(ByteBuffer byteBuffer) {
            return new a(byteBuffer);
        }
    }

    public a(ByteBuffer byteBuffer) {
        this.f443806a = byteBuffer;
    }

    @Override // com.bumptech.glide.load.data.e
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ByteBuffer a() {
        this.f443806a.position(0);
        return this.f443806a;
    }

    @Override // com.bumptech.glide.load.data.e
    public void cleanup() {
    }
}
