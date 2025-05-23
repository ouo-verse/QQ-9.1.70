package tencent.im.oidb.cmd0x7f5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x7f5$ReqBody extends MessageMicro<cmd0x7f5$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_req_context;
    public final PBBytesField bytes_route_mac;
    public final PBRepeatMessageField<cmd0x7f5$Wifi> rpt_msg_wifi_mac;
    public final PBUInt32Field uint32_area_count;
    public final PBUInt32Field uint32_filter_id;
    public final PBFixed32Field uint32_ipv4;
    public final PBUInt32Field uint32_sort_type;
    public final PBUInt32Field uint32_strategy;
    public final PBUInt32Field uint32_max_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_max_distance = PBField.initUInt32(0);
    public final PBUInt32Field uint32_loc_type = PBField.initUInt32(0);
    public cmd0x7f5$GPS msg_gps = new MessageMicro<cmd0x7f5$GPS>() { // from class: tencent.im.oidb.cmd0x7f5.cmd0x7f5$GPS
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 66, 72}, new String[]{"uint32_latitude", "uint32_longitude", "uint32_altitude", "uint32_accuracy", "uint32_time", "uint32_flag", "uint32_cityid", "bytes_client_version", "uint32_client"}, new Object[]{0, 0, 0, 0, 0, 0, 0, ByteStringMicro.EMPTY, 0}, cmd0x7f5$GPS.class);
        public final PBUInt32Field uint32_latitude = PBField.initUInt32(0);
        public final PBUInt32Field uint32_longitude = PBField.initUInt32(0);
        public final PBUInt32Field uint32_altitude = PBField.initUInt32(0);
        public final PBUInt32Field uint32_accuracy = PBField.initUInt32(0);
        public final PBUInt32Field uint32_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
        public final PBUInt32Field uint32_cityid = PBField.initUInt32(0);
        public final PBBytesField bytes_client_version = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_client = PBField.initUInt32(0);
    };

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 53, 58, 66, 72, 80, 88, 96}, new String[]{"uint32_max_count", "uint32_max_distance", "uint32_loc_type", "msg_gps", "bytes_route_mac", "uint32_ipv4", "rpt_msg_wifi_mac", "bytes_req_context", "uint32_area_count", "uint32_sort_type", "uint32_filter_id", "uint32_strategy"}, new Object[]{0, 0, 0, null, byteStringMicro, 0, null, byteStringMicro, 0, 0, 0, 0}, cmd0x7f5$ReqBody.class);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [tencent.im.oidb.cmd0x7f5.cmd0x7f5$GPS] */
    public cmd0x7f5$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_route_mac = PBField.initBytes(byteStringMicro);
        this.uint32_ipv4 = PBField.initFixed32(0);
        this.rpt_msg_wifi_mac = PBField.initRepeatMessage(cmd0x7f5$Wifi.class);
        this.bytes_req_context = PBField.initBytes(byteStringMicro);
        this.uint32_area_count = PBField.initUInt32(0);
        this.uint32_sort_type = PBField.initUInt32(0);
        this.uint32_filter_id = PBField.initUInt32(0);
        this.uint32_strategy = PBField.initUInt32(0);
    }
}
