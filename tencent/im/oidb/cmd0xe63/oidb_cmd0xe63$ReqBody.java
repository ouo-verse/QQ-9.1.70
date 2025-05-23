package tencent.im.oidb.cmd0xe63;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xe63$ReqBody extends MessageMicro<oidb_cmd0xe63$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_req_type", "rpt_uint64_uin_for_check", "bool_only_smart_status"}, new Object[]{0, 0L, Boolean.FALSE}, oidb_cmd0xe63$ReqBody.class);
    public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
    public final PBRepeatField<Long> rpt_uint64_uin_for_check = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBBoolField bool_only_smart_status = PBField.initBool(false);
}
