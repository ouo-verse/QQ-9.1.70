package tencent.im.oidb;

import appoint.define.appoint_define$AppointInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x7db$RspBody extends MessageMicro<cmd0x7db$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"str_wording", "msg_appoint_info", "bytes_SigC2C", "uint32_appoint_action"}, new Object[]{"", null, ByteStringMicro.EMPTY, 0}, cmd0x7db$RspBody.class);
    public final PBStringField str_wording = PBField.initString("");
    public appoint_define$AppointInfo msg_appoint_info = new appoint_define$AppointInfo();
    public final PBBytesField bytes_SigC2C = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_appoint_action = PBField.initUInt32(0);
}
