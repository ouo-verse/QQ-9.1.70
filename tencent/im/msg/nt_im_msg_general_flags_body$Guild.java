package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nt_im_msg_general_flags_body$Guild extends MessageMicro<nt_im_msg_general_flags_body$Guild> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"guild_id", "guild_name"}, new Object[]{0L, ""}, nt_im_msg_general_flags_body$Guild.class);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBStringField guild_name = PBField.initString("");
}
