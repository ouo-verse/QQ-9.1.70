package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QZIntimateProfileReader$GetISpaceListRsp extends MessageMicro<QZIntimateProfileReader$GetISpaceListRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<QZIntimateProfileReader$IntimateSpaceAbs> spaces = PBField.initRepeatMessage(QZIntimateProfileReader$IntimateSpaceAbs.class);
    public final PBBoolField hasMore = PBField.initBool(false);
    public final PBStringField AttchInfo = PBField.initString("");
    public QZoneBaseCommon$StCommonExt ext = new QZoneBaseCommon$StCommonExt();
    public final PBBoolField hasResumableSpace = PBField.initBool(false);
    public QZIntimateProfileReader$CreateMoreSpaceGuide create_more_space_guide = new QZIntimateProfileReader$CreateMoreSpaceGuide();
    public final PBBoolField show_manual = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 50, 56}, new String[]{"spaces", "hasMore", "AttchInfo", "ext", "hasResumableSpace", "create_more_space_guide", "show_manual"}, new Object[]{null, bool, "", null, bool, null, bool}, QZIntimateProfileReader$GetISpaceListRsp.class);
    }
}
