package trpc.zplan;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class CsCommon$SlotInfo extends MessageMicro<CsCommon$SlotInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{MiniAppReportManager2.KEY_SLOT_ID, "item_id", "inst_id", "face_data"}, new Object[]{0, 0, 0L, null}, CsCommon$SlotInfo.class);
    public final PBUInt32Field slot_id = PBField.initUInt32(0);
    public final PBUInt32Field item_id = PBField.initUInt32(0);
    public final PBUInt64Field inst_id = PBField.initUInt64(0);
    public CsCommon$FaceCustomData face_data = new MessageMicro<CsCommon$FaceCustomData>() { // from class: trpc.zplan.CsCommon$FaceCustomData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"color_config_id", "custom_color", "control_points"}, new Object[]{0, 0, null}, CsCommon$FaceCustomData.class);
        public final PBUInt32Field color_config_id = PBField.initUInt32(0);
        public final PBUInt32Field custom_color = PBField.initUInt32(0);
        public final PBRepeatMessageField<CsCommon$FaceControlData> control_points = PBField.initRepeatMessage(CsCommon$FaceControlData.class);
    };
}
