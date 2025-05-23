package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StPolyInfoData extends MessageMicro<QQCircleFeedBase$StPolyInfoData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"info", "orderID", "lastRewardOpTime"}, new Object[]{null, "", 0L}, QQCircleFeedBase$StPolyInfoData.class);
    public QQCircleFeedBase$StPolyLike info = new QQCircleFeedBase$StPolyLike();
    public final PBStringField orderID = PBField.initString("");
    public final PBUInt64Field lastRewardOpTime = PBField.initUInt64(0);
}
