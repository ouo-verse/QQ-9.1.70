package tencent.im.oidb.cmd0x6d7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6d7$ReqBody extends MessageMicro<oidb_0x6d7$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"create_folder_req", "delete_folder_req", "rename_folder_req", "move_folder_req"}, new Object[]{null, null, null, null}, oidb_0x6d7$ReqBody.class);
    public oidb_0x6d7$CreateFolderReqBody create_folder_req = new oidb_0x6d7$CreateFolderReqBody();
    public oidb_0x6d7$DeleteFolderReqBody delete_folder_req = new oidb_0x6d7$DeleteFolderReqBody();
    public oidb_0x6d7$RenameFolderReqBody rename_folder_req = new oidb_0x6d7$RenameFolderReqBody();
    public oidb_0x6d7$MoveFolderReqBody move_folder_req = new MessageMicro<oidb_0x6d7$MoveFolderReqBody>() { // from class: tencent.im.oidb.cmd0x6d7.oidb_0x6d7$MoveFolderReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42}, new String[]{"uint64_group_code", "uint32_app_id", "str_folder_id", "str_parent_folder_id", "str_dest_folder_id"}, new Object[]{0L, 0, "", "", ""}, oidb_0x6d7$MoveFolderReqBody.class);
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
        public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
        public final PBStringField str_folder_id = PBField.initString("");
        public final PBStringField str_parent_folder_id = PBField.initString("");
        public final PBStringField str_dest_folder_id = PBField.initString("");
    };
}
