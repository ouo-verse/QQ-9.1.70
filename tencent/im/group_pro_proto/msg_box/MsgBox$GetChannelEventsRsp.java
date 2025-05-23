package tencent.im.group_pro_proto.msg_box;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MsgBox$GetChannelEventsRsp extends MessageMicro<MsgBox$GetChannelEventsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{CheckForwardServlet.KEY_ERR_CODE, "err_msg", "guilds"}, new Object[]{0L, ByteStringMicro.EMPTY, null}, MsgBox$GetChannelEventsRsp.class);
    public final PBUInt64Field err_code = PBField.initUInt64(0);
    public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<MsgBox$Guild> guilds = PBField.initRepeatMessage(MsgBox$Guild.class);
}
