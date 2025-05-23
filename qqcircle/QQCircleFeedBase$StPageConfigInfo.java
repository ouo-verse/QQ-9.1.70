package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon$Entry;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StPageConfigInfo extends MessageMicro<QQCircleFeedBase$StPageConfigInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"tagPageConfig"}, new Object[]{null}, QQCircleFeedBase$StPageConfigInfo.class);
    public final PBRepeatMessageField<FeedCloudCommon$Entry> tagPageConfig = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
}
