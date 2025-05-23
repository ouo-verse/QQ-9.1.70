package tencent.im.oidb.cmd0xbe0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xbe0$StackGallery extends MessageMicro<cmd0xbe0$StackGallery> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 56}, new String[]{"bytes_row_key", "uint32_place", "uint32_is_exposure", "uint32_is_clicked", "uint32_pic_count", "uint32_read_pic_count", "uint64_read_time"}, new Object[]{ByteStringMicro.EMPTY, 0, 0, 0, 0, 0, 0L}, cmd0xbe0$StackGallery.class);
    public final PBBytesField bytes_row_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_place = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_exposure = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_clicked = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_read_pic_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_read_time = PBField.initUInt64(0);
}
