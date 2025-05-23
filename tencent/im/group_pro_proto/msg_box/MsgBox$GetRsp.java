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
public final class MsgBox$GetRsp extends MessageMicro<MsgBox$GetRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<MsgBox$ChannelEvent> channel_events;
    public final PBBytesField cookie;
    public final PBUInt64Field err_code = PBField.initUInt64(0);
    public final PBBytesField err_msg;

    static {
        String[] strArr = {CheckForwardServlet.KEY_ERR_CODE, "err_msg", "channel_events", "cookie"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, strArr, new Object[]{0L, byteStringMicro, null, byteStringMicro}, MsgBox$GetRsp.class);
    }

    public MsgBox$GetRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.err_msg = PBField.initBytes(byteStringMicro);
        this.channel_events = PBField.initRepeatMessage(MsgBox$ChannelEvent.class);
        this.cookie = PBField.initBytes(byteStringMicro);
    }
}
