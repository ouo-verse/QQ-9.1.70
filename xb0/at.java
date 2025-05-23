package xb0;

import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.events.QFSPushRanCommentUpdateEvent;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StComment;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0014\u00a8\u0006\f"}, d2 = {"Lxb0/at;", "Lcom/tencent/biz/qqcircle/share/QCircleBaseShareOperation;", "", "G", "", "y", "Lcom/tencent/biz/qqcircle/share/QCircleBaseShareOperation$a;", "builder", "<init>", "(Lcom/tencent/biz/qqcircle/share/QCircleBaseShareOperation$a;)V", "u", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class at extends QCircleBaseShareOperation {
    public at(@Nullable QCircleBaseShareOperation.a aVar) {
        super(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        String str;
        boolean z16;
        FeedCloudMeta$StComment feedCloudMeta$StComment;
        PBStringField pBStringField;
        QCircleShareInfo t16 = t();
        if (t16 != null && (feedCloudMeta$StComment = t16.comment) != null && (pBStringField = feedCloudMeta$StComment.f398447id) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSPushRanCommentUpdateEvent(str, 1, true));
        } else {
            QLog.e("QFSPushRanCommentOperation", 1, "[realOperate] commentId is null:" + str);
        }
        d(QCircleDaTongConstant.ElementParamValue.HOTCOMMENT, null);
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return false;
    }
}
