package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class subcmd0x501$SubCmd0x501Rspbody extends MessageMicro<subcmd0x501$SubCmd0x501Rspbody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_httpconn_sig_session;
    public final PBBytesField bytes_session_key;
    public final PBRepeatMessageField<SrvAddrs> rpt_msg_httpconn_addrs;
    public final PBUInt32Field uint32_share_channel;
    public final PBUInt32Field uint32_share_type;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class IpAddr extends MessageMicro<IpAddr> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 21, 24, 32}, new String[]{"uint32_type", "uint32_ip", "uint32_port", "uint32_area"}, new Object[]{0, 0, 0, 0}, IpAddr.class);
        public final PBUInt32Field uint32_type = PBField.initUInt32(0);
        public final PBFixed32Field uint32_ip = PBField.initFixed32(0);
        public final PBUInt32Field uint32_port = PBField.initUInt32(0);
        public final PBUInt32Field uint32_area = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SrvAddrs extends MessageMicro<SrvAddrs> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_service_type", "rpt_msg_addrs"}, new Object[]{0, null}, SrvAddrs.class);
        public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
        public final PBRepeatMessageField<IpAddr> rpt_msg_addrs = PBField.initRepeatMessage(IpAddr.class);
    }

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 96, 104}, new String[]{"bytes_httpconn_sig_session", "bytes_session_key", "rpt_msg_httpconn_addrs", "uint32_share_type", "uint32_share_channel"}, new Object[]{byteStringMicro, byteStringMicro, null, 0, 0}, subcmd0x501$SubCmd0x501Rspbody.class);
    }

    public subcmd0x501$SubCmd0x501Rspbody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_httpconn_sig_session = PBField.initBytes(byteStringMicro);
        this.bytes_session_key = PBField.initBytes(byteStringMicro);
        this.rpt_msg_httpconn_addrs = PBField.initRepeatMessage(SrvAddrs.class);
        this.uint32_share_type = PBField.initUInt32(0);
        this.uint32_share_channel = PBField.initUInt32(0);
    }
}
