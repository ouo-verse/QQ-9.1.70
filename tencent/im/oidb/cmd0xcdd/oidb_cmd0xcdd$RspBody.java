package tencent.im.oidb.cmd0xcdd;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xcdd$RspBody extends MessageMicro<oidb_cmd0xcdd$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"get_qr_rsp", "confirm_qr_rsp", "query_state_rsp"}, new Object[]{null, null, null}, oidb_cmd0xcdd$RspBody.class);
    public oidb_cmd0xcdd$GetQrRsp get_qr_rsp = new oidb_cmd0xcdd$GetQrRsp();
    public oidb_cmd0xcdd$ConfirmQrRsp confirm_qr_rsp = new oidb_cmd0xcdd$ConfirmQrRsp();
    public oidb_cmd0xcdd$QueryStateRsp query_state_rsp = new oidb_cmd0xcdd$QueryStateRsp();
}
