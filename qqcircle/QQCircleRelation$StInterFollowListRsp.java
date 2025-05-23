package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StRelationInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRelation$StInterFollowListRsp extends MessageMicro<QQCircleRelation$StInterFollowListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42}, new String[]{"extInfo", "relationInfo", "total", "hasMore", "attachInfo"}, new Object[]{null, null, 0L, 0, ""}, QQCircleRelation$StInterFollowListRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<FeedCloudMeta$StRelationInfo> relationInfo = PBField.initRepeatMessage(FeedCloudMeta$StRelationInfo.class);
    public final PBInt64Field total = PBField.initInt64(0);
    public final PBInt32Field hasMore = PBField.initInt32(0);
    public final PBStringField attachInfo = PBField.initString("");
}
