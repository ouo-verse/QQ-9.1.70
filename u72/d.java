package u72;

import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$SignalInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$SignalInfo;", "Lu72/c;", "a", "matchfriend_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d {
    public static final SignalEntryInfo a(SignalPlazaSvrPB$SignalInfo signalPlazaSvrPB$SignalInfo) {
        Intrinsics.checkNotNullParameter(signalPlazaSvrPB$SignalInfo, "<this>");
        long j3 = signalPlazaSvrPB$SignalInfo.signal_meta.partner_id.get();
        String str = signalPlazaSvrPB$SignalInfo.signal_meta.partner_name.get();
        Intrinsics.checkNotNullExpressionValue(str, "this.signal_meta.partner_name.get()");
        return new SignalEntryInfo(j3, str, signalPlazaSvrPB$SignalInfo.signal_meta.ttl.get(), false, 8, null);
    }
}
