package tencent.im.msg.hummer.resv;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class generalflags$BotMetaData extends MessageMicro<generalflags$BotMetaData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40}, new String[]{"uint32_msg_src", "uint64_inline_bot_appid", "uint32_msg_type", "source_guild", "bool_show_msg_setting"}, new Object[]{0, 0L, 0, null, Boolean.FALSE}, generalflags$BotMetaData.class);
    public final PBUInt32Field uint32_msg_src = PBField.initUInt32(0);
    public final PBUInt64Field uint64_inline_bot_appid = PBField.initUInt64(0);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public generalflags$Guild source_guild = new generalflags$Guild();
    public final PBBoolField bool_show_msg_setting = PBField.initBool(false);
}
