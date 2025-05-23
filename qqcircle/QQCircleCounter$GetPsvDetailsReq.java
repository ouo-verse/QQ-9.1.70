package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCircleCounter$GetPsvDetailsReq extends MessageMicro<QQCircleCounter$GetPsvDetailsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"uid", "from"}, new Object[]{"", 0}, QQCircleCounter$GetPsvDetailsReq.class);
    public final PBStringField uid = PBField.initString("");
    public final PBEnumField from = PBField.initEnum(0);
}
