package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StCommCountStore extends MessageMicro<QQCircleFeedBase$StCommCountStore> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"polyInfos"}, new Object[]{null}, QQCircleFeedBase$StCommCountStore.class);
    public final PBRepeatMessageField<QQCircleFeedBase$StPolyInfoData> polyInfos = PBField.initRepeatMessage(QQCircleFeedBase$StPolyInfoData.class);
}
