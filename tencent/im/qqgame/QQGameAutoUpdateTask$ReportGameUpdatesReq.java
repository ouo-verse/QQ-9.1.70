package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameAutoUpdateTask$ReportGameUpdatesReq extends MessageMicro<QQGameAutoUpdateTask$ReportGameUpdatesReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{QCircleDaTongConstant.ElementParamValue.OPERATION, "channel_id", "appid", "version_code"}, new Object[]{0, "", "", 0}, QQGameAutoUpdateTask$ReportGameUpdatesReq.class);
    public final PBEnumField operation = PBField.initEnum(0);
    public final PBStringField channel_id = PBField.initString("");
    public final PBStringField appid = PBField.initString("");
    public final PBInt32Field version_code = PBField.initInt32(0);
}
