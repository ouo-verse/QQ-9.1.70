package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRead$GetCircleTagInfoReq extends MessageMicro<QQCircleRead$GetCircleTagInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"extInfo", "tagNameList", "needJoinNum", "needFollowStatus"}, new Object[]{null, "", 0, 0}, QQCircleRead$GetCircleTagInfoReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatField<String> tagNameList = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBInt32Field needJoinNum = PBField.initInt32(0);
    public final PBInt32Field needFollowStatus = PBField.initInt32(0);
}
