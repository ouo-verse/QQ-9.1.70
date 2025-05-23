package tencent.im.oidb.cmd0xb83;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xb83$TagInfo extends MessageMicro<oidb_cmd0xb83$TagInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 25, 32}, new String[]{"uint64_tag_id", "bytes_tag_name", "double_tag_score", "uint64_channel"}, new Object[]{0L, ByteStringMicro.EMPTY, Double.valueOf(0.0d), 0L}, oidb_cmd0xb83$TagInfo.class);
    public final PBUInt64Field uint64_tag_id = PBField.initUInt64(0);
    public final PBBytesField bytes_tag_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBDoubleField double_tag_score = PBField.initDouble(0.0d);
    public final PBUInt64Field uint64_channel = PBField.initUInt64(0);
}
