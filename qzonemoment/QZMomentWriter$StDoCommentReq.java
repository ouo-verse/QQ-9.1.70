package qzonemoment;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZMomentWriter$StDoCommentReq extends MessageMicro<QZMomentWriter$StDoCommentReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"extInfo", "commentType", "comment", "feed"}, new Object[]{null, 0, null, null}, QZMomentWriter$StDoCommentReq.class);
    public QZMomentCommon$StCommonExt extInfo = new QZMomentCommon$StCommonExt();
    public final PBUInt32Field commentType = PBField.initUInt32(0);
    public QZMomentMeta$StComment comment = new QZMomentMeta$StComment();
    public QZMomentMeta$StFeed feed = new QZMomentMeta$StFeed();
}
