package tencent.im.oidb.cmd0xd68;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xd68$RspBody extends MessageMicro<oidb_cmd0xd68$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"int32_ret_code", "str_internal_err_msg", "forward_group_rsp", "forward_offline_rsp", "forward_data_wire_rsp"}, new Object[]{0, "", null, null, null}, oidb_cmd0xd68$RspBody.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_internal_err_msg = PBField.initString("");
    public oidb_cmd0xd68$ForwardGroupRspBody forward_group_rsp = new oidb_cmd0xd68$ForwardGroupRspBody();
    public oidb_cmd0xd68$ForwardOfflineFileRspBody forward_offline_rsp = new oidb_cmd0xd68$ForwardOfflineFileRspBody();
    public oidb_cmd0xd68$ForwardDataWireRspBody forward_data_wire_rsp = new oidb_cmd0xd68$ForwardDataWireRspBody();
}
