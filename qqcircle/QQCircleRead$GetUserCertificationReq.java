package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRead$GetUserCertificationReq extends MessageMicro<QQCircleRead$GetUserCertificationReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40}, new String[]{"extInfo", "flag", "hostUin", "needNoPass", "needDetail"}, new Object[]{null, 0, "", 0, 0}, QQCircleRead$GetUserCertificationReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBInt32Field flag = PBField.initInt32(0);
    public final PBStringField hostUin = PBField.initString("");
    public final PBInt32Field needNoPass = PBField.initInt32(0);
    public final PBInt32Field needDetail = PBField.initInt32(0);
}
