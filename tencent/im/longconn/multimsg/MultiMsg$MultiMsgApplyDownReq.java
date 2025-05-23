package tencent.im.longconn.multimsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MultiMsg$MultiMsgApplyDownReq extends MessageMicro<MultiMsg$MultiMsgApplyDownReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg_key;
    public final PBBytesField bytes_msg_resid;
    public final PBBytesField bytes_msg_sig;
    public final PBRepeatMessageField<MultiMsg$Ipv4Info> rpt_ip_v4_info;
    public final PBRepeatMessageField<MultiMsg$Ipv6Info> rpt_ip_v6_info;
    public final PBUInt32Field uint32_apply_id;
    public final PBUInt32Field uint32_msg_type;
    public final PBUInt64Field uint64_src_uin;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 50, 58, 66}, new String[]{"bytes_msg_resid", "uint32_msg_type", "uint64_src_uin", "uint32_apply_id", "bytes_msg_key", "bytes_msg_sig", "rpt_ip_v4_info", "rpt_ip_v6_info"}, new Object[]{byteStringMicro, 0, 0L, 0, byteStringMicro, byteStringMicro, null, null}, MultiMsg$MultiMsgApplyDownReq.class);
    }

    public MultiMsg$MultiMsgApplyDownReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_msg_resid = PBField.initBytes(byteStringMicro);
        this.uint32_msg_type = PBField.initUInt32(0);
        this.uint64_src_uin = PBField.initUInt64(0L);
        this.uint32_apply_id = PBField.initUInt32(0);
        this.bytes_msg_key = PBField.initBytes(byteStringMicro);
        this.bytes_msg_sig = PBField.initBytes(byteStringMicro);
        this.rpt_ip_v4_info = PBField.initRepeatMessage(MultiMsg$Ipv4Info.class);
        this.rpt_ip_v6_info = PBField.initRepeatMessage(MultiMsg$Ipv6Info.class);
    }
}
