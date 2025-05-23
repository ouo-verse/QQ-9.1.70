package rs3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.trpcprotocol.minibox.va_stop_bleeding.VaStopBleeding.VaStopBleedingPB$CommonReportReq;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lrs3/i;", "Lrs3/a;", "", "getCmd", "Lcom/tencent/mobileqq/pb/MessageMicro;", "getRequestData", "Lus3/a;", "a", "Lus3/a;", "reportDetail", "<init>", "(Lus3/a;)V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class i implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final us3.a reportDetail;

    public i(@NotNull us3.a reportDetail) {
        Intrinsics.checkNotNullParameter(reportDetail, "reportDetail");
        this.reportDetail = reportDetail;
    }

    @Override // rs3.a
    @NotNull
    public String getCmd() {
        return "miniapp.trpc.minigame.va_stop_bleeding.VaStopBleeding.CommonReport";
    }

    @Override // rs3.a
    @NotNull
    public MessageMicro<?> getRequestData() {
        VaStopBleedingPB$CommonReportReq vaStopBleedingPB$CommonReportReq = new VaStopBleedingPB$CommonReportReq();
        vaStopBleedingPB$CommonReportReq.appid.set(this.reportDetail.f439975a);
        vaStopBleedingPB$CommonReportReq.app_version.set(this.reportDetail.f439976b);
        vaStopBleedingPB$CommonReportReq.app_new_version.set(this.reportDetail.f439977c);
        vaStopBleedingPB$CommonReportReq.event_name.set(this.reportDetail.f439978d);
        vaStopBleedingPB$CommonReportReq.event_data.set(this.reportDetail.f439979e);
        return vaStopBleedingPB$CommonReportReq;
    }
}
