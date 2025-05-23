package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StVideo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleVideourlexchange$StGetVideoAdaptReq extends MessageMicro<QQCircleVideourlexchange$StGetVideoAdaptReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"extInfo", "from", "userID", "videos"}, new Object[]{null, 0, "", null}, QQCircleVideourlexchange$StGetVideoAdaptReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBStringField userID = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudMeta$StVideo> videos = PBField.initRepeatMessage(FeedCloudMeta$StVideo.class);
}
