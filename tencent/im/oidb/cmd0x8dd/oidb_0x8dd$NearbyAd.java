package tencent.im.oidb.cmd0x8dd;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8dd$NearbyAd extends MessageMicro<oidb_0x8dd$NearbyAd> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"bytes_ad", "uint32_postion", "uint32_source"}, new Object[]{ByteStringMicro.EMPTY, 0, 0}, oidb_0x8dd$NearbyAd.class);
    public final PBBytesField bytes_ad = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_postion = PBField.initUInt32(0);
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
}
