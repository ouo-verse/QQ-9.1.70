package qqcircle;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRelation$StInterFollowListReq extends MessageMicro<QQCircleRelation$StInterFollowListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"extInfo", "leftRightKey", "rightRightKey", WidgetCacheConstellationData.NUM, "attachInfo"}, new Object[]{null, null, null, 0, ""}, QQCircleRelation$StInterFollowListReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public QQCircleRelation$FollowListKeyType leftRightKey = new MessageMicro<QQCircleRelation$FollowListKeyType>() { // from class: qqcircle.QQCircleRelation$FollowListKeyType
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"userId", "keyType"}, new Object[]{"", 0}, QQCircleRelation$FollowListKeyType.class);
        public final PBStringField userId = PBField.initString("");
        public final PBInt32Field keyType = PBField.initInt32(0);
    };
    public QQCircleRelation$FollowListKeyType rightRightKey = new MessageMicro<QQCircleRelation$FollowListKeyType>() { // from class: qqcircle.QQCircleRelation$FollowListKeyType
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"userId", "keyType"}, new Object[]{"", 0}, QQCircleRelation$FollowListKeyType.class);
        public final PBStringField userId = PBField.initString("");
        public final PBInt32Field keyType = PBField.initInt32(0);
    };
    public final PBInt32Field num = PBField.initInt32(0);
    public final PBStringField attachInfo = PBField.initString("");
}
