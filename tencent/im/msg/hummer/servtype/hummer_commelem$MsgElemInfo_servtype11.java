package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hummer_commelem$MsgElemInfo_servtype11 extends MessageMicro<hummer_commelem$MsgElemInfo_servtype11> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_Doodle_md5;
    public final PBBytesField bytes_Doodle_url;
    public final PBBytesField bytes_resID;
    public final PBBytesField bytes_resMD5;
    public final PBBytesField reserve_Info1;
    public final PBBytesField reserve_Info2;
    public final PBUInt32Field uint32_doodleData_offset;
    public final PBUInt32Field uint32_doodle_gif_id;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 58, 66}, new String[]{"bytes_resID", "bytes_resMD5", "reserve_Info1", "reserve_Info2", "uint32_doodleData_offset", "uint32_doodle_gif_id", "bytes_Doodle_url", "bytes_Doodle_md5"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, byteStringMicro}, hummer_commelem$MsgElemInfo_servtype11.class);
    }

    public hummer_commelem$MsgElemInfo_servtype11() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_resID = PBField.initBytes(byteStringMicro);
        this.bytes_resMD5 = PBField.initBytes(byteStringMicro);
        this.reserve_Info1 = PBField.initBytes(byteStringMicro);
        this.reserve_Info2 = PBField.initBytes(byteStringMicro);
        this.uint32_doodleData_offset = PBField.initUInt32(0);
        this.uint32_doodle_gif_id = PBField.initUInt32(0);
        this.bytes_Doodle_url = PBField.initBytes(byteStringMicro);
        this.bytes_Doodle_md5 = PBField.initBytes(byteStringMicro);
    }
}
