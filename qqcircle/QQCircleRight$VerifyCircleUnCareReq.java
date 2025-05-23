package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRight$VerifyCircleUnCareReq extends MessageMicro<QQCircleRight$VerifyCircleUnCareReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42}, new String[]{"extInfo", "uin", "rightType", "verifyType", "uid"}, new Object[]{null, 0, 0, 0, ""}, QQCircleRight$VerifyCircleUnCareReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBUInt32Field uin = PBField.initUInt32(0);
    public final PBEnumField rightType = PBField.initEnum(0);
    public final PBEnumField verifyType = PBField.initEnum(0);
    public final PBStringField uid = PBField.initString("");
}
