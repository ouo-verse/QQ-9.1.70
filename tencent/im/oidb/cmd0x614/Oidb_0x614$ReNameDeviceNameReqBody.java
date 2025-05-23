package tencent.im.oidb.cmd0x614;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x614$ReNameDeviceNameReqBody extends MessageMicro<Oidb_0x614$ReNameDeviceNameReqBody> {
    public static final int BYTES_APPNAME_FIELD_NUMBER = 4;
    public static final int BYTES_DEVICE_DES_FIELD_NUMBER = 5;
    public static final int BYTES_GUID_FIELD_NUMBER = 1;
    public static final int BYTES_RENAME_DEVICE_NAME_FIELD_NUMBER = 6;
    public static final int UINT32_APPID_FIELD_NUMBER = 2;
    public static final int UINT32_SUBAPPID_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_appname;
    public final PBBytesField bytes_device_des;
    public final PBBytesField bytes_guid;
    public final PBBytesField bytes_rename_device_name;
    public final PBUInt32Field uint32_appid;
    public final PBUInt32Field uint32_subappid;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 50}, new String[]{"bytes_guid", "uint32_appid", "uint32_subappid", "bytes_appname", "bytes_device_des", "bytes_rename_device_name"}, new Object[]{byteStringMicro, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro}, Oidb_0x614$ReNameDeviceNameReqBody.class);
    }

    public Oidb_0x614$ReNameDeviceNameReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_guid = PBField.initBytes(byteStringMicro);
        this.uint32_appid = PBField.initUInt32(0);
        this.uint32_subappid = PBField.initUInt32(0);
        this.bytes_appname = PBField.initBytes(byteStringMicro);
        this.bytes_device_des = PBField.initBytes(byteStringMicro);
        this.bytes_rename_device_name = PBField.initBytes(byteStringMicro);
    }
}
