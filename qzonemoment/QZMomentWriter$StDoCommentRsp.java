package qzonemoment;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZMomentWriter$StDoCommentRsp extends MessageMicro<QZMomentWriter$StDoCommentRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "comment"}, new Object[]{null, null}, QZMomentWriter$StDoCommentRsp.class);
    public QZMomentCommon$StCommonExt extInfo = new QZMomentCommon$StCommonExt();
    public QZMomentMeta$StComment comment = new QZMomentMeta$StComment();
}
