package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QZIntimateProfileReader$CreateMoreSpaceGuide extends MessageMicro<QZIntimateProfileReader$CreateMoreSpaceGuide> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"icontoken", "guide_text", "button"}, new Object[]{"", "", null}, QZIntimateProfileReader$CreateMoreSpaceGuide.class);
    public final PBStringField icontoken = PBField.initString("");
    public final PBStringField guide_text = PBField.initString("");
    public QZoneBaseMeta$StButton button = new QZoneBaseMeta$StButton();
}
