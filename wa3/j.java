package wa3;

import FileUpload.MultiPicInfo;
import FileUpload.PicExtendInfo;
import FileUpload.UploadPicInfoReq;
import com.qq.jce.wup.UniPacket;
import com.qzone.publish.business.model.UploadVideoObject;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkpublish.config.l;
import com.tencent.mobileqq.winkpublish.model.params.VideoParams;
import com.tencent.mobileqq.winkpublish.outbox.task.TaskContext;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.data.VideoExportingUploadTask;
import com.tencent.upload.uinterface.data.VideoUploadTask;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\"\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u0001H\u0002J(\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H&J(\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H&J8\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0004\u00a8\u0006\u001e"}, d2 = {"Lwa3/j;", "", "Lcom/tencent/upload/uinterface/data/VideoUploadTask;", "videoUploadTask", "", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "", "d", "", "clientKey", "path", "uploadTaskType", "g", "Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "taskContext", "Lcom/tencent/mobileqq/winkpublish/model/params/VideoParams;", "videoParams", "indexInMediaList", "", "a", "inst", "f", "Lcom/tencent/upload/uinterface/IUploadTaskCallback;", "callback", "b", "Lcom/tencent/upload/uinterface/data/VideoExportingUploadTask;", "c", "e", "<init>", "()V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lwa3/j$a;", "", "Lcom/tencent/mobileqq/winkpublish/config/l;", DownloadInfo.spKey_Config, "Lwa3/j;", "a", "", "EXTEND_KEY_TRACE_ID", "Ljava/lang/String;", "EXTEND_VIDEO_TYPE_ALBUM", "EXTEND_VIDEO_TYPE_RECORD", "TAG", "<init>", "()V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: wa3.j$a, reason: from kotlin metadata */
    /* loaded from: classes36.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final j a(l config) {
            Intrinsics.checkNotNullParameter(config, "config");
            int businessType = config.getBusinessType();
            if (businessType == 1) {
                return g.f445343b;
            }
            if (businessType == 2) {
                return c.f445339b;
            }
            throw new IllegalStateException("no support UploadLocalConfig");
        }

        Companion() {
        }
    }

    private final byte[] a(TaskContext taskContext, VideoParams videoParams, int indexInMediaList) {
        UploadPicInfoReq uploadPicInfoReq = new UploadPicInfoReq();
        uploadPicInfoReq.iBatchID = taskContext.getBatchId();
        MultiPicInfo multiPicInfo = new MultiPicInfo();
        multiPicInfo.iBatUploadNum = taskContext.u();
        multiPicInfo.iCurUpload = indexInMediaList;
        uploadPicInfoReq.mutliPicInfo = multiPicInfo;
        PicExtendInfo picExtendInfo = new PicExtendInfo();
        uploadPicInfoReq.stExtendInfo = picExtendInfo;
        picExtendInfo.mapParams = new HashMap();
        uploadPicInfoReq.stExternalMapExt = new HashMap();
        uploadPicInfoReq.mapExt = new HashMap();
        if (taskContext.z()) {
            Map<String, String> map = uploadPicInfoReq.stExternalMapExt;
            Intrinsics.checkNotNullExpressionValue(map, "req.stExternalMapExt");
            map.put(FSUploadConst.KEY_CLIENT_UPLOOAD_COVER, "1");
            Map<String, String> map2 = uploadPicInfoReq.stExternalMapExt;
            Intrinsics.checkNotNullExpressionValue(map2, "req.stExternalMapExt");
            map2.put(FSUploadConst.KEY_MIX_FEED, "1");
        }
        Map<String, String> map3 = uploadPicInfoReq.stExternalMapExt;
        Intrinsics.checkNotNullExpressionValue(map3, "req.stExternalMapExt");
        map3.put(FSUploadConst.KEY_MIX_VIDEO_SIZE, String.valueOf(videoParams.getFileSize()));
        Map<String, String> map4 = uploadPicInfoReq.stExternalMapExt;
        Intrinsics.checkNotNullExpressionValue(map4, "req.stExternalMapExt");
        map4.put(FSUploadConst.KEY_MIX_ORIGIN_VIDEO, "1");
        Map<String, String> map5 = uploadPicInfoReq.stExternalMapExt;
        Intrinsics.checkNotNullExpressionValue(map5, "req.stExternalMapExt");
        map5.put(FSUploadConst.KEY_MIX_TIME, String.valueOf(videoParams.getDuration()));
        uploadPicInfoReq.iUploadTime = taskContext.getCom.qzone.album.data.model.PhotoCategorySinglePicInfo.UPLOAD_TIME java.lang.String();
        Map<String, String> mapExt = uploadPicInfoReq.mapExt;
        Intrinsics.checkNotNullExpressionValue(mapExt, "mapExt");
        mapExt.put(FSUploadConst.KEY_FAKEFEED_CLIENTKEY, taskContext.getPublishParams().getClientKey());
        Map<String, String> mapExt2 = uploadPicInfoReq.mapExt;
        Intrinsics.checkNotNullExpressionValue(mapExt2, "mapExt");
        mapExt2.put("refer", "");
        uploadPicInfoReq.iBusiNessType = taskContext.getUploadBusinessType();
        uploadPicInfoReq.vBusiNessData = new byte[0];
        return f(uploadPicInfoReq);
    }

    private final void d(VideoUploadTask videoUploadTask, int entrance) {
        int i3 = videoUploadTask.uploadEntrance;
        if (i3 != 19) {
            if (i3 != 45 && i3 != 207) {
                switch (i3) {
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        break;
                    default:
                        switch (i3) {
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                                break;
                            default:
                                return;
                        }
                }
            }
            videoUploadTask.entry = AbstractUploadTask.ENTRY_TYPE_SHUOSHUO;
            return;
        }
        videoUploadTask.entry = "album";
    }

    private final byte[] f(Object inst) {
        try {
            UniPacket uniPacket = new UniPacket();
            uniPacket.setEncodeName("UTF-8");
            uniPacket.setRequestId(0);
            uniPacket.setFuncName("FuncName");
            uniPacket.setServantName("ServantName");
            uniPacket.put("UploadPicInfoReq", inst);
            byte[] encode = uniPacket.encode();
            uniPacket.clearCacheData();
            return encode;
        } catch (Exception e16) {
            QLog.w("WinkPublish-upload2-VideoUploadTaskFactory", 1, "[pack]", e16);
            return null;
        }
    }

    public abstract VideoUploadTask b(TaskContext taskContext, VideoParams videoParams, int indexInMediaList, IUploadTaskCallback callback);

    public abstract VideoExportingUploadTask c(TaskContext taskContext, VideoParams videoParams, int indexInMediaList, IUploadTaskCallback callback);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e(VideoUploadTask videoUploadTask, TaskContext taskContext, VideoParams videoParams, int indexInMediaList, int uploadTaskType, IUploadTaskCallback callback) {
        Intrinsics.checkNotNullParameter(videoUploadTask, "videoUploadTask");
        Intrinsics.checkNotNullParameter(taskContext, "taskContext");
        Intrinsics.checkNotNullParameter(videoParams, "videoParams");
        Intrinsics.checkNotNullParameter(callback, "callback");
        videoUploadTask.iIsNew = 113;
        int g16 = g(taskContext.getPublishParams().getClientKey(), videoParams.getLocalPath(), uploadTaskType);
        videoUploadTask.flowId = g16;
        QLog.i("WinkPublish-upload2-VideoUploadTaskFactory", 1, "[fillVideoUploadTask] flowId=" + g16 + " , task id=" + taskContext.getId());
        videoUploadTask.iUin = ua3.a.d().f();
        videoUploadTask.sRefer = "mqq";
        videoUploadTask.vLoginData = ua3.a.d().b(true);
        videoUploadTask.sCoverUrl = null;
        videoUploadTask.iUploadTime = taskContext.getCom.qzone.album.data.model.PhotoCategorySinglePicInfo.UPLOAD_TIME java.lang.String() - ((long) indexInMediaList);
        videoUploadTask.iBusiNessType = taskContext.getUploadBusinessType();
        videoUploadTask.vBusiNessData = a(taskContext, videoParams, indexInMediaList);
        videoUploadTask.uploadEntrance = taskContext.getPublishParams().getUploadEntrance();
        videoUploadTask.uploadTaskCallback = callback;
        videoUploadTask.iPlayTime = (int) videoParams.getDuration();
        videoUploadTask.iIsOriginalVideo = 1;
        videoUploadTask.iIsFormatF20 = 0;
        HashMap extend_info = new HashMap();
        videoUploadTask.extend_info = extend_info;
        Intrinsics.checkNotNullExpressionValue(extend_info, "extend_info");
        extend_info.put("video_type", "3");
        if (videoParams.isHEVC()) {
            Map<String, String> extend_info2 = videoUploadTask.extend_info;
            Intrinsics.checkNotNullExpressionValue(extend_info2, "extend_info");
            extend_info2.put(FSUploadConst.KEY_VIDEO_FORMAT, UploadVideoObject.VODEO_FORMAT_H265);
        } else {
            Map<String, String> extend_info3 = videoUploadTask.extend_info;
            Intrinsics.checkNotNullExpressionValue(extend_info3, "extend_info");
            extend_info3.put(FSUploadConst.KEY_VIDEO_FORMAT, "h264");
        }
        if (videoParams.isHDR()) {
            Map<String, String> extend_info4 = videoUploadTask.extend_info;
            Intrinsics.checkNotNullExpressionValue(extend_info4, "extend_info");
            extend_info4.put(FSUploadConst.KEY_VIDEO_IS_HDR, "1");
        } else {
            Map<String, String> extend_info5 = videoUploadTask.extend_info;
            Intrinsics.checkNotNullExpressionValue(extend_info5, "extend_info");
            extend_info5.put(FSUploadConst.KEY_VIDEO_IS_HDR, "0");
        }
        HashMap mExtend_info = new HashMap();
        videoUploadTask.mExtend_info = mExtend_info;
        Intrinsics.checkNotNullExpressionValue(mExtend_info, "mExtend_info");
        mExtend_info.put("trace_id", taskContext.getPublishParams().getClientKey());
        d(videoUploadTask, taskContext.getPublishParams().getUploadEntrance());
        videoUploadTask.keepTmpFile(true);
    }

    private final int g(String clientKey, String path, int uploadTaskType) {
        if (path == null) {
            path = "";
        }
        return ((path + clientKey) + uploadTaskType).hashCode();
    }
}
