package x7;

import NS_MOBILE_OPERATION.MediaInfo;
import NS_MOBILE_OPERATION.PicInfo;
import NS_MOBILE_OPERATION.operation_addcomment_rsp;
import android.text.TextUtils;
import android.util.Log;
import com.qq.taf.jce.JceStruct;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.protocol.request.QZoneAddCommentRequest;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.publish.outbox.Outbox;
import com.tencent.biz.richframework.publish.base.RFWPublishFile;
import com.tencent.biz.richframework.publish.base.interfaces.IRFWLog;
import com.tencent.biz.richframework.publish.base.interfaces.IRFWUploadDelegate;
import com.tencent.biz.richframework.publish.nt.NTBatchUploadConstants$AppType;
import com.tencent.biz.richframework.publish.nt.model.NTPublishModel;
import com.tencent.biz.richframework.publish.nt.model.media.NTPublishFile;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.BatchUploadTask;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import qzone.StoragePhotoSdkCommon$ImgInfo;
import y7.QZPicCommentNTPublishModel;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u00020\u0005:\u0001(B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0003H\u0002J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0006\u0010\r\u001a\u00020\u0000J\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eJ\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J \u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u0011H\u0016J\u0012\u0010\u001f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016R\u0016\u0010\"\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010!R\u0016\u0010%\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010$\u00a8\u0006)"}, d2 = {"Lx7/b;", "Lcom/tencent/biz/richframework/publish/base/interfaces/IRFWLog;", "Lcom/tencent/biz/richframework/publish/base/interfaces/IRFWUploadDelegate;", "Lcom/tencent/biz/richframework/publish/nt/model/NTPublishModel;", "Lcom/tencent/biz/richframework/publish/nt/model/media/NTPublishFile;", "Lcom/qzone/common/business/IQZoneServiceListener;", "publishModel", "LNS_MOBILE_OPERATION/MediaInfo;", "d", "Lcom/qzone/common/business/task/QZoneTask;", "task", "", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/qzone/common/business/service/QZoneWriteOperationService$l;", "params", "p", "", "getLogTag", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "publishFile", tl.h.F, "g", "f", "e", "", "bytesUploaded", "bytesTotal", "i", "toString", "onTaskResponse", "Lx7/d;", "Lx7/d;", "uploader", "Lx7/c;", "Lx7/c;", "publisher", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b implements IRFWLog, IRFWUploadDelegate<NTPublishModel, NTPublishFile>, IQZoneServiceListener {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h, reason: collision with root package name */
    private static volatile b f447357h;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QZPicCommentNTUploader uploader;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private c publisher;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e\u00a2\u0006\f\n\u0004\b\t\u0010\n\u0012\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lx7/b$a;", "", "Lx7/b;", "a", "", "b", "", "TAG", "Ljava/lang/String;", "sInstance", "Lx7/b;", "getSInstance$annotations", "()V", "<init>", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: x7.b$a, reason: from kotlin metadata */
    /* loaded from: classes36.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final b a() {
            if (b.f447357h == null) {
                synchronized (b.class) {
                    if (b.f447357h == null) {
                        b.f447357h = new b(null).q();
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            b bVar = b.f447357h;
            Intrinsics.checkNotNull(bVar);
            return bVar;
        }

        Companion() {
        }

        @JvmStatic
        public final void b() {
            b.f447357h = null;
        }
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final MediaInfo d(NTPublishModel publishModel) {
        MediaInfo mediaInfo = new MediaInfo();
        if (mediaInfo.picinfolist == null) {
            mediaInfo.picinfolist = new ArrayList<>();
        }
        Iterator<RFWPublishFile<BatchUploadTask>> it = publishModel.getFileList().iterator();
        while (it.hasNext()) {
            RFWPublishFile<BatchUploadTask> next = it.next();
            if (next instanceof z7.b) {
                PicInfo picInfo = new PicInfo();
                picInfo.pictype = 2;
                z7.b bVar = (z7.b) next;
                if (bVar.b() != null) {
                    List<StoragePhotoSdkCommon$ImgInfo> b16 = bVar.b();
                    Intrinsics.checkNotNull(b16);
                    if (b16.isEmpty()) {
                        QLog.e(getLogTag(), 1, "convertMediaInfo error\uff0cimageInfo is empty,taskId={" + next.getFileID() + "}");
                    }
                    List<StoragePhotoSdkCommon$ImgInfo> b17 = bVar.b();
                    Intrinsics.checkNotNull(b17);
                    for (StoragePhotoSdkCommon$ImgInfo storagePhotoSdkCommon$ImgInfo : b17) {
                        String str = storagePhotoSdkCommon$ImgInfo.img_url.get();
                        Intrinsics.checkNotNullExpressionValue(str, "imageInfo.img_url.get()");
                        if (!(str.length() == 0)) {
                            if (storagePhotoSdkCommon$ImgInfo.img_class.get() == 1) {
                                picInfo.pic_url = storagePhotoSdkCommon$ImgInfo.img_url.get();
                                picInfo.hdwidth = storagePhotoSdkCommon$ImgInfo.img_width.get();
                                picInfo.hdheight = storagePhotoSdkCommon$ImgInfo.img_height.get();
                            } else if (storagePhotoSdkCommon$ImgInfo.img_class.get() == 2) {
                                String str2 = picInfo.pic_url;
                                Intrinsics.checkNotNullExpressionValue(str2, "picInfo.pic_url");
                                if (str2.length() == 0) {
                                    picInfo.pic_url = storagePhotoSdkCommon$ImgInfo.img_url.get();
                                    picInfo.hdwidth = storagePhotoSdkCommon$ImgInfo.img_width.get();
                                    picInfo.hdheight = storagePhotoSdkCommon$ImgInfo.img_height.get();
                                }
                            } else if (storagePhotoSdkCommon$ImgInfo.img_class.get() == 3) {
                                String str3 = picInfo.pic_url;
                                Intrinsics.checkNotNullExpressionValue(str3, "picInfo.pic_url");
                                if (str3.length() == 0) {
                                    picInfo.pic_url = storagePhotoSdkCommon$ImgInfo.img_url.get();
                                }
                                picInfo.picwidth = storagePhotoSdkCommon$ImgInfo.img_width.get();
                                picInfo.picheight = storagePhotoSdkCommon$ImgInfo.img_height.get();
                            }
                        }
                    }
                    mediaInfo.picinfolist.add(picInfo);
                }
            }
        }
        return mediaInfo;
    }

    @JvmStatic
    public static final b j() {
        return INSTANCE.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(b this$0, NTPublishModel publishModel) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(publishModel, "$publishModel");
        this$0.missionDidFinish(publishModel);
    }

    @JvmStatic
    public static final void o() {
        INSTANCE.b();
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWUploadDelegate
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void fileDidCancelUpload(NTPublishFile publishFile) {
        Intrinsics.checkNotNullParameter(publishFile, "publishFile");
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWUploadDelegate
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void fileDidFailUpload(NTPublishFile publishFile) {
        Intrinsics.checkNotNullParameter(publishFile, "publishFile");
        QLog.d(getLogTag(), 1, "send pic comment occur error! file=" + publishFile.getFileID() + ", error=" + publishFile.getUploadErrorInfo());
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWUploadDelegate
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void fileDidFinishUpload(NTPublishFile publishFile) {
        Intrinsics.checkNotNullParameter(publishFile, "publishFile");
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWLog
    public String getLogTag() {
        return "QZPicCommentNTPublishHelper";
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWUploadDelegate
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void fileDidStartUpload(NTPublishFile publishFile) {
        Intrinsics.checkNotNullParameter(publishFile, "publishFile");
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWUploadDelegate
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void fileDidUpdateProgress(NTPublishFile publishFile, long bytesUploaded, long bytesTotal) {
        Intrinsics.checkNotNullParameter(publishFile, "publishFile");
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWUploadDelegate
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void missionDidStart(NTPublishModel publishModel) {
        Intrinsics.checkNotNullParameter(publishModel, "publishModel");
    }

    public final void p(QZoneWriteOperationService.l params) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (params.f45726s.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = params.f45726s.iterator();
        while (it.hasNext()) {
            String path = it.next();
            if (!TextUtils.isEmpty(path)) {
                Intrinsics.checkNotNullExpressionValue(path, "path");
                z7.b bVar = new z7.b(path);
                bVar.c(params.f45711d);
                arrayList.add(bVar);
            }
        }
        this.publisher.b(arrayList, params);
    }

    public final b q() {
        c cVar = this.publisher;
        String uinString = LoginData.getInstance().getUinString();
        Intrinsics.checkNotNullExpressionValue(uinString, "getInstance().uinString");
        cVar.a(uinString);
        this.publisher.injectDelegate(this);
        return this;
    }

    public String toString() {
        return "QZPicCommentNTPublishHelper";
    }

    b() {
        this.uploader = new QZPicCommentNTUploader(NTBatchUploadConstants$AppType.APP_TYPE_QZONE_SHUOSHUO_COMMENT);
        this.publisher = new c(this.uploader);
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask task) {
        if (task == null) {
            return;
        }
        try {
            n(task);
        } catch (Exception e16) {
            QLog.e(getLogTag(), 1, "send pic comment error,notifyPublishResult exception:" + Log.getStackTraceString(e16));
        }
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWUploadDelegate
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void missionDidFinish(final NTPublishModel publishModel) {
        Intrinsics.checkNotNullParameter(publishModel, "publishModel");
        if (publishModel instanceof QZPicCommentNTPublishModel) {
            QZoneWriteOperationService.l params = ((QZPicCommentNTPublishModel) publishModel).getParams();
            if (params == null) {
                QLog.e(getLogTag(), 1, "send pic comment error,params is null!");
                return;
            }
            if (!publishModel.isAllFileUploadNoError()) {
                QQToastUtil.showQQToastInUiThread(4, "\u4e0a\u4f20\u56fe\u7247\u5931\u8d25,\u8bf7\u7a0d\u540e\u91cd\u8bd5");
                n(null);
                return;
            }
            if (!publishModel.isAllFileUploaded()) {
                QLog.d(getLogTag(), 1, "send pic comment\uff0cnot all file uploaded, waiting...");
                RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: x7.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.l(b.this, publishModel);
                    }
                }, 100L);
                return;
            }
            MediaInfo d16 = d(publishModel);
            QLog.d(getLogTag(), 1, "begin send pic comment\uff0cmedia size=" + d16.picinfolist.size());
            QZoneAddCommentRequest qZoneAddCommentRequest = new QZoneAddCommentRequest(0, params.f45712e, params.f45713f, params.f45714g, params.f45715h, params.f45716i, params.f45717j, params.f45718k, params.f45719l, params.f45725r, d16, params.f45730w);
            QZoneTask qZoneTask = new QZoneTask(qZoneAddCommentRequest, null, this, 0);
            qZoneTask.addParameter(s4.c.UGCKEY, params.f45708a);
            qZoneTask.addParameter("feedkey", params.f45709b);
            qZoneTask.addParameter("uniKey", params.f45710c);
            qZoneTask.addParameter("position", Integer.valueOf(params.f45723p));
            qZoneTask.addParameter("clickScene", Integer.valueOf(params.f45727t));
            qZoneTask.addParameter("src_refer", Integer.valueOf(params.f45728u));
            qZoneTask.addParameter("albumid", params.f45714g);
            qZoneTask.addParameter("lloc", params.f45729v);
            qZoneTask.addParameter("is_from_hb", Boolean.FALSE);
            qZoneTask.addParameter("feeddata", params.f45732y);
            qZoneTask.addParameter("feedtype", Integer.valueOf(params.f45733z));
            if (params.f45712e == 4 && !TextUtils.isEmpty(params.f45722o)) {
                qZoneTask.addParameter("relative_ugckey", params.f45722o);
            }
            Outbox.C().Q(new b9.a(this, qZoneTask, qZoneAddCommentRequest.getRequestCmd()));
        }
    }

    private final void n(QZoneTask task) {
        if (task != null) {
            QZoneRequest qZoneRequest = task.mRequest;
            if (qZoneRequest instanceof QZoneAddCommentRequest) {
                Intrinsics.checkNotNull(qZoneRequest, "null cannot be cast to non-null type com.qzone.common.protocol.request.QZoneAddCommentRequest");
                JceStruct jceStruct = ((QZoneAddCommentRequest) qZoneRequest).rsp;
                operation_addcomment_rsp operation_addcomment_rspVar = jceStruct instanceof operation_addcomment_rsp ? (operation_addcomment_rsp) jceStruct : null;
                if (operation_addcomment_rspVar != null) {
                    task.mResultCode = operation_addcomment_rspVar.ret;
                    task.f45835msg = operation_addcomment_rspVar.f25009msg;
                    String str = operation_addcomment_rspVar.commentid;
                    String str2 = operation_addcomment_rspVar.commentLikekey;
                    Map<String, String> map = operation_addcomment_rspVar.extend_info;
                    if (task.succeeded()) {
                        QQToastUtil.showQQToastInUiThread(5, "\u8bc4\u8bba\u6210\u529f");
                        QLog.d(getLogTag(), 1, "send pic comment success!");
                    } else {
                        QQToastUtil.showQQToastInUiThread(4, "\u8bc4\u8bba\u5931\u8d25");
                        QLog.e(getLogTag(), 1, "send pic comment error,errCode=" + task.mResultCode + ",errMsg:" + task.f45835msg);
                    }
                    Object parameter = task.getParameter(s4.c.UGCKEY);
                    String str3 = parameter instanceof String ? (String) parameter : null;
                    if (str3 == null) {
                        str3 = "";
                    }
                    Object parameter2 = task.getParameter("uniKey");
                    String str4 = parameter2 instanceof String ? (String) parameter2 : null;
                    if (str4 == null) {
                        str4 = "";
                    }
                    Object parameter3 = task.getParameter("feedkey");
                    String str5 = parameter3 instanceof String ? (String) parameter3 : null;
                    String str6 = str5 != null ? str5 : "";
                    Object parameter4 = task.getParameter("position");
                    Integer num = parameter4 instanceof Integer ? (Integer) parameter4 : null;
                    int intValue = num != null ? num.intValue() : 0;
                    Object parameter5 = task.getParameter("clickScene");
                    Integer num2 = parameter5 instanceof Integer ? (Integer) parameter5 : null;
                    int intValue2 = num2 != null ? num2.intValue() : 0;
                    Object parameter6 = task.getParameter("feedtype");
                    Integer num3 = parameter6 instanceof Integer ? (Integer) parameter6 : null;
                    QZoneWriteOperationService.v0().notify(4, str3, str4, Boolean.valueOf(task.succeeded()), str, str6, Integer.valueOf(intValue), Integer.valueOf(task.mResultCode), Integer.valueOf(intValue2), str2, Integer.valueOf(num3 != null ? num3.intValue() : 0), map);
                    return;
                }
                QLog.e(getLogTag(), 1, "notifyResult occur error,response is null!");
                return;
            }
            QLog.e(getLogTag(), 1, "notifyResult occur error,request is not QZoneAddCommentRequest!");
            return;
        }
        QLog.e(getLogTag(), 1, "notifyResult occur error,task is null!");
    }
}
