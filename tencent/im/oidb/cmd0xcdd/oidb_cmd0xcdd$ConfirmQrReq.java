package tencent.im.oidb.cmd0xcdd;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xcdd$ConfirmQrReq extends MessageMicro<oidb_cmd0xcdd$ConfirmQrReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"qr_sig", QCircleScheme.AttrQQPublish.BUSINESS_USER_DATA, "biz_type"}, new Object[]{ByteStringMicro.EMPTY, null, 1}, oidb_cmd0xcdd$ConfirmQrReq.class);
    public final PBBytesField qr_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_cmd0xcdd$UserData user_data = new oidb_cmd0xcdd$UserData();
    public final PBEnumField biz_type = PBField.initEnum(1);
}
