package tm3;

import com.tencent.now.linkpkanchorplay.event.UIEvent;
import e55.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import om3.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\r\u00a8\u0006\u0010"}, d2 = {"Ltm3/b;", "", "Lom3/e;", "linkMicStateMgr", "", "b", "Lcom/tencent/now/linkpkanchorplay/event/UIEvent$PKType;", "pkType", "c", "", "Le55/c;", "anchorInfo", "a", "Lom3/e;", "<init>", "()V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f436626a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static e linkMicStateMgr;

    b() {
    }

    public final void a(int pkType, @Nullable c anchorInfo) {
        e eVar = linkMicStateMgr;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linkMicStateMgr");
            eVar = null;
        }
        eVar.b(pkType, anchorInfo);
    }

    public final void b(@NotNull e linkMicStateMgr2) {
        Intrinsics.checkNotNullParameter(linkMicStateMgr2, "linkMicStateMgr");
        linkMicStateMgr = linkMicStateMgr2;
    }

    public final void c(@NotNull UIEvent.PKType pkType) {
        Intrinsics.checkNotNullParameter(pkType, "pkType");
        e eVar = linkMicStateMgr;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linkMicStateMgr");
            eVar = null;
        }
        eVar.a(pkType);
    }
}
