package wtlogin.qrlogin.scanresult;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class QrLogin$TipsCtrl extends MessageMicro<QrLogin$TipsCtrl> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"normal_tips_color", "sec_check", "sec_check_tips", "sec_tips_color"}, new Object[]{0, Boolean.FALSE, "", 0}, QrLogin$TipsCtrl.class);
    public final PBEnumField normal_tips_color = PBField.initEnum(0);
    public final PBBoolField sec_check = PBField.initBool(false);
    public final PBStringField sec_check_tips = PBField.initString("");
    public final PBEnumField sec_tips_color = PBField.initEnum(0);
}
