package tencent.im.oidb.inner.cmd0xca02;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xca02$Result extends MessageMicro<cmd0xca02$Result> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_can_remove;
    public final PBBoolField bool_red_point;
    public cmd0xca02$AppInfo msg_app_info;
    public final PBBytesField string_hash_val;
    public final PBBytesField string_icon;
    public final PBBytesField string_name;
    public final PBBytesField string_url;
    public final PBUInt32Field uint32_add_timestamp;
    public final PBUInt32Field uint32_identify_visibilty;
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_res = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 56, 64, 74, 80, 88}, new String[]{"uint32_id", "uint32_res", "string_hash_val", "string_icon", "string_name", "string_url", "bool_red_point", "bool_can_remove", "msg_app_info", "uint32_add_timestamp", "uint32_identify_visibilty"}, new Object[]{0, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, bool, bool, null, 0, 31}, cmd0xca02$Result.class);
    }

    public cmd0xca02$Result() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.string_hash_val = PBField.initBytes(byteStringMicro);
        this.string_icon = PBField.initBytes(byteStringMicro);
        this.string_name = PBField.initBytes(byteStringMicro);
        this.string_url = PBField.initBytes(byteStringMicro);
        this.bool_red_point = PBField.initBool(false);
        this.bool_can_remove = PBField.initBool(false);
        this.msg_app_info = new cmd0xca02$AppInfo();
        this.uint32_add_timestamp = PBField.initUInt32(0);
        this.uint32_identify_visibilty = PBField.initUInt32(31);
    }
}
