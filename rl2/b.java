package rl2;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u0003\u00a2\u0006\u0004\b\b\u0010\u000bB\u0017\b\u0016\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\b\u0010\fJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lrl2/b;", "Lrl2/e;", "", "", "d", "a", "Ljava/util/List;", "pathList", "<init>", "()V", "path", "(Ljava/lang/String;)V", "(Ljava/util/List;)V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b extends e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private List<String> pathList;

    public b() {
    }

    @Override // rl2.e
    @NotNull
    public List<String> d() {
        List<String> list = this.pathList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pathList");
            return null;
        }
        return list;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(@NotNull String path) {
        this();
        List<String> listOf;
        Intrinsics.checkNotNullParameter(path, "path");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(path);
        this.pathList = listOf;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(@NotNull List<String> pathList) {
        this();
        Intrinsics.checkNotNullParameter(pathList, "pathList");
        this.pathList = pathList;
    }
}
