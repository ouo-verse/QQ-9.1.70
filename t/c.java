package t;

import android.util.Log;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes.dex */
public class c implements com.bumptech.glide.load.a<ByteBuffer> {
    @Override // com.bumptech.glide.load.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull File file, @NonNull com.bumptech.glide.load.e eVar) {
        try {
            h0.a.e(byteBuffer, file);
            return true;
        } catch (IOException e16) {
            if (Log.isLoggable("ByteBufferEncoder", 3)) {
                Log.d("ByteBufferEncoder", "Failed to write data", e16);
            }
            return false;
        }
    }
}
