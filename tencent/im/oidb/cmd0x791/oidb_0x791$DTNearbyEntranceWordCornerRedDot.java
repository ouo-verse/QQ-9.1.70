package tencent.im.oidb.cmd0x791;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x791$DTNearbyEntranceWordCornerRedDot extends MessageMicro<oidb_0x791$DTNearbyEntranceWordCornerRedDot> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_enable = PBField.initBool(false);
    public final PBBoolField bool_switch_to_word_corner = PBField.initBool(false);
    public final PBBytesField str_hintText = PBField.initBytes(ByteStringMicro.EMPTY);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"bool_enable", "bool_switch_to_word_corner", "str_hintText"}, new Object[]{bool, bool, ByteStringMicro.EMPTY}, oidb_0x791$DTNearbyEntranceWordCornerRedDot.class);
    }
}
