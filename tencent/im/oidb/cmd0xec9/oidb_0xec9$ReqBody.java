package tencent.im.oidb.cmd0xec9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xec9$ReqBody extends MessageMicro<oidb_0xec9$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40}, new String[]{"str_quest_id", "uint64_uin", "uint64_act_type", "str_like_key", "uint64_quest_time"}, new Object[]{"", 0L, 0L, "", 0L}, oidb_0xec9$ReqBody.class);
    public final PBStringField str_quest_id = PBField.initString("");
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_act_type = PBField.initUInt64(0);
    public final PBStringField str_like_key = PBField.initString("");
    public final PBUInt64Field uint64_quest_time = PBField.initUInt64(0);
}
