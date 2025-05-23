package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceWriter$StDoCommentReq extends MessageMicro<QZIntimateSpaceWriter$StDoCommentReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"ext_info", "comment_type", "comment", "feed"}, new Object[]{null, 0, null, null}, QZIntimateSpaceWriter$StDoCommentReq.class);
    public QZoneBaseCommon$StCommonExt ext_info = new QZoneBaseCommon$StCommonExt();
    public final PBUInt32Field comment_type = PBField.initUInt32(0);
    public QZoneBaseMeta$StComment comment = new QZoneBaseMeta$StComment();
    public QZoneBaseMeta$StFeed feed = new QZoneBaseMeta$StFeed();
}
