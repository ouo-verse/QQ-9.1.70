package tencent.im.oidb.oidb_0x1250;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$CommonBody;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x1250$ReqBody extends MessageMicro<oidb_0x1250$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
    public final PBEnumField date_type = PBField.initEnum(1);
    public final PBBoolField bool_qzone_dna = PBField.initBool(false);
    public final PBRepeatMessageField<oidb_0xcf4$CommonBody> rpt_msg_common_reqbody = PBField.initRepeatMessage(oidb_0xcf4$CommonBody.class);
    public final PBBoolField bool_new_dna = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{16, 24, 32, 42, 48}, new String[]{"uint64_to_uin", "date_type", "bool_qzone_dna", "rpt_msg_common_reqbody", "bool_new_dna"}, new Object[]{0L, 1, bool, null, bool}, oidb_0x1250$ReqBody.class);
    }
}
