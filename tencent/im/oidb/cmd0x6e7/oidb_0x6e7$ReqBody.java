package tencent.im.oidb.cmd0x6e7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6e7$ReqBody extends MessageMicro<oidb_0x6e7$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42}, new String[]{"uint64_group_code", "str_app_src", "str_version", "uint64_number", "combine_key"}, new Object[]{0L, "", "", 0L, null}, oidb_0x6e7$ReqBody.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBStringField str_app_src = PBField.initString("");
    public final PBStringField str_version = PBField.initString("");
    public final PBUInt64Field uint64_number = PBField.initUInt64(0);
    public oidb_0x6e7$CombineKey combine_key = new MessageMicro<oidb_0x6e7$CombineKey>() { // from class: tencent.im.oidb.cmd0x6e7.oidb_0x6e7$CombineKey
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_ext1", "uint64_ext2", "uint64_ext3"}, new Object[]{0L, 0L, 0L}, oidb_0x6e7$CombineKey.class);
        public final PBUInt64Field uint64_ext1 = PBField.initUInt64(0);
        public final PBUInt64Field uint64_ext2 = PBField.initUInt64(0);
        public final PBUInt64Field uint64_ext3 = PBField.initUInt64(0);
    };
}
