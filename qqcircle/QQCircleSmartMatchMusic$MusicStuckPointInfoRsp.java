package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* loaded from: classes29.dex */
public final class QQCircleSmartMatchMusic$MusicStuckPointInfoRsp extends MessageMicro<QQCircleSmartMatchMusic$MusicStuckPointInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "stuckPointInfo"}, new Object[]{null, null}, QQCircleSmartMatchMusic$MusicStuckPointInfoRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<QQCircleSmartMatchMusic$MusicStuckPointInfo> stuckPointInfo = PBField.initRepeatMessage(QQCircleSmartMatchMusic$MusicStuckPointInfo.class);
}
