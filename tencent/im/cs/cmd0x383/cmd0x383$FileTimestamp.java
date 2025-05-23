package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x383$FileTimestamp extends MessageMicro<cmd0x383$FileTimestamp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_upload_time", "str_file_path"}, new Object[]{0, ""}, cmd0x383$FileTimestamp.class);
    public final PBUInt32Field uint32_upload_time = PBField.initUInt32(0);
    public final PBStringField str_file_path = PBField.initString("");
}
