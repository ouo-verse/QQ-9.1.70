package zd4;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\nR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lzd4/f;", "", "Lzd4/b;", "iRenderChainManager", "", "b", "Lfe4/a;", "effectNode", "a", "", "Ljava/util/List;", "exceptedAddRenderNodes", "Lzd4/b;", "<init>", "()V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<fe4.a> exceptedAddRenderNodes = new ArrayList();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private b iRenderChainManager;

    public final void a(@NotNull fe4.a effectNode) {
        Intrinsics.checkParameterIsNotNull(effectNode, "effectNode");
        b bVar = this.iRenderChainManager;
        if (bVar != null) {
            bVar.d(effectNode);
        }
        synchronized (this.exceptedAddRenderNodes) {
            this.exceptedAddRenderNodes.add(effectNode);
        }
    }

    public final void b(@NotNull b iRenderChainManager) {
        Intrinsics.checkParameterIsNotNull(iRenderChainManager, "iRenderChainManager");
        this.iRenderChainManager = iRenderChainManager;
        synchronized (this.exceptedAddRenderNodes) {
            if (!this.exceptedAddRenderNodes.isEmpty()) {
                for (fe4.a aVar : this.exceptedAddRenderNodes) {
                    b bVar = this.iRenderChainManager;
                    if (bVar != null) {
                        bVar.d(aVar);
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
