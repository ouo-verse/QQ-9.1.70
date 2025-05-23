package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QZIntimateSpaceReader$GetSpaceRightPageReq extends MessageMicro<QZIntimateSpaceReader$GetSpaceRightPageReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"space_id"}, new Object[]{""}, QZIntimateSpaceReader$GetSpaceRightPageReq.class);
    public final PBStringField space_id = PBField.initString("");
}
