package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QZIntimateProfileReader$ResumeISpacesReq extends MessageMicro<QZIntimateProfileReader$ResumeISpacesReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"space_id", "anniversary"}, new Object[]{"", 0L}, QZIntimateProfileReader$ResumeISpacesReq.class);
    public final PBStringField space_id = PBField.initString("");
    public final PBInt64Field anniversary = PBField.initInt64(0);
}
