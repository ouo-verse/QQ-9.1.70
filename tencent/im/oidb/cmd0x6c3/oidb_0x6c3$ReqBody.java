package tencent.im.oidb.cmd0x6c3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6c3$ReqBody extends MessageMicro<oidb_0x6c3$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_user_ip;
    public final PBBytesField bytes_version;
    public oidb_0x6c3$ExtParam msg_ext_param;
    public oidb_0x6c3$GetExtraDataReq msg_extra_data;
    public oidb_0x6c3$GetStockReq msg_get_stock;
    public final PBUInt32Field uint32_activity_detail;
    public final PBUInt32Field uint32_business_id;
    public final PBUInt32Field uint32_client;
    public final PBUInt32Field uint32_instance_id;
    public final PBUInt32Field uint32_portal;
    public final PBUInt32Field uint32_req_from;
    public final PBUInt32Field uint32_use_stock_cache;
    public final PBUInt64Field uint64_group = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 58, 66, 74, 80, 88, 96, 104}, new String[]{"uint64_group", "bytes_user_ip", "bytes_version", "uint32_portal", "uint32_client", "uint32_instance_id", "msg_ext_param", "msg_get_stock", "msg_extra_data", "uint32_business_id", "uint32_req_from", "uint32_activity_detail", "uint32_use_stock_cache"}, new Object[]{0L, byteStringMicro, byteStringMicro, 0, 0, 0, null, null, null, 0, 0, 0, 0}, oidb_0x6c3$ReqBody.class);
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [tencent.im.oidb.cmd0x6c3.oidb_0x6c3$GetExtraDataReq] */
    public oidb_0x6c3$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_user_ip = PBField.initBytes(byteStringMicro);
        this.bytes_version = PBField.initBytes(byteStringMicro);
        this.uint32_portal = PBField.initUInt32(0);
        this.uint32_client = PBField.initUInt32(0);
        this.uint32_instance_id = PBField.initUInt32(0);
        this.msg_ext_param = new oidb_0x6c3$ExtParam();
        this.msg_get_stock = new oidb_0x6c3$GetStockReq();
        this.msg_extra_data = new MessageMicro<oidb_0x6c3$GetExtraDataReq>() { // from class: tencent.im.oidb.cmd0x6c3.oidb_0x6c3$GetExtraDataReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"int32_config_id", "int32_version_seq"}, new Object[]{0, 0}, oidb_0x6c3$GetExtraDataReq.class);
            public final PBInt32Field int32_config_id = PBField.initInt32(0);
            public final PBInt32Field int32_version_seq = PBField.initInt32(0);
        };
        this.uint32_business_id = PBField.initUInt32(0);
        this.uint32_req_from = PBField.initUInt32(0);
        this.uint32_activity_detail = PBField.initUInt32(0);
        this.uint32_use_stock_cache = PBField.initUInt32(0);
    }
}
