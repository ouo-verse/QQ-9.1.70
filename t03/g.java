package t03;

import com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder;
import com.tencent.mobileqq.vas.dynamicDrawable.decoder.DynamicFileDecoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lt03/g;", "Lcom/tencent/cachedrawable/dynamicdrawable/e;", "", "filePath", "Lcom/tencent/cachedrawable/dynamicdrawable/AbsFileDecoder;", "a", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class g implements com.tencent.cachedrawable.dynamicdrawable.e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f435275a = new g();

    g() {
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.e
    @NotNull
    public AbsFileDecoder a(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return new DynamicFileDecoder(filePath);
    }
}
