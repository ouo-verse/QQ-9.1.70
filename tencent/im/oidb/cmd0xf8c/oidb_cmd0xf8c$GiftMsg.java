package tencent.im.oidb.cmd0xf8c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xf8c$GiftMsg extends MessageMicro<oidb_cmd0xf8c$GiftMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"giftuin", "gitfnickname", "materialInfo"}, new Object[]{0L, "", null}, oidb_cmd0xf8c$GiftMsg.class);
    public final PBUInt64Field giftuin = PBField.initUInt64(0);
    public final PBStringField gitfnickname = PBField.initString("");
    public oidb_cmd0xf8c$MaterialInfo materialInfo = new oidb_cmd0xf8c$MaterialInfo();
}
