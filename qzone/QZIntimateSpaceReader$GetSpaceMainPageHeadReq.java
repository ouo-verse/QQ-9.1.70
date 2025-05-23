package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QZIntimateSpaceReader$GetSpaceMainPageHeadReq extends MessageMicro<QZIntimateSpaceReader$GetSpaceMainPageHeadReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"space_id", "is_draft_space", "space_type", "uids"}, new Object[]{"", Boolean.FALSE, 0, ""}, QZIntimateSpaceReader$GetSpaceMainPageHeadReq.class);
    public final PBStringField space_id = PBField.initString("");
    public final PBBoolField is_draft_space = PBField.initBool(false);
    public final PBEnumField space_type = PBField.initEnum(0);
    public final PBRepeatField<String> uids = PBField.initRepeat(PBStringField.__repeatHelper__);
}
