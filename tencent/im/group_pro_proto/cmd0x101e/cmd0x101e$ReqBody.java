package tencent.im.group_pro_proto.cmd0x101e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x101e$ReqBody extends MessageMicro<cmd0x101e$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48, 56}, new String[]{"guild_id", "channel_id", "message_seqno", "emoji_id", "emoji_type", "task_id", "task_type"}, new Object[]{0L, 0L, 0L, "", 0L, 0L, 0L}, cmd0x101e$ReqBody.class);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBUInt64Field message_seqno = PBField.initUInt64(0);
    public final PBStringField emoji_id = PBField.initString("");
    public final PBUInt64Field emoji_type = PBField.initUInt64(0);
    public final PBUInt64Field task_id = PBField.initUInt64(0);
    public final PBUInt64Field task_type = PBField.initUInt64(0);
}
