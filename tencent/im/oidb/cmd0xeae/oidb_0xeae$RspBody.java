package tencent.im.oidb.cmd0xeae;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xeae$RspBody extends MessageMicro<oidb_0xeae$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uint64_black_times", "str_black_times_used_up_tips", "str_black_times_used_up_title", "str_black_times_tips"}, new Object[]{0L, "", "", ""}, oidb_0xeae$RspBody.class);
    public final PBUInt64Field uint64_black_times = PBField.initUInt64(0);
    public final PBStringField str_black_times_used_up_tips = PBField.initString("");
    public final PBStringField str_black_times_used_up_title = PBField.initString("");
    public final PBStringField str_black_times_tips = PBField.initString("");
}
