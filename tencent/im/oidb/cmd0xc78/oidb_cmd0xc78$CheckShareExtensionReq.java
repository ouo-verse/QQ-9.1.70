package tencent.im.oidb.cmd0xc78;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xc78$CheckShareExtensionReq extends MessageMicro<oidb_cmd0xc78$CheckShareExtensionReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48, 56, 90, 98, 106, 114, 122}, new String[]{"uin", "src", "ios_boundle_id", "android_package_names", "content_type", "user_flag1", "user_flag2", "texts", "imgs", "videos", "files", "app_msgs"}, new Object[]{0L, "", "", "", 0, 0L, 0L, null, null, null, null, null}, oidb_cmd0xc78$CheckShareExtensionReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField src = PBField.initString("");
    public final PBStringField ios_boundle_id = PBField.initString("");
    public final PBRepeatField<String> android_package_names = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field content_type = PBField.initUInt32(0);
    public final PBUInt64Field user_flag1 = PBField.initUInt64(0);
    public final PBUInt64Field user_flag2 = PBField.initUInt64(0);
    public final PBRepeatMessageField<oidb_cmd0xc78$TextInfo> texts = PBField.initRepeatMessage(oidb_cmd0xc78$TextInfo.class);
    public final PBRepeatMessageField<oidb_cmd0xc78$ImgInfo> imgs = PBField.initRepeatMessage(oidb_cmd0xc78$ImgInfo.class);
    public final PBRepeatMessageField<oidb_cmd0xc78$VideoInfo> videos = PBField.initRepeatMessage(oidb_cmd0xc78$VideoInfo.class);
    public final PBRepeatMessageField<oidb_cmd0xc78$AppFileMsgInfo> files = PBField.initRepeatMessage(oidb_cmd0xc78$AppFileMsgInfo.class);
    public final PBRepeatMessageField<oidb_cmd0xc78$AppMsgInfo> app_msgs = PBField.initRepeatMessage(oidb_cmd0xc78$AppMsgInfo.class);
}
