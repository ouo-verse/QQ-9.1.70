package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xc26$BusiMediaData extends MessageMicro<oidb_0xc26$BusiMediaData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"media_type", "pic_url", "text"}, new Object[]{0, "", ""}, oidb_0xc26$BusiMediaData.class);
    public final PBEnumField media_type = PBField.initEnum(0);
    public final PBStringField pic_url = PBField.initString("");
    public final PBStringField text = PBField.initString("");
}
