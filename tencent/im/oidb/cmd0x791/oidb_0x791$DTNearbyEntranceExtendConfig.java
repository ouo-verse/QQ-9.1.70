package tencent.im.oidb.cmd0x791;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x791$DTNearbyEntranceExtendConfig extends MessageMicro<oidb_0x791$DTNearbyEntranceExtendConfig> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_has_hintWord;
    public final PBBoolField bool_has_waterMarkURLStr = PBField.initBool(false);
    public final PBBytesField str_hintWord;
    public final PBBytesField str_waterMarkURLStr;

    static {
        Boolean bool = Boolean.FALSE;
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"bool_has_waterMarkURLStr", "str_waterMarkURLStr", "bool_has_hintWord", "str_hintWord"}, new Object[]{bool, byteStringMicro, bool, byteStringMicro}, oidb_0x791$DTNearbyEntranceExtendConfig.class);
    }

    public oidb_0x791$DTNearbyEntranceExtendConfig() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.str_waterMarkURLStr = PBField.initBytes(byteStringMicro);
        this.bool_has_hintWord = PBField.initBool(false);
        this.str_hintWord = PBField.initBytes(byteStringMicro);
    }
}
