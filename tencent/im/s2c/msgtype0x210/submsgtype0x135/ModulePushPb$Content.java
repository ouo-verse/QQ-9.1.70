package tencent.im.s2c.msgtype0x210.submsgtype0x135;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class ModulePushPb$Content extends MessageMicro<ModulePushPb$Content> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 64, 74, 82}, new String[]{"uint64_from_uin", "str_title", "str_desc", "msg_image", "msg_forward", "bytes_ext_data", "buttons", "style_type", "category", "force_push_info"}, new Object[]{0L, "", "", null, null, ByteStringMicro.EMPTY, null, 0, "", null}, ModulePushPb$Content.class);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
    public final PBStringField str_title = PBField.initString("");
    public final PBStringField str_desc = PBField.initString("");
    public ModulePushPb$Image msg_image = new ModulePushPb$Image();
    public ModulePushPb$Forward msg_forward = new ModulePushPb$Forward();
    public final PBBytesField bytes_ext_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<ModulePushPb$Button> buttons = PBField.initRepeatMessage(ModulePushPb$Button.class);
    public final PBUInt32Field style_type = PBField.initUInt32(0);
    public final PBStringField category = PBField.initString("");
    public ModulePushPb$ForcePushInfo force_push_info = new ModulePushPb$ForcePushInfo();
}
