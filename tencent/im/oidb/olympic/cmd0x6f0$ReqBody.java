package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x6f0$ReqBody extends MessageMicro<cmd0x6f0$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"rpt_uin_list", "uint64_req_torch_info", "enum_req_source"}, new Object[]{0L, 0L, 1}, cmd0x6f0$ReqBody.class);
    public final PBRepeatField<Long> rpt_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field uint64_req_torch_info = PBField.initUInt64(0);
    public final PBEnumField enum_req_source = PBField.initEnum(1);
}
