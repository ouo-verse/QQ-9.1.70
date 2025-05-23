package rs3;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.utils.ah;
import com.tencent.trpcprotocol.minibox.basicinfo.VMBasicInfo$IsVMAppBlockedReq;
import com.tencent.trpcprotocol.minibox.basicinfo.VMBasicInfo$VMAppLaunchContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007\u00a8\u0006\r"}, d2 = {"Lrs3/h;", "Lrs3/a;", "", "getCmd", "Lcom/tencent/mobileqq/pb/MessageMicro;", "getRequestData", "a", "Ljava/lang/String;", "appId", "b", "appVersion", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class h implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String appId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String appVersion;

    public h(@NotNull String appId, @NotNull String appVersion) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        this.appId = appId;
        this.appVersion = appVersion;
    }

    @Override // rs3.a
    @NotNull
    public String getCmd() {
        return "miniapp.trpc.minigame.virtualappbasicinfo.Virtualappbasicinfo.IsVMAppBlocked";
    }

    @Override // rs3.a
    @NotNull
    public MessageMicro<?> getRequestData() {
        VMBasicInfo$VMAppLaunchContext vMBasicInfo$VMAppLaunchContext = new VMBasicInfo$VMAppLaunchContext();
        vMBasicInfo$VMAppLaunchContext.app_id.set(this.appId);
        vMBasicInfo$VMAppLaunchContext.app_version.set(this.appVersion);
        vMBasicInfo$VMAppLaunchContext.device.set(ah.F());
        vMBasicInfo$VMAppLaunchContext.mobileqq_version.set(AppSetting.f99551k);
        vMBasicInfo$VMAppLaunchContext.system_version.set(ah.t());
        VMBasicInfo$IsVMAppBlockedReq vMBasicInfo$IsVMAppBlockedReq = new VMBasicInfo$IsVMAppBlockedReq();
        vMBasicInfo$IsVMAppBlockedReq.app_context.set(vMBasicInfo$VMAppLaunchContext);
        return vMBasicInfo$IsVMAppBlockedReq;
    }
}
