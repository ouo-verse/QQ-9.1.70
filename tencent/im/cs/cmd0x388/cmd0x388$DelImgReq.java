package tencent.im.cs.cmd0x388;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x388$DelImgReq extends MessageMicro<cmd0x388$DelImgReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_build_ver;
    public final PBBytesField bytes_file_resid;
    public final PBUInt32Field uint32_pic_height;
    public final PBUInt32Field uint32_pic_width;
    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_req_term = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_platform_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bu_type = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 58, 64, 72}, new String[]{"uint64_src_uin", "uint64_dst_uin", "uint32_req_term", "uint32_req_platform_type", "uint32_bu_type", "bytes_build_ver", "bytes_file_resid", "uint32_pic_width", "uint32_pic_height"}, new Object[]{0L, 0L, 0, 0, 0, byteStringMicro, byteStringMicro, 0, 0}, cmd0x388$DelImgReq.class);
    }

    public cmd0x388$DelImgReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_build_ver = PBField.initBytes(byteStringMicro);
        this.bytes_file_resid = PBField.initBytes(byteStringMicro);
        this.uint32_pic_width = PBField.initUInt32(0);
        this.uint32_pic_height = PBField.initUInt32(0);
    }
}
