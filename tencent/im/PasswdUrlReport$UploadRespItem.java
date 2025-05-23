package tencent.im;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class PasswdUrlReport$UploadRespItem extends MessageMicro<PasswdUrlReport$UploadRespItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ret_code", "ret_msg"}, new Object[]{0, ""}, PasswdUrlReport$UploadRespItem.class);
    public final PBInt32Field ret_code = PBField.initInt32(0);
    public final PBStringField ret_msg = PBField.initString("");
}
