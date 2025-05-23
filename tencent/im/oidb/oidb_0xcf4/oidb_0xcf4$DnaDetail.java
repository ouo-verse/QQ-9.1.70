package tencent.im.oidb.oidb_0xcf4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xcf4$DnaDetail extends MessageMicro<oidb_0xcf4$DnaDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"bytes_desc", "uint32_bold_index", "uint32_bold_len"}, new Object[]{ByteStringMicro.EMPTY, 0, 0}, oidb_0xcf4$DnaDetail.class);
    public final PBBytesField bytes_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_bold_index = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bold_len = PBField.initUInt32(0);
}
