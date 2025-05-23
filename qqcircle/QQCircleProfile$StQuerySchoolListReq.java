package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QQCircleProfile$StQuerySchoolListReq extends MessageMicro<QQCircleProfile$StQuerySchoolListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"keyword", "count"}, new Object[]{"", 0}, QQCircleProfile$StQuerySchoolListReq.class);
    public final PBStringField keyword = PBField.initString("");
    public final PBUInt32Field count = PBField.initUInt32(0);
}
