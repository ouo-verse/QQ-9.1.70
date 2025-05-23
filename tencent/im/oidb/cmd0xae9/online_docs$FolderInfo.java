package tencent.im.oidb.cmd0xae9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class online_docs$FolderInfo extends MessageMicro<online_docs$FolderInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 48}, new String[]{"folder_id", "title", "create_ts", "modify_ts", "parent_folder_id", "status"}, new Object[]{"", "", 0, 0, "", 0}, online_docs$FolderInfo.class);
    public final PBStringField folder_id = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBUInt32Field create_ts = PBField.initUInt32(0);
    public final PBUInt32Field modify_ts = PBField.initUInt32(0);
    public final PBStringField parent_folder_id = PBField.initString("");
    public final PBUInt32Field status = PBField.initUInt32(0);
}
