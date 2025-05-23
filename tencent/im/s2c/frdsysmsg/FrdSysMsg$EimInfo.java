package tencent.im.s2c.frdsysmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class FrdSysMsg$EimInfo extends MessageMicro<FrdSysMsg$EimInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"uint64_eim_fuin", "str_eim_id", "str_eim_telno", "uint64_group_id"}, new Object[]{0L, "", "", 0L}, FrdSysMsg$EimInfo.class);
    public final PBUInt64Field uint64_eim_fuin = PBField.initUInt64(0);
    public final PBStringField str_eim_id = PBField.initString("");
    public final PBStringField str_eim_telno = PBField.initString("");
    public final PBUInt64Field uint64_group_id = PBField.initUInt64(0);
}
