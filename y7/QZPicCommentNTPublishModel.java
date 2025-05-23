package y7;

import com.qzone.common.business.service.QZoneWriteOperationService;
import com.tencent.biz.richframework.publish.base.RFWPublishFile;
import com.tencent.biz.richframework.publish.nt.model.NTPublishModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0014\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016J\u0014\u0010\t\u001a\u00020\u00072\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016J\u0014\u0010\n\u001a\u00020\u00072\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016J\u0014\u0010\u000b\u001a\u00020\u00072\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016J\u0014\u0010\f\u001a\u00020\u00072\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016J\u0014\u0010\r\u001a\u00020\u00072\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016R\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001c\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u000f\u0010\u001b\u00a8\u0006!"}, d2 = {"Ly7/a;", "Lcom/tencent/biz/richframework/publish/nt/model/NTPublishModel;", "", "getLogTag", "toString", "Lcom/tencent/biz/richframework/publish/base/RFWPublishFile;", "file", "", "onFileProcessing", "onFileUploading", "onFileUploaded", "onFileCancel", "onFileError", "onFileReadyToUpload", "", "d", "I", "b", "()I", "setAlbumTypeID", "(I)V", "albumTypeID", "Lcom/qzone/common/business/service/QZoneWriteOperationService$l;", "e", "Lcom/qzone/common/business/service/QZoneWriteOperationService$l;", "c", "()Lcom/qzone/common/business/service/QZoneWriteOperationService$l;", "(Lcom/qzone/common/business/service/QZoneWriteOperationService$l;)V", "params", "<init>", "()V", "f", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: y7.a, reason: from toString */
/* loaded from: classes36.dex */
public final class QZPicCommentNTPublishModel extends NTPublishModel {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int albumTypeID = 7;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QZoneWriteOperationService.l params;

    /* renamed from: b, reason: from getter */
    public final int getAlbumTypeID() {
        return this.albumTypeID;
    }

    /* renamed from: c, reason: from getter */
    public final QZoneWriteOperationService.l getParams() {
        return this.params;
    }

    public final void d(QZoneWriteOperationService.l lVar) {
        this.params = lVar;
    }

    @Override // com.tencent.biz.richframework.publish.nt.model.NTPublishModel, com.tencent.biz.richframework.publish.base.interfaces.IRFWLog
    public String getLogTag() {
        return "QZPicCommentNTPublishModel";
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWPublishFileObserver
    public void onFileCancel(RFWPublishFile<?> file) {
        Intrinsics.checkNotNullParameter(file, "file");
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWPublishFileObserver
    public void onFileError(RFWPublishFile<?> file) {
        Intrinsics.checkNotNullParameter(file, "file");
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWPublishFileObserver
    public void onFileProcessing(RFWPublishFile<?> file) {
        Intrinsics.checkNotNullParameter(file, "file");
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWPublishFileObserver
    public void onFileReadyToUpload(RFWPublishFile<?> file) {
        Intrinsics.checkNotNullParameter(file, "file");
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWPublishFileObserver
    public void onFileUploaded(RFWPublishFile<?> file) {
        Intrinsics.checkNotNullParameter(file, "file");
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWPublishFileObserver
    public void onFileUploading(RFWPublishFile<?> file) {
        Intrinsics.checkNotNullParameter(file, "file");
    }

    @Override // com.tencent.biz.richframework.publish.nt.model.NTPublishModel
    public String toString() {
        return "QZPicCommentNTPublishModel(albumTypeID=" + this.albumTypeID + ", " + super.toString() + ")";
    }
}
