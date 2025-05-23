package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qqconnect$MobileAppInfo extends MessageMicro<qqconnect$MobileAppInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90, 98, 106, 112, 122, 130, 138, 146, 152}, new String[]{"android_app_info", "ios_app_info", "face_info", "universal_link_allow_time", "callback_url", "callback_addr", "callback_url_test", "callback_addr_test", "is_high_quality_game"}, new Object[]{null, null, null, 0L, "", "", "", "", Boolean.FALSE}, qqconnect$MobileAppInfo.class);
    public final PBRepeatMessageField<qqconnect$AndroidAppInfo> android_app_info = PBField.initRepeatMessage(qqconnect$AndroidAppInfo.class);
    public final PBRepeatMessageField<qqconnect$IOSAppInfo> ios_app_info = PBField.initRepeatMessage(qqconnect$IOSAppInfo.class);
    public qqconnect$FaceInfo face_info = new MessageMicro<qqconnect$FaceInfo>() { // from class: tencent.im.oidb.qqconnect$FaceInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"is_enable", DownloadInfo.spKey_Config}, new Object[]{Boolean.FALSE, ""}, qqconnect$FaceInfo.class);
        public final PBBoolField is_enable = PBField.initBool(false);
        public final PBStringField config = PBField.initString("");
    };
    public final PBUInt64Field universal_link_allow_time = PBField.initUInt64(0);
    public final PBStringField callback_url = PBField.initString("");
    public final PBStringField callback_addr = PBField.initString("");
    public final PBStringField callback_url_test = PBField.initString("");
    public final PBStringField callback_addr_test = PBField.initString("");
    public final PBBoolField is_high_quality_game = PBField.initBool(false);
}
