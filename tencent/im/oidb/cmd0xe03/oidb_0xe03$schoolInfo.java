package tencent.im.oidb.cmd0xe03;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe03$schoolInfo extends MessageMicro<oidb_0xe03$schoolInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"str_school_id", "str_school_name", "uint64_state"}, new Object[]{"", "", 0L}, oidb_0xe03$schoolInfo.class);
    public final PBStringField str_school_id = PBField.initString("");
    public final PBStringField str_school_name = PBField.initString("");
    public final PBUInt64Field uint64_state = PBField.initUInt64(0);
}
