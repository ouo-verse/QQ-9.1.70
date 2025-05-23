package weprotocols;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes30.dex */
public final class WEProtocolsVaslive$InteractivePlayInfo extends MessageMicro<WEProtocolsVaslive$InteractivePlayInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40}, new String[]{"liveIcon", "playIcon", "title", "awardName", "liveIconWidth"}, new Object[]{"", "", "", "", 0}, WEProtocolsVaslive$InteractivePlayInfo.class);
    public final PBStringField liveIcon = PBField.initString("");
    public final PBStringField playIcon = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField awardName = PBField.initString("");
    public final PBUInt32Field liveIconWidth = PBField.initUInt32(0);
}
