package tg0;

import com.tencent.ecommerce.base.router.api.IECScheme;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ(\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"Ltg0/a;", "Lcom/tencent/ecommerce/base/router/api/IECScheme;", "", "url", "", "userData", "", "handleWebScheme", "handleOtherScheme", "target", "data", "handleCommonPage", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class a implements IECScheme {
    @Override // com.tencent.ecommerce.base.router.api.IECScheme
    public int handleCommonPage(int target, @NotNull Map<String, String> data) {
        throw new IllegalArgumentException("IECScheme handleCommonPage not yet implemented");
    }

    @Override // com.tencent.ecommerce.base.router.api.IECScheme
    public int handleOtherScheme(@Nullable String url) {
        throw new IllegalArgumentException("IECScheme handleOtherScheme not yet implemented");
    }

    @Override // com.tencent.ecommerce.base.router.api.IECScheme
    public int handleWebScheme(@Nullable String url, @Nullable Map<String, String> userData) {
        throw new IllegalArgumentException("IECScheme handleWebScheme not yet implemented");
    }
}
