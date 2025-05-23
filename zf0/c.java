package zf0;

import com.tencent.ecommerce.base.imageloader.api.IECPagSoLoader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\u0007\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016\u00a8\u0006\u000b"}, d2 = {"Lzf0/c;", "Lcom/tencent/ecommerce/base/imageloader/api/IECPagSoLoader;", "", "loadPagSo", "Lkotlin/Function1;", "", "resultBlock", "loadPagSoAsync", "downloadPagSo", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class c implements IECPagSoLoader {
    @Override // com.tencent.ecommerce.base.imageloader.api.IECPagSoLoader
    public boolean loadPagSo() {
        return false;
    }

    @Override // com.tencent.ecommerce.base.imageloader.api.IECPagSoLoader
    public void loadPagSoAsync(@NotNull Function1<? super Boolean, Unit> resultBlock) {
        resultBlock.invoke(Boolean.FALSE);
    }

    @Override // com.tencent.ecommerce.base.imageloader.api.IECPagSoLoader
    public void downloadPagSo() {
    }
}
