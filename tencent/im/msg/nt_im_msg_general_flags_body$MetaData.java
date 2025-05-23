package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nt_im_msg_general_flags_body$MetaData extends MessageMicro<nt_im_msg_general_flags_body$MetaData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"data_from", "ext_nick"}, new Object[]{"", ""}, nt_im_msg_general_flags_body$MetaData.class);
    public final PBStringField data_from = PBField.initString("");
    public final PBStringField ext_nick = PBField.initString("");
}
