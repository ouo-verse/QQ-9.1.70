package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class qzoneUnifiedStore$GetPayProfileReq extends MessageMicro<qzoneUnifiedStore$GetPayProfileReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"space_id"}, new Object[]{""}, qzoneUnifiedStore$GetPayProfileReq.class);
    public final PBStringField space_id = PBField.initString("");
}
