package tencent.im.s2c.msgtype0x210.submsgtype0x15d;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x15d$OnlineDevInfo extends MessageMicro<SubMsgType0x15d$OnlineDevInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField app_name;
    public final PBBytesField dev_name;
    public final PBBytesField encrypt_guid;
    public final PBUInt32Field encrypt_guid_version;
    public final PBUInt32Field lock_status;
    public final PBUInt32Field loginsig_appid;
    public final PBUInt32Field platform_id;
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBUInt32Field instance_id = PBField.initUInt32(0);
    public final PBUInt32Field client_type = PBField.initUInt32(0);
    public final PBUInt32Field plat_type = PBField.initUInt32(0);

    static {
        String[] strArr = {"appid", "instance_id", AudienceReportConst.CLIENT_TYPE, "plat_type", "dev_name", "encrypt_guid", "encrypt_guid_version", "loginsig_appid", "app_name", "lock_status", StartupReportKey.PLATFORM_ID};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 56, 64, 74, 80, 88}, strArr, new Object[]{0, 0, 0, 0, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, 0, 0}, SubMsgType0x15d$OnlineDevInfo.class);
    }

    public SubMsgType0x15d$OnlineDevInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.dev_name = PBField.initBytes(byteStringMicro);
        this.encrypt_guid = PBField.initBytes(byteStringMicro);
        this.encrypt_guid_version = PBField.initUInt32(0);
        this.loginsig_appid = PBField.initUInt32(0);
        this.app_name = PBField.initBytes(byteStringMicro);
        this.lock_status = PBField.initUInt32(0);
        this.platform_id = PBField.initUInt32(0);
    }
}
