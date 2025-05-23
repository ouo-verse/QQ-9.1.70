package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleSac$GetSacBeatInfoRsp extends MessageMicro<QQCircleSac$GetSacBeatInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"beatStatus", "timeInfo", "displayInfo"}, new Object[]{0, null, null}, QQCircleSac$GetSacBeatInfoRsp.class);
    public final PBEnumField beatStatus = PBField.initEnum(0);
    public QQCircleSac$SacBeatTimeInfo timeInfo = new MessageMicro<QQCircleSac$SacBeatTimeInfo>() { // from class: qqcircle.QQCircleSac$SacBeatTimeInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"startTime", "endTime", "duration"}, new Object[]{0L, 0L, 0L}, QQCircleSac$SacBeatTimeInfo.class);
        public final PBUInt64Field startTime = PBField.initUInt64(0);
        public final PBUInt64Field endTime = PBField.initUInt64(0);
        public final PBUInt64Field duration = PBField.initUInt64(0);
    };
    public QQCircleSac$SacBeatDisplayInfo displayInfo = new MessageMicro<QQCircleSac$SacBeatDisplayInfo>() { // from class: qqcircle.QQCircleSac$SacBeatDisplayInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"text", "url"}, new Object[]{"", ""}, QQCircleSac$SacBeatDisplayInfo.class);
        public final PBStringField text = PBField.initString("");
        public final PBStringField url = PBField.initString("");
    };
}
