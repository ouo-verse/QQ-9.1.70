package x7;

import com.tencent.biz.richframework.publish.base.RFWPublishFile;
import com.tencent.biz.richframework.publish.base.interfaces.IRFWPublishModelObserver;
import com.tencent.biz.richframework.publish.nt.NTBatchPublisher;
import com.tencent.biz.richframework.publish.nt.NTBatchUploader;
import com.tencent.biz.richframework.publish.nt.model.media.NTPublishFile;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.InnerWebView;
import com.tencent.qqnt.kernel.nativeinterface.BatchUploadTask;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import x7.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\u000b\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016\u00a8\u0006\u0015"}, d2 = {"Lx7/i;", "Lcom/tencent/biz/richframework/publish/nt/NTBatchPublisher;", "", "uid", "", "a", "", "Lcom/tencent/biz/richframework/publish/nt/model/media/NTPublishFile;", "list", "", "param", "b", "filePath", InnerWebView.API_UPLOAD_IMAGE, "getLogTag", "toString", "Lcom/tencent/biz/richframework/publish/nt/NTBatchUploader;", "uploader", "<init>", "(Lcom/tencent/biz/richframework/publish/nt/NTBatchUploader;)V", "d", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class i extends NTBatchPublisher {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"x7/i$b", "Lcom/tencent/biz/richframework/publish/base/interfaces/IRFWPublishModelObserver;", "Lcom/tencent/biz/richframework/publish/base/RFWPublishFile;", "file", "", "onTaskReadyToUpload", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b implements IRFWPublishModelObserver {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ y7.b f447387b;

        b(y7.b bVar) {
            this.f447387b = bVar;
        }

        @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWPublishModelObserver
        public void onTaskReadyToUpload(RFWPublishFile<?> file) {
            Intrinsics.checkNotNullParameter(file, "file");
            if (file instanceof z7.d) {
                BatchUploadTask genUploadTask = ((z7.d) file).genUploadTask();
                genUploadTask.isReadyUpload = true;
                i.this.getUploader().updateTask(genUploadTask);
            } else {
                QLog.e(this.f447387b.getLogTag(), 1, "uploadImage onTaskReadyToUpload error,file type mismatch!file=" + file.getClass().getCanonicalName());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"x7/i$c", "Lcom/tencent/biz/richframework/publish/base/interfaces/IRFWPublishModelObserver;", "Lcom/tencent/biz/richframework/publish/base/RFWPublishFile;", "file", "", "onTaskReadyToUpload", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class c implements IRFWPublishModelObserver {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ y7.b f447389b;

        c(y7.b bVar) {
            this.f447389b = bVar;
        }

        @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWPublishModelObserver
        public void onTaskReadyToUpload(RFWPublishFile<?> file) {
            Intrinsics.checkNotNullParameter(file, "file");
            if (file instanceof z7.d) {
                BatchUploadTask genUploadTask = ((z7.d) file).genUploadTask();
                genUploadTask.isReadyUpload = true;
                i.this.getUploader().updateTask(genUploadTask);
            } else {
                QLog.e(this.f447389b.getLogTag(), 1, "uploadImage onTaskReadyToUpload error,file type mismatch!file=" + file.getClass().getCanonicalName());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(NTBatchUploader uploader) {
        super(uploader);
        Intrinsics.checkNotNullParameter(uploader, "uploader");
    }

    public final void a(String uid) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        getUploader().setup(uid, this);
    }

    public void b(List<? extends NTPublishFile> list, Object param) {
        Intrinsics.checkNotNullParameter(list, "list");
        y7.b bVar = new y7.b();
        bVar.setUploadTime(System.currentTimeMillis());
        if (param instanceof h.b) {
            bVar.d((h.b) param);
        }
        bVar.setObserver(new c(bVar));
        createMission(bVar);
        Iterator<? extends NTPublishFile> it = list.iterator();
        while (it.hasNext()) {
            bVar.addPublishFile(it.next());
        }
        startUpload(bVar.getPublishID());
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWLog
    public String getLogTag() {
        return "QzoneFeedProPicCommentNTPublisher";
    }

    public String toString() {
        return "QzoneFeedProPicCommentNTPublisher";
    }

    @Override // com.tencent.biz.richframework.publish.nt.NTBatchPublisher
    public void uploadImage(String filePath, Object param) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        y7.b bVar = new y7.b();
        bVar.setUploadTime(System.currentTimeMillis());
        bVar.setObserver(new b(bVar));
        createMission(bVar);
        bVar.addPublishFile(new z7.d(filePath));
        startUpload(bVar.getPublishID());
    }
}
