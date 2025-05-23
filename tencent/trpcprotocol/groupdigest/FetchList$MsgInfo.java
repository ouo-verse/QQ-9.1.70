package tencent.trpcprotocol.groupdigest;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class FetchList$MsgInfo extends MessageMicro<FetchList$MsgInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 48, 58, 66, 72, 82, 90}, new String[]{"group_code", "msg_seq", "msg_random", "sender_avatar", "sender_nick", "sender_time", "add_digest_avatar", "add_digest_nick", "add_digest_time", "jump_url", "msg_content"}, new Object[]{0L, 0, 0, "", "", 0, "", "", 0, "", null}, FetchList$MsgInfo.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBUInt32Field msg_seq = PBField.initUInt32(0);
    public final PBUInt32Field msg_random = PBField.initUInt32(0);
    public final PBStringField sender_avatar = PBField.initString("");
    public final PBStringField sender_nick = PBField.initString("");
    public final PBUInt32Field sender_time = PBField.initUInt32(0);
    public final PBStringField add_digest_avatar = PBField.initString("");
    public final PBStringField add_digest_nick = PBField.initString("");
    public final PBUInt32Field add_digest_time = PBField.initUInt32(0);
    public final PBStringField jump_url = PBField.initString("");
    public final PBRepeatMessageField<FetchList$MsgContent> msg_content = PBField.initRepeatMessage(FetchList$MsgContent.class);
}
