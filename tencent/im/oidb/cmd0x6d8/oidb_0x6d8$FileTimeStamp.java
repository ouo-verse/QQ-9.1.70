package tencent.im.oidb.cmd0x6d8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6d8$FileTimeStamp extends MessageMicro<oidb_0x6d8$FileTimeStamp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_upload_time", "str_file_id"}, new Object[]{0, ""}, oidb_0x6d8$FileTimeStamp.class);
    public final PBUInt32Field uint32_upload_time = PBField.initUInt32(0);
    public final PBStringField str_file_id = PBField.initString("");
}
