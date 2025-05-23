package t7;

import com.tencent.biz.richframework.publish.base.RFWPublishFile;
import com.tencent.biz.richframework.publish.base.interfaces.IRFWLog;
import com.tencent.biz.richframework.publish.base.interfaces.IRFWUploadDelegate;
import com.tencent.biz.richframework.publish.nt.NTBatchPublisher;
import com.tencent.biz.richframework.publish.nt.NTBatchUploadConstants$AppType;
import com.tencent.biz.richframework.publish.nt.model.NTPublishModel;
import com.tencent.biz.richframework.publish.nt.model.media.NTPublishFile;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.BatchUploadTaskErrorInfo;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u7.QZIntimatePublishModel;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002:\u0001%B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0006\u0010\u0005\u001a\u00020\u0000J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J \u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0016R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001eR\u001e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010!\u00a8\u0006&"}, d2 = {"Lt7/d;", "Lcom/tencent/biz/richframework/publish/base/interfaces/IRFWLog;", "Lcom/tencent/biz/richframework/publish/base/interfaces/IRFWUploadDelegate;", "Lcom/tencent/biz/richframework/publish/nt/model/NTPublishModel;", "Lcom/tencent/biz/richframework/publish/nt/model/media/NTPublishFile;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "getLogTag", "filePath", "Lt7/a;", "listener", "", DomainData.DOMAIN_NAME, "publishModel", "k", "i", "publishFile", "g", "f", "e", "d", "", "bytesUploaded", "bytesTotal", tl.h.F, "toString", "Lt7/i;", "Lt7/i;", "uploader", "Lt7/e;", "Lt7/e;", "publisher", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "uploadListenerRef", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d implements IRFWLog, IRFWUploadDelegate<NTPublishModel, NTPublishFile> {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: collision with root package name */
    private static volatile d f435506i;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QZNTArkUploader uploader = new QZNTArkUploader(NTBatchUploadConstants$AppType.APP_TYPE_QZONE_INTIMATE_SPACE_ARK_SHARE);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private e publisher = new e(this.uploader);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private WeakReference<a> uploadListenerRef;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e\u00a2\u0006\f\n\u0004\b\t\u0010\n\u0012\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lt7/d$a;", "", "Lt7/d;", "a", "", "b", "", "TAG", "Ljava/lang/String;", "sInstance", "Lt7/d;", "getSInstance$annotations", "()V", "<init>", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: t7.d$a, reason: from kotlin metadata */
    /* loaded from: classes36.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final d a() {
            if (d.f435506i == null) {
                synchronized (d.class) {
                    if (d.f435506i == null) {
                        d.f435506i = new d().m();
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            d dVar = d.f435506i;
            Intrinsics.checkNotNull(dVar);
            return dVar;
        }

        Companion() {
        }

        @JvmStatic
        public final void b() {
            d.f435506i = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(d this$0, NTPublishModel publishModel) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(publishModel, "$publishModel");
        this$0.missionDidFinish(publishModel);
    }

    @JvmStatic
    public static final void l() {
        INSTANCE.b();
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWUploadDelegate
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void fileDidCancelUpload(NTPublishFile publishFile) {
        Intrinsics.checkNotNullParameter(publishFile, "publishFile");
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWUploadDelegate
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void fileDidFailUpload(NTPublishFile publishFile) {
        Intrinsics.checkNotNullParameter(publishFile, "publishFile");
        QLog.e(getLogTag(), 1, "upload ark pic occur error!file=" + publishFile.getFileID() + ",error=" + publishFile.getUploadErrorInfo());
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWUploadDelegate
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void fileDidFinishUpload(NTPublishFile publishFile) {
        Intrinsics.checkNotNullParameter(publishFile, "publishFile");
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWUploadDelegate
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void fileDidStartUpload(NTPublishFile publishFile) {
        Intrinsics.checkNotNullParameter(publishFile, "publishFile");
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWLog
    public String getLogTag() {
        return "QZNTArkUploadHelper";
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWUploadDelegate
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void fileDidUpdateProgress(NTPublishFile publishFile, long bytesUploaded, long bytesTotal) {
        Intrinsics.checkNotNullParameter(publishFile, "publishFile");
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWUploadDelegate
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void missionDidFinish(final NTPublishModel publishModel) {
        Object firstOrNull;
        Object obj;
        BatchUploadTaskErrorInfo uploadErrorInfo;
        BatchUploadTaskErrorInfo uploadErrorInfo2;
        Intrinsics.checkNotNullParameter(publishModel, "publishModel");
        QLog.d(getLogTag(), 1, "upload ark pic finish,model=" + publishModel);
        if (publishModel instanceof QZIntimatePublishModel) {
            WeakReference<a> weakReference = this.uploadListenerRef;
            r1 = null;
            String str = null;
            a aVar = weakReference != null ? weakReference.get() : null;
            if (aVar == null) {
                QLog.e(getLogTag(), 1, "upload ark pic drop result,listener is null!");
                return;
            }
            if (!publishModel.isAllFileUploadNoError()) {
                Iterator<T> it = publishModel.getFileList().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    RFWPublishFile rFWPublishFile = (RFWPublishFile) obj;
                    boolean z16 = false;
                    if ((rFWPublishFile instanceof v7.a) && ((v7.a) rFWPublishFile).getUploadErrorInfo() != null) {
                        z16 = true;
                    }
                    if (z16) {
                        break;
                    }
                }
                v7.a aVar2 = obj instanceof v7.a ? (v7.a) obj : null;
                long j3 = (aVar2 == null || (uploadErrorInfo2 = aVar2.getUploadErrorInfo()) == null) ? -1L : uploadErrorInfo2.detailErrCode;
                if (aVar2 != null && (uploadErrorInfo = aVar2.getUploadErrorInfo()) != null) {
                    str = uploadErrorInfo.errMsg;
                }
                aVar.b(j3, str != null ? str : "");
                return;
            }
            if (publishModel.isAllFileUploaded()) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) publishModel.getFileList());
                v7.a aVar3 = firstOrNull instanceof v7.a ? (v7.a) firstOrNull : null;
                if (aVar3 != null) {
                    String urlPath = aVar3.getUrlPath();
                    if (urlPath == null) {
                        urlPath = "";
                    }
                    String fileUUID = aVar3.getFileUUID();
                    aVar.a(urlPath, fileUUID != null ? fileUUID : "");
                    return;
                }
                return;
            }
            QLog.d(getLogTag(), 1, "upload ark pic\uff0cnot all file uploaded,waiting...");
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: t7.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.j(d.this, publishModel);
                }
            }, 100L);
        }
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWUploadDelegate
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void missionDidStart(NTPublishModel publishModel) {
        Intrinsics.checkNotNullParameter(publishModel, "publishModel");
        QLog.d(getLogTag(), 1, "upload ark pic start,model=" + publishModel);
    }

    public final d m() {
        this.publisher.a(new b());
        this.publisher.injectDelegate(this);
        return this;
    }

    public final void n(String filePath, a listener) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.uploadListenerRef = new WeakReference<>(listener);
        NTBatchPublisher.uploadImage$default(this.publisher, filePath, null, 2, null);
    }

    public String toString() {
        return "QZNTArkUploadHelper";
    }
}
