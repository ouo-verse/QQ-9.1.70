package qqlogin.qrlogin.extinfo;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QrLoginExtInfo$GenInfo extends MessageMicro<QrLoginExtInfo$GenInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{AudienceReportConst.CLIENT_TYPE, "client_ver", "client_appid"}, new Object[]{0, 0, 0}, QrLoginExtInfo$GenInfo.class);
    public final PBUInt32Field client_type = PBField.initUInt32(0);
    public final PBUInt32Field client_ver = PBField.initUInt32(0);
    public final PBUInt32Field client_appid = PBField.initUInt32(0);
}
