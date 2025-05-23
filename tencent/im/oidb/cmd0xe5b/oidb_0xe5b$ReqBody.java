package tencent.im.oidb.cmd0xe5b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe5b$ReqBody extends MessageMicro<oidb_0xe5b$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint64_uin", "rpt_achievement_id", "uint32_max_count", "bool_req_achievement_content"}, new Object[]{0L, 0, 0, Boolean.FALSE}, oidb_0xe5b$ReqBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBRepeatField<Integer> rpt_achievement_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_max_count = PBField.initUInt32(0);
    public final PBBoolField bool_req_achievement_content = PBField.initBool(false);
}
