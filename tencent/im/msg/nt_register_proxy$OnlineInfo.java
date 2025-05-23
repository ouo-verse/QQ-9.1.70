package tencent.im.msg;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nt_register_proxy$OnlineInfo extends MessageMicro<nt_register_proxy$OnlineInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField app_name;
    public final PBUInt32Field client_type_new;
    public final PBBytesField device_name;
    public final PBBytesField encrypt_guid;
    public final PBUInt32Field encrypt_guid_version;
    public final PBUInt32Field lock_status;
    public final PBUInt32Field login_sig_appid;
    public final PBBytesField sub_platform;
    public final PBUInt32Field instance_id = PBField.initUInt32(0);
    public final PBUInt32Field client_type = PBField.initUInt32(0);
    public final PBUInt32Field online_stat = PBField.initUInt32(0);
    public final PBUInt32Field platform_id = PBField.initUInt32(0);

    static {
        String[] strArr = {"instance_id", AudienceReportConst.CLIENT_TYPE, "online_stat", StartupReportKey.PLATFORM_ID, "sub_platform", "client_type_new", "device_name", "encrypt_guid", "login_sig_appid", "encrypt_guid_version", "app_name", "lock_status"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 58, 66, 72, 80, 90, 96}, strArr, new Object[]{0, 0, 0, 0, byteStringMicro, 0, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, 0}, nt_register_proxy$OnlineInfo.class);
    }

    public nt_register_proxy$OnlineInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.sub_platform = PBField.initBytes(byteStringMicro);
        this.client_type_new = PBField.initUInt32(0);
        this.device_name = PBField.initBytes(byteStringMicro);
        this.encrypt_guid = PBField.initBytes(byteStringMicro);
        this.login_sig_appid = PBField.initUInt32(0);
        this.encrypt_guid_version = PBField.initUInt32(0);
        this.app_name = PBField.initBytes(byteStringMicro);
        this.lock_status = PBField.initUInt32(0);
    }
}
