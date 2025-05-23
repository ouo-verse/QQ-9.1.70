package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.view.FilterEnum;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class subcmd0x519$RspBody extends MessageMicro<subcmd0x519$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, FilterEnum.MIC_PTU_BAIXI}, new String[]{"uint32_sub_cmd", "msg_crm_common_head", "msg_get_navigation_menu_rsp"}, new Object[]{0, null, null}, subcmd0x519$RspBody.class);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public subcmd0x519$CRMMsgHead msg_crm_common_head = new subcmd0x519$CRMMsgHead();
    public subcmd0x519$GetNavigationMenuRspBody msg_get_navigation_menu_rsp = new subcmd0x519$GetNavigationMenuRspBody();
}
