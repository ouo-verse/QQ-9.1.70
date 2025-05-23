package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$LightInteractionBusiData extends MessageMicro<QQCircleFeedBase$LightInteractionBusiData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"polyInfo", "polyInfos", "splitItemText", "urgeUpdateInfo", "hostPushDesc", "hostCancelPushDesc"}, new Object[]{null, null, "", null, "", ""}, QQCircleFeedBase$LightInteractionBusiData.class);
    public QQCircleFeedBase$StPolyLike polyInfo = new QQCircleFeedBase$StPolyLike();
    public final PBRepeatMessageField<QQCircleFeedBase$StPolyLike> polyInfos = PBField.initRepeatMessage(QQCircleFeedBase$StPolyLike.class);
    public final PBStringField splitItemText = PBField.initString("");
    public QQCircleFeedBase$StUrgeUpdateInfo urgeUpdateInfo = new QQCircleFeedBase$StUrgeUpdateInfo();
    public final PBStringField hostPushDesc = PBField.initString("");
    public final PBStringField hostCancelPushDesc = PBField.initString("");
}
