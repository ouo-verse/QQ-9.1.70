package tencent.im;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes29.dex */
public final class PasswdUrlReport$RspBody extends MessageMicro<PasswdUrlReport$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"result", "upload_rsp_item"}, new Object[]{0, null}, PasswdUrlReport$RspBody.class);
    public final PBInt32Field result = PBField.initInt32(0);
    public PasswdUrlReport$UploadRespItem upload_rsp_item = new PasswdUrlReport$UploadRespItem();
}
