package rs3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qq.minibox.exception.MiniBoxExceptionDetail;
import com.tencent.trpcprotocol.minibox.va_stop_bleeding.VaStopBleeding.VaStopBleedingPB$CrashReportReq;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lrs3/j;", "Lrs3/a;", "", "getCmd", "Lcom/tencent/mobileqq/pb/MessageMicro;", "getRequestData", "Lcom/tencent/qq/minibox/exception/MiniBoxExceptionDetail;", "a", "Lcom/tencent/qq/minibox/exception/MiniBoxExceptionDetail;", "crashDetail", "<init>", "(Lcom/tencent/qq/minibox/exception/MiniBoxExceptionDetail;)V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class j implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MiniBoxExceptionDetail crashDetail;

    public j(@NotNull MiniBoxExceptionDetail crashDetail) {
        Intrinsics.checkNotNullParameter(crashDetail, "crashDetail");
        this.crashDetail = crashDetail;
    }

    @Override // rs3.a
    @NotNull
    public String getCmd() {
        return "miniapp.trpc.minigame.va_stop_bleeding.VaStopBleeding.CrashReport";
    }

    @Override // rs3.a
    @NotNull
    public MessageMicro<?> getRequestData() {
        VaStopBleedingPB$CrashReportReq vaStopBleedingPB$CrashReportReq = new VaStopBleedingPB$CrashReportReq();
        vaStopBleedingPB$CrashReportReq.crash_time.set(this.crashDetail.getCrashTime());
        PBStringField pBStringField = vaStopBleedingPB$CrashReportReq.process_name;
        String processName = this.crashDetail.getProcessName();
        String str = "";
        if (processName == null) {
            processName = "";
        }
        pBStringField.set(processName);
        vaStopBleedingPB$CrashReportReq.is_native_crashed.set(this.crashDetail.isNativeCrashed());
        PBStringField pBStringField2 = vaStopBleedingPB$CrashReportReq.crash_type;
        String crashType = this.crashDetail.getCrashType();
        if (crashType == null) {
            crashType = "";
        }
        pBStringField2.set(crashType);
        PBStringField pBStringField3 = vaStopBleedingPB$CrashReportReq.crash_address;
        String crashAddress = this.crashDetail.getCrashAddress();
        if (crashAddress == null) {
            crashAddress = "";
        }
        pBStringField3.set(crashAddress);
        PBStringField pBStringField4 = vaStopBleedingPB$CrashReportReq.crash_stack;
        String sliceCrashStack = this.crashDetail.getSliceCrashStack();
        if (sliceCrashStack == null) {
            sliceCrashStack = "";
        }
        pBStringField4.set(sliceCrashStack);
        PBStringField pBStringField5 = vaStopBleedingPB$CrashReportReq.minibox_version;
        String dexVersion = this.crashDetail.getDexVersion();
        if (dexVersion == null) {
            dexVersion = "";
        }
        pBStringField5.set(dexVersion);
        PBStringField pBStringField6 = vaStopBleedingPB$CrashReportReq.appid;
        String appId = this.crashDetail.getAppId();
        if (appId == null) {
            appId = "";
        }
        pBStringField6.set(appId);
        PBStringField pBStringField7 = vaStopBleedingPB$CrashReportReq.game_version;
        String gameVersion = this.crashDetail.getGameVersion();
        if (gameVersion != null) {
            str = gameVersion;
        }
        pBStringField7.set(str);
        vaStopBleedingPB$CrashReportReq.start_time.set(this.crashDetail.getLaunchTime());
        return vaStopBleedingPB$CrashReportReq;
    }
}
