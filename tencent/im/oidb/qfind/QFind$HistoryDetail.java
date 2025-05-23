package tencent.im.oidb.qfind;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QFind$HistoryDetail extends MessageMicro<QFind$HistoryDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"date", TencentLocation.RUN_MODE, "walk", "duration"}, new Object[]{0, 0, 0, 0}, QFind$HistoryDetail.class);
    public final PBUInt32Field date = PBField.initUInt32(0);
    public final PBUInt32Field run = PBField.initUInt32(0);
    public final PBUInt32Field walk = PBField.initUInt32(0);
    public final PBUInt32Field duration = PBField.initUInt32(0);
}
