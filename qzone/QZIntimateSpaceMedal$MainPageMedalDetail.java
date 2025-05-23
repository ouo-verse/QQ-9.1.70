package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QZIntimateSpaceMedal$MainPageMedalDetail extends MessageMicro<QZIntimateSpaceMedal$MainPageMedalDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 64, 74}, new String[]{"total", "got_num", "medals", "new_medals", "alert_medal", "num_content", "list_content", "has_new_medal", "detail_page_url"}, new Object[]{0, 0, null, null, null, "", "", Boolean.FALSE, ""}, QZIntimateSpaceMedal$MainPageMedalDetail.class);
    public final PBUInt32Field total = PBField.initUInt32(0);
    public final PBUInt32Field got_num = PBField.initUInt32(0);
    public final PBRepeatMessageField<QZIntimateSpaceMedal$MedalInfo> medals = PBField.initRepeatMessage(QZIntimateSpaceMedal$MedalInfo.class);
    public final PBRepeatMessageField<QZIntimateSpaceMedal$MedalInfo> new_medals = PBField.initRepeatMessage(QZIntimateSpaceMedal$MedalInfo.class);
    public QZIntimateSpaceMedal$MedalInfo alert_medal = new QZIntimateSpaceMedal$MedalInfo();
    public final PBStringField num_content = PBField.initString("");
    public final PBStringField list_content = PBField.initString("");
    public final PBBoolField has_new_medal = PBField.initBool(false);
    public final PBStringField detail_page_url = PBField.initString("");
}
