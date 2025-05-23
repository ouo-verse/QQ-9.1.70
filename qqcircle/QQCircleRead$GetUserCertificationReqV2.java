package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRead$GetUserCertificationReqV2 extends MessageMicro<QQCircleRead$GetUserCertificationReqV2> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40}, new String[]{"extInfo", "certFlag", "hostUin", "statusFlag", "needDetail"}, new Object[]{null, 0, "", 0, 0}, QQCircleRead$GetUserCertificationReqV2.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBInt32Field certFlag = PBField.initInt32(0);
    public final PBStringField hostUin = PBField.initString("");
    public final PBInt32Field statusFlag = PBField.initInt32(0);
    public final PBInt32Field needDetail = PBField.initInt32(0);
}
