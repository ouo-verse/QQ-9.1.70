package wtlogin.qrlogin.scanresult;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class QrLogin$RejectInfo extends MessageMicro<QrLogin$RejectInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"str_tips"}, new Object[]{""}, QrLogin$RejectInfo.class);
    public final PBStringField str_tips = PBField.initString("");
}
