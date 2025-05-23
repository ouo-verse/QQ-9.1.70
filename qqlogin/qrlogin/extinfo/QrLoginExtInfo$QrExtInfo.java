package qqlogin.qrlogin.extinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QrLoginExtInfo$QrExtInfo extends MessageMicro<QrLoginExtInfo$QrExtInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"dev_info", "qr_url", "qr_sig", "gen_info"}, new Object[]{null, "", "", null}, QrLoginExtInfo$QrExtInfo.class);
    public QrLoginExtInfo$DevInfo dev_info = new QrLoginExtInfo$DevInfo();
    public final PBStringField qr_url = PBField.initString("");
    public final PBStringField qr_sig = PBField.initString("");
    public QrLoginExtInfo$GenInfo gen_info = new QrLoginExtInfo$GenInfo();
}
