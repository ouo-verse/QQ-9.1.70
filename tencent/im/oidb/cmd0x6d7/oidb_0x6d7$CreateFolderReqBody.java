package tencent.im.oidb.cmd0x6d7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6d7$CreateFolderReqBody extends MessageMicro<oidb_0x6d7$CreateFolderReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"uint64_group_code", "uint32_app_id", "str_parent_folder_id", "str_folder_name"}, new Object[]{0L, 0, "", ""}, oidb_0x6d7$CreateFolderReqBody.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBStringField str_parent_folder_id = PBField.initString("");
    public final PBStringField str_folder_name = PBField.initString("");
}
