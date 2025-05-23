package td4;

import android.graphics.Matrix;
import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.tavcut.core.render.builder.light.model.type.ClipType;
import com.tencent.tavcut.core.render.util.MatrixTransform;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.light.lightAssetKit.components.TimeRange;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Ltd4/a;", "Ltd4/d;", "", "path", "Lorg/light/lightAssetKit/components/TimeRange;", "timeRange", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "b", "a", "<init>", "()V", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class a implements d {

    /* renamed from: a, reason: collision with root package name */
    public static final a f435874a = new a();

    a() {
    }

    @Override // td4.d
    @NotNull
    public ClipSource a(@NotNull String path, @NotNull TimeRange timeRange) {
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(timeRange, "timeRange");
        Matrix matrix = new Matrix();
        ClipType clipType = ClipType.PHOTO;
        return new ClipSource(UUID.randomUUID().toString(), path, clipType, timeRange.duration, null, null, Long.valueOf(timeRange.startTime), MatrixTransform.transMatrixToListMatrix(matrix), null, null, null, null, null, 7984, null);
    }

    @Override // td4.d
    @NotNull
    public ClipSource b(@NotNull String path, @NotNull TimeRange timeRange) {
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(timeRange, "timeRange");
        Matrix matrix = new Matrix();
        ClipType clipType = ClipType.VIDEO;
        String uuid = UUID.randomUUID().toString();
        Long valueOf = Long.valueOf(timeRange.startTime);
        long j3 = timeRange.duration;
        Float valueOf2 = Float.valueOf(1.0f);
        return new ClipSource(uuid, path, clipType, j3, valueOf2, valueOf2, valueOf, MatrixTransform.transMatrixToListMatrix(matrix), null, null, null, null, null, 7936, null);
    }
}
