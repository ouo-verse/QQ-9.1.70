package t14;

import com.tencent.qqnt.kernel.nativeinterface.RobotGuideInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00032\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u00a2\u0006\u0004\b\f\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lt14/f;", "Lt14/a;", "", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotGuideInfo;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotGuideInfo;", "c", "()Lcom/tencent/qqnt/kernel/nativeinterface/RobotGuideInfo;", "setAdelieGuideInfo", "(Lcom/tencent/qqnt/kernel/nativeinterface/RobotGuideInfo;)V", "adelieGuideInfo", "<init>", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class f extends a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RobotGuideInfo adelieGuideInfo;

    public f(@NotNull RobotGuideInfo adelieGuideInfo) {
        Intrinsics.checkNotNullParameter(adelieGuideInfo, "adelieGuideInfo");
        this.adelieGuideInfo = adelieGuideInfo;
    }

    @Override // t14.a
    public int b() {
        return 2;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final RobotGuideInfo getAdelieGuideInfo() {
        return this.adelieGuideInfo;
    }
}
