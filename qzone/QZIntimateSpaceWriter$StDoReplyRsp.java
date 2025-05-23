package qzone;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceWriter$StDoReplyRsp extends MessageMicro<QZIntimateSpaceWriter$StDoReplyRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"ext_info", "reply"}, new Object[]{null, null}, QZIntimateSpaceWriter$StDoReplyRsp.class);
    public QZoneBaseCommon$StCommonExt ext_info = new QZoneBaseCommon$StCommonExt();
    public QZoneBaseMeta$StReply reply = new QZoneBaseMeta$StReply();
}
