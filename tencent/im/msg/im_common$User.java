package tencent.im.msg;

import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_common$User extends MessageMicro<im_common$User> {
    public static final int APP_ID_FIELD_NUMBER = 2;
    public static final int APP_TYPE_FIELD_NUMBER = 4;
    public static final int CLIENT_IP_FIELD_NUMBER = 5;
    public static final int EQUIP_KEY_FIELD_NUMBER = 10;
    public static final int INSTANCE_ID_FIELD_NUMBER = 3;
    public static final int LANGUAGE_FIELD_NUMBER = 9;
    public static final int PLATFORM_ID_FIELD_NUMBER = 8;
    public static final int STR_PHONE_NUMBER_FIELD_NUMBER = 7;
    public static final int UIN_FIELD_NUMBER = 1;
    public static final int VERSION_FIELD_NUMBER = 6;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 45, 48, 58, 64, 72, 82}, new String[]{"uin", "app_id", "instance_id", "app_type", "client_ip", "version", "str_phone_number", StartupReportKey.PLATFORM_ID, IjkMediaMeta.IJKM_KEY_LANGUAGE, "equip_key"}, new Object[]{0L, 0, 0, 0, 0, 0, "", 0, 0, ByteStringMicro.EMPTY}, im_common$User.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field app_id = PBField.initUInt32(0);
    public final PBUInt32Field instance_id = PBField.initUInt32(0);
    public final PBUInt32Field app_type = PBField.initUInt32(0);
    public final PBFixed32Field client_ip = PBField.initFixed32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
    public final PBStringField str_phone_number = PBField.initString("");
    public final PBUInt32Field platform_id = PBField.initUInt32(0);
    public final PBUInt32Field language = PBField.initUInt32(0);
    public final PBBytesField equip_key = PBField.initBytes(ByteStringMicro.EMPTY);
}
