package qzonemoment;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZMomentReader$StGetFeedListRsp extends MessageMicro<QZMomentReader$StGetFeedListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42}, new String[]{"extInfo", "vecFeed", "isFinish", QCircleAlphaUserReporter.KEY_USER, "feedAttchInfo"}, new Object[]{null, null, 0, null, ""}, QZMomentReader$StGetFeedListRsp.class);
    public QZMomentCommon$StCommonExt extInfo = new QZMomentCommon$StCommonExt();
    public final PBRepeatMessageField<QZMomentMeta$StFeed> vecFeed = PBField.initRepeatMessage(QZMomentMeta$StFeed.class);
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public QZMomentMeta$StUser user = new QZMomentMeta$StUser();
    public final PBStringField feedAttchInfo = PBField.initString("");
}
