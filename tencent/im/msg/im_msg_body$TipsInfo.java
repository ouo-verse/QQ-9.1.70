package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg_body$TipsInfo extends MessageMicro<im_msg_body$TipsInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"text"}, new Object[]{""}, im_msg_body$TipsInfo.class);
    public final PBStringField text = PBField.initString("");
}
