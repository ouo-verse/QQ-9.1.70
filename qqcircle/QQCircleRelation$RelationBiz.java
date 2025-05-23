package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRelation$RelationBiz extends MessageMicro<QQCircleRelation$RelationBiz> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 50}, new String[]{"timestamp", "nick", "sign", "qqRelation", "certification", "logo"}, new Object[]{0L, "", "", 0, 0, ""}, QQCircleRelation$RelationBiz.class);
    public final PBUInt64Field timestamp = PBField.initUInt64(0);
    public final PBStringField nick = PBField.initString("");
    public final PBStringField sign = PBField.initString("");
    public final PBInt32Field qqRelation = PBField.initInt32(0);
    public final PBInt32Field certification = PBField.initInt32(0);
    public final PBStringField logo = PBField.initString("");
}
