package tencent.im.oidb.cmd0xcdd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xcdd$GetQrReq extends MessageMicro<oidb_cmd0xcdd$GetQrReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"push", QCircleScheme.AttrQQPublish.BUSINESS_USER_DATA, "biz_type"}, new Object[]{Boolean.FALSE, null, 1}, oidb_cmd0xcdd$GetQrReq.class);
    public final PBBoolField push = PBField.initBool(false);
    public oidb_cmd0xcdd$UserData user_data = new oidb_cmd0xcdd$UserData();
    public final PBEnumField biz_type = PBField.initEnum(1);
}
