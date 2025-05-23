package tencent.im.cs.cmd0x352;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x352$ImgInfo extends MessageMicro<cmd0x352$ImgInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 56}, new String[]{"bytes_file_md5", "uint32_file_type", "uint64_file_size", "uint32_file_width", "uint32_file_height", "uint64_file_flag", "uint32_file_cut_pos"}, new Object[]{ByteStringMicro.EMPTY, 0, 0L, 0, 0, 0L, 0}, cmd0x352$ImgInfo.class);
    public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_file_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0);
    public final PBUInt32Field uint32_file_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_height = PBField.initUInt32(0);
    public final PBUInt64Field uint64_file_flag = PBField.initUInt64(0);
    public final PBUInt32Field uint32_file_cut_pos = PBField.initUInt32(0);
}
