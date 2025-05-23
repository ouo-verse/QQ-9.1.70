package xd4;

import android.graphics.Matrix;
import com.tencent.tavcut.composition.model.component.TimeRange;
import com.tencent.tavcut.model.ClipSource;
import com.tencent.tavcut.rendermodel.transform.MatrixTransform;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lxd4/a;", "Lxd4/d;", "", "path", "Lcom/tencent/tavcut/composition/model/component/TimeRange;", "timeRange", "Lcom/tencent/tavcut/model/ClipSource;", "b", "a", "<init>", "()V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class a implements d {

    /* renamed from: a, reason: collision with root package name */
    public static final a f447835a = new a();

    a() {
    }

    @Override // xd4.d
    @NotNull
    public ClipSource a(@NotNull String path, @NotNull TimeRange timeRange) {
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(timeRange, "timeRange");
        Matrix matrix = new Matrix();
        ClipSource.ClipType clipType = ClipSource.ClipType.PHOTO;
        return new ClipSource(UUID.randomUUID().toString(), path, clipType, timeRange.duration, null, null, Long.valueOf(timeRange.startTime), MatrixTransform.transMatrixToListMatrix(matrix), null, null, null, null, 3888, null);
    }

    @Override // xd4.d
    @NotNull
    public ClipSource b(@NotNull String path, @NotNull TimeRange timeRange) {
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(timeRange, "timeRange");
        Matrix matrix = new Matrix();
        ClipSource.ClipType clipType = ClipSource.ClipType.VIDEO;
        String uuid = UUID.randomUUID().toString();
        Long valueOf = Long.valueOf(timeRange.startTime);
        long j3 = timeRange.duration;
        Float valueOf2 = Float.valueOf(1.0f);
        return new ClipSource(uuid, path, clipType, j3, valueOf2, valueOf2, valueOf, MatrixTransform.transMatrixToListMatrix(matrix), null, null, null, null, 3840, null);
    }
}
