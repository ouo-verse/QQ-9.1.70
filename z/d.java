package z;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.q;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes.dex */
public class d implements com.bumptech.glide.load.g<c> {
    @Override // com.bumptech.glide.load.g
    @NonNull
    public EncodeStrategy b(@NonNull com.bumptech.glide.load.e eVar) {
        return EncodeStrategy.SOURCE;
    }

    @Override // com.bumptech.glide.load.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull q<c> qVar, @NonNull File file, @NonNull com.bumptech.glide.load.e eVar) {
        try {
            h0.a.e(qVar.get().d(), file);
            return true;
        } catch (IOException e16) {
            if (Log.isLoggable("GifEncoder", 5)) {
                Log.w("GifEncoder", "Failed to encode GIF drawable data", e16);
            }
            return false;
        }
    }
}
