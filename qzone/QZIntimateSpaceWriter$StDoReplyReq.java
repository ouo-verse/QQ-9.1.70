package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceWriter$StDoReplyReq extends MessageMicro<QZIntimateSpaceWriter$StDoReplyReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42}, new String[]{"ext_info", "reply_type", "reply", "comment", "feed"}, new Object[]{null, 0, null, null, null}, QZIntimateSpaceWriter$StDoReplyReq.class);
    public QZoneBaseCommon$StCommonExt ext_info = new QZoneBaseCommon$StCommonExt();
    public final PBUInt32Field reply_type = PBField.initUInt32(0);
    public QZoneBaseMeta$StReply reply = new QZoneBaseMeta$StReply();
    public QZoneBaseMeta$StComment comment = new QZoneBaseMeta$StComment();
    public QZoneBaseMeta$StFeed feed = new QZoneBaseMeta$StFeed();
}
