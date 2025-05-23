package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleCounter$GroupInfoRsp extends MessageMicro<QQCircleCounter$GroupInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"extInfo", "groupinfo", "nextTime", "iconVersion"}, new Object[]{null, null, 0, 0}, QQCircleCounter$GroupInfoRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<QQCircleCounter$GroupInfo> groupinfo = PBField.initRepeatMessage(QQCircleCounter$GroupInfo.class);
    public final PBUInt32Field nextTime = PBField.initUInt32(0);
    public final PBEnumField iconVersion = PBField.initEnum(0);
}
