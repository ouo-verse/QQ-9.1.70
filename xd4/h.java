package xd4;

import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.composition.model.component.Rect;
import com.tencent.tavcut.composition.model.component.TimeRange;
import com.tencent.tavcut.composition.model.component.TimeStretchMode;
import com.tencent.tavcut.rendermodel.inputsource.InputSourceType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J(\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J \u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J \u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J(\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016J \u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H\u0016\u00a8\u0006\u001a"}, d2 = {"Lxd4/h;", "Lxd4/g;", "", "pagPath", "id", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "a", "", "loopCount", "Lcom/tencent/tavcut/composition/model/component/TimeStretchMode;", "timeStretchMode", "g", "path", "b", "Lcom/tencent/tavcut/composition/model/component/TimeRange;", "timeRange", "f", "Lcom/tencent/tavcut/composition/model/component/Rect;", "clipRect", tl.h.F, "c", "d", "inputKey", "e", "<init>", "()V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class h implements g {

    /* renamed from: a, reason: collision with root package name */
    public static final h f447838a = new h();

    h() {
    }

    @Override // xd4.g
    @NotNull
    public InputSource a(@NotNull String pagPath, @NotNull String id5) {
        Intrinsics.checkParameterIsNotNull(pagPath, "pagPath");
        Intrinsics.checkParameterIsNotNull(id5, "id");
        return g(pagPath, -1, id5, TimeStretchMode.REPEAT);
    }

    @Override // xd4.g
    @NotNull
    public InputSource b(@NotNull String path, @NotNull String id5) {
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(id5, "id");
        return new InputSource(id5, InputSourceType.LUTFilterData.name(), path, path, new TimeRange(0L, 0L, null, 4, null), -1, null, null, null, null, null, null, 4032, null);
    }

    @Override // xd4.g
    @NotNull
    public InputSource c(@NotNull String id5, @NotNull String path, @NotNull TimeRange timeRange, @NotNull Rect clipRect) {
        Intrinsics.checkParameterIsNotNull(id5, "id");
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(timeRange, "timeRange");
        Intrinsics.checkParameterIsNotNull(clipRect, "clipRect");
        return new InputSource(id5, InputSourceType.VideoClipData.name(), path, path, timeRange, 0, null, null, null, clipRect, null, null, 3520, null);
    }

    @Override // xd4.g
    @NotNull
    public InputSource d(@NotNull String id5, @NotNull String path) {
        Intrinsics.checkParameterIsNotNull(id5, "id");
        Intrinsics.checkParameterIsNotNull(path, "path");
        return new InputSource(id5, InputSourceType.TextureData.name(), path, path, null, 0, null, null, null, null, null, null, 4048, null);
    }

    @Override // xd4.g
    @NotNull
    public InputSource e(@NotNull String id5, @NotNull String path, @NotNull String inputKey) {
        Intrinsics.checkParameterIsNotNull(id5, "id");
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(inputKey, "inputKey");
        return new InputSource(id5, InputSourceType.RenderTarget.name(), path, path, null, null, null, inputKey, null, null, null, null, 3952, null);
    }

    @Override // xd4.g
    @NotNull
    public InputSource f(@NotNull String path, @NotNull TimeRange timeRange, @NotNull String id5) {
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(timeRange, "timeRange");
        Intrinsics.checkParameterIsNotNull(id5, "id");
        return new InputSource(id5, InputSourceType.AudioClipData.name(), path, path, timeRange, 0, null, null, null, null, null, null, 4032, null);
    }

    @Override // xd4.g
    @NotNull
    public InputSource g(@NotNull String pagPath, int loopCount, @NotNull String id5, @NotNull TimeStretchMode timeStretchMode) {
        Intrinsics.checkParameterIsNotNull(pagPath, "pagPath");
        Intrinsics.checkParameterIsNotNull(id5, "id");
        Intrinsics.checkParameterIsNotNull(timeStretchMode, "timeStretchMode");
        return new InputSource(id5, InputSourceType.PAGFileData.name(), pagPath, pagPath, new TimeRange(0L, 0L, null, 4, null), Integer.valueOf(loopCount), null, null, Integer.valueOf(ie4.c.a(timeStretchMode)), null, null, null, 3776, null);
    }

    @Override // xd4.g
    @NotNull
    public InputSource h(@NotNull String id5, @NotNull String path, @NotNull Rect clipRect) {
        Intrinsics.checkParameterIsNotNull(id5, "id");
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(clipRect, "clipRect");
        return new InputSource(id5, InputSourceType.ImageData.name(), path, path, new TimeRange(0L, 0L, null, 4, null), 0, null, null, null, clipRect, null, null, 3520, null);
    }
}
