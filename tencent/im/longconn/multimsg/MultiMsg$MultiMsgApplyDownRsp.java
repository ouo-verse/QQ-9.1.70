package tencent.im.longconn.multimsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MultiMsg$MultiMsgApplyDownRsp extends MessageMicro<MultiMsg$MultiMsgApplyDownRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg_key;
    public final PBBytesField bytes_msg_resid;
    public final PBBytesField bytes_thumb_down_para;
    public MultiMsg$ExternMsg msg_extern_info;
    public final PBRepeatField<ByteStringMicro> rpt_bytes_down_ip_v6;
    public final PBRepeatField<Integer> rpt_uint32_down_ip;
    public final PBRepeatField<Integer> rpt_uint32_down_port;
    public final PBRepeatField<Integer> rpt_uint32_down_v6_port;
    public final PBUInt32Field uint32_apply_id;
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 50, 58, 66, 72, 80}, new String[]{"uint32_result", "bytes_thumb_down_para", "bytes_msg_key", "rpt_uint32_down_ip", "rpt_uint32_down_port", "bytes_msg_resid", "msg_extern_info", "rpt_bytes_down_ip_v6", "rpt_uint32_down_v6_port", "uint32_apply_id"}, new Object[]{0, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, null, byteStringMicro, 0, 0}, MultiMsg$MultiMsgApplyDownRsp.class);
    }

    public MultiMsg$MultiMsgApplyDownRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_thumb_down_para = PBField.initBytes(byteStringMicro);
        this.bytes_msg_key = PBField.initBytes(byteStringMicro);
        PBUInt32Field pBUInt32Field = PBUInt32Field.__repeatHelper__;
        this.rpt_uint32_down_ip = PBField.initRepeat(pBUInt32Field);
        this.rpt_uint32_down_port = PBField.initRepeat(pBUInt32Field);
        this.bytes_msg_resid = PBField.initBytes(byteStringMicro);
        this.msg_extern_info = new MultiMsg$ExternMsg();
        this.rpt_bytes_down_ip_v6 = PBField.initRepeat(PBBytesField.__repeatHelper__);
        this.rpt_uint32_down_v6_port = PBField.initRepeat(pBUInt32Field);
        this.uint32_apply_id = PBField.initUInt32(0);
    }
}
