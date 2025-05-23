package tencent.im.cs.longconn.putinfo;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class hd_video_putinfo$PutinfoHead extends MessageMicro<hd_video_putinfo$PutinfoHead> {
    public static final int CMD_CLIENT_REPORT_REQ = 1;
    public static final int CMD_S2C_PUTINFO_REQ = 2;
    public static final int ERR_DECODE_REQUEST = 1;
    public static final int ERR_UNKNOWN = 255;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_appid;
    public final PBBytesField bytes_config_ver;
    public final PBBytesField bytes_error_msg;
    public final PBUInt32Field uint32_error_no;
    public final PBUInt64Field uint64_seq;
    public final PBEnumField enum_body_type = PBField.initEnum(1);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 50, 58}, new String[]{"enum_body_type", "uint64_uin", "bytes_appid", "uint64_seq", "uint32_error_no", "bytes_error_msg", "bytes_config_ver"}, new Object[]{1, 0L, byteStringMicro, 0L, 0, byteStringMicro, byteStringMicro}, hd_video_putinfo$PutinfoHead.class);
    }

    public hd_video_putinfo$PutinfoHead() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_appid = PBField.initBytes(byteStringMicro);
        this.uint64_seq = PBField.initUInt64(0L);
        this.uint32_error_no = PBField.initUInt32(0);
        this.bytes_error_msg = PBField.initBytes(byteStringMicro);
        this.bytes_config_ver = PBField.initBytes(byteStringMicro);
    }
}
