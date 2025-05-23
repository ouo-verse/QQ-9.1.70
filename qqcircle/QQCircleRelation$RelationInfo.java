package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRelation$RelationInfo extends MessageMicro<QQCircleRelation$RelationInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uin", "relation"}, new Object[]{0L, 0}, QQCircleRelation$RelationInfo.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field relation = PBField.initUInt32(0);
}
