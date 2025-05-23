package tencent.im.oidb.cmd0x6d6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6d6$MoveFileRspBody extends MessageMicro<oidb_0x6d6$MoveFileRspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"int32_ret_code", "str_ret_msg", "str_client_wording", "str_parent_folder_id"}, new Object[]{0, "", "", ""}, oidb_0x6d6$MoveFileRspBody.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBStringField str_client_wording = PBField.initString("");
    public final PBStringField str_parent_folder_id = PBField.initString("");
}
