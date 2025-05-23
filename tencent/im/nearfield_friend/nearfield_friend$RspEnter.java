package tencent.im.nearfield_friend;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nearfield_friend$RspEnter extends MessageMicro<nearfield_friend$RspEnter> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40}, new String[]{"result", "security_level", "verify_url", "heartbeat_time", VasQQSettingMeImpl.EXPIRE_TIME}, new Object[]{null, 0, ByteStringMicro.EMPTY, 0, 0}, nearfield_friend$RspEnter.class);
    public nearfield_friend$ResultInfo result = new nearfield_friend$ResultInfo();
    public final PBUInt32Field security_level = PBField.initUInt32(0);
    public final PBBytesField verify_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field heartbeat_time = PBField.initUInt32(0);
    public final PBUInt32Field expire_time = PBField.initUInt32(0);
}
