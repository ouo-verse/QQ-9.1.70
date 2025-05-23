package tencent.im.oidb.cmd0xb86;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xb86$ExamineDesc extends MessageMicro<oidb_cmd0xb86$ExamineDesc> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_desc", "uint64_timestamp"}, new Object[]{ByteStringMicro.EMPTY, 0L}, oidb_cmd0xb86$ExamineDesc.class);
    public final PBBytesField bytes_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0);
}
