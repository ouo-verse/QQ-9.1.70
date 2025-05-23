package yg0;

import com.tencent.ecommerce.base.ticket.api.IECPSKeyCallback;
import com.tencent.ecommerce.base.ticket.api.IECTicketManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ%\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ%\u0010\n\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\n\u0010\tJ\b\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lyg0/a;", "Lcom/tencent/ecommerce/base/ticket/api/IECTicketManager;", "", "", "domains", "Lcom/tencent/ecommerce/base/ticket/api/IECPSKeyCallback;", "callback", "", "getPsKeysAsync", "([Ljava/lang/String;Lcom/tencent/ecommerce/base/ticket/api/IECPSKeyCallback;)V", "getPsKeysAsyncNoCache", "", "getServerTimeMillis", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class a implements IECTicketManager {
    @Override // com.tencent.ecommerce.base.ticket.api.IECTicketManager
    public void getPsKeysAsync(@NotNull String[] domains, @NotNull IECPSKeyCallback callback) {
        throw new IllegalArgumentException("IECTicketManager getPsKeysAsync not yet implemented");
    }

    @Override // com.tencent.ecommerce.base.ticket.api.IECTicketManager
    public void getPsKeysAsyncNoCache(@NotNull String[] domains, @NotNull IECPSKeyCallback callback) {
        throw new IllegalArgumentException("IECTicketManager getPsKeysAsync not yet implemented");
    }

    @Override // com.tencent.ecommerce.base.ticket.api.IECTicketManager
    public long getServerTimeMillis() {
        return System.currentTimeMillis();
    }
}
