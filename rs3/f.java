package rs3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.trpcprotocol.minibox.basicinfo.VMBasicInfo$GetVMAppInfoReq;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lrs3/f;", "Lrs3/a;", "", "getCmd", "Lcom/tencent/mobileqq/pb/MessageMicro;", "getRequestData", "a", "Ljava/lang/String;", "appId", "<init>", "(Ljava/lang/String;)V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class f implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String appId;

    public f(@NotNull String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        this.appId = appId;
    }

    @Override // rs3.a
    @NotNull
    public String getCmd() {
        return "miniapp.trpc.minigame.virtualappbasicinfo.Virtualappbasicinfo.GetVMAppInfo";
    }

    @Override // rs3.a
    @NotNull
    public MessageMicro<?> getRequestData() {
        VMBasicInfo$GetVMAppInfoReq vMBasicInfo$GetVMAppInfoReq = new VMBasicInfo$GetVMAppInfoReq();
        vMBasicInfo$GetVMAppInfoReq.app_id.set(this.appId);
        return vMBasicInfo$GetVMAppInfoReq;
    }
}
