package tencent.im.cs.video.voip;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hd_video_voip2$TelInfo extends MessageMicro<hd_video_voip2$TelInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_mobile;
    public final PBBytesField bytes_nation;
    public final PBBytesField bytes_prefix;
    public final PBUInt32Field uint32_appid;
    public final PBUInt32Field uint32_binded_id_type;
    public final PBUInt32Field uint32_mobile_type;
    public final PBUInt32Field uint32_status;
    public final PBUInt64Field uint64_binded_id;
    public final PBUInt64Field uint64_uin;
    public final PBUInt32Field uint64_uin_type;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 152, 160, 168, 176, 184, 192}, new String[]{"bytes_nation", "bytes_prefix", "bytes_mobile", "uint32_status", "uint32_appid", "uint64_uin", "uint64_uin_type", "uint64_binded_id", "uint32_binded_id_type", "uint32_mobile_type"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0L, 0, 0L, 0, 0}, hd_video_voip2$TelInfo.class);
    }

    public hd_video_voip2$TelInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_nation = PBField.initBytes(byteStringMicro);
        this.bytes_prefix = PBField.initBytes(byteStringMicro);
        this.bytes_mobile = PBField.initBytes(byteStringMicro);
        this.uint32_status = PBField.initUInt32(0);
        this.uint32_appid = PBField.initUInt32(0);
        this.uint64_uin = PBField.initUInt64(0L);
        this.uint64_uin_type = PBField.initUInt32(0);
        this.uint64_binded_id = PBField.initUInt64(0L);
        this.uint32_binded_id_type = PBField.initUInt32(0);
        this.uint32_mobile_type = PBField.initUInt32(0);
    }
}
