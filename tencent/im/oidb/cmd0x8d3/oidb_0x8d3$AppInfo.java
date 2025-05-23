package tencent.im.oidb.cmd0x8d3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8d3$AppInfo extends MessageMicro<oidb_0x8d3$AppInfo> {
    public static final int OPT_BYTES_ANDROID_DOWNLOAD_URL_FIELD_NUMBER = 21;
    public static final int OPT_BYTES_ANDROID_OPEN_FIELD_NUMBER = 24;
    public static final int OPT_BYTES_APPNAME_FIELD_NUMBER = 2;
    public static final int OPT_BYTES_APP_ICON_FIELD_NUMBER = 7;
    public static final int OPT_BYTES_APP_INTRO_FIELD_NUMBER = 5;
    public static final int OPT_BYTES_APP_URL_FIELD_NUMBER = 6;
    public static final int OPT_BYTES_IOS_DOWNLOAD_URL_FIELD_NUMBER = 22;
    public static final int OPT_BYTES_IOS_OPEN_FIELD_NUMBER = 23;
    public static final int OPT_BYTES_OPEN_PARAM_FIELD_NUMBER = 12;
    public static final int OPT_BYTES_TAGS_FIELD_NUMBER = 18;
    public static final int OPT_BYTES_VERSION_ANDROID_FIELD_NUMBER = 20;
    public static final int OPT_BYTES_VERSION_IOS_FIELD_NUMBER = 19;
    public static final int OPT_MSG_APP_TIP_FIELD_NUMBER = 17;
    public static final int OPT_UINT32_APP_FROM_FIELD_NUMBER = 4;
    public static final int OPT_UINT32_APP_ICON_UPDATE_TIME_FIELD_NUMBER = 11;
    public static final int OPT_UINT32_APP_INNER_TYPE_FIELD_NUMBER = 14;
    public static final int OPT_UINT32_APP_IS_NEW_FIELD_NUMBER = 26;
    public static final int OPT_UINT32_APP_NEW_TIME_FIELD_NUMBER = 27;
    public static final int OPT_UINT32_APP_SORT_KEY_FIELD_NUMBER = 25;
    public static final int OPT_UINT32_APP_STATUS_FIELD_NUMBER = 13;
    public static final int OPT_UINT32_APP_TYPE_FIELD_NUMBER = 3;
    public static final int OPT_UINT32_APP_UPDATE_TIME_FIELD_NUMBER = 10;
    public static final int OPT_UINT32_APP_WINDOW_HIGH_FIELD_NUMBER = 8;
    public static final int OPT_UINT32_APP_WINDOW_WIDTH_FIELD_NUMBER = 9;
    public static final int OPT_UINT32_INIT_FLAG_FIELD_NUMBER = 15;
    public static final int OPT_UINT32_SETTING_FLAG_FIELD_NUMBER = 16;
    public static final int OPT_UINT64_APPID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField opt_bytes_android_download_url;
    public final PBBytesField opt_bytes_android_open;
    public final PBBytesField opt_bytes_app_icon;
    public final PBBytesField opt_bytes_app_intro;
    public final PBBytesField opt_bytes_app_url;
    public final PBBytesField opt_bytes_appname;
    public final PBBytesField opt_bytes_ios_download_url;
    public final PBBytesField opt_bytes_ios_open;
    public final PBBytesField opt_bytes_open_param;
    public final PBBytesField opt_bytes_tags;
    public final PBBytesField opt_bytes_version_android;
    public final PBBytesField opt_bytes_version_ios;
    public oidb_0x8d3$AppTip opt_msg_app_tip;
    public final PBUInt32Field opt_uint32_app_from;
    public final PBUInt32Field opt_uint32_app_icon_update_time;
    public final PBUInt32Field opt_uint32_app_inner_type;
    public final PBUInt32Field opt_uint32_app_is_new;
    public final PBUInt32Field opt_uint32_app_new_time;
    public final PBUInt32Field opt_uint32_app_sort_key;
    public final PBUInt32Field opt_uint32_app_status;
    public final PBUInt32Field opt_uint32_app_type;
    public final PBUInt32Field opt_uint32_app_update_time;
    public final PBUInt32Field opt_uint32_app_window_high;
    public final PBUInt32Field opt_uint32_app_window_width;
    public final PBUInt32Field opt_uint32_init_flag;
    public final PBUInt32Field opt_uint32_setting_flag;
    public final PBUInt64Field opt_uint64_appid = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 50, 58, 64, 72, 80, 88, 98, 104, 112, 120, 128, 138, 146, 154, 162, 170, 178, 186, 194, 200, 208, 216}, new String[]{"opt_uint64_appid", "opt_bytes_appname", "opt_uint32_app_type", "opt_uint32_app_from", "opt_bytes_app_intro", "opt_bytes_app_url", "opt_bytes_app_icon", "opt_uint32_app_window_high", "opt_uint32_app_window_width", "opt_uint32_app_update_time", "opt_uint32_app_icon_update_time", "opt_bytes_open_param", "opt_uint32_app_status", "opt_uint32_app_inner_type", "opt_uint32_init_flag", "opt_uint32_setting_flag", "opt_msg_app_tip", "opt_bytes_tags", "opt_bytes_version_ios", "opt_bytes_version_android", "opt_bytes_android_download_url", "opt_bytes_ios_download_url", "opt_bytes_ios_open", "opt_bytes_android_open", "opt_uint32_app_sort_key", "opt_uint32_app_is_new", "opt_uint32_app_new_time"}, new Object[]{0L, byteStringMicro, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0, 0, byteStringMicro, 0, 0, 0, 0, null, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0}, oidb_0x8d3$AppInfo.class);
    }

    public oidb_0x8d3$AppInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.opt_bytes_appname = PBField.initBytes(byteStringMicro);
        this.opt_uint32_app_type = PBField.initUInt32(0);
        this.opt_uint32_app_from = PBField.initUInt32(0);
        this.opt_bytes_app_intro = PBField.initBytes(byteStringMicro);
        this.opt_bytes_app_url = PBField.initBytes(byteStringMicro);
        this.opt_bytes_app_icon = PBField.initBytes(byteStringMicro);
        this.opt_uint32_app_window_high = PBField.initUInt32(0);
        this.opt_uint32_app_window_width = PBField.initUInt32(0);
        this.opt_uint32_app_update_time = PBField.initUInt32(0);
        this.opt_uint32_app_icon_update_time = PBField.initUInt32(0);
        this.opt_bytes_open_param = PBField.initBytes(byteStringMicro);
        this.opt_uint32_app_status = PBField.initUInt32(0);
        this.opt_uint32_app_inner_type = PBField.initUInt32(0);
        this.opt_uint32_init_flag = PBField.initUInt32(0);
        this.opt_uint32_setting_flag = PBField.initUInt32(0);
        this.opt_msg_app_tip = new oidb_0x8d3$AppTip();
        this.opt_bytes_tags = PBField.initBytes(byteStringMicro);
        this.opt_bytes_version_ios = PBField.initBytes(byteStringMicro);
        this.opt_bytes_version_android = PBField.initBytes(byteStringMicro);
        this.opt_bytes_android_download_url = PBField.initBytes(byteStringMicro);
        this.opt_bytes_ios_download_url = PBField.initBytes(byteStringMicro);
        this.opt_bytes_ios_open = PBField.initBytes(byteStringMicro);
        this.opt_bytes_android_open = PBField.initBytes(byteStringMicro);
        this.opt_uint32_app_sort_key = PBField.initUInt32(0);
        this.opt_uint32_app_is_new = PBField.initUInt32(0);
        this.opt_uint32_app_new_time = PBField.initUInt32(0);
    }
}
