package tencent.im.oidb.cmd0xecf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xecf$ReqBody extends MessageMicro<oidb_0xecf$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40}, new String[]{"uint64_uin", "uint64_comment_num", "uint64_quest_time", "str_quest_id", "uint64_no_cache"}, new Object[]{0L, 0L, 0L, "", 0L}, oidb_0xecf$ReqBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_comment_num = PBField.initUInt64(0);
    public final PBUInt64Field uint64_quest_time = PBField.initUInt64(0);
    public final PBStringField str_quest_id = PBField.initString("");
    public final PBUInt64Field uint64_no_cache = PBField.initUInt64(0);
}
