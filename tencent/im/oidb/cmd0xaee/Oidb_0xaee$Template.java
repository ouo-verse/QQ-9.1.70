package tencent.im.oidb.cmd0xaee;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xaee$Template extends MessageMicro<Oidb_0xaee$Template> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50, 58, 66, 72, 160}, new String[]{"template_id", "template_name", "group_type", "mob_thumb_url", "mob_prev_url", "web_thumb_url", "web_prev_url", "template_url", "doc_type", "group_code"}, new Object[]{0, "", 0, "", "", "", "", "", 0, 0L}, Oidb_0xaee$Template.class);
    public final PBUInt32Field template_id = PBField.initUInt32(0);
    public final PBStringField template_name = PBField.initString("");
    public final PBUInt32Field group_type = PBField.initUInt32(0);
    public final PBStringField mob_thumb_url = PBField.initString("");
    public final PBStringField mob_prev_url = PBField.initString("");
    public final PBStringField web_thumb_url = PBField.initString("");
    public final PBStringField web_prev_url = PBField.initString("");
    public final PBStringField template_url = PBField.initString("");
    public final PBUInt32Field doc_type = PBField.initUInt32(0);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
}
