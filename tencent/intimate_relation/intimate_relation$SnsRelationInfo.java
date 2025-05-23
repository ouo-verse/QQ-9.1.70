package tencent.intimate_relation;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class intimate_relation$SnsRelationInfo extends MessageMicro<intimate_relation$SnsRelationInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"intimate_list"}, new Object[]{null}, intimate_relation$SnsRelationInfo.class);
    public final PBRepeatMessageField<intimate_relation$IntimateInfo> intimate_list = PBField.initRepeatMessage(intimate_relation$IntimateInfo.class);
}
