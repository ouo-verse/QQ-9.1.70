package td4;

import com.tencent.tavcut.core.render.builder.light.model.InputSource;
import com.tencent.tavcut.core.render.builder.light.model.PostEffectOptions;
import com.tencent.tavcut.core.render.builder.light.model.type.InputSourceType;
import com.tencent.tavcut.core.render.builder.light.model.type.TimeStretchMode;
import com.tencent.tavcut.core.render.util.TimeStretchModeExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.light.lightAssetKit.components.Rect;
import org.light.lightAssetKit.components.TimeRange;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J(\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J \u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J \u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J(\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J(\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J \u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0016\u00a8\u0006\u001b"}, d2 = {"Ltd4/h;", "Ltd4/g;", "", "pagPath", "id", "Lcom/tencent/tavcut/core/render/builder/light/model/InputSource;", "a", "", "loopCount", "Lcom/tencent/tavcut/core/render/builder/light/model/type/TimeStretchMode;", "timeStretchMode", "g", "path", "b", "Lorg/light/lightAssetKit/components/TimeRange;", "timeRange", tl.h.F, "Lorg/light/lightAssetKit/components/Rect;", "clipRect", "c", "e", "d", "Lcom/tencent/tavcut/core/render/builder/light/model/PostEffectOptions;", "postEffectOptions", "f", "<init>", "()V", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class h implements g {

    /* renamed from: a, reason: collision with root package name */
    public static final h f435877a = new h();

    h() {
    }

    @Override // td4.g
    @NotNull
    public InputSource a(@NotNull String pagPath, @NotNull String id5) {
        Intrinsics.checkParameterIsNotNull(pagPath, "pagPath");
        Intrinsics.checkParameterIsNotNull(id5, "id");
        return g(pagPath, -1, id5, TimeStretchMode.REPEAT);
    }

    @Override // td4.g
    @NotNull
    public InputSource b(@NotNull String path, @NotNull String id5) {
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(id5, "id");
        return new InputSource(id5, InputSourceType.LUTFilterData.name(), path, path, new TimeRange(0L, 0L), -1, null, null, null, null, null, 1984, null);
    }

    @Override // td4.g
    @NotNull
    public InputSource c(@NotNull String id5, @NotNull String path, @NotNull Rect clipRect) {
        Intrinsics.checkParameterIsNotNull(id5, "id");
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(clipRect, "clipRect");
        return new InputSource(id5, InputSourceType.ImageData.name(), path, path, new TimeRange(0L, 0L), 0, null, null, null, clipRect, null, 1472, null);
    }

    @Override // td4.g
    @NotNull
    public InputSource d(@NotNull String id5, int loopCount, @NotNull String path, @NotNull Rect clipRect) {
        Intrinsics.checkParameterIsNotNull(id5, "id");
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(clipRect, "clipRect");
        return new InputSource(id5, InputSourceType.ExtImageAPNG.name(), path, path, new TimeRange(0L, 0L), Integer.valueOf(loopCount), null, null, null, clipRect, null, 1472, null);
    }

    @Override // td4.g
    @NotNull
    public InputSource e(@NotNull String id5, int loopCount, @NotNull String path, @NotNull Rect clipRect) {
        Intrinsics.checkParameterIsNotNull(id5, "id");
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(clipRect, "clipRect");
        return new InputSource(id5, InputSourceType.ExtImageGIF.name(), path, path, new TimeRange(0L, 0L), Integer.valueOf(loopCount), null, null, null, clipRect, null, 1472, null);
    }

    @Override // td4.g
    @NotNull
    public InputSource f(@NotNull String id5, @NotNull String path, @NotNull PostEffectOptions postEffectOptions) {
        Intrinsics.checkParameterIsNotNull(id5, "id");
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(postEffectOptions, "postEffectOptions");
        return new InputSource(id5, InputSourceType.PostEffectData.name(), path, path, null, null, null, null, null, null, postEffectOptions, 1008, null);
    }

    @Override // td4.g
    @NotNull
    public InputSource g(@NotNull String pagPath, int loopCount, @NotNull String id5, @NotNull TimeStretchMode timeStretchMode) {
        Intrinsics.checkParameterIsNotNull(pagPath, "pagPath");
        Intrinsics.checkParameterIsNotNull(id5, "id");
        Intrinsics.checkParameterIsNotNull(timeStretchMode, "timeStretchMode");
        return new InputSource(id5, InputSourceType.PAGFileData.name(), pagPath, pagPath, new TimeRange(0L, 0L), Integer.valueOf(loopCount), null, null, Integer.valueOf(TimeStretchModeExtKt.toPagTimeStretchMode(timeStretchMode)), null, null, 1728, null);
    }

    @Override // td4.g
    @NotNull
    public InputSource h(@NotNull String path, @NotNull TimeRange timeRange, @NotNull String id5) {
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(timeRange, "timeRange");
        Intrinsics.checkParameterIsNotNull(id5, "id");
        return new InputSource(id5, InputSourceType.AudioClipData.name(), path, path, timeRange, 0, null, null, null, null, null, 1984, null);
    }
}
