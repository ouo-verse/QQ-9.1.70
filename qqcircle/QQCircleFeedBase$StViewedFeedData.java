package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StViewedFeedData extends MessageMicro<QQCircleFeedBase$StViewedFeedData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"feeds"}, new Object[]{null}, QQCircleFeedBase$StViewedFeedData.class);
    public final PBRepeatMessageField<QQCircleFeedBase$ViewedFeed> feeds = PBField.initRepeatMessage(QQCircleFeedBase$ViewedFeed.class);
}
