package tencent.im.oidb.cmd0xb31;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xb31$SimilarItem extends MessageMicro<oidb_0xb31$SimilarItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 64}, new String[]{"type", "title", "name", "url", "jump_url", "sub_title", "icon_url", "show_both_head"}, new Object[]{1, "", "", "", "", "", "", 0}, oidb_0xb31$SimilarItem.class);
    public final PBEnumField type = PBField.initEnum(1);
    public final PBStringField title = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField sub_title = PBField.initString("");
    public final PBStringField icon_url = PBField.initString("");
    public final PBUInt32Field show_both_head = PBField.initUInt32(0);
}
