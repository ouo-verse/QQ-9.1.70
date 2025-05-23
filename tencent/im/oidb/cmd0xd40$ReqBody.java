package tencent.im.oidb;

import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xd40$ReqBody extends MessageMicro<cmd0xd40$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{APMidasPayAPI.ENV_DEV, "src", "event", "redtype"}, new Object[]{null, 0, 0, 0}, cmd0xd40$ReqBody.class);
    public cmd0xd40$DeviceInfo dev = new MessageMicro<cmd0xd40$DeviceInfo>() { // from class: tencent.im.oidb.cmd0xd40$DeviceInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_os"}, new Object[]{0}, cmd0xd40$DeviceInfo.class);
        public final PBUInt32Field uint32_os = PBField.initUInt32(0);
    };
    public final PBUInt32Field src = PBField.initUInt32(0);
    public final PBUInt32Field event = PBField.initUInt32(0);
    public final PBUInt32Field redtype = PBField.initUInt32(0);
}
