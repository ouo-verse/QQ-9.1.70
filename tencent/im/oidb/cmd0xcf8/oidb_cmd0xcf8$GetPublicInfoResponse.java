package tencent.im.oidb.cmd0xcf8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class oidb_cmd0xcf8$GetPublicInfoResponse extends MessageMicro<oidb_cmd0xcf8$GetPublicInfoResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"ret_info", "seqno", "info"}, new Object[]{null, 0, null}, oidb_cmd0xcf8$GetPublicInfoResponse.class);
    public oidb_cmd0xcf8$RetInfo ret_info = new oidb_cmd0xcf8$RetInfo();
    public final PBUInt32Field seqno = PBField.initUInt32(0);
    public oidb_cmd0xcf8$PublicAccountInfo info = new oidb_cmd0xcf8$PublicAccountInfo();
}
