package tencent.im.oidb.ranklist_comm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class ranklist_comm$ExtraParam extends MessageMicro<ranklist_comm$ExtraParam> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"param_key", "param_value", "param_type"}, new Object[]{"", 0, 0}, ranklist_comm$ExtraParam.class);
    public final PBStringField param_key = PBField.initString("");
    public final PBInt32Field param_value = PBField.initInt32(0);
    public final PBInt32Field param_type = PBField.initInt32(0);
}
