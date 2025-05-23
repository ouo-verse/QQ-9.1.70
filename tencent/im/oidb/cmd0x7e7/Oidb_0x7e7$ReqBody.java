package tencent.im.oidb.cmd0x7e7;

import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x7e7$ReqBody extends MessageMicro<Oidb_0x7e7$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field cmd_id = PBField.initUInt32(0);
    public final PBBytesField cmd_key;
    public final PBUInt64Field corp_uin;
    public final PBUInt32Field env;
    public final PBBytesField json_string;
    public final PBUInt32Field platform;
    public Oidb_0x7e7$PlatformInfo platform_info;
    public final PBUInt64Field timestamp;
    public final PBUInt64Field user_uin;

    static {
        String[] strArr = {"cmd_id", "cmd_key", MosaicConstants$JsProperty.PROP_ENV, "platform", "platform_info", "corp_uin", "user_uin", "timestamp", "json_string"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 48, 56, 64, 74}, strArr, new Object[]{0, byteStringMicro, 0, 0, null, 0L, 0L, 0L, byteStringMicro}, Oidb_0x7e7$ReqBody.class);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [tencent.im.oidb.cmd0x7e7.Oidb_0x7e7$PlatformInfo] */
    public Oidb_0x7e7$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.cmd_key = PBField.initBytes(byteStringMicro);
        this.env = PBField.initUInt32(0);
        this.platform = PBField.initUInt32(0);
        this.platform_info = new MessageMicro<Oidb_0x7e7$PlatformInfo>() { // from class: tencent.im.oidb.cmd0x7e7.Oidb_0x7e7$PlatformInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"os_name", "build_no", "pub_no"}, new Object[]{ByteStringMicro.EMPTY, 0L, 0L}, Oidb_0x7e7$PlatformInfo.class);
            public final PBBytesField os_name = PBField.initBytes(ByteStringMicro.EMPTY);
            public final PBUInt64Field build_no = PBField.initUInt64(0);
            public final PBUInt64Field pub_no = PBField.initUInt64(0);
        };
        this.corp_uin = PBField.initUInt64(0L);
        this.user_uin = PBField.initUInt64(0L);
        this.timestamp = PBField.initUInt64(0L);
        this.json_string = PBField.initBytes(byteStringMicro);
    }
}
