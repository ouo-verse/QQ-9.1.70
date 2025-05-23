package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg$MsgSendReq extends MessageMicro<im_msg$MsgSendReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bu_msg;
    public final PBBytesField bytes_cookie;
    public final PBUInt32Field conn_msg_flag;

    /* renamed from: msg, reason: collision with root package name */
    public im_msg$Msg f435953msg = new im_msg$Msg();
    public final PBUInt32Field msg_tail_id;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42}, new String[]{"msg", "bu_msg", "msg_tail_id", "conn_msg_flag", "bytes_cookie"}, new Object[]{null, byteStringMicro, 0, 0, byteStringMicro}, im_msg$MsgSendReq.class);
    }

    public im_msg$MsgSendReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bu_msg = PBField.initBytes(byteStringMicro);
        this.msg_tail_id = PBField.initUInt32(0);
        this.conn_msg_flag = PBField.initUInt32(0);
        this.bytes_cookie = PBField.initBytes(byteStringMicro);
    }
}
