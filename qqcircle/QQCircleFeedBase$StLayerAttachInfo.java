package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StLayerAttachInfo extends MessageMicro<QQCircleFeedBase$StLayerAttachInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"feedList"}, new Object[]{null}, QQCircleFeedBase$StLayerAttachInfo.class);
    public final PBRepeatMessageField<QQCircleFeedBase$StSimpleFeed> feedList = PBField.initRepeatMessage(QQCircleFeedBase$StSimpleFeed.class);
}
