package tencent.im.oidb.cmd0x758;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x758$ReqBody extends MessageMicro<cmd0x758$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 50, 56, 66, 74, 80}, new String[]{"uint64_join_group_code", "be_invited_uin_info", "string_msg", "uint32_main_source_id", "uint32_sub_source_id", "string_verify_token", "uint32_verify_type", "bytes_test", "rpt_share_msg_info", "has_share_msg_info"}, new Object[]{0L, null, "", 0, 0, "", 0, ByteStringMicro.EMPTY, null, Boolean.FALSE}, cmd0x758$ReqBody.class);
    public final PBUInt64Field uint64_join_group_code = PBField.initUInt64(0);
    public final PBRepeatMessageField<cmd0x758$InviteUinInfo> be_invited_uin_info = PBField.initRepeatMessage(cmd0x758$InviteUinInfo.class);
    public final PBStringField string_msg = PBField.initString("");
    public final PBUInt32Field uint32_main_source_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_source_id = PBField.initUInt32(0);
    public final PBStringField string_verify_token = PBField.initString("");
    public final PBUInt32Field uint32_verify_type = PBField.initUInt32(0);
    public final PBBytesField bytes_test = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<cmd0x758$ShareMsgInfo> rpt_share_msg_info = PBField.initRepeatMessage(cmd0x758$ShareMsgInfo.class);
    public final PBBoolField has_share_msg_info = PBField.initBool(false);
}
