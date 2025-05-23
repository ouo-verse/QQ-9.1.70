package tencent.im.s2c.msgtype0x210.submsgtype0x65;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x65$MsgBody extends MessageMicro<SubMsgType0x65$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_cmd", "msg_expired_pkg"}, new Object[]{0, null}, SubMsgType0x65$MsgBody.class);
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    public SubMsgType0x65$MsgExpiredPkg msg_expired_pkg = new MessageMicro<SubMsgType0x65$MsgExpiredPkg>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x65.SubMsgType0x65$MsgExpiredPkg
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_expire_pkg;
        public final PBBytesField bytes_predown_pkg;
        public final PBUInt32Field uint32_platform = PBField.initUInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_platform", "bytes_expire_pkg", "bytes_predown_pkg"}, new Object[]{0, byteStringMicro, byteStringMicro}, SubMsgType0x65$MsgExpiredPkg.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_expire_pkg = PBField.initBytes(byteStringMicro);
            this.bytes_predown_pkg = PBField.initBytes(byteStringMicro);
        }
    };
}
