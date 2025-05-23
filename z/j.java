package z;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.q;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class j implements com.bumptech.glide.load.f<InputStream, c> {

    /* renamed from: a, reason: collision with root package name */
    private final List<ImageHeaderParser> f451696a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.f<ByteBuffer, c> f451697b;

    /* renamed from: c, reason: collision with root package name */
    private final r.b f451698c;

    public j(List<ImageHeaderParser> list, com.bumptech.glide.load.f<ByteBuffer, c> fVar, r.b bVar) {
        this.f451696a = list;
        this.f451697b = fVar;
        this.f451698c = bVar;
    }

    private static byte[] e(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e16) {
            if (Log.isLoggable("StreamGifDecoder", 5)) {
                Log.w("StreamGifDecoder", "Error reading data from stream", e16);
                return null;
            }
            return null;
        }
    }

    @Override // com.bumptech.glide.load.f
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public q<c> b(@NonNull InputStream inputStream, int i3, int i16, @NonNull com.bumptech.glide.load.e eVar) throws IOException {
        byte[] e16 = e(inputStream);
        if (e16 == null) {
            return null;
        }
        return this.f451697b.b(ByteBuffer.wrap(e16), i3, i16, eVar);
    }

    @Override // com.bumptech.glide.load.f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.e eVar) throws IOException {
        if (!((Boolean) eVar.c(i.f451695b)).booleanValue() && com.bumptech.glide.load.b.e(this.f451696a, inputStream, this.f451698c) == ImageHeaderParser.ImageType.GIF) {
            return true;
        }
        return false;
    }
}
