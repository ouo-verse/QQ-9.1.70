package tencent.im.oidb.cmd0x686;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x686$RankTitleConfig extends MessageMicro<Oidb_0x686$RankTitleConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_listtype", "str_first_title", "str_second_title"}, new Object[]{0, "", ""}, Oidb_0x686$RankTitleConfig.class);
    public final PBUInt32Field uint32_listtype = PBField.initUInt32(0);
    public final PBStringField str_first_title = PBField.initString("");
    public final PBStringField str_second_title = PBField.initString("");
}
