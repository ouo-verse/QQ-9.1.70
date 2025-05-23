package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* loaded from: classes29.dex */
public final class QQCircleSmartMatchMusic$MusicStuckPointInfoReq extends MessageMicro<QQCircleSmartMatchMusic$MusicStuckPointInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "musicMIDList"}, new Object[]{null, ""}, QQCircleSmartMatchMusic$MusicStuckPointInfoReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatField<String> musicMIDList = PBField.initRepeat(PBStringField.__repeatHelper__);
}
