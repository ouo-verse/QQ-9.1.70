package tencent.im.oidb.cmd0x112e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x112e$ClickButtonRequest extends MessageMicro<oidb_0x112e$ClickButtonRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50}, new String[]{"guild_id", "channel_id", "bot_appid", "msg_seq", "button_id", "callback_data"}, new Object[]{0L, 0L, 0L, 0L, "", ""}, oidb_0x112e$ClickButtonRequest.class);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBUInt64Field bot_appid = PBField.initUInt64(0);
    public final PBUInt64Field msg_seq = PBField.initUInt64(0);
    public final PBStringField button_id = PBField.initString("");
    public final PBStringField callback_data = PBField.initString("");
}
