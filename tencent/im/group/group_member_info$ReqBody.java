package tencent.im.group;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_member_info$ReqBody extends MessageMicro<group_member_info$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"uint64_group_code", "uint64_uin", "bool_new_client", "uint32_client_type", "uint32_rich_card_name_ver"}, new Object[]{0L, 0L, Boolean.FALSE, 0, 0}, group_member_info$ReqBody.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBBoolField bool_new_client = PBField.initBool(false);
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_rich_card_name_ver = PBField.initUInt32(0);
}
