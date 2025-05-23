package tencent.im.s2c.msgtype0x210.submsgtype0xe4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0xe4$GeoInfo extends MessageMicro<submsgtype0xe4$GeoInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_latitude", "uint64_longitude"}, new Object[]{0L, 0L}, submsgtype0xe4$GeoInfo.class);
    public final PBUInt64Field uint64_latitude = PBField.initUInt64(0);
    public final PBUInt64Field uint64_longitude = PBField.initUInt64(0);
}
