package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StUserTypeLabel extends MessageMicro<QQCircleFeedBase$StUserTypeLabel> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"LabelType", "text"}, new Object[]{1, ""}, QQCircleFeedBase$StUserTypeLabel.class);
    public final PBEnumField LabelType = PBField.initEnum(1);
    public final PBStringField text = PBField.initString("");
}
