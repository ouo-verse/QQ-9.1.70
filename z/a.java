package z;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import h0.k;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;
import v.l;

/* compiled from: P */
/* loaded from: classes.dex */
public class a implements com.bumptech.glide.load.f<ByteBuffer, c> {

    /* renamed from: f, reason: collision with root package name */
    private static final C11641a f451653f = new C11641a();

    /* renamed from: g, reason: collision with root package name */
    private static final b f451654g = new b();

    /* renamed from: a, reason: collision with root package name */
    private final Context f451655a;

    /* renamed from: b, reason: collision with root package name */
    private final List<ImageHeaderParser> f451656b;

    /* renamed from: c, reason: collision with root package name */
    private final b f451657c;

    /* renamed from: d, reason: collision with root package name */
    private final C11641a f451658d;

    /* renamed from: e, reason: collision with root package name */
    private final z.b f451659e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @VisibleForTesting
    /* renamed from: z.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C11641a {
        C11641a() {
        }

        GifDecoder a(GifDecoder.a aVar, com.bumptech.glide.gifdecoder.b bVar, ByteBuffer byteBuffer, int i3) {
            return new com.bumptech.glide.gifdecoder.d(aVar, bVar, byteBuffer, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Queue<com.bumptech.glide.gifdecoder.c> f451660a = k.e(0);

        b() {
        }

        synchronized com.bumptech.glide.gifdecoder.c a(ByteBuffer byteBuffer) {
            com.bumptech.glide.gifdecoder.c poll;
            poll = this.f451660a.poll();
            if (poll == null) {
                poll = new com.bumptech.glide.gifdecoder.c();
            }
            return poll.p(byteBuffer);
        }

        synchronized void b(com.bumptech.glide.gifdecoder.c cVar) {
            cVar.a();
            this.f451660a.offer(cVar);
        }
    }

    public a(Context context, List<ImageHeaderParser> list, r.d dVar, r.b bVar) {
        this(context, list, dVar, bVar, f451654g, f451653f);
    }

    @Nullable
    private e c(ByteBuffer byteBuffer, int i3, int i16, com.bumptech.glide.gifdecoder.c cVar, com.bumptech.glide.load.e eVar) {
        Bitmap.Config config;
        long b16 = h0.f.b();
        try {
            com.bumptech.glide.gifdecoder.b c16 = cVar.c();
            if (c16.b() > 0 && c16.c() == 0) {
                if (eVar.c(i.f451694a) == DecodeFormat.PREFER_RGB_565) {
                    config = Bitmap.Config.RGB_565;
                } else {
                    config = Bitmap.Config.ARGB_8888;
                }
                GifDecoder a16 = this.f451658d.a(this.f451659e, c16, byteBuffer, e(c16, i3, i16));
                a16.a(config);
                a16.advance();
                Bitmap nextFrame = a16.getNextFrame();
                if (nextFrame == null) {
                    return null;
                }
                e eVar2 = new e(new c(this.f451655a, a16, l.c(), i3, i16, nextFrame));
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    Log.v("BufferGifDecoder", "Decoded GIF from stream in " + h0.f.a(b16));
                }
                return eVar2;
            }
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + h0.f.a(b16));
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + h0.f.a(b16));
            }
        }
    }

    private static int e(com.bumptech.glide.gifdecoder.b bVar, int i3, int i16) {
        int highestOneBit;
        int min = Math.min(bVar.a() / i16, bVar.d() / i3);
        if (min == 0) {
            highestOneBit = 0;
        } else {
            highestOneBit = Integer.highestOneBit(min);
        }
        int max = Math.max(1, highestOneBit);
        if (Log.isLoggable("BufferGifDecoder", 2) && max > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i3 + HippyTKDListViewAdapter.X + i16 + "], actual dimens: [" + bVar.d() + HippyTKDListViewAdapter.X + bVar.a() + "]");
        }
        return max;
    }

    @Override // com.bumptech.glide.load.f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public e b(@NonNull ByteBuffer byteBuffer, int i3, int i16, @NonNull com.bumptech.glide.load.e eVar) {
        com.bumptech.glide.gifdecoder.c a16 = this.f451657c.a(byteBuffer);
        try {
            return c(byteBuffer, i3, i16, a16, eVar);
        } finally {
            this.f451657c.b(a16);
        }
    }

    @Override // com.bumptech.glide.load.f
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull com.bumptech.glide.load.e eVar) throws IOException {
        if (!((Boolean) eVar.c(i.f451695b)).booleanValue() && com.bumptech.glide.load.b.f(this.f451656b, byteBuffer) == ImageHeaderParser.ImageType.GIF) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    a(Context context, List<ImageHeaderParser> list, r.d dVar, r.b bVar, b bVar2, C11641a c11641a) {
        this.f451655a = context.getApplicationContext();
        this.f451656b = list;
        this.f451658d = c11641a;
        this.f451659e = new z.b(dVar, bVar);
        this.f451657c = bVar2;
    }
}
