package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRelation$RelationTopItem extends MessageMicro<QQCircleRelation$RelationTopItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uin", "count"}, new Object[]{0L, 0L}, QQCircleRelation$RelationTopItem.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBInt64Field count = PBField.initInt64(0);
}
