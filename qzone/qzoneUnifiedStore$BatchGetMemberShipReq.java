package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qzoneUnifiedStore$BatchGetMemberShipReq extends MessageMicro<qzoneUnifiedStore$BatchGetMemberShipReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"space_ids"}, new Object[]{""}, qzoneUnifiedStore$BatchGetMemberShipReq.class);
    public final PBRepeatField<String> space_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
}
