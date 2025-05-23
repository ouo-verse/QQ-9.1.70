package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateCheckIn$StCheckinRsp extends MessageMicro<QZIntimateCheckIn$StCheckinRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"days", "checkin_in_btn", QQPermissionConstants.Permission.CALENDAR_GROUP}, new Object[]{0, null, null}, QZIntimateCheckIn$StCheckinRsp.class);
    public final PBUInt32Field days = PBField.initUInt32(0);
    public QZoneBaseMeta$StButton checkin_in_btn = new QZoneBaseMeta$StButton();
    public QZIntimateCheckIn$CheckinCalendar calendar = new MessageMicro<QZIntimateCheckIn$CheckinCalendar>() { // from class: qzone.QZIntimateCheckIn$CheckinCalendar
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 64, 72}, new String[]{"space_name", "calendar_content", "calendar_content_source", "calendar_tips", IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_BACKGROUND_URL, "remind_button", "share_button", "comm_checkin_days", "support_resign"}, new Object[]{"", "", "", "", "", null, null, 0, Boolean.FALSE}, QZIntimateCheckIn$CheckinCalendar.class);
        public final PBStringField space_name = PBField.initString("");
        public final PBStringField calendar_content = PBField.initString("");
        public final PBStringField calendar_content_source = PBField.initString("");
        public final PBStringField calendar_tips = PBField.initString("");
        public final PBStringField background_url = PBField.initString("");
        public QZIntimateCheckIn$CalendarButton remind_button = new MessageMicro<QZIntimateCheckIn$CalendarButton>() { // from class: qzone.QZIntimateCheckIn$CalendarButton
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"title", "after_click_title"}, new Object[]{"", ""}, QZIntimateCheckIn$CalendarButton.class);
            public final PBStringField title = PBField.initString("");
            public final PBStringField after_click_title = PBField.initString("");
        };
        public QZIntimateCheckIn$CalendarButton share_button = new MessageMicro<QZIntimateCheckIn$CalendarButton>() { // from class: qzone.QZIntimateCheckIn$CalendarButton
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"title", "after_click_title"}, new Object[]{"", ""}, QZIntimateCheckIn$CalendarButton.class);
            public final PBStringField title = PBField.initString("");
            public final PBStringField after_click_title = PBField.initString("");
        };
        public final PBUInt32Field comm_checkin_days = PBField.initUInt32(0);
        public final PBBoolField support_resign = PBField.initBool(false);
    };
}
