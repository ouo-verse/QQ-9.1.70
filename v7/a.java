package v7;

import android.text.TextUtils;
import com.tencent.biz.richframework.publish.base.RFWPublishFile;
import com.tencent.biz.richframework.publish.nt.model.media.NTPublishImage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.BatchUploadTask;
import com.tencent.qqnt.kernel.nativeinterface.IndexNode;
import com.tencent.qqnt.kernel.nativeinterface.MsgInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgInfoBody;
import com.tencent.qqnt.kernel.nativeinterface.PictureInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0016\u0018\u0000 \u00152\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0014\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R$\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\r\u00a8\u0006\u0016"}, d2 = {"Lv7/a;", "Lcom/tencent/biz/richframework/publish/nt/model/media/NTPublishImage;", "Lcom/tencent/qqnt/kernel/nativeinterface/BatchUploadTask;", "task", "", "c", "", "getLogTag", "d", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setUrlPath", "(Ljava/lang/String;)V", "urlPath", "e", "a", "setFileUUID", "fileUUID", "filePath", "<init>", "f", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public class a extends NTPublishImage {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String urlPath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String fileUUID;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String filePath) {
        super(filePath);
        Intrinsics.checkNotNullParameter(filePath, "filePath");
    }

    /* renamed from: a, reason: from getter */
    public final String getFileUUID() {
        return this.fileUUID;
    }

    /* renamed from: b, reason: from getter */
    public final String getUrlPath() {
        return this.urlPath;
    }

    @Override // com.tencent.biz.richframework.publish.base.RFWPublishFile
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void updateFileAfterUpload(BatchUploadTask task) {
        String str;
        Object firstOrNull;
        MsgInfoBody msgInfoBody;
        IndexNode indexNode;
        ArrayList<MsgInfoBody> arrayList;
        Object firstOrNull2;
        PictureInfo pictureInfo;
        Intrinsics.checkNotNullParameter(task, "task");
        MsgInfo msgInfo = getMsgInfo();
        String str2 = null;
        if (msgInfo != null && (arrayList = msgInfo.msgInfoBody) != null) {
            firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
            MsgInfoBody msgInfoBody2 = (MsgInfoBody) firstOrNull2;
            if (msgInfoBody2 != null && (pictureInfo = msgInfoBody2.pictureInfo) != null) {
                str = pictureInfo.urlPath;
                this.urlPath = str;
                ArrayList<MsgInfoBody> arrayList2 = task.msgInfo.msgInfoBody;
                Intrinsics.checkNotNullExpressionValue(arrayList2, "task.msgInfo.msgInfoBody");
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList2);
                msgInfoBody = (MsgInfoBody) firstOrNull;
                if (msgInfoBody != null && (indexNode = msgInfoBody.indexNode) != null) {
                    str2 = indexNode.fileUuid;
                }
                this.fileUUID = str2;
                if (TextUtils.isEmpty(this.urlPath) && !TextUtils.isEmpty(this.fileUUID)) {
                    QLog.d("QZNTArkUploadImage", 1, "upload ark pic:url=" + this.urlPath + ",fileUUID=" + this.fileUUID);
                    setState(RFWPublishFile.FileState.UPLOADED);
                    return;
                }
                setState(RFWPublishFile.FileState.ERROR);
            }
        }
        str = null;
        this.urlPath = str;
        ArrayList<MsgInfoBody> arrayList22 = task.msgInfo.msgInfoBody;
        Intrinsics.checkNotNullExpressionValue(arrayList22, "task.msgInfo.msgInfoBody");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList22);
        msgInfoBody = (MsgInfoBody) firstOrNull;
        if (msgInfoBody != null) {
            str2 = indexNode.fileUuid;
        }
        this.fileUUID = str2;
        if (TextUtils.isEmpty(this.urlPath)) {
        }
        setState(RFWPublishFile.FileState.ERROR);
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWLog
    public String getLogTag() {
        return "QZNTArkUploadImage";
    }
}
