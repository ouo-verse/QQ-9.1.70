package r63;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\t\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lr63/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "outputPath", "", "Lr63/c;", "Ljava/util/List;", "()Ljava/util/List;", "metaVideos", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: r63.d, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class Metadata {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String outputPath;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<MetaVideo> metaVideos;

    public Metadata(@NotNull String outputPath, @NotNull List<MetaVideo> metaVideos) {
        Intrinsics.checkNotNullParameter(outputPath, "outputPath");
        Intrinsics.checkNotNullParameter(metaVideos, "metaVideos");
        this.outputPath = outputPath;
        this.metaVideos = metaVideos;
    }

    @NotNull
    public final List<MetaVideo> a() {
        return this.metaVideos;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getOutputPath() {
        return this.outputPath;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Metadata)) {
            return false;
        }
        Metadata metadata = (Metadata) other;
        if (Intrinsics.areEqual(this.outputPath, metadata.outputPath) && Intrinsics.areEqual(this.metaVideos, metadata.metaVideos)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.outputPath.hashCode() * 31) + this.metaVideos.hashCode();
    }

    @NotNull
    public String toString() {
        return "Metadata(outputPath=" + this.outputPath + ", metaVideos=" + this.metaVideos + ")";
    }
}
