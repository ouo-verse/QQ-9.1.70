package tencent.im.oidb.oidb_0xcf4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xcf4$MutualMarkInfo extends MessageMicro<oidb_0xcf4$MutualMarkInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_grade_resource_info;
    public final PBBytesField bytes_max_ver;
    public final PBBytesField bytes_min_ver;
    public final PBEnumField eMutualMarkType = PBField.initEnum(0);
    public final PBUInt32Field uint32_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_days = PBField.initUInt32(0);
    public final PBEnumField eMutualMarkNewType = PBField.initEnum(1);
    public oidb_0xcf4$SpecialWordInfo msg_special_word_info = new oidb_0xcf4$SpecialWordInfo();
    public final PBUInt64Field uint64_sub_level = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 58, 1602, 1610}, new String[]{"eMutualMarkType", "uint32_level", "uint32_days", "eMutualMarkNewType", "msg_special_word_info", "uint64_sub_level", "bytes_grade_resource_info", "bytes_min_ver", "bytes_max_ver"}, new Object[]{0, 0, 0, 1, null, 0L, byteStringMicro, byteStringMicro, byteStringMicro}, oidb_0xcf4$MutualMarkInfo.class);
    }

    public oidb_0xcf4$MutualMarkInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_grade_resource_info = PBField.initBytes(byteStringMicro);
        this.bytes_min_ver = PBField.initBytes(byteStringMicro);
        this.bytes_max_ver = PBField.initBytes(byteStringMicro);
    }
}
