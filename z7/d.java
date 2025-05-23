package z7;

import com.qzone.publish.business.protocol.QZoneUploadPicRequest;
import com.tencent.biz.richframework.publish.base.RFWPublishFile;
import com.tencent.biz.richframework.publish.base.RFWPublishModel;
import com.tencent.biz.richframework.publish.nt.model.media.NTPublishImage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.BatchUploadTask;
import com.tencent.qqnt.kernel.nativeinterface.FileClass;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.StorageNTSdkExtInfo$CommonExtensionInfo;
import qzone.StorageNTSdkExtInfo$PhotoApplyUploadReqExtInfo;
import qzone.StorageNTSdkExtInfo$PhotoDataUploadRspExtInfo;
import qzone.StoragePhotoSdkCommon$EnvInfo;
import qzone.StoragePhotoSdkCommon$ImgInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0019\u001a\u00020\b\u00a2\u0006\u0004\b\u001a\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0018\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lz7/d;", "Lcom/tencent/biz/richframework/publish/nt/model/media/NTPublishImage;", "", "genBizExtInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/BatchUploadTask;", "task", "", "d", "", "getLogTag", "", "Lqzone/StoragePhotoSdkCommon$ImgInfo;", "Ljava/util/List;", "b", "()Ljava/util/List;", "setImageInfos", "(Ljava/util/List;)V", "imageInfos", "e", "Ljava/lang/String;", "getClientKey", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "clientKey", "filePath", "<init>", "f", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public class d extends NTPublishImage {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private List<StoragePhotoSdkCommon$ImgInfo> imageInfos;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String clientKey;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String filePath) {
        super(filePath);
        Intrinsics.checkNotNullParameter(filePath, "filePath");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(BatchUploadTask task, d this$0) {
        Intrinsics.checkNotNullParameter(task, "$task");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            StorageNTSdkExtInfo$PhotoDataUploadRspExtInfo mergeFrom = new StorageNTSdkExtInfo$PhotoDataUploadRspExtInfo().mergeFrom(task.rspExtInfo);
            this$0.imageInfos = mergeFrom.img_infos.get();
            QLog.d(this$0.getLogTag(), 1, "taskDidFinishUpload type=image, taskId=" + task.taskId + ",imageInfo size=" + mergeFrom.img_infos.get().size());
        } catch (Exception e16) {
            QLog.d(this$0.getLogTag(), 1, "taskDidFinishUpload type=image, parse PhotoDataUploadRspExtInfo error\uff0ctaskId=" + task.taskId + ", exception:" + e16);
        }
        this$0.setState(RFWPublishFile.FileState.UPLOADED);
    }

    public final List<StoragePhotoSdkCommon$ImgInfo> b() {
        return this.imageInfos;
    }

    public final void c(String str) {
        this.clientKey = str;
    }

    @Override // com.tencent.biz.richframework.publish.base.RFWPublishFile
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void updateFileAfterUpload(final BatchUploadTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.fileInfo.fileType.getKlass() == FileClass.KFILECLASSPICTURE.ordinal()) {
            RFWThreadManager.getInstance().execOnAsyncDisplayThread(new Runnable() { // from class: z7.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.e(BatchUploadTask.this, this);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.publish.nt.model.media.NTPublishImage
    public byte[] genBizExtInfo() {
        RFWPublishModel<BatchUploadTask> model = getModel();
        y7.b bVar = model instanceof y7.b ? (y7.b) model : null;
        if (bVar == null) {
            return new byte[0];
        }
        StorageNTSdkExtInfo$PhotoApplyUploadReqExtInfo storageNTSdkExtInfo$PhotoApplyUploadReqExtInfo = new StorageNTSdkExtInfo$PhotoApplyUploadReqExtInfo();
        storageNTSdkExtInfo$PhotoApplyUploadReqExtInfo.batch_id.set(bVar.getBatchID());
        storageNTSdkExtInfo$PhotoApplyUploadReqExtInfo.album_type_id.set(bVar.getAlbumTypeID());
        storageNTSdkExtInfo$PhotoApplyUploadReqExtInfo.batch_upload_time.set(bVar.getUploadTime());
        storageNTSdkExtInfo$PhotoApplyUploadReqExtInfo.batch_upload_num.set(bVar.getFileList().size());
        storageNTSdkExtInfo$PhotoApplyUploadReqExtInfo.batch_cur_num.set(indexInPublishModel() > 0 ? indexInPublishModel() : 0);
        StoragePhotoSdkCommon$EnvInfo storagePhotoSdkCommon$EnvInfo = storageNTSdkExtInfo$PhotoApplyUploadReqExtInfo.env;
        w7.a aVar = w7.a.f444706a;
        storagePhotoSdkCommon$EnvInfo.set(aVar.b());
        storageNTSdkExtInfo$PhotoApplyUploadReqExtInfo.distinct_use.set(QZoneUploadPicRequest.SHUOSHUO_SRC);
        storageNTSdkExtInfo$PhotoApplyUploadReqExtInfo.exif_info.set(aVar.c(getFilePath()));
        if (this.clientKey != null) {
            StorageNTSdkExtInfo$CommonExtensionInfo storageNTSdkExtInfo$CommonExtensionInfo = storageNTSdkExtInfo$PhotoApplyUploadReqExtInfo.common_ext_info;
            StorageNTSdkExtInfo$CommonExtensionInfo storageNTSdkExtInfo$CommonExtensionInfo2 = new StorageNTSdkExtInfo$CommonExtensionInfo();
            storageNTSdkExtInfo$CommonExtensionInfo2.mobile_fakefeeds_clientkey.set(this.clientKey);
            storageNTSdkExtInfo$CommonExtensionInfo.set(storageNTSdkExtInfo$CommonExtensionInfo2);
        }
        byte[] byteArray = storageNTSdkExtInfo$PhotoApplyUploadReqExtInfo.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "photoExtendInfo.toByteArray()");
        return byteArray;
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWLog
    public String getLogTag() {
        return "QzoneFeedProPicCommentNTPublishImage";
    }
}
