package trpc.yes.common;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class SafeOuterClass$QQGMForbiddenUserReq extends MessageMicro<SafeOuterClass$QQGMForbiddenUserReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56}, new String[]{AudienceReportConst.ROOM_ID, "visitor_uid", "forbidden_type", "forbidden_time", VRReportDefine$ReportParam.SCENE_TYPE, QCircleSchemeAttr.CoverFeed.SOURCE_TYPE, "is_gm"}, new Object[]{0L, 0L, 0, 0, 0, 0, Boolean.FALSE}, SafeOuterClass$QQGMForbiddenUserReq.class);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBUInt64Field visitor_uid = PBField.initUInt64(0);
    public final PBEnumField forbidden_type = PBField.initEnum(0);
    public final PBUInt32Field forbidden_time = PBField.initUInt32(0);
    public final PBEnumField scene_type = PBField.initEnum(0);
    public final PBEnumField source_type = PBField.initEnum(0);
    public final PBBoolField is_gm = PBField.initBool(false);
}
