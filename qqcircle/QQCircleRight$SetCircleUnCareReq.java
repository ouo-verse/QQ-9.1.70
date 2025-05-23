package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRight$SetCircleUnCareReq extends MessageMicro<QQCircleRight$SetCircleUnCareReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40, 48}, new String[]{"extInfo", "uin", "operType", "strUid", "rightType", "src"}, new Object[]{null, 0, 1, "", 0, 0}, QQCircleRight$SetCircleUnCareReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBUInt32Field uin = PBField.initUInt32(0);
    public final PBEnumField operType = PBField.initEnum(1);
    public final PBStringField strUid = PBField.initString("");
    public final PBEnumField rightType = PBField.initEnum(0);
    public final PBInt32Field src = PBField.initInt32(0);
}
