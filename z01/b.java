package z01;

import android.graphics.drawable.Animatable;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import com.tencent.libra.base.model.Model;
import com.tencent.libra.h;
import com.tencent.libra.request.ExtraDecoderRequestInfo;
import com.tencent.libra.util.apng.decode.APNGParser;
import java.io.File;
import t01.e;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b implements r01.a<Animatable> {
    @Override // r01.a
    public boolean a(@NonNull File file) {
        return APNGParser.a(file.getAbsolutePath());
    }

    @Override // r01.a
    public boolean b(@NonNull Model<?> model) {
        return APNGParser.b(new e(model.c()));
    }

    @Override // r01.a
    public void c(@NonNull ExtraDecoderRequestInfo extraDecoderRequestInfo, @NonNull Consumer<Animatable> consumer) {
        consumer.accept(a.j(h.f118788a.b(extraDecoderRequestInfo.e(), extraDecoderRequestInfo.getSrcFile())));
    }

    @Override // r01.a
    public String getLogTag() {
        return "LibraAPNGDecoder";
    }
}
