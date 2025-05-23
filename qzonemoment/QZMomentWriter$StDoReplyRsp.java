package qzonemoment;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZMomentWriter$StDoReplyRsp extends MessageMicro<QZMomentWriter$StDoReplyRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "reply"}, new Object[]{null, null}, QZMomentWriter$StDoReplyRsp.class);
    public QZMomentCommon$StCommonExt extInfo = new QZMomentCommon$StCommonExt();
    public QZMomentMeta$StReply reply = new QZMomentMeta$StReply();
}
