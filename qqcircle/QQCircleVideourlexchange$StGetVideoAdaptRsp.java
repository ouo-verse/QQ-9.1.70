package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StVideo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleVideourlexchange$StGetVideoAdaptRsp extends MessageMicro<QQCircleVideourlexchange$StGetVideoAdaptRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "videos"}, new Object[]{null, null}, QQCircleVideourlexchange$StGetVideoAdaptRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<FeedCloudMeta$StVideo> videos = PBField.initRepeatMessage(FeedCloudMeta$StVideo.class);
}
