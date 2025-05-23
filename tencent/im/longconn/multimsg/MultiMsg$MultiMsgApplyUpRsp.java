package tencent.im.longconn.multimsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MultiMsg$MultiMsgApplyUpRsp extends MessageMicro<MultiMsg$MultiMsgApplyUpRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg_key;
    public final PBBytesField bytes_msg_resid;
    public final PBBytesField bytes_msg_sig;
    public final PBBytesField bytes_msg_ukey;
    public MultiMsg$ExternMsg msg_extern_info;
    public final PBRepeatField<ByteStringMicro> rpt_bytes_up_ip_v6;
    public final PBRepeatField<Integer> rpt_uint32_up_ip;
    public final PBRepeatField<Integer> rpt_uint32_up_port;
    public final PBRepeatField<Integer> rpt_uint32_up_v6_port;
    public final PBUInt32Field uint32_apply_id;
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt64Field uint64_block_size;
    public final PBUInt64Field uint64_up_offset;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 56, 64, 74, 82, 90, 98, 104}, new String[]{"uint32_result", "bytes_msg_resid", "bytes_msg_ukey", "rpt_uint32_up_ip", "rpt_uint32_up_port", "uint64_block_size", "uint64_up_offset", "uint32_apply_id", "bytes_msg_key", "bytes_msg_sig", "msg_extern_info", "rpt_bytes_up_ip_v6", "rpt_uint32_up_v6_port"}, new Object[]{0, byteStringMicro, byteStringMicro, 0, 0, 0L, 0L, 0, byteStringMicro, byteStringMicro, null, byteStringMicro, 0}, MultiMsg$MultiMsgApplyUpRsp.class);
    }

    public MultiMsg$MultiMsgApplyUpRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_msg_resid = PBField.initBytes(byteStringMicro);
        this.bytes_msg_ukey = PBField.initBytes(byteStringMicro);
        PBUInt32Field pBUInt32Field = PBUInt32Field.__repeatHelper__;
        this.rpt_uint32_up_ip = PBField.initRepeat(pBUInt32Field);
        this.rpt_uint32_up_port = PBField.initRepeat(pBUInt32Field);
        this.uint64_block_size = PBField.initUInt64(0L);
        this.uint64_up_offset = PBField.initUInt64(0L);
        this.uint32_apply_id = PBField.initUInt32(0);
        this.bytes_msg_key = PBField.initBytes(byteStringMicro);
        this.bytes_msg_sig = PBField.initBytes(byteStringMicro);
        this.msg_extern_info = new MultiMsg$ExternMsg();
        this.rpt_bytes_up_ip_v6 = PBField.initRepeat(PBBytesField.__repeatHelper__);
        this.rpt_uint32_up_v6_port = PBField.initRepeat(pBUInt32Field);
    }
}
