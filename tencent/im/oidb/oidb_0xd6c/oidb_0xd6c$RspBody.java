package tencent.im.oidb.oidb_0xd6c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xd6c$RspBody extends MessageMicro<oidb_0xd6c$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"str_gift_url", "str_custom_url", "str_desc", "str_send_times"}, new Object[]{"", "", "", 0}, oidb_0xd6c$RspBody.class);
    public final PBRepeatField<String> str_gift_url = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField str_custom_url = PBField.initString("");
    public final PBStringField str_desc = PBField.initString("");
    public final PBInt32Field str_send_times = PBField.initInt32(0);
}
