package tencent.im.cs.longconn;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hd_video_comm$SharpSignInfo extends MessageMicro<hd_video_comm$SharpSignInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 98, 106, 112, 122}, new String[]{"uint64_uin", "uint32_business_type", "uint64_business_id", "uint64_roomId", "uint32_timestamp", "uint32_timeout", "uint32_clientseq", "uint32_interface_ip", "uint32_interface_port", "uint32_engine_ip", "uint32_engine_port", "msg_initiator_addr", "rpt_receiver_addr", "uint32_client_ip", "msg_crypt_info"}, new Object[]{0L, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, null, null, 0, null}, hd_video_comm$SharpSignInfo.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_business_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_business_id = PBField.initUInt64(0);
    public final PBUInt64Field uint64_roomId = PBField.initUInt64(0);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_timeout = PBField.initUInt32(0);
    public final PBUInt32Field uint32_clientseq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_interface_ip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_interface_port = PBField.initUInt32(0);
    public final PBUInt32Field uint32_engine_ip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_engine_port = PBField.initUInt32(0);
    public hd_video_comm$AddrInfo msg_initiator_addr = new MessageMicro<hd_video_comm$AddrInfo>() { // from class: tencent.im.cs.longconn.hd_video_comm$AddrInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"uint64_account", "uint32_isp", "uint32_country", "uint32_prov", "uint32_city"}, new Object[]{0L, 0, 0, 0, 0}, hd_video_comm$AddrInfo.class);
        public final PBUInt64Field uint64_account = PBField.initUInt64(0);
        public final PBUInt32Field uint32_isp = PBField.initUInt32(0);
        public final PBUInt32Field uint32_country = PBField.initUInt32(0);
        public final PBUInt32Field uint32_prov = PBField.initUInt32(0);
        public final PBUInt32Field uint32_city = PBField.initUInt32(0);
    };
    public final PBRepeatMessageField<hd_video_comm$AddrInfo> rpt_receiver_addr = PBField.initRepeatMessage(hd_video_comm$AddrInfo.class);
    public final PBUInt32Field uint32_client_ip = PBField.initUInt32(0);
    public hd_video_comm$CryptInfo msg_crypt_info = new hd_video_comm$CryptInfo();
}
