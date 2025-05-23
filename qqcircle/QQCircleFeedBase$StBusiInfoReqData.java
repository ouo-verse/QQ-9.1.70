package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StGPSV2;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StBusiInfoReqData extends MessageMicro<QQCircleFeedBase$StBusiInfoReqData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"gpsInfo", "busiMap", "rewardInfo", "entrySchema"}, new Object[]{null, null, 0L, ""}, QQCircleFeedBase$StBusiInfoReqData.class);
    public FeedCloudMeta$StGPSV2 gpsInfo = new FeedCloudMeta$StGPSV2();
    public final PBRepeatMessageField<FeedCloudCommon$Entry> busiMap = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    public final PBRepeatField<Long> rewardInfo = PBField.initRepeat(PBInt64Field.__repeatHelper__);
    public final PBStringField entrySchema = PBField.initString("");
}
