package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRead$GetFollowTagListReq extends MessageMicro<QQCircleRead$GetFollowTagListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40}, new String[]{"extInfo", "hostUin", "attachInfo", "count", "from"}, new Object[]{null, "", "", 0, 0}, QQCircleRead$GetFollowTagListReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBStringField hostUin = PBField.initString("");
    public final PBStringField attachInfo = PBField.initString("");
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBInt32Field from = PBField.initInt32(0);
}
