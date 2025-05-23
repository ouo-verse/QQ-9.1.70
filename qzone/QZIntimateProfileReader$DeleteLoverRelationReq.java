package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QZIntimateProfileReader$DeleteLoverRelationReq extends MessageMicro<QZIntimateProfileReader$DeleteLoverRelationReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"target_uid"}, new Object[]{""}, QZIntimateProfileReader$DeleteLoverRelationReq.class);
    public final PBStringField target_uid = PBField.initString("");
}
