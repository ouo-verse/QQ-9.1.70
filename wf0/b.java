package wf0;

import com.tencent.ecommerce.base.account.api.IECAccountManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lwf0/b;", "Lcom/tencent/ecommerce/base/account/api/IECAccountManager;", "", "getCurrentAccount", "", "getCurrentAccountNickName", "getCurrentAccountHeadUrl", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class b implements IECAccountManager {
    @Override // com.tencent.ecommerce.base.account.api.IECAccountManager
    public long getCurrentAccount() {
        throw new IllegalArgumentException("IECAccountManager getCurrentAccount not yet implemented");
    }

    @Override // com.tencent.ecommerce.base.account.api.IECAccountManager
    @NotNull
    public String getCurrentAccountHeadUrl() {
        throw new IllegalArgumentException("IECAccountManager getCurrentAccountHeadUrl not yet implemented");
    }

    @Override // com.tencent.ecommerce.base.account.api.IECAccountManager
    @NotNull
    public String getCurrentAccountNickName() {
        throw new IllegalArgumentException("IECAccountManager getCurrentAccountNickName not yet implemented");
    }
}
