package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg_body$QQWalletAioBody extends MessageMicro<im_msg_body$QQWalletAioBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_authkey;
    public final PBBytesField bytes_billno;
    public final PBBytesField bytes_name;
    public final PBBytesField bytes_pb_reserve;
    public final PBBytesField bytes_pc_body;
    public final PBSInt32Field sint32_conftype;
    public final PBSInt32Field sint32_envelopeid;
    public final PBSInt32Field sint32_msg_from;
    public final PBSInt32Field sint32_msgtype;
    public final PBSInt32Field sint32_sessiontype;
    public final PBBytesField string_index;
    public final PBUInt32Field uint32_redchannel;
    public final PBRepeatField<Long> uint64_grap_uin;
    public final PBUInt64Field uint64_senduin = PBField.initUInt64(0);
    public im_msg_body$QQWalletAioElem sender = new im_msg_body$QQWalletAioElem();
    public im_msg_body$QQWalletAioElem receiver = new im_msg_body$QQWalletAioElem();
    public final PBSInt32Field sint32_channelid = PBField.initSInt32(0);
    public final PBSInt32Field sint32_templateid = PBField.initSInt32(0);
    public final PBUInt32Field uint32_resend = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_priority = PBField.initUInt32(0);
    public final PBSInt32Field sint32_redtype = PBField.initSInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 56, 64, 74, 82, 88, 96, 104, 114, 120, 128, 138, 146, 152, 160, 170}, new String[]{"uint64_senduin", "sender", "receiver", "sint32_channelid", "sint32_templateid", "uint32_resend", "uint32_msg_priority", "sint32_redtype", "bytes_billno", "bytes_authkey", "sint32_sessiontype", "sint32_msgtype", "sint32_envelopeid", "bytes_name", "sint32_conftype", "sint32_msg_from", "bytes_pc_body", "string_index", "uint32_redchannel", "uint64_grap_uin", "bytes_pb_reserve"}, new Object[]{0L, null, null, 0, 0, 0, 0, 0, byteStringMicro, byteStringMicro, 0, 0, 0, byteStringMicro, 0, 0, byteStringMicro, byteStringMicro, 0, 0L, byteStringMicro}, im_msg_body$QQWalletAioBody.class);
    }

    public im_msg_body$QQWalletAioBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_billno = PBField.initBytes(byteStringMicro);
        this.bytes_authkey = PBField.initBytes(byteStringMicro);
        this.sint32_sessiontype = PBField.initSInt32(0);
        this.sint32_msgtype = PBField.initSInt32(0);
        this.sint32_envelopeid = PBField.initSInt32(0);
        this.bytes_name = PBField.initBytes(byteStringMicro);
        this.sint32_conftype = PBField.initSInt32(0);
        this.sint32_msg_from = PBField.initSInt32(0);
        this.bytes_pc_body = PBField.initBytes(byteStringMicro);
        this.string_index = PBField.initBytes(byteStringMicro);
        this.uint32_redchannel = PBField.initUInt32(0);
        this.uint64_grap_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        this.bytes_pb_reserve = PBField.initBytes(byteStringMicro);
    }
}
