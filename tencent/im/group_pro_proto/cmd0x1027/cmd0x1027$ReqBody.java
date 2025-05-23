package tencent.im.group_pro_proto.cmd0x1027;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x1027$ReqBody extends MessageMicro<cmd0x1027$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50}, new String[]{"guild_id", "channel_id", "msg_seqno", "emoji_type", "emoji_id", "cookie"}, new Object[]{0L, 0L, 0L, 0, "", ""}, cmd0x1027$ReqBody.class);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBUInt64Field msg_seqno = PBField.initUInt64(0);
    public final PBUInt32Field emoji_type = PBField.initUInt32(0);
    public final PBStringField emoji_id = PBField.initString("");
    public final PBStringField cookie = PBField.initString("");
}
