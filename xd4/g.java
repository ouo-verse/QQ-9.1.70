package xd4;

import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.composition.model.component.Rect;
import com.tencent.tavcut.composition.model.component.TimeRange;
import com.tencent.tavcut.composition.model.component.TimeStretchMode;
import kotlin.Metadata;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H&J,\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\tH&J\u001a\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H&J\"\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0004\u001a\u00020\u0002H&J\"\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0011H&J(\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H&J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H&J \u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H&\u00a8\u0006\u0018"}, d2 = {"Lxd4/g;", "", "", "pagPath", "id", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "a", "", "loopCount", "Lcom/tencent/tavcut/composition/model/component/TimeStretchMode;", "timeStretchMode", "g", "path", "b", "Lcom/tencent/tavcut/composition/model/component/TimeRange;", "timeRange", "f", "Lcom/tencent/tavcut/composition/model/component/Rect;", "clipRect", tl.h.F, "c", "d", "inputKey", "e", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public interface g {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class a {
        public static /* synthetic */ InputSource a(g gVar, String str, String str2, Rect rect, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    rect = new Rect(0.0f, 0.0f, 0.0f, 0.0f, null, 16, null);
                }
                return gVar.h(str, str2, rect);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createImageData");
        }

        public static /* synthetic */ InputSource b(g gVar, String str, String str2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    str2 = ByteString.Companion.encodeString$default(ByteString.INSTANCE, str, null, 1, null).md5().hex();
                }
                return gVar.a(str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createPagAsset");
        }
    }

    @NotNull
    InputSource a(@NotNull String pagPath, @NotNull String id5);

    @NotNull
    InputSource b(@NotNull String path, @NotNull String id5);

    @NotNull
    InputSource c(@NotNull String id5, @NotNull String path, @NotNull TimeRange timeRange, @NotNull Rect clipRect);

    @NotNull
    InputSource d(@NotNull String id5, @NotNull String path);

    @NotNull
    InputSource e(@NotNull String id5, @NotNull String path, @NotNull String inputKey);

    @NotNull
    InputSource f(@NotNull String path, @NotNull TimeRange timeRange, @NotNull String id5);

    @NotNull
    InputSource g(@NotNull String pagPath, int loopCount, @NotNull String id5, @NotNull TimeStretchMode timeStretchMode);

    @NotNull
    InputSource h(@NotNull String id5, @NotNull String path, @NotNull Rect clipRect);
}
