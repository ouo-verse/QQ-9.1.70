package tencent.im.new_year_report;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class PackReport$PkgResp extends MessageMicro<PackReport$PkgResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"retcode", "retmsg"}, new Object[]{0, ""}, PackReport$PkgResp.class);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public final PBStringField retmsg = PBField.initString("");
}
