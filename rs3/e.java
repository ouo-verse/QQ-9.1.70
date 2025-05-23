package rs3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.trpcprotocol.minibox.basicinfo.VMBasicInfo$GetGCRealAppInfoReq;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lrs3/e;", "Lrs3/a;", "", "getCmd", "Lcom/tencent/mobileqq/pb/MessageMicro;", "getRequestData", "a", "Ljava/lang/String;", "appId", "", "b", "I", "source", "<init>", "(Ljava/lang/String;I)V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class e implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String appId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int source;

    public e(@NotNull String appId, int i3) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        this.appId = appId;
        this.source = i3;
    }

    @Override // rs3.a
    @NotNull
    public String getCmd() {
        return "miniapp.trpc.minigame.virtualappbasicinfo.Virtualappbasicinfo.GetGCRealAppInfo";
    }

    @Override // rs3.a
    @NotNull
    public MessageMicro<?> getRequestData() {
        VMBasicInfo$GetGCRealAppInfoReq vMBasicInfo$GetGCRealAppInfoReq = new VMBasicInfo$GetGCRealAppInfoReq();
        vMBasicInfo$GetGCRealAppInfoReq.app_id.set(this.appId);
        vMBasicInfo$GetGCRealAppInfoReq.src.set(this.source);
        return vMBasicInfo$GetGCRealAppInfoReq;
    }

    public /* synthetic */ e(String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i16 & 2) != 0 ? 1 : i3);
    }
}
