package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* loaded from: classes29.dex */
public final class QZIntimateProfileReader$GetISpaceListReq extends MessageMicro<QZIntimateProfileReader$GetISpaceListReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public QZoneBaseMeta$StUser user = new QZoneBaseMeta$StUser();
    public QZoneBaseCommon$StCommonExt ext = new QZoneBaseCommon$StCommonExt();
    public final PBBoolField need_space_id_only = PBField.initBool(false);
    public final PBBoolField skip_relation_verification = PBField.initBool(false);

    static {
        String[] strArr = {QCircleAlphaUserReporter.KEY_USER, "ext", "need_space_id_only", "skip_relation_verification"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, strArr, new Object[]{null, null, bool, bool}, QZIntimateProfileReader$GetISpaceListReq.class);
    }
}
