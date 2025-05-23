package tencent.im.oidb.cmd0x769;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x769 {
    public static final int ANDROID = 2;
    public static final int FEATURE = 5;
    public static final int IOS = 1;
    public static final int SYMBIAN = 4;
    public static final int WINDOWSPHONE = 3;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class CPU extends MessageMicro<CPU> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"model", "cores", "frequency"}, new Object[]{"", 0, 0}, CPU.class);
        public final PBStringField model = PBField.initString("");
        public final PBUInt32Field cores = PBField.initUInt32(0);
        public final PBUInt32Field frequency = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class Camera extends MessageMicro<Camera> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"primary", "secondary", "flash"}, new Object[]{0L, 0L, Boolean.FALSE}, Camera.class);
        public final PBUInt64Field primary = PBField.initUInt64(0);
        public final PBUInt64Field secondary = PBField.initUInt64(0);
        public final PBBoolField flash = PBField.initBool(false);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class Config extends MessageMicro<Config> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42}, new String[]{"uint32_type", "uint32_version", "rpt_content_list", "debug_msg", "rpt_msg_content_list"}, new Object[]{0, 0, "", "", null}, Config.class);
        public final PBUInt32Field uint32_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_version = PBField.initUInt32(0);
        public final PBRepeatField<String> rpt_content_list = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBStringField debug_msg = PBField.initString("");
        public final PBRepeatMessageField<Content> rpt_msg_content_list = PBField.initRepeatMessage(Content.class);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ConfigSeq extends MessageMicro<ConfigSeq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"type", "version"}, new Object[]{0, 0}, ConfigSeq.class);
        public final PBUInt32Field type = PBField.initUInt32(0);
        public final PBUInt32Field version = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class Content extends MessageMicro<Content> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 82}, new String[]{"task_id", ITroopAnnouncementHelperApi.CONTROL_INFO_COMPRESS, "content"}, new Object[]{0, 0, ByteStringMicro.EMPTY}, Content.class);
        public final PBUInt32Field task_id = PBField.initUInt32(0);
        public final PBUInt32Field compress = PBField.initUInt32(0);
        public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class DeviceInfo extends MessageMicro<DeviceInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66}, new String[]{"brand", "model", "os", "cpu", "memory", QQPermissionConstants.Permission.STORAGE_GROUP, "screen", "camera"}, new Object[]{"", "", null, null, null, null, null, null}, DeviceInfo.class);
        public final PBStringField brand = PBField.initString("");
        public final PBStringField model = PBField.initString("");

        /* renamed from: os, reason: collision with root package name */
        public OS f435978os = new OS();
        public CPU cpu = new CPU();
        public Memory memory = new Memory();
        public Storage storage = new Storage();
        public Screen screen = new Screen();

        /* renamed from: camera, reason: collision with root package name */
        public Camera f435977camera = new Camera();
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class Memory extends MessageMicro<Memory> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"total", "process"}, new Object[]{0L, 0L}, Memory.class);
        public final PBUInt64Field total = PBField.initUInt64(0);
        public final PBUInt64Field process = PBField.initUInt64(0);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class OS extends MessageMicro<OS> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"type", "version", "sdk", "kernel", "rom"}, new Object[]{1, "", "", "", ""}, OS.class);
        public final PBEnumField type = PBField.initEnum(1);
        public final PBStringField version = PBField.initString("");
        public final PBStringField sdk = PBField.initString("");
        public final PBStringField kernel = PBField.initString("");
        public final PBStringField rom = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class QueryUinPackageUsageReq extends MessageMicro<QueryUinPackageUsageReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"type", "uin_file_size"}, new Object[]{0, 0L}, QueryUinPackageUsageReq.class);
        public final PBUInt32Field type = PBField.initUInt32(0);
        public final PBUInt64Field uin_file_size = PBField.initUInt64(0);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class QueryUinPackageUsageRsp extends MessageMicro<QueryUinPackageUsageRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 82}, new String[]{"status", "left_uin_num", "max_uin_num", "proportion", "uin_package_used_list"}, new Object[]{0, 0L, 0L, 0, null}, QueryUinPackageUsageRsp.class);
        public final PBUInt32Field status = PBField.initUInt32(0);
        public final PBUInt64Field left_uin_num = PBField.initUInt64(0);
        public final PBUInt64Field max_uin_num = PBField.initUInt64(0);
        public final PBUInt32Field proportion = PBField.initUInt32(0);
        public final PBRepeatMessageField<UinPackageUsedInfo> uin_package_used_list = PBField.initRepeatMessage(UinPackageUsedInfo.class);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ReqBody extends MessageMicro<ReqBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 810}, new String[]{"rpt_config_list", "msg_device_info", "str_info", "province", "city", "req_debug_msg", "query_uin_package_usage_req"}, new Object[]{null, null, "", "", "", 0, null}, ReqBody.class);
        public final PBRepeatMessageField<ConfigSeq> rpt_config_list = PBField.initRepeatMessage(ConfigSeq.class);
        public DeviceInfo msg_device_info = new DeviceInfo();
        public final PBStringField str_info = PBField.initString("");
        public final PBStringField province = PBField.initString("");
        public final PBStringField city = PBField.initString("");
        public final PBInt32Field req_debug_msg = PBField.initInt32(0);
        public QueryUinPackageUsageReq query_uin_package_usage_req = new QueryUinPackageUsageReq();
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class RspBody extends MessageMicro<RspBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 810}, new String[]{"uint32_result", "rpt_config_list", "query_uin_package_usage_rsp"}, new Object[]{0, null, null}, RspBody.class);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBRepeatMessageField<Config> rpt_config_list = PBField.initRepeatMessage(Config.class);
        public QueryUinPackageUsageRsp query_uin_package_usage_rsp = new QueryUinPackageUsageRsp();
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class Screen extends MessageMicro<Screen> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40}, new String[]{"model", "width", "height", "dpi", "multi_touch"}, new Object[]{"", 0, 0, 0, Boolean.FALSE}, Screen.class);
        public final PBStringField model = PBField.initString("");
        public final PBUInt32Field width = PBField.initUInt32(0);
        public final PBUInt32Field height = PBField.initUInt32(0);
        public final PBUInt32Field dpi = PBField.initUInt32(0);
        public final PBBoolField multi_touch = PBField.initBool(false);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class Storage extends MessageMicro<Storage> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"builtin", "external"}, new Object[]{0L, 0L}, Storage.class);
        public final PBUInt64Field builtin = PBField.initUInt64(0);
        public final PBUInt64Field external = PBField.initUInt64(0);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class UinPackageUsedInfo extends MessageMicro<UinPackageUsedInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"rule_id", "author", "url", "uin_num"}, new Object[]{0, "", "", 0L}, UinPackageUsedInfo.class);
        public final PBUInt32Field rule_id = PBField.initUInt32(0);
        public final PBStringField author = PBField.initString("");
        public final PBStringField url = PBField.initString("");
        public final PBUInt64Field uin_num = PBField.initUInt64(0);
    }

    Oidb_0x769() {
    }
}
