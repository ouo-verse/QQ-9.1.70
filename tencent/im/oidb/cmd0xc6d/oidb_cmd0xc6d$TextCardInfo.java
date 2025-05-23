package tencent.im.oidb.cmd0xc6d;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xc6d$TextCardInfo extends MessageMicro<oidb_cmd0xc6d$TextCardInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBEnumField enum_indexing_type = PBField.initEnum(0);
    public final PBUInt32Field uint32_location = PBField.initUInt32(0);
    public final PBBoolField bool_locate_forwards = PBField.initBool(false);
    public final PBBoolField bool_insert_forwards = PBField.initBool(false);
    public final PBBytesField bytes_card_json = PBField.initBytes(ByteStringMicro.EMPTY);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"enum_indexing_type", "uint32_location", "bool_locate_forwards", "bool_insert_forwards", "bytes_card_json"}, new Object[]{0, 0, bool, bool, ByteStringMicro.EMPTY}, oidb_cmd0xc6d$TextCardInfo.class);
    }
}
