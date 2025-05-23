package tencent.im.hw;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_mgr$CardInfo extends MessageMicro<group_mgr$CardInfo> {
    public static final int COMMON_FIELD_NUMBER = 1;
    public static final int HWINFO_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"common", "hwinfo"}, new Object[]{null, null}, group_mgr$CardInfo.class);

    /* renamed from: common, reason: collision with root package name */
    public group_mgr$CardCommInfo f435948common = new MessageMicro<group_mgr$CardCommInfo>() { // from class: tencent.im.hw.group_mgr$CardCommInfo
        public static final int CARD_NAME_FIELD_NUMBER = 3;
        public static final int LEVEL_FIELD_NUMBER = 4;
        public static final int NICK_NAME_FIELD_NUMBER = 2;
        public static final int POINT_FIELD_NUMBER = 5;
        public static final int UIN_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40}, new String[]{"uin", IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, "card_name", "level", "point"}, new Object[]{0L, "", "", 0, 0}, group_mgr$CardCommInfo.class);
        public final PBUInt64Field uin = PBField.initUInt64(0);
        public final PBStringField nick_name = PBField.initString("");
        public final PBStringField card_name = PBField.initString("");
        public final PBUInt32Field level = PBField.initUInt32(0);
        public final PBUInt32Field point = PBField.initUInt32(0);
    };
    public group_mgr$CardHomeworkInfo hwinfo = new MessageMicro<group_mgr$CardHomeworkInfo>() { // from class: tencent.im.hw.group_mgr$CardHomeworkInfo
        public static final int IDENTITY_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"identity"}, new Object[]{0}, group_mgr$CardHomeworkInfo.class);
        public final PBUInt32Field identity = PBField.initUInt32(0);
    };
}
