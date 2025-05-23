package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QZIntimateSpaceReader$GetSpaceMainPageFeedsReq extends MessageMicro<QZIntimateSpaceReader$GetSpaceMainPageFeedsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 50}, new String[]{"ext", "space_id", "attach_info", "is_draft_space", "space_type", "uids"}, new Object[]{null, "", "", Boolean.FALSE, 0, ""}, QZIntimateSpaceReader$GetSpaceMainPageFeedsReq.class);
    public QZoneBaseCommon$StCommonExt ext = new QZoneBaseCommon$StCommonExt();
    public final PBStringField space_id = PBField.initString("");
    public final PBStringField attach_info = PBField.initString("");
    public final PBBoolField is_draft_space = PBField.initBool(false);
    public final PBEnumField space_type = PBField.initEnum(0);
    public final PBRepeatField<String> uids = PBField.initRepeat(PBStringField.__repeatHelper__);
}
