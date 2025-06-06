package tencent.im.oidb.cmd0x8b8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8b8$ReqBody extends MessageMicro<oidb_0x8b8$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 64}, new String[]{"uint64_group_uin", "uint32_sequence", "uint32_subcmd", "msg_modify_order", "msg_set_default", "msg_del_pic", "uint32_client_ver"}, new Object[]{0L, 0, 0, null, null, null, 0}, oidb_0x8b8$ReqBody.class);
    public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_sequence = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public oidb_0x8b8$ModifyOrderReq msg_modify_order = new oidb_0x8b8$ModifyOrderReq();
    public oidb_0x8b8$SetDefaultReq msg_set_default = new oidb_0x8b8$SetDefaultReq();
    public oidb_0x8b8$DelPicReq msg_del_pic = new oidb_0x8b8$DelPicReq();
    public final PBUInt32Field uint32_client_ver = PBField.initUInt32(0);
}
