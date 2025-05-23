package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceReader$RelatationInfo extends MessageMicro<QZIntimateSpaceReader$RelatationInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"type", "users"}, new Object[]{0, null}, QZIntimateSpaceReader$RelatationInfo.class);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBRepeatMessageField<QZIntimateSpaceReader$RelatedUser> users = PBField.initRepeatMessage(QZIntimateSpaceReader$RelatedUser.class);
}
