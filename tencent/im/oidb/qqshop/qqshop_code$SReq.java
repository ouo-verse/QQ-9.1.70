package tencent.im.oidb.qqshop;

import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qqshop_code$SReq extends MessageMicro<qqshop_code$SReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"version", "appid", CommonConstant.ReqAccessTokenParam.REDIRECT_URI}, new Object[]{0, 0, ""}, qqshop_code$SReq.class);
    public final PBUInt32Field version = PBField.initUInt32(0);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBStringField redirect_uri = PBField.initString("");
}
