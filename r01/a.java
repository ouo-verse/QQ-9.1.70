package r01;

import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import com.tencent.libra.base.model.Model;
import com.tencent.libra.request.ExtraDecoderRequestInfo;
import java.io.File;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface a<DecodeType> {
    boolean a(@NonNull File file);

    boolean b(@NonNull Model<?> model);

    void c(@NonNull ExtraDecoderRequestInfo extraDecoderRequestInfo, @NonNull Consumer<DecodeType> consumer);

    String getLogTag();
}
