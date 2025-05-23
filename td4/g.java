package td4;

import com.tencent.tavcut.core.render.builder.light.model.InputSource;
import com.tencent.tavcut.core.render.builder.light.model.PostEffectOptions;
import com.tencent.tavcut.core.render.builder.light.model.type.TimeStretchMode;
import kotlin.Metadata;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.light.lightAssetKit.components.Rect;
import org.light.lightAssetKit.components.TimeRange;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H&J,\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\tH&J\u001a\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H&J\"\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0004\u001a\u00020\u0002H&J\"\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0011H&J\"\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0004\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H&J*\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0011H&J*\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0011H&\u00a8\u0006\u0019"}, d2 = {"Ltd4/g;", "", "", "pagPath", "id", "Lcom/tencent/tavcut/core/render/builder/light/model/InputSource;", "a", "", "loopCount", "Lcom/tencent/tavcut/core/render/builder/light/model/type/TimeStretchMode;", "timeStretchMode", "g", "path", "b", "Lorg/light/lightAssetKit/components/TimeRange;", "timeRange", tl.h.F, "Lorg/light/lightAssetKit/components/Rect;", "clipRect", "c", "Lcom/tencent/tavcut/core/render/builder/light/model/PostEffectOptions;", "postEffectOptions", "f", "e", "d", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public interface g {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class a {
        public static /* synthetic */ InputSource a(g gVar, String str, int i3, String str2, Rect rect, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 8) != 0) {
                    rect = new Rect(0.0f, 0.0f, 0.0f, 0.0f);
                }
                return gVar.d(str, i3, str2, rect);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createAPngData");
        }

        public static /* synthetic */ InputSource b(g gVar, String str, TimeRange timeRange, String str2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str2 = ByteString.Companion.encodeString$default(ByteString.INSTANCE, str + timeRange.toString(), null, 1, null).md5().hex();
                }
                return gVar.h(str, timeRange, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createAudioClipData");
        }

        public static /* synthetic */ InputSource c(g gVar, String str, int i3, String str2, Rect rect, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 8) != 0) {
                    rect = new Rect(0.0f, 0.0f, 0.0f, 0.0f);
                }
                return gVar.e(str, i3, str2, rect);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createGifData");
        }

        public static /* synthetic */ InputSource d(g gVar, String str, String str2, Rect rect, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    rect = new Rect(0.0f, 0.0f, 0.0f, 0.0f);
                }
                return gVar.c(str, str2, rect);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createImageData");
        }
    }

    @NotNull
    InputSource a(@NotNull String pagPath, @NotNull String id5);

    @NotNull
    InputSource b(@NotNull String path, @NotNull String id5);

    @NotNull
    InputSource c(@NotNull String id5, @NotNull String path, @NotNull Rect clipRect);

    @NotNull
    InputSource d(@NotNull String id5, int loopCount, @NotNull String path, @NotNull Rect clipRect);

    @NotNull
    InputSource e(@NotNull String id5, int loopCount, @NotNull String path, @NotNull Rect clipRect);

    @NotNull
    InputSource f(@NotNull String id5, @NotNull String path, @NotNull PostEffectOptions postEffectOptions);

    @NotNull
    InputSource g(@NotNull String pagPath, int loopCount, @NotNull String id5, @NotNull TimeStretchMode timeStretchMode);

    @NotNull
    InputSource h(@NotNull String str, @NotNull TimeRange timeRange, @NotNull String str2);
}
