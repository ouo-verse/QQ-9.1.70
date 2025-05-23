package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleSmartMatchMusic$IsCollectedRsp extends MessageMicro<QQCircleSmartMatchMusic$IsCollectedRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"collects"}, new Object[]{null}, QQCircleSmartMatchMusic$IsCollectedRsp.class);
    public final PBRepeatMessageField<QQCircleSmartMatchMusic$CollectInfo> collects = PBField.initRepeatMessage(QQCircleSmartMatchMusic$CollectInfo.class);
}
