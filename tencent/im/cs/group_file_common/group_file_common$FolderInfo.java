package tencent.im.cs.group_file_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_file_common$FolderInfo extends MessageMicro<group_file_common$FolderInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48, 58, 64, 72, 82, 88}, new String[]{"str_folder_id", "str_parent_folder_id", "str_folder_name", "uint32_create_time", "uint32_modify_time", "uint64_create_uin", "str_creator_name", "uint32_total_file_count", "uint64_modify_uin", "str_modify_name", "uint64_used_space"}, new Object[]{"", "", "", 0, 0, 0L, "", 0, 0L, "", 0L}, group_file_common$FolderInfo.class);
    public final PBStringField str_folder_id = PBField.initString("");
    public final PBStringField str_parent_folder_id = PBField.initString("");
    public final PBStringField str_folder_name = PBField.initString("");
    public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_modify_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_create_uin = PBField.initUInt64(0);
    public final PBStringField str_creator_name = PBField.initString("");
    public final PBUInt32Field uint32_total_file_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_modify_uin = PBField.initUInt64(0);
    public final PBStringField str_modify_name = PBField.initString("");
    public final PBUInt64Field uint64_used_space = PBField.initUInt64(0);
}
