package tencent.im.cs.longconn.putinfo;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hd_video_putinfo$CmdReportClientInfoReqBody extends MessageMicro<hd_video_putinfo$CmdReportClientInfoReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_app_version;
    public final PBBytesField bytes_client_system_info;
    public final PBBytesField bytes_device_info;
    public final PBBytesField bytes_mobile_rom_info;
    public hd_video_putinfo$MobileHardWareValue msg_device_info;
    public hd_video_putinfo$VideoHardWareInfo msg_video_info;
    public final PBUInt32Field uint32_open_general_info;
    public final PBUInt32Field uint32_sharp_sdk_ver;
    public final PBUInt32Field uint32_mobile_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mobile_os_info = PBField.initUInt32(0);
    public final PBUInt32Field uint32_instid = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 58, 66, 72, 80, 90}, new String[]{"uint32_mobile_type", "uint32_mobile_os_info", "uint32_instid", "bytes_client_system_info", "bytes_device_info", "msg_device_info", "msg_video_info", "bytes_mobile_rom_info", "uint32_sharp_sdk_ver", "uint32_open_general_info", "bytes_app_version"}, new Object[]{0, 0, 0, byteStringMicro, byteStringMicro, null, null, byteStringMicro, 0, 0, byteStringMicro}, hd_video_putinfo$CmdReportClientInfoReqBody.class);
    }

    public hd_video_putinfo$CmdReportClientInfoReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_client_system_info = PBField.initBytes(byteStringMicro);
        this.bytes_device_info = PBField.initBytes(byteStringMicro);
        this.msg_device_info = new hd_video_putinfo$MobileHardWareValue();
        this.msg_video_info = new hd_video_putinfo$VideoHardWareInfo();
        this.bytes_mobile_rom_info = PBField.initBytes(byteStringMicro);
        this.uint32_sharp_sdk_ver = PBField.initUInt32(0);
        this.uint32_open_general_info = PBField.initUInt32(0);
        this.bytes_app_version = PBField.initBytes(byteStringMicro);
    }
}
