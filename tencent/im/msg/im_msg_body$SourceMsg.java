package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg_body$SourceMsg extends MessageMicro<im_msg_body$SourceMsg> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pb_reserve;
    public final PBBytesField bytes_richMsg;
    public final PBBytesField bytes_src_msg;
    public final PBBytesField bytes_troop_name;
    public final PBUInt64Field uint64_to_uin;
    public final PBRepeatField<Integer> uint32_orig_seqs = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBRepeatMessageField<im_msg_body$Elem> elems = PBField.initRepeatMessage(im_msg_body$Elem.class);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 58, 66, 74, 80, 90}, new String[]{"uint32_orig_seqs", "uint64_sender_uin", "uint32_time", "uint32_flag", "elems", "uint32_type", "bytes_richMsg", "bytes_pb_reserve", "bytes_src_msg", "uint64_to_uin", "bytes_troop_name"}, new Object[]{0, 0L, 0, 0, null, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0L, byteStringMicro}, im_msg_body$SourceMsg.class);
    }

    public im_msg_body$SourceMsg() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_richMsg = PBField.initBytes(byteStringMicro);
        this.bytes_pb_reserve = PBField.initBytes(byteStringMicro);
        this.bytes_src_msg = PBField.initBytes(byteStringMicro);
        this.uint64_to_uin = PBField.initUInt64(0L);
        this.bytes_troop_name = PBField.initBytes(byteStringMicro);
    }
}
