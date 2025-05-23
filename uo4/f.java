package uo4;

import com.tencent.qqnt.kernel.nativeinterface.UnreadCntInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\b\u00a8\u0006\f"}, d2 = {"Luo4/f;", "", "", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/UnreadCntInfo;", "a", "Z", "hasLoad", "Lcom/tencent/qqnt/kernel/nativeinterface/UnreadCntInfo;", "unreadCntInfo", "<init>", "(ZLcom/tencent/qqnt/kernel/nativeinterface/UnreadCntInfo;)V", "troop-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean hasLoad;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final UnreadCntInfo unreadCntInfo;

    public f(boolean z16, @NotNull UnreadCntInfo unreadCntInfo) {
        Intrinsics.checkNotNullParameter(unreadCntInfo, "unreadCntInfo");
        this.hasLoad = z16;
        this.unreadCntInfo = unreadCntInfo;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final UnreadCntInfo getUnreadCntInfo() {
        return this.unreadCntInfo;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getHasLoad() {
        return this.hasLoad;
    }
}
