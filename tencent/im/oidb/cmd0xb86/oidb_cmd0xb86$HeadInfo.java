package tencent.im.oidb.cmd0xb86;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xb86$HeadInfo extends MessageMicro<oidb_cmd0xb86$HeadInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 104}, new String[]{"uint32_face_flag", "str_url", "uint64_timestamp"}, new Object[]{0, "", 0L}, oidb_cmd0xb86$HeadInfo.class);
    public final PBUInt32Field uint32_face_flag = PBField.initUInt32(0);
    public final PBStringField str_url = PBField.initString("");
    public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0);
}
