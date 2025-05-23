package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QZIntimateCheckIn$MainPageCheckinDetail extends MessageMicro<QZIntimateCheckIn$MainPageCheckinDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50}, new String[]{"days", "done_today", "content", "animation_url", "detail_page_url", "checkin_in_btn"}, new Object[]{0L, Boolean.FALSE, "", "", "", null}, QZIntimateCheckIn$MainPageCheckinDetail.class);
    public final PBInt64Field days = PBField.initInt64(0);
    public final PBBoolField done_today = PBField.initBool(false);
    public final PBStringField content = PBField.initString("");
    public final PBStringField animation_url = PBField.initString("");
    public final PBStringField detail_page_url = PBField.initString("");
    public QZoneBaseMeta$StButton checkin_in_btn = new QZoneBaseMeta$StButton();
}
