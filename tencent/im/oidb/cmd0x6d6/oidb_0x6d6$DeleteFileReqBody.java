package tencent.im.oidb.cmd0x6d6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6d6$DeleteFileReqBody extends MessageMicro<oidb_0x6d6$DeleteFileReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 48, 56}, new String[]{"uint64_group_code", "uint32_app_id", "uint32_bus_id", "str_parent_folder_id", "str_file_id", "uint32_msgdb_seq", "uint32_msg_rand"}, new Object[]{0L, 0, 0, "", "", 0, 0}, oidb_0x6d6$DeleteFileReqBody.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
    public final PBStringField str_parent_folder_id = PBField.initString("");
    public final PBStringField str_file_id = PBField.initString("");
    public final PBUInt32Field uint32_msgdb_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_rand = PBField.initUInt32(0);
}
