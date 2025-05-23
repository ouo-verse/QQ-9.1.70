package t7;

import com.tencent.biz.richframework.publish.base.RFWPublishFile;
import com.tencent.biz.richframework.publish.base.interfaces.IRFWPublishModelObserver;
import com.tencent.biz.richframework.publish.nt.NTBatchPublisher;
import com.tencent.biz.richframework.publish.nt.NTBatchUploader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.InnerWebView;
import com.tencent.qqnt.kernel.nativeinterface.BatchUploadTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import u7.QZIntimatePublishModel;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lt7/e;", "Lcom/tencent/biz/richframework/publish/nt/NTBatchPublisher;", "Lt7/b;", "initBuilder", "", "a", "", "filePath", "", "param", InnerWebView.API_UPLOAD_IMAGE, "getLogTag", "toString", "d", "Lt7/b;", "builder", "Lcom/tencent/biz/richframework/publish/nt/NTBatchUploader;", "uploader", "<init>", "(Lcom/tencent/biz/richframework/publish/nt/NTBatchUploader;)V", "e", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e extends NTBatchPublisher {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private t7.b builder;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"t7/e$b", "Lcom/tencent/biz/richframework/publish/base/interfaces/IRFWPublishModelObserver;", "Lcom/tencent/biz/richframework/publish/base/RFWPublishFile;", "file", "", "onTaskReadyToUpload", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b implements IRFWPublishModelObserver {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QZIntimatePublishModel f435513b;

        b(QZIntimatePublishModel qZIntimatePublishModel) {
            this.f435513b = qZIntimatePublishModel;
        }

        @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWPublishModelObserver
        public void onTaskReadyToUpload(RFWPublishFile<?> file) {
            Intrinsics.checkNotNullParameter(file, "file");
            if (file instanceof v7.a) {
                BatchUploadTask genUploadTask = ((v7.a) file).genUploadTask();
                genUploadTask.isReadyUpload = true;
                e.this.getUploader().updateTask(genUploadTask);
            } else {
                QLog.e(this.f435513b.getLogTag(), 1, "uploadImage onTaskReadyToUpload error,file type mismatch!file=" + file.getClass().getCanonicalName());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(NTBatchUploader uploader) {
        super(uploader);
        Intrinsics.checkNotNullParameter(uploader, "uploader");
    }

    public final void a(t7.b initBuilder) {
        Intrinsics.checkNotNullParameter(initBuilder, "initBuilder");
        this.builder = initBuilder;
        getUploader().setup(initBuilder.getUid(), this);
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWLog
    public String getLogTag() {
        return "QZNTArkUploadPublisher";
    }

    public String toString() {
        return "QZNTArkUploadPublisher";
    }

    @Override // com.tencent.biz.richframework.publish.nt.NTBatchPublisher
    public void uploadImage(String filePath, Object param) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        QZIntimatePublishModel qZIntimatePublishModel = new QZIntimatePublishModel();
        qZIntimatePublishModel.setUploadTime(System.currentTimeMillis());
        qZIntimatePublishModel.setObserver(new b(qZIntimatePublishModel));
        createMission(qZIntimatePublishModel);
        qZIntimatePublishModel.addPublishFile(new v7.a(filePath));
        startUpload(qZIntimatePublishModel.getPublishID());
    }
}
