package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StSimulateData extends MessageMicro<QQCircleFeedBase$StSimulateData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40}, new String[]{"material_id", QzoneCameraConst.Tag.ARG_PARAM_FILTER_ID, "simulate_name", "simulate_schema", "is_show_button"}, new Object[]{"", "", "", "", 0}, QQCircleFeedBase$StSimulateData.class);
    public final PBStringField material_id = PBField.initString("");
    public final PBStringField filter_id = PBField.initString("");
    public final PBStringField simulate_name = PBField.initString("");
    public final PBStringField simulate_schema = PBField.initString("");
    public final PBUInt32Field is_show_button = PBField.initUInt32(0);
}
