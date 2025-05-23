package tencent.trpc.qqgroup;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GroupFace$UploadRsp extends MessageMicro<GroupFace$UploadRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40}, new String[]{"result", "file_name", CheckForwardServlet.KEY_ERR_CODE, "err_msg", "seq"}, new Object[]{0, "", 0, "", 0}, GroupFace$UploadRsp.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBStringField file_name = PBField.initString("");
    public final PBUInt32Field err_code = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBUInt32Field seq = PBField.initUInt32(0);
}
