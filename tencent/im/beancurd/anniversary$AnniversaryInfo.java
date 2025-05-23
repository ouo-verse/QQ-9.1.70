package tencent.im.beancurd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class anniversary$AnniversaryInfo extends MessageMicro<anniversary$AnniversaryInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58, 66}, new String[]{"uint64_type", "uint64_uin", "uint64_frd_uin", "uint64_bind_time", "uint64_n", "uint64_level", "str_bg_url", "str_text_color"}, new Object[]{0L, 0L, 0L, 0L, 0L, 0L, "", ""}, anniversary$AnniversaryInfo.class);
    public final PBUInt64Field uint64_type = PBField.initUInt64(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_frd_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_bind_time = PBField.initUInt64(0);
    public final PBUInt64Field uint64_n = PBField.initUInt64(0);
    public final PBUInt64Field uint64_level = PBField.initUInt64(0);
    public final PBStringField str_bg_url = PBField.initString("");
    public final PBStringField str_text_color = PBField.initString("");
}
