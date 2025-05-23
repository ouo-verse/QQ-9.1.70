package t7;

import com.tencent.biz.richframework.publish.nt.NTBatchUploadConstants$AppType;
import com.tencent.biz.richframework.publish.nt.NTBatchUploadService;
import com.tencent.biz.richframework.publish.nt.NTBatchUploader;
import com.tencent.qqnt.kernel.api.k;
import com.tencent.qqnt.kernel.nativeinterface.BatchUploadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lt7/i;", "Lcom/tencent/biz/richframework/publish/nt/NTBatchUploader;", "", "getLogTag", "toString", "uid", "Lcom/tencent/qqnt/kernel/nativeinterface/BatchUploadConfig;", "genBatchUploadConfig", "Lcom/tencent/biz/richframework/publish/nt/NTBatchUploadConstants$AppType;", "appType", "<init>", "(Lcom/tencent/biz/richframework/publish/nt/NTBatchUploadConstants$AppType;)V", "d", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: t7.i, reason: from toString */
/* loaded from: classes36.dex */
public final class QZNTArkUploader extends NTBatchUploader {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZNTArkUploader(NTBatchUploadConstants$AppType appType) {
        super(appType);
        Intrinsics.checkNotNullParameter(appType, "appType");
    }

    @Override // com.tencent.biz.richframework.publish.nt.NTBatchUploader
    public BatchUploadConfig genBatchUploadConfig(String uid) {
        BatchUploadConfig createBatchUploadConfig;
        Intrinsics.checkNotNullParameter(uid, "uid");
        k batchUploadService = NTBatchUploadService.getBatchUploadService();
        if (batchUploadService == null || (createBatchUploadConfig = batchUploadService.createBatchUploadConfig()) == null) {
            return null;
        }
        createBatchUploadConfig.bizConfig.appType = getNTUploaderAppType().ordinal();
        createBatchUploadConfig.bizConfig.c2cUserInfo.uid = uid;
        gd.a aVar = gd.a.f401926a;
        createBatchUploadConfig.isDisableBdhUpload = aVar.c("KEY_NT_UPLOAD_DISABLE_BDH", false);
        createBatchUploadConfig.isDisableQuicUpload = aVar.c("KEY_NT_UPLOAD_DISABLE_QUIC", false);
        return createBatchUploadConfig;
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWLog
    public String getLogTag() {
        return "QZNTArkUploader";
    }

    public String toString() {
        return "QZNTArkUploader(appType= " + getAppType().name() + ")";
    }
}
