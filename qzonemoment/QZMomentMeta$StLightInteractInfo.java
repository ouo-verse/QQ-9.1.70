package qzonemoment;

import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZMomentMeta$StLightInteractInfo extends MessageMicro<QZMomentMeta$StLightInteractInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40}, new String[]{QCircleAlphaUserReporter.KEY_USER, "relation", "count", MessageForQCircleFeed.MSG_QCIRCLE_FEED_LEY_BUSI_DATA, "opTime"}, new Object[]{null, null, 0, ByteStringMicro.EMPTY, 0}, QZMomentMeta$StLightInteractInfo.class);
    public QZMomentMeta$StUser user = new QZMomentMeta$StUser();
    public QZMomentMeta$StRelationInfo relation = new QZMomentMeta$StRelationInfo();
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field opTime = PBField.initUInt32(0);
}
