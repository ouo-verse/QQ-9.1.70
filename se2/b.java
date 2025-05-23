package se2;

import com.tencent.ecommerce.base.network.api.IECHttpDownloader;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ,\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"Lse2/b;", "Lcom/tencent/ecommerce/base/network/api/IECHttpDownloader;", "", "src", "Ljava/io/File;", "file", "Lkotlin/Function1;", "", "", "resultBlock", "downloadFileAsync", "downloadFileSync", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b implements IECHttpDownloader {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function1 resultBlock, b this$0, String src, File file) {
        Intrinsics.checkNotNullParameter(resultBlock, "$resultBlock");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(src, "$src");
        Intrinsics.checkNotNullParameter(file, "$file");
        resultBlock.invoke(Boolean.valueOf(this$0.downloadFileSync(src, file)));
    }

    @Override // com.tencent.ecommerce.base.network.api.IECHttpDownloader
    public void downloadFileAsync(final String src, final File file, final Function1<? super Boolean, Unit> resultBlock) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(resultBlock, "resultBlock");
        ThreadManagerV2.excute(new Runnable() { // from class: se2.a
            @Override // java.lang.Runnable
            public final void run() {
                b.b(Function1.this, this, src, file);
            }
        }, 128, null, true);
    }

    @Override // com.tencent.ecommerce.base.network.api.IECHttpDownloader
    public boolean downloadFileSync(String src, File file) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(file, "file");
        return HttpDownloadUtil.download((AppRuntime) null, src, file);
    }
}
