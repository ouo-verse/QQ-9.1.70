package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xccb$GuildMsgInfo extends MessageMicro<cmd0xccb$GuildMsgInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"msg_seq", "roam_flag"}, new Object[]{0L, 0}, cmd0xccb$GuildMsgInfo.class);
    public final PBUInt64Field msg_seq = PBField.initUInt64(0);
    public final PBUInt32Field roam_flag = PBField.initUInt32(0);
}
