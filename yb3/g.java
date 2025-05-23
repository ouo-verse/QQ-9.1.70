package yb3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 \r2\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\n\u0010\bR\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\b\u00a8\u0006\u0011"}, d2 = {"Lyb3/g;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "uploadUrlPrefix", "c", "coverUrlPrefix", "getCoverUrlTestPrefix", "d", "coverUrlTestPrefix", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String uploadUrlPrefix = "https://hongbao.meta.qq.com";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String coverUrlPrefix = "https://wuji-1258344701.file.myqcloud.com/redpackage/prod";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String coverUrlTestPrefix = "https://wuji-1258344701.file.myqcloud.com/redpackage/test";

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getCoverUrlPrefix() {
        return this.coverUrlPrefix;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getUploadUrlPrefix() {
        return this.uploadUrlPrefix;
    }

    public final void c(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.coverUrlPrefix = str;
    }

    public final void d(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.coverUrlTestPrefix = str;
    }

    public final void e(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uploadUrlPrefix = str;
    }
}
