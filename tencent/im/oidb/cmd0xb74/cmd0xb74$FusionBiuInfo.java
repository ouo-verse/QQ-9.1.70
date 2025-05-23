package tencent.im.oidb.cmd0xb74;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xb74$FusionBiuInfo extends MessageMicro<cmd0xb74$FusionBiuInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_is_gray = PBField.initBool(false);
    public final PBUInt32Field uint32_biu_count = PBField.initUInt32(0);
    public final PBBoolField bool_is_biu = PBField.initBool(false);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"bool_is_gray", "uint32_biu_count", "bool_is_biu", "uint64_feeds_id"}, new Object[]{bool, 0, bool, 0L}, cmd0xb74$FusionBiuInfo.class);
    }
}
