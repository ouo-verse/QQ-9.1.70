package wa3;

import FileUpload.MultiPicInfo;
import FileUpload.PicExtendInfo;
import FileUpload.cnst.kExtKeyMarkUinBeforeUpload;
import NS_MOBILE_OPERATION.LbsInfo;
import com.qzone.publish.business.protocol.QZoneUploadPicRequest;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.winkpublish.config.l;
import com.tencent.mobileqq.winkpublish.model.ExtendExifInterface;
import com.tencent.mobileqq.winkpublish.model.params.ImageParams;
import com.tencent.mobileqq.winkpublish.outbox.task.TaskContext;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.mobileqq.winkpublish.util.ExifUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.data.ImageUploadTask;
import common.config.service.QzoneConfig;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.model.LocalImageShootInfo;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b$\u0010%J0\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001a\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J(\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0002J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J \u0010\u0017\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\bH\u0002J\u001a\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000eH\u0002J\u0018\u0010 \u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u000eH\u0003J(\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J0\u0010#\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0004\u00a8\u0006&"}, d2 = {"Lwa3/d;", "", "Lcom/tencent/upload/uinterface/data/ImageUploadTask;", "imageUploadTask", "Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "context", "Lcom/tencent/mobileqq/winkpublish/model/params/ImageParams;", "imageParams", "", "indexInMediaList", "Lcom/tencent/upload/uinterface/IUploadTaskCallback;", "callback", "", "b", "", "clientTraceId", "e", "videoMediaCount", "imageMediaCount", tl.h.F, "g", "mediaCount", "mediaListIndex", "f", "c", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "i", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_FLOW_ID, "path", "k", "Lcom/tencent/mobileqq/winkpublish/model/ExtendExifInterface;", "exif", "j", "taskContext", "a", "d", "<init>", "()V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lwa3/d$a;", "", "Lcom/tencent/mobileqq/winkpublish/config/l;", DownloadInfo.spKey_Config, "Lwa3/d;", "a", "", "APPID_FLOCK", "Ljava/lang/String;", "APPID_QCIRCLE_AVATAR", "APPID_QQLIVE_COVER", "EXTEND_KEY_TRACE_ID", "TAG", "<init>", "()V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: wa3.d$a, reason: from kotlin metadata */
    /* loaded from: classes36.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final d a(l config) {
            Intrinsics.checkNotNullParameter(config, "config");
            int businessType = config.getBusinessType();
            if (businessType != 1) {
                if (businessType == 2) {
                    return b.f445338b;
                }
                if (businessType == 3) {
                    return e.f445341b;
                }
                if (businessType != 13) {
                    switch (businessType) {
                        case 9:
                            return i.f445345b;
                        case 10:
                            return h.f445344b;
                        case 11:
                            break;
                        default:
                            throw new IllegalArgumentException("no support config type: " + config.getBusinessType());
                    }
                } else {
                    return a.f445337b;
                }
            }
            return f.f445342b;
        }

        Companion() {
        }
    }

    private final void b(ImageUploadTask imageUploadTask, TaskContext context, ImageParams imageParams, int indexInMediaList, IUploadTaskCallback callback) {
        imageUploadTask.uploadTaskCallback = callback;
        imageUploadTask.iUin = ua3.a.d().f();
        imageUploadTask.sRefer = "mqq";
        imageUploadTask.vLoginData = ua3.a.d().b(true);
        imageUploadTask.md5 = SecUtil.getFileMd5(imageParams.getLocalPath());
        imageUploadTask.sAlbumName = "";
        int k3 = k((int) context.getBatchId(), imageParams.getLocalPath());
        imageUploadTask.flowId = k3;
        QLog.i("WinkPublish-ImageUploadTaskFactory", 1, "[fillCommonInfo] flowId=" + k3);
        imageUploadTask.uploadEntrance = context.getPublishParams().getUploadEntrance();
        imageUploadTask.sPicTitle = "";
        imageUploadTask.sPicDesc = null;
        imageUploadTask.bWaterType = false;
        imageUploadTask.autoRotate = true;
        imageUploadTask.clientFakeKey = context.getPublishParams().getClientKey();
        imageUploadTask.uploadPoi = null;
        imageUploadTask.iBusiNessType = context.getUploadBusinessType();
        imageUploadTask.iUploadTime = context.getCom.qzone.album.data.model.PhotoCategorySinglePicInfo.UPLOAD_TIME java.lang.String() - indexInMediaList;
        imageUploadTask.iUploadType = imageParams.getQuality();
        imageUploadTask.iBatchID = context.getBatchId();
        imageUploadTask.iUpPicType = context.u() > 0 ? 1 : 0;
        imageUploadTask.iSync = 0;
        imageUploadTask.sAlbumID = "";
        imageUploadTask.iAlbumTypeID = 32;
        imageUploadTask.iDistinctUse = QZoneUploadPicRequest.SHUOSHUO_SRC;
        imageUploadTask.uiRefer = "";
        imageUploadTask.keepTmpFile(true);
    }

    private final void c(ImageUploadTask imageUploadTask) {
        HashMap<String, byte[]> hashMap = new HashMap<>();
        hashMap.put(kExtKeyMarkUinBeforeUpload.value, new byte[0]);
        imageUploadTask.mExternalByteData = hashMap;
    }

    private final void e(ImageUploadTask imageUploadTask, String clientTraceId) {
        Map<String, String> mExtend_info = imageUploadTask.mExtend_info;
        if (mExtend_info == null) {
            mExtend_info = new HashMap<>();
        }
        imageUploadTask.mExtend_info = mExtend_info;
        Intrinsics.checkNotNullExpressionValue(mExtend_info, "mExtend_info");
        if (clientTraceId == null) {
            clientTraceId = "";
        }
        mExtend_info.put("trace_id", clientTraceId);
    }

    private final void f(ImageUploadTask imageUploadTask, int mediaCount, int mediaListIndex) {
        MultiPicInfo multiPicInfo = new MultiPicInfo();
        multiPicInfo.iBatUploadNum = mediaCount;
        multiPicInfo.iCurUpload = mediaListIndex;
        imageUploadTask.mutliPicInfo = multiPicInfo;
    }

    private final void g(ImageUploadTask imageUploadTask) {
        String format;
        PicExtendInfo picExtendInfo = imageUploadTask.stExtendInfo;
        if (picExtendInfo == null) {
            picExtendInfo = new PicExtendInfo();
        }
        imageUploadTask.stExtendInfo = picExtendInfo;
        Map<String, String> map = picExtendInfo.mapParams;
        if (map == null) {
            map = new HashMap<>();
        }
        picExtendInfo.mapParams = map;
        try {
            if (!JpegExifReader.isCrashJpeg(imageUploadTask.uploadFilePath)) {
                ExtendExifInterface extendExifInterface = new ExtendExifInterface(imageUploadTask.uploadFilePath);
                imageUploadTask.stExtendInfo.mapExif = ExifUtil.getExifToHashMap(extendExifInterface);
                String uploadFilePath = imageUploadTask.uploadFilePath;
                Intrinsics.checkNotNullExpressionValue(uploadFilePath, "uploadFilePath");
                imageUploadTask.exifTime = j(extendExifInterface, uploadFilePath);
            }
        } catch (Exception e16) {
            QLog.w("WinkPublish-ImageUploadTaskFactory", 1, "[createImageUploadTask] read pic exif error", e16);
        }
        LocalImageShootInfo shootInfo = LocalImageShootInfo.createFrom(imageUploadTask.uploadFilePath);
        if (shootInfo != null) {
            Intrinsics.checkNotNullExpressionValue(shootInfo, "shootInfo");
            LbsInfo lbsInfo = LbsDataV2.parceToLbsInfo(shootInfo);
            if (lbsInfo != null) {
                Intrinsics.checkNotNullExpressionValue(lbsInfo, "lbsInfo");
                String lbs_x = lbsInfo.lbs_x;
                if (lbs_x != null) {
                    Intrinsics.checkNotNullExpressionValue(lbs_x, "lbs_x");
                    Map<String, String> map2 = imageUploadTask.stExtendInfo.mapParams;
                    Intrinsics.checkNotNullExpressionValue(map2, "imageUploadTask.stExtendInfo.mapParams");
                    map2.put("geo_x", lbs_x);
                }
                String lbs_y = lbsInfo.lbs_y;
                if (lbs_y != null) {
                    Intrinsics.checkNotNullExpressionValue(lbs_y, "lbs_y");
                    Map<String, String> map3 = imageUploadTask.stExtendInfo.mapParams;
                    Intrinsics.checkNotNullExpressionValue(map3, "imageUploadTask.stExtendInfo.mapParams");
                    map3.put("geo_y", lbs_y);
                }
            }
            if (shootInfo.captureTime > 0) {
                try {
                    format = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").format(new Date(shootInfo.captureTime));
                    Intrinsics.checkNotNullExpressionValue(format, "formatter.format(Date(shootInfo.captureTime))");
                } catch (Exception e17) {
                    QLog.w("WinkPublish-ImageUploadTaskFactory", 1, "[fillSTExtendInfo] captureTime=" + shootInfo.captureTime, e17);
                }
                Map<String, String> map4 = imageUploadTask.stExtendInfo.mapParams;
                Intrinsics.checkNotNullExpressionValue(map4, "imageUploadTask.stExtendInfo.mapParams");
                map4.put("Exif_Time", format);
            }
            format = "";
            Map<String, String> map42 = imageUploadTask.stExtendInfo.mapParams;
            Intrinsics.checkNotNullExpressionValue(map42, "imageUploadTask.stExtendInfo.mapParams");
            map42.put("Exif_Time", format);
        }
        imageUploadTask.stExtendInfo.mapParams.put("show_geo", "0");
    }

    private final void h(ImageUploadTask imageUploadTask, ImageParams imageParams, int videoMediaCount, int imageMediaCount) {
        HashMap<String, String> stExternalMapExt = imageUploadTask.stExternalMapExt;
        if (stExternalMapExt == null) {
            stExternalMapExt = new HashMap<>();
        }
        imageUploadTask.stExternalMapExt = stExternalMapExt;
        if (videoMediaCount <= 0 || imageMediaCount <= 0) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(stExternalMapExt, "stExternalMapExt");
        stExternalMapExt.put(FSUploadConst.KEY_MIX_FEED, "1");
    }

    private final void i(ImageUploadTask imageUploadTask, int entrance) {
        int i3 = imageUploadTask.uploadEntrance;
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
            imageUploadTask.entry = AbstractUploadTask.ENTRY_TYPE_SHUOSHUO;
            return;
        }
        imageUploadTask.entry = "album";
    }

    private final String j(ExtendExifInterface exif, String path) {
        String attribute = exif.getAttribute("DateTime");
        if (QLog.isColorLevel()) {
            QLog.d("WinkPublish-ImageUploadTaskFactory", 2, "[getShootTime] exif dateString:" + attribute);
        }
        if (attribute != null) {
            return attribute;
        }
        String valueOf = String.valueOf(new File(path).lastModified());
        if (QLog.isColorLevel()) {
            QLog.d("WinkPublish-ImageUploadTaskFactory", 2, "[getShootTime] file dateString:" + valueOf);
        }
        if (Intrinsics.areEqual(valueOf, "0")) {
            return "";
        }
        String format = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").format(new Date(Long.parseLong(valueOf)));
        String str = format != null ? format : "";
        if (QLog.isColorLevel()) {
            QLog.d("WinkPublish-ImageUploadTaskFactory", 2, "[getShootTime] formatter dateString:" + str);
        }
        return str;
    }

    public abstract ImageUploadTask a(TaskContext taskContext, ImageParams imageParams, int indexInMediaList, IUploadTaskCallback callback);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d(ImageUploadTask imageUploadTask, TaskContext context, ImageParams imageParams, int indexInMediaList, IUploadTaskCallback callback) {
        Intrinsics.checkNotNullParameter(imageUploadTask, "imageUploadTask");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageParams, "imageParams");
        Intrinsics.checkNotNullParameter(callback, "callback");
        b(imageUploadTask, context, imageParams, indexInMediaList, callback);
        f(imageUploadTask, context.u(), indexInMediaList);
        e(imageUploadTask, context.getPublishParams().getTraceId());
        h(imageUploadTask, imageParams, context.x().size(), context.l().size());
        g(imageUploadTask);
        c(imageUploadTask);
        i(imageUploadTask, context.getPublishParams().getUploadEntrance());
        QLog.d("WinkPublish-ImageUploadTaskFactory", 1, "[fillImageUploadTask] create finish, path=" + imageUploadTask.uploadFilePath + ", flowId=" + imageUploadTask.flowId + ", index=" + indexInMediaList + ", iUploadTime=" + imageUploadTask.iUploadTime + ", task id=" + context.getId());
    }

    private final int k(int flowId, String path) {
        if (path == null) {
            path = "";
        }
        return flowId + (path + flowId).hashCode();
    }
}
