package x7;

import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.tencent.biz.richframework.publish.base.RFWPublishFile;
import com.tencent.biz.richframework.publish.base.interfaces.IRFWLog;
import com.tencent.biz.richframework.publish.base.interfaces.IRFWUploadDelegate;
import com.tencent.biz.richframework.publish.nt.NTBatchUploadConstants$AppType;
import com.tencent.biz.richframework.publish.nt.model.NTPublishModel;
import com.tencent.biz.richframework.publish.nt.model.media.NTPublishFile;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonImage;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonPicSpecUrlEntry;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonPicUrl;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonRichMsg;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedCommentManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.AddCommentRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedDataUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.BatchUploadTask;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import qzone.StoragePhotoSdkCommon$ImgInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000b2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002:\u0002,-B\t\b\u0002\u00a2\u0006\u0004\b*\u0010+J&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007H\u0002J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0006\u0010\u000e\u001a\u00020\u0000J\u0016\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J \u0010 \u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0016J\b\u0010!\u001a\u00020\u0006H\u0016R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lx7/h;", "Lcom/tencent/biz/richframework/publish/base/interfaces/IRFWLog;", "Lcom/tencent/biz/richframework/publish/base/interfaces/IRFWUploadDelegate;", "Lcom/tencent/biz/richframework/publish/nt/model/NTPublishModel;", "Lcom/tencent/biz/richframework/publish/nt/model/media/NTPublishFile;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "photoPaths", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", "f", "publishModel", "g", "t", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "commonFeed", "Lwd/d;", "commentBean", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "getLogTag", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "publishFile", "k", "j", "i", tl.h.F, "", "bytesUploaded", "bytesTotal", "l", "toString", "Lx7/d;", "d", "Lx7/d;", "uploader", "Lx7/i;", "e", "Lx7/i;", "publisher", "<init>", "()V", "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class h implements IRFWLog, IRFWUploadDelegate<NTPublishModel, NTPublishFile> {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h, reason: collision with root package name */
    private static volatile h f447377h;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QZPicCommentNTUploader uploader;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private i publisher;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e\u00a2\u0006\f\n\u0004\b\t\u0010\n\u0012\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lx7/h$a;", "", "Lx7/h;", "a", "", "b", "", "TAG", "Ljava/lang/String;", "sInstance", "Lx7/h;", "getSInstance$annotations", "()V", "<init>", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: x7.h$a, reason: from kotlin metadata */
    /* loaded from: classes36.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final h a() {
            if (h.f447377h == null) {
                synchronized (h.class) {
                    if (h.f447377h == null) {
                        h.f447377h = new h(null).t();
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            h hVar = h.f447377h;
            Intrinsics.checkNotNull(hVar);
            return hVar;
        }

        Companion() {
        }

        @JvmStatic
        public final void b() {
            h.f447377h = null;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\f\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\nR\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lx7/h$b;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "a", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "b", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "commonFeed", "Lwd/d;", "Lwd/d;", "()Lwd/d;", "commentBean", "", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "fakeClientKey", "<init>", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;Lwd/d;Ljava/lang/String;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final CommonFeed commonFeed;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final wd.d commentBean;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final String fakeClientKey;

        public b(CommonFeed commonFeed, wd.d commentBean, String fakeClientKey) {
            Intrinsics.checkNotNullParameter(commonFeed, "commonFeed");
            Intrinsics.checkNotNullParameter(commentBean, "commentBean");
            Intrinsics.checkNotNullParameter(fakeClientKey, "fakeClientKey");
            this.commonFeed = commonFeed;
            this.commentBean = commentBean;
            this.fakeClientKey = fakeClientKey;
        }

        /* renamed from: a, reason: from getter */
        public final wd.d getCommentBean() {
            return this.commentBean;
        }

        /* renamed from: b, reason: from getter */
        public final CommonFeed getCommonFeed() {
            return this.commonFeed;
        }

        /* renamed from: c, reason: from getter */
        public final String getFakeClientKey() {
            return this.fakeClientKey;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"x7/h$c", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/AddCommentRsp;", "", "errorCode", "", "errorMsg", "", "onFailure", "t", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class c implements DataCallback<AddCommentRsp> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ NTPublishModel f447384b;

        c(NTPublishModel nTPublishModel) {
            this.f447384b = nTPublishModel;
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(AddCommentRsp t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(t16, "t");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            String logTag = h.this.getLogTag();
            StComment stComment = t16.comment;
            String str = stComment != null ? stComment.id : null;
            QLog.i(logTag, 1, "missionDidFinish addPicComment onSuccess | commentId=" + str + " | publishModel=" + this.f447384b);
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            QLog.e(h.this.getLogTag(), 1, "missionDidFinish addPicComment error | errorCode=" + errorCode + " | errorMsg=" + errorMsg + " | publishModel=" + this.f447384b);
            com.qzone.reborn.feedpro.utils.c.f54317a.a(errorCode, errorMsg, "\u8bc4\u8bba\u5931\u8d25");
        }
    }

    public /* synthetic */ h(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final List<CommonMedia> f(ArrayList<String> photoPaths) {
        ArrayList arrayList = new ArrayList();
        for (String str : photoPaths) {
            CommonMedia commonMedia = new CommonMedia();
            commonMedia.setType(0);
            commonMedia.setImage(le.a.f414396a.e(str));
            arrayList.add(commonMedia);
        }
        return arrayList;
    }

    private final List<CommonMedia> g(NTPublishModel publishModel) {
        ArrayList arrayList = new ArrayList();
        Iterator<RFWPublishFile<BatchUploadTask>> it = publishModel.getFileList().iterator();
        while (it.hasNext()) {
            RFWPublishFile<BatchUploadTask> next = it.next();
            if (next instanceof z7.d) {
                z7.d dVar = (z7.d) next;
                List<StoragePhotoSdkCommon$ImgInfo> b16 = dVar.b();
                if (b16 == null || b16.isEmpty()) {
                    QLog.e(getLogTag(), 1, "convertMediaInfo error\uff0cimageInfo is empty,taskId={" + next.getFileID() + "}");
                    return arrayList;
                }
                ArrayList arrayList2 = new ArrayList();
                List<StoragePhotoSdkCommon$ImgInfo> b17 = dVar.b();
                Intrinsics.checkNotNull(b17);
                int i3 = 0;
                int i16 = 0;
                for (StoragePhotoSdkCommon$ImgInfo storagePhotoSdkCommon$ImgInfo : b17) {
                    QLog.d(getLogTag(), 1, "convertMediaInfo\uff0cimageInfo=" + w7.a.f444706a.e(storagePhotoSdkCommon$ImgInfo));
                    CommonPicSpecUrlEntry commonPicSpecUrlEntry = new CommonPicSpecUrlEntry();
                    int i17 = storagePhotoSdkCommon$ImgInfo.img_class.get();
                    if (i17 == 1) {
                        commonPicSpecUrlEntry.setSpec(1);
                    } else if (i17 == 2) {
                        commonPicSpecUrlEntry.setSpec(0);
                    } else if (i17 == 3) {
                        commonPicSpecUrlEntry.setSpec(3);
                    }
                    if (storagePhotoSdkCommon$ImgInfo.img_width.get() != 0) {
                        i3 = storagePhotoSdkCommon$ImgInfo.img_width.get();
                    }
                    if (storagePhotoSdkCommon$ImgInfo.img_height.get() != 0) {
                        i16 = storagePhotoSdkCommon$ImgInfo.img_height.get();
                    }
                    CommonPicUrl commonPicUrl = new CommonPicUrl();
                    commonPicUrl.setUrl(storagePhotoSdkCommon$ImgInfo.img_url.get());
                    commonPicUrl.setWidth(storagePhotoSdkCommon$ImgInfo.img_width.get() != 0 ? storagePhotoSdkCommon$ImgInfo.img_width.get() : i3);
                    commonPicUrl.setHeight(storagePhotoSdkCommon$ImgInfo.img_height.get() != 0 ? storagePhotoSdkCommon$ImgInfo.img_height.get() : i16);
                    commonPicSpecUrlEntry.setUrl(commonPicUrl);
                    arrayList2.add(commonPicSpecUrlEntry);
                }
                CommonMedia commonMedia = new CommonMedia();
                commonMedia.setType(0);
                CommonImage commonImage = new CommonImage();
                commonImage.setPhotoUrl(arrayList2);
                commonMedia.setImage(commonImage);
                CommonImage image = commonMedia.getImage();
                Intrinsics.checkNotNull(image);
                CommonImage image2 = commonMedia.getImage();
                Intrinsics.checkNotNull(image2);
                image.setDefaultUrl(xd.d.e(image2));
                arrayList.add(commonMedia);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(h this$0, NTPublishModel publishModel) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(publishModel, "$publishModel");
        this$0.missionDidFinish(publishModel);
    }

    @JvmStatic
    public static final void p() {
        INSTANCE.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(final wd.d commentBean, final h this$0, final CommonFeed commonFeed) {
        Intrinsics.checkNotNullParameter(commentBean, "$commentBean");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(commonFeed, "$commonFeed");
        final List<CommonRichMsg> stringToRichMsg = CommonFeedDataUtil.INSTANCE.stringToRichMsg(commentBean.getCommentText());
        ArrayList<String> e16 = commentBean.e();
        Intrinsics.checkNotNull(e16);
        final List<CommonMedia> f16 = this$0.f(e16);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: x7.g
            @Override // java.lang.Runnable
            public final void run() {
                h.s(CommonFeed.this, stringToRichMsg, f16, this$0, commentBean);
            }
        });
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWLog
    public String getLogTag() {
        return "QzoneFeedProPicCommentNTPublishHelper";
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWUploadDelegate
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void fileDidCancelUpload(NTPublishFile publishFile) {
        Intrinsics.checkNotNullParameter(publishFile, "publishFile");
        QLog.w(getLogTag(), 1, "fileDidCancelUpload, file=" + publishFile + ", error=" + publishFile.getUploadErrorInfo());
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWUploadDelegate
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void fileDidFailUpload(NTPublishFile publishFile) {
        Intrinsics.checkNotNullParameter(publishFile, "publishFile");
        QLog.e(getLogTag(), 1, "fileDidFailUpload error! file=" + publishFile + ", error=" + publishFile.getUploadErrorInfo());
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWUploadDelegate
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void fileDidFinishUpload(NTPublishFile publishFile) {
        Intrinsics.checkNotNullParameter(publishFile, "publishFile");
        QLog.d(getLogTag(), 1, "fileDidFinishUpload, file=" + publishFile + ", error=" + publishFile.getUploadErrorInfo());
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWUploadDelegate
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void fileDidStartUpload(NTPublishFile publishFile) {
        Intrinsics.checkNotNullParameter(publishFile, "publishFile");
        QLog.d(getLogTag(), 1, "fileDidStartUpload, file=" + publishFile + ", error=" + publishFile.getUploadErrorInfo());
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWUploadDelegate
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void fileDidUpdateProgress(NTPublishFile publishFile, long bytesUploaded, long bytesTotal) {
        Intrinsics.checkNotNullParameter(publishFile, "publishFile");
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWUploadDelegate
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void missionDidFinish(final NTPublishModel publishModel) {
        Intrinsics.checkNotNullParameter(publishModel, "publishModel");
        if (!(publishModel instanceof y7.b)) {
            QLog.e(getLogTag(), 1, "missionDidFinish !is QzoneFeedProPicCommentNTPublishModel!");
            return;
        }
        if (((y7.b) publishModel).getParamsData() == null) {
            QLog.e(getLogTag(), 1, "send pic comment error,params is null!");
            return;
        }
        if (!publishModel.isAllFileUploadNoError()) {
            QLog.e(getLogTag(), 1, "missionDidFinish upload pic error, publishModel=" + publishModel);
            return;
        }
        if (!publishModel.isAllFileUploaded()) {
            QLog.d(getLogTag(), 1, "send pic comment\uff0cnot all file uploaded, waiting...");
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: x7.f
                @Override // java.lang.Runnable
                public final void run() {
                    h.n(h.this, publishModel);
                }
            }, 100L);
            return;
        }
        QLog.i(getLogTag(), 1, "missionDidFinish uploadPic onSuccess, publishModel=" + publishModel);
        CommonFeedDataUtil commonFeedDataUtil = CommonFeedDataUtil.INSTANCE;
        y7.b bVar = (y7.b) publishModel;
        b paramsData = bVar.getParamsData();
        Intrinsics.checkNotNull(paramsData);
        List<CommonRichMsg> stringToRichMsg = commonFeedDataUtil.stringToRichMsg(paramsData.getCommentBean().getCommentText());
        QzoneFeedCommentManager qzoneFeedCommentManager = new QzoneFeedCommentManager();
        b paramsData2 = bVar.getParamsData();
        Intrinsics.checkNotNull(paramsData2);
        CommonCellCommon cellCommon = paramsData2.getCommonFeed().getCellCommon();
        CommonUnionID unionId = cellCommon != null ? cellCommon.getUnionId() : null;
        List<CommonMedia> g16 = g(publishModel);
        b paramsData3 = bVar.getParamsData();
        Intrinsics.checkNotNull(paramsData3);
        String fakeClientKey = paramsData3.getFakeClientKey();
        b paramsData4 = bVar.getParamsData();
        Intrinsics.checkNotNull(paramsData4);
        qzoneFeedCommentManager.addPicComment(unionId, stringToRichMsg, g16, fakeClientKey, paramsData4.getCommentBean().getIsPrivate(), new c(publishModel));
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWUploadDelegate
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void missionDidStart(NTPublishModel publishModel) {
        Intrinsics.checkNotNullParameter(publishModel, "publishModel");
    }

    public final void q(final CommonFeed commonFeed, final wd.d commentBean) {
        Intrinsics.checkNotNullParameter(commonFeed, "commonFeed");
        Intrinsics.checkNotNullParameter(commentBean, "commentBean");
        ArrayList<String> e16 = commentBean.e();
        if (e16 == null || e16.isEmpty()) {
            QLog.e(getLogTag(), 1, "sendPicComment pic is null");
        } else {
            RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: x7.e
                @Override // java.lang.Runnable
                public final void run() {
                    h.r(wd.d.this, this, commonFeed);
                }
            });
        }
    }

    public final h t() {
        i iVar = this.publisher;
        String uinString = LoginData.getInstance().getUinString();
        Intrinsics.checkNotNullExpressionValue(uinString, "getInstance().uinString");
        iVar.a(uinString);
        this.publisher.injectDelegate(this);
        return this;
    }

    public String toString() {
        return "QzoneFeedProPicCommentNTPublishHelper";
    }

    h() {
        this.uploader = new QZPicCommentNTUploader(NTBatchUploadConstants$AppType.APP_TYPE_QZONE_SHUOSHUO_COMMENT);
        this.publisher = new i(this.uploader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(CommonFeed commonFeed, List content, List fakeMediaInfo, h this$0, wd.d commentBean) {
        Intrinsics.checkNotNullParameter(commonFeed, "$commonFeed");
        Intrinsics.checkNotNullParameter(content, "$content");
        Intrinsics.checkNotNullParameter(fakeMediaInfo, "$fakeMediaInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(commentBean, "$commentBean");
        QzoneFeedCommentManager qzoneFeedCommentManager = new QzoneFeedCommentManager();
        CommonCellCommon cellCommon = commonFeed.getCellCommon();
        String insertFakePicComment = qzoneFeedCommentManager.insertFakePicComment(cellCommon != null ? cellCommon.getUnionId() : null, content, fakeMediaInfo);
        String logTag = this$0.getLogTag();
        String commentText = commentBean.getCommentText();
        ArrayList<String> e16 = commentBean.e();
        QLog.i(logTag, 1, "sendPicComment  | fakeClientKey=" + insertFakePicComment + " | content=" + commentText + " | picList=" + (e16 != null ? CollectionsKt___CollectionsKt.joinToString$default(e16, "\u3001", null, null, 0, null, null, 62, null) : null));
        ArrayList arrayList = new ArrayList();
        ArrayList<String> e17 = commentBean.e();
        Intrinsics.checkNotNull(e17);
        Iterator<String> it = e17.iterator();
        while (it.hasNext()) {
            String path = it.next();
            if (!TextUtils.isEmpty(path)) {
                Intrinsics.checkNotNullExpressionValue(path, "path");
                z7.d dVar = new z7.d(path);
                CommonCellCommon cellCommon2 = commonFeed.getCellCommon();
                dVar.c(cellCommon2 != null ? cellCommon2.getClientKey() : null);
                arrayList.add(dVar);
            }
        }
        this$0.publisher.b(arrayList, new b(commonFeed, commentBean, insertFakePicComment));
    }
}
