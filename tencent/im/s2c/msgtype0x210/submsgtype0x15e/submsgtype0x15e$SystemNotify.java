package tencent.im.s2c.msgtype0x210.submsgtype0x15e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x15e$SystemNotify extends MessageMicro<submsgtype0x15e$SystemNotify> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field uint32_service_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_service_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_scene_type = PBField.initUInt32(0);
    public final PBStringField str_push_id = PBField.initString("");
    public final PBUInt32Field uint32_push_type = PBField.initUInt32(0);
    public final PBBoolField bool_is_recall = PBField.initBool(false);
    public final PBBoolField bool_is_pull_back = PBField.initBool(false);
    public final PBBoolField bool_is_handle_offline = PBField.initBool(false);
    public submsgtype0x15e$Content msg_content = new submsgtype0x15e$Content();
    public final PBBytesField bytes_ext_data = PBField.initBytes(ByteStringMicro.EMPTY);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48, 56, 64, 82, 90}, new String[]{"uint32_service_id", "uint32_sub_service_id", "uint32_scene_type", "str_push_id", "uint32_push_type", "bool_is_recall", "bool_is_pull_back", "bool_is_handle_offline", "msg_content", "bytes_ext_data"}, new Object[]{0, 0, 0, "", 0, bool, bool, bool, null, ByteStringMicro.EMPTY}, submsgtype0x15e$SystemNotify.class);
    }
}
