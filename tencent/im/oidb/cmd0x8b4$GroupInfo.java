package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.group.group_label.GroupLabel$Label;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x8b4$GroupInfo extends MessageMicro<cmd0x8b4$GroupInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_rich_intro;
    public final PBBytesField bytes_text_intro;
    public final PBUInt64Field uint64_gc = PBField.initUInt64(0);
    public final PBStringField str_group_name = PBField.initString("");
    public final PBStringField str_face_url = PBField.initString("");
    public final PBUInt32Field uint32_set_display_time = PBField.initUInt32(0);
    public final PBRepeatMessageField<GroupLabel$Label> rpt_group_label = PBField.initRepeatMessage(GroupLabel$Label.class);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50, 58}, new String[]{"uint64_gc", "str_group_name", "str_face_url", "uint32_set_display_time", "rpt_group_label", "bytes_text_intro", "bytes_rich_intro"}, new Object[]{0L, "", "", 0, null, byteStringMicro, byteStringMicro}, cmd0x8b4$GroupInfo.class);
    }

    public cmd0x8b4$GroupInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_text_intro = PBField.initBytes(byteStringMicro);
        this.bytes_rich_intro = PBField.initBytes(byteStringMicro);
    }
}
