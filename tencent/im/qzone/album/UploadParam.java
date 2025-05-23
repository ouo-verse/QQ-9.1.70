package tencent.im.qzone.album;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class UploadParam extends MessageMicro<UploadParam> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"uint32_full_image", "uint64_batchid", "uint64_image_number", "uint64_image_number_index", "bytes_qzone_albumid"}, new Object[]{0, 0L, 0L, 0L, ByteStringMicro.EMPTY}, UploadParam.class);
    public final PBUInt32Field uint32_full_image = PBField.initUInt32(0);
    public final PBUInt64Field uint64_batchid = PBField.initUInt64(0);
    public final PBUInt64Field uint64_image_number = PBField.initUInt64(0);
    public final PBUInt64Field uint64_image_number_index = PBField.initUInt64(0);
    public final PBBytesField bytes_qzone_albumid = PBField.initBytes(ByteStringMicro.EMPTY);
}
