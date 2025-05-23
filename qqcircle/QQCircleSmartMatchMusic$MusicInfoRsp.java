package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleSmartMatchMusic$MusicInfoRsp extends MessageMicro<QQCircleSmartMatchMusic$MusicInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "musicListInfo"}, new Object[]{null, null}, QQCircleSmartMatchMusic$MusicInfoRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<QQCircleSmartMatchMusic$MusicInfo> musicListInfo = PBField.initRepeatMessage(QQCircleSmartMatchMusic$MusicInfo.class);
}
